package tools;

public class MathHelper {

	/**
	 * Math helper utility, checks if number c is between a and b
	 * 
	 * @param a
	 *            First Boundary, inclusive
	 * @param b
	 *            Second boundary, exclusive
	 * @param c
	 *            Number to test
	 * @return True if c is between a and b
	 */
	public static boolean isBetween(int a, int b, int c) {
		return b > a ? c >= a && c < b : c > b && c <= a;
	}

}
