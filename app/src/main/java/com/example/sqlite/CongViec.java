package com.example.sqlite;

public class CongViec {
    private int idCV;
    private String TenCV;

    public CongViec() {
    }

    public CongViec(int idCV, String tenCV) {
        this.idCV = idCV;
        TenCV = tenCV;
    }

    public int getIdCV() {
        return idCV;
    }

    public void setIdCV(int idCV) {
        this.idCV = idCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String tenCV) {
        TenCV = tenCV;
    }
}
