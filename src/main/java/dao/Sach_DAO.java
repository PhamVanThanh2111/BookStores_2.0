package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.Sach_Impl;
import entity.Sach;
import entity.SanPham;
import entity.generateid.SachGeneratorId;
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

	/**
	 * @param sach sách cần xóa. Trong đó, mã sách của sach là mã S.
     * @return true nếu xóa sách thành công, ngược lại trả về false.
     *
	 */
	@Override
	public boolean xoaSachVaoThungRac(String maSach) throws RemoteException, SQLException {
		try {
			Sach sach = em.find(Sach.class, maSach);
			Sach sach_temp = new Sach();
			sach_temp.setMaSanPham("X" + maSach);
			sach_temp.setTenSanPham(sach.getTenSanPham());
			sach_temp.setXuatXu(sach.getXuatXu());
			sach_temp.setGiaNhap(sach.getGiaNhap());
			sach_temp.setGiaBan(sach.getGiaBan());
			sach_temp.setSoLuongTon(sach.getSoLuongTon());
			sach_temp.setNhaXuatBan(sach.getNhaXuatBan());
			sach_temp.setTheLoaiSach(sach.getTheLoaiSach());
			sach_temp.setTacGia(sach.getTacGia());
			sach_temp.setSoTrang(sach.getSoTrang());
			sach_temp.setNamXuatBan(sach.getNamXuatBan());
			sach_temp.setHinhAnh(sach.getHinhAnh());
			if (sach != null) {
				xoaSachTheoMaSach(maSach);
				themSach(sach_temp);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không thể xóa sách này!");
			return false;
		}
	}

	/**
	 * @param sach có mã của sách cần khôi phục. Trong đó, mã sách của sach là mã sách đã xóa.
     * @return true nếu khôi phục sách thành công, ngược lại trả về false.
	 */
	@Override
	public boolean khoiPhucSach(String maSachXoa) throws RemoteException, SQLException {
		try {
			Sach sach = em.find(Sach.class, maSachXoa);
			Sach sach_temp = new Sach();
			sach_temp.setMaSanPham(maSachXoa.substring(1));
			sach_temp.setTenSanPham(sach.getTenSanPham());
			sach_temp.setXuatXu(sach.getXuatXu());
			sach_temp.setGiaNhap(sach.getGiaNhap());
			sach_temp.setGiaBan(sach.getGiaBan());
			sach_temp.setSoLuongTon(sach.getSoLuongTon());
			sach_temp.setNhaXuatBan(sach.getNhaXuatBan());
			sach_temp.setTheLoaiSach(sach.getTheLoaiSach());
			sach_temp.setTacGia(sach.getTacGia());
			sach_temp.setSoTrang(sach.getSoTrang());
			sach_temp.setNamXuatBan(sach.getNamXuatBan());
			sach_temp.setHinhAnh(sach.getHinhAnh());
			if (sach != null) {
				xoaSachTheoMaSach(maSachXoa);
				themSach(sach_temp);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
	public Sach getSachTheoMa(String maSach) throws RemoteException {
		return em.find(Sach.class, maSach);
	}
}
