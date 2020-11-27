package com.mateusz.lebioda.model;

import lombok.Getter;

@Getter
public class Tuple {

    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return this.x == -1 && this.y == -1;
    }

    public static Tuple emptyTuple() {
        return new Tuple(-1, -1);
    }

    public String toString(){
        return "x: " + x + "; y: " + y;
    }
}
