package logicline.modeleSemantique;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author WISSOCQ Sarah
 * @author PETIT Antoine
 *
 */
public class Et extends Formule{

	protected Formule fg;
	protected Formule fd;
	
	public Et(Formule f1,Formule f2){
		this.fg=f1;
		this.fd=f2;
	}
	
	public String toString() {
		String res = "(" + fg.toString() + " ∧ " + fd.toString() + ")";
		return res;
	}

	public Set variablesLibres() {
		HashSet res= new HashSet(this.fg.variablesLibres());
		Set setd = this.fd.variablesLibres();
		Iterator it= setd.iterator();
		while (it.hasNext()) {
			res.add(it.next());
		}
		return res;
	}

	public Formule substitue(Substitution s) {
		return new Et(this.fg.substitue(s), this.fd.substitue(s));
	}
	
	protected Formule supprImplications() {
		return new Et(this.fg.supprImplications(),this.fd.supprImplications());
	}
	
	protected Formule negation() { 
		return new Ou(this.fg.negation(),this.fd.negation()); 
	}
	
	protected Formule entrerNegations() {
		return new Et(this.fg.entrerNegations(),this.fd.entrerNegations());
	}
	
	protected boolean contientEt() {
		return true;
	}

	protected Formule ougauche(Formule d) {
		return new Et( new Ou((this.fg),d),new Ou(this.fd,d));
	}
	
	protected Formule oudroite(Formule g) {
		return new Et( new Ou((this.fg),d),new Ou(this.fd,g));
	}
	
	protected Formule entrerDisjonctions() { 
		return new Et(this.fg.entrerDisjonctions(),this.fd.entrerDisjonctions());
	}
	
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
