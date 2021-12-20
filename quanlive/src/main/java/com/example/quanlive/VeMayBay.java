package com.example.quanlive;



public class VeMayBay {
    protected String tenNguoiMua;
    protected int soCMT;
    protected String noiDi;
    protected String noiDen;
    protected double quangDuong;
    protected String ngayGioBay;
    protected String ngayBanVe;
    protected String loaiVe;

    public VeMayBay(String tenNguoiMua, int soCMT, String noiDi, String noiDen, double quangDuong, String ngayGioBay, String ngayBanVe, String loaiVe) {
        this.tenNguoiMua = tenNguoiMua;
        this.soCMT = soCMT;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.quangDuong = quangDuong;
        this.ngayGioBay = ngayGioBay;
        this.ngayBanVe = ngayBanVe;
        this.loaiVe = loaiVe;
    }

    public VeMayBay() {
    }

    public String getTenNguoiMua() {
        return tenNguoiMua;
    }

    public void setTenNguoiMua(String tenNguoiMua) {
        this.tenNguoiMua = tenNguoiMua;
    }

    public int getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(int soCMT) {
        this.soCMT = soCMT;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public double getQuangDuong() {
        return quangDuong;
    }

    public void setQuangDuong(double quangDuong) {
        this.quangDuong = quangDuong;
    }

    public String getNgayGioBay() {
        return ngayGioBay;
    }

    public void setNgayGioBay(String ngayGioBay) {
        this.ngayGioBay = ngayGioBay;
    }

    public String getNgayBanVe() {
        return ngayBanVe;
    }

    public void setNgayBanVe(String ngayBanVe) {
        this.ngayBanVe = ngayBanVe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }
}
