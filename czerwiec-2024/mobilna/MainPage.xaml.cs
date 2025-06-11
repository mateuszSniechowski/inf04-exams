namespace GraKosciMobilna
{
    public partial class MainPage : ContentPage
    {
        public int gameScore;

        public MainPage()
        {
            InitializeComponent();
        }

        private void OnThrowButtonClicked(object sender, EventArgs e)
        {
            int[] randomNum = new int[5];

            // GET RANDOM NUMBERS
            for (int i = 0; i < randomNum.Length; i++) 
            {
                Random random = new Random();
                randomNum[i] = random.Next(1, 6);
            }

            // COUNT POINTS
            List<int> duplicates = new List<int>();
            int points = 0;
            for (int i = 0; i < randomNum.Length; i++)
            {
                int currentNum = randomNum[i];
                int counter = 0;

                for (int j = 0; j < randomNum.Length; j++) 
                {
                    if (randomNum[j] == currentNum) 
                    { 
                        counter++;
                    }
                }

                if (counter > 1 && !duplicates.Contains(currentNum)) 
                {
                    points += currentNum * counter;
                    duplicates.Add(currentNum);
                }
            }
            gameScore += points;
            gamePointsLbl.Text = "Wynik tego losowania: " + points;
            gameScoreLbl.Text = "Wynik gry: " + gameScore;

            // DISPLAY IMAGES


            Image[] imagesArray = [ firstImg, secondImg, thirdImg, fourthImg, fifthImg ];
            

            for (int i = 0; i < randomNum.Length; i++)
            {
                switch (randomNum[i]) 
                {
                    case 1:
                        imagesArray[i].Source = "one.png";
                        break;
                    case 2:
                        imagesArray[i].Source = "two.png";
                        break;
                    case 3:
                        imagesArray[i].Source = "three.png";
                        break;
                    case 4:
                        imagesArray[i].Source = "four.png";
                        break;
                    case 5:
                        imagesArray[i].Source = "five.png";
                        break;
                    case 6:
                        imagesArray[i].Source = "six.png";
                        break;
                    default:
                        imagesArray[i].Source = "question.jpg";
                        break;
                }
            }
        }


        //************************************************
        // nazwa: <OnResetButtonClicked>
        // opis: <Metoda obsługuje kliknięcie przycisku RESETUJ WYNIK.
        //        Po kliknięciu wszystkie obrazy są ustawiane na obaz
        //        question.jpg oraz "wynik tego losowania" jest ustawiany na 0,
        //        dodatkowo "Wynik gry" również jest ustawiany na 0>
        // parametry: <sender - obiet wywołujący zdarzenie>
        //            <e  - argumenty zdarzenia. Brak szczególnych danych. >
        //...
        // zwracany typ i opis:<brak>
        //************************************************
        private void OnResetButtonClicked(object sender, EventArgs e)
        {
            firstImg.Source = "question.jpg";
            secondImg.Source = "question.jpg";
            thirdImg.Source = "question.jpg";
            fourthImg.Source = "question.jpg";
            fifthImg.Source = "question.jpg";
            
            gamePointsLbl.Text = "Wynik tego losowania: 0";
            gameScore = 0;
            gameScoreLbl.Text = "Wynik gry: " + gameScore;
        }
    }

}
