package com.giap.shopoline.models;

public class CartItem {
    private TblSanphamEntity SanPham;
    private int Count;

    public CartItem() {

    }

    public CartItem(TblSanphamEntity sanpham, int Count) {
        this.SanPham = sanpham;
        this.Count = Count;
    }

    public TblSanphamEntity getSanPham() {
        return SanPham;
    }

    public void setSanPham(TblSanphamEntity sanPham) {
        SanPham = sanPham;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }
}
