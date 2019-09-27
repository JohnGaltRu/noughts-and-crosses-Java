package xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        final String expectedValue = "Kostya";
        final Player player = new Player("Kostya", null);
        final String actualValue =  player.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getFigure() {
        final Figure expectedValue = Figure.X;
        final Player player = new Player(null, expectedValue);
        final Figure actualValue =  player.getFigure();
        assertEquals(expectedValue, actualValue);
    }
}