package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Giris {

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kullanici> kullanicilar = new ArrayList<>();



        kullanicilar.add(new Akademisyen("AHMET", "YILMAZ", "Profesör", "1111","İNTERNET PROGRAMCILIĞI"));
        kullanicilar.add(new Akademisyen("ELİF", "DEMİR", "Profesör", "2222","NESNE TABANLI PROGRAMLAMA"));
        kullanicilar.add(new Akademisyen("BELGİN", "AKGÖL", "Profesör", "3333","VERİTABANI VE YÖNETİMİ"));
        kullanicilar.add(new Akademisyen("FATMA", "AYDIN", "Profesör", "4444","GÖRSEL PROGRAMLAMA"));
        kullanicilar.add(new Akademisyen("HASAN", "ÖZTÜRK", "Profesör", "5555","İNGİLİZCE"));
        kullanicilar.add(new Akademisyen("EMRE", "CAN", "Profesör", "6666","SANALLAŞTIRMA VE BULUT BİLİŞİM SİSTEMLERİ"));
        kullanicilar.add(new Akademisyen("MEHMET", "KARA", "Doçent", "7777","İLERİ PROGRAMLAMA"));
        kullanicilar.add(new Akademisyen("ERTUĞRUL", "DUMAN", "Doçent", "8888","DATA STRUCTURES"));
        kullanicilar.add(new Akademisyen("GÖKHAN", "ARSLAN", "Doçent", "9999","OLASILIK VE İSTATİSTİK"));
        kullanicilar.add(new Akademisyen("MELİKE", "ÇOBAN", "Doçent", "1010","ELEKTRİK VE ELEKTRONİK DEVRELER"));
        kullanicilar.add(new Akademisyen("SELİN", "YÜCEL", "Doçent", "1212","DIFFERENTIAL EQUATIONS"));
        kullanicilar.add(new Akademisyen("BURAK", "KESKİN", "Doçent", "1313","ACADEMIC ENGLISH"));
        kullanicilar.add(new Ogrenci("ALİ", "DEMİR", "Ön Lisans", "1414"));
        kullanicilar.add(new Ogrenci("MERVE", "YARTAS", "Ön Lisans", "1515"));
        kullanicilar.add(new Ogrenci("ELİF", "KARAPINAR", "Lisans", "1616"));
        kullanicilar.add(new Ogrenci("AYŞE", "ÇELİK", "Lisans", "1717"));

        while (true) {
            System.out.println("1 -> Akademisyen Giriş");
            System.out.println("2 -> Öğrenci Giriş");
            System.out.println("3 -> Çıkış");
            System.out.print("Seçiminiz: ");
            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    new Akademisyen("", "", "", "","").akademisyenGiris(kullanicilar, kullanicilar);
                    break;
                case "2":
                    new Ogrenci("", "", "", "").ogrenciGiris(kullanicilar);
                    break;
                case "3":
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }
    }
}

