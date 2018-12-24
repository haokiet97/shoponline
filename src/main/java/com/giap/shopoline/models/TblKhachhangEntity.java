package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_khachhang", schema = "dbo", catalog = "QuanLiDT")
public class TblKhachhangEntity {
    private int id;
    private String ten;
    private Integer sdt;
    private String matkhau;
    private String email;
    private String diachi;
    private Collection<TblBinhluanEntity> tblBinhluansById;
    private Collection<TblDondathangEntity> tblDondathangsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ten", nullable = true, length = 50)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "sdt", nullable = true, precision = 0)
    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    @Basic
    @Column(name = "matkhau", nullable = true, length = 10)
    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "diachi", nullable = true, length = 250)
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblKhachhangEntity that = (TblKhachhangEntity) o;
        return id == that.id &&
                Objects.equals(ten, that.ten) &&
                Objects.equals(sdt, that.sdt) &&
                Objects.equals(matkhau, that.matkhau) &&
                Objects.equals(email, that.email) &&
                Objects.equals(diachi, that.diachi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, sdt, matkhau, email, diachi);
    }

    @OneToMany(mappedBy = "tblKhachhangByIdKhachhang")
    public Collection<TblBinhluanEntity> getTblBinhluansById() {
        return tblBinhluansById;
    }

    public void setTblBinhluansById(Collection<TblBinhluanEntity> tblBinhluansById) {
        this.tblBinhluansById = tblBinhluansById;
    }

    @OneToMany(mappedBy = "tblKhachhangByIdKhachhang")
    public Collection<TblDondathangEntity> getTblDondathangsById() {
        return tblDondathangsById;
    }

    public void setTblDondathangsById(Collection<TblDondathangEntity> tblDondathangsById) {
        this.tblDondathangsById = tblDondathangsById;
    }
}
