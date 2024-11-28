package com.tests;

import com.item.Item;
import com.item_inheritance.InventaireInheritedH;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireInheritedHTest {
    private InventaireInheritedH inventaireInheritedH;

    private Item firstItem;
    private Item secondItem;
    private Item thirdItem;

    @BeforeEach
    void setUp() {
        inventaireInheritedH = new InventaireInheritedH();

        firstItem = new Item("firstItem", 25);
        secondItem = new Item("secondItem", 50);
        thirdItem = new Item("thirdItem", 100);

        inventaireInheritedH.ajouterItem(firstItem.getaNom(), firstItem.getaPrix());
        inventaireInheritedH.ajouterItem(secondItem.getaNom(), secondItem.getaPrix());
        inventaireInheritedH.ajouterItem(thirdItem.getaNom(), thirdItem.getaPrix());
    }

    /**
     * Test case for getItem method
     */
    @Test
    void getItem() {
        assertAll(
                () -> assertEquals(inventaireInheritedH.get(firstItem.getaNom()), inventaireInheritedH.getItem(firstItem.getaNom())),
                () -> assertNull(inventaireInheritedH.getItem("nonExistingItem"))
        );
    }

    /**
     * Test case for contientItem method
     */
    @Test
    void contientItem() {
        assertAll(
                () -> assertTrue(inventaireInheritedH.contientItem(firstItem.getaNom())),
                () -> assertFalse(inventaireInheritedH.contientItem("nonExistingItem"))
        );
    }

    @Test
    void ajouterItem() {
        assertFalse(inventaireInheritedH.contientItem("newItem"));
        inventaireInheritedH.ajouterItem("newItem", 100);
        assertTrue(inventaireInheritedH.contientItem("newItem"));
    }

    @Test
    void enleverItem() {
        int currentInventaire = inventaireInheritedH.size();
        inventaireInheritedH.enleverItem("secondItem");
        assertEquals(currentInventaire - 1, inventaireInheritedH.size());
    }
}