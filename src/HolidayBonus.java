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
public class HolidayBonus {
	private static final double HIGH = 5000.0;
	private static final double LOW = 1000.0;
	private static final double NORMAL = 2000.0;
	public HolidayBonus() {
		
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][]data){
		double[] bonuses = new double[data.length];
		
		
		for(int row = 0; row < data.length; row++) {
			double bouns = 0.0;
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] <=0) {
					bouns += 0.0;
				}
				else if(row == TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col)) {
					bouns += HIGH;
				}
				else if(row == TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col)) {
					bouns += LOW;
				}
				else {
					bouns += NORMAL;
				}
			}bonuses[row] = bouns;
		}return bonuses;
		
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double calculateTotalHolidayBonus(double[][]data) {
		double total = 0.0;
		
		double[] bonusArr = calculateHolidayBonus(data);
		
		for(double bonus : bonusArr) {
			total += bonus;
		}return total;
	}

}
