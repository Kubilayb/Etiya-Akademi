//PascalCase büyük harf ile başlama

public class Product {
    public Product() {
        //constraction
    }
    //camelCase küçük harf ile başlama     Private ekledik ulaşılamaz oldu

    //alt+insert shortcut'ını kullanabilirsiniz getter,setter ve constructor'ları hızlıca oluşturmak için
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getDiscountRate() {
        if(discountRate>50)

        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private String name;
    private double unitPrice;
    private String imageUrl;
    private double discountRate;
     private int stock;

    //setter getter oluşturcaz
    public void setName(String name)  //parametre
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }




}
