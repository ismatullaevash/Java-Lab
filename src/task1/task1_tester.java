package task1;

import java.util.Scanner;
/**
 * this program uses lambdas to calculate the maximum,sum and average of an array that  user inputs
 * it also count number of occurrences of certain value in the array
 * @author Shakhzoda ismatullaeva
 *
 */

public class task1_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter size of an array: ");
		int size=userInput.nextInt();
		double[] array=new double[size];
		for(int i=0;i<size;i++) {
			System.out.println("Enter element #"+i+" :");
			array[i]=userInput.nextDouble();
			
		}
		

		System.out.println("Minimum of list: " + task1.getMin.apply(array));
		System.out.println("Maximum of list: " + task1.getMax.apply(array));
		System.out.println("Sum of list: " + task1.getSum.apply(array));
		System.out.println("Average of list: " + task1.getAvg.apply(array)+"\n");
		
		double num=0;
		do {
			System.out.println("Enter the number to find in array,-0 to exit"+"\n");
			num=userInput.nextDouble();
			if(num!=-0) {
			System.out.println("Count of "+ num+ " in the array: " + task1.counter(num).apply(array)+"\n");
			}
			else {
				System.out.println("Exiting the program!");
			}
			
		} while (num!=-0);
		

	}

}
