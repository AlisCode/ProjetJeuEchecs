package controler;

import javax.swing.JLayeredPane;

import tools.data.Couleur;

public interface ChessGameControlerModelVue extends ChessGameControlerModel {

	/**
	 * @param panel
	 * 
	 *            Cette méthode permet à la vue d'indiquer au controler avec
	 *            lequel de ses composants, il peut échanger
	 */
	public void setGridPanel(JLayeredPane panel);

	/**
	 * @param pieceToMoveCouleur
	 * @return true si c'est bien au tour du joueur de la couleur passée en
	 *         paramètre de jouer, false sinon
	 */
	public boolean isPlayerOk(Couleur pieceToMoveCouleur);
}
