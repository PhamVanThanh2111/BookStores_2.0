package test;

import java.sql.SQLException;

import dao.PhatSinhMa_DAO;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStores MSSQL");
		EntityManager em = emf.createEntityManager();
//		emf.close();
//		PhatSinhMa_DAO phatSinhMa_DAO = new PhatSinhMa_DAO();
//		System.out.println(phatSinhMa_DAO.getMaSachXoa());
		Sach sach = em.find(Sach.class, "XS0002");
		System.out.println(sach.getTacGia());
		
	}
}
