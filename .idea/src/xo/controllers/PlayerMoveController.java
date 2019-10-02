package xo.controllers;

import xo.model.*;
import  xo.model.exceptions.*;

import java.awt.*;

public class PlayerMoveController {
    public Figure currentPlayer(final Board board) {
        int figureCount = 0;
        for (int a = 0; a < Board.fieldSize; a++) {
            for (int b = 0; b < Board.fieldSize; b++) {
                try {
                    if (board.getFigure(new Point(a, b)) != null) { figureCount++; }
                }
                catch (InvalidPointException e) {};
            }
        }
        if (figureCount == (Board.fieldSize * Board.fieldSize)) { return null; };
        if (figureCount % 2 == 0) { return Figure.X; };
        return Figure.O;
    }
}
