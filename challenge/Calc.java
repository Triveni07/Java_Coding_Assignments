package challenge;

import java.util.Stack;

/********************************************************************************************************	
 *  My Note:
 * 	Infix to post-fix Set of Rules:-->
 * 
 * 	a) Keep the sequence of numbers as it is 
 *	b) To check for higher precedence of operator in a String, 
 *	c) once we get higher precedence then we should place them in a descending order of precedence.
 *	d) And then move on to next number and operator subsequently
 *	----------------------------------------------------------------------------------------------------
 *  1) Very first considered splitting the String into parts separated by white space.
 *	2) Used stack data structure for FILO(First In Last Out) form of elements manipulation.
 *	3) As per the switch cases, default case used to collect numbers using push() 
 *	and other cases for operators- where elements taken out to perform operator 
 *	case matching operations as per the instructions given.
 *	4) Considered numbers(result here) as operand which popped twice in cases and 
 *	with respect to the matching cases of operators, performed operations on numbers.
 *	5) Finally  result was  evaluated, and pushed into stack.
 *	6) Returned the expected result
 * 	@author Triveni
 *
 *******************************************************************************************************/
public class Calc {
/**
 * 	This function is a calculator which evaluates expressions given in the string format,
 * 	using stack's pop and push methods and switching cases matching numbers, operators 
 * 	performed operations on parts of String (i.e. converting string into an array by split()). 
 * 	The expressions are numbers and operators. 
 * 	@param String
 * 	@return double
 */
	public static double evaluate(String expr) {

//		Splitting string considering white spaces and collecting it into array
		String [] parts = expr.split(" ");

//		Defining stack
		Stack<Double> st = new Stack<Double>();	
		double operand1 = 0.0;
		double operand2 = 0.0;
		double result = 0.0;

//		Iterating String array to find the matching switch cases and perform operations accordingly:
		for (int i = 0 ; i < parts.length ; i++)
		{
			switch (parts[i]) {
			case "": return 0;

			case "+": 
				operand2 = st.pop();
				operand1 = st.pop();
				result = operand1 + operand2;
				st.push(result);
				break;

			case "-":
				operand2 = st.pop();
				operand1 = st.pop();
				result = operand1 - operand2;
				st.push(result);
				break;
				
			case "*":
				operand2 = st.pop();
				operand1 = st.pop();
				result = operand1 * operand2;
				st.push(result);
				break;

			case "/":
				operand2 = st.pop();
				operand1 = st.pop();
				result = operand1 / operand2;
				st.push(result);
				break;

			default:
				result = Double.parseDouble(parts[i]);
				st.push(result);
				break;
			}
		}
		return result;

	}
/*	public static void main(String args[]) {
//		(1 + 2 * 3 / 2)---> Infix operator notation
		String expr1 = "1 2 3 2 / * +";//---> Post-fix operator notation
//		((7 * (4+5) -3 )/10)
		String expr2 = "7 4 5 + * 3 - 10 /";
//		( 7 - (8 * (6 / 2)) + 10 - (5 * 4))--> 
		String expr3 = "7 8 6 2 / * - 10 5 4 * - +";
//		( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
		String expr4 = "2 3 4 + 5 6 * * +";

		double result1 = evaluate(expr1); 
		double result2 = evaluate(expr2); 
		double result3 = evaluate(expr3);
		double result4 = evaluate(expr4);

		String fs1 = String.format("Result of the expression " + expr1 + " = " + result1);
		String fs2 = String.format("Result of the expression " + expr2 + " = " + result2);
		String fs3 = String.format("Result of the expression " + expr3 + " = " + result3);
		String fs4 = String.format("Result of the expression " + expr4 + " = " + result4);

		System.out.println(fs1);
		System.out.println(fs2);
		System.out.println(fs3);
		System.out.println(fs4);
	}	
*/

}
