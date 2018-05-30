package model;

import java.util.List;
import java.util.Observable;

import model.business.ChessGameModel;
import model.business.ChessModel;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import tools.data.MessageModelToGUI;

/**
 * @author francoise.perrin
 * 
 *         Cette classe est fortement couplée à un Echiquier qu'elle crée Elle
 *         le rend Observable et en simplifie l'interface (DP Proxy, Facade,
 *         Observer)
 *
 */
public class ChessModelObs extends Observable implements ChessGameModel {

	private ChessGameModel chessGameModel;

	/**
	 * Cree une instance de la classe Echiquier et notifie ses observateurs
	 */
	public ChessModelObs() {
		super();
		this.chessGameModel = new ChessModel();
	}

	@Override
	public String toString() {
		String st = "";
		st = chessGameModel.toString();
		return st;
	}

	@Override
	public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {

		ActionType ret = ActionType.UNKNOWN;
		Couleur couleur = chessGameModel.getPieceColor(xInit, yInit);
		ret = this.chessGameModel.move(xInit, yInit, xFinal, yFinal);
		this.notifyObservers(new MessageModelToGUI(couleur, xInit, yInit,
				xFinal, yFinal, ret));
		return ret;
	}

	@Override
	public boolean isEnd() {
		return chessGameModel.isEnd();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return chessGameModel.getColorCurrentPlayer();
	}

	@Override
	public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
		return chessGameModel.getPieceListMoveOK(xInit, yInit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.business.BoardGamesModel#getPieceColor(int, int)
	 * 
	 * * Cette méthode ne pourra pas être invoquée par d'autres client que la
	 * classe BoardGame elle même
	 */
	@Override
	public Couleur getPieceColor(int x, int y) {
		try {
			throw new NoSuchMethodException();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean pawnPromotion(int x, int y, String promotionType) {
		boolean ret = false;
		ret = (chessGameModel).pawnPromotion(x, y, promotionType);
		if (ret) {
			this.notifyObservers(new MessageModelToGUI(getPieceColor(x, y), -1,
					-1, x, y, ActionType.PROMOTION));
		}
		return ret;
	}

	@Override
	public void notifyObservers(Object arg) {
		super.setChanged();
		super.notifyObservers(arg);
	}

}
