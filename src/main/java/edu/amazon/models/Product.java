package edu.amazon.models;

import java.util.List;

public class Product {
	private Integer id;
	private String title;
	private String description;
	private Double price;
	private String url;
	private List<Feature> features;

	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public Double getPrice() {
		return price;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public Product setId(Integer id) {
		this.id = id;
		return this;
	}
	
	
	public Product setTitle(String title) {
		this.title = title;
		return this;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	public Product setPrice(Double price) {
		this.price = price;
		return this;
	}

	public Product setUrl(String url) {
		this.url = url;
		return this;
	}

	public Product setFeatures(List<Feature> features) {
		this.features = features;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", url=");
		builder.append(url);
		builder.append(", features=");
		builder.append(features);
		builder.append("]");
		return builder.toString();
	}
}
