import java.util.Scanner;
import java.awt.*;

public class Register {
	
	int d;
	String binary = " ";
	
	boolean[] data = creatArray(convertBindary(d));
	
	public Register(){
    	
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
    
    public void setInt(int d){
    	this.d = d;
    }
    
    public String convertBinary(int d){
    	
    	
        for ( int decimal = d ; decimal > 0 ; decimal/=2 )

        {

         binary = decimal%2 + binary  ;

        }
        
    	return binary;
    }
    
    public boolean[] createArray(String binary){
    	
    	boolean[] aBinary = new boolean[8];
    	
    	for ( int index = 0 ; index < 8 ; index++){
    		
    		if (binary.charAt(index) == 1){
    			aBinary[index] = true;
    		}
    		else{
    			aBinary[index] = false;
    			
    		}
    		
    	}
    	
    	return aBinary;
    }
         
}
