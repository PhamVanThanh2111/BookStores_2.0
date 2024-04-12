package dao;

import java.util.ArrayList;
import java.util.List;

import dao.iplm.SanPham_Iplm;
import entity.DungCuHocTap;
import entity.Sach;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class SanPham_DAO implements SanPham_Iplm{
	private EntityManager em;

	public SanPham_DAO() {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	// Lấy sách
	public List<Sach> getAllSach() {
		return  em.createNamedQuery("getAllSach").getResultList();
	}
	//Lấy tên theo mã sách
	public SanPham getTenSachTheoTenSanPham(String tenSanPham) {
		return null;
	}
	// Xóa sách 
	public boolean xoaSachTheoMa(String maSach) {
		return false;
	}
	// sửa Mã Sách
	public boolean suaMaSach(SanPham sanPham) {
		return false;
	}
	// khôi phục sản phẩm sách
	public boolean khoiPhucSanPham01(SanPham sanPham) {
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
	public boolean themSanPham(SanPham sanPham) {
		return false;
	}
	
	public boolean suaSanPhamTheoMa(SanPham sanPham) {
		return false;
	}
	// sửa sản phẩm
	public boolean suaSanPhamTheoMaSach(SanPham sanPham) {
	    return false;
	}
	// ban san pham, soLuong là số lượng sản phẩm bán đi
	public boolean banSanPham(String maSanPham, int soLuong) {
		return false;
	}
	
	public boolean suaMaDCHT(SanPham sanPham) {
		return false;
	}
	
	public boolean khoiPhucSanPham(SanPham sanPham) {
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
