public class Logicgate {
	private String type;
	private boolean input1;
	private boolean input2;
	private int wires = 0;
	/**
	 * @param args
	 */
	public Logicgate() {
		type = "";
		input1 = false;
		input2 = false;
	}
	public Logicgate(String s) {
		type = s;
	}
	public Logicgate(String s, boolean i1, boolean i2) {
		type = s;
		input1=i1;
		input2=i2;
	}
	@Override public String toString() {
		return type;
	}
	public boolean getOutput() {
		if(type.equals("NOT"))
			return !input1;
		else if(type.equals("AND"))
			return input1&&input2;
		else if(type.equals("OR"))
			return input1|| input2;
		else if(type.equals("XOR"))
			return ((input1 && !input2) || (!input1 && input2));
		else if(type.equals("NAND"))
			return !(input1 && input2);
		else if(type.equals("NOR"))
			return !(input1 || input2);
		else {
			System.out.println("Invalid gate");
			return false;
		}
	}
	public void setInput1(boolean in1) {
		input1=in1;
	}
	public void setInput2(boolean in2) {
		input2=in2;
	}
	public boolean getInput1() {
		return input1;
	}
	public boolean getInput2() {
		return input2;
	}
	public String getType() {
		return type;
	}
	public void wireAdded() {
		if(wires<3)
			wires++;
		else
			System.out.println("Too many wires added.");
			
	}


}
