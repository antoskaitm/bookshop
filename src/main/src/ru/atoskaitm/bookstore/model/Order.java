package  ru.atoskaitm.bookstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "giftWrap")
	private Boolean giftWrap;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderLine> orderLines;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getGiftWrap() {
		return giftWrap;
	}

	public void setGiftWrap(Boolean giftWrap) {
		this.giftWrap = giftWrap;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setFrom(Cart cart) {
		orderLines = new HashSet<OrderLine>();
		for (CartLine cartLine : cart.getCartLines()) {
			OrderLine orderLine = new OrderLine();
			orderLine.setFrom(cartLine);
			orderLine.setOrder(this);
			orderLines.add(orderLine);
		}
	}
}
