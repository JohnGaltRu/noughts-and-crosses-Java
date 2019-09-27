package xo.model;

import java.awt.*;

public class Board {
    final static int fieldSize = 3;
    private final Figure field[][] = new Figure[fieldSize][fieldSize];

    public int getFieldSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) {
        field[point.x][point.y] = figure;
    }
}
