package com.mateusz.lebioda;

import com.mateusz.lebioda.model.Area;
import com.mateusz.lebioda.model.Domino;
import com.mateusz.lebioda.model.State;
import com.mateusz.lebioda.model.Tuple;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AreaBuilder {

    @Getter
    private List<Area> areas = new ArrayList<>();

    public AreaBuilder() {
    }


    public Area doDominoes(Area area) {
        Area localArea = new Area(area.getWidth(), area.getHeight());
        Tuple tuple = new Tuple(0, 0);
        int index = 0;

        addNewDomino(tuple, localArea, index);
        return localArea;
    }

    private void addNewDomino(Tuple tuple, Area area, int index) {
        Tuple tuple1 = area.getNextTuple(tuple);
        Area tempArea = area.copyArea();


        if (canAddVerticalDomino(tuple, tempArea)) {
            System.out.println("dodaje nowe domino pionowo" + tuple.toString());
            addVerticallyDomino(tuple, tempArea, index);
            index++;
            if(tempArea.isFull()){
                areas.add(tempArea);
            }
            addNewDomino(tuple,tempArea,index);
        }if(canAddHorizontallyDomino(tuple,tempArea)){
            System.out.println("dodaje nowe domino poziomo" + tuple.toString());
            addHorizontallyDomino(tuple, tempArea, index);
            index++;
            if(tempArea.isFull()){
                areas.add(tempArea);
            }
        }if (checkTupleState(tuple1, tempArea) != State.DOESNT_EXIST) {
            addNewDomino(tuple1, tempArea, index);
        }
    }

    private boolean canAddVerticalDomino(Tuple tuple, Area area) {
        return (checkTupleState(tuple, area) == State.EMPTY) && (checkTupleState(getAboveTuple(tuple), area) == State.EMPTY);
    }

    private void addVerticallyDomino(Tuple tuple, Area area, int index) {
        area.addDomino(new Domino(tuple, getAboveTuple(tuple), String.valueOf(index)));
    }


    private boolean canAddHorizontallyDomino(Tuple tuple, Area area) {
        return (checkTupleState(tuple, area) == State.EMPTY) && (checkTupleState(getLeftTuple(tuple), area) == State.EMPTY);
    }

    private void addHorizontallyDomino(Tuple tuple, Area area, int index) {
        area.addDomino(new Domino(tuple, getLeftTuple(tuple), String.valueOf(index)));
    }

    private State checkTupleState(Tuple tuple, Area area) {
        if ((tuple.getY() < 0 || tuple.getY() >= area.getHeight()) ||
                (tuple.getX() < 0 || tuple.getX() >= area.getWidth())) {
            return State.DOESNT_EXIST;
        } else if (area.isOccupiedTuple(tuple)) {
            return State.OCCUPIED;
        } else {
            return State.EMPTY;
        }
    }

    private Tuple getAboveTuple(Tuple tuple) {
        return new Tuple(tuple.getX(), tuple.getY() - 1);
    }

    private Tuple getLeftTuple(Tuple tuple) {
        return new Tuple(tuple.getX() - 1, tuple.getY());
    }
}
