public class Main {
    public static void main(String[] args) {

        //OOP NESNE YÖNELİMLİ PROGRAMLAMA
        //instance üretmek(nesne)
        //obje üretmek   obje ve nesne farkı
        //Product deriBot = new Product();
        Product product1 = new Product();
        //set işlemi
        product1.setUnitPrice(); = 50; //fiyat ad vs.
        //product1.name = "Erkek Deri Bot";
        product1.setName("Erkek deri bot");
        product1.setDiscountRate();=13.5;
        product1.setImageUrl();="bot.jpeg";
        product1.setStock();=15;

        Product product2 = new Product();
        product2.setUnitPrice();unitPrice=10523;
        product2.setName();name="4k ultra hd tv";

        //get etmek
        System.out.println(product1.getName()); //ilgili objenin adresi çıkıyor çalıştırınca



    }
}