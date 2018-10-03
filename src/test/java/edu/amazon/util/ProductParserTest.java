package edu.amazon.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.amazon.models.Product;

public class ProductParserTest {
	public static Product parsed;

	@BeforeClass
	public static void init() {
		Document doc;
		try {
			doc = Jsoup.parse(new File("src/test/resources/fallout.html"), "UTF-8");
			parsed = ProductParser.parseProduct(doc);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	@Test
	public void givenHtmlDocument_WhenParsed_ShouldReturnValidTitleTest() {			
		assertEquals("Funko Pop! Games: Fallout - Assaultron", parsed.getTitle());
	}

	@Test
	public void givenHtmlDocument_WhenParsed_ShouldReturnValidPriceTest() {		
		assertEquals("$17.95", parsed.getPrice());
	}
		
	@Test
	public void givenHtmlDocument_WhenParsed_ShouldReturnValidDescriptionTest() {
		String expected = "From Fallout, assaultron, as a stylized pop vinyl from Funko! figure stands 3 3/4 inches and comes in a window display box. Check out the other Fallout figures from Funko! collect them all!";
		
		assertEquals(expected, parsed.getDescription());
	}
	
	@Test
	public void givenHtmlDocument_WhenParsed_ShouldReturnValidFeatureCountTest() {		
		assertEquals(4, parsed.getFeatures().size());
	}
	
	@Test
	public void givenHtmlDocument_WhenParsed_ShouldReturnValidSecondFeatureTest() {		
		String expectedFeature = "Figure stands 3 3/4 inches and comes in a window display box. Check out the other Fallout figures from Funko! collect them all!";
		assertEquals(expectedFeature, parsed.getFeatures().get(1).getFeature());
	}
}
