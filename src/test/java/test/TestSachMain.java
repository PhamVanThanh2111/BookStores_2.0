package test;

import java.util.List;

import entity.NhanVien;
import entity.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TestSachMain {
    private static EntityManager entityManager = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	public static void main(String[] args) {
		List<Sach> ds = entityManager.createNamedQuery("findAllSach", Sach.class).getResultList();
    	ds.forEach(sach -> System.out.println(sach.getTenSanPham()));
	}
}
