package ru.atoskaitm.bookstore.dao.security;

import ru.atoskaitm.bookstore.model.security.Role;

public interface IRoleDao {
    Role getRole(Long id);
}
