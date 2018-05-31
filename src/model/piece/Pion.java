package model.piece;

import java.util.List;

import tools.MathHelper;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public class Pion extends AbstractPiece {

	private boolean hasFirstMoved;

	public Pion(Couleur couleur, Coord coords) {
		super(couleur, coords);
		this.hasFirstMoved = false;
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType action) {

		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		boolean isMovingOnXAxis = Math.abs(deltaX) == 1;
		switch (action) {
		case MOVE:
			if (this.getCouleur() == Couleur.NOIR) {
				return !isMovingOnXAxis && deltaY < 0;
			}
			return !isMovingOnXAxis && deltaY > 0;
		case TAKE:
			if (this.getCouleur() == Couleur.NOIR) {
				return isMovingOnXAxis && deltaY < 0;
			}
			return isMovingOnXAxis && deltaY > 0;
		default:
			return false;
		}
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		return this.computeMoveItinerary(xFinal, yFinal);
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		return this.isAlgoMoveOk(xFinal, yFinal, ActionType.MOVE);
	}

}
