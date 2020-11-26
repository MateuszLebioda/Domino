package com.mateusz.lebioda.model;

import lombok.Getter;

@Getter
public class Domino {

    private Tuple tuple1;
    private Tuple tuple2;
    private String name;

    public Domino(Tuple tuple1, Tuple tuple2, String name) {
        this.tuple1 = tuple1;
        this.tuple2 = tuple2;
        this.name = name;
    }
}
