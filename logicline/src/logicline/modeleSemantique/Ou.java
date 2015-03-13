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
public class Ou extends Formule{

	protected Formule fg;
	protected Formule fd;
	
	public Ou(Formule f1,Formule f2){
		this.fg=f1;
		this.fd=f2;
	}
	
	public String toString() {
		String res = "(" + fg.toString() + " ∨ " + fd.toString() + ")";
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
		return new Ou(this.fg.substitue(s), this.fd.substitue(s));
	}
	
	protected Formule supprImplications() {
		return new Ou(this.fg.supprImplications(),this.fd.supprImplications());
	}

	protected Formule negation() { 
		return new Et(this.fg.negation(),this.fd.negation()); 
	}
	
	protected Formule entrerNegations() {
		return new Ou (this.fg.entrerNegations(),this.fd.entrerNegations());
	}
	
	protected Formule entrerDisjonctions() { 
		/*if ((this.fg.contientEt()) && (this.fd.contientEt())) 
			return this.fg.ougauche(this.fd).entrerDisjonctions();
		else */ if (this.fg.contientEt())
			return this.fg.ougauche(this.fd).entrerDisjonctions();
		else if (this.fd.contientEt())
			return this.fd.oudroite(this.fg).entrerDisjonctions();
		else 
			return new Ou(this.fg.entrerDisjonctions(),this.fd.entrerDisjonctions());
	}
	
	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
