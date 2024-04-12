package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.TaiKhoan;

public class TaiKhoan_DAO {
	// taoTK khi themNV
	public boolean themTaiKhoan(TaiKhoan tk) throws SQLException {
		return false;
	}

	// xoa nhan vien
	public boolean xoaTaiKhoan(String maTaiKhoan) throws SQLException {
		return false;
	}

	public boolean suaTaiKhoan(TaiKhoan taiKhoan) {
		return false;
	}

	// Load ds TK
	public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
		return null;
	}

	public TaiKhoan getTaiKhoanTheoMaTaiKhoan(String maTK) {
		return null;
	}

	public TaiKhoan getMatKhauTheoMaNhanVien(String ma) {
		return null;
	}
}
