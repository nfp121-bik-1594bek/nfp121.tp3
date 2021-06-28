package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
          if (taille <= 0){
        taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<Object>();
        this.capacite = 0;
        // prevoir le cas <=0
        // a completer
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()){
            throw new PilePleineException();
        }else{
            this.stk.push(o);
        }
        // a completer
    }

    public Object depiler() throws PileVideException {
        Object result;
        if (estVide()){
            throw new PileVideException();
        }else{
             result = this.stk.pop();
        }
        return result;
    }

    public Object sommet() throws PileVideException {
        Object result;
        if (estVide()){
            throw new PileVideException();
        }else{
            result = this.stk.peek();
        }
        return result;
    }
    
     public int taille() {
        return this.stk.size();
    }
    
    public int capacite() {
        // a completer
        return this.capacite;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    
    
    public boolean estVide() {
        return taille() == 0;
    }

    public boolean estPleine() {
        return taille() == capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = this.stk.size(); i>=0;i--){
            s+=this.stk.get(i).toString();
            if(i>0){
                s+=",";
            }
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        Pile2 newPile = (Pile2)o;
        if (o instanceof Pile2) {
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


} // Pile2.java
