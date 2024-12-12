package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class NotYonetimi {

    public static Map<String, String> notlar = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void notgiris(Akademisyen akademisyen, Ogrenci ogrenci, String ders, int not) {
        String anahtar = ogrenci.ad + "-" + ders;
        String deger = akademisyen.ad + " " + akademisyen.soyad + " tarafından girilen not: " + not;
        notlar.put(anahtar, deger);
        System.out.println("Not başarıyla girildi.");

    }

    public void notgoruntule(Ogrenci ogrenci, String kullanıcı) {
        System.out.println("Öğrenci: " + ogrenci.ad + " " + ogrenci.soyad);
        boolean notbulundu = false;
        for (Map.Entry<String, String> entry : notlar.entrySet()) {
            String[] parts = entry.getKey().split("-");
            String ogrenciAdi = parts[0];
            String dersAdi = parts[1];

            if (ogrenciAdi.equalsIgnoreCase(ogrenci.ad)) {
                System.out.println("Ders: " + dersAdi + "\nNot: " + entry.getValue());
                System.out.println("-----------------------------------------");
                notbulundu = true;
            }
            if (!notbulundu) {
                System.out.println("Henüz girilen bir notunuz yok.");
            }

        }
    }
}