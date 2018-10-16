package edu.amazon.util.database;

import java.sql.Connection;


public class DaoFactory {

	public static AccountDao getAccountDao(Connection connection) {	
		return new AccountDao(connection);
	}
	
	public static ProductDao getProductDao(Connection connection) {	
		return new ProductDao(connection);
	}
}
