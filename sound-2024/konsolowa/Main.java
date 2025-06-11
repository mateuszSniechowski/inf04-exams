import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printAlbums(getAlbumsFromFile());
    }

//    **********************************************
//    nazwa metody: <getAlbumsFromFile>
//    opis metody: <Metoda wczytuje dane z pliku Data.txt.
//                  Dane z pliku .txt są przypisywane do odpowiednich
//                  pól po czym tworzymy obiekt Album. Każdy obiekt Album jest
//                  zapisywany do list albumów.>
//    parametry: <brak>
//    zwracany typ i opis: <Zwracana jest Lista albumów typu Album.>
//***********************************************

    public static List<Album> getAlbumsFromFile() {
        String filePath = "Data.txt";
        List<Album> albumsList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(Paths.get(filePath));

            while (scanner.hasNext()) {
                String artist = scanner.nextLine();
                String album = scanner.nextLine();
                int songsNumber = scanner.nextInt();
                int year = scanner.nextInt();
                int downloadNumber = scanner.nextInt();
                scanner.nextLine();

                albumsList.add(new Album(
                        artist,
                        album,
                        songsNumber,
                        year,
                        downloadNumber));

                if(scanner.hasNextLine() && scanner.nextLine().isEmpty()) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania pliku: " + e.getMessage());
        }
        return albumsList;
    }

    public static void printAlbums(List<Album> albmusList) {
        for(Album album : albmusList) {
            System.out.println(album);
        }
    }
}
