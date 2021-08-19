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
using System.Windows.Shapes;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;

namespace CarSim
{
    //-------------------------------------------------------------------------
    public partial class MainWindow : Window
    {
        Boolean driverDoorOpen = false;
        static string[] DomeLightSettings = { "On", "Off", "Auto" };
        string domeLightState = DomeLightSettings[2];
        static string[] GearShiftSettings = { "PARK", "REVERSE", "NEUTRAL", "FIRST", "SECOND", "THIRD" };
        string gearShiftState = GearShiftSettings[0];
        static string[] IgnitionSettings = { "No_Key", "Off", "Accessory", "On" };
        string ignitionState = IgnitionSettings[0];
        static string[] TurnSignalSettings = { "Left", "Off", "Right" };
        string turnSignalState = TurnSignalSettings[1];
        static string[] WiperSettings = {"Fast", "Slow", "Off", "Single" };
        string wiperState = WiperSettings[2];
        Boolean seatBeltFastened = false;
        Boolean driverInSeat = false;
        string msgBeeping = "Beep";
        string openDoorMsg = "Close Door";
        string closedDoorMsg = "Open Door";
        string msgNoBeep, wiperString, turnString, ignitionString, doorString, windowString, domeString, gearString, headLightString, brakeString, driverString, seatString;

        private void BtnDriverSeat_Click(object sender, RoutedEventArgs e)
        {
            driverInSeat = !driverInSeat;
            if (driverInSeat)
                btnDriverSeat.Content = "Seat (Occupied)";
            else btnDriverSeat.Content = "Seat (Empty)";
        }

        //---------------------------------------------------------------------
        public MainWindow()
        {
            InitializeComponent();
        }
private void BtnDriverDoor_Click(object sender, RoutedEventArgs e)
        {
            driverDoorOpen = !driverDoorOpen;
            if (driverDoorOpen)
            {
                btnDriverDoor.Content = openDoorMsg;
            }
            else
            {
                btnDriverDoor.Content = closedDoorMsg;
            }
            UpdateInstrumentation();
        }
//---------------------------------------------------------------------
private void UpdateInstrumentation()
        {
            //-- Check the wipers
            if (wiperState != WiperSettings[2] && ignitionState != IgnitionSettings[0])
                wiperString = "Wipers set to: " + wiperState.ToString();
            else wiperString = "Wipers are off.";
            //-- Check the Dome Light
            if (((driverDoorOpen) && (domeLightState ==
                DomeLightSettings[2])) ||
                (domeLightState == DomeLightSettings[0]))
            {
                domeLight.Fill = Brushes.Yellow;
            }
            else
            {
                domeLight.Fill = Brushes.White;
            }
            if (driverInSeat && !seatBeltFastened)
                imgSeatBelt.Visibility = System.Windows.Visibility.Visible;
            else imgSeatBelt.Visibility = System.Windows.Visibility.Hidden;
            //-- Display appropriate Gear Shift Posn.
            if (gearShiftState == GearShiftSettings[0])
                lblGearState.Content = "Gear: " + GearShiftSettings[0];
            if (gearShiftState == GearShiftSettings[1])
                lblGearState.Content = "Gear: " + GearShiftSettings[1];
            if (gearShiftState == GearShiftSettings[2])
                lblGearState.Content = "Gear: " + GearShiftSettings[2];
            if (gearShiftState == GearShiftSettings[3])
                lblGearState.Content = "Gear: " + GearShiftSettings[3];
            if (gearShiftState == GearShiftSettings[4])
                lblGearState.Content = "Gear: " + GearShiftSettings[4];
            if (gearShiftState == GearShiftSettings[5])
                lblGearState.Content = "Gear: " + GearShiftSettings[5];
            //-- Check the Door Chime.
            if ((slideIgnition.Value != 0) &&
            (driverDoorOpen))
                lblDoorChime.Content = msgBeeping;
            else
                lblDoorChime.Content = msgNoBeep;

            txtSummary.Text = wiperString + turnString + ignitionString + doorString + windowString + domeString + gearString + headLightString + brakeString + driverString + seatString;
        }

        private void SlideDomeLight_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (slideDomeLight.Value == 0)
                domeLightState = DomeLightSettings[0];
            else if (slideDomeLight.Value == 1)
                domeLightState = DomeLightSettings[1];
            else if (slideDomeLight.Value == 2)
                domeLightState = DomeLightSettings[2];
            UpdateInstrumentation();
        }

        private void SlideTurnSignal_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (slideTurnSignal.Value == 0)
                turnSignalState = TurnSignalSettings[0];
            else if (slideTurnSignal.Value == 1)
                turnSignalState = TurnSignalSettings[1];
            else if (slideTurnSignal.Value == 2)
                turnSignalState = TurnSignalSettings[2];
            UpdateInstrumentation();
        }

        private void SlideWiper_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (slideWiper.Value == 0)
                wiperState = WiperSettings[0];
            else if (slideWiper.Value == 1)
                wiperState = WiperSettings[1];
            else if (slideWiper.Value == 2)
                wiperState = WiperSettings[2];
            else if (slideWiper.Value == 3)
                wiperState = WiperSettings[3];
            UpdateInstrumentation();
        }

        private void SlideIgnition_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (slideIgnition.Value == 0)
                ignitionState = IgnitionSettings[0];
            else if (slideIgnition.Value == 1)
                ignitionState = IgnitionSettings[1];
            else if (slideIgnition.Value == 2)
                ignitionState = IgnitionSettings[2];
            else if (slideIgnition.Value == 3)
                ignitionState = IgnitionSettings[3];
            UpdateInstrumentation();
        }

        private void SlideSeatBelt_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (slideSeatBelt.Value == 1)
                seatBeltFastened = true;
            else
                seatBeltFastened = false;
            UpdateInstrumentation();
        }

        private void DomeLight_Initialized(object sender, EventArgs e)
        {
            Ellipse domeLight = sender as Ellipse;
            while (true)
            {
                if (((driverDoorOpen) && (domeLightState ==
                DomeLightSettings[2])) ||
                (domeLightState == DomeLightSettings[0]))
                {
                    domeLight.Fill = Brushes.Yellow;
                }
                else
                {
                    domeLight.Fill = Brushes.White;
                }
            }
        }
    }
}

