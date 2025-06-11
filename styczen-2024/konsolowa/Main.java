import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] pesel = new int[11];

        System.out.println("Proszę podać swój numer pesel");
        Scanner scanner = new Scanner(System.in);
        String peselString = scanner.nextLine();
        char[] peselChar = peselString.toCharArray();

        if(peselChar.length > 11) {
            System.out.println("Pesel jest za długi!");
        } else if (peselChar.length < 11) {
            System.out.println("Pesel jest za krótki!");
        } else if(!peselString.matches("\\d{11}")) {
            System.out.println("Pesel powinien składać się tylko z cyfr!");
        } else {
            for (int i = 0; i < 11; i++) {
                pesel[i] = Integer.parseInt(String.valueOf(peselChar[i]));
            }

            System.out.print("Twój pesel: ");
            for (int i : pesel) {
                System.out.print(i);
            }

            if (checkControlNumber(pesel)) {
                String sex = checkSex(pesel) == 'M' ? "Mężczyzna" : "Kobieta";
                System.out.println("\nPłeć: " + sex);
            } else {
                System.out.println("\nPłeć niedostępna. Proszę zweryfikować poprawność peselu!");
            }

            String correct = checkControlNumber(pesel) ? "" : "nie ";
            System.out.println("Suma kontrolna jest " + correct + "zgodna");
        }
    }
//**********************************************
//    nazwa funkcji: <checkSex>
//    opis funkcji: <Metoda sprawdza płeć na podstawie przedostatniej cyfry numeru pesel.
//                  Metoda sprawdza czy przedostatnia cyfra numeru pesel jest parzysta czy nie.
//                  Jeżeli cyfra jest parzysta to metoda zwraca znak K czyli Kobieta, jeżeli nie jest
//                  parzysta to zwraca znak M czyli mężczyzna>
//    parametry: <tablica typu int - tablica która zawiera numer pesel. Każda cyfra to inny index.
//                Długość tablicy to 11 cyfr>
//    zwracany typ i opis: <zwracany jest char (znak) - gdy zwróci M to znaczy że pesel należy do mężczyzny,
//                          z kolei jeżeli zwróci K to znaczy że pesel należy do kobiety>
//***********************************************

    public static char checkSex(int[] pesel) {
        char sex = 'M';
        if(pesel[9] % 2 == 0) {
            sex = 'K';
        }
        return sex;
    }

    public static boolean checkControlNumber(int[] pesel) {
        boolean correct;
        int S = 0;

        for(int i = 0; i < 10; i++) {

            if(i == 0 || i == 4 || i == 8) {
                S += pesel[i];
            } else if(i == 1 || i == 5 || i == 9) {
                S += pesel[i]*3;
            } else if(i == 2 || i == 6) {
                S += pesel[i]*7;
            } else if(i == 3 || i == 7) {
                S += pesel[i]*9;
            }
        }
        int M = S % 10;
        int R = M == 0 ? 0 : 10 - M;
        correct = R == pesel[10];

        return correct;
    }
}
