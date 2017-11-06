package ru.atoskaitm.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.model.Order;

@Repository
public class OrderDao implements IOrderDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addOrder(Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(order);
	}
}
