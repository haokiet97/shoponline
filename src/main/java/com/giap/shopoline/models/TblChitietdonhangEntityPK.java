package com.giap.shopoline.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TblChitietdonhangEntityPK implements Serializable {
    private int idDondathang;
    private int idSanpham;

    @Column(name = "id_dondathang")
    @Id
    public int getIdDondathang() {
        return idDondathang;
    }

    public void setIdDondathang(int idDondathang) {
        this.idDondathang = idDondathang;
    }

    @Column(name = "id_sanpham")
    @Id
    public int getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(int idSanpham) {
        this.idSanpham = idSanpham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblChitietdonhangEntityPK that = (TblChitietdonhangEntityPK) o;
        return idDondathang == that.idDondathang &&
                idSanpham == that.idSanpham;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDondathang, idSanpham);
    }
}
