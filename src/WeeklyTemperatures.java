import java.util.ArrayList;
import java.util.Scanner;

// A class to store the week's average temperature for each day and report it to the user.
public class WeeklyTemperatures {

	public static void main(String[] args) {
		// Initialize all properties.
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> weekdays = new ArrayList<String>();
		ArrayList<Integer> averageTemperatures = new ArrayList<Integer>();
		String userInput = "";
		
		// Add all the days of the week.
		weekdays.add("Monday");
		weekdays.add("Tuesday");
		weekdays.add("Wednesday");
		weekdays.add("Thursday");
		weekdays.add("Friday");
		weekdays.add("Saturday");
		weekdays.add("Sunday");
		
		// Add each day's average temperature.
		averageTemperatures.add(54);
		averageTemperatures.add(51);
		averageTemperatures.add(49);
		averageTemperatures.add(52);
		averageTemperatures.add(61);
		averageTemperatures.add(65);
		averageTemperatures.add(68);
		
		// While the user does not choose to quit, get their input.
		while (!userInput.equals("q")) {
			// Output instructions and get the user's input.
			outputUserDirections();
			userInput = scnr.next();
			
			// Remove any extra spaces.
			userInput = userInput.trim();
			
			if (userInput.equals("week")) {
				// Output the weekly average to the user and then continue until they quit.
				System.out.println(getWeeklyAverageOutput(weekdays, averageTemperatures));
			} 
			else if (userInput.equals("q")) {
				// Inform the user they are exiting.
				System.out.println("\nExiting");
			} 
			else {
				// See if the user's input matches a day of the week.
				int matchingIndex = weekdays.indexOf(userInput);
				
				if (matchingIndex < 0) {
					// Inform the user the input is invalid and there was no match.
					System.out.println("\nInvalid input. Please try again.\n");
				}
				else {
					// Get matching weekday and temperature.
					String weekday = weekdays.get(matchingIndex);
					int temp = averageTemperatures.get(matchingIndex);
							
					// Output the matching day and its average temperature.
					System.out.println(String.format("\nDay: %s - Average Temperature: %d Degrees\n", weekday, temp));
				}
			}
		}
		
		// Close the scanner.
		scnr.close();
	}
	
	// A method to output the directions to the user on multiple lines.
	public static void outputUserDirections() {
		System.out.println("Please enter a day of the week with a capital first letter to see the average temperature for that day. An example is \"Monday\"");
		System.out.println("Enter the word \"week\" to see the temperatures for the whole week and the weekly average.");
		System.out.println("Enter the letter \"q\" to quit.");
	}
	
	// A method that creates an output of all weekdays, their temperatures, and the weekly average temperature.
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
			output = output + String.format("Day: %s - Average Temperature: %d Degrees\n", weekday, temp);
		}
		
		// Calculate the weekly average.
		int weeklyAverage = tempTotal / temps.size();
		
		
		// Add the weekly average to the output.
		output = output + String.format("\nWeekly Average Temperature: %d Degrees\n", weeklyAverage);
		
		// Return the output.
		return output;
	}
}
