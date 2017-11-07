package ru.atoskaitm.bookstore.dao.sequrity;

import ru.atoskaitm.bookstore.model.sequrity.User;

public interface IUserDao
{
    User getUser(String username);

    void save(User user);
}