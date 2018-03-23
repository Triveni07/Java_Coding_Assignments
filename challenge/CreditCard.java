package challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**************************************************************************************************************
 *  My Notes:
 * 	1) Get the length of the String to check condition of length limit i.e less than 6;  return same String.
 *	2) Rest part is to cut the String into a part which is to be masked using substring().
 * 	3) Check that substring  against the pattern of digits only using Pattern and Matcher core libraries.
 *	4) And replace that pattern matched substring with the "#"  using replaceAll() of Matcher.
 *	5) Finally, again concatenate the first digit, repalced digits by"#" and 
 *	   last four digits substrings which forms a credit card number as a string with masked digits.
 *	6) Return that creditcard number as string.
 * 	@author Triveni
 *
 *************************************************************************************************************/
public class CreditCard {
	/**
	 *	 This function masks the digits only if greater than 6 in a string 
	 * 	 with a given character starting and ending at specified indices. 
	 *	 It handles blank and String less than 6 characters by returning original String.
	 *	 @param String
	 *	  @return String
	 */
	public static String maskify(String creditCardNumber) {
		
		int length = creditCardNumber.length();
		if(length < 6){
			return creditCardNumber;
		}
		String maskedDigits = "";
		maskedDigits = creditCardNumber.substring(1, (length-4)); 
		try {
			//returns Pattern object: a compiled representation of a regular expression.
			Pattern pattern = Pattern.compile("[0-9]");	
			//interprets the pattern and perform match operation
			Matcher matchedDigits = pattern.matcher(maskedDigits);
			maskedDigits = matchedDigits.replaceAll("#");

		}catch(PatternSyntaxException  pse) {
			pse.printStackTrace();//syntax error in regular expression
		}
		creditCardNumber = String.format(creditCardNumber.substring(0,1) + maskedDigits +
				creditCardNumber.substring((length-4), length));

		return creditCardNumber;
	}
	
	public static void main(String[] args) {
		String str1 = maskify("");
		String str2 = maskify("12345");
		String str3 = maskify("64607935616");
		String str4 = maskify("Ski546ppy");
		String str5 = maskify("Skippyyyy");
		String str6 = maskify("7234-5632-7896-4521");

		System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" 
				+ str4 + "\n" + str5 + "\n"+ str6 + "\n");
	}

}
