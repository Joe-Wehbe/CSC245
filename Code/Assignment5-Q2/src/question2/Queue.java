/*________________________________________________________________________________________________________________________
NAME: Joe Wehbe                                                                                                                                                                                                                       
ID#: 202000908                                                                                                                                                                                                                         
COURSE: Objects and Data Abstraction (CSC245)                                                                                                                                                                                          
DATE LAST MODIFIED: 11/15/2021                                                                                                                                                                                                         
OTHER FILES: No other files                                                                                                           
PROGRAM DESCRIPTION: This program implements a queue using an array.                                        
_________________________________________________________________________________________________________________________
                                                                                                                     */

package question2;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
	
	// 0 is considered as a null value in the array (no element)
	private int[] queue;
	
	// front points to the first non-zero element in the array
	// end points to the last non-zero element in the array.
	// counter is used to track the number of elements in the array
	private int front, end, counter, indexPointer, tempIndexPointer;
	
	// constructor
    public Queue() {
    	queue = new int[10]; // size of the array set to 10 by default   	
    	// initializing variables
    	front = 0;
    	end = 0;
    	counter = 0;
    	indexPointer = 0; // points to the next index at which an element will be enqueued
    	tempIndexPointer = 0;   /* if end becomes 0, a temporary index pointer is created
                                  that points to the next index at which an element will be
                                  enqueued, it increments at each enqueue until it reaches front,
                                  the array will increase in size. */
    }

    
	public void increaseCapacity() {
		/* Method used to increase the size of the array once it is full.
		   It takes no parameters and the return type is void.		 
		 */
		
		int count = 0; // count used to point at the indices that we are copying to in the temp array.
		// creating a temporary array with double the size
		int[] temp = new int[queue.length * 2];	
		
		/* In case end didn't return to the beginning of the array 
		   which means that front is still less that end */	 
		if (front < end) {
			// copy the elements
		    for (int i = front ; i <= end; i++) {
		        temp[count] = queue[i];
		        count++;
		    } 
		    queue = temp;		    
		}
		
		/* In case end returned to 0 (end is less than front) */
		else if (end < front) {
			count = 0;
			// we copy the elements from front to the last element of the array
			for (int i = front; i < queue.length; i++) {
				temp[count] = queue[i];
				count++;
			}
			
			// Then we copy the elements from the beginning of the array to front.
			for (int i = 0; i < front; i++) {
				temp[count] = queue[i];
				count++;
			}
			queue = temp;
			front = 0; // front points at the first non-zero element in the array
			end = counter - 1; // end points at the last non-zero element
			tempIndexPointer = 0; // reset it to 0 to use it when the array rotates again
			

		}
	}
			
	
	public void enqueue(int i) {
		/* Method used enqueue an element to the.
		   It takes a parameter of type int and the 
		   return type is void.		 
		 */
		
		// In case the last element of the array is still 0 (no element)
		if (indexPointer < queue.length) {
			// if we are enqueueing the first element
			if (indexPointer == 0) {
			    queue[end] = i; // add the element, end is still 0 (points to index 0).
			    indexPointer++; // we point to the next index at which we will enqueue
			    counter++; // number of elements increases
			}
			// if we are not enqueueing the first element
			else {
				queue[indexPointer] = i; // add the element
				end++; // end becomes 1 or greater
				indexPointer++; // we point to the next index at which we will enqueue
				counter++; // number of elements increases
			}
	    }
		// In case the last element in the array is not 0
		else {		
			    // if we are enqueueing at index 0
				if (tempIndexPointer == 0) {
					end = 0; // end now points to 0
			        queue[end] = i;			        
			        tempIndexPointer++;
			        counter++;
				}
				// if we are enqueueing at index 1 or greater
				else {
					// if end is less than front
					if (end < front) {
					    queue[tempIndexPointer] = i;
					    end++;
					    tempIndexPointer++;
					    counter++;
					}
					// if end is equal to front - 1
					if (tempIndexPointer == front) {
						increaseCapacity();
					}
				}					
		}
		// in case the first and last elements in the array are not 0, we increase the size
		if (end == queue.length -1 && front == 0) {
			increaseCapacity();
		}

	}
	
	
	// Used in option 2	
	public void dequeue() {	
		/* Method used to dequeue an element of the array.
		   It takes no parameters and the return type is void.		 
		 */
			
		// If there is no elements in the array
		if (counter == 0) {
			System.out.println("No elements in the queue.");
			
		}
		// Dequeueing 
		if (queue[front] != 0) {	
			int data = queue[front]; // storing the element to be dequeued in a variable
		    queue[front] = 0; // setting the element to 0 (dequeued)
		    front++; // front points to the next element
		    counter--; // number of elements decreased
		    System.out.println("Number dequeued is: " + data);
		} 
		// if an element equal to 0 is being dequeued
		else {
			System.out.println("No element to be dequeued.");
		}

	}
	
	
	// Used in option 3
	public boolean isEmpty() {
		/* Method used to check whether the array is empty or not.
		   It takes no parameters and the return type is boolean.		 
		 */
		if (counter == 0) {
			return true;
		}
		return false;
	}
	
	
	// Used in option 4
	public void printArray() {
		/* Method used to print the array
		   It takes no parameters and the return type is void.		 
		 */
		System.out.println();
		System.out.println(Arrays.toString(queue));
	}
	
	
	// Used in option 5
	public void exitProgram() {
		/* Method used to exit the program
		   It takes no parameters and the return type is void.		 
		 */
		System.out.println();
		System.out.println("Program terminated.");
		System.exit(0);
	}
	
	
	// MAIN PROGRAM
	public static void main(String[] args) {
		
		Queue q = new Queue();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
        byte sentinel = 0;
        
        while (sentinel == 0) {
        	
        	// Menu
        	System.out.println();
        	System.out.println("1. Enqueue");
        	System.out.println("2. Dequeue");
        	System.out.println("3. Check if empty");
        	System.out.println("4. Print array");
        	System.out.println("5. Exit");
        	System.out.println("-----------------");
        	System.out.println("Enter your choice: ");
        	
        	int choice = scanner.nextInt();
        	
        	switch(choice) {
        	
        	case 1: // enqueue
        		
        		System.out.println();
        		System.out.println("Enter a number to enqueue: ");
        		int number = scanner.nextInt();
        		
        		if (number == 0) { // 0 is considered a null value, cannot be inputed.
        			System.out.println("Cannot enqueue 0.");
        		}
        		q.enqueue(number);
        		System.out.println("Number enqueued.");
        		
        		break;
        		
        	case 2: // dequeue 
        		
        		System.out.println();
        		q.dequeue();
        		
        		break;
        		
        	case 3: // Check whether the array is empty ot not
        		
        		System.out.println(q.isEmpty());
        		
        		break;
        		
        	case 4: // Print the array
        		
        		q.printArray();
        		
        		break;
        	       	
        	case 5: // Exit the program
        		
        		q.exitProgram();
        		
        		break;
        	
            default:
                System.out.println();
            	System.out.println("Invalid choice.");
            	break;
        	}
        	
        }
		
	}

}
    
    
	
