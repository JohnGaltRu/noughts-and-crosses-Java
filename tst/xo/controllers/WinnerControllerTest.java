package xo.controllers;

import xo.model.*;
import xo.model.exceptions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {
    @Test
    void getWinnerColumn() {
        final WinnerController winnerController = new WinnerController();
        try {
            for (int i = 0; i < 3; i++) {
                final Board board = new Board();
                board.setFigure(new Point(i, 0), Figure.X);
                board.setFigure(new Point(i, 1), Figure.X);
                board.setFigure(new Point(i, 2), Figure.X);
                assertEquals(Figure.X, winnerController.getWinner(board));
            }
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getNoWinnerColumn() {
        final WinnerController winnerController = new WinnerController();
        try {
            for (int i = 0; i < 3; i++) {
                final Board board = new Board();
                board.setFigure(new Point(i, 0), Figure.O);
                board.setFigure(new Point(i, 1), Figure.O);
                board.setFigure(new Point(i, 2), Figure.X);
                assertEquals(null, winnerController.getWinner(board));
            }
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getWinnerRow() {
        final WinnerController winnerController = new WinnerController();
        try {
            for (int i = 0; i < 3; i++) {
                final Board board = new Board();
                board.setFigure(new Point(0, i), Figure.X);
                board.setFigure(new Point(1, i), Figure.X);
                board.setFigure(new Point(2, i), Figure.X);
                assertEquals(Figure.X, winnerController.getWinner(board));
            }
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getNoWinnerRow() {
        final WinnerController winnerController = new WinnerController();
        try {
            for (int i = 0; i < 3; i++) {
                final Board board = new Board();
                board.setFigure(new Point(0, i), Figure.O);
                board.setFigure(new Point(1, i), Figure.X);
                board.setFigure(new Point(2, i), Figure.X);
                assertEquals(null, winnerController.getWinner(board));
            }
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getWinnerFirstDiagonal() {
        final WinnerController winnerController = new WinnerController();
        try {
                final Board board = new Board();
                board.setFigure(new Point(0, 0), Figure.X);
                board.setFigure(new Point(1, 1), Figure.X);
                board.setFigure(new Point(2, 2), Figure.X);
                assertEquals(Figure.X, winnerController.getWinner(board));
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getNoWinnerFirstDiagonal() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Board board = new Board();
            board.setFigure(new Point(0, 0), Figure.X);
            board.setFigure(new Point(1, 1), Figure.O);
            board.setFigure(new Point(2, 2), Figure.X);
            assertEquals(null, winnerController.getWinner(board));
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getWinnerSecondDiagonal() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Board board = new Board();
            board.setFigure(new Point(0, 2), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 0), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
        }
        catch (InvalidPointException e) {};
    }

    @Test
    void getNoWinnerSecondDiagonal() {
        final WinnerController winnerController = new WinnerController();
        try {
            final Board board = new Board();
            board.setFigure(new Point(0, 2), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 0), Figure.O);
            assertEquals(null, winnerController.getWinner(board));
        }
        catch (InvalidPointException e) {};
    }
}