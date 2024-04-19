package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietHoaDon")
@NamedQueries({
		@NamedQuery(name = "getAllChiTietHoaDonTheoMaHoaDon", query = "select cthd from ChiTietHoaDon cthd where cthd.id.maHoaDon = :maHoaDon")
})
public class ChiTietHoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietHoaDonKey id;

	@ManyToOne()
	@MapsId("maHoaDon")
	@JoinColumn(name = "maHoaDon", columnDefinition = "nvarchar(7)", nullable = false)
	private HoaDon hoaDon;

	@ManyToOne()
	@MapsId("maSanPham")
	@JoinColumn(name = "maSanPham", columnDefinition = "nvarchar(10)", nullable = false)
	private SanPham sanPham;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@Column(name = "donGia", nullable = false)
	private float donGia;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(ChiTietHoaDonKey id, int soLuong, float donGia) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietHoaDonKey getId() {
		return id;
	}

	public void setId(ChiTietHoaDonKey id) {
		this.id = id;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
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

//	@Override
//	public String toString() {
//		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", donGia="
//				+ donGia + "]";
//	}

}
