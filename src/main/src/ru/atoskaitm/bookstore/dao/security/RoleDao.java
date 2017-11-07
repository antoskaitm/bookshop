package ru.atoskaitm.bookstore.dao.security;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.model.security.Role;

@Repository
public class RoleDao implements IRoleDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Role getRole(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Role) session.load(Role.class, new Long(id));
	}
}
