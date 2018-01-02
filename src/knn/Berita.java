/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

/**
 *
 * @author MBP
 */
public class Berita {
    private String berita;
    private double like;
    private double provokasi;
    private double komentar;
    private double emosi;
    private int hoax;

    public Berita(String berita, double like, double provokasi, double komentar, double emosi, int hoax) {
        this.berita = berita;
        this.like = like;
        this.provokasi = provokasi;
        this.komentar = komentar;
        this.emosi = emosi;
        this.hoax = hoax;
    }

    public String getBerita() {
        return berita;
    }

    public void setBerita(String berita) {
        this.berita = berita;
    }

    public double getLike() {
        return like;
    }

    public void setLike(double like) {
        this.like = like;
    }

    public double getProvokasi() {
        return provokasi;
    }

    public void setProvokasi(double provokasi) {
        this.provokasi = provokasi;
    }

    public double getKomentar() {
        return komentar;
    }

    public void setKomentar(double komentar) {
        this.komentar = komentar;
    }

    public double getEmosi() {
        return emosi;
    }

    public void setEmosi(double emosi) {
        this.emosi = emosi;
    }

    public int getHoax() {
        return hoax;
    }

    public void setHoax(int hoax) {
        this.hoax = hoax;
    }

    @Override
    public String toString() {
        return "Berita{" + "berita=" + berita + ", like=" + like + ", provokasi=" + provokasi + ", komentar=" + komentar + ", emosi=" + emosi + ", hoax=" + hoax + '}';
    }
    
    
    
    
}
