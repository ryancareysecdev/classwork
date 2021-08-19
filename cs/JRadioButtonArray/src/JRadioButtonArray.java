//Ryan Carey's JRadioButtonArray
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class JRadioButtonArray {
	JFrame frame = new JFrame();
	JRadioButton[][] grid;
	Random generate = new Random();
	public JRadioButtonArray(int width, int height){
		grid = new JRadioButton[width][height];
		frame.setLayout(new GridLayout(width,height));
		frame.setTitle("Radio Button Array");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i<width; i++) {
			for(int c=0; c<height; c++) {
				grid[i][c]=new JRadioButton(""+c);
				frame.add(grid[i][c]);
				
			}
		}
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new JRadioButtonArray(10, 10);
	}

}
