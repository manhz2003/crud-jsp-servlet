package dao;

import database.Connection;
import model.SachModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachDao {
    public List<SachModel> getAll() {
        List<SachModel> sachList = new ArrayList<>();
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Sach");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachModel sach = new SachModel();
                sach.setId(rs.getInt("id"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setGiaBan(rs.getDouble("giaBan"));
                sach.setNamXuatBan(rs.getInt("namXuatBan"));
                sach.setMoTa(rs.getString("moTa"));
                sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
        return sachList;
    }

    public SachModel get(int id) {
        SachModel sach = null;
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Sach WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sach = new SachModel();
                sach.setId(rs.getInt("id"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setGiaBan(rs.getDouble("giaBan"));
                sach.setNamXuatBan(rs.getInt("namXuatBan"));
                sach.setMoTa(rs.getString("moTa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
        return sach;
    }

    public void add(SachModel sach) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Sach (tenSach, giaBan, namXuatBan, moTa) VALUES (?, ?, ?, ?)");
            ps.setString(1, sach.getTenSach());
            ps.setDouble(2, sach.getGiaBan());
            ps.setInt(3, sach.getNamXuatBan());
            ps.setString(4, sach.getMoTa());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
    }

    public void update(SachModel sach) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Sach SET tenSach = ?, giaBan = ?, namXuatBan = ?, moTa = ? WHERE id = ?");
            ps.setString(1, sach.getTenSach());
            ps.setDouble(2, sach.getGiaBan());
            ps.setInt(3, sach.getNamXuatBan());
            ps.setString(4, sach.getMoTa());
            ps.setInt(5, sach.getId()); // Sử dụng id từ đối tượng SachModel truyền vào
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
    }

    public void delete(SachModel sach) {
        java.sql.Connection connection = Connection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Sach WHERE id = ?");
            ps.setInt(1, sach.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection(connection);
        }
    }
}
