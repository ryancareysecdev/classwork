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

namespace Wawa
{
    /// <summary>
    /// Interaction logic for Hoagies.xaml
    /// </summary>
    public partial class Hoagies : Window
    {
        public Hoagies()
        {
            InitializeComponent();
        }

        private void BtnReturn2_Click(object sender, RoutedEventArgs e)
        {
            Lunch lunch_Window = new Lunch();
            lunch_Window.Show();
            this.Close();
        }

        private void BtnChicken1_Click(object sender, RoutedEventArgs e)
        {
            lstHoagies.Items.Add("Chicken Chowdown");
        }

        private void BtnBeef_Click(object sender, RoutedEventArgs e)
        {
            lstHoagies.Items.Add("Beefsteak Burger");
        }

        private void BtnChickenPesto_Click(object sender, RoutedEventArgs e)
        {
            lstHoagies.Items.Add("Chicken Pesto");
            
        }

        private void BtnGiuseppe_Click(object sender, RoutedEventArgs e)
        {
            lstHoagies.Items.Add("The Giuseppe");
        }
    }
}
