package practice;

public class InfixToPrefixConversion {

	public static void main(String[] args) {
		String inputExpr = "( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )";
		String prefix = convertInfixToPrefix(inputExpr);
		System.out.println(prefix);
	}
	public static String convertInfixToPrefix(String infix) {
		String postfix = InfixToPostfixConversion.convertInfixToPostfix(infix);
		String prefix = reverseString(postfix);
		return prefix;
	}
	public static String reverseString(String str) {
		String reverseString = "";
		String [] words = str.split(" ");
		for(int i = words.length-1; i >= 0; i--) {	

			reverseString += words [i];
			reverseString = reverseString.concat(" ");
		}			
		reverseString = reverseString.trim();
		return reverseString;
	}
}
