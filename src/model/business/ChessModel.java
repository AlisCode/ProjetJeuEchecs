package model.business;

import java.util.ArrayList;
import java.util.List;

import model.ChessImplementor;
import model.piece.Pieces;
import tools.BoardGameConfig;
import tools.MathHelper;
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
		// garde une liste de toutes les coord de déplacement possibles pour une
		// pièce
		Pieces p = this.chessImplementor.getPieceAtCoord(xInit, yInit);
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

	private boolean checkItineraryLegal(Pieces p, int xFinal, int yFinal) {

		List<Coord> list = p.getMoveItinerary(xFinal, yFinal);
		Pieces pFinal = this.chessImplementor.getPieceAtCoord(xFinal, yFinal);

		for (Coord c : list) {
			if (this.chessImplementor.getPieceAtCoord(c.getX(), c.getY()) != null) {
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

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces p1 = this.chessImplementor.getPieceAtCoord(xInit, yInit);
		Pieces p2 = this.chessImplementor.getPieceAtCoord(xFinal, yFinal);

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
					this.colorCurrentPlayer = this.colorCurrentPlayer == Couleur.BLANC ? Couleur.NOIR
							: Couleur.BLANC;
					return ActionType.TAKE;
				} else {
					return ActionType.ILLEGAL;
				}
			}

			ActionType at = p1.doMove(xFinal, yFinal);
			this.colorCurrentPlayer = this.colorCurrentPlayer == Couleur.BLANC ? Couleur.NOIR
					: Couleur.BLANC;
			return at;
		}
		return ActionType.ILLEGAL;
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
