package xo.model;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Game {
    private Player players[];
    final private Board board;
    final static String gameName = "Welcome to XO!";

    public Game(Board board, Player players[]) {
        this.players = players;
        this.board = board;
    }

    public Player[] getPlayers() { return players;};
    public Board getField() { return board;}; // naxera ne poimy
    public static String getGameName() {return gameName;};
}
