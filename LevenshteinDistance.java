/**
 * @author Khoa Tran
 * @version 07/23/2012
 * Computes the Levenshtein distance between two strings. 
 * An output of zero means the strings are identical.
 * For more information: http://en.wikipedia.org/wiki/Levenshtein_distance
 * Source code adapted from: http://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance#Java
 */

public class LevenshteinDistance {
	
	/**
	 * Computes the minimum of three numbers, using Math.min
	 * @param a the first number
	 * @param b the second number
	 * @param c the third number
	 * @return the smallest of the three numbers
	 */
	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	/**
	 * Computes the Levenshtein distance between two sequences of characters
	 * The algorithm and pseudocode can be found here: http://en.wikipedia.org/wiki/Levenshtein_distance
	 * @param str1 the source string
	 * @param str2 the target string, to be compared with the source string
	 * @return the Levenshtein distance between the two strings
	 */
	public static int computeLevenshteinDistance(CharSequence str1, CharSequence str2) {
		int[][] distance = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
			distance[i][0] = i;
		for (int j = 0; j <= str2.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++)
				distance[i][j] = minimum(
						distance[i - 1][j] + 1, /* a deletion */
						distance[i][j - 1] + 1, /* an insertion */
						distance[i - 1][j - 1]  /* a substitution */
						                + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
						                		: 1));

		return distance[str1.length()][str2.length()];
	}
	
	private static final String ZEROES = "000000000000";
	
	/**
	 * Formats a double value into a String with n decimal points
	 * @param val the value to be formatted
	 * @param n the number of decimal points
	 * @return the formatted String representation of val
	 */
	public static String format(double val, int n) 
	{
	    /* rounding */			
		double incr = 0.5;
		for (int j = n; j > 0; j--) 
			incr /= 10; 
		val += incr;
		
		String s = Double.toString(val);
		int n1 = s.indexOf('.');
		int n2 = s.length() - n1 - 1;
		
		if (n > n2)      
			s = s + ZEROES.substring(0, n - n2);
		else if (n2 > n) 
			s = s.substring(0, n1 + n + 1);
		
		return s;
	}	
}
