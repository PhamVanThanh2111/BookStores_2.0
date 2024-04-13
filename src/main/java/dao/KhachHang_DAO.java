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
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		return em.createNamedQuery("getAllKhachHang", KhachHang.class).getResultList();
	}

	@Override
	public KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws RemoteException {
		return em.createNamedQuery("getKhachHangTheoSoDienThoai", KhachHang.class)
				.setParameter("soDienThoai", soDienThoai).getSingleResult();
	}

	@Override
	public KhachHang getKhachHangTheoMa(String maKhachHang) throws RemoteException {
		return em.find(KhachHang.class, maKhachHang);
	}

	@Override
	public boolean xoaKhachHangTheoMa(String maKH) throws RemoteException {
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
	public boolean suaKhachHangTheoMa(KhachHang khachHang) throws RemoteException {
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
	public boolean themKhachHang(KhachHang khachHang) throws RemoteException {
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
	public List<KhachHang> getDanhSachKhachHangMuaNhieuTienNhat() throws RemoteException {
		List<KhachHang> result = em.createNamedQuery("getKhachHangMuaNhieuTienNhat", KhachHang.class)
				.getResultList();
		return result;
	}

}
