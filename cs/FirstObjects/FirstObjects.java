//Ryan Carey
//FirstObjects

import java.util.*;
import java.io.*;
public class FirstObjects {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Student s1 = new Student("John", 16, 3.25, 90.0, 87.5, 91.0);
		System.out.println(s1);
		System.out.print("Name: ");
		String a = inp.nextLine();
		System.out.print("Age: ");
		int b = inp.nextInt();
		System.out.print("Gpa: ");
		double c = inp.nextDouble();
		System.out.print("First Test: ");
		double d = inp.nextDouble();
		System.out.print("Second Test: ");
		double e = inp.nextDouble();
		System.out.print("Third Test: ");
		double f = inp.nextDouble();
		Student s2 = new Student(a, b, c, d, e, f);
		System.out.println(s2);
	}
}