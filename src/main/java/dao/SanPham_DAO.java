package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.DungCuHocTap;
import entity.Sach;
import entity.SanPham;

public class SanPham_DAO {
	// Lấy sách
	public ArrayList<SanPham> getAllSach() {
		return null;
	}
	//Lấy tên theo mã sách
	public SanPham getTenSachTheoTenSanPham(String tenSanPham) {
		return null;
	}
	// Xóa sách 
	public boolean xoaSachTheoMa(String maSach) throws SQLException {
		return false;
	}
	// sửa Mã Sách
	public boolean suaMaSach(SanPham sanPham) throws SQLException {
		return false;
	}
	// khôi phục sản phẩm sách
	public boolean khoiPhucSanPham01(SanPham sanPham) throws SQLException {
		return false;
	}
	// Lấy Dụng Cụ Học Tập
	public ArrayList<SanPham> getAllDungCuHocTap() {
		return null;
	}
	public SanPham getSanPhamTheoTenSanPham(String tenSanPham) {
		return null;
	}
	
	public SanPham getSanPhamTheoMaSanPham(String maSanPham) {
		return null;
	}
	
//	Them DCHT
	public boolean themSanPham(SanPham sanPham) throws SQLException {
		return false;
	}
	
	public boolean suaSanPhamTheoMa(SanPham sanPham) throws SQLException {
		return false;
	}
	// sửa sản phẩm
	public boolean suaSanPhamTheoMaSach(SanPham sanPham) {
	    return false;
	}
	// ban san pham, soLuong là số lượng sản phẩm bán đi
	public boolean banSanPham(String maSanPham, int soLuong) throws SQLException {
		return false;
	}
	
	public boolean suaMaDCHT(SanPham sanPham) throws SQLException {
		return false;
	}
	
	public boolean khoiPhucSanPham(SanPham sanPham) throws SQLException {
		return false;
	}
	public ArrayList<DungCuHocTap> getAllDCHTXoa() {
		return null;
	}
	
	public ArrayList<Sach> getAllSachXoa() {
		return null;
	}
	
	// lấy danh sách các sản phẩm gần hết hàng (soLuongTon <= 10)
	public ArrayList<SanPham> getSanPhamGanHetHang() {
		return null;
	}
}
