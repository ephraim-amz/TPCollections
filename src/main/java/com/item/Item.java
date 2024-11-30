package com.item;

import java.util.Objects;

/**
 * Public class item that implements the Comparable interface for another item
 *
 * @author ephraim
 * @see java.lang.Comparable
 */
public class Item implements Comparable<Item> {
    private String aNom;
    private int aPrix;

    /**
     * Item instance constructor
     *
     * @param aNom The item name
     * @param aPrix The item price
     */
    public Item(String aNom, int aPrix) {
        this.aNom = aNom;
        this.aPrix = aPrix;
    }

    /**
     * Getter for aNom attribute
     *
     * @return String : aNom
     */
    public String getaNom() {
        return aNom;
    }

    /**
     * Setter for aNom attribute
     *
     * @param aNom The name
     */
    public void setaNom(String aNom) {
        this.aNom = aNom;
    }

    /**
     * Getter for aPrix attribute
     *
     * @return String : aNom
     */
    public int getaPrix() {
        return aPrix;
    }

    /**
     * Setter for aNom attribute
     *
     * @param aPrix The price
     */
    public void setaPrix(int aPrix) {
        this.aPrix = aPrix;
    }

    /**
     * Overwriting of the equals method from the Object class to indicate if one Item is equals to another supposed item
     *
     * @param o the object we want to compare with the current item instance
     * @return true if the item is the same as the o argument; false otherwise
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return aPrix == item.aPrix && Objects.equals(aNom, item.aNom);
    }

    /**
     * Overwriting of the hashCode method from the Object class
     *
     * @return integer number representing the hash value of the values used
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(aNom, aPrix);
    }

    /**
     * Adds a literal presentation of an Item
     *
     * @return the instance represented as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return String.format("(%s, %d)", aNom, aPrix);
    }


    /**
     * Compares an item object with the specified object for order
     *
     * @param o the object to be compared.
     * @return -1, 0 or 1 if the object is inferior, equals or greater than the specified object
     * @throws NullPointerException if the object is null
     * @throws ClassCastException if the object cannot be cast as an Item instance
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(Item o) {
        Integer p = this.aPrix;
        if (p.compareTo(o.aPrix) != 0) {
            return p.compareTo(o.aPrix);
        } else {
            return this.aNom.compareTo(o.aNom);
        }
    }
}
