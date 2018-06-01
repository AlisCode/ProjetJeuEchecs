package model;

import java.util.ArrayList;
import java.util.List;

import model.piece.Pieces;
import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
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

	private Pieces getPieceAtCoord(int x, int y) { // Renvoie la piece en
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

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		// garde une liste de toutes les coord de déplacement possibles pour une
		// pièce
		Pieces p = this.getPieceAtCoord(xInit, yInit);
		List<Coord> coords = new ArrayList<>();
		if (p != null) {
			for (int y = 0; y < BoardGameConfig.getNbLigne(); y++) {
				for (int x = 0; x < BoardGameConfig.getNbColonne(); x++) {
					if ((p.isAlgoMoveOk(x, y, ActionType.MOVE) || p
							.isAlgoMoveOk(x, y, ActionType.TAKE))
							&& checkItineraryLegal(p, x, y)) {
						coords.add(new Coord(x, y));
					}
				}
			}
		}
		return coords;

	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		Pieces p = this.getPieceAtCoord(x, y);
		if (p != null) {
			return p.getCouleur();
		}
		return null;
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal,
			Couleur colorCurrentPlayer) {
		Pieces p1 = this.getPieceAtCoord(xInit, yInit);
		Pieces p2 = this.getPieceAtCoord(xFinal, yFinal);

		if (p1 == null) {
			return ActionType.UNKNOWN;
		}

		if (p1.isAlgoMoveOk(
				xFinal,
				yFinal,
				p2 != null && p2.getCouleur() != p1.getCouleur() ? ActionType.TAKE
						: ActionType.MOVE)) {
			// Deplacement si la piece ne va pas sur une piece de même couleur &
			// deplacement possible

			// vérifie si on a une pièce sur le chemin. Si oui, le move est
			// illégal.
			if (!this.checkItineraryLegal(p1, xFinal, yFinal)) {
				return ActionType.ILLEGAL;
			}

			if (p2 != null) {

				if (p1.getCouleur() != p2.getCouleur()) {
					// suppression piece
					p2.catchPiece();
					p1.doMove(xFinal, yFinal);
					return ActionType.TAKE;
				} else {
					return ActionType.ILLEGAL;
				}
			}

			ActionType at = p1.doMove(xFinal, yFinal);

			return at;
		}
		return ActionType.ILLEGAL;

	}

	private boolean checkItineraryLegal(Pieces p, int xFinal, int yFinal) {

		List<Coord> list = p.getMoveItinerary(xFinal, yFinal);
		Pieces pFinal = this.getPieceAtCoord(xFinal, yFinal);

		for (Coord c : list) {
			if (this.getPieceAtCoord(c.getX(), c.getY()) != null) {
				return false;
			}
		}

		if (pFinal != null) {
			return p.isAlgoMoveOk(xFinal, yFinal, ActionType.TAKE)
					&& pFinal.getCouleur() != p.getCouleur();
		} else {
			return p.isAlgoMoveOk(xFinal, yFinal, ActionType.MOVE);
		}
	}

}
