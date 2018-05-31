package model.piece;

import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Pion extends AbstractPiece {

	private boolean hasFirstMoved;

	public Pion(Couleur couleur, Coord coords) {
		super(couleur, coords);
		this.hasFirstMoved = false;
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {

		int deltaY = yFinal - this.getY();

		switch (this.getCouleur()) {
		case NOIR:
			return xFinal == this.getX() && this.hasFirstMoved ? deltaY == 1
					: (deltaY <= 2 && deltaY > 0);
		case BLANC:
			return xFinal == this.getX() && this.hasFirstMoved ? deltaY == -1
					: (deltaY >= -2 && deltaY < 0);
		default:
			break;
		}

		return false;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
	}

}
