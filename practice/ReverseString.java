package practice;

public class ReverseString {

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
	
	public static String reverseCharacters(String str) {
		String reverseChars = "";
		StringBuilder sb = new StringBuilder(str);
		reverseChars = sb.reverse().toString();

		return reverseChars;
	}
	
	public static String reverseAlternateChars(String str) {
		String reverseAlternateChars = "";
		String evenStr = "";
		char[]charArr = str.toCharArray();
		int i, j;

		for(i = 1; i < charArr.length; i += 2) {
			evenStr += charArr[i];			
		}
		evenStr = reverseCharacters(evenStr);//reversed
		for(i = 1, j = 0; i < charArr.length; i += 2, j++) {		
			charArr[i] = evenStr.charAt(j);	
		}
		for (i = 0; i < str.length(); i ++) {
			reverseAlternateChars += charArr[i];
		}
		return reverseAlternateChars;
	}
}
