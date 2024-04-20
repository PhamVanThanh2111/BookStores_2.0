package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "DungCuHocTap")
@NamedQueries({
	@NamedQuery(name = "getAllDungCuHocTap", query = "SELECT d FROM DungCuHocTap d WHERE d.maSanPham LIKE 'DCHT%' AND d.trangThai = true"),
	@NamedQuery(name = "getDungCuHocTapTheoTen", query = "SELECT d FROM DungCuHocTap d WHERE d.tenSanPham LIKE :tenSanPham"),
	@NamedQuery(name = "getAllDungCuHocTapXoa", query = "SELECT d FROM DungCuHocTap d WHERE d.maSanPham LIKE 'DCHT%' AND d.trangThai = false"),
})
public class DungCuHocTap extends SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "mucTieuSuDung", columnDefinition = "nvarchar(100)")
	private String mucTieuSuDung;

	@ManyToOne
	@JoinColumn(name = "maNhaCungCap", columnDefinition = "nvarchar(7)", nullable = false)
	private NhaCungCap nhaCungCap;

	public DungCuHocTap() {
		super();
	}

	public DungCuHocTap(String mucTieuSuDung) {
		super();
		this.mucTieuSuDung = mucTieuSuDung;
	}

	public String getMucTieuSuDung() {
		return mucTieuSuDung;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setMucTieuSuDung(String mucTieuSuDung) {
		this.mucTieuSuDung = mucTieuSuDung;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

}
