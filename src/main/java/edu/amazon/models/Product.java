package edu.amazon.models;

import java.util.List;

public class Product {
	private String title;
	private String description;
	private String price;
	private String url;
	private List<Feature> features;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

	public String getPrice() {
		return price;
	}

	public List<Feature> getFeatures() {
		return features;
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
		builder.append("Product [title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", features=");
		builder.append(features);
		builder.append("]");
		return builder.toString();
	}
}
