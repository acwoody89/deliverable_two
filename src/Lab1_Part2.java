import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

/**
* <h1>Find the difference between two dates</h1>
* The DateDifference program takes two inputs from the user,
* and outputs the difference between the two dates.
*
** @author  Alex Wood
* @version 1.0
* @since   6/5/2018
*/
public class Lab1_Part2 {

	public static void main(String[] args) {
		// stores the dates of the user as strings
		String input1 = "";
		String input2 = "";
		
		Scanner scan = new Scanner(System.in);
		
		//Ask for two Dates, stored as String
		System.out.println("Please enter two dates. EX) 11/11/2011 | 1/02/1918");
		System.out.println("----------------------------------------------------------");
		
		System.out.println("Please input the first date.");
		input1 = scan.nextLine();
		
		System.out.println("Please input the second date.");
		input2 = scan.nextLine();
		
		DateDifference(input1, input2);
	}
	
	
	 /**
	    * This method is used to find the difference of the two inputs.
	    * @param a This is the first date inputed by the user.
	    * @param b This is the second date inputed by the user.
	    * @return  No return value, displays results directly to screen
	    */
	
	public static void DateDifference(String a, String b) {
		// storing the user inputs in two separate strings
		String firstDate = a;
		String secondDate = b;
		
		// stores dates as (year, month, day)
		LocalDate date1;
		LocalDate date2;
		
		// Finds the difference between two dates.
		Period difference = null;
		
		// variables that will store the month, day, year for the first input
		int firstDay = 0;
		int firstMonth = 0;
		int firstYear = 0;
		
		// variables that will store the month, day, year for the second input
		int secondDay = 0;
		int secondMonth = 0;
		int secondYear = 0;
		
		// variables to store the digits of the inputs
		String[] firstInput = null;
		String[] secondInput = null;
		
		
		// breaks apart the string firstDate, stores the digits in firstInput[]
		if(firstDate.contains("/") == true) {
			firstInput = firstDate.split("/");
		}
		
		// breaks apart the string secondDate, stores the inputs in secondInput[]
		if(secondDate.contains("/") == true) {
			secondInput = secondDate.split("/");
		}
		
		// takes the strings stores them as integers
		firstMonth = Integer.parseInt(firstInput[0]);
		firstDay = Integer.parseInt(firstInput[1]);
		firstYear = Integer.parseInt(firstInput[2]);
		
		// takes the strings stores them as integers
		secondMonth = Integer.parseInt(secondInput[0]);	
		secondDay = Integer.parseInt(secondInput[1]);	
		secondYear = Integer.parseInt(secondInput[2]);
		
		// takes the broken up parts of the inputs, and stores them as dates
		date1 = LocalDate.of(firstYear, firstMonth, firstDay);
		date2 = LocalDate.of(secondYear, secondMonth, secondDay);
		
		// finds which date came first, so no negative number is output to the screen
		if(date1.isBefore(date2)) {
			difference = Period.between(date1, date2);
		}
		else if (date1.isAfter(date2)){
			difference = Period.between(date2, date1);
		}
			
			System.out.println("Difference is " + difference.getYears() + " years, " + difference.getMonths() + " months," + 
					 " and " + difference.getDays() + " days");
	}
}
