package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import tools.data.Coord;

public class ChessSquareGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Coord coords;
	private Color color;

	public ChessSquareGUI(Coord coords) {
		this.coords = coords;
		this.color = (coords.getX() + coords.getY()) % 2 == 1 ? Color.BLACK
				: Color.WHITE;

		this.setBackground(this.color);
		this.setLayout(new BorderLayout());
	}

	public Coord getCoords() {
		return this.coords;
	}

	public String toString() {
		return "[x: " + this.coords.getX() + ",y: " + this.coords.getY()
				+ ", color:" + this.color + "]";
	}

	public void setLight(boolean light) {
		this.setBackground(light ? Color.GREEN : this.color);
		this.repaint();
	}

}
