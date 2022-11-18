public class Main {
    public static void main(String[] args) {

        //grade=not demek
        //case=durum

        char grade = 'B';

        switch (grade) {
            case 'A':
                System.out.println("Mükemmel Geçtiniz");
                break;
            case 'B':
            case 'C':
                System.out.println("Fena değil geçtiniz");
                break;
            case 'D':
                System.out.println("Şartlı geçtiniz");
                break;
            case 'F':
                System.out.println("Maalesef kaldınız");
                break;
            default:
                System.out.println("Geçersiz not girdiniz");
        }


    }
}