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
public class Fold {
    
    private String Fold;
    private double akurasi;
    int K;

    public Fold(String Fold, int K,  double akurasi) {
        this.Fold = Fold;
        this.K = K;
        this.akurasi = akurasi;
    }

    public String getFold() {
        return Fold;
    }

    public void setFold(String Fold) {
        this.Fold = Fold;
    }

    public double getAkurasi() {
        return akurasi;
    }

    public void setAkurasi(double akurasi) {
        this.akurasi = akurasi;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }
    
    
    
    
    
    
}
