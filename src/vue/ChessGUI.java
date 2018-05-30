package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.data.MessageModelToGUI;
import controler.ChessGameControlerModelVue;

public class ChessGUI extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChessGridGUI chessGridGUI; // le damier est une extension de
										// JLayeredPane
	
	private ChessTextGUI execTrace; // affichage de la trace d'exécution dans un
									// JPanel

	public ChessGUI(ChessGameControlerModelVue chessGameControler) {
		super();
		Container contentPane = this.getContentPane();
		this.chessGridGUI = new ChessGridGUI();

		// /////////////////////////////////////////////////////
		// panel d'affichage de la trace d'exécution à droite
		// ////////////////////////////////////////////////////
		this.execTrace = new ChessTextGUI();
		contentPane.add(this.execTrace, BorderLayout.EAST);

		// /////////////////////////////////////////////////////////
		// panel d'affichage du damier et des légendes au centre
		// /////////////////////////////////////////////////////////

		// /////////////////////////////////////////////////////////
		// Affichage valeurs des colonnes A -> H en haut et en bas
		// /////////////////////////////////////////////////////////
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 8));
		for (char c = 'A'; c <= 'H'; c++) {
			JLabel label = new JLabel(String.valueOf(c));
			label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			top.add(label);
		}
		top.setBackground(Color.WHITE);
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 8));
		for (char c = 'A'; c <= 'H'; c++) {
			JLabel label = new JLabel(String.valueOf(c));
			label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			bottom.add(label);
		}
		bottom.setBackground(Color.WHITE);

		// ///////////////////////////////////////////////////////////
		// Affichage valeurs des lignes 8 -> 7 à droite et à gauche
		// ///////////////////////////////////////////////////////////
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(8, 1));
		for (char c = '8'; c >= '1'; c--) {
			JLabel label = new JLabel(" " + String.valueOf(c) + " ");
			label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
			west.add(label);
		}
		west.setBackground(Color.WHITE);
		JPanel east = new JPanel();
		east.setLayout(new GridLayout(8, 1));
		for (char c = '8'; c >= '1'; c--) {
			JLabel label = new JLabel(" " + String.valueOf(c) + " ");
			label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
			east.add(label);
		}
		east.setBackground(Color.WHITE);

		// //////////////////////////////////////////////////////
		// Affichage damier au centre
		// //////////////////////////////////////////////////////
		JPanel boardGameGUI = new JPanel(new BorderLayout());
		boardGameGUI.add(top, BorderLayout.NORTH);
		boardGameGUI.add(bottom, BorderLayout.SOUTH);
		boardGameGUI.add(west, BorderLayout.WEST);
		boardGameGUI.add(east, BorderLayout.EAST);

		boardGameGUI.add(this.chessGridGUI, BorderLayout.CENTER);
		contentPane.add(boardGameGUI, BorderLayout.CENTER);

		// ///////////////////////////////////////////////////////////
		// ajout des écouteurs sur le damier
		// l'objet EventListener écoute les évènement sur la vue,
		// les transmets au controler qui les transmets au model
		// ///////////////////////////////////////////////////////////
		EventListener mouseEventListener = new ChessGridGUIListener(
				this.chessGridGUI, chessGameControler);

		this.chessGridGUI.addMouseListener((MouseListener) mouseEventListener);
		this.chessGridGUI.addMouseMotionListener((MouseMotionListener) mouseEventListener);

		// ///////////////////////////////////////////////////////////////////////////
		// La vue indique au controleur à quel panel
		// il peut envoyer des messages en réaction aux réponses du model :
		// le controler invoquera des méthodes du damier pour qu'il se
		// rafraichisse
		// ///////////////////////////////////////////////////////////////////////////
		chessGameControler.setGridPanel(this.chessGridGUI);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * à chaque action dans le model, la vue récupère le message envoyé, le
	 * décode (version minimaliste implémentée ...) et l'affiche
	 */
	@Override
	public void update(Observable arg0, Object arg1) {

		MessageModelToGUI message = (MessageModelToGUI) arg1;
		execTrace.appendText(message + "\n");

	}
}
