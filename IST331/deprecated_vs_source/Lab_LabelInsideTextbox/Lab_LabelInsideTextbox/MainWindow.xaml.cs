//Ryan Carey
//IST331 Professor Ganther
//Label inside textbox
//ruc230@psu.edu
//4-19-2020
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

namespace Lab_LabelInsideTextbox
{
	/// <summary>
	/// Interaction logic for MainWindow.xaml
	/// </summary>
	public partial class MainWindow : Window
	{

		SolidColorBrush NO_TEXT_BRUSH = Brushes.Gray;
		SolidColorBrush SOME_TEXT_BRUSH = Brushes.Black;


		//---------------------------------------------------------------------------
		public MainWindow()
		{
			InitializeComponent();
		}

		//---------------------------------------------------------------------------
		private void winMain_ContentRendered(object sender, EventArgs e)
		{
		}

		//---------------------------------------------------------------------------
		private void txtMain_GotFocus(object sender, RoutedEventArgs e)
		{
            if (txtMain.Text.Equals(txtMain.Tag.ToString()))
            {
                txtMain.Text = "";
                txtMain.Foreground = SOME_TEXT_BRUSH;
                txtMain.Select(0, 0);
            }
            txtDisplay.Text = "";
        }

		//---------------------------------------------------------------------------

		//---------------------------------------------------------------------------
		private void txtMain_LostFocus(object sender, RoutedEventArgs e)
		{
            txtDisplay.Text = txtMain.Text;
            if (txtMain.Text.Equals(""))
            {
                txtMain.Foreground = NO_TEXT_BRUSH;
                txtMain.Text = txtMain.Tag.ToString();
            }
        }

        private void btnExit_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void btnReset_Click(object sender, RoutedEventArgs e)
        {
            txtMain.Text = txtMain.Tag.ToString();
            txtMain.Foreground = NO_TEXT_BRUSH;
            txtDisplay.Text = "";
        }

        private void txtMain_TextInput(object sender, TextCompositionEventArgs e)
        {
            if (txtMain.Text.Equals(""))
            {
                txtMain.Foreground = NO_TEXT_BRUSH;
                txtMain.Text = txtMain.Tag.ToString();
                txtMain.Select(0, 0);
            }
        }
    }
}

