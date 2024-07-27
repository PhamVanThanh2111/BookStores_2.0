package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietHoaDonCho")
@NamedQueries({
	@NamedQuery(name = "getAllChiTietHoaDonChoTheoMaHoaDonCho", query = "select cthdc from ChiTietHoaDonCho cthdc where cthdc.id.maHoaDonCho = :maHoaDonCho")
})
public class ChiTietHoaDonCho implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietHoaDonChoKey id;
	
	@ManyToOne()
	@MapsId("maHoaDonCho")
	@JoinColumn(name = "maHoaDonCho", columnDefinition = "nvarchar(8)", nullable = false)
	private HoaDonCho hoaDonCho;

	@ManyToOne()
	@MapsId("maSanPham")
	@JoinColumn(name = "maSanPham", columnDefinition = "nvarchar(10)", nullable = false)
	private SanPham sanPham;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@Column(name = "donGia", nullable = false)
	private float donGia;
	
	public ChiTietHoaDonCho() {
		super();
	}
	
	public ChiTietHoaDonCho(ChiTietHoaDonChoKey id, int soLuong, float donGia) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietHoaDonChoKey getId() {
		return id;
	}

	public void setId(ChiTietHoaDonChoKey id) {
		this.id = id;
	}

	public HoaDonCho getHoaDonCho() {
		return hoaDonCho;
	}

	public void setHoaDonCho(HoaDonCho hoaDonCho) {
		this.hoaDonCho = hoaDonCho;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
