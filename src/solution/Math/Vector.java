package solution.Math;

public class Vector<N extends Number> {

    N x;

    N y;

    public Vector(N x, N y) {
        this.x = x;
        this.y = y;
    }



    /**
     * @return the x
     */
    public N getX() {
        return x;
    }
    /**
     * @return the y
     */
    public N getY() {
        return y;
    }
    /**
     * @param x the x to set
     */
    public void setX(N x) {
        this.x = x;
    }
    /**
     * @param y the y to set
     */
    public void setY(N y) {
        this.y = y;
    }
}