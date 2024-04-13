package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.impl.NhaXuatBan_Impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import entity.NhaXuatBan;

public class NhaXuatBan_DAO extends UnicastRemoteObject implements NhaXuatBan_Impl{

    private EntityManager em;

    public NhaXuatBan_DAO() throws RemoteException {
        em = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
    }

    // Lấy tất cả nhà xuất bản
    public List<NhaXuatBan> getAllNhaXuatBan() {
        return em.createNamedQuery("getAllNhaXuatBan", NhaXuatBan.class).getResultList();
    }

    // Lấy nhà xuất bản theo mã
    public NhaXuatBan getNhaXuatBanTheoMa(String maNhaXuatBan) {
        return em.find(NhaXuatBan.class, maNhaXuatBan);
    }

    // Lấy nhà xuất bản theo tên
    public NhaXuatBan getNhaXuatBanTheoTen(String tenNhaXuatBan) {
        return em.createNamedQuery("getNhaXuatBanTheoTen", NhaXuatBan.class)
                 .setParameter("tenNhaXuatBan", tenNhaXuatBan)
                 .getResultList()
                 .stream()
                 .findFirst()
                 .orElse(null);
    }

    // Thêm nhà xuất bản
    public boolean themNhaXuatBan(NhaXuatBan nhaXuatBan) {
        boolean result = false;
        try {
            em.getTransaction().begin();
            em.persist(nhaXuatBan);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }

    // Xóa nhà xuất bản theo mã
    public boolean xoaNhaXuatBanTheoMa(String maNhaXuatBan) {
        boolean result = false;
        try {
            NhaXuatBan nxb = em.find(NhaXuatBan.class, maNhaXuatBan);
            em.getTransaction().begin();
            em.remove(nxb);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }

    // Sửa nhà xuất bản theo mã
    public boolean suaNhaXuatBanTheoMa(NhaXuatBan nhaXuatBan) {
        boolean result = false;
        try {
            em.getTransaction().begin();
            em.merge(nhaXuatBan);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<NhaXuatBan> getNhaXuatBanTheoDiaChi(String diaChi) throws RemoteException {
        return em.createNamedQuery("getNhaXuatBanTheoDiaChi", NhaXuatBan.class)
                 .setParameter("diaChi", diaChi)
                 .getResultList();
    }

    @Override
    public List<NhaXuatBan> getNhaXuatBanTheoSoDienThoai(String soDienThoai) throws RemoteException {
        return em.createNamedQuery("getNhaXuatBanTheoSoDienThoai", NhaXuatBan.class)
                 .setParameter("soDienThoai", soDienThoai)
                 .getResultList();
    }


}
