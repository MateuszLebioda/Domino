package com.mateusz.lebioda;

import com.mateusz.lebioda.model.Area;
import com.mateusz.lebioda.service.AreaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;


public class Main {

    private static Logger logger = LoggerFactory.getLogger("DominoBuilder");

    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        initData(args);

        Area area = new Area(x, y);

        AreaBuilder areaBuilder = new AreaBuilder();

        areaBuilder.doDominoes(area);

        int index = 0;
        for (Area a : areaBuilder.getAreas()) {
            logger.info("{} \n{}", "Uklad numer: " + (++index), a);
        }

        logger.info("Pole o wgit bashymiarach: {} x {}", x, y);

        logger.info("Liczba dostępnych kombinacji: {}", areaBuilder.getAreas().size());

        long generationTime = System.currentTimeMillis() - start;
        LocalTime time = LocalTime.ofSecondOfDay(generationTime / 1000);
        logger.info("Czas generowania: {}s", time);

    }

    private static void initData(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-x")) {
                    x = Integer.parseInt(args[i + 1]);
                } else if (args[i].equals("-y")) {
                    y = Integer.parseInt(args[i + 1]);
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Niepoprawny format danych, należy podac liczbę!");
        }
    }
}
