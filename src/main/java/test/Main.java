package test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStores MSSQL");
//		EntityManager em = emf.createEntityManager();
		emf.close();
	}

}
