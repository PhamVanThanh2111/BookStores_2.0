package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.iplm.NhanVien_Impl;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class NhanVien_DAO extends UnicastRemoteObject implements NhanVien_Impl {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	public NhanVien_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) throws RemoteException {
		return em.createNamedQuery("getNhanVienTheoTen", NhanVien.class)
				.setParameter(tenNhanVien, tenNhanVien)
				.getResultList();
	}

	@Override
	public NhanVien getNhanVienTheoMa(String maNhanVien) throws RemoteException {
		return em.find(NhanVien.class, maNhanVien);
	}

	@Override
	public NhanVien getNhanVienTheoSDT(String sdtNV) throws RemoteException {
		return em.createNamedQuery("getNhanVienTheoSoDienThoai", NhanVien.class)
				.setParameter("cCCD", sdtNV)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	@Override
	public NhanVien getNhanVienTheoCCCD(String cccdNV) throws RemoteException {
		return em.createNamedQuery("getNhanVienTheoCCCD", NhanVien.class)
				.setParameter("cCCD", cccdNV)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null);
	}

	@Override
	public NhanVien getNhanVienTheoTaiKhoan(String maTK) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(NhanVien.class, maTK);
	}

	@Override
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(nhanVien);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean xoaNhanVienTheoMa(String maNV) throws RemoteException {
		try {
			NhanVien nhanVien = em.find(NhanVien.class, maNV);
			em.getTransaction().begin();
			em.remove(nhanVien);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean suaNhanVien(NhanVien nhanVien) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(nhanVien);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<NhanVien> getAllNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getAllNhanVien", NhanVien.class).getResultList();
	}

}
