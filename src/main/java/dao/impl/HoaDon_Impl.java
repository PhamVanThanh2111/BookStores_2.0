package dao.impl;

import entity.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public interface HoaDon_Impl extends Remote {
    //lay hoa tat ca hoa don
    public List<HoaDon> getAllHoaDon() throws RemoteException;
    //lay hoa don theo ma
    public HoaDon getHoaDonTheoMa(String maHoaDon) throws RemoteException;
    //them hoa don
    public boolean themHoaDon(HoaDon hoaDon) throws RemoteException;
    // get danh sach hoa don cua nhan vien theo ngay
    public List<HoaDon> getHoaDonTheoNhanVienNgayHienTai(String maNhanVien) throws RemoteException;
    // get danh sach hoa don theo ngay
    public List<HoaDon> getHoaDonTheoNgay(Date ngay) throws RemoteException;
    // get danh sach hoa don nhieu tien nhat
    public List<HoaDon> getHoaDonsNhieuTienNhat() throws RemoteException;
    
    public double getTongDoanhThuTheoNgay(Date date) throws RemoteException;
    
    public long getSoLuongSanPhamBanDuocTheoNgay(Date date) throws RemoteException;
}
