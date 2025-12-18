package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            throw new SQLException("Email already exists");
        }
        User user = new User(name, email);
        userDAO.create(user);
        System.out.println("User created with ID: " + user.getId());
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new SQLException("User not found");
        }
        userDAO.delete(id);
        System.out.println("User deleted");
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new SQLException("User not found");
        }
        if (!user.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new SQLException("Email already exists");
        }
        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.update(user);
        System.out.println("User updated");
    }
}
