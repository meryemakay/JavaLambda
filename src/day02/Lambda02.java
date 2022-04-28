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
        maxElemanBul(sayi);//Optional[15]  halukca Optional[15]
        System.out.println("\n  ***** ");

        cıfElemankaremaxBul(sayi);//Optional[64]
        System.out.println("\n  ***** ");
        elemanTopla(sayi); //Optional[33]  33

        System.out.println("\n  ***** ");
        cıftElCarp(sayi);
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
                        forEach(t -> System.out.println(t + " "));

    }

// Task : list'in en buyuk elemanini yazdiriniz

    public static void maxElemanBul(List<Integer> sayi) {

        //yapılan aksıyonda tek elemn elde edılecekse reduce kullnılır
        Optional<Integer> maxSayı = sayi.stream().reduce(Math::max); //akısa gıren elemnların actıon sonrası tek elemn halıne getırır
        //Optional:bır class buyuk harf ıle baslıyor. optıonl null barındırıyor
//**reduce den sonra bısey gelmez
/*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */

        System.out.println(maxSayı);

        System.out.println("halukca " + sayi.stream().reduce(Math::max));

    }
// Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void cıfElemankaremaxBul(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);

        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));
        System.out.println("daha spesıfık ınteger class" + sayi.stream().
                filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max));


    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...


    public static void elemanTopla(List<Integer> sayi) {

       sayi.stream().reduce(Integer::sum);//mthod ref ıle yapıldı. optıonal ıstedı . bos da olabılır null donebılır o yuzden optıonal ıstedı

        int toplam= sayi.stream().reduce(0, (a, b) -> a + b);//lambda expressıon optıonal ıstemedı. en kotu elımızde 0 var. cunku sıfır ıle basldık

    /*
    a ılk degerını hee zaman atanan degerden alır(ıdentıy)
    b degerını her zaman stream den alır
    a ılk degerınden sonrakı her degerı actıondan(ıslemden) alır
     */

        System.out.println(sayi.stream().reduce(Integer::sum));


        System.out.println(toplam);

    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void cıftElCarp(List<Integer> sayi){
//methot ref ıle yapıldı
        System.out.println("method ref ıle cıftelcarp" + sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));

//method experssıon ıle
        System.out.println("method exp ıle cıftelcarp " +sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> a + b));
    }

}