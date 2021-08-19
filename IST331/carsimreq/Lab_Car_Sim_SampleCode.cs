
namespace Car_Simulation
{
	//-------------------------------------------------------------------------
	public partial class MainWindow : Window
	{
		Boolean gDriverDoorOpen = false;

		enum DomeLightSettings { On, Off, Auto };
		DomeLightSettings gDomeLightState = DomeLightSettings.Auto;

		enum GearShiftPosns { PARK, REVERSE, NEUTRAL, DRIVE };
		GearShiftPosns gGearShiftState = GearShiftPosns.PARK;

		Boolean gSeatBeltFastened = false;

		//---------------------------------------------------------------------
		public MainWindow()
		{
			InitializeComponent();
		}

		//-----------------------------------------------------------------------------
		private void BtnDriverDoor_Click(object sender, RoutedEventArgs e)
		{
			gDriverDoorOpen = !gDriverDoorOpen;

			if (gDriverDoorOpen)
			{
				btnDriverDoor.Content = msgCloseDriverDoor;
				lblDoorState.Content = msgOpen;
			}
			else
			{
				btnDriverDoor.Content = msgOpenDriverDoor;
				lblDoorState.Content = msgClosed;
			}
			UpdateInstrumentation();
		}

		//---------------------------------------------------------------------------
		private void RadDomeLightOn_Checked(object sender, RoutedEventArgs e)
		{
			gDomeLightState = DomeLightSettings.On;
			UpdateInstrumentation();
		}

		private void RadDomeLightOff_Checked(object sender, RoutedEventArgs e)
		{
			gDomeLightState = DomeLightSettings.Off;
			UpdateInstrumentation();
		}

		private void RadDomeLightAuto_Checked(object sender, RoutedEventArgs e)
		{
			gDomeLightState = DomeLightSettings.Auto;
			UpdateInstrumentation();
		}

		//---------------------------------------------------------------------------
		private void UpdateInstrumentation()
		{
			int idx; string s1;

			//-- Check the Dome Light
			if (((gDriverDoorOpen) && (gDomeLightState == DomeLightSettings.Auto)) ||
				(gDomeLightState == DomeLightSettings.On))
			{
				instDomeLight.Background = Brushes.Yellow;
				instDomeLight.Content = msgOn;
			}
			else
			{
				instDomeLight.Background = Brushes.White;
				instDomeLight.Content = msgOff;
			}

			//-- Display appropriate Gear Shift Posn.
			if (gGearShiftState == GearShiftPosns.PARK) instGearShiftPosn.Background = Brushes.LightCoral;
			if (gGearShiftState == GearShiftPosns.REVERSE) instGearShiftPosn.Background = Brushes.LightGray;
			if (gGearShiftState == GearShiftPosns.NEUTRAL) instGearShiftPosn.Background = Brushes.LightBlue;
			if (gGearShiftState == GearShiftPosns.DRIVE) instGearShiftPosn.Background = Brushes.LightGreen;
			idx = (int)gGearShiftState;
			s1 = (lstGearShift.Items.GetItemAt(idx)).ToString();
			if ((idx = s1.IndexOf(':')) != -1)
				s1 = s1.Substring(idx + 2);
			instGearShiftPosn.Content = s1;


			//-- Check the Door Chime.
			if ((gIgnitionState != IgnitionSettings.NO_KEY) && (gDriverDoorOpen))
				instDoorChime.Content = msgBeeping;
			else
				instDoorChime.Content = msgOff;
		}

	}
}

