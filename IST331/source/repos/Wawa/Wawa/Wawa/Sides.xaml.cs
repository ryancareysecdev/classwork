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
    /// Interaction logic for Sides.xaml
    /// </summary>
    public partial class Sides : Window
    {
        public Sides()
        {
            InitializeComponent();
        }

        private void btnStuffing_Click(object sender, RoutedEventArgs e)
        {
            lstWawaListPrice.Items.Add("Stuffing" + ": $" + imgStuffing.Tag);
            glob_var.runningTotal += float.Parse(imgStuffing.Tag.ToString());
        }

        private void btnMeatballsClick(object sender, RoutedEventArgs e)
        {
            lstWawaListPrice.Items.Add("Meatballs" + ": $" + imgMeatballs.Tag);
            glob_var.runningTotal += float.Parse(imgMeatballs.Tag.ToString());
        }

        private void btnReturnClick(object sender, RoutedEventArgs e)
        {
            foreach (var item in lstWawaListPrice.Items)
            {
                glob_var.lstConfirmation += item.ToString() + "\n";
            }
            MainMenu freshMain = new MainMenu(); 
            freshMain.Show();
            this.Close();
        }

        private void btnMacandChessesClick(object sender, RoutedEventArgs e)
        {
            lstWawaListPrice.Items.Add("Mac and Cheese" + ": $" + imgMac.Tag);
            glob_var.runningTotal += float.Parse(imgMac.Tag.ToString());
        }

        private void btnMashed_Potatoes_Click(object sender, RoutedEventArgs e)
        {
            lstWawaListPrice.Items.Add("Mashed Potatoes" + ": $" + imgMashed.Tag);
            glob_var.runningTotal += float.Parse(imgMashed.Tag.ToString());
        }
    }
}
