package com.item_inheritance;

import com.item.Item;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Public class for an inventaire using the TreeMap data structure
 *
 * @see java.util.TreeMap
 */
public class InventaireInheritedHT extends TreeMap<String, Item>{
    private int aPrixTotal;

    /**
     * InventaireInheritedHT instance constructor
     */
    public InventaireInheritedHT() {
        super(Comparator.reverseOrder());
        this.aPrixTotal = 0;
    }

    /**
     * Search the item value inside the treemap based on the key (name)
     *
     * @param nom the Item name
     * @return the {@code Item} instance if found or {@code null} if not found
     */
    public Item getItem(String nom) {
        return this.get(nom);
    }

    /**
     * Checks if an items exists inside the current inventaire treemap
     *
     * @param nom the name of the Item wanted
     * @return {@code true} if the Item is found otherwise {@code false}
     */
    public boolean contientItem(String nom) {
        return getItem(nom) != null;
    }

    /**
     * Adds an Item inside the inventaire treemap. Without the implementation of the @{@link Object#equals(Object)}
     * and @{@link Object#hashCode()} methods we could add multiple times the same Item inside the inventaire set
     *
     * @param nom  The name of the new Item to be created
     * @param prix The price of the new Item to be created
     */
    public void ajouterItem(String nom, int prix) {
        if (!containsKey(nom)) {
            put(nom, new Item(nom, prix));
            this.aPrixTotal += prix;
        }
    }

    /**
     * Removes an Item of the inventaire treemap
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
     * Adds a literal presentation of an InventaireInheratedHT
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder(
                this.values()
                        .stream()
                        .map(Item::toString)
                        .collect(Collectors.joining(","))
        );
        return bd.toString();
    }
}
