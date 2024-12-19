package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ders {
    private String dersAdi;
    private Akademisyen akademisyen;
    private ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    private Map<Ogrenci, Integer> notlar = new HashMap<>();

    public Ders(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setAkademisyen(Akademisyen akademisyen) {
        this.akademisyen = akademisyen;
        akademisyen.dersEkle(this);
    }

    public void ogrenciEkle(Ogrenci ogrenci) {
        ogrenciler.add(ogrenci);
        ogrenci.dersEkle(this);
    }

    public void notGirisi(Akademisyen akademisyen) {
        if (this.akademisyen != akademisyen) {
            System.out.println("Bu dersi yalnızca atanmış akademisyen yönetebilir.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ders: " + dersAdi);
        for (int i = 0; i < ogrenciler.size(); i++) {
            System.out.println((i + 1) + ". " + ogrenciler.get(i).ad + " " + ogrenciler.get(i).soyad);
        }

        System.out.print("Not girişi yapmak istediğiniz öğrenciyi seçin: ");
        int secim = Integer.parseInt(scanner.nextLine()) - 1;

        if (secim >= 0 && secim < ogrenciler.size()) {
            Ogrenci seciliOgrenci = ogrenciler.get(secim);
            System.out.print("Notu girin: ");
            int not = Integer.parseInt(scanner.nextLine());

            if (not >= 0 && not <= 100) {
                notlar.put(seciliOgrenci, not);
                System.out.println("Not başarıyla girildi.");
            } else {
                System.out.println("Not 0 ile 100 arasında olmalıdır.");
            }
        } else {
            System.out.println("Geçersiz seçim.");
        }
    }

    public void notGoruntule(Ogrenci ogrenci) {
        if (notlar.containsKey(ogrenci)) {
            System.out.println("Not: " + notlar.get(ogrenci));
        } else {
            System.out.println("Henüz not girilmemiş.");
        }
    }
}
