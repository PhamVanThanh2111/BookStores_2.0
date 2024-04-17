package test;

import dao.KhachHang_DAO;
import dao.impl.KhachHang_Impl;
import entity.KhachHang;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestKhachHangDao {
    private KhachHang_Impl khachHang_DAO;

    @BeforeAll
    void TestKhachHangDao() throws RemoteException {
        this.khachHang_DAO = new KhachHang_DAO();
    }
    @AfterAll
    void close() {
        khachHang_DAO = null;
    }
    @Test
    void testThemKhachHang(){
        try {
            KhachHang khachHang = new KhachHang();
            khachHang.setTenKhachHang("Nguyen Van A");
            khachHang.setGioiTinh("Nam");
            khachHang.setSoDienThoai("0123456789");
            khachHang.setDiaChi("Ha Noi");
            khachHang_DAO.themKhachHang(khachHang);
            } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
