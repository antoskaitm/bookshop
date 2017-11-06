package  ru.atoskaitm.bookstore.model;

import javax.persistence.Entity;

@Entity
public class CartLine {

	private Book book;
	private int quantity = 0;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addOneBook() {
		this.quantity++;
	}

	public double getPrice() {
		return book.getPrice() * quantity;
	}
}