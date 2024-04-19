package test;

import dao.Sach_DAO;
import dao.impl.Sach_Impl;
import entity.Sach;
import entity.SanPham;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSach {
    private Sach_Impl sach_impl;
    @BeforeAll
    void TestSach() throws RemoteException {
        sach_impl = new Sach_DAO();
    }
    @AfterAll
    void close(){
        sach_impl = null;
    }
    @Test
    void themSach() throws RemoteException {
        Sach sach = sach_impl.getSachTheoMa("S00010");
		Sach sach_temp = new Sach();
		sach_temp.setTenSanPham(sach.getTenSanPham());
        System.out.println(sach_temp.getMaSanPham());
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
        sach_temp.setMaSanPham("XS00013");
        sach_impl.themSach(sach_temp);
        System.out.println(sach_temp.getMaSanPham());
    }
}
