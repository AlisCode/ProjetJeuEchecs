package controler;

import tools.data.Coord;
import tools.data.Couleur;

public interface ChessGameControlerModel {

	/**
	 * @param pieceToMoveCoord
	 * @param pieceToMoveCouleur
	 * 
	 *            Cette méthode est appelé par la méthode mousePressed de
	 *            l'écouteur d'évènements souris.
	 * 
	 *            Elle permet d'invoquer des méthodes du model (par exemple
	 *            récupérer la liste cases de destinations possibles d'une pièce
	 *            sélectionnée) ou les méthodes de la vue (par exemple, fixer la
	 *            pièce qui doit être déplacée, allumer les cases de
	 *            destinations possibles)
	 */
	public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord,
			Couleur pieceToMoveCouleur);

	/**
	 * @param pieceToMoveCoord
	 * @param targetCoord
	 * 
	 *            Cette méthode est appelé par la méthode mouseReleased de
	 *            l'écouteur d'évènements souris.
	 * 
	 *            Elle permet d'invoquer des méthodes du model (par exemple
	 *            move() ou pawnPromotion()) ou les méthodes de la vue (par
	 *            exemple, déplacer effectivement la pièce ou la repositionner à
	 *            sa place initiale)
	 */
	public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord,
			Coord targetCoord);

}
