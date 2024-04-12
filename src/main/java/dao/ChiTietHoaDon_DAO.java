package dao;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.ChiTietHoaDon_Impl;
import entity.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ChiTietHoaDon_DAO implements ChiTietHoaDon_Impl {
	private EntityManager em;

	public ChiTietHoaDon_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	public boolean themChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) throws SQLException {
		boolean result = false;
		try {
			em.getTransaction().begin();
			for (ChiTietHoaDon cthd : chiTietHoaDon) {
				em.persist(cthd);
			}
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	public List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws SQLException {
		return em.createNamedQuery("getAllChiTietHoaDonTheoMaHoaDon", ChiTietHoaDon.class)
				.setParameter("maHoaDon", maHoaDon)
				.getResultList();
	}
}
