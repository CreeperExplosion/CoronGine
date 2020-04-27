package solution.engine.physics;


public class Hitbox {

    private float x;
    private float y;

    private float width;
    private float height;



    public Hitbox(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    

    public void scale(float scale) {
        width *= scale;
        height *= scale;
    }

    boolean intersects(Hitbox hitbox){
        
        float totW = (hitbox.width + width) * 0.5f;
        float totH = (hitbox.height + height) * 0.5f;

        
        float tx = x;
        float ty = y;

        float hx = hitbox.x;
        float hy = hitbox.y;

        float dy = Math.abs(ty - hy);
        float dx = Math.abs(tx - hx);

        return (dx < totW) && (dy < totH);
    }


    public void move(float dx, float dy){
        this.x += dx;
        this.y += dy;
    }

    public void movex(float dx){
        this.move(dx, 0);
    }

    public void moveY(float dy) {
        this.move(0, dy);  
    }


    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
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

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    


    
}
