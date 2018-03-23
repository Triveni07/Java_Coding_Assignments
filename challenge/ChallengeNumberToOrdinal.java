package challenge;

/*************************************************************************************************************
 *  	
 *  My Notes:
 * 	1) Initially, thought of total 6 exceptional cases i.e. other than 'th' suffix. 
 *     As 1st, 2nd,3rd and 11th, 12th, 13th etc.
 *	2) So chose to use switch, but in case of 11, 12, 13 needed to check last two digits of any number. 
 *	   That is why used nested switch and checked condition for 10th digit of any number using modulo operator. 
 *	3) Under default section of first switch used nested switch to check the 1st digit of any number 
 *	   against the exceptional cases 1, 2, 3. And selected suffixes accordingly.
 *	4) Rest part was to apply 'th' suffix for all other numbers using default part.
 *	5) Finally return the ordinal number as String with suffix.
 *
 **************************************************************************************************************/
public class ChallengeNumberToOrdinal {
/**
 * 	 This function checks the first and 10th digits of a number 
 *	 and returns a String with specified suffix as per the cases given.
 *	 @param number
 * 	 @return String
*/
	public static String numberToOrdinal(Integer number) {
//		For 0 number only: returns a string as it is
		if(number == 0) {
			return number.toString();
		}
/* 
 *	 For number greater than 0 assuming positive integer values only: 
 *	 Nested switch cases to get the 10th digit first in case of exception 
 *	 i.e.11th, 12th and 13th and inner switch to get the 1st digit 
 *	 and use the english suffix as per the instructions given.
 */		
		String ordinalNumberAsString = "";
		String suffix = "";		
//		Outer switch to get the 10th digits and check the suffix accordingly
		switch (number % 100) {
		case 11: case 12: case 13: suffix = "th";			
		break;

		default:	
//			Inner switch to get the 1st digits and check the suffix accordingly
			switch (number % 10) {
			case 1: suffix = "st";	
			break;
			case 2: suffix = "nd";
			break;
			case 3: suffix = "rd";
			break;

			default: suffix = "th";
			break;
			}
			break;
		}
//		Number as a String ordinal with suffix
		ordinalNumberAsString =  number.toString() + suffix;

		return ordinalNumberAsString;
	}

/*	public static void main(String[] args) {
		String str1 = numberToOrdinal(0); //0
		String str2 = numberToOrdinal(1); //st
		String str3 = numberToOrdinal(2); //nd
		String str4 = numberToOrdinal(3); //rd
		String str5 = numberToOrdinal(4); //th
		String str6 = numberToOrdinal(11); //th
		String str7 = numberToOrdinal(12); //th
		String str8 = numberToOrdinal(13); //th
		String str9 = numberToOrdinal(100); //th
		String str10 = numberToOrdinal(1021); //st

		System.out.println(str1 + "\n" + str2 +"\n" + str3 +"\n" + str4 +"\n" + str5 
				+"\n" + str6 +"\n" + str7 +"\n" + str8 +"\n" + str9 +"\n" + str10);
	}	
*/}
