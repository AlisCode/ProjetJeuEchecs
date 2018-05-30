package tools;

import java.awt.Color;

import tools.data.Couleur;

public class BoardGameConfig {
	private static int nbLigne;
	private static int nbColonne;
	private static String factoryName;
	private static Couleur beginColor;
	private static Color blackSquareColor, whiteSquareColor;
	private static int dim;

	/**
	 * @param nbLigne
	 * @param nbColonne
	 * @param factoryName
	 * @param couleur
	 */

	private static BoardGameConfig instance = null;

	public static BoardGameConfig newInstance(int nbLigne, int nbColonne,
			String factoryName, Couleur beginColor, Color blackSquareColor,
			Color whiteSquareColor, int dim) {
		if (instance == null)
			instance = new BoardGameConfig(nbLigne, nbColonne, factoryName,
					beginColor, blackSquareColor, whiteSquareColor, dim);
		return instance;
	}

	private BoardGameConfig(int nbLigne, int nbColonne, String factoryName,
			Couleur beginColor, Color blackSquareColor, Color whiteSquareColor,
			int dim) {

		BoardGameConfig.nbLigne = nbLigne;
		BoardGameConfig.nbColonne = nbColonne;
		BoardGameConfig.factoryName = factoryName;
		BoardGameConfig.beginColor = beginColor;
		BoardGameConfig.blackSquareColor = blackSquareColor;
		BoardGameConfig.whiteSquareColor = whiteSquareColor;
		BoardGameConfig.dim = dim;
	}

	/**
	 * @return the nbLigne
	 */
	public static int getNbLigne() {
		return BoardGameConfig.nbLigne;
	}

	/**
	 * @return the nbColonne
	 */
	public static int getNbColonne() {
		return BoardGameConfig.nbColonne;
	}

	/**
	 * @return the factoryName
	 */
	public static String getFactoryName() {
		return BoardGameConfig.factoryName;
	}

	/**
	 * @return the beginColor
	 */
	public static Couleur getBeginColor() {
		return BoardGameConfig.beginColor;
	}

	/**
	 * @param x
	 * @param y
	 * @return true si les coordonnées passées en paramètre sont dans les
	 *         limites du plateau
	 */
	public static boolean coordonnees_valides(int x, int y) {
		return ((x <= BoardGameConfig.nbColonne - 1) && (x >= 0)
				&& (y <= BoardGameConfig.nbLigne) && (y >= 0));
	}

	/**
	 * @return the blackSquareColor
	 */
	public static Color getBlackSquareColor() {
		return BoardGameConfig.blackSquareColor;
	}

	/**
	 * @return the whiteSquareColor
	 */
	public static Color getWhiteSquareColor() {
		return BoardGameConfig.whiteSquareColor;
	}

	/**
	 * @return the dim
	 */
	public static int getDim() {
		return BoardGameConfig.dim;
	}

}
