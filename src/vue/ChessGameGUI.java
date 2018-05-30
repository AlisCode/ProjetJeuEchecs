package vue;

import java.util.List;
import tools.data.Coord;

/**
 * @author francoise.perrin
 *
 *         Cette interface défini le comportement attendu par le damier de la
 *         vue
 * 
 */

public interface ChessGameGUI {

	/**
	 * @param coord
	 * 
	 *            Cette méthode est appelée par le CONTROLER en cas de
	 *            mousePressed() pour fixer la pièce à déplacer
	 */
	public void setPieceToMove(Coord coord);

	/**
	 * @param coords
	 * @param isLight
	 * 
	 *            Cette méthode est appelée par le CONTROLER en cas de
	 *            mousePressed() : isLight = true, ou de mouseReleased() :
	 *            isLignt = false Elle éclaire ou remet dans leur couleur
	 *            d'origine les cases concernées par les destinations possibles
	 *            de la pièce à déplacer
	 */
	public void resetLight(List<Coord> coords, boolean isLight);

	/**
	 * @param coord
	 * 
	 *            Cette méthode est appelée par le CONTROLER en cas de
	 *            mouseReleased() uniquement dans le cas ou l'appel
	 *            controler.doMoveAndPromote() est OK la case de destination est
	 *            recherchée : si elle contient une pièce, celle ci est
	 *            supprimée puis pieceToMove est effectivement déplacée
	 * 
	 * */
	public void movePiece(Coord targetCoord);

	/**
	 * @param coord
	 * 
	 *            Cette méthode est appelée par le CONTROLER en cas de
	 *            mouseReleased() lorsque le déplacement est illégal la case
	 *            d'origine est recherchée : la pièce est replacée à ses
	 *            coordonnées d'origine
	 * 
	 * */
	public void undoMovePiece(Coord pieceToMoveInitCoord);

	/**
	 * @return promotionType Cette méthode est appelée par le CONTROLER en cas
	 *         de mouseReleased() et que le model a indiqué qu'on était dans un
	 *         cas de promotion du pion elle demande en quoi l'utilisateur veut
	 *         promouvoir le pion
	 */
	public String getPromotionType();

	/**
	 * @param coord
	 * @param promotionType
	 * 
	 *            Cette méthode est appelée par le CONTROLER en cas de
	 *            mouseReleased() et que lemodel a indiqué qu'on était dans un
	 *            cas de promotion du pion Elle change l'image de la pièce en
	 *            fonction du choix de l'utilisateur
	 */
	public void promotePiece(Coord coord, String promotionType);

}
