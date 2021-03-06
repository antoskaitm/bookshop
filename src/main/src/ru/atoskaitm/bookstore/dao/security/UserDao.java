package ru.atoskaitm.bookstore.dao.security;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.model.security.User;

@Repository
public class UserDao implements IUserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        for (Object user : session.createQuery("from User").list()) {
            if (((User) user).getUsername().equals(username)) {
                return (User) user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }
}
