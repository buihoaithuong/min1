package com.example.min1;

public class thongtin {
    private  int idKH;
    private String ten;
    private String sdt;
    private String dichVu;
    private String uuTien;

    public thongtin(int idKH, String ten, String sdt, String dichVu, String uuTien) {
        this.idKH = idKH;
        this.ten = ten;
        this.sdt = sdt;
        this.dichVu = dichVu;
        this.uuTien = uuTien;
    }

    public thongtin(){};

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public String getUuTien() {
        return uuTien;
    }

    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }
}
