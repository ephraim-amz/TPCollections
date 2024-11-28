package com.item_inheritance;

import com.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Public class for an inventaire, a class that uses the Item class for collection operations purposes
 *
 * @author ephraim
 */
public class InventaireInherited extends ArrayList<Item> {
    private int aPrixTotal;

    /**
     * InventaireInherited instance constructor
     */
    public InventaireInherited() {
        this.aPrixTotal = 0;
    }

    /**
     * Search an item inside the inventaire list based on its name
     *
     * @param nom the Item name
     * @return the {@code Item} instance if found or {@code null} if not found
     */
    public Item getItem(String nom) {
        return this
                .stream()
                .filter(i -> i.getaNom().equals(nom))
                .findFirst().orElse(null);
    }

    /**
     * Checks if an items exists inside the current inventaire list
     *
     * @param nom the name of the Item wanted
     * @return {@code true} if the Item is found otherwise {@code false}
     */
    public boolean contientItem(String nom) {
        return getItem(nom) != null;
    }

    /**
     * Adds an Item inside the inventaire list
     *
     * @param nom  The name of the new Item to be created
     * @param prix The price of the new Item to be created
     */
    public void ajouterItem(String nom, int prix) {
        if (!contientItem(nom)) {
            add(new Item(nom, prix));
            aPrixTotal += prix;
        }
    }

    /**
     * Removes an Item of the inventaire list
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
     * Sorts in ascending order the current list of items
     */
    public void trieC() {
        Collections.sort(this);
    }

    /**
     * Sorts in reverse order the current list of items
     */
    public void trieD() {
        this.sort(Collections.reverseOrder());
    }


    /**
     *
     */
    public int getAPrixTotal() {
        this.aPrixTotal = this.stream().mapToInt(Item::getaPrix).sum();
        return this.aPrixTotal;
    }

    /**
     * Adds a literal presentation of an InventaireInherited
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.stream()
                .map(Item::toString)
                .collect(Collectors.joining(" , ")));
        return String.format("%s : %d", sb, getAPrixTotal());
    }
}
