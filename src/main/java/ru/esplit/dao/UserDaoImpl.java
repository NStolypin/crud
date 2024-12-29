package ru.esplit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import ru.esplit.models.User;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<User> getAll() {
        List<User> users = null;
        try (EntityManager em = entityManagerFactory.createEntityManager();) {
            users = em.createQuery("FROM User", User.class).getResultList();
        }
        return users;
    }

    @Override
    public void create(User user) {
        try (EntityManager em = entityManagerFactory.createEntityManager();) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public User read(long id) {
        User user = null;
        try (EntityManager em = entityManagerFactory.createEntityManager();) {
            user = em.find(User.class, id);
        }
        return user;
    }

    @Override
    public void update(long id, User updatedUser) {
        try (EntityManager em = entityManagerFactory.createEntityManager();) {
            em.getTransaction().begin();
            User userToBeUpdated = em.find(User.class, id);
            if (userToBeUpdated != null) {
                userToBeUpdated.setName(updatedUser.getName());
                userToBeUpdated.setEmail(updatedUser.getEmail());
                userToBeUpdated.setAge(updatedUser.getAge());
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(long id) {
        try (EntityManager em = entityManagerFactory.createEntityManager();) {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        }
    }

}
