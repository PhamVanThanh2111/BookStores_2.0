package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.ChiTietPhieuDatHangImpl;
import entity.ChiTietPhieuDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ChiTietPhieuDatHang_DAO extends UnicastRemoteObject implements ChiTietPhieuDatHangImpl {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public ChiTietPhieuDatHang_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public boolean themChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(chiTietPhieuDatHang);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHangTheoMaPhieuDatHang(String maPhieuDatHang)
			throws RemoteException {
		return em.createNamedQuery("maPhieuDatHang", ChiTietPhieuDatHang.class)
				.setParameter("maPhieuDatHang", maPhieuDatHang)
				.getResultList();
	}

	@Override
	public boolean xoaChiTietPhieuDatHang(String maPhieuDatHang) throws RemoteException {
		try {
			ChiTietPhieuDatHang chiTietPhieuDatHang = em.find(ChiTietPhieuDatHang.class, maPhieuDatHang);
			em.getTransaction().begin();
			if (chiTietPhieuDatHang != null) {
				em.remove(chiTietPhieuDatHang);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	
}
