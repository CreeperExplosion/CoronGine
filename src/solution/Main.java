package solution;



import solution.coronagame.CoronaGame;
import solution.engine.GameLoop;
import solution.engine.logic.GameLogic;

public class Main {

    public static void main(String[] args) {
        
        GameLogic corona = new CoronaGame();
        GameLoop game = new GameLoop(corona);
        game.start();


    }   

}

