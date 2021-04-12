package task3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * This class is responsible for populating the lists that hold male,female and common names
 * @author Shakhzoda Ismatullaeva
 *
 */
public class task3 {
	private static Scanner filename;
	private static String m_year;
	private static List<String> boysList = new ArrayList<String>();
	private static List<String> girlsList = new ArrayList<String>();
	private static List<String> bothList = new ArrayList<String>();

	/**
	 * Getter function that returns year
	 * 
	 * @return m_year value representing year
	 */
	public static String getYear() {
		return m_year;
	}

	/**
	 * Setter function that sets the year
	 * 
	 * @param fyear value representing year
	 */
	public static void setYear(String fyear) {
		m_year = fyear;
	}

	/**
	 * This function gets the user input and saves it into data members using
	 * setters
	 */
	public static void getUserInput() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the year: ");
		setYear(userInput.nextLine());

	}

	/**
	 * This function opens file that matches the year inputed Creates object of
	 * Scanner passing file name + year that we access with a getter If file doesn't
	 * exist it print out error message and exits the program
	 */
	public static void open() {
		try {
			filename = new Scanner(new File("./Babynames files/babynamesranking" + getYear() + ".txt"));
		} catch (Exception e) {
			System.out.println("No file for " + getYear() + " was found");
			System.exit(1);
		}

	}

	/**
	 * This function saves male and female names into corresponding lists
	 * Creates string variables for corresponding data from file. it saves it into
	 * these variables with the help of next(). Then it adds names into lists.
	 */
	public static void getRanking() {

		while (filename.hasNext()) {
			String rank = filename.next();
			String boys = filename.next().toLowerCase();
			String bNumMale = filename.next();
			String girls = filename.next().toLowerCase();
			String bNumFemale = filename.next();

			boysList.add(boys);
			girlsList.add(girls);

		}

		for (String g : girlsList) {
			if (boysList.contains(g)) {

				bothList.add(g);
			}

		}

	}
/**
 * this function removes duplicates from female and male lists
 * it removes the names that are both in male and female lists
 */
	public static void removeDuplicates() {
		Collections.sort(girlsList);
		Collections.sort(boysList);

		for (String b : bothList) {
			if (boysList.contains(b)&&girlsList.contains(b)) {
				int indx = boysList.indexOf(b);
				boysList.remove(indx);
				int indx1 = girlsList.indexOf(b);
				girlsList.remove(indx1);
			} 
		}

	}
/**
 * This function is responsible for displaying the lists. it displays 5 names every time.
 */
	public static void displayList() {
		Scanner userInput = new Scanner(System.in);
		boolean valid = true;
		do {
			System.out.println("Enter: ");
			System.out.println("1) To see part A enter 1");
			System.out.println("2) To see part B enter 2");
			System.out.println("3) To terminate enter -0");
			int choice = userInput.nextInt();
			if (choice == 1) {
				boolean con = true;
				int innerChoice;
				int len = 5;
				int beg=0;
				
				do {
					
					for (int i = beg; i < len; i++) {
						System.out.println(bothList.get(i));
					}
					System.out.println();
					System.out.println("Do you want to see 5 more entries? (1 to continue / 0 to go back)");
					innerChoice = userInput.nextInt();
					if (innerChoice == 1) {
						len = len + 5;
						beg=beg+5;
					} else
						con = false;

				} while (con);

			} else if (choice == 2) {
				boolean con = true;
				int innerChoice;
				int len = 5;
				int beg=0;
				do {
					
					System.out.println();
					System.out.printf("%-20s %-20s", "Girls List", "Boys List");
					System.out.println();
					System.out.println();
					for (int i = beg; i < len; i++) {

						System.out.printf("%-20s %-20s", girlsList.get(i), boysList.get(i));
						System.out.println();
					}
					System.out.println();
					System.out.println("Do you want to see 5 more entries? (1 to continue / 0 to go back)");
					innerChoice = userInput.nextInt();
					if (innerChoice == 1) {
						len = len + 5;
						beg=beg+5;
					} else
						con = false;

				} while (con);

			} else if (choice == -0) {
				System.out.println("Exiting the program");
				valid = false;
			}

		} while (valid);

	}
	/**
	 * This function closes the file after it is done being used
	 */
	public static void close() {
		filename.close();
	}

}
