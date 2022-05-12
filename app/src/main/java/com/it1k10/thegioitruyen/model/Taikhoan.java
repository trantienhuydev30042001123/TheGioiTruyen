package com.it1k10.thegioitruyen.model;

public class Taikhoan {

    //Khai báo biến
    private int mId;
    private String mTenTaikhoan;
    private String mMatKhau;
    private String mEmail;
    private int mPhanQuyen;

    //Hàm khỏi tạo
    public Taikhoan(String mTenTaikhoan, String mMatKhau, String mEmail, int mPhanQuyen) {
        this.mTenTaikhoan = mTenTaikhoan;
        this.mMatKhau = mMatKhau;
        this.mEmail = mEmail;
        this.mPhanQuyen = mPhanQuyen;
    }

    public Taikhoan(String mTenTaikhoan, String mEmail) {
        this.mTenTaikhoan = mTenTaikhoan;
        this.mEmail = mEmail;
    }

    //các getter và setter
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTenTaikhoan() {
        return mTenTaikhoan;
    }

    public void setmTenTaikhoan(String mTenTaikhoan) {
        this.mTenTaikhoan = mTenTaikhoan;
    }

    public String getmMatKhau() {
        return mMatKhau;
    }

    public void setmMatKhau(String mMatKhau) {
        this.mMatKhau = mMatKhau;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmPhanQuyen() {
        return mPhanQuyen;
    }

    public void setmPhanQuyen(int mPhanQuyen) {
        this.mPhanQuyen = mPhanQuyen;
    }
}
