package solution;

import solution.coronagame.CoronaGame;
import solution.engine.Engine;
import solution.engine.logic.SceneManager;

public class Main {

    public static void main(String[] args) {

        SceneManager corona = new CoronaGame();
        Engine game = new Engine(corona);
        game.start();

    }

}
