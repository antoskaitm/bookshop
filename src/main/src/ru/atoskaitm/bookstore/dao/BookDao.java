package ru.atoskaitm.bookstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.atoskaitm.bookstore.model.Book;

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
		getSession().persist(book);
	}

	@Transactional
	public void updateBook(Book book) {
		getSession().update(book);
	}

	public void removeBook(int id) {
		Session session = getSession();
		Book book = (Book) session.load(Book.class, new Integer(id));
		if (book != null) {
			session.delete(book);
		}
	}

	@Transactional
	public Book getBookById(int id) {
		Book book = (Book) getSession().load(Book.class, new Integer(id));
		book.getId();
		return book;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Book> listBooks(Integer pageNumber, Integer size) {
		return getSession().createQuery("from Book").setFirstResult(pageNumber * size).setMaxResults(size).list();
	}

	@Transactional
	public Integer getPageCount(Integer size) {
		Number  booksCount = (Number)getSession().createCriteria(Book.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		return (int) Math.ceil(booksCount.doubleValue()/ size);
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
