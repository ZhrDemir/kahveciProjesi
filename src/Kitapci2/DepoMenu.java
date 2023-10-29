package Kitapci2;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepoMenu {
    static Scanner scan = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static String tercih="";
    public static void anaMenu() throws InterruptedException {

        System.out.println("");
        System.out.println("*********************  KİTAPÇI  *****************");
        System.out.println(" ");
        System.out.println("*********************   Menü  ********************");
        System.out.println("1 - Kitap Ekle\n" +
                "2 - Numara ile Kitap Görüntüleme\n" +
                "3 - Kitap Adı ile Görüntüleme\n" +
                "4 - Numara ile Kitap Sil\n" +
                "5 - Tüm Kitaplari Listele\n" +
                "6 - Çıkış  ");
        System.out.println("***************************************************");

        System.out.println("Lütfen menüden tercihinizi giriniz.");
        tercih = scan.nextLine();

        switch (tercih){
            case "1":
                kitapEkle();
                anaMenu();
            case "2":
                numaraIleArama();
                anaMenu();
            case "3" :
                isimIleArama();
                anaMenu();
            case "4":
                numaraIleSilme();
                anaMenu();
            case "5":
                kitapListele();
                anaMenu();
            case "6":
                cikis();
                break;
            default:
                System.out.println("Geçerli bir tercih giriniz");
             anaMenu();

        }













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
                Kitaplik.yazarAdi +", " +Kitaplik.kitapFiyati +"₺, " +Kitaplik.kayitTarihi;
        Kitaplik.kitaplarMap.put(Kitaplik.sayac, eklenecekValue);
        System.out.println(Kitaplik.sayac+ " " + eklenecekValue);
        Kitaplik.sayac ++ ;

         Thread.sleep(5000);
    }

    public static void numaraIleArama() throws InterruptedException {

        System.out.println("Lütfen aradığınız kitabın numarasını giriniz.");
        int arananKitapNo= Integer.parseInt(scanner.next());

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
        }Thread.sleep(5000);
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
