package  ru.atoskaitm.bookstore.dao;

import  ru.atoskaitm.bookstore.model.Book;

import java.util.List;

public interface IBookDao {
	void addBook(Book book);

	void updateBook(Book book);

	void removeBook(int id);

	Book getBookById(int id);

	List<Book> listBooks(Integer pageNumber,Integer size);

	Integer getPageCount(Integer size);
}
