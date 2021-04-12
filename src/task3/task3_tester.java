package task3;


/**
 * This program prompts the user to enter one of the filenames from baby ranking and
 displays the names that are used for both genders in the file.
 Use Lists to store the names and find common names in two lists (for boys and girls). 
 Sort all names for boys and girls in their lists.
 Remove the duplicates.
 Display the sorted names individually
 * @author Shakhzoda Ismatullaeva
 *
 */
public class task3_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		task3 obj = new task3();
		obj.getUserInput();
		obj.open();
		obj.getRanking();
		obj.removeDuplicates();
		obj.displayList();
		obj.close();

	}

}
