package model.piece;

import java.util.List;

import tools.BoardGameConfig;
import tools.data.Coord;
import tools.data.Couleur;

public class Tour extends AbstractPiece {

	public Tour(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		return deltaX == 0 ^ deltaY == 0;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		return this.computeMoveItinerary(xFinal, yFinal);
	}

}
