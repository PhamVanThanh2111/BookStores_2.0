package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "maHoaDon")
	private String maHoaDon;

	@Column(name = "maSanPham")
	private String maSanPham;

	public ChiTietHoaDonKey(String maHoaDon, String maSanPham) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSanPham = maSanPham;
	}

	public ChiTietHoaDonKey() {
		super();
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon, maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonKey other = (ChiTietHoaDonKey) obj;
		return Objects.equals(maHoaDon, other.maHoaDon) && Objects.equals(maSanPham, other.maSanPham);
	}

}
