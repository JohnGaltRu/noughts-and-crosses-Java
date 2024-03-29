package xo.model;

import xo.model.exceptions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getFieldSize() {
        final Board board = new Board();
        assertEquals(3, board.getFieldSize());
    }

    @Test
    void setFigure() throws InvalidPointException {
        final Board board = new Board();
        final Point point = new Point(2, 1);
        final Figure figure = Figure.X;

        try {board.setFigure(point, figure);}
        catch (InvalidPointException e) {}

        Figure expectedValue = figure;
        Figure actualValue = board.getFigure(point);

        assertEquals(expectedValue, actualValue);
    }
}