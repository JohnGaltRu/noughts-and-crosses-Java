package xo.controllers;

import  xo.model.*;
import  xo.model.exceptions.*;

import java.awt.*;
import java.lang.reflect.Field;

public class MoveController {

    public void applyFigure(final Point point, final  Board board, final Figure figure) throws InvalidPointException, AlreadyOccupiedException{
        if (board.getFigure(point) != null) {throw new AlreadyOccupiedException();}
        board.setFigure(point, figure);
    }
}
