import java.util.Scanner;

public class FindCommonDivisor {
    public static void main(String[] args) {
        System.out.println("Podaj dwie liczby całkowite dodatnie" +
                " oddzielone od siebie spacją");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbersStr = line.split("\s");

        int a = Integer.parseInt(numbersStr[0]);
        int b = Integer.parseInt(numbersStr[1]);

        System.out.println("Największy wspólny dzielnik dla liczb: " +
                "\na = " + a + "\nb = " + b +
                "\nJest równy " + getCommonDivisor(a, b));
    }

    public static int getCommonDivisor(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}