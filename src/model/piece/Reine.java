package model.piece;

import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Reine extends AbstractPiece {

	public Reine(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		return (Math.abs(deltaX) == Math.abs(deltaY) && deltaX != 0)
				|| (deltaX == 0 ^ deltaY == 0);
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return this.computeMoveItinerary(xFinal, yFinal);
	}

}
