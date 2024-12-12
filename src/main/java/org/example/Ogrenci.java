package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Ogrenci extends Kullanici{

    NotYonetimi not = new NotYonetimi();

    public Ogrenci(String ad, String soyad, String tip, String sifre) {
        super(ad, soyad, tip, sifre);
    }

    public void ogrenciGiris(ArrayList<Kullanici> ogrenciler) {
        Scanner scanner = new Scanner(System.in);
        Kullanici seciliOgrenci = null;
        String kullanıcı = "";
        boolean ogrkontrol =true;
        while (ogrkontrol) {
            System.out.print("Kullanıcı adı: ");
            kullanıcı = scanner.nextLine();
            System.out.print("Şifre: ");
            String parola = scanner.nextLine();

            for (Kullanici o : ogrenciler) {
                if (o.ad.equalsIgnoreCase(kullanıcı) || o.sifre.equalsIgnoreCase(parola)) {
                    seciliOgrenci = o;
                }
            }
            if (!seciliOgrenci.ad.equalsIgnoreCase(kullanıcı) || !seciliOgrenci.sifre.equalsIgnoreCase(parola)) {
                System.out.println("Kullanıcı adı yada şifre hatalı!");

            }else {
                ogrkontrol = false;
            }
        }
        Ogrenci sogrenci = (Ogrenci)seciliOgrenci;
        not.notgoruntule(sogrenci,kullanıcı);

    }
}
