package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille <= 0){
        taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
        // traiter le cas <=0
        // a completer
    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()){
            throw new PilePleineException();
        }else{
            this.zone[this.ptr] = o;
            ptr++;
        }
        
        
    }

    public Object depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }else{
            this.ptr--;
        return zone[ptr];
        }
        
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return zone[0];
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        if (estVide()){
            return 0;
        }else if(estPleine()){//Dans le cas elle est pleine
            return zone.length;
        }else{//Dans le cas elle n'est pas pleine
            return this.ptr;
        }
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }
    
     public int hashCode() {
        return toString().hashCode();
    }
    
    public boolean equals(Object o) {
        PileI newPile = (PileI)o;
        if (o instanceof PileI) {
            boolean check = this.capacite() == newPile.capacite() && this.hashCode() == newPile.hashCode();
            return check;
        }else{
            return false;
        }
    }

    // fonction fournie
   
    @Override
   public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}