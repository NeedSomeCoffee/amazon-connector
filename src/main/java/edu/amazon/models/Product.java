package edu.amazon.models;

public class Product {
	private String title;
	private String description;
	private String price;

		
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
		
	public String getPrice() {
		return price;
	}
	
	public Product setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Product setPrice(String price) {
		this.price = price;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
}
