package com.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Public class for an inventaire, a class that uses the Item class for collection operations purposes
 * @author ephraim
 */
public class Inventaire {
    private List<Item> aListe;
    private int aPrixTotal;

    /**
     * Inventaire instance constructor
     *
     */
    public Inventaire() {
        this.aListe = new ArrayList<>();
        this.aPrixTotal = 0;
    }

    /**
     * Search an item inside the inventaire list based on its name
     *
     * @param nom the Item name
     * @return the {@code Item} instance if found or {@code null} if not found
     */
    public Item getItem(String nom){
        for (Item item : aListe) {
            if(item.getaNom().equals(nom)){
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if an items exists inside the current inventaire list
     *
     * @param nom the name of the Item wanted
     * @return {@code true} if the Item is found otherwise {@code false}
     */
    public boolean contientItem(String nom){
        return getItem(nom) != null;
    }

    /**
     * Adds an Item inside the inventaire list
     *
     * @param nom The name of the new Item to be created
     * @param prix The price of the new Item to be created
     */
    public void ajouterItem(String nom, int prix){
        if(!contientItem(nom)){
            aListe.add(new Item(nom, prix));
            aPrixTotal += prix;
        }
    }

    /**
     * Removes an Item of the inventaire list
     *
     * @param nom The name of the new Item to be deleted
     */
    public void enleverItem(String nom){
        if(contientItem(nom)){
            aPrixTotal -= getItem(nom).getaPrix();
            aListe.remove(getItem(nom));
        }
    }

    /**
     * Sorts in ascending order the current list of items
     */
    public void trieC(){
        Collections.sort(aListe);
    }

    /**
     * Sorts in reverse order the current list of items
     */
    public void trieD(){
        aListe.sort(Collections.reverseOrder());
    }

    /**
     * Adds a literal presentation of an Inventaire
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s : %d", aListe.toString(), aPrixTotal);
    }
}
