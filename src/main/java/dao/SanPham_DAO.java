package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.impl.SanPham_Iplm;
import entity.DungCuHocTap;
import entity.Sach;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SanPham_DAO extends UnicastRemoteObject implements SanPham_Iplm{
	private EntityManager em;

	public SanPham_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	// Lấy sách
	public List<Sach> getAllSach() {
		return  em.createNamedQuery("getAllSach").getResultList();
	}
	//Lấy tên theo mã sách
	public List<Sach> getTenSachTheoTenSanPham(String tenSanPham) {
		return em.createNamedQuery("getTenSachTheoTenSanPham").setParameter("tenSanPham",tenSanPham).getResultList();
	}
	// Xóa sách 
	public boolean xoaSachTheoMa(String maSach) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Sach sach = em.find(Sach.class, maSach);
			em.remove(sach);
			et.commit();
			return true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return false;

	}
	// sửa Mã Sách
	public boolean suaMaSach(SanPham sanPham) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(sanPham);
			et.commit();
			return true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return false;
	}
	// khôi phục sản phẩm sách
	public boolean khoiPhucSanPham01(SanPham sanPham) {
		return false;
	}
	// Lấy Dụng Cụ Học Tập
	public List<DungCuHocTap> getAllDungCuHocTap() {
		return em.createNamedQuery("LayDanhSachDungCuHocTap").getResultList();
	}
	
	public List<DungCuHocTap> getSanPhamTheoTenSanPham(String tenSanPham) {
		return em.createNamedQuery("getTenSachTheoTenDCHT").setParameter("tenSanPham", tenSanPham).getResultList();
	}
	
	public DungCuHocTap getSanPhamTheoMaSanPham(String maSanPham) {
		return em.find(DungCuHocTap.class, maSanPham);
	}
	
//	Them DCHT
	public boolean themSanPham(SanPham sanPham) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(sanPham);
			et.commit();
			return true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean suaSanPhamTheoMa(SanPham sanPham) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(sanPham);
			et.commit();
			return true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return false;
	}
	// sửa sản phẩm
	public boolean suaDungCuHocTap(SanPham sanPham) {
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
