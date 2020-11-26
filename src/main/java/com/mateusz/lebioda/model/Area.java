package com.mateusz.lebioda.model;

import lombok.Getter;

@Getter
public class Area {

    private String[][] points;
    private int width;
    private int height;

    public Area(int x, int y) {
        if (x % 2 == 0 && y % 2 == 0) {
            this.points = new String[x][y];
            this.width = x;
            this.height = y;
            while (x > 0) {
                x--;
                y = this.points[x].length;
                while (y > 0) {
                    y--;
                    this.points[x][y] = "";
                }
            }
        }
    }

    public void addDomino(Domino domino) {
        points[domino.getTuple1().getX()][domino.getTuple1().getY()] = domino.getName();
        points[domino.getTuple2().getX()][domino.getTuple2().getY()] = domino.getName();
    }

    public String toString() {
        String area = "";

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                area = area.concat(points[x][y] + " ");
            }
            area = area.concat("\n");
        }

        return area;
    }

    public boolean isOccupiedTuple(Tuple tuple) {
        return !(points[tuple.getX()][tuple.getY()].equals(""));
    }

    public Tuple getNextTuple(Tuple tuple) {
        if (tuple.getY() + 1 >= this.getHeight()) {
            int y = 0;
            if (tuple.getX() + 1 >= this.getWidth()) {
                return Tuple.emptyTuple();
            }
            return new Tuple(tuple.getX() + 1, y);
        }
        return new Tuple(tuple.getX(), tuple.getY() + 1);
    }

    public boolean isFull() {
        for (String[] point : points) {
            for (String s : point) {
                if (s.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public Area copyArea(){
        Area newArea = new Area(getWidth(), getHeight());
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                newArea.points[x][y] = points[x][y];
            }
        }
        return newArea;
    }
}
