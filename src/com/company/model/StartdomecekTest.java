package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartdomecekTest {

    @Test
    void nasaditFigurku() {
        Barva red = new Barva(9,9,9);
        int pocetfig = 4;
        Startdomecek a = new Startdomecek(red,pocetfig);
        Figurka b = a.nasaditFigurku();
        assertEquals(red,b.getBarva());
        assertEquals(pocetfig-1,a.neaktivF.size());
    }
    ))
    @Test
    void vratitFigurku() {
    }
}