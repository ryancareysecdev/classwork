
//Ryan Carey, self explanatory if ever there was such a thing.
public class Lab4_LoopingThruTime
{
	public static void main(String[] args)
	{
   int hours=0, mins=0, seconds=0, loopcount=0;
		for(hours=0; hours<24; hours++)
		{
			for(mins=0; mins<60; mins++)
			{
				for(seconds=0; seconds<60; seconds++)
				{
				System.out.printf ("%02d:%02d:%02d\n", hours, mins, seconds);
            loopcount++;
				}
			}
		}
   System.out.print(loopcount);
	}
}