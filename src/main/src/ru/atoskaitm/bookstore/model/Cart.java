package  ru.atoskaitm.bookstore.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartLine> cartLines = new HashMap<>();

	public Collection<CartLine> getCartLines() {
		return cartLines.values();
	}

	public void booksLines(Map<Integer, CartLine> booksLines) {
		this.cartLines = booksLines;
	}


	public void addOneBook(Book book) {
		if (!cartLines.containsKey(book.getId())) {
			CartLine line = new CartLine();
			line.setBook(book);
			cartLines.put(book.getId(), new CartLine());
		}
		cartLines.get(book.getId()).addOneBook();
	}

	public void removeLine(int id) {
		if (cartLines.containsKey(id)) {
			cartLines.remove(id);
		}
	}

	public Double getTotalPrice() {
		Double totalPrice = 0.0;
		for (CartLine cartLine : cartLines.values()) {
			totalPrice += cartLine.getPrice();
		}
		return totalPrice;
	}

	public Integer getTotalQuantity() {
		Integer count = 0;
		for (CartLine cartLine : cartLines.values()) {
			count += cartLine.getQuantity();
		}
		return count;
	}

	public void clear() {
		cartLines.clear();
	}
}

