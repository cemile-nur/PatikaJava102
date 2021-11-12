package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Teams> teamList = new ArrayList<>();
        teamList.add(new Teams("Fenerbahçe",0, 0, 0, 0));
        teamList.add(new Teams("Galatasaray",0, 0, 0, 0));
        teamList.add(new Teams("Beşiktaş",0, 0, 0, 0));
        teamList.add(new Teams("Bursaspor",0, 0, 0, 0));
        teamList.add(new Teams("Trabzonspor",0, 0, 0, 0));
        teamList.add(new Teams("Başakşehir",0, 0, 0, 0));

        System.out.println("ÇİFT TAKIM SENARYOSU");
        System.out.println("-------------------------------------------");
        Fikstur fikstur = new Fikstur(teamList);
        fikstur.fiksturCek();
        fikstur.fiksturPrint();

        System.out.println("TEK TAKIM SENARYOSU");
        System.out.println("-------------------------------------------");
        teamList.add(new Teams("Altay",0, 0, 0, 0));
        teamList.add(new Teams("Bay",0, 0, 0, 0));
        Fikstur fikstur2 = new Fikstur(teamList);
        fikstur2.fiksturCek();
        fikstur2.fiksturPrint();
    }
}
