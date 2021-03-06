package compsim;
public class EightBitAdder {
	
	boolean[] inputA;
	boolean[] inputB;
	
	boolean[] output;
	LogicGate ebaGate = new LogicGate(0);
	
	public EightBitAdder(boolean[] inputA, boolean[] inputB) {
		this.inputA = inputA;
		this.inputB = inputB;
		
		add();
	}
	
	private void add() {
		// Leftmost digit is 0
		int bit = 7;
		
		// Least-significant digit calculation
		FullAdder fa = new FullAdder(false, inputA[bit], inputB[bit]);
		output[bit] = fa.getSum();
		bit--;
		
		// Rest of calc.
		while(bit > 0) {
			// Could've used setters instead of using new instances?
			fa = new FullAdder(fa.getCarryOut(), inputA[bit], inputB[bit]);
			output[bit] = fa.getSum();
			bit--;
		}
	}
	
	public boolean[] getSum() {
		return output;
	}

	class FullAdder {
		
		boolean carryIn;
		boolean a;
		boolean b;
		
		boolean sum;
		boolean carryOut;
		
		FullAdder(boolean carryIn, boolean a, boolean b) {
			this.carryIn = carryIn;
			this.a = a;
			this.b = b;
			sum = false;
			carryOut = false;
			
			add();
		}
		
		void add() {
			// Not a feasible design in actuality
			
			// CarryOut
			and.setInput1(carryIn);
			xor.setInput1(a);
			xor.setInput2(b);
			and.setInput2(xor.getOutput());
			or.setInput1(and.getOutput());
			
			and.setInput1(a);
			and.setInput2(b);
			or.setInput2(and.getOutput());			
			
			carryOut = or.getOutput();
			
			// Sum
			xor.setInput2(xor.getOutput());
			xor.setInput1(carryIn);
			
			sum = xor.getOutput();
		}
		
		boolean getSum() {
			return sum;
		}
		
		boolean getCarryOut() {
			return carryOut;
		}
		
	}

}
