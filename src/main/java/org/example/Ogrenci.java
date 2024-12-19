package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Ogrenci extends Kullanici {
    private ArrayList<Ders> aldigiDersler = new ArrayList<>();

    public Ogrenci(String ad, String soyad, String tip, String sifre) {
        super(ad, soyad, tip, sifre);
    }

    public void dersEkle(Ders ders) {
        aldigiDersler.add(ders);
    }

    public void ogrenciIslemleri() {
        System.out.println("Aldığınız dersler:");
        for (Ders ders : aldigiDersler) {
            System.out.println("Ders: " + ders.getDersAdi());
            ders.notGoruntule(this);
        }
    }
}