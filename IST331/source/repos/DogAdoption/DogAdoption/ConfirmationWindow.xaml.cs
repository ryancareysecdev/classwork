using System;
using System.Collections.Generic;
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
using System.Windows.Shapes;

namespace DogAdoption
{
    /// <summary>
    /// Interaction logic for ConfirmationWindow.xaml
    /// </summary>
    public partial class ConfirmationWindow : Window
    {
        Dog chosenDog;
        public ConfirmationWindow(Dog passedDog)
        {
            InitializeComponent();
            chosenDog = passedDog;
            txtConfirm.Text = "Name: " + chosenDog.getName() + ", Birthday: " + chosenDog.getBDay() + ", Breed: " + chosenDog.getBreed() + ", Weight: " + chosenDog.getWeight() + ", Shots: " + chosenDog.isIpToDate() + ", Months kenneled: " + chosenDog.getMonths() + ", Picture: " + chosenDog.getPic();

        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnConfirm_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("You have successfully adopted " + chosenDog.getName());
        }
    }
}
