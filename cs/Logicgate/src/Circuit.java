import java.util.*;
public class Circuit {
int counter = 1;
Logicgate[] gates = {};
public Scanner keyb = new Scanner(System.in);
	/**
	 * @param args
	 */
	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean sinput1=false;
		boolean sinput2=false;
		
		System.out.print("Enter initial inputs as true or false:");
		try {
			sinput1=keyb.nextBoolean();
			sinput2=keyb.nextBoolean();
		}
		catch (InputMismatchException e) {
			System.out.println("Not a valid input. Press any key to exit.");
			keyb.next();
			System.exit(1);
		}
		System.out.print("Enter the first gate: ");
		gates[0] = new Logicgate(keyb.next(), sinput1, sinput2);
		System.out.println("Enter the type of gate to add. Enter 0 to move onto wires.");
		
	}

	public void AddGate(String s) {
		gates[counter] = new Logicgate(s);
		
	}
	public void AddWire(Logicgate x, Logicgate y) {
		y.setInput1(x.getOutput());
	}

}
