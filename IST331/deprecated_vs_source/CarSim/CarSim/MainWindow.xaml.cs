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

namespace CarSim
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Boolean headLightsOn = false, wipersOn = false, doorOpen = false, seatTaken = false, beltFastened = false, carLocked = false, brakePedalPushed = false;
        String msgOpen = "Open Door", msgClose = "Close Door", msgSit = "Take A Seat", msgGetOut = "Get Out", msgHeadLightsOn = "Turn On Headlights", msgHeadLightsOff = "Turn Off Headlights", msgWipersOn = "Wipers On", msgWipersOff = "Wipers Off", msgLock = "Lock The Car", msgUnlock = "Unlock The Car";
        enum domeSettings { Off, Auto, On };
        domeSettings domeSwitch = domeSettings.Off;
        enum gears { Park, Reverse, Neutral, Drive};
        gears gear = gears.Park;
        enum turnSignalSettings { Left, Off, Right };
        turnSignalSettings turnSignalSwitch = turnSignalSettings.Off;
        enum ignitionSettings { No_Key, Off, Accessory, On };
        ignitionSettings ignitionSwitch = ignitionSettings.No_Key;

        private void radDrive_Checked(object sender, RoutedEventArgs e)
        {
            gear = gears.Drive;
            UpdateInstrumentation();
        }

        private void radNeutral_Checked(object sender, RoutedEventArgs e)
        {
            gear = gears.Neutral;
            UpdateInstrumentation();
        }

        private void radReverse_Checked(object sender, RoutedEventArgs e)
        {
            gear = gears.Reverse;
            UpdateInstrumentation();
        }

        private void btnBrakePedal_Click(object sender, RoutedEventArgs e)
        {
            brakePedalPushed = !brakePedalPushed;
            UpdateInstrumentation();
        }

        Uri turnLeftImgSrc = new Uri("turnleft.jpg", UriKind.Relative);
        Uri turnRightImgSrc = new Uri("turnright.jpg", UriKind.Relative);
        BitmapImage imgTurnSignalSrc = new BitmapImage();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void radPark_Checked(object sender, RoutedEventArgs e)
        {
            gear = gears.Park;
            UpdateInstrumentation();
        }
        private void sliderDomeLight_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (IsLoaded)
            {
                switch (sliderDomeLight.Value)
                {
                    case 0:
                        domeSwitch = domeSettings.Off;
                        break;
                    case 1:
                        domeSwitch = domeSettings.Auto;
                        break;
                    case 2:
                        domeSwitch = domeSettings.On;
                        break;
                }
            }
            UpdateInstrumentation();
        }
        private void btnLockDoor_Click(object sender, RoutedEventArgs e)
        {
            if (btnLockDoor.Content.Equals(msgLock))
                btnLockDoor.Content = msgUnlock;
            else
                btnLockDoor.Content = msgLock;
            carLocked = !carLocked;
            UpdateInstrumentation();
        }
        private void sliderTurnSignal_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (IsLoaded)
            {
                switch (sliderTurnSignal.Value)
                {
                    case 0:
                        turnSignalSwitch = turnSignalSettings.Left;
                        break;
                    case 1:
                        turnSignalSwitch = turnSignalSettings.Off;
                        break;
                    case 2:
                        turnSignalSwitch = turnSignalSettings.Right;
                        break;
                }
            }
            UpdateInstrumentation();
        }
        private void sliderIgnition_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (IsLoaded)
            {
                switch (sliderIgnition.Value)
                {
                    case 0:
                        ignitionSwitch = ignitionSettings.No_Key;
                        break;
                    case 1:
                        ignitionSwitch = ignitionSettings.Off;
                        break;
                    case 2:
                        ignitionSwitch = ignitionSettings.Accessory;
                        break;
                    case 3:
                        ignitionSwitch = ignitionSettings.On;
                        break;
                }
            }
            UpdateInstrumentation();
        }
        private void sliderSeatbelt_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (sliderSeatbelt.Value == 0)
                beltFastened = false;
            else
            {
                beltFastened = true;
            }
            UpdateInstrumentation();
        }

        private void btnDoor_Click(object sender, RoutedEventArgs e)
        {
            if (btnDoor.Content.Equals(msgOpen))
                btnDoor.Content = msgClose;
            else
                btnDoor.Content = msgOpen;
            doorOpen = !doorOpen;
            UpdateInstrumentation();
        }

        private void btnDriverSeat_Click(object sender, RoutedEventArgs e)
        {
            if (btnDriverSeat.Content.Equals(msgSit))
                btnDriverSeat.Content = msgGetOut;
            else
                btnDriverSeat.Content = msgSit;
            seatTaken = !seatTaken;
            UpdateInstrumentation();
        }

        private void btnHeadLights_Click(object sender, RoutedEventArgs e)
        {
            if (btnHeadLights.Content.Equals(msgHeadLightsOn))
                btnHeadLights.Content = msgHeadLightsOff;
            else
                btnHeadLights.Content = msgHeadLightsOn;
            headLightsOn = !headLightsOn;
            UpdateInstrumentation();
        }

        private void btnWipers_Click(object sender, RoutedEventArgs e)
        {
            if (btnWipers.Content.Equals(msgWipersOn))
                btnWipers.Content = msgWipersOff;
            else
                btnWipers.Content = msgWipersOn;
            wipersOn = !wipersOn;
            UpdateInstrumentation();
        }
        private void UpdateInstrumentation()
        {
            if (IsLoaded)
            {
                if (seatTaken & !beltFastened)
                    imgSeatIcon.Visibility = Visibility.Visible;
                else
                    imgSeatIcon.Visibility = Visibility.Hidden;
                if (headLightsOn)
                {
                    headLight1.Fill = Brushes.Yellow;
                    headLight2.Fill = Brushes.Yellow;
                }
                else
                {
                    headLight1.Fill = Brushes.LightGray;
                    headLight2.Fill = Brushes.LightGray;
                }
                if (brakePedalPushed)
                    btnBrakePedal.Content = "Brake (On)";
                else
                    btnBrakePedal.Content = "Brake (Off)";
                //-- Check the Dome Light
                if ((doorOpen && (domeSwitch == domeSettings.Auto)) ||
                    (domeSwitch == domeSettings.On))
                {
                    domeLight.Fill = Brushes.Yellow;
                }
                else
                {
                    domeLight.Fill = Brushes.White;
                }
                //gears can only be changed out of park if the car is running and foot is on the break
                if (!((ignitionSwitch == ignitionSettings.On) & brakePedalPushed))
                {
                    radPark.IsChecked = true;
                }
                switch (turnSignalSwitch)
                {
                    case turnSignalSettings.Left:
                        imgTurnSignalSrc.UriSource = turnLeftImgSrc;
                        imgTurnSignal.Source = imgTurnSignalSrc;
                        imgTurnSignal.Visibility = Visibility.Visible;
                        break;
                    case turnSignalSettings.Off:
                        imgTurnSignal.Visibility = Visibility.Hidden;
                        break;
                    case turnSignalSettings.Right:
                        imgTurnSignalSrc.UriSource = turnLeftImgSrc;
                        imgTurnSignal.Source = imgTurnSignalSrc;
                        imgTurnSignal.Visibility = Visibility.Visible;
                        break;
                }
                imgTurnSignal.Source = imgTurnSignalSrc;

                if (doorOpen)
                    imgDoorIcon.Visibility = Visibility.Visible;
                else
                    imgDoorIcon.Visibility = Visibility.Hidden;
                //-- Check the Door Chime.
                if ((((ignitionSwitch != ignitionSettings.No_Key) && (doorOpen))) || (!beltFastened && seatTaken))
                {
                    for (int i = 0; i < 3; i++)
                    {
                        System.Media.SystemSounds.Beep.Play();
                        System.Threading.Thread.Sleep(500);
                    }
                }
            }
        }
    }
}