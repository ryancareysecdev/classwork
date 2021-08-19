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
using Wawa;

namespace Wawa
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Coffee : Window
    {
        public Coffee()
        {
            InitializeComponent();
        }

        private void BtnDecaf_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblDecaf.Content + ": $" + btnDecaf.Tag);
            glob_var.runningTotal += float.Parse(btnDecaf.Tag.ToString());
        }

        private void BtnColombian_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblColombian.Content + ": $" + btnColombian.Tag);
            glob_var.runningTotal += float.Parse(btnColombian.Tag.ToString());
        }

        private void BtnCuban_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblCuban.Content + ": $" + btnCuban.Tag);
            glob_var.runningTotal += float.Parse(btnCuban.Tag.ToString());
        }
        private void BtnRegular_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblRegular.Content + ": $" + btnRegular.Tag);
            glob_var.runningTotal += float.Parse(btnRegular.Tag.ToString());
        }

        private void BtnGuatemalan_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblGuatemala.Content + ": $" + btnGuatemalan.Tag);
            glob_var.runningTotal += float.Parse(btnGuatemalan.Tag.ToString());
        }

        private void BtnDark_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblDark.Content + ": $" + btnDark.Tag);
            glob_var.runningTotal += float.Parse(btnDark.Tag.ToString());
        }

        private void BtnHazelnut_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblHazelnut.Content + ": $" + btnHazelnut.Tag);
            glob_var.runningTotal += float.Parse(btnHazelnut.Tag.ToString());
        }

        private void BtnSumatran_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblSumatran.Content + ": $" + btnSumatran.Tag);
            glob_var.runningTotal += float.Parse(btnSumatran.Tag.ToString());
        }

        private void BtnFrench_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Add(lblDark.Content + ": $" + btnFrench.Tag);
            glob_var.runningTotal += float.Parse(btnFrench.Tag.ToString());
        }

        private void BtnClearList_Click(object sender, RoutedEventArgs e)
        {
            lstChosenCoffee.Items.Clear();
            glob_var.runningTotal = 0;
        }

        private void BtnReturn_Click(object sender, RoutedEventArgs e)
        {
            foreach (var item in lstChosenCoffee.Items)
            {
                glob_var.lstConfirmation += (item.ToString()) + "\n";
            }
            MainMenu mainMenu = new MainMenu();
            mainMenu.Show();
            this.Close();
        }
    }
}
