package solution.engine.graphics;

public class Camera {

    private float zoom;
    private float x;
    private float y;


    public Camera() {
        this(1,0,0);
    }

    public Camera(float zoom, float x, float y) {
        this.zoom = zoom;
        this.x = x;
        this.y = y;
    }

    public float getZoom() {
        return this.zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }



}