package utils;

public class Operations {
	/*
	 * I have crerated this utility class that helps with the operations in the
	 * stack
	 */

	public static boolean isOperator(char c) {
		/* Check if character is operator */
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static int precedence(char operator) {
		/* returns the precedence of an operator */
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static double performOperation(char operator, double operand1, double operand2) {
		/*
		 * This method takes two operands and & the operator and evaluates them
		 */
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 != 0) {
				return operand1 / operand2;
			} else {
				throw new ArithmeticException("Division by zero");
			}
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}