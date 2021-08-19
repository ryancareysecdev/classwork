//Ryan Carey
//FirstApplet
 
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class FirstApplet extends Applet {
	
	public void init() {
	}
	public void delay(int m) {
		try {
			Thread.sleep(m);
		}
		catch (InterruptedException e) {
		}
		finally {
		}
	}

	public void paint(Graphics g) {
		Random rc = new Random();
		for(int i = 0; i<500; i+=5) {
		Color c = new Color(rc.nextInt(256), rc.nextInt(256), rc.nextInt(256));
		g.setColor(c);
		delay(300);
		g.fillRect(i, 100, i+100, 200);
		}
	}
}
