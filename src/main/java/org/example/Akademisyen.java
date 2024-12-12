package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Akademisyen extends Kullanici{
    NotYonetimi not = new NotYonetimi();

    public Akademisyen(String ad, String soyad, String tip, String sifre,String ders) {
        super(ad, soyad, tip, sifre,ders);
    }

    public void akademisyenGiris(ArrayList<Kullanici> akademisyenler, ArrayList<Kullanici> ogrenciler) {

        Scanner scanner = new Scanner(System.in);
        Kullanici seciliakademisyenler = null;
        String kullanıcı="";
        boolean akdkontrol =true;
        while(akdkontrol) {

            System.out.print("Kullanıcı adı: ");
            kullanıcı = scanner.nextLine();
            System.out.print("Şifre: ");
            String parola = scanner.nextLine();


            for (Kullanici a : akademisyenler) {
                if (a.ad.equalsIgnoreCase(kullanıcı) || a.sifre.equalsIgnoreCase(parola)) {
                    seciliakademisyenler = a;
                }
            }
            if (!seciliakademisyenler.ad.equalsIgnoreCase(kullanıcı) || !seciliakademisyenler.sifre.equalsIgnoreCase(parola)) {
                System.out.println("Kullanıcı adı yada şifre hatalı!");

            }
            else {
                akdkontrol =false;
            }
        }
        Akademisyen seciliakademisyen = (Akademisyen) seciliakademisyenler;
        boolean devamEtmekIstiyorMu = true;

        while (devamEtmekIstiyorMu) {

            ArrayList<Kullanici> uygunOgrenciler = new ArrayList<>();
            if (seciliakademisyen.tip.equals("Profesör")) {
                for (Kullanici o : ogrenciler) {
                    if (o.tip.equals("Ön Lisans")) {
                        uygunOgrenciler.add(o);
                    }
                }
            } else {
                for (Kullanici o : ogrenciler) {
                    if (o.tip.equals("Lisans")) {
                        uygunOgrenciler.add(o);
                    }
                }
            }

            if (uygunOgrenciler.isEmpty()) {
                System.out.println("Bu akademisyene uygun öğrenci yok.");
                return;
            }

            System.out.println("Öğrenciler:");
            for (int i = 0; i < uygunOgrenciler.size(); i++) {
                System.out.println((i + 1) + ". " + uygunOgrenciler.get(i));
            }

            System.out.print("Bir öğrenci seçiniz: ");
            int ogrenciIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (ogrenciIndex < 0 || ogrenciIndex >= uygunOgrenciler.size()) {
                System.out.println("Geçersiz seçim.");
                return;
            }

            Ogrenci seciliOgrenci =(Ogrenci) uygunOgrenciler.get(ogrenciIndex);

            System.out.print(seciliakademisyen.ders + " dersine not giriniz: ");
            int notGirisi = Integer.parseInt(scanner.nextLine());

            if (notGirisi <0 || notGirisi > 100) {
                System.out.println("Sadece 0 ile 100 arasında bir not girebilirsiniz !");
            }else {
                not.notgiris(seciliakademisyen,seciliOgrenci,seciliakademisyen.ders,notGirisi);
            }

            System.out.print("Başka bir  not girmek ister misiniz? (E/H): ");
            String devam = scanner.nextLine();

            if (devam.equalsIgnoreCase("H")) {
                devamEtmekIstiyorMu = false;
            }
        }
    }

}
