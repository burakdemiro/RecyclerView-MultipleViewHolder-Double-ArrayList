package com.burakdemir.multipleviewholder.Model;

import com.burakdemir.multipleviewholder.R;

import java.util.ArrayList;

public class Reklam {

    private int reklamResmi;
    private String reklamAdi;

    public int getReklamResmi() {
        return reklamResmi;
    }

    public void setReklamResmi(int reklamResmi) {
        this.reklamResmi = reklamResmi;
    }

    public String getReklamAdi() {
        return reklamAdi;
    }

    public void setReklamAdi(String reklamAdi) {
        this.reklamAdi = reklamAdi;
    }

    public static ArrayList<Reklam> getReklamlar() {

        ArrayList<Reklam> reklamList = new ArrayList<>();

        int[] resimler = {R.drawable.sahin};
        String[] reklamYazilari = {"HALİS MUHLİS TÜRK SUCUĞU"};

        for (int i = 0; i < resimler.length; i++) {

            Reklam reklam = new Reklam();

            reklam.setReklamResmi(resimler[i]);
            reklam.setReklamAdi(reklamYazilari[i]);

            reklamList.add(reklam);
        }

        return reklamList;
    }
}
