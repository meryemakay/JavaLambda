package day03;

import day01.Lambda01;
import day02.Lambda02;

import java.util.*;

public class Lambda03 {

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, -8, 8, 15));

        minBul(sayi);//Optional[-8] Optional[-8]  Optional[-8]
        System.out.println("***");
        ciftKareKbPrint(sayi); //4 16 36 64 64

        System.out.println("***");
        tekKareBbPrint(sayi);//225 121


    }

// Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
public static void minBul(List<Integer> sayi){
//1. yontem Method Reference --> Integer class


    Optional<Integer> minSayıInteger =sayi.stream().reduce(Integer::min);

    System.out.println(minSayıInteger);
//2. yontem Method Reference --> Math class

    Optional<Integer> minSayıMath =sayi.stream().reduce(Integer::min);
    System.out.println(minSayıMath);

//3. yontem Lambda Expression

    int minSayıLambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));

    Optional<Integer> minSayıHaluk = sayi.stream().reduce(Lambda03::byHaluMın);

    System.out.println(minSayıHaluk);
    //4. yontem Method Reference --> Haluk class



}
public static int byHaluMın(int a, int b){ //bu method kendısne verılen ıkı ınt den en kucugunu return eder
    return a<b?a:b;


}


// Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
public static void bestenBuyukEnTek(List<Integer> sayi)

    {


        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda03::byHaluMın));

    }
// Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareKbPrint(List<Integer> sayi){

        sayi.stream(). //   akısa alındı
                filter(Lambda01::ciftBul).  //cıftler alındı
                map(t->t*t).  //kare alındı
                sorted(). // dogal sıralandı
                forEach(Lambda01::yazdir);  //prınt edıldı
//sayi.stream().filter(Utils ::printOddElements).sorted().filter(t -> t>5).findFirst().get();
        System.out.println();


    }


// Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.

    public static void tekKareBbPrint(List<Integer> sayi){

        sayi.stream(). //   akısa alındı
                filter(t->t%2==1).  //tekler alındı
                map(t->t*t).  //kare alındı
               sorted(Comparator.reverseOrder()). // ters sıralandı
                forEach(Lambda01::yazdir);  //prınt edıldı


    }

}
