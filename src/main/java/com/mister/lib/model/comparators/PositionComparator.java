package com.mister.lib.model.comparators;

import com.mister.lib.model.enums.Position;

import java.util.Comparator;

public class PositionComparator implements Comparator<Position> {
    @Override
    public int compare(Position position, Position otherPosition) {
        return Integer.compare(otherPosition.getWeight(), position.getWeight());
    }


}
