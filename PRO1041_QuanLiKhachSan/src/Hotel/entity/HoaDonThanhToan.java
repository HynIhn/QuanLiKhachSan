/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDonThanhToan {

    private String MaHD;
    private int MaDP;
    private String MaNV;
    private String MaKH;
    private Date NgayThue;
    private Date NgayTraD;
    private Date ngayLap;
    private float thanhTien;
    
   @Override
    public String toString() {
        return this.ngayLap + " (" + this.ngayLap + ")";
    }

    public HoaDonThanhToan() {
    }
    
    public HoaDonThanhToan(String MaHD, int MaDP, String MaNV, String MaKH, Date NgayThue, Date NgayTraD, Date ngayLap, float thanhTien) {
        this.MaHD = MaHD;
        this.MaDP = MaDP;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayThue = NgayThue;
        this.NgayTraD = NgayTraD;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
    }

    

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaDP() {
        return MaDP;
    }

    public void setMaDP(int MaDP) {
        this.MaDP = MaDP;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public Date getNgayTraD() {
        return NgayTraD;
    }

    public void setNgayTraD(Date NgayTraD) {
        this.NgayTraD = NgayTraD;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }   
}
