package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.Sach_Impl;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Sach_DAO extends UnicastRemoteObject  implements Sach_Impl {
	
	private EntityManager em;

	protected Sach_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}



	// Lấy sách
		public List<Sach> getAllSach() {
			return  em.createNamedQuery("getAllSach").getResultList();
		}
		//Lấy tên theo mã sách
		public List<Sach> getTenSachTheoTenSanPham(String tenSanPham) {
			return em.createNamedQuery("getTenSachTheoTenSanPham").setParameter("tenSanPham",tenSanPham).getResultList();
		}
		// Xóa sách 
		public boolean xoaSachTheoMa(String maSach) {
			EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				Sach sach = em.find(Sach.class, maSach);
				em.remove(sach);
				et.commit();
				return true;
			} catch (Exception e) {
				et.rollback();
				e.printStackTrace();
			}
			return false;

		}
		// sửa Mã Sách
		public boolean suaMaSach(Sach sach) {
			EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				em.merge(sach);
				et.commit();
				return true;
			} catch (Exception e) {
				et.rollback();
				e.printStackTrace();
			}
			return false;
		}
		public boolean khoiPhucSanPham01(Sach sach) {
			return false;
		}
}
