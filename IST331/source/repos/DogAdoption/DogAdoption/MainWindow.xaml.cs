using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DogAdoption
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        String[] configString, splitConfig;
        Dog currentDog;
        List<Dog> dogList = new List<Dog>();
        public MainWindow()
        {
            InitializeComponent();
            try
            {
                configString = File.ReadAllLines("DogAdoption.txt");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
            }
            foreach (String dogString in configString)
            {
                splitConfig = dogString.Split(',');
                currentDog = new Dog(splitConfig[0].Trim(), splitConfig[1].Trim(), splitConfig[2].Trim(), splitConfig[3].Trim(), Boolean.Parse(splitConfig[4].Trim()), splitConfig[5].Trim(), splitConfig[6].Trim());
                dogList.Add(currentDog);
            }
        }

        private void LstRiley_Selected(object sender, RoutedEventArgs e)
        {
            foreach (Dog doggie in dogList)
            {
                if (doggie.getName() == (String)lstRiley.Content)
                {
                    currentDog = doggie;
                }
            }
            txtResults.Text = "Name: " + currentDog.getName() + ", Birthday: " + currentDog.getBDay() + ", Breed: " + currentDog.getBreed() + ", Weight: " + currentDog.getWeight() + ", Shots: " + currentDog.isIpToDate() + ", Months kenneled: " + currentDog.getMonths() + ", Picture: " + currentDog.getPic();
            txtResults.Visibility = System.Windows.Visibility.Visible;
            lblChosenName.Content = lstRiley.Content;
            imgSelectedDog.Source = new BitmapImage(new Uri(currentDog.getPic(), UriKind.Relative));
        }

        private void LstClifford_Selected(object sender, RoutedEventArgs e)
        {
            foreach (Dog doggie in dogList)
            {
                if (doggie.getName() == (String)lstClifford.Content)
                {
                    currentDog = doggie;
                }
            }
            txtResults.Text = "Name: " + currentDog.getName() + ", Birthday: " + currentDog.getBDay() + ", Breed: " + currentDog.getBreed() + ", Weight: " + currentDog.getWeight() + ", Shots: " + currentDog.isIpToDate() + ", Months kenneled: " + currentDog.getMonths() + ", Picture: " + currentDog.getPic();
            txtResults.Visibility = System.Windows.Visibility.Visible;
            lblChosenName.Content = lstClifford.Content;
            imgSelectedDog.Source = new BitmapImage(new Uri(currentDog.getPic(), UriKind.Relative));
        }

        private void LstScooby_Selected(object sender, RoutedEventArgs e)
        {
            foreach (Dog doggie in dogList)
            {
                if (doggie.getName() == (String)lstScooby.Content)
                {
                    currentDog = doggie;
                }
            }
            txtResults.Text = "Name: " + currentDog.getName() + ", Birthday: " + currentDog.getBDay() + ", Breed: " + currentDog.getBreed() + ", Weight: " + currentDog.getWeight() + ", Shots: " + currentDog.isIpToDate() + ", Months kenneled: " + currentDog.getMonths() + ", Picture: " + currentDog.getPic();
            txtResults.Visibility = System.Windows.Visibility.Visible;
            lblChosenName.Content = lstScooby.Content;
            imgSelectedDog.Source = new BitmapImage(new Uri(currentDog.getPic(), UriKind.Relative));
        }

        private void LstBalto_Selected(object sender, RoutedEventArgs e)
        {
            foreach (Dog doggie in dogList)
            {
                if (doggie.getName() == (String)lstBalto.Content)
                {
                    currentDog = doggie;
                }
            }
            txtResults.Text = "Name: " + currentDog.getName() + ", Birthday: " + currentDog.getBDay() + ", Breed: " + currentDog.getBreed() + ", Weight: " + currentDog.getWeight() + ", Shots: " + currentDog.isIpToDate() + ", Months kenneled: " + currentDog.getMonths() + ", Picture: " + currentDog.getPic();
            txtResults.Visibility = System.Windows.Visibility.Visible;
            lblChosenName.Content = lstBalto.Content;
            imgSelectedDog.Source = new BitmapImage(new Uri(currentDog.getPic(), UriKind.Relative));
        }

        private void BtnReset_Click(object sender, RoutedEventArgs e)
        {
            lblChosenName.Content = "";
            txtResults.Text = "";
            lstDogName.UnselectAll();
            imgSelectedDog.Source = null;
        }

        private void BtnExit_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnOrder_Click(object sender, RoutedEventArgs e)
        {
            ConfirmationWindow confirm = new ConfirmationWindow(currentDog);
            confirm.imgConfirmDog.Source = imgSelectedDog.Source;
            confirm.ShowDialog();
        }
    }
}
