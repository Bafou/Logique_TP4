package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author WISSOCQ Sarah
 * @author PETIT Antoine
 *
 */
public class Non extends Formule{

	protected Formule f;
	
	public Non(Formule f){
		this.f=f;
	}
	
	public String toString() {
		return  "(¬"+f+")";
	}

	public Set variablesLibres() {
		HashSet res= new HashSet(this.f.variablesLibres());
		return res;
	}

	public Formule substitue(Substitution s) {
		return new Non(this.f.substitue(s));
	}

	protected Formule negation() { 
		return f; 
	}
	
	protected Formule entrerNegations() {
		return this.f.negation();
	}
	
		
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
