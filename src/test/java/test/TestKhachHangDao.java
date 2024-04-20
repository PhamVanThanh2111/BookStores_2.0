package test;

import dao.KhachHang_DAO;
import dao.TaiKhoan_DAO;
import dao.impl.KhachHang_Impl;
import dao.impl.TaiKhoan_Impl;
import entity.KhachHang;
import entity.TaiKhoan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestKhachHangDao {
    private KhachHang_Impl khachHang_DAO;
    private TaiKhoan_Impl taiKhoan_DAO;
    @BeforeAll
    void TestKhachHangDao() throws RemoteException {
        this.khachHang_DAO = new KhachHang_DAO();
        this.taiKhoan_DAO = new TaiKhoan_DAO();
    }

    @AfterAll
    void close() {
        khachHang_DAO = null;
        taiKhoan_DAO = null;
    }

    @Test
    void testThemKhachHang() {
        try {
            KhachHang khachHang = new KhachHang();
            khachHang.setTenKhachHang("Nguyen Van A");
            System.out.println(khachHang.getMaKhachHang());
            khachHang.setGioiTinh("Nam");
            khachHang.setSoDienThoai("0123456789");
            khachHang.setDiaChi("Ha Noi");
            khachHang_DAO.themKhachHang(khachHang);
            System.out.println(khachHang.getMaKhachHang());
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Test
    void themTk() throws RemoteException {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setMatKhau("123");
        taiKhoan_DAO.themTaiKhoan(taiKhoan);
        System.out.println(taiKhoan.getNhanVien());
    }
}
