package model.business;

import java.util.List;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

/**
 * @author francoise.perrin
 * 
 *         Cette interface défini le comportement (métier) attendu des jeux
 *         d'échec
 *
 */
public interface ChessGameModel {

	/**
	 * @return la couleur du joueur courant
	 */
	public Couleur getColorCurrentPlayer();

	/**
	 * @param x
	 * @param y
	 * @return la couleur de la pièce sélectionnée
	 */
	public Couleur getPieceColor(int x, int y);

	/**
	 * @param xInit
	 * @param yInit
	 * @return la liste des destination possibles d'une Pieces
	 */
	public List<Coord> getPieceListMoveOK(int xInit, int yInit);

	/**
	 * Permet de deplacer une piece connaissant ses coordonnees initiales vers
	 * ses coordonnees finales *
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return le type de déplacement (avec ou sans prise, etc.)
	 */
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal);

	/**
	 * @param x
	 * @param y
	 * @param promotionType
	 * @return true si la promotion a été effectuée
	 */
	public boolean pawnPromotion(int x, int y, String promotionType);

	/**
	 * @return true si c'est la fin du jeu
	 */
	public boolean isEnd();

}
