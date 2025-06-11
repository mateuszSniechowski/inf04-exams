import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz tekst, a program policzy samogłoski oraz " +
                "usunie duplikaty");
        String text = scanner.nextLine();
        int numOfVowels = StringTools.countVowels(text);
        String textWithoutDuplicates = StringTools.deleteDuplicatesFromText(text);

        System.out.println("Twój tekst: " + text +
                "\nLiczba samogłosek: " + numOfVowels +
                "\nTekst po usunięciu duplikatów: " + textWithoutDuplicates);
    }
}
