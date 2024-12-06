import java.util.Objects;

public class OrderItem {
	private Long id;
	private Preke preke;
	private Integer quantity;
	private Double price;
	
	public OrderItem(Long id, Preke preke, Integer quantity, Double price) {
		this.id = id;
		this.preke = preke;
		this.quantity = quantity;
		this.price = price;
	}
	
	

	public Long getId() {
		return id;
	}

	public Preke getPreke() {
		return preke;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}
	
	public Double getSum() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, preke, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id) ;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", preke=" + preke + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	public String toOrderLine() {
		return String.format( "%-20s  %.2f  vnt. %d - suma %.2f",  
				getPreke().name(),
				getPrice(),
				getQuantity(),
				getSum());
	}
	
	
	
	
	
	
	
}
