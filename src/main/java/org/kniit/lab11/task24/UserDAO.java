package org.kniit.lab11.task24;

import java.sql.*;
import java.util.*;

public interface UserDAO {
    void create(User user) throws SQLException;

    User findById(int id) throws SQLException;

    List<User> findAll() throws SQLException;

    void update(User user) throws SQLException;

    void delete(int id) throws SQLException;

    boolean emailExists(String email) throws SQLException;
}