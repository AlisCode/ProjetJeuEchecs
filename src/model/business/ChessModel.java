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
		for (int x = 1; x <= BoardGameConfig.getNbColonne(); x++) {
			for (int y = 1; y <= BoardGameConfig.getNbLigne(); y++) {
				if (p.isAlgoMoveOk(x, y, ActionType.MOVE)
						|| p.isAlgoMoveOk(x, y, ActionType.TAKE)) {
					coords.add(new Coord(x, y));
				}
			}
		}
		return coords;
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
			List<Coord> list = p1.getMoveItinerary(xFinal, yFinal);

			for (Coord c : list) {
				if (this.chessImplementor.getPieceAtCoord(c.getX(), c.getY()) != null) {
					return ActionType.ILLEGAL;
				}
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

			return p1.doMove(xFinal, yFinal);
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
