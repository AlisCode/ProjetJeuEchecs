package model.piece;

import java.util.ArrayList;
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
		int limitMove = this.hasFirstMoved ? 1 : 2;
		int coeffMove = this.getCouleur() == Couleur.NOIR ? -1 : 1;
		switch (action) {
		case MOVE:
			return deltaX == 0
					&& MathHelper.isBetween(limitMove * coeffMove, 0, deltaY);
		case TAKE:
			return Math.abs(deltaX) == 1
					&& MathHelper.isBetween(coeffMove, 0, deltaY);
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

	@Override
	public ActionType doMove(int xFinal, int yFinal) {
		ActionType at = super.doMove(xFinal, yFinal);
		this.hasFirstMoved = true;
		return at;
	}

	// tests unitaires
	public static void main(String[] args) {
		Pion p = new Pion(Couleur.BLANC, new Coord(2, 1));

		List<Boolean> tests = new ArrayList<>();

		for (int y = 1; y <= 10; y++) {
			for (int x = 1; x <= 10; x++) {
				tests.add(p.isAlgoMoveOk(x, y, ActionType.MOVE)
						|| p.isAlgoMoveOk(x, y, ActionType.TAKE));
			}
		}

		int count = 0;
		for (Boolean b : tests) {
			if (b) {
				count++;
			}
		}

		System.out.println("count : " + count);

		tests.clear();
	}
}
