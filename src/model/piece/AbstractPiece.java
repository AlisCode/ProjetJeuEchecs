package model.piece;

import java.util.List;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public abstract class AbstractPiece implements Pieces {

	private Coord coords;
	private Coord lastCoords;
	private Couleur couleur;
	private String name;

	@Override
	public int getX() {
		return this.coords.getX();
	}

	@Override
	public int getY() {
		return this.coords.getY();
	}

	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public ActionType doMove(int xFinal, int yFinal) {
		this.lastCoords = this.coords;
		this.coords = new Coord(xFinal, yFinal);

		return ActionType.MOVE;
	}

	@Override
	public boolean catchPiece() {
		this.lastCoords = this.coords;
		this.coords = new Coord(-1, -1);
		return true;
	}

	@Override
	public boolean undoLastMove() {

		this.coords = this.lastCoords;
		return true;
	}

	@Override
	public boolean undoLastCatch() {

		this.coords = this.lastCoords;
		return true;
	}

	public String toString() {
		return "[x: " + this.getX() + ", y: " + this.getY() + ", nom: "
				+ this.getName() + "]";
	}

	@Override
	public abstract boolean isAlgoMoveOk(int xFinal, int yFinal);

	@Override
	/**
	 * Dans le cas général, ActionType est ignoré. Dans le cas du pion, la fonction est ré-implémentée
	 */
	public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
		return this.isAlgoMoveOk(xFinal, yFinal);
	}

	@Override
	public abstract List<Coord> getMoveItinerary(int xFinal, int yFinal);

	public AbstractPiece(Couleur couleur, Coord coords) {
		this.couleur = couleur;
		this.coords = coords;
		this.lastCoords = null;
		this.name = this.getClass().getSimpleName();
	}
}
