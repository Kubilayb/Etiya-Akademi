public class Main {
    public static void main(String[] args) {
        String ogrenci1 = "Berat Kubilay";
        String ogrenci2 = "Engin";
        String ogrenci3 = "Derin";
        String ogrenci4 = "Ahmet";

        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
        System.out.println(ogrenci3);
        System.out.println(ogrenci4);

        System.out.println("********************");
        String[] ogrenciler = new String[4];

        ogrenciler[0] = "Berat Kubilay";
        ogrenciler[1] = "Engin";
        ogrenciler[2] = "Derin";
        ogrenciler[3] = "Ahmet";
       // ogrenciler[4] = "Ali";
        //dizilerde sınırları aşarsak hata verir arrayinexout hatası

        for (int i = 0; i < ogrenciler.length; i++) {
            System.out.println(ogrenciler[i]);
        }
        System.out.println("-------------------");
        //!!!!! ÖNEMLİ KISIM!!!!
        for (String ogrenci: ogrenciler){
            System.out.println(ogrenci);
        }


    }
}