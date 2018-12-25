package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_anh", schema = "dbo", catalog = "QuanLiDT")
public class TblAnhEntity {
    private int id;
    private String link;
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
    @Column(name = "link", nullable = true, length = 255)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        TblAnhEntity that = (TblAnhEntity) o;
        return id == that.id &&
                Objects.equals(link, that.link) &&
                Objects.equals(idSanpham, that.idSanpham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link, idSanpham);
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
