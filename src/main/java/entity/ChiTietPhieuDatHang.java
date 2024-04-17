package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietPhieuDatHang")
@NamedQueries({
	@NamedQuery(name = "getAllChiTietPhieuDatHangTheoMaPhieuDatHang", query = "SELECT c FROM ChiTietPhieuDatHang c WHERE c.phieuDatHang.maPhieuDatHang = :maPhieuDatHang"),
	@NamedQuery(name = "getAllChiTietPhieuDatKeyByPhieuDatId", query = "SELECT c.id FROM ChiTietPhieuDatHang c WHERE c.phieuDatHang.maPhieuDatHang = :maPhieuDatHang")
})
public class ChiTietPhieuDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChiTietPhieuDatKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maPhieuDatHang")
	@JoinColumn(name = "maPhieuDatHang", columnDefinition = "nvarchar(7)", nullable = true)
	private PhieuDatHang phieuDatHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maSanPham")
	@JoinColumn(name = "maSanPham", columnDefinition = "nvarchar(10)", nullable = true)
	private SanPham sanPham;

	@Column(name = "soLuong", nullable = false)
	private int soLuong;

	@Column(name = "donGia", nullable = false)
	private float donGia;

	public ChiTietPhieuDatHang() {
		super();
	}

	public ChiTietPhieuDatHang(ChiTietPhieuDatKey id, int soLuong, float donGia) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public ChiTietPhieuDatKey getId() {
		return id;
	}

	public void setId(ChiTietPhieuDatKey id) {
		this.id = id;
	}

	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}

	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
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
//		return "ChiTietPhieuDatHang [maPhieuDatHang=" + maPhieuDatHang + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", donGia="
//				+ donGia + "]";
//	}

}
