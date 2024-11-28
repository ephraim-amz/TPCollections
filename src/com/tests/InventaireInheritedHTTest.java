package com.tests;

import com.item.Item;
import com.item_inheritance.InventaireInheritedH;
import com.item_inheritance.InventaireInheritedHT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the InventaireInheritedHT class
 */
class InventaireInheritedHTTest {
    private InventaireInheritedHT inventaireInheritedHT;
    private Item firstItem;
    private Item secondItem;
    private Item thirdItem;

    @BeforeEach
    void setUp() {
        inventaireInheritedHT = new InventaireInheritedHT();

        firstItem = new Item("firstItem", 25);
        secondItem = new Item("secondItem", 50);
        thirdItem = new Item("thirdItem", 100);

        inventaireInheritedHT.ajouterItem(firstItem.getaNom(), firstItem.getaPrix());
        inventaireInheritedHT.ajouterItem(secondItem.getaNom(), secondItem.getaPrix());
        inventaireInheritedHT.ajouterItem(thirdItem.getaNom(), thirdItem.getaPrix());
    }
    @Test
    void getItem() {
        assertAll(
                () -> assertNull(inventaireInheritedHT.getItem("nonExistingItem")),
                () -> assertInstanceOf(Item.class, inventaireInheritedHT.getItem(firstItem.getaNom())),
                () -> assertEquals(firstItem, inventaireInheritedHT.getItem(firstItem.getaNom()))
        );
    }

    @Test
    void contientItem() {
        assertAll(
                () -> assertFalse(inventaireInheritedHT.contientItem("nonExistingItem")),
                () -> assertTrue(inventaireInheritedHT.contientItem(firstItem.getaNom()))
        );

    }

    @Test
    void ajouterItem() {
        assertFalse(inventaireInheritedHT.contientItem("newItem"));
        inventaireInheritedHT.ajouterItem("newItem", 100);
        assertTrue(inventaireInheritedHT.contientItem("newItem"));
    }

    @Test
    void enleverItem() {
        int currentInventaire = inventaireInheritedHT.size();
        inventaireInheritedHT.enleverItem("secondItem");
        assertEquals(currentInventaire - 1, inventaireInheritedHT.size());
    }
}