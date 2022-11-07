/* Write a program of Balancing Brackets, use a suitable data structure to print
 * whether the string entered is Balanced Brackets or not.
 */

package com.greatlearning.lab3_question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	// method for checking if brackets are balanced or not
	private static boolean areBracketsBalanced(String input ) {

		Stack<Character> stack = new Stack<>();

		// Traversing the input
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);

			if (ch == '(' || ch== '[' || ch == '{') {
				// Push the element in the stack
				stack.push(ch);
			}

			if(stack.isEmpty()) {
				return false;
			}

			char temp;
			switch(ch) {

			case ')':
				temp = stack.pop();
				if(temp=='{' || temp=='[')
					return false;
				break;

			case '}':
				temp = stack.pop();
				if(temp=='(' || temp=='[')
					return false;
				break;

			case ']':
				temp = stack.pop();
				if(temp=='(' || temp=='{')
					return false;
				break;
			}
		}

		return (stack.isEmpty());
	}

	// method to check if input valid or not
	private static boolean isValid(String input ) {

		char[] value= input.toCharArray();	

		for(int i=0;i<value.length;i++) {

			if(value[i] !='{' && value[i] !='[' && value[i] !='(' && value[i] !='}' && value[i] !=']' && value[i] !=')') {
				System.out.println("invalid input....\nPlease enter brackets only.");
				return false;
			}	

		}
		return true;
	}

	// Driver code
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		System.out.print("Enter String:");
		String input = sc.nextLine();

		// Function call

		if(input.isEmpty()) {
			System.out.print("Null string not accepted.\nEnter String again : ");
		} else {
			boolean result = isValid(input);
			if(result) {
				if (areBracketsBalanced(input))
					System.out.println("The entered String has Balanced Brackets.");
				else
					System.out.println("The entered String do not contain Balanced Brackets."); 
			}
			sc.close();
		}
	}
}