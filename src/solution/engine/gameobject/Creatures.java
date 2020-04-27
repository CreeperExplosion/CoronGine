package solution.engine.gameobject;

public abstract class Creatures extends Body {

    public Creatures(String path) {
        super(path);

    public void moveX(float dx){
        x += dx;
    }
    
    public void moveX(float dx) {
        x += dx;
    }

    public void moveY(float dy) {
        y += dy;
    }
}