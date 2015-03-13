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
public class Equivalence extends Formule{
	
	protected Formule fg;
	protected Formule fd;
	
	public Equivalence(Formule f1,Formule f2){
		this.fg=f1;
		this.fd=f2;
	}

	public String toString() {
		String res = "(" + fg.toString() + "⇔" + fd.toString() + ")";
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
	
	protected Formule supprImplications() {
		return new Et((new Ou(new Non(this.fg.supprImplications()),this.fd.supprImplications())),(new Ou(this.fg.supprImplications(),new Non(this.fd.supprImplications()))));  
	}


	public Formule substitue(Substitution s) {
		return new Equivalence(this.fg.substitue(s), this.fd.substitue(s));
	}

	public boolean valeur() throws VariableLibreException {
		// TODO Auto-generated method stub
		return false;
	}

}
