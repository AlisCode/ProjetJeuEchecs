package vue;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controler.ChessGameControlerModelVue;

public class ChessGridGUIListener implements MouseListener, MouseMotionListener {

	private ChessPieceGUI chessPiece;
	private ChessGameControlerModelVue chessGameControler;
	private ChessGridGUI chessGridGUI;

	private int xOffset;
	private int yOffset;

	public ChessGridGUIListener(ChessGridGUI chessGridGUI,
			ChessGameControlerModelVue chessGameControler) {

		this.chessGridGUI = chessGridGUI;
		this.chessPiece = null;
		this.chessGameControler = chessGameControler;

		this.xOffset = 0;
		this.yOffset = 0;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent ev) {
		// TODO Auto-generated method stub

		this.chessPiece = null;
		Component c = this.chessGridGUI.findComponentAt(ev.getX(), ev.getY());

		if (c instanceof JPanel)
			return;

		Point parentLocation = c.getParent().getLocation();
		this.xOffset = parentLocation.x - ev.getX();
		this.yOffset = parentLocation.y - ev.getY();

		this.chessPiece = (ChessPieceGUI) c;
		chessPiece.setLocation(ev.getX() + xOffset, ev.getY() + yOffset);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		chessGridGUI.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		// TODO Vérifier la légalité des mouvements (couche Model)
		if (this.chessPiece == null)
			return;

		this.chessPiece.setVisible(false);
		Component c = this.chessGridGUI.findComponentAt(ev.getX(), ev.getY());

		if (c instanceof ChessPieceGUI) {
			Container parent = c.getParent();
			parent.removeAll();
			parent.add(this.chessPiece);
		} else {
			Container parent = (Container) c;
			parent.add(this.chessPiece);
		}

		this.chessPiece.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		if (this.chessPiece == null)
			return;

		this.chessPiece.setLocation(ev.getX() + xOffset, ev.getY() + yOffset);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
