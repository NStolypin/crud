package ru.esplit.dao;

import java.util.List;

import ru.esplit.models.User;

public interface UserDao {
    List<User> getAll();

    void create(User user);

    User read(long id);

    void update(long id, User updatedUser);

    void delete(long id);
}
