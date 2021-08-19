//Ryan Carey - Quadratic

import java.util.*;

public class Quadratic {
    public static void main(String[] args) {
        double a, b, c;
        double ans1 = 0.0;
        double ans2 = 0.0;
        System.out.print("Enter a value for A: ");
        a = assignme();
        System.out.print("Enter a value for B: ");
        b = assignme();
        System.out.print("Enter a value for C: ");
        c = assignme();
        if (breakcheck(a, b, c) == true) {
            System.out.println("Nonreal answers sorry.");
            input.next();
            System.exit(1);
        } else {
            ans1 = (((-1 * b) + Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
            ans2 = (((-1 * b) - Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
        }
        System.out.println("Valid input! For a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("The answers are: " + ans1 + ", " + ans2);
    }
    public static Scanner input = new Scanner(System.in);

    public static double assignme() {
        double d = input.nextDouble();
        return d;

    }

    public static boolean breakcheck(double a, double b, double c) {
        if (((b * b) - (4 * a * c)) < 0.0 | a == 0.0) {
            return true;
        }
        else {
        return false;
        }
    }
}