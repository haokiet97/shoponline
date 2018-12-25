package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_album_anh", schema = "dbo", catalog = "QuanLiDT")
public class TblAlbumAnhEntity {
    private int id;
    private String anh1;
    private String anh2;
    private String anh3;
    private String anh4;
    private Integer temp;
    private Integer idSanpham;
    private TblSanphamEntity tblSanphamByIdSanpham;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "anh1", nullable = true, length = 250)
    public String getAnh1() {
        return anh1;
    }

    public void setAnh1(String anh1) {
        this.anh1 = anh1;
    }

    @Basic
    @Column(name = "anh2", nullable = true, length = 250)
    public String getAnh2() {
        return anh2;
    }

    public void setAnh2(String anh2) {
        this.anh2 = anh2;
    }

    @Basic
    @Column(name = "anh3", nullable = true, length = 250)
    public String getAnh3() {
        return anh3;
    }

    public void setAnh3(String anh3) {
        this.anh3 = anh3;
    }

    @Basic
    @Column(name = "anh4", nullable = true, length = 250)
    public String getAnh4() {
        return anh4;
    }

    public void setAnh4(String anh4) {
        this.anh4 = anh4;
    }

    @Basic
    @Column(name = "temp", nullable = true)
    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @Basic
    @Column(name = "id_sanpham", nullable = true)
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
        TblAlbumAnhEntity that = (TblAlbumAnhEntity) o;
        return id == that.id &&
                Objects.equals(anh1, that.anh1) &&
                Objects.equals(anh2, that.anh2) &&
                Objects.equals(anh3, that.anh3) &&
                Objects.equals(anh4, that.anh4) &&
                Objects.equals(temp, that.temp) &&
                Objects.equals(idSanpham, that.idSanpham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anh1, anh2, anh3, anh4, temp, idSanpham);
    }

    @ManyToOne
    @JoinColumn(name = "id_sanpham", referencedColumnName = "id", insertable = false, updatable = false)
    public TblSanphamEntity getTblSanphamByIdSanpham() {
        return tblSanphamByIdSanpham;
    }

    public void setTblSanphamByIdSanpham(TblSanphamEntity tblSanphamByIdSanpham) {
        this.tblSanphamByIdSanpham = tblSanphamByIdSanpham;
    }
}
