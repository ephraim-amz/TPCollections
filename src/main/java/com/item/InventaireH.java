package com.item;

import java.util.HashMap;
import java.util.Map;

/**
 * Public class for an inventaire using the Map data structure
 */
public class InventaireH {
    private Map<String, Item> aListe;
    private int aPrixTotal;

    /**
     * InventaireH instance constructor
     *
     */
    public InventaireH() {
        this.aListe = new HashMap<>();
        this.aPrixTotal = 0;
    }

    /**
     * Search the item value inside the map the key (name)
     *
     * @param nom the Item name
     * @return the {@code Item} instance if found or {@code null} if not found
     */
    public Item getItem(String nom) {
        return this.aListe.get(nom);
    }

    /**
     * Checks if an items exists inside the current inventaire dictionnary
     *
     * @param nom the name of the Item wanted
     * @return {@code true} if the Item is found otherwise {@code false}
     */
    public boolean contientItem(String nom) {
        return getItem(nom) != null;
    }

    /**
     * Adds an Item inside the inventaire dictionnary. Without the implementation of the @{@link Object#equals(Object)}
     * and @{@link Object#hashCode()} methods we could add multiple times the same Item inside the inventaire set
     *
     * @param nom The name of the new Item to be created
     * @param prix The price of the new Item to be created
     */
    public void ajouterItem(String nom, int prix) {
        if (!aListe.containsKey(nom)) {
            aListe.put(nom, new Item(nom, prix));
            this.aPrixTotal += prix;

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
            aListe.remove(getItem(nom));
        }
    }

    /**
     * Adds a literal presentation of an InventaireS
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder();
        for (Item item : aListe.values()) {
            bd.append(item.toString() + ",");
        }
        bd.deleteCharAt(bd.length() - 1);
        return bd.toString();
    }
}
