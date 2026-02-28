package org.kniit.lab11.task24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ Драйвер найден!");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "lolGODdamn2188"
            );
            System.out.println("✅ Подключение успешно!");

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC драйвер НЕ добавлен в проект!");
        } catch (SQLException e) {
            System.out.println("❌ SQL ошибка: " + e.getMessage());
        }
    }
}
