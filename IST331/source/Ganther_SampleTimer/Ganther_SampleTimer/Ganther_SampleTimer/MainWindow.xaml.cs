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
using System.Windows.Threading;

//-----------------------------------------------------------------------------
namespace Ganther_SampleTimer
{

	//----------------------------------------------------------------------------
	public partial class MainWindow : Window
	{
		const int MILLISECOND_DELAY = 040;	// the delay between displaying #s

		DispatcherTimer testTimer;


		//---------------------------------------------------------------------------
		public MainWindow()
		{
			InitializeComponent();
		}

		//---------------------------------------------------------------------------
		private void winMain_ContentRendered(object sender, EventArgs e)
		{
			testTimer_Setup();
		}

		//---------------------------------------------------------------------
		private void testTimer_Setup()
		{
			//-- 3 important lines of code for setting up a timer.
			testTimer = new DispatcherTimer();
			testTimer.Tick += TestTimer_Tick;
			testTimer.Interval = TimeSpan.FromMilliseconds(MILLISECOND_DELAY);
		}

		//---------------------------------------------------------------------
		private void btnStartTest_Click(object sender, RoutedEventArgs e)
		{
			if (btnStartTest.Content.Equals("Start Test"))
			{
				btnStartTest.Content = "Stop Test";
				//-- Storing the later # in the Timer's Tag property.
				testTimer.Tag = Convert.ToInt32(txtStartingValue.Text);
				txtTest.Foreground = Brushes.Red;	// assume starting value is negative.
				testTimer.Start();
			}
			else
			{
				btnStartTest.Content = "Start Test";
				testTimer.Stop();
			}

		}

		private void TestTimer_Tick(object sender, EventArgs e)
		{
			int i, incr;
			//-- the Tag propery is holding next number to display.
			i = Convert.ToInt32(testTimer.Tag);

			//-- Positive #s are displayed in a different color.
			if ((i >= 0) && (txtTest.Foreground != Brushes.Green))
				txtTest.Foreground = Brushes.Green;
			txtTest.Text = i.ToString();

			//-- When reach the end of the #s, stop the timer + misc.
			if (i >= Convert.ToInt32(txtEndingValue.Text))
			{
				testTimer.Stop();
				testTimer.Tag = Convert.ToInt32(txtStartingValue.Text);
				btnStartTest.Content = "Start Test";
			}
			else
			{
				//-- if too many #s to display, calc an increment value.
				incr = Convert.ToInt32(txtEndingValue.Text) - Convert.ToInt32(txtStartingValue.Text);

				//-- If range of #s is too large, loop by a higher incr.
				incr = incr / 100;
				if (incr <= 0)
					incr = 1;
				int newI = i + incr;

				//-- Make sure stop exactly at the high value.
				if (newI > Convert.ToInt32(txtEndingValue.Text))  
					testTimer.Tag = Convert.ToInt32(txtEndingValue.Text);
				else
					testTimer.Tag = newI;
			}

		}
		//---------------------------------------------------------------------


	}


}
