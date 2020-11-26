package com.mateusz.lebioda;

import com.mateusz.lebioda.model.Area;

public class Main {

    public static void main(String[] args) {
        Area area = new Area(4,4);
        System.out.println(area.toString());

        AreaBuilder areaBuilder = new AreaBuilder();

        areaBuilder.doDominoes(area);

        areaBuilder.getAreas().forEach( a -> System.out.println(a.toString()));

        System.out.println(areaBuilder.getAreas().size());

    }
}
