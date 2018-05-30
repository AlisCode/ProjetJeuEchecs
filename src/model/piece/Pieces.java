package model.piece;

import java.util.List;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 * @author francoise.perrin - Alain BECKER Inspiration Jacques SARAYDARYAN,
 *         Adrien GUENARD *
 * 
 *         cette interface définit le comportement attendu des pièces
 */
public interface Pieces {

	/**
	 * @return indice de la colonne où est positionnée la piece
	 */
	public int getX();

	/**
	 * @return indice de la ligne où est positionnée la piece
	 */
	public int getY();

	/**
	 * @return couleur de la piece
	 */
	public Couleur getCouleur();

	/**
	 * @return le nom de la pièce (Tour, Cavalier, etc.) attention le type ne
	 *         correspond pas forcément au nom de la classe
	 */
	public String getName();

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement effectué
	 */
	public ActionType doMove(int xFinal, int yFinal);

	/**
	 * @return true si piece effectivement capturée Positionne x et y à -1
	 */
	public boolean catchPiece();

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement légal en fonction des algo de déplacement
	 *         spécifique de chaque pièce
	 */
	public boolean isAlgoMoveOk(int xFinal, int yFinal);

	/**
	 * @param xFinal
	 * @param yFinal
	 * @param type
	 * @return true si déplacement légal en fonction des algo de déplacement
	 *         spécifique de chaque pièce dans le cas d'un déplacement avec
	 *         prise
	 */
	public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type);

	/**
	 * @param xFinal
	 * @param yFinal
	 * @return la liste des coordonnées des cases traversée en allant vers case
	 *         de destination
	 */
	public List<Coord> getMoveItinerary(int xFinal, int yFinal);

	/**
	 * Effectue un rollback du dernier mouvement (en rétablissant les
	 * coordonnées initiales de la pièce, telles que mémorisées avant son
	 * déplacement).
	 */
	public boolean undoLastMove();

	/**
	 * Effectue un rollback de la capture (en rétablissant les coordonnées
	 * initiales de la pièce au moment de sa capture).
	 */
	public boolean undoLastCatch();
};
