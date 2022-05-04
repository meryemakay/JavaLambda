package day04;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda4 {

    /*
      TASK :
      fields --> Universite (String)
                 bolum (String)
                 ogrcSayisi (int)
                 notOrt (int)
                 olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
       */
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));//false

        System.out.println("*****");
        System.out.println(ogrencıSyısı110danAzMı(unv));//false hepsı 1000 den buyuk

        System.out.println(" *****");
        System.out.println(matematikVarMı(unv));//true
        System.out.println("*****");
        ogrencıSayısıBkSırala(unv);//[Universite{universite='istanbul', bolum='hukuk', ogrSayisi=1453, notOrt=71
// Universite{universite='marmara', bolum='bilgisayar muh', ogrSayisi=1071, notOrt=77
                // Universite{universite='istanbul teknik', bolum='matematik', ogrSayisi=622, notOrt=81
                // Universite{universite='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93
                //Universite{universite='yıldız teknik', bolum='gemi', ogrSayisi=333, notOrt=74

            System.out.println("\n*****");
        System.out.println(notOrtBkSialiIlkUc(unv));//[Universite{universite='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93//
        // Universite{universite='istanbul teknik', bolum='matematik', ogrSayisi=622, notOrt=81
        //Universite{universite='marmara', bolum='bilgisayar muh', ogrSayisi=1071, notOrt=77

            System.out.println("*****");
        System.out.println(enAzOgrcSaysi2Unv(unv));//[Universite{universite='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93

        System.out.println("*****");
        System.out.println(enAzOgrcSaysi2Unv(unv));//[Universite{universite='bogazici', bolum='matematik', ogrSayisi=571, notOrt=93

        System.out.println("*****");
        System.out.println(notOrt63BykUnvOgrcSayisiTopla(unv));//4050
        System.out.println("*****");
        System.out.println(ogrcSayisi333BykNotOrtOrtlamaAl(unv));//OptionalDouble[80.5]
        System.out.println("*****");

        System.out.println("*****");

    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv ){

        return  unv.
                stream().
                allMatch(t->t.getNotOrt()>74); //hepsı 74 ten buyyk mu? degıl ozamn false
    }

        //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
public static boolean ogrencıSyısı110danAzMı(List<Universite> unv){
return unv.stream().allMatch(t->t.getOgrSayisi()<1000);

}

        //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matematikVarMı(List<Universite> unv){
        return  unv.stream().anyMatch(t->t.getBolum().contains("matematik"));

    }



        //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
        public static void ogrencıSayısıBkSırala(List<Universite> unv) {

            System.out.println(unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList()));
//Collectors.toList()->collect'e toplanan elemanlari list'e cevirir
        }


        //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
        public static List<Universite> notOrtBkSialiIlkUc(List<Universite> unv) {
            return unv.
                    stream().//akısa alındı
                            sorted(Comparator.comparing(Universite::getNotOrt).reversed()).//notOrt a göre b->k sıralandı
                            limit(3).//akısın ilk 3 elemanı alındı
                            collect(Collectors.toList());//akısın ilk 3 elemanı list'e assign edildi
            //toList());//akısın ilk 3 elemanı list'e assign edildi
        }




        //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
        public static List<Universite> enAzOgrcSaysi2Unv(List<Universite> unv) {
            return unv.
                    stream().//akısa alındı
                    sorted(Comparator.comparing(Universite::getOgrSayisi)).//sıraldı ogr sayısına gore
                    limit(2).//ılk 2
                    skip(1).//1.atlandı
                    collect(Collectors.toList());//

        }
        //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
        public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv) {
            return unv.
                    stream().
                    filter(t -> t.getNotOrt() > 63).
                    map(t -> t.getOgrSayisi()).//akıstakı objeler ogr sayıısna degıstı
                    // reduce(Integer::sum);
                    // reduce(Math::addExact);
                            reduce(0, (t, u) -> t + u);//ogrencı sayılarını topladık

        }

    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).
                sum();
        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

    }


        //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
        public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {

            return unv.
                    stream().
                    filter(t -> t.getOgrSayisi() > 333).
                    mapToDouble(t -> t.getNotOrt()).//
                            average();//akısdakş elamnalrın ortlaması alındı
            // mapToDouble() --> bu method akısdaki elemanların data type'nı
            // parameterisindeki degere göre dooble data type update eder

        }

        //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
        public static int mathBolmSayısı(List<Universite> unv) {
            return (int) unv.
                    stream().
                    filter(t -> t.getBolum().contains("mat")).
                    count();//akısdaki elelman sayısını return eder
            //count();-->akısdaki elelman sayısını return eder

        }

        //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
        public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
            return unv.
                    stream().//akıs
                            filter(t -> t.getOgrSayisi() > 571).//unv obj akısı fittrelendi
                            mapToInt(t -> t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                            max();   //akısın en byk degerini return eder

        }


        //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
        public static OptionalInt ogrcSayisi1071AzMinnotOrt(List<Universite> unv) {
            return   unv.
                    stream().
                    filter(t->t.getOgrSayisi()<1071).
                    mapToInt(t->t.getNotOrt()).
                    min();

        }


}


