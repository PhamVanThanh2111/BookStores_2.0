package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import dao.impl.KhachHang_Impl;
import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class KhachHang_DAO extends UnicastRemoteObject implements KhachHang_Impl {
	private static final long serialVersionUID = 1L;
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
	public Map<KhachHang, Double> getKhachHangMuaNhieuTienNhat() throws RemoteException {
		List<?> result = em.createNamedQuery("getKhachHangMuaNhieuTienNhat").getResultList();
		Map<KhachHang, Double> map = new HashMap<>();
		if (result.isEmpty())
			return null;
		result.stream().map(o -> (Object[]) o).forEach(o -> {
			try {
				map.put(getKhachHangTheoMa((String) o[0]), (Double) o[1]);
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
		});
		return map;
	}

	@Override
	public Map<KhachHang, Double> getDanhSachMuoiKhachHangMuaNhieuNhat() throws RemoteException {
		List<?> result = em.createNamedQuery("getMuoiKhachHangMuaNhieu").setMaxResults(10).getResultList();
		Map<KhachHang, Double> map = new LinkedHashMap<>();
		if (result.isEmpty())
			return null;
		result.stream().map(o -> (Object[]) o).forEach(o -> {
			try {
				map.put(getKhachHangTheoMa((String) o[0]), (Double) o[1]);
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
		});
		return map;
	}


}
