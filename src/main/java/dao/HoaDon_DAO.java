package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import dao.impl.HoaDon_Impl;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HoaDon_DAO extends UnicastRemoteObject implements HoaDon_Impl {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

    public HoaDon_DAO() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
    }

    @Override
    public List<HoaDon> getAllHoaDon() throws RemoteException {
        return em.createNamedQuery("getAllHoaDon", HoaDon.class).getResultList();
    }

    @Override
    public HoaDon getHoaDonTheoMa(String maHoaDon) throws RemoteException {
        return em.find(HoaDon.class, maHoaDon);
    }

    @Override
    public HoaDon themHoaDon(HoaDon hoaDon) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.persist(hoaDon);
            em.getTransaction().commit();
            return hoaDon;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> getHoaDonTheoNhanVienNgayHienTai(String maNhanVien) throws RemoteException {
        Date customDate = Date.valueOf(LocalDate.now());
        return em.createNamedQuery("getHoaDonTheoMaNhanVienVaNgayHienTai", HoaDon.class)
                .setParameter("maNhanVien", maNhanVien)
                .setParameter("ngayHienTai", customDate)
                .getResultList();
    }

    @Override
    public List<HoaDon> getHoaDonTheoNgay(Date ngay) throws RemoteException {
        return em.createNamedQuery("getHoaDonTheoNgay", HoaDon.class).setParameter("ngaylap", ngay).getResultList();

    }

    @Override
    public List<HoaDon> getHoaDonsNhieuTienNhat() throws RemoteException {
        return em.createNamedQuery("getHoaDonsNhieuTienNhat", HoaDon.class).getResultList();
    }

	@Override
	public double getTongDoanhThuTheoNgay(Date date) throws RemoteException {
		Double result = em.createNamedQuery("getDoanhThuTheoNgay", Double.class)
				.setParameter("ngaylap", date)
				.getSingleResult();
		return result == null ? 0.0 : result;
	}

	@Override
	public long getSoLuongSanPhamBanDuocTheoNgay(Date date) throws RemoteException {
	    Long result = em.createNamedQuery("getSoLuongSanPhamBanTheoNgay", Long.class)
	                    .setParameter("ngaylap", date)
	                    .getSingleResult();
	    return result == null ? 0 : result;
	}

	@Override
	public List<HoaDon> getHoaDonTheoMaNhanVien(String maNhanVien) throws RemoteException {
		return em.createNamedQuery("getHoaDonTheoMaNhanVien", HoaDon.class)
				.setParameter("maNhanVien", maNhanVien)
				.getResultList();
	}

	@Override
	public List<HoaDon> getHoaDonTheoMaKhachHang(String maKhachHang) throws RemoteException {
		return em.createNamedQuery("getHoaDonTheoMaKhachHang", HoaDon.class)
				.setParameter("maKhachHang", maKhachHang)
				.getResultList();
	}
}
