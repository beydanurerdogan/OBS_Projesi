package org.example;

public class Kullanici {
    protected String ad;
    protected String soyad;
    protected String tip;
    protected String sifre;
    protected String ders;

    public Kullanici(String ad, String soyad, String tip, String sifre, String ders) {
        this.ad = ad;
        this.soyad = soyad;
        this.tip = tip;
        this.sifre = sifre;
        this.ders = ders;
    }
    public Kullanici(String ad, String soyad, String tip, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.tip = tip;
        this.sifre = sifre;

    }

    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Tip: " + tip;
    }

}
