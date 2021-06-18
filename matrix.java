package inclassassignment1;
import java.util.*;
public class matrix {

	public static void main(String[] args) {
		program();	
	}
	
	public static int[][] generate(int[][] matrix,int dim){
		Random rand = new Random();
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j <dim; j++){
				matrix[i][j]=Math.abs(rand.nextInt(51));
			}
		}
		return matrix;
	}

	public static void display(int[][] matrix, int dim) {
		System.out.print("[");
		System.out.print("[");
		for(int i = 0; i < dim; i++){
			for (int j = 0; j < dim; j++) {
				if (j != dim-1) {
				System.out.print(matrix[i][j]+", ");
			} else {
				System.out.print(matrix[i][j]);
			}
		}
			if (i!=dim-1) {
			System.out.print("],");
			System.out.println();
			}
		}
		System.out.print("]");
		System.out.print("]");
	}
	
	public static int value(int[][] matrix1, int[][] matrix2, int row, int column) {
		int dim = matrix1.length;
		int value=0;
		
		for (int i = 0 ; i < dim; i++) {
			value = value + (matrix1[row][i]*matrix2[i][column]);
		}
		
		return value;
	}

	public static void program() {
		Scanner inputDevice = new Scanner(System.in);
		int dim=0;
		boolean condition = false;
		
		while(condition == false) {
		System.out.println("What is the matrix dimension");
		dim = inputDevice.nextInt();
		if(dim == 50) condition = true;
		else System.out.println("Sorry... try again");
		}
		
		long start, end, clock;
		start = System.nanoTime();
		int[][] matrix1 = new int[dim][dim];
		int[][] matrix2 = new int[dim][dim];
		
		generate(matrix1,dim);
		generate(matrix2,dim);
		
		System.out.println("Matrix 1:");
		display(matrix1, dim);
		System.out.println();
		System.out.println();
		System.out.println("Matrix 2:");
		display(matrix2, dim);
		//test
		System.out.println();
		
		int[][] matrix3 = new int[dim][dim];
		for (int row = 0; row<dim; row++) {
			for (int column = 0; column < dim; column++) {
				matrix3[row][column] = value(matrix1,matrix2,row,column);
			}
		}
		
		System.out.println();
		System.out.println("Matrix 3:");
		display(matrix3,dim);
		System.out.println();
		
		end = System.nanoTime();
		System.out.println("Execution time : " + ((end-start)/1000000) + "ms\n");
		
		while (condition == true) {
		System.out.println("Would you like to continue? ( YES / NO ) ");
		String userInput = inputDevice.next();
		if (userInput.equalsIgnoreCase("YES")) {
			program();
			condition= false;
		}
		else if (userInput.equalsIgnoreCase("NO")) {
			inputDevice.close();
			condition= false;
		}
		else {
			System.out.println("OOPS. Something went wrong. Try again");
		}
		
		System.out.println("Goodbye..");
		System.exit(0);
		}
	}
}
