package test;

import java.rmi.RemoteException;
import java.sql.SQLException;

import dao.DungCuHocTap_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.Sach;
import entity.TaiKhoan;
import entity.generateid.DungCuHocTapGeneratorId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) throws SQLException, RemoteException {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStores MSSQL");
//		EntityManager em = emf.createEntityManager();
//		emf.close();
//		PhatSinhMa_DAO phatSinhMa_DAO = new PhatSinhMa_DAO();
//		System.out.println(phatSinhMa_DAO.getMaSachXoa());
//		Sach sach = em.find(Sach.class, "XS0002");
//		System.out.println(sach.getTacGia());
//		Sach_DAO sach_DAO = new Sach_DAO();
//		System.out.println(sach_DAO.xoaSachVaoThungRac("S00012"));
//		DungCuHocTap_DAO dungCuHocTap_DAO = new DungCuHocTap_DAO();
//		System.out.println(dungCuHocTap_DAO.xoaDungCuHocTapVaoThungRac("DCHT00020"));
//		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
//		TaiKhoan taiKhoan = new TaiKhoan();
//		taiKhoan.setMatKhau(taiKhoan.getTaiKhoan());
//		taiKhoan_DAO.themTaiKhoan(taiKhoan);
//		System.out.println(taiKhoan.getTaiKhoan());
		Sach_DAO sach_DAO = new Sach_DAO();
//		sach_DAO.xoaSachVaoThungRac("S00011");
		sach_DAO.khoiPhucSach("XS00011");
	}
}
