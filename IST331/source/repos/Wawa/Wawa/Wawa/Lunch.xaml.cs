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
    public partial class Lunch : Window
    {
        public Lunch()
        {
            InitializeComponent();
        }

        private void Hoagies_Button_Click(object sender, RoutedEventArgs e)
        {
            Hoagies hoagies = new Hoagies();
            hoagies.Show();
            this.Close();
        }

        private void BtnSandwiches_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Window Under Contruction, Try Hoagies");
        }

        private void BtnSalad_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Window Under Contruction, Try Hoagies");
        }

        private void BtnQuesadillas_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Window Under Contruction, Try Hoagies");
        }
    }
}
