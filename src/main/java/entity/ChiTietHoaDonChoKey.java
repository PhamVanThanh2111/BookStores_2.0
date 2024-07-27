package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonChoKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "maHoaDonCho")
	private String maHoaDonCho;

	@Column(name = "maSanPham")
	private String maSanPham;

	public ChiTietHoaDonChoKey(String maHoaDonCho, String maSanPham) {
		super();
		this.maHoaDonCho = maHoaDonCho;
		this.maSanPham = maSanPham;
	}

	public ChiTietHoaDonChoKey() {
		super();
	}

	public String getMaHoaDonCho() {
		return maHoaDonCho;
	}

	public void setMaHoaDonCho(String maHoaDonCho) {
		this.maHoaDonCho = maHoaDonCho;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
