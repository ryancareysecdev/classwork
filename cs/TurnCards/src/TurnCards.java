import javax.swing.*;
import java.awt.*;
import java.util.*;
public class TurnCards {
	public TurnCards() {
		JFrame frame = new JFrame();
		Random randomizer = new Random();
		JButton[] cards = new JButton[4];
		frame.setLayout(new GridLayout(1,4));
		ImageIcon defaultbg = new ImageIcon("src/Images/b1fv.png");
		for(int i=0; i<4; i++) {
			cards[i] = new JButton(defaultbg);
			cards[i].setSize(71,96);
			cards[i].setBorder(BorderFactory.createLineBorder(Color.black));
			cards[i].setPressedIcon(new ImageIcon("src/Images/"+(randomizer.nextInt(54)+1)+".png"));
			frame.add(cards[i]);
		}
		frame.pack();
		frame.setSize(284,130);
		frame.setTitle("Cards");
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TurnCards();

	}

}