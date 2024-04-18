package test;

import dao.HoaDon_DAO;
import dao.impl.HoaDon_Impl;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestHoaDonDao {
    private HoaDon_Impl hoaDonDao;
    @BeforeAll
    void TestHoaDonDao() throws Exception {
        hoaDonDao = new HoaDon_DAO();
    }
    @AfterAll
    void tearDownAfterClass() throws Exception {
        hoaDonDao = null;
    }
    @Test
    void testFindHoaDonByMaNhanVienVaNgay() throws RemoteException {
//        try {
//            hoaDonDao.getHoaDonTheoNhanVienNgayHienTai("NV0001").forEach(hoaDon -> {
//                System.out.println(hoaDon.getMaHoaDon());
//            });
//        } catch (RemoteException e) {
//            throw new RuntimeException(e);
//        }
        HoaDon hoaDon = new HoaDon();
        System.out.println(hoaDon.getMaHoaDon());
        hoaDon.setNhanVien(new NhanVien("NV0001"));
        hoaDon.setKhachHang(new KhachHang("KH00001"));
        hoaDon.setNgayLap(Date.valueOf(LocalDate.now()));
        hoaDon.setThanhTien(0);
        hoaDonDao.themHoaDon(hoaDon);
        System.out.println(hoaDon.getMaHoaDon());

    }
}
