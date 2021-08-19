package compsim;
public class LogicGate
{
  // create LogicGate type constants
  public static final int NOT = 0;
  public static final int AND = 1;
  public static final int OR = 2;
  public static final int XOR = 3;
  public static final int NAND = 4;
  public static final int NOR = 5;
  private static final String [] GATENAMES =
            {"NOT","AND","OR","XOR","AND","NOR"};
  // create instance variables
  private boolean in1;
  private boolean in2;
  private int gateId;
   
  public LogicGate(int gateId)
  {
          this.gateId = gateId;
  }
  
  public void setGateId(int setTo) {
	  this.gateId = setTo;
  }

  public String toString()
  {
    return GATENAMES[gateId];
  }

  public void setInput1(boolean in1)
  {
    this.in1 = in1;
  }
 
  public void setInput2(boolean in2)
  {
    this.in2 = in2;
  }
 
  public boolean getInput1()
  {
    return in1;
  }
 
  public boolean getInput2()
  {
    return in2;
  }
 
  public boolean getOutput()
  {
    switch (gateId)
    {
      case NOT : return !in1;
      case AND : return (in1 && in2);
      case OR : return (in1 || in2);
      case XOR : return ((in1 && !in2) || (!in1 && in2));
      case NAND : return !(in1 && in2);
      case NOR : return !(in1 || in2);
        default : return false; // should never happen
    }
  }
} 