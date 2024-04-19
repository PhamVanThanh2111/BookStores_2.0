package test;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import dao.ChiTietPhieuDatHang_DAO;
import dao.PhieuDatHang_DAO;
import dao.Sach_DAO;
import dao.SanPham_DAO;
import dao.impl.ChiTietPhieuDatHangImpl;
import dao.impl.PhieuDatHang_Impl;
import dao.impl.Sach_Impl;
import dao.impl.SanPham_Impl;
import entity.ChiTietPhieuDatHang;
import entity.ChiTietPhieuDatKey;
import entity.KhachHang;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.PhieuDatHang;
import entity.Sach;
import entity.SanPham;
import entity.TheLoaiSach;
import entity.generateid.SachGeneratorId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDatHang {
    private PhieuDatHang_Impl phieuDatHang_Impl;
    private ChiTietPhieuDatHangImpl chiTietPhieuDatHangImpl;
    private SanPham_Impl sanPham_Impl;
    private Sach_Impl sach_Impl;
    private EntityManager em;

     @BeforeAll
    void TestDatHang() throws RemoteException {
        phieuDatHang_Impl = new PhieuDatHang_DAO();
        chiTietPhieuDatHangImpl = new ChiTietPhieuDatHang_DAO();
        sanPham_Impl = new SanPham_DAO();
        sach_Impl = new Sach_DAO();
//		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
    }

    @AfterAll
    void close() {
        phieuDatHang_Impl = null;
    }

    @Test
    void testTaoPhieu() throws RemoteException, SQLException {
//		String maPhieuDatHang = "PDH0001";
        PhieuDatHang phieuDatHang = new PhieuDatHang();
//		phieuDatHang.setMaPhieuDatHang("PD00001");
        phieuDatHang.setNhanVien(new NhanVien("NV0002"));
        phieuDatHang.setKhachHang(new KhachHang("KH00022"));
        phieuDatHang.setNgayLap(Date.valueOf(LocalDate.now()));
        phieuDatHang.setThanhTien(1231);
        phieuDatHang_Impl.lapPhieuDatHang(phieuDatHang);


        ChiTietPhieuDatHang chiTietPhieuDatHang = new ChiTietPhieuDatHang();
        SanPham sanPham = sanPham_Impl.getSanPhamTheoMa("DCHT00002");
//		sanPham.setChiTietHoaDons(null);
//		sanPham.setChiTietPhieuDatHangs(null);
//		System.out.println(sanPham.getChiTietHoaDons().size());
        ChiTietPhieuDatKey chiTietPhieuDatKey = new ChiTietPhieuDatKey(phieuDatHang.getMaPhieuDatHang(),"DCHT00002");
//		int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
        chiTietPhieuDatHang.setPhieuDatHang(phieuDatHang);
        chiTietPhieuDatHang.setSanPham(sanPham);
        chiTietPhieuDatHang.setId(chiTietPhieuDatKey);
        chiTietPhieuDatHang.setSoLuong(12);
        chiTietPhieuDatHang.setDonGia(123);
        chiTietPhieuDatHangImpl.themChiTietPhieuDatHang(chiTietPhieuDatHang);
//		SanPham_DAO.banSanPham(sanPham.getMaSanPham(), soLuong);
    }
//	@Test
//	void themSach() throws RemoteException {
//		SachGeneratorId sachGeneratorId = new SachGeneratorId();
//		String maString = sachGeneratorId.generate(null, null).toString();
//		System.out.println(maString);
//		Sach sach = new Sach(maString, "Hahaa", "123", 123, 13, 12, "123", "123", 12, 12, new TheLoaiSach("TL0001"), new NhaXuatBan("NXB0001"));
//		sach_Impl.themSach(sach);
////		sach_Impl.xoaSachTheoMaSach("aaaa");
////		Sach sach = sach_Impl.getSachTheoMa("S00011");
////		Sach sach1 = sach;
////		sach1.setMaSanPham("XS00011");
////		System.out.println(sach);
////		System.out.println(sach.getMaSanPham());
////		System.out.println(sach1.getMaSanPham());
////		try {
////			em.getTransaction().begin();
////			em.persist(sach1);
////			em.getTransaction().commit();
////			em.close();
////		} catch (Exception e) {
////			em.getTransaction().rollback();
////			em.close();
////		}
//	}
}
