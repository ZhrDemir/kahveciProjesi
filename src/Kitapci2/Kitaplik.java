package Kitapci2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDateTime;

public class Kitaplik {
    static int sayac = 1008;
    static String kitapAdi, yazarAdi;
    static int kitapFiyati;
    static LocalDate kayitTarihi = LocalDate.now();
    static DateTimeFormatter tarih = DateTimeFormatter.ofPattern("dd.MM.YYYY");
    static Scanner scan = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, String> kitaplarMap = new TreeMap<>();
    static String eklenecekValue ="";

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
    public static void sekil(){
       // System.out.println("******************************* KİTAP LİSTESİ ***********************************");
        System.out.println("Kitap No   Kitap Adı             Yazarı              Fiyatı       Kayıt Tarihi");
        System.out.println("*********************************************************************************");
    }


    public static void kitapEkle() throws InterruptedException {



            System.out.println("Eklemek istediğiniz kitabın ismi ");

            kitapAdi = scanner.nextLine();

            System.out.println("Yazar ismi ");

            yazarAdi = scanner.nextLine();

            System.out.println("Kitabın Fiyatı ");
    try {        kitapFiyati = scan.nextInt();




        eklenecekValue = kitapAdi + "-" +
        yazarAdi + "-" + kitapFiyati + "₺-" + tarih.format(kayitTarihi);
        kitaplarMap.put(sayac, eklenecekValue);
        System.out.println("Kitap eklenmiştir...\n");
        sekil();
        System.out.printf("%-10s    %-20s   %-15s    %-8s    %-8s     %n\n", sayac, kitapAdi, yazarAdi, kitapFiyati, tarih.format(kayitTarihi));

       // System.out.println(sayac + " " + eklenecekValue);
        sayac++;

        Thread.sleep(3000);

    }catch (Exception e) {
            scan.nextLine();
            System.out.println("Yanlış giriş yaptınız");
            System.out.println("");
            kitapEkle();

        }
    }


    public static void numaraIleArama() throws InterruptedException {
try {

    System.out.println("Lütfen aradığınız kitabın numarasını giriniz.");
    int arananKitapNo = scan.nextInt();

    Set<Map.Entry<Integer, String>> aranankitapEntrySet = kitaplarMap.entrySet();


    if (kitaplarMap.containsKey(arananKitapNo)) {
        for (Map.Entry<Integer, String> each : aranankitapEntrySet
        ) {
            int eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValuArr = eachValue.split("-");

            if (arananKitapNo == eachKey) {
                sekil();
                System.out.printf("%-10s  %-20s  %-15s  %-8s    %-8s  %n", eachKey, eachValuArr[0], eachValuArr[1], eachValuArr[2], eachValuArr[3]);
            }
        }
    } else {
        System.out.println("Aradığınız kitap bulunmamaktadır.\n");
        System.out.println("Ana menüye yönlendiriliyorsunuz.... \n");
        Thread.sleep(3000);
    }
}catch (Exception e) {
    System.out.println("Yanlış giriş yaptınız...");
    System.out.println("");
    scan.nextLine();
    numaraIleArama();
}
    }


    public static void isimIleArama() throws InterruptedException {

        try {

            System.out.println("Lütfen aradığınız kitabın ismini giriniz.");
            String arananKitapIsmi = scanner.nextLine();

            Set<Map.Entry<Integer, String>> aranankitapEntrySet = kitaplarMap.entrySet();

            boolean flag = false;

            for (Map.Entry<Integer, String> each : aranankitapEntrySet
            ) {
                int eachKey = each.getKey();
                String eachValue = each.getValue();
                String[] eachValuArr = eachValue.split("-");

                if (arananKitapIsmi.equalsIgnoreCase(eachValuArr[0])) {

                    sekil();
                    System.out.printf("%-10s %-20s %-15s    %-8s %-8s %n", eachKey, eachValuArr[0], eachValuArr[1], eachValuArr[2], eachValuArr[3]);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("Aradığınız kitap bulunmamaktadır.");
                System.out.println("\nAna menüye yönlendiriliyorsunuz.... \n");
            }
        }catch (Exception e){
            System.out.println("Yanlış giriş yaptınız...");
            isimIleArama();
        }
        Thread.sleep(3000);
    }



    public static void numaraIleSilme() throws InterruptedException {
         try {
             Set<Map.Entry<Integer, String>> silinecekkitapEntrySet = kitaplarMap.entrySet();
             System.out.println("Silmek istediğiniz kitabın numarasını giriniz.");
             int silinecekKitap = scan.nextInt();

             if (kitaplarMap.containsKey(silinecekKitap)) {
                 Kitaplik.kitaplarMap.remove(silinecekKitap);
                 System.out.println("Kitap silinmiştir.");
             } else {
                 System.out.println("Silmek istediğiniz kitap bulunamadı.");
                 System.out.println("\nAna menüye yönlendiriliyorsunuz.... \n");
             }
         }catch (Exception e){
             System.out.println("Yanlış giriş yaptınız...");
             scan.nextLine();
             numaraIleSilme();
         }
        Thread.sleep(3000);
    }




    public static void kitapListele() throws InterruptedException {
        Set<Map.Entry<Integer,String>> kitapEntrySet = kitaplarMap.entrySet();
        System.out.println("******************************* KİTAP LİSTESİ ***********************************");

        sekil();
        for (Map.Entry<Integer,String> each : kitapEntrySet
        ) {
            int eachKey = each.getKey();
            String  eachValue = each.getValue();
            String [] eachValuArr = eachValue.split("-");
            System.out.printf("%-10s %-20s %-20S %-8s %-8s %n",eachKey,eachValuArr[0],eachValuArr[1],eachValuArr[2],eachValuArr[3]);
           }
        System.out.println("\nAna menüye yönlendiriliyorsunuz.... \n");
        Thread.sleep(3000);

    }

    public static void cikis() {
        System.out.println("Programdan çıkış yapıyorsunuz.....");
        System.exit(0);
    }
}




