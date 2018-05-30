package vue;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ChessGameControlerModel chessGameControlerModel;
	private Map<Coord, ChessSquareGUI> map;

	public ChessGridGUI(ChessGameControlerModel chessGameControlerModel) {
		super();
		this.chessGameControlerModel = chessGameControlerModel;

		GridLayout gridLayout = new GridLayout(BoardGameConfig.getNbLigne(),
				BoardGameConfig.getNbColonne());
		this.setLayout(gridLayout);

		// Initialisation du damier
		// "fond"
		this.setChessBoard();

		// Ajout des pièces
		this.setPieceChessGrid();

	}

	private void setPieceChessGrid() {

		JPanel square;
		// ///////////////////////////////////////////////////////////////////////
		// Ajout des images de pièces sur le damier en fonction de leur position
		// On suppose la création des ChessSquareGUI effectuée
		// ///////////////////////////////////////////////////////////////////////
		JLabel chessPieceGUI = null;
		int index;

		for (int i = 0; i < ChessPiecePos.values().length; i++) {
			for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
				// Fabrication de l'image de la pièce
				chessPieceGUI = new ChessPieceGUI(
						ChessPiecePos.values()[i].couleur,
						ChessPiecePos.values()[i].nom, new ImageIcon(
								ChessImageProvider.getImageFile(
										ChessPiecePos.values()[i].nom,
										ChessPiecePos.values()[i].couleur)));

				ChessPieceGUI cpg = (ChessPieceGUI) chessPieceGUI;

				// Ajout de l'image de piece sur le carre
				index = ChessPiecePos.values()[i].coords[j].getY()
						* BoardGameConfig.getNbLigne()
						+ ChessPiecePos.values()[i].coords[j].getX();
				square = (JPanel) this.getComponent(index);
				square.add(chessPieceGUI);

			}
		}

		// --------------

	}

	public void setChessBoard() {

		map = new HashMap<>();

		for (int x = 0; x < BoardGameConfig.getNbLigne(); x++) {
			for (int y = 0; y < BoardGameConfig.getNbColonne(); y++) {
				ChessSquareGUI square = new ChessSquareGUI(new Coord(x, y));
				this.add(square, JLayeredPane.DEFAULT_LAYER);
				map.put(square.getCoords(), square);
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
