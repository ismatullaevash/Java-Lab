package task2;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * This program is a simulation of Banks.
 * it finds all the unsafe banks. This program reads the input as follows.
1. It first reads two integers n and limit, a. n indicates the number of banks
b. limit is the minimum total assets for keeping a bank safe from the user.
2. It then reads n lines that describe the information for n banks with IDs from 0 to n-1.
3. The first number in the line is the bank’s balance, the second number indicates the number of banks
that borrowed money from the bank, and the rest are pairs of two numbers.
4. Each pair describes a borrower. The first number in the pair is the borrower’s ID and the second is the
amount borrowed. 
 * @author Shakhzoda Ismatullaeva
 *
 */

public class task2_tester {
	public static void main(String[] args) {
		task2.initializeBanks();
		task2.isSafe();
		
		

	}

}
