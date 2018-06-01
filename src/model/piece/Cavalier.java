package model.piece;

import java.util.ArrayList;
import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Cavalier extends AbstractPiece {

	public Cavalier(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		int hamiltonianDistance = Math.abs(deltaX) + Math.abs(deltaY);
		return hamiltonianDistance == 3 && deltaX != 0 && deltaY != 0;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		return new ArrayList<Coord>();
	}

}
