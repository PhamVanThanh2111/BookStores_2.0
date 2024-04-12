package dao;

import java.rmi.RemoteException;
import java.util.List;

import dao.impl.PhieuDatHang_Impl;
import entity.PhieuDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PhieuDatHang_DAO implements PhieuDatHang_Impl {
	private EntityManager em;
	public PhieuDatHang_DAO() {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public List<PhieuDatHang> getAllPhieuDatHang() throws RemoteException {
		return em.createNamedQuery("getAllPhieuDatHang", PhieuDatHang.class).getResultList();
	}

	@Override
	public PhieuDatHang getPhieuDatHangTheoMa(String maPhieuDatHang) throws RemoteException {
		return em.find(PhieuDatHang.class, maPhieuDatHang);
	}

	@Override
	public boolean lapPhieuDatHang(PhieuDatHang phieuDatHang) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(phieuDatHang);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean xoaPhieuDatHangTheoMa(String maPhieuDatHang) throws RemoteException {
		try {
			PhieuDatHang phieuDatHang = em.find(PhieuDatHang.class, maPhieuDatHang);
			em.getTransaction().begin();
			em.remove(phieuDatHang);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	
}
