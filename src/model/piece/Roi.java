package model.piece;

import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Roi extends AbstractPiece {

	public Roi(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		
		int deltaX = this.getX() - xFinal;
		int deltaY = this.getY() - yFinal;
		
		int delta = Math.abs(deltaX) +Math.abs(deltaY);
		
		return ((deltaX == 0 ^ deltaY == 0 && (delta==1) )
				|| (Math.abs(deltaX) == Math.abs(deltaY) && delta==2));
		
		
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
	}

}
