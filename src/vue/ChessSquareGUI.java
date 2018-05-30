package vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import tools.data.Coord;

public class ChessSquareGUI extends JPanel {

	private Coord coords;
	private Color color;

	public ChessSquareGUI(Coord coords) {
		this.coords = coords;
		this.color = (coords.getX() + coords.getY()) % 2 == 1 ? Color.BLACK
				: Color.WHITE;

		this.setBackground(this.color);
		this.setLayout(new BorderLayout());
	}

}
