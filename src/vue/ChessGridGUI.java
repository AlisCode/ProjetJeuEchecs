package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLayeredPane;

import tools.BoardGameConfig;
import tools.data.Coord;

public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChessGridGUI() {
		super();
		
		GridLayout gridLayout = new GridLayout(BoardGameConfig.getNbLigne(), BoardGameConfig.getNbColonne());
		this.setLayout(gridLayout);

		this.setChessBoard();
	}
	
	public void setChessBoard() {
		
		for(int x = 0 ; x < BoardGameConfig.getNbLigne() ; x++) {
			for(int y = 0 ; y < BoardGameConfig.getNbColonne() ; y++) {
				this.add(new ChessSquareGUI(
						new Coord(x,y)
				), JLayeredPane.DEFAULT_LAYER);
			}
		}
	}

	@Override
	public void setPieceToMove(Coord coord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetLight(List<Coord> coords, boolean isLight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePiece(Coord targetCoord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undoMovePiece(Coord pieceToMoveInitCoord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPromotionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void promotePiece(Coord coord, String promotionType) {
		// TODO Auto-generated method stub
		
	}

}
