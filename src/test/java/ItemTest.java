package com.tests;

import com.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Item class
 * @author ephraim
 */
 class ItemTest {
    private Item itemTest;

    /**
     * 
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        itemTest = new Item("test", 0);
    }

    @Test
    void testToString() {
        assertEquals( "(test, 0)", itemTest.toString());
        assertNotEquals( "(test,0)", itemTest.toString());
    }

    @Test
    void testGetANom() {
        assertEquals("test", itemTest.getaNom());
    }

    @Test
    void testSetANom() {
        itemTest.setaNom("setTest");
        assertNotEquals("test", itemTest.getaNom());
        assertEquals("setTest", itemTest.getaNom());
    }

    @Test
    void testGetAPrix(){
        assertEquals(0, itemTest.getaPrix());
    }

    @Test
    void testSetAPrix() {
        itemTest.setaPrix(10);
        assertNotEquals(0, itemTest.getaPrix());
        assertEquals(10, itemTest.getaPrix());
    }

    @Test
    void testEquals() {
        assertTrue(itemTest.equals(itemTest));
    }

    @Test
    void testHashCode() {
        assertEquals(new Item("test",0).hashCode(), itemTest.hashCode());
    }

    @Test
    void testCompareTo() {
        assertEquals(-1, itemTest.compareTo(new Item("test",1)));
        assertEquals(0, itemTest.compareTo(new Item("test",0)));
        assertEquals(1, itemTest.compareTo(new Item("test",-1)));
    }


}