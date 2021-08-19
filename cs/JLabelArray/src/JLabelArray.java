//Ryan Carey's JLabelArray
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class JLabelArray {
	JFrame frame = new JFrame();
	JLabel[][] grid;
	Random generate = new Random();
	public JLabelArray(int width, int height){
		grid = new JLabel[width][height];
		frame.setLayout(new GridLayout(width,height));
		frame.setTitle("JLabelArray");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i<width; i++) {
			for(int c=0; c<height; c++) {
				grid[i][c]=new JLabel(""+generate.nextInt(2));
				frame.add(grid[i][c]);
			}
		}
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new JLabelArray(10, 10);
	}

}
