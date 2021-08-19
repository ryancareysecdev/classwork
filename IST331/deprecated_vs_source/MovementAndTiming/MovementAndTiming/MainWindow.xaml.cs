//Ryan Carey
//ruc230@psu.edu
//MovementAndTimingLab
//4/18/2020

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
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

namespace MovementAndTiming
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        double windowTop, windowLeft, windowRight;
        Thickness newBtnPos;
        double[] oldBtnPos, windowMargins;
        bool goingForward = true;
        DispatcherTimer myTimer = new DispatcherTimer();
        ThicknessConverter workPlease = new ThicknessConverter();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void sliderDelay_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            myTimer.Interval = TimeSpan.FromMilliseconds(sliderDelay.Value);
            if (this.IsLoaded)
            {
                lblTimeDelay.Content = "Delay: " + sliderDelay.Value;
            }
        }

        private void OnlyMain_Loaded(object sender, RoutedEventArgs e)
        {
            myTimer.Interval = TimeSpan.FromMilliseconds(sliderDelay.Value);
            myTimer.Tick += new EventHandler(myTimer_Tick);
            windowMargins = Array.ConvertAll(workPlease.ConvertToString(this.Margin).Trim('(', ')').Split(','), Double.Parse);
            myGrid.Margin = this.Margin;
            windowTop = windowMargins[0];
            windowLeft = windowMargins[1];
            windowRight = windowLeft + ActualWidth;
        }

        private void btnExit_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void btnStartStop_Click(object sender, RoutedEventArgs e)
        {
            if (btnStartStop.Content.Equals("Start"))
            {
                myTimer.Start();
                btnStartStop.Content = "Stop";
            }
            else if (btnStartStop.Content.Equals("Stop"))
            {
                myTimer.Stop();
                btnStartStop.Content = "Start";
            }
        }

        private void OnlyMain_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            windowMargins = Array.ConvertAll(workPlease.ConvertToString(this.Margin).Trim('(', ')').Split(','), Double.Parse);
            myGrid.Margin = this.Margin;
            windowTop = windowMargins[0];
            windowLeft = windowMargins[1];
            windowRight = windowLeft + ActualWidth;
        }

        private void sliderStepSize_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (this.IsLoaded)
            {
                lblStepSize.Content = "Step: " + sliderStepSize.Value;
            }
        }

        private void btnStep_Click(object sender, RoutedEventArgs e)
        {
            myTimer.Stop();
            btnStartStop.Content = "Start";
            step();
        }

        private void myTimer_Tick(object sender, EventArgs e)
        {
            //-- When reach the end of the #s, stop the timer + misc.
            step();
        }
        //Most of the logic is here. The conversion to double arrays was a little tricky at first, so I could manipulate margins more directly.
        private void step()
        {
            oldBtnPos = Array.ConvertAll(workPlease.ConvertToString(btnThatMoves.Margin).Trim('(', ')').Split(','), Double.Parse);
            if (goingForward == true)
            {
                if ((oldBtnPos[0] + btnThatMoves.ActualWidth + sliderStepSize.Value + 14) < ActualWidth)
                {
                    newBtnPos = new Thickness(oldBtnPos[0] + sliderStepSize.Value, oldBtnPos[1], oldBtnPos[2], oldBtnPos[3]);
                    btnThatMoves.Margin = newBtnPos;
                }
                else
                {
                    goingForward = false;
                    newBtnPos = new Thickness(ActualWidth - btnThatMoves.ActualWidth - 14, oldBtnPos[1], oldBtnPos[2], oldBtnPos[3]);
                    btnThatMoves.Margin = newBtnPos;
                }
                
            }
            else
            {
                if ((oldBtnPos[0] - sliderStepSize.Value) > windowLeft)
                {
                    newBtnPos = new Thickness(oldBtnPos[0] - sliderStepSize.Value, oldBtnPos[1], oldBtnPos[2], oldBtnPos[3]);
                    btnThatMoves.Margin = newBtnPos;
                }
                else
                {
                    newBtnPos = new Thickness(windowLeft, oldBtnPos[1], oldBtnPos[2], oldBtnPos[3]);
                    btnThatMoves.Margin = newBtnPos;
                    goingForward = true;
                }
                
            }
        }
    }
}
