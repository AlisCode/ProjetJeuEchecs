package model.business;

import java.util.ArrayList;
import java.util.List;

import model.ChessImplementor;
import model.piece.Pieces;
import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

public class ChessModel implements ChessGameModel {

	private Couleur colorCurrentPlayer;
	private ChessImplementor chessImplementor;

	public ChessModel() {
		super();
		this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
		this.chessImplementor = new ChessImplementor();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.colorCurrentPlayer;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		Pieces p = this.chessImplementor.getPieceAtCoord(x, y);
		if (p != null) {
			return p.getCouleur();
		}
		return null;
	}

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		// garde une liste de toutes les coord de déplacement possibles pour une pièce   
		Pieces p = this.chessImplementor.getPieceAtCoord(xInit, yInit);
		List<Coord> coords = new ArrayList();
		for (int x = 0; x < BoardGameConfig.getNbColonne(); x++) {
			for (int y = 0; y < BoardGameConfig.getNbLigne(); y++) {
				if (p.isAlgoMoveOk(x, y)) {
					coords.add(new Coord(x, y));
				}
			}
		}
		return coords;
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		Pieces p1 = this.chessImplementor.getPieceAtCoord(xInit, yInit);
		Pieces p2 = this.chessImplementor.getPieceAtCoord(xFinal, yFinal);
		
		if(p1 == null){
			return null;
		}
				
		if(p1.isAlgoMoveOk(xFinal, yFinal)){
			//Deplacement si la piece ne va pas sur une piece de même couleur & deplacement possible
			
			if(p2 != null && p1.getCouleur() != p2.getCouleur()){
				//suppression piece
				p2.catchPiece();
				System.out.println("Suppression piece" + p2.getName() + " " + p2.getCouleur() + "Par : " + p1.getName() + " " + p1.getCouleur() );
			}
			
			if(p1.doMove(xFinal, yFinal)==null)
				System.out.println("Erreur Déplacement");
			
			p1.doMove(xFinal, yFinal);
			System.out.println("Deplacement");
			return null;
		}
		return null;
	}

	@Override
	public boolean pawnPromotion(int x, int y, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		return "[ " + "colorCurrentPlayer: " + this.colorCurrentPlayer + ","
				+ "chessImplementor: " + this.chessImplementor + ']';
	}

}
