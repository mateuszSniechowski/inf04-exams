import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ile kostek chcesz rzucić? (3 - 10)");
        int numOfDice = 0;
        boolean correctNumOfDice = false;

        while (!correctNumOfDice) {
            Scanner scanner = new Scanner(System.in);
            numOfDice = scanner.nextInt();

            if (numOfDice >= 3 && numOfDice <= 10) {
                correctNumOfDice = true;
            }
        }

        boolean playAgain;

        do {
            List<Integer> randomNumbersList = getNumbers(numOfDice);
            int counter = 1;
            for (int num : randomNumbersList) {
                System.out.println("Kostka " + counter + ": " + num);
                counter++;
            }
            System.out.println("Liczba uzyskanych punktów: " +
                    countPoints(randomNumbersList));

            System.out.println("Jeszcze raz? (t/n)");
            Scanner playAgainScanner = new Scanner(System.in);
            String playAgainString = playAgainScanner.nextLine();
            if(playAgainString.equalsIgnoreCase("t")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        } while(playAgain);
    }

//************************************************
//    nazwa: <getNumbers>
//    opis: <Metoda losuje liczby od 1 do 6 tyle razy ile użytkownik
//          wpisał że chce kostek. Innymi słowy metoda rzuca kostkami i
//          zapisuje wylosowane liczby do listy typu Integer>
//    parametry: <int numOfDice - liczba kostek, które użytkownik wybrał
//                że chce użyć do rzutu>
//    zwracany typ i opis:<List typu Integer - zwracana jest lista z wylosowanymi liczbami>
//************************************************

    public static List<Integer> getNumbers(int numOfDice) {
        List<Integer> randomNumbersList = new ArrayList<>();

        for(int i = 0; i < numOfDice; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(1, 6);

            randomNumbersList.add(randomNum);
        }

        return randomNumbersList;
    }

    public static int countPoints(List<Integer> randomNumbersList) {
        int points = 0;
        int [] numberArray = new int[randomNumbersList.size()];

        int index = 0;
        for(int num : randomNumbersList) {
            numberArray[index] = num;
            index++;
        }

        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < numberArray.length; i++) {
            int currentNum = numberArray[i];
            int count = 0;

            for(int num : randomNumbersList) {
                if(num == currentNum) {
                    count++;
                }
            }

            if(count > 1 && !duplicates.contains(currentNum)) {
                points += currentNum * count;
                duplicates.add(currentNum);
            }
        }
        return points;
    }
}
