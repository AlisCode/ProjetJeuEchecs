package controler.controlerLocal;

import java.util.List;

import javax.swing.JLayeredPane;

import model.business.ChessGameModel;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import vue.ChessGridGUI;
import controler.ChessGameControlerModelVue;

public class ChessControlerLocal implements ChessGameControlerModelVue {

	private ChessGameModel chessGame;
	private ChessGridGUI chessGridGUI;

	public ChessControlerLocal(ChessGameModel chessGame) {
		this.chessGame = chessGame;
	}

	@Override
	public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord,
			Couleur pieceToMoveCouleur) {

		List<Coord> coords = this.chessGame.getPieceListMoveOK(
				pieceToMoveCoord.getX(), pieceToMoveCoord.getY());
		this.chessGridGUI.resetLight(coords, true);
	}

	@Override
	public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord,
			Coord targetCoord) {

		List<Coord> coords = this.chessGame.getPieceListMoveOK(
				pieceToMoveCoord.getX(), pieceToMoveCoord.getY());

		ActionType at = this.chessGame
				.move(pieceToMoveCoord.getX(), pieceToMoveCoord.getY(),
						targetCoord.getX(), targetCoord.getY());

		this.chessGridGUI.resetLight(coords, false);

		if (at != ActionType.ILLEGAL) {
			this.chessGridGUI.movePiece(targetCoord);
		} else {
			this.chessGridGUI.undoMovePiece(pieceToMoveCoord);
		}
	}

	@Override
	public void setGridPanel(JLayeredPane panel) {
		this.chessGridGUI = (ChessGridGUI) panel;
	}

	@Override
	public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
		return this.chessGame.getColorCurrentPlayer() == pieceToMoveCouleur;
	}

}
