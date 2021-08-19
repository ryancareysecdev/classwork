package compsim;
public class Register {
	
	private int d;
	private String binary = " ";
	private boolean[] data;
	private int bits;
	
	public Register(int size){
    	bits = size;
    	setInt(0);
	}
	
	public void setData(boolean[] dArray){
		
		this.data = dArray;
	}
	
	public boolean[] getData(){
		
		return data;
	}
	
    public int getInt(){

    	return d;
    }
    
    public int getSize(){
    	return bits;
    }
    
    public void setInt(int value){
    	d = value;
    	data = createArray(convertBinary(d));
    }
    
    private String convertBinary(int d){
    	
    	
        for ( int decimal = d ; decimal > 0 ; decimal/=2 )

        {

         binary = decimal%2 + binary  ;

        }
        
    	return binary;
    }
    
    public boolean[] createArray(String binary){
    	
    	boolean[] aBinary = new boolean[bits];
    	
    	for ( int index = 0 ; index < bits ; index++){
    		
    		if (binary.charAt(index) == 1){
    			aBinary[index] = true;
    		} else{
    			aBinary[index] = false;
    		}
    		
    	}
    	return aBinary;
    }
         
}