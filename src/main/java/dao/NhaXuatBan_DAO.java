package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.NhaXuatBan;
public class NhaXuatBan_DAO {

	// get all nhà xuất bản
    public ArrayList<NhaXuatBan> getAllNhaXuatBan() {
        return null;
    }
    
 // get NXB theo ma
 	public NhaXuatBan getnhaXuatBanTheoMa(String maNhaXuatBan) {
 		return null;
 	}
 // get NXB theo tên
  	public NhaXuatBan getnhaXuatBanTheoTen(String tenNhaXuatBan ) {
  		return null;
  	}
 // thêm nhà xuất bản
 	public boolean themNhaXuatBan(NhaXuatBan nhaXuatBan) throws SQLException {
 	    return false;
 	}
 // xóa nhà xuất bản theo mã
 	public boolean xoaNhaXuatBanTheoMa(String maNhaXuatBan) throws SQLException {
 		return false;
 	}
 	// sửa nhà xuất bản theo mã
 	public boolean suaNhaXuatBanTheoMa(NhaXuatBan nhaXuatBan) throws SQLException {
		return false;
	}
}