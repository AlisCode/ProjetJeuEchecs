package vue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import tools.data.Couleur;

@SuppressWarnings("serial")
public class ChessPieceGUI extends JLabel {

	private Couleur colorPiece;
	private String nom;

	public ChessPieceGUI(Couleur couleur, String nom, ImageIcon imageIcon) {
		super();
		this.nom = nom;
		this.colorPiece = couleur;
		this.setIcon(imageIcon);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public Couleur getColorPiece() {
		return colorPiece;
	}

	public String getNom() {
		return nom;
	}

}
