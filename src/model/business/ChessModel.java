package model.business;

import java.util.List;

import model.ChessImplementor;
import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public class ChessModel implements ChessGameModel {

	private Couleur colorCurrentPlayer;
	private ChessImplementor chessImplementor;

	public ChessModel() {
		super();
		this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
		this.chessImplementor = new ChessImplementor();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.colorCurrentPlayer;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return this.chessImplementor.getPieceColor(x, y);
	}

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		return this.chessImplementor.getPieceListMoveOK(xInit, yInit);
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
		ActionType at = this.chessImplementor.move(xInit, yInit, xFinal,
				yFinal, colorCurrentPlayer);

		if (at != ActionType.UNKNOWN && at != ActionType.ILLEGAL) {
			colorCurrentPlayer = colorCurrentPlayer == Couleur.BLANC ? Couleur.NOIR
					: Couleur.BLANC;
		}

		return at;

	}

	@Override
	public boolean pawnPromotion(int x, int y, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		return "[ " + "colorCurrentPlayer: " + this.colorCurrentPlayer + ","
				+ "chessImplementor: " + this.chessImplementor + ']';
	}

}
