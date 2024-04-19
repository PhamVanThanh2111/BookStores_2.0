package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.TaiKhoan_Impl;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TaiKhoan_DAO extends UnicastRemoteObject implements TaiKhoan_Impl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public TaiKhoan_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public boolean themTaiKhoan(TaiKhoan tk) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(tk);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean xoaTaiKhoan(String maTaiKhoan) throws RemoteException {
		TaiKhoan taiKhoan = em.find(TaiKhoan.class, maTaiKhoan);
		if (taiKhoan != null) {
			try {
				em.getTransaction().begin();
				em.remove(taiKhoan);
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

	@Override
	public boolean suaTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(taiKhoan);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<TaiKhoan> getDanhSachTaiKhoan() throws RemoteException {
		return null;
	}

	@Override
	public TaiKhoan getTaiKhoanTheoMaTaiKhoan(String maTK) throws RemoteException {
		return em.find(TaiKhoan.class, maTK);
	}

	@Override
	public String getMatKhauTheoMaNhanVien(String ma) throws RemoteException {
		return em.find(TaiKhoan.class, ma).getMatKhau();
	}

	@Override
	public String getTaiKhoanMoiNhat() throws RemoteException {
		return em.createNamedQuery("getTaiKhoanMoiNhat", String.class).getSingleResult();
	}
	
}
