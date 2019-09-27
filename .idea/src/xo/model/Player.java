package xo.model;

public class Player {
    final String name;
    final Figure figure;

    public Player(String name, xo.model.Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public xo.model.Figure getFigure() {
        return figure;
    }
}
