package ru.esplit.service;

import java.util.List;
import java.util.Optional;

import ru.esplit.models.User;

public interface UserService {
    List<User> findAll();

    void save(User user);

    Optional<User> findOne(long id);

    void update(long id, User updatedUser);

    void delete(long id);
}
