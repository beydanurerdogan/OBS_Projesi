package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Giris {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kullanici> kullanicilar = new ArrayList<>();
        ArrayList<Ders> dersler = new ArrayList<>();

        Akademisyen akademisyen1 = new Akademisyen("AHMET", "YILMAZ", "Profesör", "1111");
        Akademisyen akademisyen2 = new Akademisyen("ELİF", "DEMİR", "Doçent", "2222");
        Ogrenci ogrenci1 = new Ogrenci("ALİ", "DEMİR", "Ön Lisans", "1414");
        Ogrenci ogrenci2 = new Ogrenci("MERVE", "YARTAS", "Lisans", "1515");

        kullanicilar.add(akademisyen1);
        kullanicilar.add(akademisyen2);
        kullanicilar.add(ogrenci1);
        kullanicilar.add(ogrenci2);

        Ders ders1 = new Ders("İNTERNET PROGRAMCILIĞI");
        Ders ders2 = new Ders("NESNE TABANLI PROGRAMLAMA");

        dersler.add(ders1);
        dersler.add(ders2);

        ders1.setAkademisyen(akademisyen1);
        ders2.setAkademisyen(akademisyen2);

        ders1.ogrenciEkle(ogrenci1);
        ders2.ogrenciEkle(ogrenci2);

        boolean cikis = false;
        while (!cikis) {
            System.out.println("1. Kullanıcı Girişi");
            System.out.println("2. Şifre Değiştir");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = Integer.parseInt(scanner.nextLine());

            switch (secim) {
                case 1:
                    login(kullanicilar);
                    break;
                case 2:
                    System.out.print("Kullanıcı Adı: ");
                    String kullaniciAdi = scanner.nextLine();
                    Kullanici bulunanKullanici = null;
                    for (Kullanici k : kullanicilar) {
                        if (k.ad.equalsIgnoreCase(kullaniciAdi)) {
                            bulunanKullanici = k;
                            break;
                        }
                    }
                    if (bulunanKullanici != null) {
                        System.out.print("Yeni Şifre: ");
                        String yeniSifre = scanner.nextLine();
                        bulunanKullanici.sifreDegistir(yeniSifre);
                    } else {
                        System.out.println("Kullanıcı bulunamadı.");
                    }
                    break;
                case 3:
                    cikis = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }

    private void login(ArrayList<Kullanici> kullanicilar) {
        Scanner scanner = new Scanner(System.in);
        Kullanici seciliKullanici = null;
        boolean kontrol = true;

        while (kontrol) {
            System.out.print("Kullanıcı adı: ");
            String kullaniciAdi = scanner.nextLine();
            System.out.print("Şifre: ");
            String sifre = scanner.nextLine();

            for (Kullanici k : kullanicilar) {
                if (k.ad.equalsIgnoreCase(kullaniciAdi) && k.sifre.equals(sifre)) {
                    seciliKullanici = k;
                    kontrol = false;
                    break;
                }
            }

            if (seciliKullanici == null) {
                System.out.println("Kullanıcı adı veya şifre hatalı!");
            }
        }

        if (seciliKullanici instanceof Akademisyen) {
            ((Akademisyen) seciliKullanici).akademisyenIslemleri();
        } else if (seciliKullanici instanceof Ogrenci) {
            ((Ogrenci) seciliKullanici).ogrenciIslemleri();
        }
    }
}

