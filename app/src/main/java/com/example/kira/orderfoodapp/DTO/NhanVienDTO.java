package com.example.kira.orderfoodapp.DTO;

/**
 * Created by KIRA on 10/11/2017.
 */

public class NhanVienDTO {

    int MANV,CMND;
    String TENDN,MATKHAU,GIOITINH,NGAYSINH;

    public int getMANV() {
        return MANV;
    }

    public NhanVienDTO(int MANV,  String TENDN, String MATKHAU, String GIOITINH, String NGAYSINH, int CMND) {
        this.MANV = MANV;
        this.CMND = CMND;
        this.TENDN = TENDN;
        this.MATKHAU = MATKHAU;
        this.GIOITINH = GIOITINH;
        this.NGAYSINH = NGAYSINH;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" +
                "MANV=" + MANV +
                ", CMND=" + CMND +
                ", TENDN='" + TENDN + '\'' +
                ", MATKHAU='" + MATKHAU + '\'' +
                ", GIOITINH='" + GIOITINH + '\'' +
                ", NGAYSINH='" + NGAYSINH + '\'' +
                '}';
    }
}
