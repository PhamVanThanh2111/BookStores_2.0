package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.HoaDonCho_Impl;
import entity.HoaDonCho;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HoaDonCho_DAO extends UnicastRemoteObject implements HoaDonCho_Impl {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public HoaDonCho_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public List<HoaDonCho> getAllHoaDonCho() throws RemoteException {
		return em.createNamedQuery("getAllHoaDonCho", HoaDonCho.class).getResultList();
	}

	@Override
	public HoaDonCho getHoaDonChoTheoMa(String maHoaDonCho) throws RemoteException {
		return em.find(HoaDonCho.class, maHoaDonCho);
	}

	@Override
	public HoaDonCho themHoaDonCho(HoaDonCho hoaDonCho) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(hoaDonCho);
			em.getTransaction().commit();
			return hoaDonCho;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean xoaHoaDonCho(String maHoaDonCho) throws RemoteException {
		if (em.find(HoaDonCho.class, maHoaDonCho) != null) {
			try {
				em.getTransaction().begin();
				em.remove(em.find(HoaDonCho.class, maHoaDonCho));
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
