package xo.model;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Game {
    private Player players[];
    final private Field field;
    final static String gameName = "XO";

    public Game(Field field, Player players[]) {
        this.players = players;
        this.field = field;
    }

    //public String getPlayers(Player players) { return Arrays.toString(players);};
    public Field getField(Field field) { return field;};
    public String getGameName() {return gameName;};
}
