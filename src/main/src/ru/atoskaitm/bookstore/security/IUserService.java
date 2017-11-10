package ru.atoskaitm.bookstore.security;

import ru.atoskaitm.bookstore.model.security.User;

public interface IUserService {

    void save(User user);

    User findByUsername(String username);
}