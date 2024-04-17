package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.ChiTietPhieuDatHangImpl;
import entity.ChiTietPhieuDatHang;
import entity.ChiTietPhieuDatKey;
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
			em.merge(chiTietPhieuDatHang);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHangTheoMa(String maPhieuDatHang)
			throws RemoteException {
		return em.createNamedQuery("getAllChiTietPhieuDatHangTheoMaPhieuDatHang", ChiTietPhieuDatHang.class)
				.setParameter("maPhieuDatHang", maPhieuDatHang)
				.getResultList();
	}

	@Override
	public boolean xoaChiTietPhieuDatHang(String maPhieuDatHang) throws RemoteException {
		try {
			em.getTransaction().begin();
			List<ChiTietPhieuDatKey> list = getAllChiTietPhieuDatKeyByPhieuDatId(maPhieuDatHang);
			list.forEach(e -> {
				em.remove(em.find(ChiTietPhieuDatHang.class, e));
			});
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public ChiTietPhieuDatHang getChiTietPhieuDatHangById(ChiTietPhieuDatKey chiTietPhieuDatKey)
			throws RemoteException {
		return em.find(ChiTietPhieuDatHang.class, chiTietPhieuDatKey);
	}

	@Override
	public List<ChiTietPhieuDatKey> getAllChiTietPhieuDatKeyByPhieuDatId(String maPhieuDatHang) throws RemoteException {
		return em.createNamedQuery("getAllChiTietPhieuDatKeyByPhieuDatId", ChiTietPhieuDatKey.class)
				.setParameter("maPhieuDatHang", maPhieuDatHang)
				.getResultList();
	}
	
}
