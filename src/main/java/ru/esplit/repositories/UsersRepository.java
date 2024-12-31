package ru.esplit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.esplit.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

}
