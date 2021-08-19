//Ryan Carey
//RanDoubles

import java.util.*;
import java.io.*;
public class RanDoubles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		PrintWriter write = new PrintWriter(new File("Random.txt"));
		Random ran = new Random();
		int numbers = 0, c = 0;
		double rdouble = 0, power = 0;
		System.out.print("how many random doubles?: ");
		numbers = input.nextInt();
		write.println(numbers);
		double[] rda = new double[numbers];
		for(c = 0; c < numbers; c++) {
			rdouble = ran.nextDouble();
			power = Math.pow(10, (ran.nextInt(17)-5));
			if (power == 0) {
				c--;
			}
			rda[c] = rdouble * power;
			write.println();
			write.printf("%30.16f", rda[c]);
		}
		write.println();
		Arrays.sort(rda);
		write.println("the lowest number is " + rda[0]);
		write.println("the greatest number is " + rda[numbers-1]);
		write.close();
		System.out.println("the file has been generated.");
	}
}