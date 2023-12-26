package utils;

import model.LinkedStack;

public class EqautionProcessing {
	/*
	 * This utility class is used to perform operations on the equation expressions
	 */

	public static double evaluatePostfix(String postfixExpression) {
		/*
		 * This method takes a postfixExpression and evaluate it 
		 * using the stack
		 */
		LinkedStack<Double> stack = new LinkedStack<>();
		for (char c : postfixExpression.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(Double.parseDouble(String.valueOf(c)));
			} else if (Operations.isOperator(c)) {
				double operand2 = stack.pop();
				double operand1 = stack.pop();
				double result = Operations.performOperation(c, operand1, operand2);
				stack.push(result);
			}
		}
		return stack.pop();
	}

	public static double evaluatePrefix(String prefixExpression) {
		/*
		 * This method takes a prefixExpression and evaluate it 
		 * using the stack
		 */
		LinkedStack<Double> stack = new LinkedStack<>();
		for (int i = prefixExpression.length() - 1; i >= 0; i--) {
			char c = prefixExpression.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(Double.parseDouble(String.valueOf(c)));
			} else if (Operations.isOperator(c)) {
				double operand1 = stack.pop();
				double operand2 = stack.pop();
				double result = Operations.performOperation(c, operand1, operand2);
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	public static String postfixToPrefix(String postfixExpression) {
		/*
		 * This method takes a postfix expression and convert to a prefix
		 */
		LinkedStack<String> stack = new LinkedStack<>();
		for (char c : postfixExpression.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(String.valueOf(c));
			} else if (Operations.isOperator(c)) {
				String operand2 = stack.pop();
				String operand1 = stack.pop();
				String result = c + operand1 + operand2;
				stack.push(result);
			}
		}
		return stack.pop();
	}

	public static String infixToPostfix(String infixExpression) {
		/*
		 * This method takes an infix Expression and convert to a prefix
		 */
	    StringBuilder postfix = new StringBuilder();
	    LinkedStack<Character> stack = new LinkedStack<>();
	    for (char c : infixExpression.toCharArray()) {
	        if (Character.isDigit(c)) {
	            postfix.append(c);
	        } else if (c == '(') {
	            stack.push(c);
	        } else if (c == ')') {
	            while (!stack.isEmpty() && stack.peek() != '(') {
	                postfix.append(stack.pop());
	            }
	            stack.pop(); // Pop '('
	        } else if (Operations.isOperator(c)) {
	            while (!stack.isEmpty() && Operations.precedence(c) <= Operations.precedence(stack.peek())) {
	                postfix.append(stack.pop());
	            }
	            stack.push(c);
	        }
	    }
	    while (!stack.isEmpty()) {
	        postfix.append(stack.pop());
	    }
	    return postfix.toString();
	}
}