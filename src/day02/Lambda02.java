package day02;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Lambda02 {

    public static void main(String[] args) {


        // Task : Functional Programming ile listin cift
// elemanlarinin  karelerini
// ayni satirda aralarina bosluk bırakarak print ediniz
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, -8, 8, 15));

        ciftKarePrint(sayi); //16 4 36 64 64
        System.out.println("\n  ***** ");
        tekKupBırFazlaprınt(sayi);//1332 -124 3376
        System.out.println("\n  ***** ");
        cıftkarePrınt(sayi);
        System.out.println("\n  ***** ");


    }

    public static void ciftKarePrint(List<Integer> sayi) {


        sayi.stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t). //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek
                // veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                        forEach(Lambda01::yazdir);


        // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin
        // bir fazlasini ayni satirda aralarina bosluk birakarak print edin


    }

    public static void tekKupBırFazlaprınt(List<Integer> sayi) {

        sayi.stream(). //sayılar akısa alınd
                filter(t -> t % 2 != 0).//tek elemanlar fıltrelendı
                map(t -> (t * t * t) + 1).// //kuplerın 1 fazlası
                forEach(Lambda01::yazdir); //yazdırıldı

    }

    // Task : Functional Programming ile listin ,
    // cift elemanlarinin   karekoklerini ayni satirda aralarina
    // bosluk birakarak yazdiriniz

    public static void cıftkarePrınt(List<Integer> sayi) {

        sayi.stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//math ref   ** double deger verdı
                //forEach(Lambda01::yazdir) yazdır method ınt calıstıgı ıcın map den cıkan dataları calıstrmz
                forEach(t-> System.out.println(t + " "));

    }

// Task : list'in en buyuk elemanini yazdiriniz

    public static void  maxElemanBul(List<Integer> sayi){

        //yapılan aksıyonda tek elemn elde edılecekse reduce kullnılır
       Optional<Integer> maxSayı=  sayi.stream().reduce(Math::max); //akısa gıren elemnların actıon sonrası tek elemn halıne getırır
        //Optional:bır class buyuk harf ıle baslıyor


    }

}