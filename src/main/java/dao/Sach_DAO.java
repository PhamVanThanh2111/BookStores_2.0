package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.Sach_Impl;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Sach_DAO extends UnicastRemoteObject implements Sach_Impl {
	private static final long serialVersionUID = 1L;

	private EntityManager em;
	public Sach_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public List<Sach> getAllSach() throws RemoteException {
		return em.createNamedQuery("getAllSach", Sach.class).getResultList();
	}

	@Override
	public List<Sach> getSachTheoTen(String tenSach) throws RemoteException {
		return em.createNamedQuery("getSachTheoTen", Sach.class)
				.setParameter("tenSanPham", "%" +tenSach+ "%")
                .getResultList();
	}

	@Override
	public boolean xoaSachTheoMaSach(String maSach) throws RemoteException {
		try {
			Sach sach = em.find(Sach.class, maSach);
			em.getTransaction().begin();
			if (sach != null) {
				em.remove(sach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<Sach> getAllSachXoa() throws RemoteException {
		return em.createNamedQuery("getAllSachXoa", Sach.class).getResultList();
	}

	@Override
	public boolean xoaSachVaoThungRac(String maSach) throws RemoteException, SQLException {
		PhatSinhMa_DAO phatSinhMa = new PhatSinhMa_DAO();
		String maSachXoa = phatSinhMa.getMaSachXoa();
		try {
			Sach sach = em.find(Sach.class, maSach);
			em.getTransaction().begin();
			if (sach != null) {
				sach.setMaSanPham(maSachXoa);
                em.merge(sach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Không thể xóa sách này!");
			return false;
		}
	}

	@Override
	public boolean khoiPhucSach(String maSachXoa) throws RemoteException, SQLException {
		PhatSinhMa_DAO phatSinhMa = new PhatSinhMa_DAO();
		String maSach = phatSinhMa.getMaSach();
		try {
			Sach sach = em.find(Sach.class, maSachXoa);
			em.getTransaction().begin();
			if (sach != null) {
				sach.setMaSanPham(maSach);
                em.merge(sach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean themSach(Sach sach) throws RemoteException {
		try {
			em.getTransaction().begin();
			if (sach != null) {
                em.persist(sach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean suaSach(Sach sach) throws RemoteException {
		try {
			em.getTransaction().begin();
			if (sach != null) {
                em.merge(sach);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<Sach> getSachGanHetHang() throws RemoteException {
		return em.createNamedQuery("getSachGanHetHang", Sach.class).getResultList();
	}
}
