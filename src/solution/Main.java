package solution;

import solution.graphics.Window;
import solution.graphics.WindowPanel;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Window window = new Window(new WindowPanel()).setWindowParams(1280, 720).commit();


    }
}
