package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien")
@NamedQueries({
        @NamedQuery(name = "getAllNhanVien", query = "SELECT nv FROM NhanVien nv"),
        @NamedQuery(name = "getNhanVienTheoCCCD", query = "SELECT nv FROM NhanVien nv WHERE nv.cCCD = :cCCD"),
        @NamedQuery(name = "getNhanVienTheoSoDienThoai", query = "SELECT nv FROM NhanVien nv WHERE nv.soDienThoai = :soDienThoai"),
        @NamedQuery(name = "getNhanVienTheoTen", query = "SELECT nv FROM NhanVien nv WHERE nv.tenNhanVien LIKE :tenNhanVien"),
        @NamedQuery(name = "getDoanhThuTheoNhanVien", query = "select nv.maNhanVien, sum(hd.thanhTien) as total from NhanVien nv join nv.hoaDons hd GROUP BY nv.maNhanVien order by total desc"),
})
public class NhanVien implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maNhanVien", columnDefinition = "nvarchar(6)")
    private String maNhanVien;

    @Column(name = "tenNhanVien", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenNhanVien;

    @Column(name = "diaChi", columnDefinition = "nvarchar(120)", nullable = false)
    private String diaChi;

    @Column(name = "gioiTinh", columnDefinition = "nvarchar(5)", nullable = false)
    private String gioiTinh;

    @Column(name = "ngaySinh", nullable = false)
    private java.sql.Date ngaySinh;

    @Column(name = "ngayVaoLam", nullable = false)
    private java.sql.Date ngayVaoLam;

    @Column(name = "cCCD", columnDefinition = "nvarchar(12)", nullable = false)
    private String cCCD;

    @Column(name = "email", columnDefinition = "nvarchar(50)", nullable = false)
    private String email;

    @Column(name = "soDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
    private String soDienThoai;

    @Column(name = "chucVu", columnDefinition = "nvarchar(10)", nullable = false)
    private String chucVu;

    @OneToOne()
    @JoinColumn(name = "taiKhoan", columnDefinition = "nvarchar(6)", nullable = false)
    private TaiKhoan taiKhoan;

    @ManyToOne()
    @JoinColumn(name = "maCa", columnDefinition = "nvarchar(3)", nullable = false)
    private Ca ca;

    @OneToMany(mappedBy = "nhanVien")
    private Set<HoaDon> hoaDons;

    @OneToMany(mappedBy = "nhanVien")
    private Set<PhieuDatHang> phieuDatHangs;

    @Column(name = "hinhAnh", columnDefinition = "nvarchar(50)", nullable = false)
    private String hinhAnh;

    public NhanVien() {
        super();
    }

    public NhanVien(String maNV) {
        super();
        this.maNhanVien = maNV;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String gioiTinh, Date ngaySinh,
                    Date ngayVaoLam, String cCCD, String email, String soDienThoai, String chucVu, TaiKhoan taiKhoan, Ca ca, String hinhAnh) {
        super();
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.cCCD = cCCD;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
        this.taiKhoan = taiKhoan;
        this.hinhAnh = hinhAnh;
        this.ca = ca;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public java.sql.Date getNgaySinh() {
        return ngaySinh;
    }

    public java.sql.Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public String getcCCD() {
        return cCCD;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public Ca getCa() {
        return ca;
    }

    public Set<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public Set<PhieuDatHang> getPhieuDatHangs() {
        return phieuDatHangs;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(java.sql.Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayVaoLam(java.sql.Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public void setcCCD(String cCCD) {
        this.cCCD = cCCD;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public void setHoaDons(Set<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public void setPhieuDatHangs(Set<PhieuDatHang> phieuDatHangs) {
        this.phieuDatHangs = phieuDatHangs;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cCCD, email, hinhAnh, maNhanVien, soDienThoai, taiKhoan);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NhanVien other = (NhanVien) obj;
        return Objects.equals(cCCD, other.cCCD) && Objects.equals(email, other.email)
                && Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maNhanVien, other.maNhanVien)
                && Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(taiKhoan, other.taiKhoan);
    }

//	@Override
//	public String toString() {
//		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi
//				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", cCCD=" + cCCD
//				+ ", email=" + email + ", soDienThoai=" + soDienThoai + ", chucVu=" + chucVu + ", taiKhoan=" + taiKhoan
//				+ ", maCa=" + maCa + ", hinhAnh=" + hinhAnh + "]";
//	}

}
