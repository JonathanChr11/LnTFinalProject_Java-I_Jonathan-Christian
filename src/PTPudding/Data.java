package PTPudding;

public class Data {
	
	private String id, name, price, stock;

	public Data(String id, String name, String price, String stock) {
		this.id = id;
		this.name = name;
        this.price = price;
        this.stock = stock;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

}
