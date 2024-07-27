package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.impl.SanPham_Impl;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class SanPham_DAO extends UnicastRemoteObject implements SanPham_Impl {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public SanPham_DAO() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	}

	@Override
	public SanPham getSanPhamTheoMa(String maSanPham) throws RemoteException {
		return em.find(SanPham.class, maSanPham);
	}

	@Override
	public SanPham getSanPhamTheoTen(String tenSanPham) throws RemoteException {
		return em.createNamedQuery("getSanPhamTheoTen", SanPham.class)
				.setParameter("tenSanPham", tenSanPham)
				.getResultList()
				.stream()
				.findFirst()
				.orElse(null); 
	}

	@Override
	public boolean banSanPham(String maSanPham, int soLuongBan) throws RemoteException {
		try {
			SanPham sanPham = em.find(SanPham.class, maSanPham);
			em.getTransaction().begin();
			if (sanPham != null) {
				if (sanPham.getSoLuongTon() >= soLuongBan) {
					sanPham.setSoLuongTon(sanPham.getSoLuongTon() - soLuongBan);
					em.merge(sanPham);
				}
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<SanPham> getSanPhamGanHetHang() throws RemoteException {
		return em.createNamedQuery("getSanPhamGanHetHang", SanPham.class).getResultList();
	}

	@Override
	public boolean xoaSanPhamTheoMa(String maSanPham) throws RemoteException {
		try {
			SanPham sanPham = em.find(SanPham.class, maSanPham);
			em.getTransaction().begin();
			if (sanPham != null) {
                em.remove(sanPham);
			}
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public Map<SanPham, Long> getSanPhamBanChay() throws RemoteException {
		List<?> result = em.createNamedQuery("getSanPhamBanChay").setMaxResults(8).getResultList();
		Map<SanPham, Long> map = new LinkedHashMap<SanPham, Long>();
		result.stream()
		.map(o -> (Object[]) o)
		.forEach(o -> {
            try {
            	String maSanPham = (String) o[0];
                SanPham sanPham = em.find(SanPham.class, maSanPham);
                Long soLuongBan = (Long) o[1];
                map.put(sanPham, soLuongBan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
		return map;
	}

}
