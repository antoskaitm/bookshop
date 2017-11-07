package ru.atoskaitm.bookstore.dao.security;

import ru.atoskaitm.bookstore.model.security.User;

public interface IUserDao
{
    User getUser(String username);

    void save(User user);
}