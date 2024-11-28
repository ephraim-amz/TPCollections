package com.tests;

import com.item.Item;
import com.item_inheritance.InventaireInherited;
import com.item_inheritance.InventaireInheritedS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for InventaireInheritedS
 *
 * @author ephraim
 */
public class InventaireInheritedSTest {
    private InventaireInheritedS inventaireInheritedS;
    private Item firstItem;
    private Item secondItem;
    private Item thirdItem;

    /**
     * Set up method for variables used in each tests cases
     */
    @BeforeEach
    void setUp() {
        inventaireInheritedS = new InventaireInheritedS();

        firstItem = new Item("firstItem", 25);
        secondItem = new Item("secondItem", 50);
        thirdItem = new Item("thirdItem", 100);

        Item[] items = {firstItem, secondItem, thirdItem};
        inventaireInheritedS.addAll(Arrays.stream(items).toList());

    }


    /**
     * Test case for the getItem method
     */
    @Test
    void getItem() {
        assertAll(
                () -> assertInstanceOf(Item.class, inventaireInheritedS.getItem(firstItem.getaNom())),
                () -> assertNull(inventaireInheritedS.getItem("nonExistingItem")),
                () -> assertEquals(firstItem, inventaireInheritedS.getItem(firstItem.getaNom()))
        );
    }

    /**
     * Test case for the contientItem method
     */
    @Test
    void contientItem() {
        assertAll(
                () -> assertTrue(inventaireInheritedS.contientItem(firstItem.getaNom())),
                () -> assertFalse(inventaireInheritedS.contientItem("nonExistingItem"))
        );
    }

    /**
     * Test case for the ajouterItem method
     */
    @Test
    void ajouterItem() {
        inventaireInheritedS.ajouterItem(firstItem.getaNom(), firstItem.getaPrix());
        // Because inventaireInheritedS inherits from the HashSet class, we want to be sure that the same item cannot be added twice
        assertEquals(3, inventaireInheritedS.size());

    }

    /**
     * Test case for the enleverItem method
     */
    @Test
    void enleverItem() {
        inventaireInheritedS.enleverItem(firstItem.getaNom());
        assertFalse(inventaireInheritedS.contientItem(firstItem.getaNom()));
    }
}