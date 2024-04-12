package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.iplm.Ca_Impl;
import entity.Ca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Ca_DAO extends UnicastRemoteObject implements Ca_Impl{

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	protected Ca_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public Ca getCaTheoMa(String maCa) throws RemoteException {
		return em.find(Ca.class, maCa);
	}
}
