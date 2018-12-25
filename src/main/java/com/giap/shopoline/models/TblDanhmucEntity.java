package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_danhmuc", schema = "dbo", catalog = "QuanLiDT")
public class TblDanhmucEntity {
    private int id;
    private String ten;
    private Collection<TblSanphamEntity> tblSanphamsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblDanhmucEntity that = (TblDanhmucEntity) o;
        return id == that.id &&
                Objects.equals(ten, that.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten);
    }

    @OneToMany(mappedBy = "tblDanhmucByIdDanhmuc")
    public Collection<TblSanphamEntity> getTblSanphamsById() {
        return tblSanphamsById;
    }

    public void setTblSanphamsById(Collection<TblSanphamEntity> tblSanphamsById) {
        this.tblSanphamsById = tblSanphamsById;
    }
}
