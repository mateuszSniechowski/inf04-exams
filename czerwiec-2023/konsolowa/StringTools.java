import java.util.ArrayList;
import java.util.List;

//************************************************
//klasa: <StringTools>
//opis: <Klasa reprezentuje zbiór narzędzi dla typu łańcuchowego String.
//       Klasa posiada dwie metody, które przyjmują String jako parametr wejściowy
//       i wykonują określone działania na tekście>
//metody: <countVowels - metoda liczy samogłoski w tekście i zwraca liczbę samogłosek>
//        <deleteDuplicatesFromText - metoda usuwa powtórzenia znaków występujących obok
//        siebie i zwraca tekst (typu String) bez tych powtórzeń>
//************************************************

public class StringTools {
    public static int countVowels(String text) {
        int numOfVowels = 0;
        if(text == null || text.isEmpty()) {
            return numOfVowels;
        }
        String vowels = "aąeęiouóyAĄEĘIOUÓY";

        char[] vowelsArray = vowels.toCharArray();
        char[] textToCharArray = text.toCharArray();

        for(int i = 0; i < textToCharArray.length; i++) {
            for(char c : vowelsArray) {
                if(textToCharArray[i] == c) {
                    numOfVowels++;
                }
            }
        }
        return numOfVowels;
    }

    public static String deleteDuplicatesFromText(String text) {
        StringBuilder textWithoutDuplicates = new StringBuilder();
        if(text == null || text.isEmpty()) {
            return textWithoutDuplicates.toString();
        }

        char[] textToChar = text.toCharArray();
        List<Character> charListWithoutDuplicates = new ArrayList<>();

        for(int i = 0; i < textToChar.length; i++) {
            char temp = textToChar[i];
            if(i != textToChar.length - 1 && temp != textToChar[i + 1]) {
                charListWithoutDuplicates.add(temp);
            }

            if(i == textToChar.length-1) {
                charListWithoutDuplicates.add(textToChar[i]);
            }
        }

        for(char c : charListWithoutDuplicates) {
            textWithoutDuplicates.append(c);
        }
        return textWithoutDuplicates.toString();
    }
}
