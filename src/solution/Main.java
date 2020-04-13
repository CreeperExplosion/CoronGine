package solution;

import solution.graphics.Window;
import solution.graphics.WindowPanel;
import java.util.Vector;

import solution.Game.CoronaGame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Window window = new Window(new WindowPanel()).setWindowParams(1280, 720).commit();

        CoronaGame game = new CoronaGame();
    
    
        System.out.println();
        game.start();
    }   

    }

