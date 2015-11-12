package com.example.kieutrang.database;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class Extra {
    private int id;
    private String ten, noidung;

    public Extra() {
        super();
    }

    public Extra(int id, String ten, String noidung) {
        super();
        this.id = id;
        this.ten = ten;
        this.noidung = noidung;
    }

    public Extra(String ten, String noidung) {
        this.ten = ten;
        this.noidung = noidung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
