package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author WISSOCQ Sarah
 * @author PETIT Antoine
 *
 */
public class Variable extends Formule {

	protected String var;

	public Variable(String var) {
		this.var = var;
	}

	public String toString() {
		return "("+this.var + ")";
	}

	public Set variablesLibres() {
		HashSet res= new HashSet();
		res.add(this.var);
		return res;
	}

	public Formule substitue(Substitution s) {
		if (s.get(var) != null) 
			return s.get(var);
		else return this;
	}
	

	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
