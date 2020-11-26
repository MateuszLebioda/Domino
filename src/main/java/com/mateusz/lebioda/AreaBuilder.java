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
        Tuple nextTuple = area.getNextTuple(tuple);


        if (canAddVerticalDomino(tuple, area)) {
            Area tempArea = area.copyArea();
            //System.out.println("dodaje nowe domino pionowo" + tuple.toString());
            addVerticallyDomino(tuple, tempArea, index);
            index++;
            if (tempArea.isFull()) {
                addArea(tempArea);
            }
            addNewDomino(tuple,tempArea,index);
        }if(canAddHorizontallyDomino(tuple,area)){
            Area tempArea = area.copyArea();
            //System.out.println("dodaje nowe domino poziomo" + tuple.toString());
            addHorizontallyDomino(tuple, tempArea, index);
            index++;
            if (tempArea.isFull()) {
                addArea(tempArea);
            }
            addNewDomino(tuple,tempArea,index);
        }
        if (checkTupleState(nextTuple, area) != State.DOESNT_EXIST) {
            addNewDomino(nextTuple, area, index);
        }
    }

    private boolean canAddVerticalDomino(Tuple tuple, Area area) {
        return (checkTupleState(tuple, area) == State.EMPTY) && (checkTupleState(getBottomTuple(tuple), area) == State.EMPTY);
    }

    private void addVerticallyDomino(Tuple tuple, Area area, int index) {
        area.addDomino(new Domino(tuple, getBottomTuple(tuple), String.valueOf(index)));
    }


    private boolean canAddHorizontallyDomino(Tuple tuple, Area area) {
        return (checkTupleState(tuple, area) == State.EMPTY) && (checkTupleState(getRightTuple(tuple), area) == State.EMPTY);
    }

    private void addHorizontallyDomino(Tuple tuple, Area area, int index) {
        area.addDomino(new Domino(tuple, getRightTuple(tuple), String.valueOf(index)));
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

    private Tuple getBottomTuple(Tuple tuple) {
        return new Tuple(tuple.getX(), tuple.getY() + 1);
    }

    private Tuple getRightTuple(Tuple tuple) {
        return new Tuple(tuple.getX() + 1, tuple.getY());
    }

    private void addArea(Area area) {
        boolean add = true;
        for (Area a : areas) {
            if (a.isEquals(area)) {
                add = false;
            }
        }
        if (add) {
        areas.add(area);
        }
    }
}
