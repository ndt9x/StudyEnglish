package com.example.kieutrang.database;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class Vocabulary {
    private int id;
    private String lesson, tenchu, phienam, nghia, vidu;

    public Vocabulary(String vidu, String nghia, String phienam, String tenchu, String lesson, int id) {
        super();
        this.vidu = vidu;
        this.nghia = nghia;
        this.phienam = phienam;
        this.tenchu = tenchu;
        this.lesson = lesson;
        this.id = id;
    }

    public Vocabulary() {
        super();
    }

    public Vocabulary(String lesson, String tenchu, String phienam, String nghia, String vidu) {
        super();
        this.lesson = lesson;
        this.tenchu = tenchu;
        this.phienam = phienam;
        this.nghia = nghia;
        this.vidu = vidu;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getPhienam() {
        return phienam;
    }

    public void setPhienam(String phienam) {
        this.phienam = phienam;
    }

    public String getTenchu() {

        return tenchu;
    }

    public void setTenchu(String tenchu) {
        this.tenchu = tenchu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVidu() {

        return vidu;
    }

    public void setVidu(String vidu) {
        this.vidu = vidu;
    }

    public String getNghia() {

        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
}
