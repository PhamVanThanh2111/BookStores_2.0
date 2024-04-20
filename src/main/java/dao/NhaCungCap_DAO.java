package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.NhaCungCap_Impl;
import entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
public class NhaCungCap_DAO extends UnicastRemoteObject implements NhaCungCap_Impl {
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	
	public NhaCungCap_DAO() throws RemoteException {
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}
	
	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
        return em.createNamedQuery("getAllNhaCungCap", NhaCungCap.class).getResultList();
    }
    
	@Override
	public NhaCungCap getNhaCCTheoMa(String maNCC) throws RemoteException {
	    return em.find(NhaCungCap.class, maNCC);
	}

	@Override
	public NhaCungCap getNhaCungCapTheoTen(String tenNhaCC) throws RemoteException {
	    return em.createNamedQuery("getNhaCungCapTheoTen", NhaCungCap.class)
	             .setParameter("tenNhaCungCap", tenNhaCC)
	             .getResultList()
                 .stream()
                 .findFirst()
                 .orElse(null);
	}
	


	@Override
	public boolean themNhaCC(NhaCungCap nhaCC) throws RemoteException {
	    boolean result = false;
	    try {
	        em.getTransaction().begin();
	        em.persist(nhaCC);
	        em.getTransaction().commit();
	        result = true;
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	    }
	    return result;
	}

	@Override
	public boolean xoaNhaCungCapTheoMa(String maNCC) throws RemoteException {
	    boolean result = false;
	    try {
	        NhaCungCap nhaCC = em.find(NhaCungCap.class, maNCC);
	        em.getTransaction().begin();
	        em.remove(nhaCC);
	        em.getTransaction().commit();
	        result = true;
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	    }
	    return result;
	}

	@Override
	public boolean suaNhaCungCapTheoMa(NhaCungCap nhaCC) throws RemoteException {
	    boolean result = false;
	    try {
	        em.getTransaction().begin();
	        em.merge(nhaCC);
	        em.getTransaction().commit();
	        result = true;
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	    }
	    return result;
	}
	

	@Override
	public List<NhaCungCap> getNhaCungCapTheoDiaChi(String diaChi) throws RemoteException {
	    return em.createNamedQuery("getNhaCungCapTheoDiaChi", NhaCungCap.class)
	             .setParameter("diaChi", diaChi)
	             .getResultList();
	}

	@Override
	public List<NhaCungCap> getNhaCungCapTheoSoDienThoai(String soDienThoai) throws RemoteException {
	    return em.createNamedQuery("getNhaCungCapTheoSoDienThoai", NhaCungCap.class)
	             .setParameter("soDienThoai", soDienThoai)
	             .getResultList();
	}

	@Override
	public List<NhaCungCap> getNhaCungCapTheoTenList(List<String> tenNhaCungCapList) throws RemoteException {
	    return em.createNamedQuery("getNhaCungCapTheoTenList", NhaCungCap.class)
	             .setParameter("tenNhaCungCapList", tenNhaCungCapList)
	             .getResultList();
	}

}