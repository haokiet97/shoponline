package com.giap.shopoline.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_dondathang", schema = "dbo", catalog = "QuanLiDT")
public class TblDondathangEntity {
    private int id;
    private Integer idKhachhang;
    private Integer idNhanvien;
    private Date ngaylap;
    private Integer tonggia;
    private String tinhtrang;
    private String ghichu;
    private Collection<TblChitietdonhangEntity> tblChitietdonhangsById;
    private TblKhachhangEntity tblKhachhangByIdKhachhang;
    private TblNhanvienEntity tblNhanvienByIdNhanvien;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_khachhang")
    public Integer getIdKhachhang() {
        return idKhachhang;
    }

    public void setIdKhachhang(Integer idKhachhang) {
        this.idKhachhang = idKhachhang;
    }

    @Basic
    @Column(name = "id_nhanvien")
    public Integer getIdNhanvien() {
        return idNhanvien;
    }

    public void setIdNhanvien(Integer idNhanvien) {
        this.idNhanvien = idNhanvien;
    }

    @Basic
    @Column(name = "ngaylap")
    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    @Basic
    @Column(name = "tonggia")
    public Integer getTonggia() {
        return tonggia;
    }

    public void setTonggia(Integer tonggia) {
        this.tonggia = tonggia;
    }

    @Basic
    @Column(name = "tinhtrang")
    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    @Basic
    @Column(name = "ghichu")
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblDondathangEntity that = (TblDondathangEntity) o;
        return id == that.id &&
                Objects.equals(idKhachhang, that.idKhachhang) &&
                Objects.equals(idNhanvien, that.idNhanvien) &&
                Objects.equals(ngaylap, that.ngaylap) &&
                Objects.equals(tonggia, that.tonggia) &&
                Objects.equals(tinhtrang, that.tinhtrang) &&
                Objects.equals(ghichu, that.ghichu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idKhachhang, idNhanvien, ngaylap, tonggia, tinhtrang, ghichu);
    }

    @OneToMany(mappedBy = "tblDondathangByIdDondathang")
    public Collection<TblChitietdonhangEntity> getTblChitietdonhangsById() {
        return tblChitietdonhangsById;
    }

    public void setTblChitietdonhangsById(Collection<TblChitietdonhangEntity> tblChitietdonhangsById) {
        this.tblChitietdonhangsById = tblChitietdonhangsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_khachhang", referencedColumnName = "id")
    public TblKhachhangEntity getTblKhachhangByIdKhachhang() {
        return tblKhachhangByIdKhachhang;
    }

    public void setTblKhachhangByIdKhachhang(TblKhachhangEntity tblKhachhangByIdKhachhang) {
        this.tblKhachhangByIdKhachhang = tblKhachhangByIdKhachhang;
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
