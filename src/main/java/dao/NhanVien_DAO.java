package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.impl.NhanVien_Impl;
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
				.setParameter("soDienThoai", sdtNV)
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
			if (nhanVien.getMaNhanVien() != null) {
				em.merge(nhanVien);
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
	public List<NhanVien> getAllNhanVien() throws RemoteException {
		return em.createNamedQuery("getAllNhanVien", NhanVien.class).getResultList();
	}
	@Override
	public Map<NhanVien, Double> getDoanhThuNhanVien() throws RemoteException {
		List<?> result = em.createNamedQuery("getDoanhThuTheoNhanVien").setMaxResults(7).getResultList();
		Map<NhanVien, Double> map = new LinkedHashMap<>();
		if(result.isEmpty())
			return null;
		result.stream().map(o -> (Object[]) o).forEach(o -> {
			try {
				map.put(this.getNhanVienTheoMa((String) o[0]), (Double) o[1]);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
		return map;
	}
	@Override
	public Map<NhanVien, Integer> getTongHoaDonSoLuongNhanVien() throws RemoteException {
		List<?> result = em.createNamedQuery("getHoaDonSoLuongNhanVien").setMaxResults(7).getResultList();
		Map<NhanVien, Integer> map = new LinkedHashMap<>();
		if (result.isEmpty())
			return null;
		result.stream().map(o -> (Object[]) o).forEach(o -> {
			try {
				Long a = (Long) o[1];
				map.put(getNhanVienTheoMa((String) o[0]), a.intValue());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
		return map;
	}

	@Override
	public NhanVien getNhanVienTheoMaHoaDon(String maHoaDon) throws RemoteException {
		return em.createNamedQuery("getNhanVienTheoMaHoaDon", NhanVien.class)
				.setParameter("maHoaDon", maHoaDon)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
	}

	@Override
	public double getDoanhThuNhanVienTheoNgay(String maNhanVien, Date ngay) throws RemoteException {
		Double result = em.createNamedQuery("getDoanhThuNhanVienTheoNgay", Double.class)
				.setParameter("ngay", ngay)
				.setParameter("maNhanVien", maNhanVien)
				.getSingleResult();
		return result == null ? 0.0 : result;
	}
}
