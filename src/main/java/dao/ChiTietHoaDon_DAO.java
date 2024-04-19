package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import dao.impl.ChiTietHoaDon_Impl;
import entity.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ChiTietHoaDon_DAO extends UnicastRemoteObject implements ChiTietHoaDon_Impl {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ChiTietHoaDon_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(chiTietHoaDon);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException {
		return em.createNamedQuery("getAllChiTietHoaDonTheoMaHoaDon", ChiTietHoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getResultList();
	}
}
