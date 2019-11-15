package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class GildedRoseApprovalTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream out;

    @BeforeEach
    public void setUp() {
        out = System.out;    // remplacer la sortie console par ecriture dans un fichier de log
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(out);
    }

    @Test
    void approve_operations_on_2_days() {
        TexttestFixture.main(new String[0]);
        System.out.flush();
        Approvals.verify(output.toString());
    }


    @Test
    void default_product() {
        Item[] items = new Item[]{
                new Item("default",2,50),
                new Item ("default",2,0),
                new Item("default",2,10),
                new Item ("default",0,10),
                new Item("default",-1,10),
        };
        new GildedRose(items).updateQuality();
        Approvals.verify(Arrays.deepToString(items));
    }

    @Test
    void backstagepasses_to_a_TAFKAL80ETC_concert() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert",2,50),
                new Item("Backstage passes to a TAFKAL80ETC concert",2,40),
                new Item ("Backstage passes to a TAFKAL80ETC concert",2,0),
                new Item("Backstage passes to a TAFKAL80ETC concert",2,10),
                new Item("Backstage passes to a TAFKAL80ETC concert",1,10),
                new Item ("Backstage passes to a TAFKAL80ETC concert",0,10),
                new Item("Backstage passes to a TAFKAL80ETC concert",-1,10),
        };
        new GildedRose(items).updateQuality();
        Approvals.verify(Arrays.deepToString(items));
    }

    @Test
    void aged_brie() {
        Item[] items = new Item[]{
                new Item("Aged Brie",2,50),
                new Item("Aged Brie",2,40),
                new Item ("Aged Brie",2,0),
                new Item("Aged Brie",2,10),
                new Item("Aged Brie",1,10),
                new Item ("Aged Brie",0,10),
                new Item("Aged Brie",-1,10),
        };
        new GildedRose(items).updateQuality();
        Approvals.verify(Arrays.deepToString(items));
    }

    @Test
    void sulfuras_hand_of_ragnaros() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros",100,50),
                new Item("Sulfuras, Hand of Ragnaros",2,40),
                new Item ("Sulfuras, Hand of Ragnaros",2,0),
                new Item("Sulfuras, Hand of Ragnaros",2,10),
                new Item("Sulfuras, Hand of Ragnaros",1,10),
                new Item ("Sulfuras, Hand of Ragnaros",0,10),
                new Item("Sulfuras, Hand of Ragnaros",-1,10),
                new Item("Sulfuras, Hand of Ragnaros",-1,-1)
        };
        new GildedRose(items).updateQuality();
        Approvals.verify(Arrays.deepToString(items));
    }
}
