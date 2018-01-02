/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.Comparator;

/**
 *
 * @author MBP
 */
public class BFold implements Comparable<BFold> {
    private String Berita;
    private double distance;
    private int hoax;

    public BFold(String Berita, double distance, int hoax) {
        this.Berita = Berita;
        this.distance = distance;
        this.hoax = hoax;
    }

    public String getBerita() {
        return Berita;
    }

    public void setBerita(String Berita) {
        this.Berita = Berita;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getHoax() {
        return hoax;
    }

    public void setHoax(int hoax) {
        this.hoax = hoax;
    }
    
//    public double compareTo(BFold sort) {
//        double compareDest=((BFold)sort).getDistance();
//        /* For Ascending order*/
//        return this.distance-compareDest;
//    }
    public static class OrderByDistance implements Comparator<BFold>{

        @Override
        public int compare(BFold o1, BFold o2) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return o1.distance > o2.distance ? 1 : (o1.distance < o2.distance ? -1 : 0);
        }
        
    }

    @Override
    public int compareTo(BFold o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
