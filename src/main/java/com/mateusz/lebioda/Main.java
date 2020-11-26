package com.mateusz.lebioda;

import com.mateusz.lebioda.model.Area;

import java.time.LocalTime;


public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int x = 6;
        int y = 6;
        Area area = new Area(x,y);

        AreaBuilder areaBuilder = new AreaBuilder();

        areaBuilder.doDominoes(area);

        areaBuilder.getAreas().forEach( a -> System.out.println(a.toString()));


        System.out.println("Pole o wymiarach: " + x + " x " + y);
        System.out.println("Liczba dostępnych kombinacji: " + areaBuilder.getAreas().size());

        long generationTime = System.currentTimeMillis() - start;
        LocalTime time = LocalTime.ofSecondOfDay(generationTime/1000);
        System.out.println("Czas generowania: " + time.toString() + "s");

    }
}
