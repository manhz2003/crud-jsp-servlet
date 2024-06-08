package database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/testConnectionJava";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    static {
        try {
            // Tải driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không thể tải driver MySQL", e);
        }
    }

    public static java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Kết nối thất bại !", e);
        }
    }

    public static void closeConnection(java.sql.Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Đóng kết nối thất bại !", e);
            }
        }
    }
}