import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/*
* Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Christopher Newman
*/
/**
 * 
 * @author chris
 * @version 4/22/2023
 *
 */
public class TwoDimRaggedArrayUtility {
	//1
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static double[][]readFile(File file)throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		int Row = 0;
		
		String[][] arr = new String[10][10];
		
		while(sc.hasNextLine()) {
			String[]row = sc.nextLine().split(" ");
			arr[Row] = new String[row.length];
			for(int i = 0; i < row.length; i++) {
				arr[Row][i] = row[i];
				
			}Row++;
		}
		double[][]data = new double[Row][];
		
		for(int i = 0; i < Row; i++) {
			data[i] = new double[arr[i].length];
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j] + " ");
				data[i][j] = Double.parseDouble(arr[i][j]);
			}System.out.println();
		}
		sc.close();
		return data;
	}
	/**
	 * 
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter op = new PrintWriter(outputFile);
		
		for(int row = 0; row < data.length; row++) {
			String nextLine = "";
			for(int col = 0; col < data[row].length; col++) {
				nextLine += data[row][col] + " ";
				
			}op.println(nextLine);
			
		}op.close();
		
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getAverage(double[][]data) {
		int ele = 0;
		double sum = 0.0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				sum += data[row][col];
				ele++;
			}
		}
		return sum/ele;
	}
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getRowTotal(double[][]data, int row) {
		double total = 0.0;
		for(int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}return total;
	}
	
	public static double getColumnTotal(double[][]data, int col) {
		double total = 0.0;
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				total += data[row][col];
			}
		}return total;
	}
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getHighestInRow(double[][]data, int row) {
		double highestRow = 0.0;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] > highestRow) {
				highestRow = data[row][col];
				
			}
		}return highestRow;
	}
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][]data, int row) {
		double highest = 0.0;
		int highestRow = 0;
		
		for(int col = 0; col <data[row].length; col++) {
			if(data[row][col] > highest) {
				highest = data[row][col];
				highestRow = col;
			}
		}return highestRow;
	}
	
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getLowestInRow(double[][]data, int row) {
		double lowestRow = Double.MAX_VALUE;
		for(int i = 0; i < data[row].length; i++) {
			if(data[row][i] < lowestRow) {
				lowestRow = data[row][i];
			}
		}return lowestRow;
	}
	
	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getLowestInRowIndex(double[][]data, int row) {
		double lowestRow = Double.MAX_VALUE;
		int lowestRowIdx = 0;
		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < lowestRow) {
				lowestRow = data[row][col];
				lowestRowIdx = col;
			}
		}return lowestRowIdx;
	}
	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getHighestInColumn(double[][]data, int col) {
		double highestCol = 0.0;
		
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] > highestCol) {
					highestCol = data[row][col];
				}
			}
		}return highestCol;
	}
	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getHighestInColumnIndex(double[][]data, int col) {
		double highestCol = 0.0;
		int highestColIn = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] > highestCol) {
					highestCol = data[row][col];
					highestColIn = row;
				}
			}
		}return highestColIn;
	}
	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getLowestInColumn(double[][]data, int col) {
		double lowestCol = Double.MAX_VALUE;
		
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < lowestCol) {
					lowestCol = data[row][col];
				}
			}
		}return lowestCol;
	}
	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][]data, int col) {
		double lowestCol = 0.0;
		int lowestColIn = 0;
		
		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < lowestCol) {
					lowestCol = data[row][col];
					lowestColIn = row;
				}
			}
		}return lowestColIn;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getHighestInArray(double[][]data) {
		double highest = 0.0;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] > highest) {
					highest = data[row][col];
				}
			}
		}return highest;
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getLowestInArray(double[][]data) {
		double lowest = Double.MAX_VALUE;
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}return lowest;
	}

}
