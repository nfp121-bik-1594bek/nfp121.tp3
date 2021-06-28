package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille<=0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
       if(estPleine()){
            throw new PilePleineException();
        }else{
            this.stk.push(o);
        }
        
    }

    public T depiler() throws PileVideException{
        // à compléter
         if (estVide()){
            throw new PileVideException();
        }else{
            return this.stk.pop();
        }
    }

    public T sommet() throws PileVideException{
        if (estVide()){
            throw new PileVideException();
            
        }else{
            return this.stk.peek();
        }
    }
    
     public int taille() {
        return this.stk.size();
    }
    
     public int capacite() {
        return this.capacite;
    }
    
     public int hashCode() {
        return toString().hashCode();
    }
    
    
    public boolean estVide(){
        return this.taille() == 0;

    }
    
    public boolean estPleine() {
        return this.taille() == this.capacite();
        
    }

    
    public boolean equals(Object o){
    Pile2 newPile = (Pile2)o;
        if (o instanceof Pile2) {
            boolean check = this.capacite() == newPile.capacite() && this.hashCode() == newPile.hashCode() && this.taille() == newPile.taille();
            return check;
        }else{
            return false;
        }
    }
    
    public String toString() {
        String result = "[";
        for (int i =this.stk.size()-1;i>=0;i--){
            result += this.stk.get(i).toString();
            if (i>0){
                result +=",";
            }
        }
        return result+"]";
    }
    
    
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2