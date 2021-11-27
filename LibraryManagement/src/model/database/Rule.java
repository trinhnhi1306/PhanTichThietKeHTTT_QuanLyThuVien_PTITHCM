/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database;

/**
 *
 * @author TRINH
 */
public class Rule {
    
    private int maQuyDinh, soSachMuonToiDa, soNgayMuonToiDa, tienPhatQuaHan, tienPhatHongMat;
    private String ngayThayDoi;

    public Rule() {
    }

    public Rule(int maQuyDinh, int soNgayMuonToiDa, int soSachMuonToiDa, int tienPhatQuaHan, int tienPhatHongMat, String ngayThayDoi) {
        this.maQuyDinh = maQuyDinh;
        this.soSachMuonToiDa = soSachMuonToiDa;
        this.soNgayMuonToiDa = soNgayMuonToiDa;
        this.tienPhatQuaHan = tienPhatQuaHan;
        this.tienPhatHongMat = tienPhatHongMat;
        this.ngayThayDoi = ngayThayDoi;
    }

    public int getMaQuyDinh() {
        return maQuyDinh;
    }

    public void setMaQuyDinh(int maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }

    public int getSoSachMuonToiDa() {
        return soSachMuonToiDa;
    }

    public void setSoSachMuonToiDa(int soSachMuonToiDa) {
        this.soSachMuonToiDa = soSachMuonToiDa;
    }

    public int getSoNgayMuonToiDa() {
        return soNgayMuonToiDa;
    }

    public void setSoNgayMuonToiDa(int soNgayMuonToiDa) {
        this.soNgayMuonToiDa = soNgayMuonToiDa;
    }

    public int getTienPhatQuaHan() {
        return tienPhatQuaHan;
    }

    public void setTienPhatQuaHan(int tienPhatQuaHan) {
        this.tienPhatQuaHan = tienPhatQuaHan;
    }

    public int getTienPhatHongMat() {
        return tienPhatHongMat;
    }

    public void setTienPhatHongMat(int tienPhatHongMat) {
        this.tienPhatHongMat = tienPhatHongMat;
    }

    public String getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(String ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }
    
    
}
