package com.tests;

import com.item.Item;
import com.item_inheritance.InventaireInherited;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for InventaireInherited class
 * @author ephraim
 */
class InventaireInheritedTest {
    private InventaireInherited inventaireInherited;
    private Item firstItem;
    private Item secondItem;
    private Item thirdItem;

    @BeforeEach
    void setUp() {
        inventaireInherited = new InventaireInherited();

        firstItem = new Item("firstItem", 25);
        secondItem = new Item("secondItem", 50);
        thirdItem = new Item("thirdItem", 100);


        inventaireInherited.add(secondItem);
        inventaireInherited.add(firstItem);
        inventaireInherited.add(thirdItem);


    }

    /**
     * Test case for the contientItem method
     */
    @Test
    void contientItem() {
        assertAll(
                () -> assertTrue(inventaireInherited.contientItem("firstItem")),
                () -> assertFalse(inventaireInherited.contientItem("nonExistingItem"))
        );
    }

    /**
     * Test case for the ajouterItem method
     */
    @Test
    void ajouterItem() {
        int currentSize = inventaireInherited.size();
        inventaireInherited.ajouterItem("fourthItem", 75);
        assertAll(
                () -> assertEquals(currentSize + 1, inventaireInherited.size()),
                () -> assertTrue(inventaireInherited.contientItem("fourthItem"))
        );

    }

    /**
     * Test case for remove item
     */
    @Test
    void enleverItem() {
        int currentSize = inventaireInherited.size();
        inventaireInherited.enleverItem("thirdItem");
        assertAll(
                () -> assertEquals(currentSize - 1, inventaireInherited.size()),
                () -> assertFalse(inventaireInherited.contientItem("thirdItem"))
        );
    }

    /**
     * Test case for ascending sort method trieC
     */
    @Test
    void trieC() {
        int mostExpensiveItem = inventaireInherited.stream().max(Item::compareTo).orElseThrow(NoSuchElementException::new).getaPrix();
        int leastExpensiveItem = inventaireInherited.stream().min(Item::compareTo).orElseThrow(NoSuchElementException::new).getaPrix();
        inventaireInherited.trieC();

        assertAll(
                () -> assertEquals(mostExpensiveItem, inventaireInherited.get(inventaireInherited.size()-1).getaPrix()),
                () -> assertTrue(inventaireInherited.get(1).getaPrix() > inventaireInherited.get(0).getaPrix()),
                () -> assertEquals(leastExpensiveItem, inventaireInherited.get(0).getaPrix())
        );
    }

    /**
     * Test case of reversal order method trieD
     */
    @Test
    void trieD() {
        int mostExpensiveItem = inventaireInherited.stream().max(Item::compareTo).orElseThrow(NoSuchElementException::new).getaPrix();
        int leastExpensiveItem = inventaireInherited.stream().min(Item::compareTo).orElseThrow(NoSuchElementException::new).getaPrix();

        inventaireInherited.trieD();

        assertAll(
                () -> assertEquals(leastExpensiveItem, inventaireInherited.get(inventaireInherited.size()-1).getaPrix()),
                () -> assertTrue(inventaireInherited.get(1).getaPrix() < inventaireInherited.get(0).getaPrix()),
                () -> assertEquals(mostExpensiveItem, inventaireInherited.get(0).getaPrix())
        );

    }

    /**
     * Test case for getAPrixTotal method
     */
    @Test
    void testGetAPrixTotal() {
        int itemSum = firstItem.getaPrix() + secondItem.getaPrix() + thirdItem.getaPrix();
        assertEquals(itemSum, inventaireInherited.getAPrixTotal());
    }
}