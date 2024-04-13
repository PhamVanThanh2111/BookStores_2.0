package dao.impl;

import entity.HoaDon;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface HoaDon_Impl {
    //lay hoa tat ca hoa don
    public List<HoaDon> getAllHoaDon() throws Exception;
    //lay hoa don theo ma
    public HoaDon getHoaDonTheoMa(String maHoaDon)throws Exception;
    //them hoa don
    public boolean themHoaDon(HoaDon hoaDon)throws Exception;
    // get danh sach hoa don cua nhan vien theo ngay
    public List<HoaDon> getHoaDonTheoNhanVienNgayHienTai(String maNhanVien)throws Exception;
    // get danh sach hoa don theo ngay
    public List<HoaDon> getHoaDonTheoNgay(Date ngay)throws Exception;
    // get danh sach hoa don nhieu tien nhat
    public List<HoaDon> getHoaDonsNhieuTienNhat()throws Exception;


}
