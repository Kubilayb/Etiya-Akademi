public class Main {
    public static void main(String[] args) {
        String mesaj = "    Bugün hava çok güzel.   ";
        System.out.println(mesaj);

/*        System.out.println("Eleman sayısı :" + mesaj.length());
        System.out.println("5.eleman :" + mesaj.charAt(4)); //dizinin 4.elemanı olarak düşüneceğiz
        System.out.println(mesaj.concat(" Yaşasın!")); //yeni bir string oluşturuyor
        System.out.println(mesaj.startsWith("B"));   //Metin hangi harf ile başlıyor true false cevap alırız
        System.out.println(mesaj.endsWith("."));    //Metin bitişi
        char[] karakterler = new char[5];
        mesaj.getChars(0, 5, karakterler, 0);
        System.out.println(karakterler);

        System.out.println(mesaj.indexOf("av")); //belirtiğimiz karakterin mesaj içinde kaçıncı olduğunu yazar.
        System.out.println(mesaj.lastIndexOf("e"));//aramaya sağdan başlar indexof un tersi*/

        //replace olayı
        String yeniMesaj = mesaj.replace(' ', '-');
        System.out.println(yeniMesaj);
        System.out.println(mesaj.substring(2)); //substring mesajın ikinci indexinden başlar
        //diğer kullanımı ise
        System.out.println(mesaj.substring(2, 5));

        //split fonksiyonu boşluk karakterlerini ayırıcaz
        for (String kelime : mesaj.split(" ")) {
            System.out.println(kelime);
        }

        System.out.println(mesaj.toLowerCase()); // bütün harfleri küçük büyük yapma fonksiyonu
        System.out.println(mesaj.toUpperCase());
        System.out.println(mesaj.trim()); // boşlukları atma ilk baştaki ve sondaki
    }
}