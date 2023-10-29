package Kitapci2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Set;

public class Kitaplik {
    static int sayac = 1008;
    static String kitapAdi, yazarAdi;
    static double kitapFiyati;
    static LocalDate kayitTarihi = LocalDate.now();

    static Scanner scan = new Scanner(System.in);
    static Map<Integer, String> kitaplarMap = new HashMap<>();


    public static void feykKitaplikEkle() {

        kitaplarMap.put(1000, "İnsan Neyle Yaşar-Tolstoy-20₺-20.10.2023");
        kitaplarMap.put(1001, "Gurur ve Önyargı-Jane Austen-51₺-23.10.2023");
        kitaplarMap.put(1002, "Yeraltından Notlar-Dostoyevski-23₺-24.09.2023");
        kitaplarMap.put(1003, "Romeo ve Juliet-W Shakespeare-21₺-24.10.2023");
        kitaplarMap.put(1004, "Dönüşüm-F Kafka-18₺-22.10.2023");
        kitaplarMap.put(1005, "Ağaçkakanlar-C Zarifoğlu-53₺-20.10.2023");
        kitaplarMap.put(1006, "Acımak-R N Güntekin-68₺-24.08.2023");
        kitaplarMap.put(1007, "İrade Terbiyesi-Ethem Bakar-84₺-24.10.2023");


    }

    public static void kitapEkle() throws InterruptedException {
        System.out.println("Eklemek istediğiniz kitabın ismi ");

        try {
            Kitaplik.kitapAdi = scan.nextLine();
            System.out.println("Yazar ismi ");
            Kitaplik.yazarAdi = scan.nextLine();
            System.out.println("Kitabın Fiyatı ");
            Kitaplik.kitapFiyati = scan.nextDouble();
        } catch (Exception e) {
            System.out.println("yanlış giriş yaptınız");
            kitapEkle();
        }

        String eklenecekValue = Kitaplik.kitapAdi + ", " +
                Kitaplik.yazarAdi + ", " + Kitaplik.kitapFiyati + "₺, " + Kitaplik.kayitTarihi;
        Kitaplik.kitaplarMap.put(Kitaplik.sayac, eklenecekValue);
        System.out.println(Kitaplik.sayac + " " + eklenecekValue);
        Kitaplik.sayac++;

        Thread.sleep(5000);
    }


    public static void numaraIleArama() throws InterruptedException {

        System.out.println("Lütfen aradığınız kitabın numarasını giriniz.");
        int arananKitapNo = Integer.parseInt(scan.next());

        Set<Map.Entry<Integer, String>> aranankitapEntrySet = Kitaplik.kitaplarMap.entrySet();
        System.out.println("******************* KİTAP NO İLE BULUNAN KİTAP LİSTESİ ****************");
        System.out.println("Kitap No   Kitap Adı          Yazarı          Fiyatı   Kayıt Tarihi");
        System.out.println("*********************************************************************");

        for (Map.Entry<Integer, String> each : aranankitapEntrySet
        ) {
            int eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuArr = eachValue.split("-");

            if (arananKitapNo == eachKey) {
                System.out.println(eachKey + "   " + eachValuArr[0] + "  " +
                        eachValuArr[1] + "   " + eachValuArr[2] + "  " + eachValuArr[3]);
            }
            // scan.nextLine();
        }
        Thread.sleep(5000);
    }


    public static void isimIleArama() throws InterruptedException {

        System.out.println("Lütfen aradığınız kitabın ismini giriniz.");
        String arananKitapIsmi = scan.nextLine();

        Set<Map.Entry<Integer,String>> aranankitapEntrySet = Kitaplik.kitaplarMap.entrySet();
        System.out.println("******************* KİTAP ADI İLE BULUNAN KİTAP LİSTESİ ****************");
        System.out.println("Kitap No   Kitap Adı          Yazarı          Fiyatı   Kayıt Tarihi");
        System.out.println("*********************************************************************");

        for (Map.Entry<Integer, String> each : aranankitapEntrySet
        ) {
            int eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuArr = eachValue.split("-");

            if (arananKitapIsmi.equalsIgnoreCase(eachValuArr[0])) {
                System.out.println(eachKey + "   " + eachValuArr[0] + "  " +
                        eachValuArr[1] + "   " + eachValuArr[2] + "  " + eachValuArr[3]);
            }


        }
        Thread.sleep(5000);
    }



    public static void numaraIleSilme() {

        System.out.println("Silmek istediğiniz kitabın numarasını giriniz.");
        String silinecekKitap = scan.nextLine();
        String silinecekValue = Kitaplik.kitaplarMap.get(silinecekKitap);
        String sonucValue = Kitaplik.kitaplarMap.remove(silinecekKitap);
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
            if (sonuc == true) {
                System.out.println("İstediğiniz kitap silindi...");
            }
        } catch (Exception e) {
            System.out.println("Silmek istediğiniz kitap bulunamadı.");
        }
        scan.nextLine();
    }




    public static void kitapListele() throws InterruptedException{
        Set<Map.Entry<Integer,String>> kitapEntrySet = Kitaplik.kitaplarMap.entrySet();
        System.out.println("*********************** KİTAP LİSTESİ **************************");
        System.out.println("Kitap No   Kitap Adı          Yazarı          Fiyatı   Kayıt Tarihi");
        System.out.println("*********************************************************************");
        for (Map.Entry<Integer,String> each : kitapEntrySet
        ) {
            int eachKey = each.getKey();
            String  eachValue = each.getValue();
            String [] eachValuArr = eachValue.split("-");

            System.out.println(eachKey +"   " + eachValuArr[0] + "  " +
                    eachValuArr[1]+"   " + eachValuArr[2] );
        }
        Thread.sleep(5000);

    }

    public static void cikis() {
        System.out.println("Programdan çıkış yapıyorsunuz.....");
        System.exit(0);
    }
}




