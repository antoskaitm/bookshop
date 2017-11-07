package ru.atoskaitm.bookstore.dao.sequrity;

import ru.atoskaitm.bookstore.model.sequrity.Role;

public interface IRoleDao {
    Role getRole(Long id);
}
