package com.main;
import com.item.*;

/**
 * Application entry point
 * @author ephraim
 */
public class Main {
    public static void main(String[] args) {
        // Main.mainInventaire();
         Main.mainInventaireS();
        // Main.mainInventaireH();
//        Main.mainInventaireHT();
    }

    /**
     * Static method to be call in the main() method if trying to create an Inventaire
     */
    public static void mainInventaire() {
        Inventaire inventaire = new Inventaire();
        System.out.println(inventaire);

        inventaire.ajouterItem("First", 25);
        System.out.println(inventaire);
        Item x = new Item("First", 35);
        inventaire.ajouterItem(x.getaNom(), x.getaPrix());
        System.out.println(inventaire);

        Item y = new Item("Second", 23);
        inventaire.ajouterItem(y.getaNom(), y.getaPrix());
        System.out.println(inventaire);

        inventaire.enleverItem("Third");
        System.out.println(inventaire);

        inventaire.enleverItem(x.getaNom());
        System.out.println(inventaire);

        inventaire.enleverItem(y.getaNom());
        System.out.println(inventaire);

        inventaire.enleverItem(y.getaNom());
        System.out.println(inventaire);

        inventaire.trieC();
        System.out.println(inventaire);
    }

    /**
     * Static method to be call in the main() method if trying to create an InventaireS
     */
    public static void mainInventaireS() {
        InventaireS inventaireS = new InventaireS();
        System.out.println(inventaireS);
        inventaireS.ajouterItem("First", 25);
        inventaireS.ajouterItem("First", 25);
        System.out.println(inventaireS);
    }

    /**
     * Static method to be call in the main() method if trying to create an InventaireH
     */
    public static void mainInventaireH() {
        InventaireH inventaireH = new InventaireH();
        inventaireH.ajouterItem("First", 25);
        inventaireH.ajouterItem("Second", 25);
        System.out.println(inventaireH);
    }

    /**
     * Static method to be call in the main() method if trying to create an InventaireHT
     */
    public static void mainInventaireHT() {
        InventaireHT inventaireHT = new InventaireHT();
        inventaireHT.ajouterItem("First", 25);
        inventaireHT.ajouterItem("Second", 35);
        inventaireHT.ajouterItem("Third", 55);
        System.out.println(inventaireHT);

    }
}
