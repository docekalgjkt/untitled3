package com.company.model;

import java.util.Random;

public class Kostka {

    private Random random;

    private int pocetSten;

    public Kostka(int strany){
        pocetSten = strany;
    }
    public int hod() {
        return random.nextInt(pocetSten)+1;
    }
}0;