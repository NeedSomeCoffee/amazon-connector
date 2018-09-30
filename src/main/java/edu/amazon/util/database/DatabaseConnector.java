package edu.amazon.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import edu.amazon.interfaces.Logging;

public class DatabaseConnector implements Logging {
	private static String SQL_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5430/amazondb?user=java_app&password=amazondb";
	
	static {
		try {
			Class.forName(SQL_DRIVER);

		} catch (ClassNotFoundException cnfe) {
			logger.severe(cnfe.getMessage());
		}
	}
	
	//TODO REwrite to connection pool!!!!
	
	public static Optional<Connection> getConnection() {
		try {
			return Optional.of(DriverManager.getConnection(DB_URL));
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			return Optional.ofNullable(null);
		}
	}	
}
