package model.business;

import java.util.List;

import javax.swing.colorchooser.ColorChooserComponentFactory;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public class ChessModel implements ChessGameModel {
	
	private Couleur colorCurrentPlayer;
	
	public ChessModel() {
		super();
		this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.colorCurrentPlayer;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
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

}
