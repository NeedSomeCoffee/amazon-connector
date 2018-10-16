package edu.amazon.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.amazon.exceptions.PersistException;
import edu.amazon.interfaces.database.GenericDao;
import edu.amazon.models.Product;

public class ProductDao implements GenericDao<Product> {
	private static final Logger LOGGER = Logger.getLogger("ProductDao");
	private Connection connection;
	
	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Product create() {
		Product product = new Product();
		
		try(PreparedStatement statement = connection.prepareStatement("INSERT INTO products(id) VALUES (DEFAULT)")) {
			statement.executeUpdate();
		} catch(SQLException e) {
			return null;
		}		
		
		return product;
	}

	@Override
	public Product getById(Integer key) throws PersistException {
		try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE id=?;")) {
			statement.setInt(1, key);
			
			ResultSet results =  statement.executeQuery();
			
			if(results.next()) {
				Product result = new Product()
									.setId(key)
									.setTitle(results.getString("title"))
									.setPrice(results.getDouble("price"))
									.setDescription(results.getString("description"));
				
				return result;
			} else {
				LOGGER.warning("No products with id " + key);
				return null;
			}			
			
		} catch(SQLException e) {
			return null;
		}		
	}

	@Override
	public void update(Product object) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement("UPDATE products SET title=?, description=?, price=? WHERE id=?")) {
			statement.setString(1, object.getTitle());
			statement.setString(2, object.getDescription());
			statement.setDouble(3, object.getPrice());
			statement.setInt(4, object.getId());
			
			statement.executeUpdate();
			
						
			
		} catch(SQLException e) {
			LOGGER.warning("Couldn't update product with id " + object.getId());
		}		
		
	}

	@Override
	public void delete(Product object) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id=?;")) {
			statement.setInt(1, object.getId());
			
			statement.executeUpdate();
								
		} catch(SQLException e) {
			LOGGER.warning("Error while removing product with id " + object.getId());
		}		
		
	}

	@Override
	public List<Product> getAll() throws SQLException, PersistException {
		List<Product> products = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM products")) {
			ResultSet results =  statement.executeQuery();
			
			while(results.next()) {
				Product result = new Product()
									.setId(results.getInt("id"))
									.setTitle(results.getString("title"))
									.setPrice(results.getDouble("price"))
									.setDescription(results.getString("description"));
				
				
				products.add(result);
			}
			
			return products;
		} catch(SQLException e) {
			return null;
		}
	}
}
