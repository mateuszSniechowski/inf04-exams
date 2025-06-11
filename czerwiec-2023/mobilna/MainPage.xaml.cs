namespace Weterynarz
{
    //************************************************
    // klasa: <MainPage>
    // opis: <Kalsa reprezentuje funkcjonaloności aplikacji mobilnej.
    //        Zawiera metody, które obsługują wszystkie interakcje, które
    //        użytkownik może wykonać, np. kliknięcie przycisku OK, wybór wieku
    //        dla swojego zwierzęcia itp.>
    // metody: <OnSubmitBtnClicked - metoda nic nie zwraca. Jedynie reaguje na
    //          wciśnięcie przycisku i pobiera dane z wszystkich pól, które użytkwonik
    //          wypełnił, po czym wyświetla komunikat z tymi danymi>
    //          <AgeSlider - również nic nie zwraca. Jedynie zmienia wartość w etykiecie
    //          z tekstem w zależności od pozycji slidera>
    //          <OnAnimalTapped - nic nie zwraca. Ustawia maksymalny wiek, który uzytkownik
    //          może wybrać dla zwierzęcia w zależności od jego gatunku>
    //************************************************
    public partial class MainPage : ContentPage
    {
        List<String> animals = new List<String>();
        public MainPage()
        {
            InitializeComponent();
            animals.Add("Pies");
            animals.Add("Kot");
            animals.Add("Świnka morska");
            animalsListView.ItemsSource = animals;
        }

        private void OnSubmitBtnClicked(object sender, EventArgs e)
        {
            string animal = (string)animalsListView.SelectedItem;
            string name = nameEntry.Text;
            string problem = probelmEntry.Text;
            string age = ageLbl.Text;
            string time = timePicker.Time.ToString();
            DisplayAlert("Zapisana Wizyta", $"{name}, {animal}, {age}, {problem}, {time}", "OK");
        }

        private void AgeSlider(object sender, ValueChangedEventArgs e)
        {
            Slider slider = (Slider)sender;
            int value = (int)slider.Value;
            ageLbl.Text = value.ToString();
        }

        private void OnAnimalTapped(object sender, ItemTappedEventArgs e)
        {
            string selectedAnimal = (string)animalsListView.SelectedItem;
            switch (selectedAnimal)
            {
                case "Pies":
                    ageSlider.Maximum = 18;
                    break;
                case "Kot":
                    ageSlider.Maximum = 20;
                    break;
                case "Świnka morska":
                    ageSlider.Maximum = 9;
                    break;
                default:
                    ageSlider.Maximum = 20;
                    break;
            }
        }
    }
}
