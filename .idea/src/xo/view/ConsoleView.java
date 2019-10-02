package xo.view;

import xo.model.*;
import xo.controllers.*;
import xo.model.exceptions.*;
import xo.model.exceptions.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final MoveController moveController = new MoveController();
    private final PlayerMoveController playerMoveController  = new PlayerMoveController();
    private final WinnerController winnerController = new WinnerController();

    public void show(final Game game) {
        Board board = game.getField();
        for (int i = 0; i < Board.fieldSize; i++) {
            if (i != 0) {System.out.println("~~~~~~~~~");};
            for (int y = 0; y < Board.fieldSize; y++) {
                if (y != 0) {
                    System.out.print("|");
                    System.out.print(" ");
                }
                final Figure figure;
                try {
                    figure = board.getFigure(new Point(y,i));
                }
                catch (InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                };
                System.out.print(figure != null ? figure : " ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean move(final Game game) {
        final Board board = game.getField();
        final Figure winner = winnerController.getWinner(board);
        if (winner != null) {
            System.out.println("Winner is: " + winner);
            return false;
        }

        final Figure currentFigure = playerMoveController.currentPlayer(board);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }

        String player1 = game.getPlayers()[0].getName();
        String player2 = game.getPlayers()[1].getName();
        if (currentFigure == Figure.X) {System.out.println(player1 + ", please enter your move point");};
        if (currentFigure == Figure.O) {System.out.println(player2 + ", please enter your move point");};

        final Point point = new Point(askCoordinate("column"), askCoordinate("row"));
        try {
            moveController.applyFigure(point, board, currentFigure);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        System.out.println(Arrays.deepToString(game.getField().field)); //dsfsdfsdfsdf
        return true;
    }

    private int askCoordinate(final String coordinateName) {
        System.out.println("Please input " + coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Please enter a number");
            return askCoordinate(coordinateName);
        }
    }
}
