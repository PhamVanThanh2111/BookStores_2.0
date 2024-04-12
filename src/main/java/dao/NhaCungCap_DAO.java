package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.NhaCungCap;
public class NhaCungCap_DAO {

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        return null;
    }
    
    public NhaCungCap getNhaCCTheoMa(String maNCC) {
 		return null;
    }
    
    public NhaCungCap getNhaCungCapTheoTen(String tenNhaCC) {
		return null;
	}
    
    public boolean themNhaCC(NhaCungCap nhaCC) throws SQLException {
		return false;
	}
    
	public boolean xoaNhaCungCapTheoMa(String maNCC) throws SQLException {
		return false;
	}
	
	
    public boolean suaNhaCungCapTheoMa(NhaCungCap nhaCC) throws SQLException {
		return false;	
	}
}