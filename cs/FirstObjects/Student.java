//Ryan Carey
//Student

import java.util.*;
import java.io.*;
public class Student {
	private int age;
	private double gpa;
	private String name;
	private double grade1;
	private double grade2;
	private double grade3;
	public Student(String a, int b, double c, double d, double e, double f) {
		name = a;
		age = b;
		gpa = c;
		grade1 = d;
		grade2 = e;
		grade3 = f;
	}
	public Student() {
		name = "";
		age = 0;
		gpa = 0.0;
		grade1 = 0.0;
		grade2 = 0.0;
		grade3 = 0.0;
	}
	public void setAll(String a, int b, double c, double d, double e, double f) {
		name = a;
		age = b;
		gpa = c;
		grade1 = d;
		grade2 = e;
		grade3 = f;
	}
	public void setName(String a) {
		name = a;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setGpa(double a) {
		gpa = a;
	}
	public void setGrade(double a, double b, double c) {
		grade1 = a;
		grade2 = b;
		grade3 = c;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getGpa() {
		return gpa;
	}
	public double getGrade1() {
		return grade1;
	}
	public double getGrade2() {
		return grade2;
	}
	public double getGrade3() {
		return grade3;
	}
	public double avg() {
		return (grade1+grade2+grade3)/3;
	}
	public String toString() {
		String ret = "Name: "+name+"  Age: "+age+"  gpa: "+gpa;
		ret = ret+"\ntest scores: "+grade1+" "+grade2+" "+grade3;
		return ret+"\nAverage: "+avg();
	}
}