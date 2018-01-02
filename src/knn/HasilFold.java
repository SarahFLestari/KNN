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
public class HasilFold {
    private String berita;
    private int hoax;

    public HasilFold(String berita, int hoax) {
//        int x = Integer.valueOf(berita);
//        if (x >= 1 && x <= 9 ){
//            this.berita = "Berita000"+berita;
//        } else if (x >= 10 && x <= 99){
//            this.berita = "Berita00"+berita;
//        } else if (x >= 100 && x <= 999){
//            this.berita = "Berita0"+berita;
//        } else if (x >= 1000 && x <= 4000){
//            this.berita = berita;
//        }
        this.berita = berita;
        this.hoax = hoax;
    }

    public String getBerita() {
        return berita;
    }

    public void setBerita(String berita) {
        this.berita = berita;
    }

    public int getHoax() {
        return hoax;
    }

    public void setHoax(int hoax) {
        this.hoax = hoax;
    }

    @Override
    public String toString() {
        return "HasilFold{" + "berita=" + berita + ", hoax=" + hoax + '}';
    }
    
    
    
}
