package dao;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import dao.impl.HoaDon_Impl;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HoaDon_DAO implements HoaDon_Impl {
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
    public boolean themHoaDon(HoaDon hoaDon) throws RemoteException {
        boolean result = false;
        try {
            em.getTransaction().begin();
            em.persist(hoaDon);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
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
    public List<HoaDon> getHoaDonTheoNgay(Date ngay) {
        return em.createNamedQuery("getHoaDonTheoNgay", HoaDon.class).setParameter("ngaylap", ngay).getResultList();

    }

    @Override
    public List<HoaDon> getHoaDonsNhieuTienNhat() {
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
		Integer result = em.createNamedQuery("getSoLuongSanPhamBanTheoNgay", Integer.class)
                .setParameter("ngaylap", date)
                .getSingleResult();
        return result == null ? 0 : result;
	}
}
