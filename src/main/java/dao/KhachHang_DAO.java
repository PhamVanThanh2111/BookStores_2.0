package dao;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.impl.KhachHang_Impl;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class KhachHang_DAO implements KhachHang_Impl {
	private EntityManager em;

	public KhachHang_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public List<KhachHang> getAllKhachHang() throws Exception {
		return em.createNamedQuery("getAllKhachHang", KhachHang.class).getResultList();
	}

	@Override
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws Exception {
		return em.createNamedQuery("getKhachHangTheoSoDienThoai", KhachHang.class)
				.setParameter("soDienThoai", soDienThoai).getSingleResult();
	}

	@Override
	public KhachHang getKhachHangTheoMa(String maKhachHang) throws SQLException {
		return em.find(KhachHang.class, maKhachHang);
	}

	@Override
	public boolean xoaKhachHangTheoMa(String maKH) throws Exception {
		boolean result = false;
		try {
			KhachHang khachHang = em.find(KhachHang.class, maKH);
			em.getTransaction().begin();
			em.remove(khachHang);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean suaKhachHangTheoMa(KhachHang khachHang) throws Exception {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.merge(khachHang);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean themKhachHang(KhachHang khachHang) throws SQLException {
		boolean result = false;
		try {
			em.getTransaction().begin();
			em.persist(khachHang);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<KhachHang, Double> getDanhSachKhachHangMuaNhieuTienNhat() {

		return null;
	}
}
