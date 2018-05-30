package tools.data;

import java.io.Serializable;

/**
 * @author francoise.perrin
 * 
 *         Chaque fois qu'une action est effectuée sur le modèle, un message est
 *         envoyé à la vue qui le récupère dans sa méthode update()
 *
 */
public class MessageModelToGUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String coordInit, coordFinal;
	private ActionType actionType;
	private Couleur couleur;

	/**
	 * @param couleur
	 * @param coordInit
	 * @param coordFinal
	 * @param actionType
	 */
	public MessageModelToGUI(Couleur couleur, int xInit, int yInit, int xFinal,
			int yFinal, ActionType actionType) {

		// si pas de coord initiale = promotion pion : xinit = xfinal
		if (xInit != -1) {
			this.coordInit = "" + ((char) (xInit + 'A')) + (8 - yInit);
		} else {
			this.coordInit = "" + ((char) (xFinal + 'A')) + (8 - yFinal);
		}
		this.coordFinal = "" + ((char) (xFinal + 'A')) + (8 - yFinal);
		this.actionType = actionType;
		this.couleur = couleur;
	}

	/**
	 * @return the coordInit
	 */
	public String getCoordInit() {
		return coordInit;
	}

	/**
	 * @return the coordFinal
	 */
	public String getCoordFinal() {
		return coordFinal;
	}

	/**
	 * @return the actionType
	 */
	public ActionType getActionType() {
		return actionType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = couleur + " - " + coordInit + " -> " + coordFinal + " : "
				+ actionType;
		return st;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result
				+ ((coordFinal == null) ? 0 : coordFinal.hashCode());
		result = prime * result
				+ ((coordInit == null) ? 0 : coordInit.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageModelToGUI other = (MessageModelToGUI) obj;
		if (actionType != other.actionType)
			return false;
		if (coordFinal == null) {
			if (other.coordFinal != null)
				return false;
		} else if (!coordFinal.equals(other.coordFinal))
			return false;
		if (coordInit == null) {
			if (other.coordInit != null)
				return false;
		} else if (!coordInit.equals(other.coordInit))
			return false;
		return true;
	}

}
