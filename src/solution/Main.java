package solution;



import solution.coronagame.CoronaGame;
import solution.engine.Engine;
import solution.engine.logic.GameImplementation;

public class Main {

    public static void main(String[] args) {
        
        GameImplementation corona = new CoronaGame();
        Engine game = new Engine(corona);
        game.start();


    }   

}

