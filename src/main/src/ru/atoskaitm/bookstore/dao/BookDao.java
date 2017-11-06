package ru.atoskaitm.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import  ru.atoskaitm.bookstore.model.Book;

import java.util.List;

@Repository
@Transactional
public class BookDao implements IBookDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
	}

	@Transactional
	public void updateBook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);

	}

	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		if (book != null) {
			session.delete(book);
		}
	}

	@Transactional
	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		book.getId();
		return book;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		return bookList;
	}
}
