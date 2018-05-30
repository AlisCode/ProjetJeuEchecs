package vue;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ChessTextGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea textArea;

	public ChessTextGUI() {
		this.textArea = new JTextArea();
		this.textArea.setEditable(true);
		this.textArea.append("\t Trace d'éxécution \n\n\n");
		this.setBackground(Color.WHITE);
		this.add(this.textArea);
	}
	
	public void appendText(String message) {
		// TODO Auto-generated method stub
		this.textArea.append(message);
		
		this.repaint();
		this.revalidate();
	}
	
}
