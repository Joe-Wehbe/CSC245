/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 11/15/2021                                                                                                                                                                                                         
OTHER FILES: Node.java, Stack.java                                                                                                            
PROGRAM DESCRIPTION: This program evaluates a fully parenthesized expression and returns the result                                           
_________________________________________________________________________________________________________________________
                                                                                                                     */

package question1;

public class FullyParenthesized {
	
	// Creating 2 stacks
	Stack s1 = new Stack();
	Stack s2 = new Stack();

	public int fullyParenthesized(String s) {
		/* Method that evaluates a fully parenthesized expression. It takes int as
		   return type, and a String as parameter.
		 */
		
		if (s == "") { // In case the string is empty, the method returns 0.
			return 0;
		}
		
		for (int i = 0; i < s.length(); i++) { // iterating over the string.
			
			// If i is pointing at an index that contains an operator
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%') {
				s2.push(Character.toString(s.charAt(i))); // we push it to stack 2
			}			
			
			// If i is pointing at an index that contains a digit
			if (s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' 
				|| s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' 
				|| s.charAt(i) == '9' || s.charAt(i) == '0') {
				
				/* We have to check whether the character next to i is also a digit, 
				   if so, we check the one after etc. 
				   This is to be able to use any integer in the expression				 
				 */
				
				int j = i+1; // j points at the index after i
				
				// Loop to keep incrementing j if there is a sequence of digits
				while (s.charAt(j) == '1' || s.charAt(j) == '2' || s.charAt(j) == '3' || s.charAt(j) == '4' 
					|| s.charAt(j) == '5' || s.charAt(j) == '6' || s.charAt(j) == '7' || s.charAt(j) == '8' 
					|| s.charAt(j) == '9' || s.charAt(j) == '0') {			
					j++; // incrementing j					
				}							
				s1.push(s.substring(i,j)); // we finally take the substing that has the sequence of digits.
				i = j-1; // we increase i to skip these digits.				
			}	
			
			if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') { // If i points to an index that is a right parentheses 
				if (!s2.isEmpty()) { // if the stacks of operators is not empty, we perform the calculations
					
					int operand2 = Integer.parseInt(s1.pop()); // operand 2
					int operand1 = Integer.parseInt(s1.pop());	// operand 1							
					String operator = s2.pop(); // their operator
				
					switch(operator) {
				
					case "+": // Adding
						s1.push(Integer.toString(operand1 + operand2));
						break;
					
					case "-": // Subtracting
						s1.push(Integer.toString(operand1 - operand2));
						break;
					
					case "*": // Multiplying
						s1.push(Integer.toString(operand1 * operand2));
						break;
					
					case "/": // Dividing
						s1.push(Integer.toString(operand1 / operand2));
						break;
					
					case "%": // Modulo
						s1.push(Integer.toString(operand1 % operand2));
						break;
					
					default:
						break;
					}
				}
				else { // If there is no operators, we just return the number
					System.out.print("Result: ");
					return Integer.parseInt(s1.pop());
				}
			}
	
		}
		// We return the final result
		System.out.print("Result: ");
		return Integer.parseInt(s1.pop());

	}
	
	// Main program
	public static void main (String[] args) {
		
		FullyParenthesized fp = new FullyParenthesized();
				
		System.out.println(fp.fullyParenthesized("((2-22)+7)"));	
		System.out.println(fp.fullyParenthesized("((1+(2+2)+2))]"));		
		System.out.println(fp.fullyParenthesized("(1+2)"));
		System.out.println(fp.fullyParenthesized("((10-3)+(9-8))"));
	    System.out.println(fp.fullyParenthesized("(((9+8)-(9*7))-(7+2))"));
	    System.out.println(fp.fullyParenthesized("(12)"));
	}

}
