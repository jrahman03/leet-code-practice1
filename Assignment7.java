import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Name: Jewel Rahman
// Class: CS211
// Date: 5/19/22
// Instructor: Craig Niiyama
// Description: This class contains the methods seeingThree, twoStacksAreEqual, and isMirrored. 
// seeingThree takes a stack and makes and replaces every value in the stack with three occurrences of that value
// twoStacksAreEqual takes as parameters two stacks of integers and returns true if the two stacks are equal and that returns false otherwise.
// isMirrored takes a queue of integers as a parameter and returns true if the numbers in the queue represent a palindrome (and false otherwise).


public class Assignment7 {

	// the entry point of the class calling the test methods which in turn calling the assigned methods
	public static void main(String[] args) {
		testSeeingThreeMethod();
		testTwoStacksAreEqualMethod();
		testIsMirrored();
	
	}
	// pre : a stack of integers
	// post: every value in the stack is replaced with three occurrences of that value
	public static void seeingThree(Stack<Integer> s) {
		
		 /*********Write Code Here************/
		
		// Making a Queue for the Stack
		Queue<Integer> q = new LinkedList<Integer>();
		
		int size = 0;
		
		// While loop until the parameter stack s is empty 
		while(!s.isEmpty()) {
			q.add(s.pop());
			size ++;
		
			//For loop that goes through the size 
			for(int i = 0; i < size - 1; i++) {
				q.add(q.remove());	
			}
		}
		
		//While loop until the made Queue q is empty
		while(!q.isEmpty()) {
			int removed_val = q.remove();
			// Pushing to the stack 3 times in order to see the given num 3 times
			s.push(removed_val);
			s.push(removed_val);
			s.push(removed_val);
			}
	    }
	
	// pre : two stacks of integers
	// post: a boolean result of true if the stacks are equal or false if the stacks are not equal
	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {
		
		 /*********Write Code Here************/
		
		//if statement judging whether or not the stacks are incomparable sizes, if so return false
		if(s1.size() != s2.size()) {
			return false;	
		}
		
		// Equal means will return true since they are both equal sizes 
		boolean equal = true;
		
		// Temporary Stack
		Stack<Integer> temp = new Stack<Integer>();
		
		//while loop until both s1 and s2 are empty
		while(!s1.isEmpty()) {
			//if s1 top element != s2 first element, they they wont be equal, equal = false
			if(!s1.peek().equals(s2.peek())) {
				equal = false;
			} else { // add the top item to the temp stack and remove from both s1 and s2
				temp.push(s1.peek());
				s1.pop();
				s2.pop();
			}
		}
		//reset the elements with while loop using the temp stack and putting them into s1 and s2
		while(!temp.isEmpty()) {
			s1.push(temp.peek());
			s2.push(temp.peek());
			temp.pop();
		}
		// returns if equal or not
		return equal;
	}

	// pre : a queue of integers
	// post: returns true if the numbers in the queue represent a palindrome (and false otherwise). 
	//       A sequence of numbers is considered a palindrome if it is the same in reverse order
	public static boolean isMirrored(Queue<Integer> q) {
		
		 /*********Write Code Here************/
		
		// new stack
		Stack<Integer> s = new Stack<Integer>();
		
		// for loop that goes through the size
		for(int i = 0; i < q.size(); i++) {
			int temp_val = q.remove();
			//adds to the top of stack
			s.push(temp_val);
			// adds to end of queue to be in order
			q.add(temp_val);
		}
		
		// the queue is assumed to be mirrored at first
		boolean mirrored = true;
		
		//for loop going through the size
		for(int i = 0; i < q.size(); i++) {
			//if the first (top) elements of s and q aren't = then its not mirrored, will set mirror to a false status
			if(!s.peek().equals(q.peek())){
				mirrored = false;
			}
			q.add(q.remove());
			s.pop();
		}
		//return the status
		return mirrored;	
	}

	// This is a test method testing twoStacksAreEqual method. It test both the true case and the false case
	private static void testIsMirrored() {

		Queue<Integer> myQueueP  = new LinkedList<Integer>();;
	
		for (int i = 0; i < 5; i++)
		{
		
			System.out.print(i);
			myQueueP.add(i);
			
		}
		for (int i = 3; i >= 0 ; i--)
		{
			
			System.out.print(i);
			myQueueP.add(i);
				
		}
		
		
		System.out.println();
		
		System.out.println(isMirrored(myQueueP) + " isMirrord");
		
	}

	//test method to test the testTwoStacksAreEqualMethod. 
	//It tests cases of the same stack and not the same stack.
	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1  = new Stack<Integer>();	
		Stack<Integer> myStack2  = new Stack<Integer>();
		Stack<Integer> myStack3  = new Stack<Integer>();
		Stack<Integer> myStack4  = new Stack<Integer>();
	
		for (int i = 0; i < 5; i++)
		{
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		
		}
		for (int i = 0; i < 6; i++)
		{
			myStack3.push(i);
		
		}
	
		System.out.println(twoStacksAreEqual(myStack1,myStack2) + " Same Stack ");
		
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
		
	}

	//Method to test the SeeingThree method
	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		
		for (int i = 0; i < 5; i++)
		{
			myStack.push(i);

		}
		
		
		System.out.println();
		print(myStack);
		
		seeingThree(myStack);
	
		print(myStack);
		
	}
	// pre : a stack of integers
	// post: prints out the stack of integers
	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();

		 while ( e.hasMoreElements() )
		      System.out.print( e.nextElement() + " " );
		    System.out.println();

	
	}

} //end of Assignment7