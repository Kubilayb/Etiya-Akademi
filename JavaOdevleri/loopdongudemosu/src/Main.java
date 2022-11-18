public class Main {
    public static void main(String[] args) {

        //for döngüsü önce int sonra şart i küçük 10 gibi son kısım ise sayaç kaçar kaçar artması için ++ 1 artar

        //tek sayı için int i = 1 çift için int i 2 i+=2 ikişer ikişer
        for (int i = 2; i < 10; i += 2) {
            System.out.println(i);
        }
        System.out.println("For döngüsü bitti");

        //while döngüsü
        int i = 1;
        while (i < 10) {
            System.out.println(i);
            i++; //i yi 1 er 1 er arttır
        }
        System.out.println("While döngüsü bitti");

        //do while döngüsü
        int j = 100;
        do {
            System.out.println(j);
            j += 2;
        } while (j < 10);
        System.out.println("Do-While döngüsü bitti");



    }
}