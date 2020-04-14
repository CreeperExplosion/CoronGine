package solution;



import solution.Game.CoronaGame;
import solution.Game.GameLoop;
import solution.Game.logic.GameLogic;

public class Main {

    public static void main(String[] args) {
        

        GameLogic corona = new CoronaGame();
        GameLoop game = new GameLoop(corona);
        System.out.println();
        game.start();
    }   

}

