package vue;

import java.awt.Component;
import java.awt.Container;
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
import tools.data.Couleur;
import tools.factory.ChessImageProvider;
import controler.ChessGameControlerModel;

public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ChessGameControlerModel chessGameControlerModel;
	private ChessPieceGUI pieceToMove;
	private Map<Coord, ChessSquareGUI> map;

	private ChessPieceGUI takenPiece;

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
				ChessSquareGUI square = new ChessSquareGUI(new Coord(y, x));
				this.add(square, JLayeredPane.DEFAULT_LAYER);
				map.put(square.getCoords(), square);
			}
		}
	}

	/**
	 * Récupère les coordonneés métiers en fonction de coordonnées X et Y
	 * données en px
	 * 
	 * @param x
	 *            en pixel, la coordonnée x à traduire
	 * @param y
	 *            en pixel, la coordonnée y à traduire
	 * @return Un objet Coord métier qui correspond aux positions données
	 */
	public Coord getCoordsOfEvent(int x, int y) {
		Component c = this.findComponentAt(x, y);

		if (c instanceof ChessSquareGUI) {
			return ((ChessSquareGUI) c).getCoords();
		} else {
			Component parent = c.getParent();
			return ((ChessSquareGUI) parent).getCoords();
		}
	}

	/**
	 * Récupère la couleur d'une pièce située aux coordonnées données
	 * 
	 * @param coords
	 *            Les coordonnées de la pièce qu'on recherche
	 * @return La couleur de la pièce, ou null si aucune pièce n'a été trouvée
	 */
	public Couleur getCouleurAtCoords(Coord coords) {
		ChessSquareGUI csg = map.get(coords);

		if (csg.getComponentCount() <= 0) {
			return null;
		}

		ChessPieceGUI cpg = (ChessPieceGUI) csg.getComponent(0);
		if (cpg != null) {
			return cpg.getColorPiece();
		}

		return null;
	}

	@Override
	public void setPieceToMove(Coord coord) {

		ChessSquareGUI csg = this.map.get(coord);
		this.pieceToMove = csg != null ? (ChessPieceGUI) csg.getComponent(0)
				: null;

	}

	@Override
	public void resetLight(List<Coord> coords, boolean isLight) {
		// TODO Auto-generated method stub

	}

	@Override
	public void movePiece(Coord targetCoord) {

		Component c = map.get(targetCoord);

		if (c instanceof ChessPieceGUI) {
			Container parent = c.getParent();
			this.takenPiece = (ChessPieceGUI) c;
			parent.removeAll();
			parent.add(this.pieceToMove);
		} else if (c instanceof ChessSquareGUI) {
			Container parent = (Container) c;
			parent.add(this.pieceToMove);
		}
	}

	@Override
	public void undoMovePiece(Coord pieceToMoveInitCoord) {

		ChessSquareGUI targetSquare = map.get(pieceToMoveInitCoord);
		targetSquare.add(this.pieceToMove);

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
