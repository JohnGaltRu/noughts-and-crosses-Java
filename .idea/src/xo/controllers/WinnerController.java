package xo.controllers;

import  xo.model.*;
import  xo.controllers.exceptions.*;
import  xo.model.exceptions.*;

import java.awt.*;
import java.lang.reflect.Field;

public class WinnerController {
    public Figure getWinner(final Board board) {
        try {
            for (int i = 0; i < 3; i++) {
                if (checkWinner(board, new Point(i, 0), new Point(i, 1), new Point(i, 2))) {
                    return board.getFigure(new Point(i, 0));
                }
            }
            for (int i = 0; i < 3; i++) {
                if (checkWinner(board, new Point(0, i), new Point(1, i), new Point(2, i))) {
                    return board.getFigure(new Point(0, i));
                }
            }
            if (checkWinner(board, new Point(0, 0), new Point(1, 1), new Point(2, 2))) {
                return board.getFigure(new Point(0, 0));
            }
            if (checkWinner(board, new Point(0, 2), new Point(1, 1), new Point(2, 0))) {
                return board.getFigure(new Point(0, 2));
            }
        }
        catch (InvalidPointException e) {}
        //catch (NoWinnerException e) {}
        return null;
    };
    private boolean checkWinner(final Board board, final Point p1, final  Point p2, final  Point p3) throws InvalidPointException{
        if (board.getFigure(p1) == null) { return  false;};
        if (board.getFigure(p1) == board.getFigure(p2) && board.getFigure(p1) == board.getFigure(p3)) {return true;}
        return false;
    }
}
