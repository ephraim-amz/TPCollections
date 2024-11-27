package com.item_inheritance;

import com.item.Item;

import java.util.HashSet;

/**
 * Public class for an inventaire, a class that uses the Item class for HashSet collection operations
 * @author ephraim
 */
public class InventaireInheritedS extends HashSet<Item> {
    private int aPrixTotal;

    /**
     * InventaireInheritedS instance constructor
     *
     */
    public InventaireInheritedS() {
        this.aPrixTotal = 0;
    }

    /**
     * Search an item inside the inventaire set based on its name
     *
     * @param nom the Item name
     * @return the {@code Item} instance if found or {@code null} if not found
     */
    public Item getItem(String nom) {
        return this
                .stream()
                .filter(item-> item.getaNom().equals(nom))
                .findFirst().orElse(null);
    }

    /**
     * Checks if an items exists inside the current inventaire set
     *
     * @param nom the name of the Item wanted
     * @return {@code true} if the Item is found otherwise {@code false}
     */
    public boolean contientItem(String nom) {
        return getItem(nom) != null;
    }


    /**
     * Adds an Item inside the inventaire list. Without the implementation of the @{@link Object#equals(Object)}
     * and @{@link Object#hashCode()} methods we could add multiple times the same Item inside the inventaire set
     *
     * @param nom The name of the new Item to be created
     * @param prix The price of the new Item to be created
     */
    public void ajouterItem(String nom, int prix) {
        if (!contains(nom)) {
            if(add(new Item(nom, prix))){
                this.aPrixTotal += prix;
            };
        }
    }

    /**
     * Removes an Item of the inventaire set
     *
     * @param nom The name of the new Item to be deleted
     */
    public void enleverItem(String nom) {
        if (contientItem(nom)) {
            aPrixTotal -= getItem(nom).getaPrix();
            remove(getItem(nom));
        }
    }

    /**
     * Adds a literal presentation of an InventaireInheritedS
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s : %d", toString(), aPrixTotal);
    }
}
