import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
class TwoDimRaggedArrayUtilityStudentTest {
	private double[][] dataSet1 = {{1.0 ,2.0 ,3.0}, {4.0, 5.0}, {6.0, 7.0, 8.0, 9.0}};
	private File inputFile, outputFile;

	@BeforeEach
	void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
		dataSet1 = null;
		inputFile = outputFile = null;
	}

	@Test
	void testReadFile() {
		double[][] arr = null;
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0");
			inFile.close();
			arr = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(1.0, arr[0][0], .001);
			assertEquals(2.0, arr[0][1], .001);
			assertEquals(3.0, arr[0][2], .001);
			assertEquals(4.0, arr[1][0], .001);
			assertEquals(5.0, arr[1][1], .001);
			assertEquals(6.0, arr[2][0], .001);
			assertEquals(7.0, arr[2][1], .001);
			assertEquals(8.0, arr[2][2], .001);
			assertEquals(9.0, arr[2][3], .001);
		}catch(FileNotFoundException e) {
			fail("This should not cause an FileNotFoundException");
		}
	}

	@Test
	void testWriteToFile() throws FileNotFoundException {
		double[][] arr = null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
		}catch(Exception e) {
			fail("This shouldn't cause an Exception");
		}
		arr = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(1.0, arr[0][0], .001);
		assertEquals(2.0, arr[0][1], .001);
		assertEquals(3.0, arr[0][2], .001);
		assertEquals(4.0, arr[1][0], .001);
		assertEquals(5.0, arr[1][1], .001);
		assertEquals(6.0, arr[2][0], .001);
		assertEquals(7.0, arr[2][1], .001);
		assertEquals(8.0, arr[2][2], .001);
		assertEquals(9.0, arr[2][3], .001);

	}

	@Test
	 void testGetTotal() {
		assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
	}

	@Test
	void testGetAverage() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
	}

	@Test
	void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);

	}

	@Test
	void testGetColumnTotal() {
		assertEquals(15, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), .001);
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0), .001);
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0), .001);
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), .001);
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0), .001);
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), .001);
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0), .001);
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
	}

}
