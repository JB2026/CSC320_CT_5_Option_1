// Imports
import java.util.ArrayList;
import java.util.Scanner;

/** 
* A class to store the week's average temperature for each day and report it to the user.
* 
* @author  Joshua Borck
*/
public class WeeklyTemperatures {
	// Static Strings
	private static String MONDAY = "Monday";
	private static String TUESDAY = "Tuesday";
	private static String WEDNESDAY = "Wednesday";
	private static String THURSDAY = "Thursday";
	private static String FRIDAY = "Friday";
	private static String SATURDAY = "Saturday";
	private static String SUNDAY = "Sunday";
	private static String QUIT_VALUE = "q";
	private static String WEEK_VALUE = "week";
	private static String EXITING_OUTPUT = "\nExiting";
	private static String INVALID_INPUT_OUTPUT = "\nInvalid input. Please try again.\n";
	private static String DIRECTIONS_FIRST = "Please enter a day of the week with a capital first letter to see the average temperature for that day. An example is \"Monday\"";
	private static String DIRECTIONS_SECOND = "Enter the word \"week\" to see the temperatures for the whole week and the weekly average.";
	private static String DIRECTIONS_THIRD = "Enter the letter \"q\" to quit.";
	private static String DAY_OUTPUT = "Day: %s - Average Temperature: %d Degrees\n";
	private static String WEEK_OUTPUT = "\nWeekly Average Temperature: %d Degrees\n";

	public static void main(String[] args) {
		// Initialize all properties.
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> weekdays = new ArrayList<String>();
		ArrayList<Integer> averageTemperatures = new ArrayList<Integer>();
		String userInput = "";
		
		// Add all the days of the week.
		weekdays.add(MONDAY);
		weekdays.add(TUESDAY);
		weekdays.add(WEDNESDAY);
		weekdays.add(THURSDAY);
		weekdays.add(FRIDAY);
		weekdays.add(SATURDAY);
		weekdays.add(SUNDAY);
		
		// Add each day's average temperature.
		averageTemperatures.add(54);
		averageTemperatures.add(51);
		averageTemperatures.add(49);
		averageTemperatures.add(52);
		averageTemperatures.add(61);
		averageTemperatures.add(65);
		averageTemperatures.add(68);
		
		// While the user does not choose to quit, get their input.
		while (!userInput.equals(QUIT_VALUE)) {
			// Output instructions and get the user's input.
			outputUserDirections();
			userInput = scnr.next();
			
			// Remove any extra spaces.
			userInput = userInput.trim();
			
			if (userInput.equals(WEEK_VALUE)) {
				// Output the weekly average to the user and then continue until they quit.
				System.out.println(getWeeklyAverageOutput(weekdays, averageTemperatures));
			} 
			else if (userInput.equals(QUIT_VALUE)) {
				// Inform the user they are exiting.
				System.out.println(EXITING_OUTPUT);
			} 
			else {
				// See if the user's input matches a day of the week.
				int matchingIndex = weekdays.indexOf(userInput);
				
				if (matchingIndex < 0) {
					// Inform the user the input is invalid and there was no match.
					System.out.println(INVALID_INPUT_OUTPUT);
				}
				else {
					// Get matching weekday and temperature.
					String weekday = weekdays.get(matchingIndex);
					int temp = averageTemperatures.get(matchingIndex);
							
					// Output the matching day and its average temperature.
					System.out.println(String.format(DAY_OUTPUT, weekday, temp));
				}
			}
		}
		
		// Close the scanner.
		scnr.close();
	}
	
	 /** 
	    * A method to output the directions to the user on multiple lines.
	    */
	public static void outputUserDirections() {
		System.out.println(DIRECTIONS_FIRST);
		System.out.println(DIRECTIONS_SECOND);
		System.out.println(DIRECTIONS_THIRD);
	}
	
	 /** 
	    * A method that creates an output of all weekdays, their temperatures, and the weekly average temperature.
	    * @param weekdays An ArrayList that contains all of the weekdays.
	    * @param temps An ArrayList that contains each of the daily temps directly matching the index of the day of the week from the previous parameter.
	    * @return String This string is the output of temperatures that the user requested.
	    */
	public static String getWeeklyAverageOutput(ArrayList<String> weekdays, ArrayList<Integer> temps) {
		// Initialize method properties.
		String output = "\n";
		int tempTotal = 0;
		
		for (int i = 0; i < weekdays.size(); i++) {
			// Initialize loop properties.
			String weekday = weekdays.get(i);
			int temp = temps.get(i);
			
			// Add the current temperature to the running total for average calculation.
			tempTotal = tempTotal + temp;
			
			// Create the output of each day and day's temperature.
			output = output + String.format(DAY_OUTPUT, weekday, temp);
		}
		
		// Calculate the weekly average.
		int weeklyAverage = tempTotal / temps.size();
		
		
		// Add the weekly average to the output.
		output = output + String.format(WEEK_OUTPUT, weeklyAverage);
		
		// Return the output.
		return output;
	}
}
