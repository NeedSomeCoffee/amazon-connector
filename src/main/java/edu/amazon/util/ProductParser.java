package edu.amazon.services;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.amazon.models.Feature;
import edu.amazon.models.Product;

public class ProductParser {
	
	private ProductParser () {}
	
	public static Product parseProduct(String source) {
		Document doc = Jsoup.parse(source);
		
		Product product = new Product();
		
		product.setTitle(parseProductTitle(doc))
				.setDescription(parseProductDescription(doc))
				.setPrice(parseProductPrice(doc))
				.setFeatures(parseProductFeatures(doc));
				
		return product;
	}
	
	public static Product parseProductInfo(Document doc) {
		Product product = new Product();
		
		product.setTitle(parseProductTitle(doc))
				.setDescription(parseProductDescription(doc))
				.setPrice(parseProductPrice(doc))
				.setFeatures(parseProductFeatures(doc));
				
		return product;
	}

	private static String parseProductTitle(Document doc) {
		Elements selected = doc.select("#productTitle");
		String title = "";
		
		
		if(!selected.isEmpty()) {
			title = selected.first().text();
		}
		
		return title;
	}
	
	private static String parseProductDescription(Document doc) {
		Elements selected = doc.select("#productDescription p");
		String description = "";
		
		
		if(!selected.isEmpty()) {
			description = selected.first().text();
		}
		
		return description;
	}

	private static String parseProductPrice(Document doc) {
		Elements selected = doc.select("#priceblock_ourprice");
		String price = "";
		
		
		if(!selected.isEmpty()) {
			price = selected.first().text();
		}
		
		return price;
	}

	private static List<Feature> parseProductFeatures(Document doc) {
		Elements selected = doc.select("#feature-bullets ul li:not(.aok-hidden)");
		List<Feature> features = new ArrayList<Feature>();
		
		
		if(!selected.isEmpty()) {
			for(Element singleFeature : selected) {
				features.add(new Feature(singleFeature.text()));
			}
		}
		
		return features;
	}
}
