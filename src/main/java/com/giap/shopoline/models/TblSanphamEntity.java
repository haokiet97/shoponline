package com.giap.shopoline.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tbl_sanpham", schema = "dbo", catalog = "QuanLiDT")
public class TblSanphamEntity {
    private int id;
    private Integer idDanhmuc;
    private String ten;
    private Integer gia;
    private Integer soluong;
    private String trongluong;
    private String rom;
    private String ram;
    private String thenho;
    private String cameraTruoc;
    private String cameraSau;
    private Integer pin;
    private String baohanh;
    private Integer bluetooth;
    private Integer idNhasanxuat;
    private String cpu;
    private String manhinh;
    private Integer status;
    private Collection<TblAlbumAnhEntity> tblAlbumAnhsById;
    private Collection<TblAnhEntity> tblAnhsById;
    private Collection<TblBinhluanEntity> tblBinhluansById;
    private Collection<TblChitietdonhangEntity> tblChitietdonhangsById;
    private TblDanhmucEntity tblDanhmucByIdDanhmuc;
    private TblNhasanxuatEntity tblNhasanxuatByIdNhasanxuat;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_danhmuc")
    public Integer getIdDanhmuc() {
        return idDanhmuc;
    }

    public void setIdDanhmuc(Integer idDanhmuc) {
        this.idDanhmuc = idDanhmuc;
    }

    @Basic
    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "gia")
    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    @Basic
    @Column(name = "soluong")
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Basic
    @Column(name = "trongluong")
    public String getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(String trongluong) {
        this.trongluong = trongluong;
    }

    @Basic
    @Column(name = "ROM")
    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    @Basic
    @Column(name = "RAM")
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Basic
    @Column(name = "thenho")
    public String getThenho() {
        return thenho;
    }

    public void setThenho(String thenho) {
        this.thenho = thenho;
    }

    @Basic
    @Column(name = "camera_truoc")
    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    @Basic
    @Column(name = "camera_sau")
    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    @Basic
    @Column(name = "pin")
    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "baohanh")
    public String getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(String baohanh) {
        this.baohanh = baohanh;
    }

    @Basic
    @Column(name = "bluetooth")
    public Integer getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Integer bluetooth) {
        this.bluetooth = bluetooth;
    }

    @Basic
    @Column(name = "id_nhasanxuat")
    public Integer getIdNhasanxuat() {
        return idNhasanxuat;
    }

    public void setIdNhasanxuat(Integer idNhasanxuat) {
        this.idNhasanxuat = idNhasanxuat;
    }

    @Basic
    @Column(name = "CPU")
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Basic
    @Column(name = "manhinh")
    public String getManhinh() {
        return manhinh;
    }

    public void setManhinh(String manhinh) {
        this.manhinh = manhinh;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblSanphamEntity that = (TblSanphamEntity) o;
        return id == that.id &&
                Objects.equals(idDanhmuc, that.idDanhmuc) &&
                Objects.equals(ten, that.ten) &&
                Objects.equals(gia, that.gia) &&
                Objects.equals(soluong, that.soluong) &&
                Objects.equals(trongluong, that.trongluong) &&
                Objects.equals(rom, that.rom) &&
                Objects.equals(ram, that.ram) &&
                Objects.equals(thenho, that.thenho) &&
                Objects.equals(cameraTruoc, that.cameraTruoc) &&
                Objects.equals(cameraSau, that.cameraSau) &&
                Objects.equals(pin, that.pin) &&
                Objects.equals(baohanh, that.baohanh) &&
                Objects.equals(bluetooth, that.bluetooth) &&
                Objects.equals(idNhasanxuat, that.idNhasanxuat) &&
                Objects.equals(cpu, that.cpu) &&
                Objects.equals(manhinh, that.manhinh) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDanhmuc, ten, gia, soluong, trongluong, rom, ram, thenho, cameraTruoc, cameraSau, pin, baohanh, bluetooth, idNhasanxuat, cpu, manhinh, status);
    }

    @OneToMany(mappedBy = "tblSanphamByIdSanpham")
    public Collection<TblAlbumAnhEntity> getTblAlbumAnhsById() {
        return tblAlbumAnhsById;
    }

    public void setTblAlbumAnhsById(Collection<TblAlbumAnhEntity> tblAlbumAnhsById) {
        this.tblAlbumAnhsById = tblAlbumAnhsById;
    }

    @OneToMany(mappedBy = "tblSanphamByIdSanpham")
    public Collection<TblAnhEntity> getTblAnhsById() {
        return tblAnhsById;
    }

    public void setTblAnhsById(Collection<TblAnhEntity> tblAnhsById) {
        this.tblAnhsById = tblAnhsById;
    }

    @OneToMany(mappedBy = "tblSanphamByIdSanpham")
    public Collection<TblBinhluanEntity> getTblBinhluansById() {
        return tblBinhluansById;
    }

    public void setTblBinhluansById(Collection<TblBinhluanEntity> tblBinhluansById) {
        this.tblBinhluansById = tblBinhluansById;
    }

    @OneToMany(mappedBy = "tblSanphamByIdSanpham")
    public Collection<TblChitietdonhangEntity> getTblChitietdonhangsById() {
        return tblChitietdonhangsById;
    }

    public void setTblChitietdonhangsById(Collection<TblChitietdonhangEntity> tblChitietdonhangsById) {
        this.tblChitietdonhangsById = tblChitietdonhangsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_danhmuc", referencedColumnName = "id")
    public TblDanhmucEntity getTblDanhmucByIdDanhmuc() {
        return tblDanhmucByIdDanhmuc;
    }

    public void setTblDanhmucByIdDanhmuc(TblDanhmucEntity tblDanhmucByIdDanhmuc) {
        this.tblDanhmucByIdDanhmuc = tblDanhmucByIdDanhmuc;
    }

    @ManyToOne
    @JoinColumn(name = "id_nhasanxuat", referencedColumnName = "id")
    public TblNhasanxuatEntity getTblNhasanxuatByIdNhasanxuat() {
        return tblNhasanxuatByIdNhasanxuat;
    }

    public void setTblNhasanxuatByIdNhasanxuat(TblNhasanxuatEntity tblNhasanxuatByIdNhasanxuat) {
        this.tblNhasanxuatByIdNhasanxuat = tblNhasanxuatByIdNhasanxuat;
    }
}
