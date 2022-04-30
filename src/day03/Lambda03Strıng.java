package day03;

import day01.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03Strıng {
    public static void main(String[] args) {


        List<String> menü = new ArrayList<>(Arrays.asList("küşleme", "adana", "trileçe", "trileçe", "havuçdilim",
                "buryan", "yaglama", "kokoreç", "arabAsı", "güveç"));
        System.out.println("\n *****   ");
        alfabetikBykTekrarsz(menü);//ADANA, ARABASI, BURYAN, GÜVEÇ, HAVUÇDİLİM, KOKOREÇ, KÜŞLEME, TRİLEÇE, YAGLAMA,

        System.out.println("\n *****   ");
        karaktersayısıTersirali(menü);//10 7 6 5

        System.out.println("\n *****   ");
        elemanlarinKarakterSayısı(menü);//adana güveç buryan küşleme trileçe yaglama kokoreç arabAsı havuçdilim

        System.out.println("\n *****   ");
        elemanlarınSonHarfıneGoreTers(menü);//arabAsı, kokoreç, güveç, buryan, havuçdilim, küşleme, trileçe, trileçe, adana, yaglama,

        System.out.println("\n *****   ");
        charKaresiCiftElSirala(menü); //100 36

        System.out.println("\n *****   ");
        harfSayisi7denAzKontrol(menü);//list elemanları 7 harften  buyuk


        System.out.println("\n *****   ");
        wIleBaslayanElKontrol(menü);//agam w ile başlayan yemahh olu mu ?


        System.out.println("\n *****   ");
        xIleBitenElKontrol(menü);//agam senin aradigin yemek bu torpaklarda yooogggg


        System.out.println("\n *****   ");
        charSayisiBykElPrint(menü);

        System.out.println("\n *****   ");
        ilkElHarcSonHrfSiraliPrint(menü);//yaglama küşleme trileçe trileçe havuçdilim buryan kokoreç güveç arabAsı



    }

    // Task : List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfabetikBykTekrarsz(List<String> yemek) {


        yemek.stream(). //akıs kaynagı
                // map(t->t.toUpperCase()).// lambda experrsıon yapıldı elemenları buyuk harf update edıldı
                        map(String::toUpperCase).
                sorted().//alfabetık sıra
                distinct().//benzeesız hale getırdı
                forEach(t -> System.out.print(t + ", ")); //prınt edıldı


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
                map(t -> t.length()).
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
    public static void elemanlarinKarakterSayısı(List<String> yemek) {


        yemek.
                stream().
                sorted(Comparator.comparing(String::length)).
                distinct().
                forEach(t -> System.out.print(t + " "));
    }
// Task : list elemanlarinin son harfine gore ters sirali print ediniz.

    public static void elemanlarınSonHarfıneGoreTers(List<String> yemek) {


        yemek.stream(). //akıs
                sorted(Comparator.
                comparing(t -> t.toString().// son harfe gore
                        charAt(t.toString().
                        length() - 1)).reversed()).//ters sıraladı
                forEach(t -> System.out.print(t + ", "));
    }


// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.
                stream().//akısa alndı
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).//cift elemanlar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menü) {
        //amele code
        System.out.println("amele code");
        boolean kontrol = menü.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else System.out.println("list elemanları 7 harften  buyuk");


        //cincix code
        System.out.println("cincix code");
        System.out.println(menü.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften  buyuk");
 //almatch hepsını gozden gecır esıtle..
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }


// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

    public static void wIleBaslayanElKontrol(List<String> menü) {
        System.out.println(menü.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" :
                "agam  wenemen ne menen bi şey  ?");

    }

// Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
public static void xIleBitenElKontrol(List<String> menü) {
    System.out.println(menü.
            stream().
            //map(String::toUpperCase). buyyk harf
            anyMatch(t -> t.endsWith("x")) ? "agam senden bir  cacix olmaz  ?" :
            "agam senin aradigin yemek bu torpaklarda yooogggg");

}



// Task : Karakter sayisi en buyuk elemani yazdiriniz.
public static void charSayisiBykElPrint(List<String> menü) {
    Stream<String> sonIsim = menü.
            stream().
            sorted(Comparator.comparing(t -> t.toString().length()).
                    reversed()).
            //   findFirst();//ilk eleman alındı
                    limit(3);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.

    /*
sonIsim.toArray()--> limit() meth return dan dolayı
stream type olan sonIsim toArray() method ile array type convert edildi
 */

    /*    System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi

//limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan,
uzunluğu maxSize'dan uzun olmayacak
// şekilde kesilmiş bir akış return eder. Stream return eder.

         /*
    TRİCK : Stream’ler ekrana direk yazdırılamaz. Stream’i toArray() ile Array’e çeviririz. Array’i de Arrays.toString() ‘in içine alıp yazdırabiliriz.
  	Ör; System.out.println(Arrays.toString(stream.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
     */


// akıs cıktısını bir veriable assaign edilebilir
//               Optional<String> enBykKrEl = menü.
//        stream().
//        sorted(Comparator.comparing(t -> t.toString().length()).
//        reversed()).
//        findFirst();//ilk eleman alınd

}




// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHarcSonHrfSiraliPrint(List<String> menü) {

        menü.
                stream().//akısa alındı
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).//son harfe göre sıralandı
                skip(1).//ilk eleman atlandı -->adana
                forEach(t -> System.out.print(t + " "));//print edildi


//skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
// Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
//skip(list.size()-1) => List’in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }


}




