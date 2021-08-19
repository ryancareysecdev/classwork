package compsim;
public class BitTools {
	
	public static Register Complementer(Register input) {
		//Invert each boolean value with NOT gate in place
		boolean[] binaryData = input.getData();
		for (int i=0;i<binaryData.length;i++){
			LogicGate NOT = new LogicGate(0);
			NOT.setInput1(binaryData[i]);
			binaryData[i] = NOT.getOutput();
		}
		//Add one
		for (int j=binaryData.length-1;j>=0;j--) {
			//Invert value at j
			LogicGate NOT = new LogicGate(0);
			NOT.setInput1(binaryData[j]);
			binaryData[j] = NOT.getOutput();
			//If value just flipped had no carry, stop loop
			if (binaryData[j] == true)
				break;
		}
		//Output
		Register output = new Register(input.getSize());
		output.setData(binaryData);
		return output;
	}
	
	public static Register[] shiftRight(Register... input) {
		//Carry between registers
		boolean carry = false;
		//For each register, starting at the leftmost
		for (int i=input.length-1;i>=0;i--) {
			//Get register data
			boolean[] data = input[i].getData();
			//Take rightmost bit, set as temp carry value
			boolean carryOut = data[0];
			//Shift bits to the right except if register is 1 bit 
			if (data.length>1) {
				for (int j=1;j<data.length;j++)
					data[j-1] = data[j];
				//Leftmost bit becomes carry in
				data[data.length-1] = carry;
			} else {
				data[0] = carry;
			}
			//Set carry for next register
			carry = carryOut;
			//Re-set data for register
			input[i].setData(data);
		}
		return input;
	}
}
