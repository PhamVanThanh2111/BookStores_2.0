package test;

import dao.KhachHang_DAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestKhachHangDao {
    private KhachHang_DAO khachHang_DAO;

    @BeforeAll
    void TestKhachHangDao() throws RemoteException {
        this.khachHang_DAO = new KhachHang_DAO();
    }
    @AfterAll
    void close() {
        khachHang_DAO = null;
    }
    @Test
    void testGetKhachHangMuaNhieu(){
        try {
            khachHang_DAO.getDanhSachKhachHangMuaNhieuTienNhat().forEach((khachHang, aDouble) -> {
                System.out.println(khachHang.getMaKhachHang() + " " + aDouble);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
