package vue;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.data.Couleur;


@SuppressWarnings("serial")
public class ChessPieceGUI extends JLabel{
	
	//private ChessGameControler chessGameControler;
	@SuppressWarnings("unused")
	private Couleur colorPiece;
	private Image image;
	private ImageIcon imageIcon;
	private String nom;
	

	public ChessPieceGUI(Image image,Couleur colorPiece) {
		//this.chessGameControler = chessGameControler;
		this.image = image;
		this.colorPiece = colorPiece;
		//this.setOpaque(false);	// permet de superposer le dessin de la piece sur celle du carré
	}

	public ChessPieceGUI(Couleur couleur, String nom,ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.imageIcon = imageIcon;
		this.colorPiece = couleur;
	}

}
