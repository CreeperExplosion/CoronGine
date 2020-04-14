package solution;



import solution.Game.CoronaGame;
import solution.Game.GameLoop;
import solution.Game.logic.GameLogic;
import solution.graphics.ImageLoader;
import solution.graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        
        GameLogic corona = new CoronaGame();
        GameLoop game = new GameLoop(corona);
        System.out.println();
        game.start();

    }   

}

