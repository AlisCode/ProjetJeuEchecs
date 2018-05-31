package model.piece;

import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Fou extends AbstractPiece {

	public Fou(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		return Math.abs(deltaX) == Math.abs(deltaY) && deltaX != 0;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
	}

}
