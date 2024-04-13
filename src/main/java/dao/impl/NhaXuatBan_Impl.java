package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhaXuatBan;

public interface NhaXuatBan_Impl extends Remote{

    // Lấy tất cả nhà xuất bản
    List<NhaXuatBan> getAllNhaXuatBan() throws RemoteException;
    
    List<NhaXuatBan> getNhaXuatBanTheoDiaChi(String diaChi) throws RemoteException;

	List<NhaXuatBan> getNhaXuatBanTheoSoDienThoai(String soDienThoai) throws RemoteException;

    // Lấy nhà xuất bản theo mã
    NhaXuatBan getNhaXuatBanTheoMa(String maNhaXuatBan) throws RemoteException;

    // Lấy nhà xuất bản theo tên
    NhaXuatBan getNhaXuatBanTheoTen(String tenNhaXuatBan) throws RemoteException;

    // Thêm nhà xuất bản
    boolean themNhaXuatBan(NhaXuatBan nhaXuatBan) throws RemoteException;

    // Xóa nhà xuất bản theo mã
    boolean xoaNhaXuatBanTheoMa(String maNhaXuatBan) throws RemoteException;

    // Sửa nhà xuất bản theo mã
    boolean suaNhaXuatBanTheoMa(NhaXuatBan nhaXuatBan) throws RemoteException;

	
}
