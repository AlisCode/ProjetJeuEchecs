package tools;

import java.util.ArrayList;
import java.util.List;

import tools.data.Coord;

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

	public static List<Coord> getCoordsBetween(Coord depart, Coord arrivee,
			int xDeplacement, int yDeplacement) {
		List<Coord> coords = new ArrayList<Coord>();

		int xTemp = depart.getX();
		int yTemp = depart.getY();

		while (xTemp != arrivee.getX() && yTemp != arrivee.getY()) {
			coords.add(new Coord(xDeplacement, yDeplacement));
			xTemp += xDeplacement;
			yTemp += yDeplacement;
		}
		System.out.println("List Coord :" + coords);
		return coords;
	}

}
