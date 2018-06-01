package model;

import java.util.List;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public interface ChessGameImplementor {

	public ActionType move(int xInit, int yInit, int xFinal, int yFinal,
			Couleur colorCurrentPlayer);

	public List<Coord> getPieceListMoveOK(int xInit, int yInit);

	public Couleur getPieceColor(int x, int y);

}
