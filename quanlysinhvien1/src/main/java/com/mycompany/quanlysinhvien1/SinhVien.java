/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysinhvien1;

public class SinhVien {
    String maSV, hoTen, ngaySinh, gioiTinh, nganhHoc;
    float diemTB;

    public SinhVien(String maSV, String hoTen, String ngaySinh, String gioiTinh, float diemTB, String nganhHoc) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diemTB = diemTB;
        this.nganhHoc = nganhHoc;
    }

    public String toString() {
        return hoTen + "," + maSV + "," + ngaySinh + "," + gioiTinh + "," + diemTB + "," + nganhHoc;
    }
}
