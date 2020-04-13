package solution;



import solution.Game.game.CoronaGame;
import solution.Game.game.GameLoop;
import solution.Game.game.logic.GameLogic;

public class Main {

    public static void main(String[] args) {
        

        GameLogic corona = new CoronaGame();
        GameLoop game = new GameLoop(corona);
        System.out.println();
        game.start();
    }   

}

