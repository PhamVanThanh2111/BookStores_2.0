package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		return null;
	}

	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) {
		return null;
	}

	public KhachHang getKhachHangTheoMa(String maKhachHang) {
		return null;
	}

	public boolean xoaKhachHangTheoMa(String maKH) throws SQLException {
		return false;
	}

	public boolean suaKhachHangTheoMa(KhachHang khachHang) throws SQLException {
		return false;
	}

	public boolean themKhachHang(KhachHang khachHang) throws SQLException {
		return false;
	}
}
