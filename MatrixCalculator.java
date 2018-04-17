package matrix_calculator;

import java.util.Scanner;

public class MatrixCalculator {
	// Name: Furaha Damien
	// McGill ID: 260754407
	private static Scanner sc;

	public static void main(String[] args) {
		// Declaring the variables
		int userSelection;
		int[][] firstMatrix = null;
		int[][] secondMatrix = null;
		int size = -1;
		// do_while loop to show the main menu to the user
		do {
			// Printing the menu
			System.out.println("\nPlease type the index of one of the following options...");
			System.out.println("1 Fill two matrices by user-input.");
			System.out.println("2 Fill two matrices by random numbers.");
			System.out.println("3 Print matrices.");
			System.out.println("4 Check if the matrices are magic.");
			System.out.println("5 Transpose the matrices.");
			System.out.println("6 Sum two matrices.");
			System.out.println("7 Multiply two matrices.");
			System.out.println("8 Exit the program.");

			// Using Scanner to get the index Selected by the user
			sc = new Scanner(System.in);
			userSelection = sc.nextInt();

			// Switch block to model the possible execution paths.
			switch (userSelection) {
			case 1:
				System.out.println("Please type one integer representing the size of the matrices.");
				size = sc.nextInt();
				System.out.println("Filling the first Matrix");
				firstMatrix = FillUser(size);
				System.out.println("Filling the second Matrix");
				secondMatrix = FillUser(size);
				break;

			case 2:
				System.out.println("Please type one integer representing the size of the matrices.");
				size = sc.nextInt();
				System.out.println("Filling the first Matrix");
				firstMatrix = FillRandom(size);
				System.out.println("Filling the second Matrix");
				secondMatrix = FillRandom(size);
				break;

			case 3:
				if (size != -1) {
					System.out.println("Printing the first Matrix.");
					PrintMatrix(firstMatrix);
					System.out.println("Printing the second Matrix.");
					PrintMatrix(secondMatrix);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;

			case 4:
				boolean magic;
				if (size != -1) {
					magic = IsMagic(firstMatrix);
					System.out.println("Is your first matrix magic?: " + magic);
					magic = IsMagic(secondMatrix);
					System.out.println("Is your second matrix magic?: " + magic);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 5:
				if (size != -1) {
					System.out.println("Transposing the first Matrix.");
					firstMatrix = Transpose(firstMatrix);
					System.out.println("Transposing the second Matrix.");
					secondMatrix = Transpose(secondMatrix);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 6:
				if (size != -1) {
					System.out.println("Printing the addition of the two matrices.");
					PrintMatrix(Addition(firstMatrix, secondMatrix));
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 7:
				if (size != -1) {
					System.out.println("Printing the multiplication of the two matrices.");
					PrintMatrix(Multiply(firstMatrix, secondMatrix));
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 8:
				System.out.println("Thanks for using the Matrix Calculator Program.....");
				break;
			default:
				System.out.println("Please insert a number between 1 and 8");
				break;
			}

		} while (userSelection != 8);
		System.out.println();

	}

	public static int[][] FillUser(int size) {
		int[][] matrix = new int[size][size];
		// Please insert below your code to fill in the matrix using the user-input data 
		int counter = 0;
		while (true) {
			System.out.println("inter your digits");

			// variable i prints rows while variable j prints columns
			for (int i = 0; i < matrix.length; i++) {
				counter++;
				for (int j = 0; j < matrix[i].length; j++) {
					sc = new Scanner(System.in);
					matrix[i][j] = sc.nextInt();

				}
				//the counter ensures that we do not enter a matrix of size greater than the declared size
				 
				if (counter == matrix.length) {
					break;
				}
			}
			// Your code must end here.
			return matrix;
		}
	}

	public static int[][] FillRandom(int size) {
		int[][] matrix = new int[size][size];
		// Please insert below your code to fill in the matrix using random-generated data

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// filling with random integers from 0 to 9
				int x = (int) (Math.random() * 10);
				matrix[i][j] = x;
			}
		}
		// Your code must end here.
		return matrix;
	}

	public static void PrintMatrix(int[][] matrix) {
		// Please insert below your code to print the matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			// jump to next row
			System.out.println();
		}
		// Your code must end here.
	}

	public static boolean IsMagic(int[][] matrix) {
		boolean isMagic = true;
		// Please insert below your code to check if the matrix is magic
		
		/* This method calls three helper methods that i wrote from line 230.
		  The methods test if the matrix is magic based on three separate
		 conditions(rows,columns and diagonals)*/
		 
		if (!(row(matrix) == true && column(matrix) == true && diagonal(matrix) == true)) {
			isMagic = false;
		}

		// Your code must end here.
		return isMagic;
	}

	public static int[][] Transpose(int[][] matrix) {
		int size = matrix.length;
		int[][] matrixTransposed = new int[size][size];
		// Please insert below your code to transpose matrix
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				// making row number i to be column number i
				matrixTransposed[j][i] = matrix[i][j];
			}
		}
		// Your code must end here.
		return matrixTransposed;
	}

	public static int[][] Addition(int[][] firstMatrix, int[][] secondMatrix) {
		int size = firstMatrix.length;
		int[][] matrixAdded = new int[size][size];
		// Please insert below your code to add the two matrices
		for (int i = 0; i < firstMatrix.length; i++) {
			for (int j = 0; j < firstMatrix.length; j++) {
				matrixAdded[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
			}
		}
		// Your code must end here.
		return matrixAdded;
	}

	public static int[][] Multiply(int[][] firstMatrix, int[][] secondMatrix) {
		int size = firstMatrix.length;
		int[][] matrixMultiplied = new int[size][size];
		// Please insert below your code to multiply the two matrices
		int[][] sum = new int[size][size];
		
		/*sum is temporary variable to hold the element obtained by multiplying
		  across rows and down columns */
		
		for (int i = 0; i < firstMatrix.length; i++) {
			for (int j = 0; j < firstMatrix.length; j++) {
				for (int k = 0; k < firstMatrix.length; k++) {
					/* variable k helps to make sure that the number of columns
					 of matrix1 equal number of rows of matrix2*/
					sum[i][j] = sum[i][j] + firstMatrix[i][k] * secondMatrix[k][j];
				}
				matrixMultiplied[i][j] = sum[i][j];
			}
		}
		// Your code must end here.
		return matrixMultiplied;
	}

	// helper method for testing if the elements in the diagonals have equal sums
	 
	public static boolean diagonal(int[][] matrix) {
		int sum = 0;
		int tempSum = 0;
		int tempSumRow = 0;
		int tempSumColumn = 0;
		boolean bool = false;
		int k = 1;
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[j].length; i++) {
				if (k == 1) {
					tempSumRow += matrix[i][j];
					tempSumColumn += matrix[j][i];

				}
				// checks if the top-left to bottom right diagonal is magic
				if (j == i) {
					sum += matrix[i][j];
				}
				// checks if top-right to bottom-left diagonal is magic
				if ((i + j) == matrix.length - 1) {
					tempSum += matrix[i][j];
				}
			}
			k = 0;

		}
		System.out.println(tempSumRow);
		System.out.println(tempSumColumn);

		// checking if the sum of elements in rows, columns and diagonals have the same value
		if (sum == tempSum && sum == tempSumRow && sum == tempSumColumn) {
			bool = true;
		}
		return bool;
	}

	// helper methods for testing if the elements in the rows have equal sums
	public static boolean row(int[][] matrix) {
		int sum = 0;
		int tempSum = 0;
		boolean bool = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
			if (i > 0) {
				if (tempSum != sum) {
					bool = false;
				}
			}
			if (i == 0) {
				tempSum = sum;
			}
			// resetting sum so that we check the next row
			sum = 0;
		}
		return bool;
	}

	// helper methods for testing if the elements in the columns have equal sums
	public static boolean column(int[][] matrix) {
		int sum = 0;
		int tempSum = 0;
		boolean bool = true;
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[j].length; i++) {
				sum += matrix[j][i];
			}
			if (j > 0) {
				if (tempSum != sum) {
					bool = false;
				}
			}
			if (j == 0) {
				tempSum = sum;
			}
			// resetting sum so that we check the next column
			sum = 0;
		}
		return bool;
	}

}