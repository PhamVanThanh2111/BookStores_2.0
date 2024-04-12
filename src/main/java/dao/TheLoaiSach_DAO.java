package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.TheLoaiSach;

public class TheLoaiSach_DAO {
	// get all loai sách //lấy
	public ArrayList<TheLoaiSach> getAllTheLoaiSach() {
		return null;
	}

	// get TheLoaiSach theo ma
	public TheLoaiSach getTheLoaiSachTheoMa(String maTheLoaiSach) {
		return null;
	}

	// get TheLoaiSach theo tên
	public TheLoaiSach getTheLoaiSachTheoTen(String tenTheLoaiSach) {
		return null;
	}

	// Thêm thể loại sách
	public boolean themTheLoaiSach(TheLoaiSach theLoaiSach) throws SQLException {
		return false;
	}

	// xoa thể loại sách
	public boolean xoaTheLoaiSachTheoMa(String maTheLoaiSach) throws SQLException {
		return false;
	}

	// kiểm tra xóa (nếu thể loại sách đã tồn tại sách thì không được xóa)
	public boolean isTheLoaiSachDaTonTai(String maTheLoaiSach) throws SQLException {
		return false;
	}

	// sửa thể loại sách theo mã
	public boolean suaTheLoaiSachTheoMa(TheLoaiSach theLoaiSach) throws SQLException {
		return false;
	}
}
