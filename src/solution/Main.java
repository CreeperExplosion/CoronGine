package solution;

import solution.coronagame.CoronaGame;
import solution.engine.Engine;

public class Main {

    public static void main(String[] args) {

        var corona = new CoronaGame();
        var engine = new Engine(corona);
        engine.start();

    }

}
