package xo;

import xo.model.*;
import xo.view.*;

import java.util.Scanner;

public class XOCLI {
    public static void main(final String[] args) {
        System.out.println(Game.getGameName());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first player name:");
        String name1 = scanner.nextLine();
        System.out.println("Please enter second player name:");
        String name2 = scanner.nextLine();

        System.out.println("Hello " + name1 + ", " + name2 + "!");

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(new Board(), players);

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }
    }
}
