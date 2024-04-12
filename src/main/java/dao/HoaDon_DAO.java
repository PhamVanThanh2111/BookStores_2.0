package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import entity.HoaDon;

public class HoaDon_DAO {
	// get all hoa don
	public ArrayList<HoaDon> getAllHoaDon() {
		return null;
	}

	// get hoa don theo ma
	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {
		return null;
	}

	// them hoa don
	public boolean lapHoaDon(HoaDon hoaDon) throws SQLException {
		return false;
	}

	// get danh sach hoa don cua nhan vien theo ngay
	public ArrayList<HoaDon> getListHoaDonTrongNgayTheoMaNhanVien(String maNhanVien) {
		return null;
	}

	// get danh sach hoa don theo ngay
	public ArrayList<HoaDon> getListHoaDonTheoNgay(LocalDate date) { // i là số ngày cách ngày hiện tại. VD: i = 1 (ngay
		return null;
	}
	
	// thống kê top khách hàng mua nhiều nhất
	public ResultSet getDanhSachKhachHangMuaNhieuNhat() {
		return null;
	}
	
	// thống kê danh sách các sản phẩm bán chạy nhất
	public ResultSet getDanhSachSanPhamBanChay() {
		return null;
	}
	
	// thống kê doanh thu và số lượng hóa đơn của các nhân viên có doanh thu cao 
	public ResultSet getDanhSachNhanVienTheoDoanhThu() {
		return null;
	}
}
