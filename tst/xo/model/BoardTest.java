package xo.model;

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
    void setFigure() {
        final Board board = new Board();
        final Point point = new Point(0, 0);
        final Figure figure = Figure.X;

        board.setFigure(point, figure);

        Figure expectedValue = figure;
        Figure actualValue = board.getFigure(point);
        assertEquals(expectedValue, actualValue);
    }
}