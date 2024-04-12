package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	// taoTK khi themNV
	public boolean themTaiKhoan(TaiKhoan tk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into TaiKhoan values (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tk.getTaiKhoan());
			ps.setString(2, tk.getMatKhau());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}

	// xoa nhan vien
	public boolean xoaTaiKhoan(String maTaiKhoan) throws SQLException {
		ConnectDB.getInstance();
		Connection connection = ConnectDB.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from TaiKhoan where taiKhoan = '" + maTaiKhoan + "'");
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		connection.close();
		return false;
	}

	public boolean suaTaiKhoan(TaiKhoan taiKhoan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where taiKhoan = ?");
			stmt.setString(2, taiKhoan.getTaiKhoan());
			stmt.setString(1, taiKhoan.getMatKhau());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return false;
	}

	// Load ds TK
	public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
		ConnectDB.getInstance();
		ArrayList<TaiKhoan> lstTK = new ArrayList<TaiKhoan>();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from TaiKhoan");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
				lstTK.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstTK;
	}

	public TaiKhoan getTaiKhoanTheoMaTaiKhoan(String maTK) {
		ConnectDB.getInstance();
		TaiKhoan tk = new TaiKhoan();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from TaiKhoan where taiKhoan = '" + maTK + "'");
			while (rs.next()) {
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tk;

	}

	public TaiKhoan getMatKhauTheoMaNhanVien(String ma) {
		ConnectDB.getInstance();
		TaiKhoan tk = new TaiKhoan();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where maTK = '" + ma + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.setTaiKhoan(rs.getString(1));
				tk.setMatKhau(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
}
