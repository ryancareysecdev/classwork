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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Wawa
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainMenu : Window
    {
        public MainMenu()
        {
            InitializeComponent();
            if (glob_var.lstConfirmation != null)
            {
                string[] splitReceipt = glob_var.lstConfirmation.Split(glob_var.newLine);
                foreach (string item in splitReceipt)
                {
                    lstReceipt.Items.Add(item);
                }
                lstReceipt.Items.Add("Total price: $" + glob_var.runningTotal.ToString(".00"));
            }
        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void imgSides_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Sides side_window = new Sides();
            side_window.Show();
            this.Close();
        }

        private void imgDrinks_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Drinks drinkMenu = new Drinks();
            drinkMenu.Show();
            this.Close();
        }

        private void imgLunch_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {

        }
    }
}
