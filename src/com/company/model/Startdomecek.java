package com.company.model;
import java.util.*;
public class Startdomecek {

    public Barva barva;


    public List <Figurka> neaktivF = new ArrayList<>();

    public Startdomecek(Barva barva1 ,int Pocetfigurek){
        barva = barva1;
        for(int i = 0;i < Pocetfigurek;i++){
            neaktivF.add(new Figurka(barva));
        }
    }
    public Figurka nasaditFigurku() {
        Figurka nasazovanaFigurka = neaktivF.get(neaktivF.size() - 1);
        neaktivF.remove(neaktivF.size() - 1);
        return nasazovanaFigurka;
    }
    public void vratitFigurku(Figurka vracenaFigurka) {
        neaktivF.add(vracenaFigurka);
    }
    }



