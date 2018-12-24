package com.giap.shopoline.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_nhanvien", schema = "dbo", catalog = "QuanLiDT")
public class TblNhanvienEntity {
    private int id;
    private String ten;
    private Integer sdt;
    private String email;
    private Date ngaysinh;
    private Boolean gioitinh;
    private String diachi;
    private Collection<TblDondathangEntity> tblDondathangsById;
    private Collection<TblTaikhoanEntity> tblTaikhoansById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ten", nullable = true, length = 100)
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
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ngaysinh", nullable = true)
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Basic
    @Column(name = "gioitinh", nullable = true)
    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Basic
    @Column(name = "diachi", nullable = true, length = 100)
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
        TblNhanvienEntity that = (TblNhanvienEntity) o;
        return id == that.id &&
                Objects.equals(ten, that.ten) &&
                Objects.equals(sdt, that.sdt) &&
                Objects.equals(email, that.email) &&
                Objects.equals(ngaysinh, that.ngaysinh) &&
                Objects.equals(gioitinh, that.gioitinh) &&
                Objects.equals(diachi, that.diachi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, sdt, email, ngaysinh, gioitinh, diachi);
    }

    @OneToMany(mappedBy = "tblNhanvienByIdNhanvien")
    public Collection<TblDondathangEntity> getTblDondathangsById() {
        return tblDondathangsById;
    }

    public void setTblDondathangsById(Collection<TblDondathangEntity> tblDondathangsById) {
        this.tblDondathangsById = tblDondathangsById;
    }

    @OneToMany(mappedBy = "tblNhanvienByIdNhanvien")
    public Collection<TblTaikhoanEntity> getTblTaikhoansById() {
        return tblTaikhoansById;
    }

    public void setTblTaikhoansById(Collection<TblTaikhoanEntity> tblTaikhoansById) {
        this.tblTaikhoansById = tblTaikhoansById;
    }
}
