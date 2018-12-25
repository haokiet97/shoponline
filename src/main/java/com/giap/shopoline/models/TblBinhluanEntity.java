package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_binhluan", schema = "dbo", catalog = "QuanLiDT")
public class TblBinhluanEntity {
    private int id;
    private Integer idKhachhang;
    private String noidung;
    private Integer idSanpham;
    private TblKhachhangEntity tblKhachhangByIdKhachhang;
    private TblSanphamEntity tblSanphamByIdSanpham;

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
    @Column(name = "noidung")
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Basic
    @Column(name = "id_sanpham")
    public Integer getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(Integer idSanpham) {
        this.idSanpham = idSanpham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblBinhluanEntity that = (TblBinhluanEntity) o;
        return id == that.id &&
                Objects.equals(idKhachhang, that.idKhachhang) &&
                Objects.equals(noidung, that.noidung) &&
                Objects.equals(idSanpham, that.idSanpham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idKhachhang, noidung, idSanpham);
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
    @JoinColumn(name = "id_sanpham", referencedColumnName = "id")
    public TblSanphamEntity getTblSanphamByIdSanpham() {
        return tblSanphamByIdSanpham;
    }

    public void setTblSanphamByIdSanpham(TblSanphamEntity tblSanphamByIdSanpham) {
        this.tblSanphamByIdSanpham = tblSanphamByIdSanpham;
    }
}
