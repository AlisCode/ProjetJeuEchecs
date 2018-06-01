package launcher.localLauncher;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.ChessModelObs;
import model.business.ChessGameModel;
import tools.BoardGameConfig;
import tools.data.Couleur;
import vue.ChessGUI;
import controler.ChessGameControlerModelVue;
import controler.controlerLocal.ChessControlerLocal;

/**
 * @author francoise.perrin Lance l'exécution d'un jeu d'échec en mode
 *         graphique. La vue (ChessGameGUI) observe le modèle (ChessGame) les
 *         échanges passent par le contrôleur (ChessGameControlers)
 * 
 */
public class LauncherChessGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChessGameModel chessGame;
		ChessGameControlerModelVue chessGameControler;
		JFrame frame;
		Dimension dim;

		BoardGameConfig.newInstance(8, // nb lignes
				8, // nb colonnes
				"ChessPiecesFactory", // nom fabrique pièces
				Couleur.BLANC, // couleur du joueur qui débute la partie
				new Color(139, 69, 0), // couleur des cases noires
				new Color(255, 250, 240), // couleur des cases blanches
				750); // taille du damier

		dim = new Dimension(1000, 800);

		chessGame = new ChessModelObs();
		chessGameControler = new ChessControlerLocal(chessGame);

		frame = new ChessGUI(chessGameControler);
		((Observable) chessGame).addObserver((Observer) frame);

		frame.setTitle("Jeu d'échec");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 10);
		frame.setPreferredSize(dim);
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);

	}
}
