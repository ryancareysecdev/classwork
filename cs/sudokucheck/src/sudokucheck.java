import java.util.Scanner;
public class sudokucheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] solution = readSolution();
		

	}
	public static int[][] readSolution(){
		Scanner keyb = new Scanner(System.in);
		int[][] solution = new int[9][9];
		System.out.println("Enter a sudoku solution: ");
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++)
				solution[i][j] = keyb.nextInt();
		return solution;
	}
	public static boolean validityCheck(int[][] solution){
		int[] track = new int[9];
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				
	}

}
