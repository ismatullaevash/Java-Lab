package task2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
/**
 * This class is responsible for bank simulation 
 * it following class members:
 * HashMap bankBalance that holds the id and balance of every single bank
 * HashMap loanerInfo that holds the id of the banks that loaned from us and the amount loaned
 * HashMap obj holds an id of each bank and a hashmap that holds a map of values with ids and amounts of banks that borrowed money from a specific bank
 * integer m_limit that holds the limit for balance
 * integer m_numOfBanks that holds the number of banks that we're simulating 
 * @author Shakhzoda Ismatullaeva
 *
 */
public class task2 {
	private static HashMap<Integer, Double> bankBalance = new HashMap<Integer, Double>();
	private static HashMap<Integer, HashMap<Integer, Double>> obj = new HashMap<Integer, HashMap<Integer, Double>>();
	private static HashMap<Integer, Double> loanerInfo = new HashMap<Integer, Double>();
	public static int m_limit = 0;
	public static int m_numOfBanks = 0;
/**
 * This function accepts user input to get information about banks and fill out the hashmaps
 */
	public static void initializeBanks() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Number of banks: ");
		m_numOfBanks = userInput.nextInt();
		System.out.println("Minimum asset limit: ");
		m_limit = userInput.nextInt();
		for (int i = 0; i < m_numOfBanks; i++) {
			loanerInfo.clear();
			System.out.println("for bank num " + i);
			System.out.println("Balance: ");
			double bal = userInput.nextDouble();
			bankBalance.put(i, bal);
			System.out.println("Number of banks loaned: ");
			int numofb = userInput.nextInt();
			for (int j = 0; j < numofb; j++) {
				System.out.println("Bank id who gets the loan: ");
				int id = userInput.nextInt();

				System.out.println("Loaned amount: ");
				double amount = userInput.nextDouble();

				loanerInfo.put(id, amount);

			}
			obj.put(i, new HashMap<Integer, Double>(loanerInfo));
		}
	}
/**
 * this function determines if the banks are safe
 */
	public static void isSafe() {
		for (int i = 0; i < m_numOfBanks; i++) {
			double amount = getAmount(i);
			if (amount < m_limit) {
				int unsafeIndx = i;
				for (int k = 0; k < m_numOfBanks; k++) {
					for (Entry<Integer, Double> j : obj.get(k).entrySet()) {
						if (j.getKey() == unsafeIndx) {
							j.setValue(0.0);
						}
					}
				}

			}
		}
		
		

		for (int i = 0; i < m_numOfBanks; i++) {
			double amount = getAmount(i);
			if (amount < m_limit) {
				System.out.println("Bank " + i + " is unsafe");

			}
		}
		

	}
/**
 * This function calculates the amount for each bank
 * @param i represent the index of each bank 
 * @return total amount of each bank
 */
	public static double getAmount(int i) {
			double amt = 0;
			amt = bankBalance.get(i);
			for (Entry<Integer, Double> j : obj.get(i).entrySet()) {
				amt += j.getValue();
			}
			return amt;
	}


}