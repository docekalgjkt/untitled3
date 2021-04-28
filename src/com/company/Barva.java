package com.company;

public class Barva {
    private  int startpole;
    private  int cilpole;
    private  int poradi;
    public int getporadi(){
        return poradi;
    }

    public int getStartpole() {
        return startpole;
    }

    public int getCilpole() {
        return cilpole;
    }

    private  boolean tah;
    public Barva(int start,int cil, int por){
        startpole = start;
        cilpole = cil;
        poradi = por;

    }



}
