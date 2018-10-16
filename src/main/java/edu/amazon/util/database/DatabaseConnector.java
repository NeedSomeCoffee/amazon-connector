package edu.amazon.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.amazon.interfaces.Logging;
import edu.amazon.interfaces.database.ConnectionPool;

public class DatabaseConnector implements Logging, ConnectionPool {
	private static final String DB_URL = "jdbc:postgresql://localhost:5430/amazondb?user=java_app&password=amazondb";
	private static final String SQL_DRIVER = "org.postgresql.Driver";
	private List<Connection> connectionPool;
	private List<Connection> usedConnections;
    private static int INITIAL_POOL_SIZE = 3;	

	private DatabaseConnector() {
		try {
			Class.forName(SQL_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.severe("Could not load JDBC driver class");
		}
		
		connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
		usedConnections = new ArrayList<>();
		
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			connectionPool.add(createConnection(DB_URL));
		}
		
	}
	
	@Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        
        usedConnections.add(connection);
        
        return connection;
    }
     
    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
	
	private Connection createConnection(String url) {
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {			
			logger.severe("Could not establish database connection. Reason: " + e.getMessage());
			return null;
		}
	}
	
	public int getTotalSize() {
		return connectionPool.size() + usedConnections.size();
	}
	
	public int getFreeSize() {
		return connectionPool.size();
	}	
}
