package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_nhasanxuat", schema = "dbo", catalog = "QuanLiDT")
public class TblNhasanxuatEntity {
    private int id;
    private String ten;
    private Collection<TblSanphamEntity> tblSanphamsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblNhasanxuatEntity that = (TblNhasanxuatEntity) o;
        return id == that.id &&
                Objects.equals(ten, that.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten);
    }

    @OneToMany(mappedBy = "tblNhasanxuatByIdNhasanxuat")
    public Collection<TblSanphamEntity> getTblSanphamsById() {
        return tblSanphamsById;
    }

    public void setTblSanphamsById(Collection<TblSanphamEntity> tblSanphamsById) {
        this.tblSanphamsById = tblSanphamsById;
    }
}
