namespace PssportApp
{
    public partial class MainPage : ContentPage
    {

        public MainPage()
        {
            InitializeComponent();
        }

//**********************************************
//nazwa funkcji: <OnButtonClicked>
//opis funkcji: <Funkcja obsługuje kliknięcie przycisku OK. Funkcja
//               sprawdza czy wszystkie dane zostały wpisane do pól Entry.
//               Sprawdza dane takie jak numer, imie, nazwisko i kolor oczu. Jeżeli
//               któreś pole nie zostało uzupełnione to wyświetla komunikat o tym
//               że te pola powinny zostać uzupełnione. Jeżeli wszystkie dane zostały
//               poprawnie uzupełnione to wyświetalny jest komunikat z danymi, które zostały pobrane
//               od użytkownika z pól Entry>
//parametry: <sender - obiekt wywołujący zdarzenie>
//           <e - Argumenty zdarzenia. Brak szególnych danych >
//zwracany typ i opis: <brak - funkcja nic nie zwraca>
//***********************************************

        private void OnButtonClicked(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(numberEntry.Text) &&
               !string.IsNullOrEmpty(nameEntry.Text) &&
               !string.IsNullOrEmpty(surnameEntry.Text))
            {

                string eyesColor = "";

                if (blueBtn.IsChecked)
                {
                    eyesColor = "niebieskie";
                }
                else if (greenBtn.IsChecked)
                {
                    eyesColor = "zielone";
                }
                else if (beerBtn.IsChecked)
                {
                    eyesColor = "piwne";
                }

                DisplayAlert("", $"{nameEntry.Text} {surnameEntry.Text} kolor oczu {eyesColor}", "OK");
            }
            else 
            {
                DisplayAlert("", "Wprowadź Dane", "OK");
            }
        }

        private void OnNumberChanged(object sender, TextChangedEventArgs e)
        {
            if (string.Equals(numberEntry.Text, "111") && numberEntry.Text.Length == 3)
            {
                faceImage.Source = "azdjecie.jpg";
                handImage.Source = "aodcisk.jpg";
            }
            else if (string.Equals(numberEntry.Text, "222") && numberEntry.Text.Length == 3)
            {
                faceImage.Source = "bzdjecie.jpg";
                handImage.Source = "bodcisk.jpg";
            }
            else if (string.Equals(numberEntry.Text, "333") && numberEntry.Text.Length == 3)
            {
                faceImage.Source = "czdjecie.jpg";
                handImage.Source = "codcisk.jpg";
            }
            else 
            {
                faceImage.Source = "";
                handImage.Source = "";
            }
        }
    }

}
