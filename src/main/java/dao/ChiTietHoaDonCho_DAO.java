package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.ChiTietHoaDonCho_Impl;
import entity.ChiTietHoaDonCho;
import entity.ChiTietHoaDonChoKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ChiTietHoaDonCho_DAO extends UnicastRemoteObject implements ChiTietHoaDonCho_Impl{

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public ChiTietHoaDonCho_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public boolean themChiTietHoaDonCho(ChiTietHoaDonCho chiTietHoaDonCho) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(chiTietHoaDonCho);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ChiTietHoaDonCho> getAllChiTietHoaDonChoTheoMaHoaDonCho(String maHoaDonCho) throws RemoteException {
		return em.createNamedQuery("getAllChiTietHoaDonChoTheoMaHoaDonCho", ChiTietHoaDonCho.class)
				.setParameter("maHoaDonCho", maHoaDonCho)
				.getResultList();
	}

	@Override
	public boolean xoaChiTietHoaDonCho(ChiTietHoaDonChoKey chiTietHoaDonChoKey) throws RemoteException {
		if (em.find(ChiTietHoaDonCho.class, chiTietHoaDonChoKey) != null) {
			try {
				em.getTransaction().begin();
                em.remove(em.find(ChiTietHoaDonCho.class, chiTietHoaDonChoKey));
                em.getTransaction().commit();
                return true;
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
				return false;
			}
		}
		return false;
	}
}
