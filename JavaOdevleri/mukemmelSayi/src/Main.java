public class Main {
    public static void main(String[] args) {
        //Mükemmel sayı:Kendinden başka pozitif tüm tam bölenlerinin sayısı tomlamı kendise eşitse oluyor 6 28 gibi

        //6 >>>1,2,3
        //28 >>>1,2,4,7,14
        int number = 6;
        int total = 0;

        for (int i=1; i<number;i++){
            if (number % i == 0){
                total = total +i;
            }
        }
        if (total==number){
            System.out.println("Mükemmel Sayıdır");
        }else {
            System.out.println("Mükemmel sayı değildir!!!!");
        }



    }
}