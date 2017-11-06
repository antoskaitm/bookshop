package ru.atoskaitm.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "order_lines")
public class OrderLine {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Column(name = "quantity")
	private Integer quantity;

	public int getQuantity() {
		return quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setFrom(CartLine cartLine) {
		book = cartLine.getBook();
		quantity = cartLine.getQuantity();
	}
}
