package edu.amazon.interfaces.database;

import java.sql.SQLException;
import java.util.List;

import edu.amazon.exceptions.PersistException;

public interface GenericDao<T> {
    
    public T create() throws SQLException;
        
    public T getById(Integer key) throws PersistException;

    public void update(T object) throws SQLException;

    public void delete(T object) throws SQLException;

    public List<T> getAll() throws SQLException, PersistException;
}