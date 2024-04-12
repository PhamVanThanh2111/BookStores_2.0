package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;

public class NhanVien_DAO {

	// get all nhan vien
	public ArrayList<NhanVien> getAllNhanVien() {
		return null;
	}

	// get nhan vien theo ten
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) {
		return null;
	}

	// get nhan vien theo ma
	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		return null;
	}

	// get nhan vien theo SDT
	public NhanVien getNhanVienTheoSDT(String sdtNV) {
		return null;
	}

	// get nhan vien theo cccd
	public NhanVien getNhanVienTheoCCCD(String cccdNV) {
		return null;
	}

	// get nhan vien theo tai khoan
	public NhanVien getNhanVienTheoTaiKhoan(String maTK) {
		return null;
	}

	// them nhan vien
	public boolean themNhanVien(NhanVien nhanVien) throws SQLException {
		return false;
	}

	// xoa nhan vien
	public boolean xoaNhanVienTheoMa(String maNV) throws SQLException {
		return false;
	}
	
	// sửa nhân viên 
	public boolean suaNhanVien(NhanVien nhanVien) throws SQLException {
		return false;
	}

}
