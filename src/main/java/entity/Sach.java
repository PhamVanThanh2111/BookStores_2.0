package entity;

import java.io.Serializable;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "Sach")
@NamedQueries({
	@NamedQuery(name = "getAllSach",query = "SELECT sa FROM Sach sa WHERE sa.maSanPham LIKE 'S%'"),
	@NamedQuery(name = "getSachTheoTen",query = "SELECT sa FROM Sach sa where sa.tenSanPham LIKE :tenSanPham"),
	@NamedQuery(name = "getAllSachXoa", query = "SELECT sa FROM Sach sa where sa.maSanPham LIKE 'XS%'"),
})
public class Sach extends SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "tacGia", columnDefinition = "nvarchar(50)", nullable = false)
	private String tacGia;

	@Column(name = "soTrang", nullable = false)
	private int soTrang;

	@Column(name = "namXuatBan", nullable = false)
	private int namXuatBan;

	@ManyToOne
	@JoinColumn(name = "maTheLoaiSach", columnDefinition = "nvarchar(7)", nullable = false)
	private TheLoaiSach theLoaiSach;

	@ManyToOne
	@JoinColumn(name = "maNhaXuatBan", columnDefinition = "nvarchar(7)", nullable = false)
	private NhaXuatBan nhaXuatBan;

	public Sach() {
		super();
	}

	public Sach(String tacGia, int soTrang, int namXuatBan) {
		super();
		this.tacGia = tacGia;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
	}

	public String getTacGia() {
		return tacGia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public TheLoaiSach getTheLoaiSach() {
		return theLoaiSach;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public void setTheLoaiSach(TheLoaiSach theLoaiSach) {
		this.theLoaiSach = theLoaiSach;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}


}
