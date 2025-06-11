using System.Collections.ObjectModel;
using DesktopowaApk.Models;
using Microsoft.VisualBasic.FileIO;

namespace DesktopowaApk
{
    public partial class MainPage : ContentPage
    {
        ObservableCollection<Album> albumsList = new ObservableCollection<Album>();
        int albumListIndex = 0;
        private void GetAlbumsFromFile() 
        {
            using StreamReader streamReader = new StreamReader("Data.txt");

            while(!streamReader.EndOfStream) 
            {
                string artist = streamReader.ReadLine();
                string album = streamReader.ReadLine();
                int songsNumber = int.Parse(streamReader.ReadLine());
                int year = int.Parse(streamReader.ReadLine());
                int downloadNumber = int.Parse(streamReader.ReadLine());
                string emptyLine = streamReader.ReadLine();

                albumsList.Add(new Album(artist, album, songsNumber, year, downloadNumber));
            }
            displayAlbum();
        }

        private void displayAlbum() 
        {
            artistLbl.Text = albumsList[albumListIndex].artist;
            albumLbl.Text = albumsList[albumListIndex].album;
            songsNumberLbl.Text = albumsList[albumListIndex].songsNumber + " utworów";
            yearLbl.Text = albumsList[albumListIndex].year.ToString();
            numberOfDownloadsLbl.Text = albumsList[albumListIndex].downloadNumber.ToString();
        }

        public MainPage()
        {
            InitializeComponent();
            GetAlbumsFromFile();
        }

        //**********************************************
        //nazwa metody: <OnDownLoadButtonClicked>
        //opis funkcji: <Metoda obsługuje zdarzenie po wciśnięciu przycisku Pobierz.
        //               Metoda inkrementuje liczbe pobrań z każdym wciśnięciem dla danego
        //               albumu.>
        //parametry: <sender - obiekt który wywołuje zdarzenie>
        //           <e - Argumenty zdarzenia. Brak szczególnych danych>
        //zwracany typ i opis: <brak>
        //***********************************************


        private void OnDownLoadButtonClicked(object sender, EventArgs e)
        {
            albumsList[albumListIndex].downloadNumber++;
            displayAlbum();
        }

        private void OnPreviousAlbumClicked(object sender, EventArgs e)
        {
            if (albumListIndex != 0)
            {
                albumListIndex--;
            }
            else 
            {
                albumListIndex = albumsList.Count - 1;
            }
            displayAlbum();
        }

        private void OnNextAlbumClicked(object sender, EventArgs e) 
        {
            if (albumListIndex != albumsList.Count - 1)
            {
                albumListIndex++;
            }
            else 
            {
                albumListIndex = 0;
            }
            displayAlbum();
        }
    }
}
