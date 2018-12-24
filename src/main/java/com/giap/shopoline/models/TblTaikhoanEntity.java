package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_taikhoan", schema = "dbo", catalog = "QuanLiDT")
public class TblTaikhoanEntity {
    private int id;
    private Integer idQuyen;
    private String tentaikhoan;
    private String matkhau;
    private Integer idNhanvien;
    private Boolean trangthai;
    private TblQuyenEntity tblQuyenByIdQuyen;
    private TblNhanvienEntity tblNhanvienByIdNhanvien;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_quyen", nullable = true)
    public Integer getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(Integer idQuyen) {
        this.idQuyen = idQuyen;
    }

    @Basic
    @Column(name = "tentaikhoan", nullable = true, length = 50)
    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    @Basic
    @Column(name = "matkhau", nullable = true, length = 30)
    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Basic
    @Column(name = "id_nhanvien", nullable = true)
    public Integer getIdNhanvien() {
        return idNhanvien;
    }

    public void setIdNhanvien(Integer idNhanvien) {
        this.idNhanvien = idNhanvien;
    }

    @Basic
    @Column(name = "trangthai", nullable = true)
    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblTaikhoanEntity that = (TblTaikhoanEntity) o;
        return id == that.id &&
                Objects.equals(idQuyen, that.idQuyen) &&
                Objects.equals(tentaikhoan, that.tentaikhoan) &&
                Objects.equals(matkhau, that.matkhau) &&
                Objects.equals(idNhanvien, that.idNhanvien) &&
                Objects.equals(trangthai, that.trangthai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idQuyen, tentaikhoan, matkhau, idNhanvien, trangthai);
    }

    @ManyToOne
    @JoinColumn(name = "id_quyen", referencedColumnName = "id")
    public TblQuyenEntity getTblQuyenByIdQuyen() {
        return tblQuyenByIdQuyen;
    }

    public void setTblQuyenByIdQuyen(TblQuyenEntity tblQuyenByIdQuyen) {
        this.tblQuyenByIdQuyen = tblQuyenByIdQuyen;
    }

    @ManyToOne
    @JoinColumn(name = "id_nhanvien", referencedColumnName = "id")
    public TblNhanvienEntity getTblNhanvienByIdNhanvien() {
        return tblNhanvienByIdNhanvien;
    }

    public void setTblNhanvienByIdNhanvien(TblNhanvienEntity tblNhanvienByIdNhanvien) {
        this.tblNhanvienByIdNhanvien = tblNhanvienByIdNhanvien;
    }
}
