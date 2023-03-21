
/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 10/17/2021                                                                                                                                                                                                         
OTHER FILES: No other files                                                                                                            
PROGRAM DESCRIPTION: This program displays a menu with many options where the user can choose to reverse a number, 
                     count the digits of a number, or concatenate a string a specified number of times.                                           
_________________________________________________________________________________________________________________________
                                                                                                                     */

package asst3;

import java.util.Scanner;

public class Recursion {
	
	public static void reverseNumber(int n) {	
	/* Static method that reverses a number, it takes
	   an integer as parameter and has void as return
	   type.  */
		
		// if n is a single digit number
		if (n >= 0 && n <= 9) {
			// print the number
			System.out.println(n);
		} 
		else {  // otherwise			
		   System.out.print(n % 10); // print the last digit of the number
		   reverseNumber(n / 10); // divide the number by 10
		}
	}	

	
	
		
	public static int countDigits(int n) {
		/* Static method that counts the number
		   of digits, it takes an integer as parameter and
		   has int as return type */
		
		// if n reaches the first decimal number, return 0
		if (n == 0.) {
			return 0;
		} // else, increment the count and keep dividing by 10			
		return 1 + countDigits(n/10);			 
	}

	
	
	
	public static String repeat(String s, int n) {
		/* Static method that repeats a string 
		   a specified number of times. It takes 2
		   parameters, a String s and an integer n. It
		   has String as return type */
		
		// Once n reaches 0, return empty string
		if (n == 0) {
			return "";
		}	
		// else, repeat the string and keep decrementing n
		return s + repeat(s, n - 1);
	}

	
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan_main = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner scan_str = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner scan_num = new Scanner(System.in);
		
		byte flag = 1; // variable used to keep displaying the menu
		
		while(flag == 1) { // Loop to keep displaying the menu
			
			// Menu
			System.out.println();
			System.out.println("1. Reverse number");
			System.out.println("2. Count digits");
			System.out.println("3. Repeat");
			System.out.println("4. Exit");
			System.out.println("-----------------");
			System.out.println("Enter your choice: ");
			
			int option = scan_main.nextInt();
			
			switch(option) {
			
			case 1: // Reverse a number
				System.out.println();
				System.out.println("Enter a number to reverse: ");
				int num = scan_num.nextInt();				
				System.out.print("Reversed number is: ");
				reverseNumber(num);
				
				break;
				
			case 2: // Count the digits of a number 
				System.out.println();
				System.out.println("Enter a number to count its digits: ");
				num = scan_num.nextInt();
				System.out.println("This number contains " + countDigits(num) + " digits.");
				break;
				
			case 3: // repeat a string n times
				System.out.println();
				System.out.println("Enter a word to repeat: ");
				String str = scan_str.next();
				
				System.out.println("Enter how many times to repeat: ");
				int times = scan_num.nextInt();
				
				System.out.println("\"" + str + "\""  + " repeated " + times + " times: " + repeat(str, times));
				break;
				
			case 4: // Exit the program
				System.out.println();
				System.out.println("Program terminated.");
				System.exit(0);
				
			default: // If none of the above option entered, invalid.
				System.out.println("Invalid option.");
				 break;
			}
			
		}
		
	}

}
