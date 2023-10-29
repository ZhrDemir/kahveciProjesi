package Kitapci2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Kitaplik {
   static int sayac = 1008;
    static String kitapAdi,yazarAdi;
    static double kitapFiyati;
    static LocalDate kayitTarihi = LocalDate.now();

    static Scanner scan = new Scanner(System.in);
    static Map<Integer ,String> kitaplarMap = new HashMap<>();



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
}
