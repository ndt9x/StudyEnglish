package com.example.database;

public class ExtraData {
	private String ten, noidung;
	private int id;

	public ExtraData(String ten, String noidung, int id) {
		super();
		this.ten = ten;
		this.noidung = noidung;
		this.id = id;
	}

	public ExtraData(String ten, String noidung) {
		super();
		this.ten = ten;
		this.noidung = noidung;
	}

	public ExtraData() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
