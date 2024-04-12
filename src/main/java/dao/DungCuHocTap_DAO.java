package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.DungCuHocTap_Impl;
import entity.DungCuHocTap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DungCuHocTap_DAO extends UnicastRemoteObject implements DungCuHocTap_Impl {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public DungCuHocTap_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public List<DungCuHocTap> getAllDungCuHocTap() throws RemoteException {
		return em.createNamedQuery("getAllDungCuHocTap", DungCuHocTap.class).getResultList();
	}

	@Override
	public List<DungCuHocTap> getDungCuHocTapTheoTen(String tenDungCuHocTap) throws RemoteException {
		return em.createNamedQuery("getDungCuHocTapTheoTen", DungCuHocTap.class)
				.setParameter("tenSanPham", "%" + tenDungCuHocTap + "%")
				.getResultList();
	}

	@Override
	public boolean xoaDungCuHocTapTheoMa(String maDungCuHocTap) throws RemoteException {
		try {
			DungCuHocTap dungCuHocTap = em.find(DungCuHocTap.class, maDungCuHocTap);
			em.getTransaction().begin();
			if (dungCuHocTap != null) {
				em.remove(dungCuHocTap);
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
	public List<DungCuHocTap> getAllDungCuHocTapXoa() throws RemoteException {
		return em.createNamedQuery("getAllDungCuHocTapXoa", DungCuHocTap.class).getResultList();
	}

	@Override
	public boolean xoaDungCuHocTapVaoThungRac(String maDungCuHocTap) throws RemoteException, SQLException {
		PhatSinhMa_DAO phatSinhMa = new PhatSinhMa_DAO();
		String maDCHTXoa = phatSinhMa.getMaDCHTXoa();
		try {
			DungCuHocTap dungCuHocTap = em.find(DungCuHocTap.class, maDungCuHocTap);
			em.getTransaction().begin();
			if (dungCuHocTap != null) {
				dungCuHocTap.setMaSanPham(maDCHTXoa);
                em.merge(dungCuHocTap);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Không thể xóa dụng cụ học tập này!");
			return false;
		}
	}

	@Override
	public boolean khoiPhucDungCuHocTap(String maDungCuHocTapXoa) throws RemoteException, SQLException {
		PhatSinhMa_DAO phatSinhMa = new PhatSinhMa_DAO();
		String maDCHT = phatSinhMa.getMaDCHT();
		try {
			DungCuHocTap dungCuHocTap = em.find(DungCuHocTap.class, maDungCuHocTapXoa);
			em.getTransaction().begin();
			if (dungCuHocTap != null) {
				dungCuHocTap.setMaSanPham(maDCHT);
                em.merge(dungCuHocTap);
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
	public boolean themDungCuHocTap(DungCuHocTap dungCuHocTap) throws RemoteException {
		try {
			em.getTransaction().begin();
			if (dungCuHocTap != null) {
                em.persist(dungCuHocTap);
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
	public boolean suaDungCuHocTap(DungCuHocTap dungCuHocTap) throws RemoteException {
		try {
			em.getTransaction().begin();
			if (dungCuHocTap != null) {
                em.merge(dungCuHocTap);
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
	public List<DungCuHocTap> getDungCuHocTapGanHetHang() throws RemoteException {
		return em.createNamedQuery("getDungCuHocTapGanHetHang", DungCuHocTap.class).getResultList();
	}

}
