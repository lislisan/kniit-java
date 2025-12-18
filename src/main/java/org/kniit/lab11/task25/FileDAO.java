package org.kniit.lab11.task25;

import java.io.*;
import java.sql.*;
import java.util.*;

public class FileDAO {
    private static final long MAX_SIZE = 10 * 1024 * 1024;

    public void saveFile(File file) throws SQLException, IOException {
        if (file.length() > MAX_SIZE) {
            throw new IOException("Файл слишком большой: " + file.length() / 1024 / 1024 + " MB");
        }

        String sql = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                pstmt.setBytes(2, fileBytes);
            }

            pstmt.executeUpdate();
            System.out.println("✅ Файл сохранен: " + file.getName());
        }
    }

    public List<FileInfo> listFiles() throws SQLException {
        List<FileInfo> files = new ArrayList<>();
        String sql = "SELECT id, file_name FROM files ORDER BY id DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                files.add(new FileInfo(rs.getInt("id"), rs.getString("file_name")));
            }
        }
        return files;
    }

    public byte[] getFileById(int id) throws SQLException {
        String sql = "SELECT file_binary FROM files WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getBytes("file_binary");
            }
            return null;
        }
    }
}
