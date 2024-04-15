package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SanPham")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "getSanPhamTheoTen", query = "SELECT sp FROM SanPham sp WHERE sp.tenSanPham = :tenSanPham"),
	@NamedQuery(name = "getSanPhamGanHetHang", query = "SELECT sp FROM SanPham sp WHERE sp.soLuongTon <= 10"),
})
public abstract class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "generator", strategy = "entity.generateid.SanPhamGeneratorId")
	@GeneratedValue(generator = "generator")
	@Column(name = "maSanPham", columnDefinition = "nvarchar(9)")
	protected String maSanPham;

	@Column(name = "tenSanPham", columnDefinition = "nvarchar(50)", nullable = false)
	protected String tenSanPham;

	@Column(name = "xuatXu", columnDefinition = "nvarchar(20)", nullable = false)
	protected String xuatXu;

	@Column(name = "giaNhap", nullable = false)
	protected float giaNhap;

	@Column(name = "giaBan", nullable = false)
	protected float giaBan;

	@Column(name = "soLuongTon", nullable = false)
	protected int soLuongTon;

	@Column(name = "hinhAnh", columnDefinition = "nvarchar(50)", nullable = false)
	protected String hinhAnh;

	@OneToMany(mappedBy = "sanPham")
	private Set<ChiTietHoaDon> chiTietHoaDons;

	@OneToMany(mappedBy = "sanPham")
	private Set<ChiTietPhieuDatHang> chiTietPhieuDatHangs;

	public SanPham() {
		super();
	}

	public SanPham(String maSanPham, String tenSanPham, String xuatXu, float giaNhap, float giaBan, int soLuongTon,
			String hinhAnh) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.hinhAnh = hinhAnh;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public Set<ChiTietPhieuDatHang> getChiTietPhieuDatHangs() {
		return chiTietPhieuDatHangs;
	}

	public void setChiTietHoaDons(Set<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public void setChiTietPhieuDatHangs(Set<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
		this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public float getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(float giaNhap) {
		this.giaNhap = giaNhap;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
