package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author WISSOCQ Sarah
 * @author PETIT Antoine
 *
 */
public class Constante extends Formule {

	protected boolean cons;

	public Constante(boolean cons) {
		this.cons = cons;
	}

	public String toString() {
		if (this.cons)
			return "T";
		else
			return "⊥";
	}

	public Set variablesLibres() {
		HashSet res= new HashSet();
		return res;
	}

	public Formule substitue(Substitution s) {
		return this;
	}

	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
