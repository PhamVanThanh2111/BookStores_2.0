package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.ChiTietHoaDon;

public class ChiTietHoaDon_DAO {
	// them nhan vien
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws SQLException {
		
		return false;
	}

	// get all chi tiet hoa don theo ma hoa don
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) {
		return null;
	}
	
//	// get danh sach chi tiet hoa don theo ngay
//		public ArrayList<ChiTietHoaDon> getListChiTietHoaDonTheoNgay(LocalDate date) { 
//			ConnectDB.getInstance();
//			Connection connection = ConnectDB.getConnection();
//			ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
//			try {
//				PreparedStatement preparedStatement = connection
//						.prepareStatement("select * from ChiTietHoaDon where ngayLap = '"+ date +"'");
//				ResultSet resultSet = preparedStatement.executeQuery();
//				while (resultSet.next()) {
//					HoaDon hoaDon = new HoaDon();
//					hoaDon.setMaHoaDon(resultSet.getString(1));
//					hoaDon.setMaNhanVien(resultSet.getString(2));
//					hoaDon.setMaKhachHang(resultSet.getString(3));
//					hoaDon.setNgayLap(resultSet.getDate(4));
//					hoaDon.setThanhTien(resultSet.getFloat(5));
//					ds.add(hoaDon);
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			return ds;
//		}
}
