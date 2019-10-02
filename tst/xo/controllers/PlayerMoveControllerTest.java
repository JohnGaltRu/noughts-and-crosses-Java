package xo.controllers;

import xo.model.*;
import xo.model.exceptions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerMoveControllerTest {

    @Test
    void gameStart() {
        Board board = new Board();

        PlayerMoveController playerMoveController = new PlayerMoveController();
        assertEquals(Figure.X, playerMoveController.currentPlayer(board));
    }

    @Test
    void noCurrentPlayer() {
        Board board = new Board();
        for (int a = 0; a < Board.fieldSize; a++) {
                for (int b = 0; b < Board.fieldSize; b++) {
                    try {
                        board.setFigure(new Point(a, b), Figure.X);
                    }
                    catch (InvalidPointException e) {} ;
                }
        }
        PlayerMoveController playerMoveController = new PlayerMoveController();
        assertEquals(null, playerMoveController.currentPlayer(board));
    }

    @Test
    void currentPlayerisX() {
        Board board = new Board();
        for (int a = 0; a < Board.fieldSize; a++) {
                try {
                    board.setFigure(new Point(a, 0), Figure.X);
                }
                catch (InvalidPointException e) {} ;
        }
        PlayerMoveController playerMoveController = new PlayerMoveController();
        assertEquals(Figure.O, playerMoveController.currentPlayer(board));
    }

    @Test
    void currentPlayerisO() {
        Board board = new Board();
            try {
                board.setFigure(new Point(1, 1), Figure.X);
            }
            catch (InvalidPointException e) {} ;
        PlayerMoveController playerMoveController = new PlayerMoveController();
        assertEquals(Figure.O, playerMoveController.currentPlayer(board));
    }
}