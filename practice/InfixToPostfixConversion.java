package practice;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Logger;

public class InfixToPostfixConversion {

	final static Logger logs = Logger.getAnonymousLogger();
	private static Stack<String> operatorStack = new Stack<String>();
	private static String postFixExpr = "";
	private static String topStackOp = "";
	private static boolean isTopStackOpGreaterOrEqual = false;

	public static void main(String[] args) {
		String inputExpr = "( 7 + ( 2 * 300 ) * 2 ( 15 / 3 ) + 50 )";
		String postFix = convertInfixToPostfix(inputExpr);
		String output = String.format("Input expression = " + inputExpr + "\n" +
				"Postfix expression = " + postFix);
		System.out.println(output);
	}

	public static String convertInfixToPostfix(String str) {
		String[] prefixExpr = str.split(" ");
		for(int i = 0; i< prefixExpr.length; i++) {
			
			switch (prefixExpr[i]) {	
			
			case "+": case "-": case "*": case "/": case "(": case ")":
				processOperators(prefixExpr[i]);
				break;
				
			default:
				postFixExpr += prefixExpr[i] + " ";
				break;
			}
		}	
		//	Outside for loop for rest of the operators in the stack..	
		while(!operatorStack.empty()) {
			postFixExpr += operatorStack.pop() + " ";
		}
		return postFixExpr;
	}
	private static void processOperators (String operator) {
		switch (operator) {
		case "(":
			operatorStack.push(operator);			
			break;

		case ")":
			try {
				while(!operatorStack.peek().equals("(")) {
					postFixExpr += operatorStack.pop() + " ";
				}
				operatorStack.pop();//remove "("
			} catch(EmptyStackException ese) {
				break;
			}
			break;

		default:
			try {
				do {
					topStackOp = operatorStack.peek();
					isTopStackOpGreaterOrEqual = checkOperatorPrecedence(topStackOp, operator);

					if(isTopStackOpGreaterOrEqual) {
						postFixExpr += operatorStack.pop() + " ";

					}else{
						operatorStack.push(operator);//less precedence push only
						break;
					}
				}while(isTopStackOpGreaterOrEqual);

			} catch(EmptyStackException ese) {
				operatorStack.push(operator);
			}
			break;
		}
		/*
		 * default:
			try {
				topStackOp = operatorStack.peek();
				isTopStackOpGreaterOrEqual = checkOperatorPrecedence(topStackOp, operator);
				if(!isTopStackOpGreaterOrEqual) {
					operatorStack.push(operator);//less precedence push only
					break;
				}
				while(isTopStackOpGreaterOrEqual) {
					postFixExpr += operatorStack.pop() + " ";
					topStackOp = operatorStack.peek();
					isTopStackOpGreaterOrEqual = checkOperatorPrecedence(topStackOp, operator);
				}
				operatorStack.push(operator);
			} catch(EmptyStackException ese) {
				operatorStack.push(operator);
			} 

			break;
		}

		 */
	}

	private static boolean checkOperatorPrecedence(String topStackOp, String operator) {
		boolean isGreaterThanStringOperator = false;
		isGreaterThanStringOperator = (checkOperatorPriority(topStackOp) >= 
				checkOperatorPriority(operator));

		return isGreaterThanStringOperator;	
	}

	public static int checkOperatorPriority(String operator) {
		int precedence = 0;
		switch (operator) {
		case "+": case "-": precedence = 1;
		break;
		case "*": case "/": precedence = 2;
		break;
		case "(": precedence = -1;
		break;

		}
		return precedence;		
	}
}
