package xo.model;

import java.awt.*;
import xo.model.exceptions.*;

public class Board {
    public final static int fieldSize = 3;
    private final Figure field[][] = new Figure[fieldSize][fieldSize];

    public int getFieldSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException{
        if (!checkCoordinate(point)) {throw new InvalidPointException();}
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkCoordinate(point)) {throw new InvalidPointException();}
        field[point.x][point.y] = figure;

    }

    private boolean checkCoordinate(final Point point) {
        if (point.x >= 0 && point.x < fieldSize && point.y >= 0 && point.y < fieldSize) {return true;}
        else {return  false;}
    }


}
