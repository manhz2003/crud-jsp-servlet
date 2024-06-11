package dao;

import model.UserModel;
import database.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void register(UserModel user) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User (hoVaTen, tenDangNhap, MatKhau) VALUES (?, ?, ?)");
            ps.setString(1, user.getHoVaTen());
            ps.setString(2, user.getTenDangNhap());
            ps.setString(3, user.getMatKhau());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
    }

    public UserModel login(String tenDangNhap, String MatKhau) {
        UserModel user = null;
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM User WHERE tenDangNhap = ? AND MatKhau = ?");
            ps.setString(1, tenDangNhap);
            ps.setString(2, MatKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setHoVaTen(rs.getString("hoVaTen"));
                user.setTenDangNhap(rs.getString("tenDangNhap"));
                user.setMatKhau(rs.getString("MatKhau"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
        return user;
    }

    public boolean isUsernameExist(String tenDangNhap) {
        String sql = "SELECT COUNT(*) FROM User WHERE tenDangNhap = ?";
        try (java.sql.Connection conn = Connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDangNhap);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}