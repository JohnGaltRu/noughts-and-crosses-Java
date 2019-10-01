package xo.controllers;

import xo.model.*;
import xo.model.exceptions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinner() {
        final Board board = new Board();
        try {
            board.setFigure(new Point(0, 0), Figure.X);
            board.setFigure(new Point(0, 1), Figure.X);
            board.setFigure(new Point(0, 2), Figure.X);
        }
        catch (InvalidPointException e) {};

        final WinnerController winnerController = new WinnerController();

        assertEquals(Figure.X, winnerController.getWinner(board));
    }
}