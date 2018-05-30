package controler.controlerLocal;

import javax.swing.JLayeredPane;

import tools.data.Coord;
import tools.data.Couleur;
import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;

public class ChessControlerLocal implements ChessGameControlerModelVue {

	public ChessControlerLocal(ChessGameModel chessGame) {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return false;
	}

}
