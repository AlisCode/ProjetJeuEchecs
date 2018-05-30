package vue;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tools.BoardGameConfig;
import tools.data.ChessPiecePos;
import tools.data.Coord;
import tools.factory.ChessImageProvider;
import controler.ChessGameControlerModel;

public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {

	private ChessGameControlerModel chessGameControlerModel;


	//private JPanel selectedPieceGUI;

	public ChessGridGUI(ChessGameControlerModel chessGameControlerModel) {
		super();
		this.chessGameControlerModel = chessGameControlerModel;

		//this.selectedPieceGUI = null;

		// initialisation du damier
		//this.setBackGroudCheckersBoard();
		this.setPieceChessGrid();

	}
	private void setPieceChessGrid() {
		// TODO Auto-generated method stub
		//--------------
		JPanel square;
		/////////////////////////////////////////////////////////////////////////
		// Ajout des images de pièces sur le damier en fonction de leur position 
		// On suppose la création des ChessSquareGUI effectuée
		/////////////////////////////////////////////////////////////////////////
		JLabel chessPieceGUI = null;
		int index;	

		for (int i = 0; i < ChessPiecePos.values().length; i++) {
			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
				// fabrication de l'image de la pièce
				chessPieceGUI = new ChessPieceGUI(
						ChessPiecePos.values()[i].couleur,
						ChessPiecePos.values()[i].nom,
						new ImageIcon(ChessImageProvider.getImageFile(
								ChessPiecePos.values()[i].nom,
								ChessPiecePos.values()[i].couleur)));
				// ajout de l'image de piece sur le carre
	index = ChessPiecePos.values()[i].coords[j].getY() * 8 +
	ChessPiecePos.values()[i].coords[j].getX();
				square = (JPanel) this.getComponent(index);
				square.add(chessPieceGUI);
			}
		}
		//--------------
		
	}
	
	
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
