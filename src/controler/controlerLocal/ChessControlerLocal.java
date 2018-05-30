package controler.controlerLocal;

import javax.swing.JLayeredPane;

import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;
import controler.ChessGameControlerModelVue;

public class ChessControlerLocal implements ChessGameControlerModelVue {

	private ChessGameModel chessGame;

	public ChessControlerLocal(ChessGameModel chessGame) {
		this.chessGame = chessGame;
	}

	@Override
	public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord,
			Couleur pieceToMoveCouleur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord,
			Coord targetCoord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGridPanel(JLayeredPane panel) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
		return this.chessGame.getColorCurrentPlayer() == pieceToMoveCouleur;
	}

}
