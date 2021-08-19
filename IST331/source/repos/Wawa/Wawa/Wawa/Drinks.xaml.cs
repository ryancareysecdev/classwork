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
    public partial class Drinks : Window
    {
        public Drinks()
        {
            InitializeComponent();
        }

        private void Coffee_Initialized()
        {

        }

        private void BtnCoffee_Click(object sender, RoutedEventArgs e)
        {
            Coffee coffeeMenu = new Coffee();
            coffeeMenu.Show();
            this.Close();
        }

        private void BtnBottled_Click(object sender, RoutedEventArgs e)
        {
            Window1 emptyWindow = new Window1();
            emptyWindow.Show();
            this.Close();
        }

        private void BtnFrozen_Click(object sender, RoutedEventArgs e)
        {
            Window1 emptyWindow = new Window1();
            emptyWindow.Show();
            this.Close();
        }

        private void BtnReturntoMain_Click(object sender, RoutedEventArgs e)
        {
            MainMenu newMain = new MainMenu();
            newMain.Show();
            this.Close();
        }
    }
}
