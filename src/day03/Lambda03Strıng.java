package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03Strıng {
    public static void main(String[] args) {


        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe","trileçe","trileçe","trileçe ","havuçdilim",
                "buryan", "yaglama", "kokoreç", "arabAsı", "güveç"));
        System.out.println("\n *****   ");
        alfabetikBykTekrarsz(menü);
        System.out.println("\n *****   ");
        karaktersayısıTersirali(menü);
        System.out.println("\n *****   ");


    }

    // Task : List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfabetikBykTekrarsz(List<String> yemek){


       yemek.stream(). //akıs kaynagı
              // map(t->t.toUpperCase()).// lambda experrsıon yapıldı elemenları buyuk harf update edıldı
              map(String::toUpperCase).
               sorted().//alfabetık sıra
               distinct().//benzeesız hale getırdı
               forEach(t-> System.out.print(t+ ", ")) ; //prınt edıldı


         //distinct() => Bu method tekrarlı elemanları sadece bir kere sokar.
         // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre)
         // oluşan bir akış döndürür.
         // Sıralı akışlar için, farklı elemanın seçimi sabittir
         // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
         // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez.
         // Stream return eder.
    }


// Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void karaktersayısıTersirali(List<String> yemek) {

yemek.stream().
        map(t->t.length()).
        sorted(Comparator.reverseOrder()).
        distinct().
        forEach(t -> System.out.print(t + " "));

        /*yemek.  2.cozum
                stream().//akısa gırdı
                map(String::length). //
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(t -> System.out.print(t + " "));*/
    }
// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
public static void elemanlarinKarakterSayısı(List<String> yemek){


        yemek.
                stream().
                map(String::length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(t -> System.out.print(t + " "));
    }
// Task : list elemanlarinin son harfine gore ters sirali print ediniz.



// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.

// Task : Karakter sayisi en buyuk elemani yazdiriniz.

// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}
