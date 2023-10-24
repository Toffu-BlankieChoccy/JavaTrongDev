package com.mechtrong.redobmicalculator;

public class Meal {
    private String tenMonAn;
    private int giaMonAn;
    private int anhMonAn;
    private String moTaMonAn;

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getGiaMonAn() {
        return giaMonAn;
    }

    public void setGiaMonAn(int giaMonAn) {
        this.giaMonAn = giaMonAn;
    }

    public int getAnhMonAn() {
        return anhMonAn;
    }

    public void setAnhMonAn(int anhMonAn) {
        this.anhMonAn = anhMonAn;
    }

    public String getMoTaMonAn() {
        return moTaMonAn;
    }

    public void setMoTaMonAn(String moTaMonAn) {
        this.moTaMonAn = moTaMonAn;
    }

    public Meal(String tenMonAn, int giaMonAn, int anhMonAn, String moTaMonAn) {
        this.tenMonAn = tenMonAn;
        this.giaMonAn = giaMonAn;
        this.anhMonAn = anhMonAn;
        this.moTaMonAn = moTaMonAn;
    }
}
