/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author MBP
 */
public class main {
    
    private static ArrayList<Berita> daftarBeritaTrain = new ArrayList<>();
    private static ArrayList<Berita> daftarBeritaTest = new ArrayList<>();
    private static ArrayList<Fold> listFold = new ArrayList<>();
    private static double[] AvrgList = new double[100];
    //private ArrayList<BFold> daftarDistance = new ArrayList<>();
    
    private static ArrayList<HasilFold> daftarHasilFold1 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold2 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold3 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold4 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold5 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold6 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold7 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold8 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold9 = new ArrayList<>();
    private static ArrayList<HasilFold> daftarHasilFold10 = new ArrayList<>();
     private static ArrayList<HasilFold> daftarHasilForTest = new ArrayList<>();
    //private static int K = 9;

    public main() {
       
        
    }
    public static void main(String[] args) {
        isiData();
        isiDataTest();
        //Fold 1 Testing 1-400, 401-4000
      // for (int K = 3; K < 400; K+=2) {
      int K = 79; //setelah melakukan looping didapat ini, ga looping lagi soalnya lama hehe ada di dokumen bukti runnningnya :)
            System.out.println("K = "+K);
            Fold1(0,400,400,4000, K);
            double b = akurasiFold1();
            String f1 = "Fold 1";
            Fold fld = new Fold(f1,K,b);
            listFold.add(fld);
            //Fold 2 Testing 401-800, 1-400 & 801-4000
            Fold2(400,800,0,400,800,4000,K);
            double c = akurasiFold2();
            String f2 = "Fold 2";
            Fold fld2 = new Fold(f2,K,c);
            listFold.add(fld2);
            //Fold 3 Testing 801-1200, 1-800 & 1201-4000 
            Fold3(800,1200,0,800,1200,4000,K);
            double d = akurasiFold3();
            String f3 = "Fold 3";
            Fold fld3 = new Fold(f3,K,d);
            listFold.add(fld3);
            //Fold 4 Testing 1201 - 1600, 1-1200 & 1601-4000
            Fold4(1200,1600,0,1200,1600,4000,K);
            double e = akurasiFold4();
            String f4 = "Fold 4";
            Fold fld4 = new Fold(f4,K,e);
            listFold.add(fld4);
            //Fold 5 Testing 1601 - 2000, 1-1600 & 2001-4000
            Fold5(1600,2000,0,1600,2000,4000,K);
            double f = akurasiFold5();
            String f5 = "Fold 5";
            Fold fld5 = new Fold(f5,K,f);
            listFold.add(fld5);
            //Fold 6 Testing 2001-2400, 1-2000 & 2401-4000
            Fold6(2000,2400,0,2000,2400,4000,K);
            double g = akurasiFold6();
            String f6 = "Fold 6";
            Fold fld6 = new Fold(f6,K,g);
            listFold.add(fld6);
            //Fold 7 Testing 2401-2800, 1-2400 & 2801-4000
            Fold7(2400,2800,0,2400,2800,4000,K);
            double h = akurasiFold7();
            String f7 = "Fold 7";
            Fold fld7 = new Fold(f7,K,h);
            listFold.add(fld7);
            //Fold 8 Testing 2801-3200, 1-2800 & 3201-4000
            Fold8(2800,3200,0,2800,3200,4000,K);
            double i = akurasiFold8();
            String f8 = "Fold 8";
            Fold fld8 = new Fold(f8,K,i);
            listFold.add(fld8);
            //Fold 9 Testing 3201-3600, 1-3200 & 3601 -4000
            Fold9(3200,3600,0,3200,3600,4000,K);
            double j = akurasiFold9();
            String f9 = "Fold 9";
            Fold fld9 = new Fold(f9,K,j);
            listFold.add(fld9);
             //Fold 10 Testing 3601-4000, 1-3600
            Fold10(3600,4000,0,3600,K);
            double a = akurasiFold10();
            String f10 = "Fold 10";
            Fold fld10 = new Fold(f10,K,a);
            listFold.add(fld10);
            resetList();
            
            untukTest(0,1000,0,4000,K);
            for (int k = 0; k < daftarBeritaTest.size(); k++) {
                System.out.println(daftarBeritaTest.get(k).getBerita());
                System.out.print(" Like     : "+daftarBeritaTest.get(k).getLike());
                System.out.print(" Provokasi: "+daftarBeritaTest.get(k).getProvokasi());
                System.out.print(" Komentar : "+daftarBeritaTest.get(k).getKomentar());
                System.out.print(" Emosi    : "+daftarBeritaTest.get(k).getEmosi());
                System.out.print(" Hoax     : "+daftarBeritaTest.get(k).getHoax());
                System.out.println();
                
            
            }
            
            
            //System.out.println("Akurasi Rata-Rata K-"+K+" :"+akurasiAvg(a,b,c,d,e,f,g,h,i,j));  
            
        
        //}
//        for (int i = 0; i < listFold.size(); i++) {
//            System.out.println("Fold    : "+listFold.get(i).getFold());
//            System.out.println("Akurasi : "+listFold.get(i).getAkurasi());
//            System.out.println("K       : "+listFold.get(i).getK());
//            
//        }
    }
    
    public static void isiData() {
        
        File excelFile = new File("Datatrain.xls");

        if (excelFile.exists()) {
            try {
                Workbook workbook = Workbook.getWorkbook(excelFile);
                Sheet sheet = workbook.getSheets()[0];

                TableModel model = new DefaultTableModel(sheet.getRows(), sheet.getColumns());
                for (int row = 1; row < sheet.getRows(); row++) {
                    //for (int column = 0; column < sheet.getColumns(); column++) {
                        int kolom = 0;
                        String berita = sheet.getCell(kolom, row).getContents();
                        kolom++;
                        double like = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double prov = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double koment = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double emosi = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        int hoax = Integer.parseInt(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        Berita b = new Berita(berita,like,prov,koment,emosi,hoax);
                        daftarBeritaTrain.add(b);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e);
                }
        } else {
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
    }
    
    public static void isiDataTest() {
        
        File excelFile = new File("Datatest.xls");

        if (excelFile.exists()) {
            try {
                Workbook workbook = Workbook.getWorkbook(excelFile);
                Sheet sheet = workbook.getSheets()[0];

                TableModel model = new DefaultTableModel(sheet.getRows(), sheet.getColumns());
                for (int row = 1; row < sheet.getRows(); row++) {
                    //for (int column = 0; column < sheet.getColumns(); column++) {
                        int kolom = 0;
                        String berita = sheet.getCell(kolom, row).getContents();
                        kolom++;
                        double like = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double prov = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double koment = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        double emosi = Double.parseDouble(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        int hoax = Integer.parseInt(sheet.getCell(kolom, row).getContents());
                        kolom++;
                        Berita b = new Berita(berita,like,prov,koment,emosi,hoax);
                        daftarBeritaTest.add(b);
                }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e);
                }
        } else {
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
    }
    
    static double nilaiEuclidian(double x1,double x2, double y1,double y2, double z1, double z2, double a1, double a2){
        double euclid = 0;
        euclid = sqrt(pow((x2-x1),2)+pow((y2-y1),2)+pow((z2-z1),2)+pow((a2-a1),2));
        return euclid;
    }
    
    public static int tentukanK(ArrayList<BFold> arr, int k){
        //int l = 0;
        int HoaxYa = 0;
        int HoaxTidak = 0;
        int hoax = 0;
        for (int i = 0; i < k ; i++) {
            //l = arr.get(i).getHoax();
            if ( arr.get(i).getHoax() == 1 ){
                HoaxYa++;
            } else if (arr.get(i).getHoax() == 0){
               HoaxTidak++;
            }
        }
        if (HoaxYa > HoaxTidak){
            hoax = 1;
        } else if (HoaxYa < HoaxTidak){
            hoax = 0;
        } else if (HoaxYa == HoaxTidak){
            hoax = -1;
        }
        return hoax;
    }
    public static double akurasiAvg(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j){
        double Avg = (a + b + c + d + e + f + g + h + i + j)/10;
        
        return Avg;
        
    }
    public static double akurasiFold1(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold1.size(); i++) {
            if (daftarHasilFold1.get(i).getHoax() == (daftarBeritaTrain.get(i).getHoax())){
//                System.out.println(daftarHasilFold1.get(i).getBerita());
//                System.out.println(daftarBeritaTrain.get(i).getBerita());
//                    
                dataBenar++; 
            } 
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    
    public static double akurasiFold10(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold10.size(); i++) {
            if (daftarHasilFold10.get(i).getHoax() == (daftarBeritaTrain.get(i+3600).getHoax())){
                
                dataBenar++; 
            } 
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold2(){
        double dataBenar = 0;
        double jumlahData = 400;
        for (int i = 0; i < daftarHasilFold2.size(); i++) {
            if (daftarHasilFold2.get(i).getHoax() == daftarBeritaTrain.get(i+400).getHoax()){
                dataBenar++; 
            }
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold3(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold3.size(); i++) {
            if (daftarHasilFold3.get(i).getHoax() == (daftarBeritaTrain.get(i+800).getHoax())){
                dataBenar++; 
            }
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold4(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold4.size(); i++) {
            if (daftarHasilFold4.get(i).getHoax() == (daftarBeritaTrain.get(i+1200).getHoax())){
                dataBenar++; 
            }   
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold5(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold5.size(); i++) {
            if (daftarHasilFold5.get(i).getHoax() == (daftarBeritaTrain.get(i+1600).getHoax())){
                dataBenar++; 
            } 
            
        }
        double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold6(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold6.size(); i++) {
            if (daftarHasilFold6.get(i).getHoax() == (daftarBeritaTrain.get(i+2000).getHoax())){
                dataBenar++; 
            }  
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public  static double akurasiFold7(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold7.size(); i++) {
            if (daftarHasilFold7.get(i).getHoax() == (daftarBeritaTrain.get(i+2400).getHoax())){
                dataBenar++; 
            }
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public  static double akurasiFold8(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold8.size(); i++) {
            if (daftarHasilFold8.get(i).getHoax() == (daftarBeritaTrain.get(i+2800).getHoax())){
                dataBenar++; 
            }
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    public static double akurasiFold9(){
        double dataBenar = 0;
        double jumlahData = 400;
        
        for (int i = 0; i < daftarHasilFold9.size(); i++) {
            if (daftarHasilFold9.get(i).getHoax() == (daftarBeritaTrain.get(i+3200).getHoax())){
                dataBenar++; 
            } 
            
        }
            double akurasi  = (dataBenar/jumlahData)*100;
        return akurasi;
    }
    
    public static void Fold1(int i, int j, int a, int b, int K){
    ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
        //for(int c=1;c<=5;c++){
        for (int k = i; k < j; k++) {        
            x1 = daftarBeritaTrain.get(k).getLike();
            y1 = daftarBeritaTrain.get(k).getProvokasi();
            z1 = daftarBeritaTrain.get(k).getKomentar();
            a1 = daftarBeritaTrain.get(k).getEmosi();
                    //System.out.println("Testing Berita ke: "+(k+1));
            String l = daftarBeritaTrain.get(k).getBerita();
            for (int d = a; d < b; d++){
                x2 = daftarBeritaTrain.get(d).getLike();
                y2 = daftarBeritaTrain.get(d).getProvokasi();
                z2 = daftarBeritaTrain.get(d).getKomentar();
                a2 = daftarBeritaTrain.get(d).getEmosi();
                hoax = daftarBeritaTrain.get(d).getHoax();
                nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                String noberita = daftarBeritaTrain.get(d).getBerita();
                BFold dis= new BFold(noberita,nilai,hoax);
                daftarDistance.add(dis);
                            //System.out.println(nilai);          
                } 
                Collections.sort(daftarDistance, new BFold.OrderByDistance());
                int nilaihoax = tentukanK(daftarDistance,K);
                HasilFold hasil = new HasilFold(l,nilaihoax);
                daftarHasilFold1.add(hasil);
                daftarDistance.removeAll(daftarDistance);
       }    
    }
    
    public static void Fold2 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold2.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                }  
        
    }
        public static void Fold3 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold3.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
    }
    public static void Fold4 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold4.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
    }
    public static void Fold5 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold5.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
        
    }
    public static void Fold6 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold6.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                }  
        
    }
    public static void Fold7 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold7.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
        
    }
    public static void Fold8 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k <  q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d <  s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold8.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
        
    }
    public static void Fold9 (int p, int q, int r, int s, int t, int u, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
            for (int k = p; k < q;k++) {           
                x1 = daftarBeritaTrain.get(k).getLike();
                y1 = daftarBeritaTrain.get(k).getProvokasi();
                z1 = daftarBeritaTrain.get(k).getKomentar();
                a1 = daftarBeritaTrain.get(k).getEmosi();
                String l = daftarBeritaTrain.get(k).getBerita();
                    for (int d = r; d < s; d++) {
                        x2 = daftarBeritaTrain.get(d).getLike();
                        y2 = daftarBeritaTrain.get(d).getProvokasi();
                        z2 = daftarBeritaTrain.get(d).getKomentar();
                        a2 = daftarBeritaTrain.get(d).getEmosi();
                        hoax = daftarBeritaTrain.get(d).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(d).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);
                    }
                    for (int e = t; e< u; e++){
                        x2 = daftarBeritaTrain.get(e).getLike();
                        y2 = daftarBeritaTrain.get(e).getProvokasi();
                        z2 = daftarBeritaTrain.get(e).getKomentar();
                        a2 = daftarBeritaTrain.get(e).getEmosi();
                        hoax = daftarBeritaTrain.get(e).getHoax();
                        nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                        String noberita = daftarBeritaTrain.get(e).getBerita();
                        BFold dis= new BFold(noberita,nilai,hoax);
                        daftarDistance.add(dis);    
                            //System.out.println(nilai);
                    }     
                    Collections.sort(daftarDistance, new BFold.OrderByDistance());

                    int nilaihoax = tentukanK(daftarDistance,K);
                    HasilFold hasil = new HasilFold(l,nilaihoax);
                    daftarHasilFold9.add(hasil); 
                    daftarDistance.removeAll(daftarDistance);
                } 
        
    }    
    public static void Fold10(int i, int j, int a, int b, int K){
        ArrayList<BFold> daftarDistance = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
        //for(int c=1;c<=5;c++){
        for (int k = i; k < j; k++) {        
            x1 = daftarBeritaTrain.get(k).getLike();
            y1 = daftarBeritaTrain.get(k).getProvokasi();
            z1 = daftarBeritaTrain.get(k).getKomentar();
            a1 = daftarBeritaTrain.get(k).getEmosi();
                    //System.out.println("Testing Berita ke: "+(k+1));
            String l = daftarBeritaTrain.get(k).getBerita();
            for (int d = a; d < b; d++){
                x2 = daftarBeritaTrain.get(d).getLike();
                y2 = daftarBeritaTrain.get(d).getProvokasi();
                z2 = daftarBeritaTrain.get(d).getKomentar();
                a2 = daftarBeritaTrain.get(d).getEmosi();
                hoax = daftarBeritaTrain.get(d).getHoax();
                nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                String noberita = daftarBeritaTrain.get(d).getBerita();
                BFold dis= new BFold(noberita,nilai,hoax);
                daftarDistance.add(dis);
                            //System.out.println(nilai);          
                } 
                Collections.sort(daftarDistance, new BFold.OrderByDistance());
                int nilaihoax = tentukanK(daftarDistance,K);
                HasilFold hasil = new HasilFold(l,nilaihoax);
                daftarHasilFold10.add(hasil);
                daftarDistance.removeAll(daftarDistance);
       }
    }
    
    public static void resetList(){
        daftarHasilFold1.removeAll(daftarHasilFold1);
        daftarHasilFold2.removeAll(daftarHasilFold2);
        daftarHasilFold3.removeAll(daftarHasilFold3);
        daftarHasilFold4.removeAll(daftarHasilFold4);
        daftarHasilFold5.removeAll(daftarHasilFold5);
        daftarHasilFold6.removeAll(daftarHasilFold6);
        daftarHasilFold7.removeAll(daftarHasilFold7);
        daftarHasilFold8.removeAll(daftarHasilFold8);
        daftarHasilFold9.removeAll(daftarHasilFold9);
        daftarHasilFold10.removeAll(daftarHasilFold10);
        
    }
    
    public static void untukTest(int a, int b, int c, int d, int K){
        ArrayList<BFold> DistanceForTest = new ArrayList<>();
        double x1=0;
        double y1=0;
        double z1=0;
        double a1=0;
        double x2=0;
        double y2=0;
        double z2=0;
        double a2=0;
        int hoax;
        double nilai = 0;
        //for(int c=1;c<=5;c++){
        for (int k = a; k < b; k++) {        
            x1 = daftarBeritaTest.get(k).getLike();
            y1 = daftarBeritaTest.get(k).getProvokasi();
            z1 = daftarBeritaTest.get(k).getKomentar();
            a1 = daftarBeritaTest.get(k).getEmosi();
                    //System.out.println("Testing Berita ke: "+(k+1));
            String l = daftarBeritaTest.get(k).getBerita();
            for (int j = c; j < d; j++){
                x2 = daftarBeritaTrain.get(j).getLike();
                y2 = daftarBeritaTrain.get(j).getProvokasi();
                z2 = daftarBeritaTrain.get(j).getKomentar();
                a2 = daftarBeritaTrain.get(j).getEmosi();
                hoax = daftarBeritaTrain.get(j).getHoax();
                nilai = nilaiEuclidian(x1,x2,y1,y2,z1,z2,a1,a2);
                String noberita = daftarBeritaTrain.get(j).getBerita();
                BFold dis= new BFold(noberita,nilai,hoax);
                DistanceForTest.add(dis);
                            //System.out.println(nilai);          
                } 
                Collections.sort(DistanceForTest, new BFold.OrderByDistance());
                int nilaihoax = tentukanK(DistanceForTest,K);
                daftarBeritaTest.get(k).setHoax(nilaihoax);
                DistanceForTest.removeAll(DistanceForTest); 
       }
    }
          
} 
