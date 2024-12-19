package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Akademisyen extends Kullanici {
    private ArrayList<Ders> verdigiDersler = new ArrayList<>();

    public Akademisyen(String ad, String soyad, String tip, String sifre) {
        super(ad, soyad, tip, sifre);
    }

    public void dersEkle(Ders ders) {
        verdigiDersler.add(ders);
    }

    public void akademisyenIslemleri() {
        Scanner scanner = new Scanner(System.in);
        boolean devam = true;

        while (devam) {
            System.out.println("Dersleriniz:");
            for (int i = 0; i < verdigiDersler.size(); i++) {
                System.out.println((i + 1) + ". " + verdigiDersler.get(i).getDersAdi());
            }

            System.out.print("Not girişi yapmak istediğiniz dersi seçin: ");
            int secim = Integer.parseInt(scanner.nextLine()) - 1;

            if (secim >= 0 && secim < verdigiDersler.size()) {
                Ders seciliDers = verdigiDersler.get(secim);
                seciliDers.notGirisi(this);
            } else {
                System.out.println("Geçersiz seçim.");
            }

            System.out.print("Başka bir işlem yapmak ister misiniz? (E/H): ");
            String devamCevap = scanner.nextLine();
            devam = devamCevap.equalsIgnoreCase("E");
        }
    }
}