package dao;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    // thống kê top khách hàng mua nhiều nhất
    public ResultSet getDanhSachKhachHangMuaNhieuNhat() {
        return null;
    }

    // thống kê danh sách các sản phẩm bán chạy nhất
    public ResultSet getDanhSachSanPhamBanChay() {
        return null;
    }

    // thống kê doanh thu và số lượng hóa đơn của các nhân viên có doanh thu cao
    public ResultSet getDanhSachNhanVienTheoDoanhThu() {
        return null;
    }
}
