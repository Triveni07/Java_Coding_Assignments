package practice;

import java.util.Stack;

/********************************************************************************************************	
 *  	My Note:
 * 		Infix to post-fix Set of Rules:-->
 * 
 * 		a) Keep the sequence of numbers as it is 
 *		b) To check for higher precedence of operator in a String, 
 *		c) once we get higher precedence then we should place them in a descending order of precedence.
 *		d) And then move on to next number and operator subsequently
 *		----------------------------------------------------------------------------------------------------
 *  	1) Very first considered splitting the String into parts separated by white space.
 *		2) Used stack data structure for FILO(First In Last Out) form of elements manipulation.
 *		3) As per the switch cases, default case used to collect numbers using push() 
 *		and other cases for operators- where elements taken out to perform operator 
 *		case matching operations as per the instructions given.
 *		4) Considered numbers(result here) as operand which popped twice in cases and 
 *		with respect to the matching cases of operators, performed operations on numbers.
 *		5) Finally  result was  evaluated, and pushed into stack.
 *		6) Returned the expected result
 * 		@author Triveni
 *
 *******************************************************************************************************/
public class Calc {

	/**
	 *      This function is a calculator which evaluates expressions given in the string format,
	 *      using stack's pop and push methods and switching cases matching numbers, operators 
	 *	   performed operations on parts of String (i.e. converting string into an array by split()). 
	 * 	   The expressions are numbers and operators. 
	 *	   @param String
	 * 	   @return double
	 */	
	private static double operand1 = 0.0;
	private static double operand2 = 0.0;
	private static double result = 0.0;
	private static String operator = "";

	public static double evaluateFromPostfix(String expr) throws NumberFormatException{
		//	 	String postfix =  "2 3 4 + 5 6 * * +" --> infix = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
		String [] exprArray = expr.split(" ");
		Stack<Double> st = new Stack<Double>();	 //Defining stack to collect operands

		for (int i = 0 ; i < exprArray.length ; i++)
		{
			switch (exprArray[i]) {
			case "": return 0;
			case "+": case "-": case "*": case "/":
				operand2 = st.pop();
				operand1 = st.pop();
				operator = exprArray[i];
				result = calculate(operand1, operator, operand2);
				st.push(result);
				break;

			default:
				try {
					result = Double.parseDouble(exprArray[i]);
					st.push(result);
				}catch(NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				break;
			}
		}

		return result;
	}
	public static double evaluateFromPrefix(String expr) throws NumberFormatException{
		//expr = "+ * * 6 5 + 4 * 3 2 2";
		String [] exprArray = expr.split(" ");
		Stack<Double> st = new Stack<Double>();	 //Defining stack to collect operands

		for (int i = exprArray.length-1 ; i >=0 ; i--)
		{
			switch (exprArray[i]) {
			case "": return 0;
			case "+": case "-": case "*": case "/":
				operand2 = st.pop();
				operand1 = st.pop();
				operator = exprArray[i];
				result = calculate(operand1, operator, operand2);
				st.push(result);
				break;

			default:
				try {
					result = Double.parseDouble(exprArray[i]);
					st.push(result);
				}catch(NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				break;
			}
		}

		return result;
	}

	private static double calculate(double operand1, String operator, double operand2) {

		double result = 0.0;
		switch (operator) {
		case "+":
			result = operand1 + operand2;		
			break;
		case "-":
			result = operand1 - operand2;		
			break;
		case "*":
			result = operand1 * operand2;		
			break;
		case "/":
			result = operand1 / operand2;		
			break;

		default:
			break;
		}

		return result;
	}

}
