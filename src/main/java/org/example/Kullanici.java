package org.example;

public class Kullanici {
    protected String ad;
    protected String soyad;
    protected String tip;
    protected String sifre;

    public Kullanici(String ad, String soyad, String tip, String sifre) {
        this.ad = ad;
        this.soyad = soyad;
        this.tip = tip;
        this.sifre = sifre;
    }

    public void sifreDegistir(String yeniSifre) {
        this.sifre = yeniSifre;
        System.out.println("Şifre başarıyla değiştirildi.");
    }

    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Tip: " + tip;
    }
}
