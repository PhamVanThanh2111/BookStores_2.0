package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.TheLoaiSach_Impl;
import entity.TheLoaiSach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TheLoaiSach_DAO extends UnicastRemoteObject implements TheLoaiSach_Impl {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public TheLoaiSach_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public List<TheLoaiSach> getAllTheLoaiSach() throws RemoteException {
		return em.createNamedQuery("getAllTheLoaiSach", TheLoaiSach.class).getResultList();
	}

	@Override
	public TheLoaiSach getTheLoaiSachTheoMa(String maTheLoaiSach) throws RemoteException {
		return em.find(TheLoaiSach.class, maTheLoaiSach);
	}

	@Override
	public TheLoaiSach getTheLoaiSachTheoTen(String tenTheLoaiSach) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getTheLoaiSachTheoTen", TheLoaiSach.class)
				.setParameter("tenTheLoaiSach", tenTheLoaiSach)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean themTheLoaiSach(TheLoaiSach theLoaiSach) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(theLoaiSach);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean xoaTheLoaiSachTheoMa(String maTheLoaiSach) throws RemoteException {
		try {
			TheLoaiSach theLoaiSach = getTheLoaiSachTheoMa(maTheLoaiSach);
			em.getTransaction().begin();
			if (theLoaiSach != null) {
				em.remove(theLoaiSach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean suaTheLoaiSach(TheLoaiSach theLoaiSach) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(theLoaiSach);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

}
