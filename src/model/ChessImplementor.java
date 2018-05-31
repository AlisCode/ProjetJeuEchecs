package model;

import java.util.List;

import model.piece.Pieces;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

public class ChessImplementor implements ChessGameImplementor {

	private List<Pieces> piecesBlanches;
	private List<Pieces> piecesNoires;

	public ChessImplementor() {
		this.piecesBlanches = ChessPiecesFactory.newPieces(Couleur.BLANC);
		this.piecesNoires = ChessPiecesFactory.newPieces(Couleur.NOIR);
	}

	@Override
	public String toString() {
		return "ChessImplementor [piecesBlanches: " + piecesBlanches
				+ ", piecesNoires: " + piecesNoires + "]";
	}

	public Pieces getPieceAtCoord(int x, int y) { // Renvoie la piece en
													// fonction des coords
		for (Pieces p : this.piecesBlanches) {
			if (p.getX() == x && p.getY() == y) {
				return p;
			}
		}

		for (Pieces p : this.piecesNoires) {
			if (p.getX() == x && p.getY() == y) {
				return p;
			}
		}

		return null;
	}
}
