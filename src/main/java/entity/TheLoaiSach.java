package entity;

import java.io.Serializable;
import java.util.Set;

import entity.generateid.StringPrefixedSequenceIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TheLoaiSach")
@NamedQueries({
        @NamedQuery(name = "getAllTheLoaiSach", query = "SELECT tls FROM TheLoaiSach tls"),
        @NamedQuery(name = "getTheLoaiSachTheoTen", query = "SELECT tls FROM TheLoaiSach tls WHERE tls.tenTheLoaiSach LIKE :tenTheLoaiSach"),
})
public class TheLoaiSach implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "TL-generator")
    @GenericGenerator(name = "TL-generator", parameters = {
            @Parameter(name = "prefix", value = "TL"),
            @Parameter(name = "numberFormat", value = "%04d")},
            strategy = "entity.generateid.MyGenerator")
    @Column(name = "maTheLoaiSach", columnDefinition = "nvarchar(7)")
    private String maTheLoaiSach;

    @Column(name = "tenTheLoaiSach", columnDefinition = "nvarchar(50)", nullable = false)
    private String tenTheLoaiSach;

    @OneToMany(mappedBy = "theLoaiSach")
    private Set<Sach> sachs;

    public TheLoaiSach() {
        super();
    }

    public TheLoaiSach(String maTheLoaiSach) {
        super();
        this.maTheLoaiSach = maTheLoaiSach;
    }

    public TheLoaiSach(String maTheLoaiSach, String tenTheLoaiSach) {
        super();
        this.maTheLoaiSach = maTheLoaiSach;
        this.tenTheLoaiSach = tenTheLoaiSach;
    }

    public String getMaTheLoaiSach() {
        return maTheLoaiSach;
    }

    public String getTenTheLoaiSach() {
        return tenTheLoaiSach;
    }

    public Set<Sach> getSachs() {
        return sachs;
    }

    public void setMaTheLoaiSach(String maTheLoaiSach) {
        this.maTheLoaiSach = maTheLoaiSach;
    }

    public void setTenTheLoaiSach(String tenTheLoaiSach) {
        this.tenTheLoaiSach = tenTheLoaiSach;
    }

    public void setSachs(Set<Sach> sachs) {
        this.sachs = sachs;
    }

    @Override
    public String toString() {
        return "LoaiSach [maTheLoaiSach=" + maTheLoaiSach + ", tenTheLoaiSach=" + tenTheLoaiSach + "]";
    }

}
