package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_chitietdonhang", schema = "dbo", catalog = "QuanLiDT")
@IdClass(TblChitietdonhangEntityPK.class)
public class TblChitietdonhangEntity {
    private int idDondathang;
    private int idSanpham;
    private Integer soluong;
    private Integer gia;
    private TblDondathangEntity tblDondathangByIdDondathang;
    private TblSanphamEntity tblSanphamByIdSanpham;

    @Id
    @Column(name = "id_dondathang", nullable = false)
    public int getIdDondathang() {
        return idDondathang;
    }

    public void setIdDondathang(int idDondathang) {
        this.idDondathang = idDondathang;
    }

    @Id
    @Column(name = "id_sanpham", nullable = false)
    public int getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(int idSanpham) {
        this.idSanpham = idSanpham;
    }

    @Basic
    @Column(name = "soluong", nullable = true)
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Basic
    @Column(name = "gia", nullable = true, precision = 0)
    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblChitietdonhangEntity that = (TblChitietdonhangEntity) o;
        return idDondathang == that.idDondathang &&
                idSanpham == that.idSanpham &&
                Objects.equals(soluong, that.soluong) &&
                Objects.equals(gia, that.gia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDondathang, idSanpham, soluong, gia);
    }

    @ManyToOne
    @JoinColumn(name = "id_dondathang", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TblDondathangEntity getTblDondathangByIdDondathang() {
        return tblDondathangByIdDondathang;
    }

    public void setTblDondathangByIdDondathang(TblDondathangEntity tblDondathangByIdDondathang) {
        this.tblDondathangByIdDondathang = tblDondathangByIdDondathang;
    }

    @ManyToOne
    @JoinColumn(name = "id_sanpham", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TblSanphamEntity getTblSanphamByIdSanpham() {
        return tblSanphamByIdSanpham;
    }

    public void setTblSanphamByIdSanpham(TblSanphamEntity tblSanphamByIdSanpham) {
        this.tblSanphamByIdSanpham = tblSanphamByIdSanpham;
    }
}
