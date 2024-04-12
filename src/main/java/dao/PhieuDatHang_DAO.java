package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.PhieuDatHang;

public class PhieuDatHang_DAO {
	// get all hoa don
	public ArrayList<PhieuDatHang> getAllPhieuDatHang() {
		return null;
	}

	// get hoa don theo ma
	public PhieuDatHang getPhieuDatHangTheoMa(String maPhieuDatHang) {
		return null;
	}

	// them hoa don
	public boolean lapPhieuDatHang(PhieuDatHang phieuDatHang) throws SQLException {
		return false;
	}

	// xoa phieu dat hang
	public boolean xoaPhieuDatHangTheoMa(String maPhieuDatHang) throws SQLException {
		return false;
	}
}
