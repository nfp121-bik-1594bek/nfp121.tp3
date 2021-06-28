package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille<=0){
            taille = PileI.CAPACITE_PAR_DEFAUT;
            this.v = new Vector<Object>(taille);
        }
        // traiter le cas <=0
        // à compléter
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()){
            throw new PilePleineException();
        }else{
            this.v.addElement(o);
        }
    }

    public Object depiler() throws PileVideException {
        Object result;
        if (estVide()){
            throw new PileVideException();
        }else {
            result = this.v.remove(this.taille()-1);
        }
        return result;
    }

    public Object sommet() throws PileVideException {
        Object last;
        if (estVide()){
            throw new PileVideException();
        }else{
            last = this.v.lastElement();
        }
        return last;
    }

    public int taille() {
        // à compléter
        return this.v.size();
    }

    public int capacite() {
        return this.v.capacity();
    }

    public boolean estVide() {
        return this.taille() == 0;
    }

    public boolean estPleine() {
        // à compléter
        return this.taille() == this.capacite();
        
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = this.v.size() - 1; i >= 0; i--) {
            sb.append(this.v.get(i).toString());
            if (i > 0)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
    

    public boolean equals(Object o) {
        Pile3 newPile = (Pile3)o;
        if (o instanceof Pile3) {
            boolean check = this.capacite() == newPile.capacite() && this.hashCode() == newPile.hashCode() && this.taille() == newPile.taille();
            return check;
        }else{
            return false;
        }

    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
