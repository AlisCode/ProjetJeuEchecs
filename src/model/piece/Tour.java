package model.piece;

import java.util.List;

import tools.data.Coord;
import tools.data.Couleur;

public class Tour extends AbstractPiece {

	public Tour(Couleur couleur, Coord coords) {
		super(couleur, coords);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAlgoMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		if((this.getX()-xFinal)==0 || (this.getY()-yFinal)==0){
			return true;
		}
		return false;
	}

	@Override
	public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return null;
	}

}
