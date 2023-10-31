package Kitapci2;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepoMenu extends Kitaplik {
    static Scanner scan = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);
    static String tercih = "";

    public static void anaMenu() throws InterruptedException {

        System.out.println("");
        System.out.println("\t\t*********************  KİTAPÇI  *****************");
        System.out.println(" ");
        System.out.println("\t\t*********************   Menü  ********************");
        System.out.println("\t\t1 - Kitap Ekle\n" +
                "\t\t2 - Numara ile Kitap Görüntüleme\n" +
                "\t\t3 - Kitap Adı ile Görüntüleme\n" +
                "\t\t4 - Numara ile Kitap Sil\n" +
                "\t\t5 - Tüm Kitaplari Listele\n" +
                "\t\t6 - Çıkış  ");
        System.out.println("\t\t***************************************************\n");

        System.out.println("Lütfen menüden tercihinizi giriniz.");
        tercih = scan.nextLine();

        switch (tercih) {
            case "1":
                kitapEkle();
                anaMenu();
            case "2":
                numaraIleArama();
                anaMenu();
            case "3":
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

}


















