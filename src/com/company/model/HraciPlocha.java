package com.company.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HraciPlocha {
    private Map<Barva, Startdomecek > domecky = new HashMap<>();
    private Map<Barva, CilDomecek > cile;
    private Map<Integer, Figurka> plocha;
    private List<Barva> hraci;
    private Barva hracnatahu;

    private  int pocetF;
    private  int pocetH;

    public HraciPlocha(int vel, int pocFig, int pocetHracu) {
        plocha = new HashMap<>(vel);
        pocetF = pocFig;
        pocetH = pocetHracu;

        for(int i = 0; i < pocetHracu; i++) {
            Barva novyHrac = new Barva(i,0,0);

            hraci.add(novyHrac);

            domecky.put(novyHrac, new Startdomecek (novyHrac, pocetF));
            cile.put(novyHrac, new CilDomecek (novyHrac, pocetF));
        }
    }

        private void posunFigurky(Figurka jaka, int odkud, int kam) {
            if(!cile.get(hracnatahu).getCil().containsValue(jaka)) {
                if(Volno(Cesta(kam))) {
                    plocha.put(Cesta(kam), jaka);
                    plocha.remove(odkud);
                }
                else if(plocha.get(Cesta(kam)).getBarva() != hracnatahu) {
                    vyhodit(Cesta(kam));
                    plocha.put(Cesta(kam), jaka);
                }
                else if(kam > hracnatahu.getCilpole()) {
                    int kamDoCile = kam - hracnatahu.getCilpole() + 1;
                    if(cile.get(hracnatahu).Volno(kamDoCile)) {
                        cile.get(hracnatahu).DoDomecku(jaka, kamDoCile);
                    }
                }
            }

        }
    private void nasaditFigurku() {
        if(Volno(hracnatahu.getStartpole())) {
            plocha.put(hracnatahu.getStartpole(), domecky.get(hracnatahu).nasaditFigurku());
        }
        else if(plocha.get(hracnatahu.getStartpole()).getBarva() != hracnatahu) {
            vyhodit(hracnatahu.getStartpole());
            plocha.put(hracnatahu.getStartpole(), domecky.get(hracnatahu).nasaditFigurku());
        }
    }
    private void vyhodit(int kde) {
        Barva koho = plocha.get(kde).getBarva();
        domecky.get(koho).vratitFigurku(plocha.get(kde));
        plocha.remove(kde);
    }


    void konecTahu() {
        int dalsihrac = hracnatahu.getporadi()+1;
        hracnatahu = hraci.get(dalsihrac);
    }

    private boolean Volno(int kde) {
        return plocha.get(kde) == null;
    }

    void konecHry() {

    }
    private int Cesta(int kam) {
        if(kam > 40) {
            return 40 - kam;
        }
        else {
            return kam;
        }
    }
}
