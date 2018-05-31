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

		int deltaY = yFinal - this.getY();
		int deltaX = xFinal - this.getX();
		boolean verticalMoveLegality = false;
		boolean takeMoveLegality = false;

		int coeffDelta = (this.getCouleur() == Couleur.NOIR ? 1 : -1);
		int deltaForwardOne = 1 * coeffDelta;
		int deltaForwardTwo = 2 * coeffDelta;

		switch (action) {
		case MOVE:
			verticalMoveLegality = xFinal == this.getX() && this.hasFirstMoved ? deltaY == deltaForwardOne
					: MathHelper.isBetween(deltaForwardTwo, 0, deltaY);
			break;
		case TAKE:
			takeMoveLegality = Math.abs(deltaX) == 1
					&& deltaY == deltaForwardOne;
			break;
		}

		return verticalMoveLegality || takeMoveLegality;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		return this.isAlgoMoveOk(xFinal, yFinal, ActionType.MOVE);
	}

}
