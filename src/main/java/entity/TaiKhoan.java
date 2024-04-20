package entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "taiKhoan", columnDefinition = "nvarchar(6)")
	private NhanVien nhanVien;
	
	@Column(name = "matKhau", columnDefinition = "nvarchar(20)", nullable = false)
	private String matKhau;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String matKhau) {
		super();
		this.matKhau = matKhau;
	}

	public String getTaiKhoan() {
		return nhanVien.getMaNhanVien();
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + nhanVien.getMaNhanVien() + ", matKhau=" + matKhau + "]";
	}

}
