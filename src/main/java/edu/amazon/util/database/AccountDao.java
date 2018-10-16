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
import edu.amazon.models.Account;

public class AccountDao implements GenericDao<Account> {
	private static final Logger LOGGER = Logger.getLogger("AccountDao");
	private Connection connection;

	public AccountDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Account create() throws SQLException {
		Account account = new Account();

		try(PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts(id) VALUES (DEFAULT);")) {
			statement.executeUpdate();
		} catch(SQLException e) {
			return null;
		}		

		return account;
	}

	@Override
	public Account getById(Integer key) throws PersistException {
		try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE id=?;")) {
			statement.setInt(1, key);

			ResultSet results =  statement.executeQuery();

			if(results.next()) {
				Account result = new Account(results.getString("login"), 
						results.getString("password"), 
						results.getString("email"))
						.setId(results.getInt("id"));

				return result;
			} else {
				LOGGER.warning("No accounts with id " + key);
				return null;
			}			

		} catch(SQLException e) {
			return null;
		}
	}

	@Override
	public void update(Account object) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET login=?, password=?, email=? WHERE id=?")) {
			statement.setString(1, object.getLogin());
			statement.setString(2, object.getPassword());
			statement.setString(3, object.getEmail());
			statement.setInt(4, object.getId());

			statement.executeUpdate();						

		} catch(SQLException e) {
			LOGGER.warning("Couldn't update product with id " + object.getId());
		}	

	}

	@Override
	public void delete(Account object) throws SQLException {
		try(PreparedStatement statement = connection.prepareStatement("DELETE FROM accounts WHERE id=?;")) {
			statement.setInt(1, object.getId());

			statement.executeUpdate();

		} catch(SQLException e) {
			LOGGER.warning("Error while removing account with id " + object.getId());
		}		

	}

	@Override
	public List<Account> getAll() throws SQLException, PersistException {
		List<Account> accounts = new ArrayList<>();

		try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts;")) {
			ResultSet results =  statement.executeQuery();

			while(results.next()) {
				Account result = new Account(results.getString("login"), 
						results.getString("password"), 
						results.getString("email"))
						.setId(results.getInt("id"));

				accounts.add(result);
			}

			return accounts;
		} catch(SQLException e) {
			return null;
		}
	}
}
