package practice;

import java.util.logging.Logger;

public class InfixEvaluation {
	final static Logger logs = Logger.getAnonymousLogger();

	public static void main(String args[]) {
		/*
		 * 		Notes:
		 *  	Infix to post-fix Set of Rules:
		 * 		1) Keep the sequence of numbers as it is 
		 *		2) To check for higher precedence of operator in a String, 
		 * 		3) once we get higher precedence then we should place them in a descending order of precedence.
		 * 		4) Then move on to next operator and numbers subsequently.
		 */
		//infix expression
		String inputExpr = "( 20 + ( ( 2 * 3 + 4 ) * ( 5 * 6 ) ) )";			
		//postfix expression
		String postfix = "2 3 4 + 5 6 * * +";
		//prefix expression
		String prefix = "+ * * 6 5 + 4 * 3 2 20";

		double result1 = Calculator.evaluateFromPostfix(postfix); 
		double result2 = Calculator.evaluateFromPrefix(prefix);

		String fs1 = String.format("Result of the postfix expression: " + postfix + " = " + result1);
		String fs2 = String.format("Result of the prefix expression: " + prefix + " = " + result2);

		System.out.println(fs1 + "\n" + fs2);

		String postfixStr = InfixToPostfixConversion.convertInfixToPostfix(inputExpr);
		String prefixStr = InfixToPrefixConversion.convertInfixToPrefix(inputExpr); 
		double result3 = Calculator.evaluateFromPostfix(postfixStr); 
		double result4 = Calculator.evaluateFromPrefix(prefixStr);

		String output = String.format("Infix expression = " + inputExpr + "\n" +
				"Postfix conversion = " + postfixStr + "\n" + 
				"Prefix conversion = " + prefixStr + "\n" +
				"Calculated result by both way = " + result3 + " = " + result4);
		System.out.println(output);
	}
}
