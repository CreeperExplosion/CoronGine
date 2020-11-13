package solution.engine.Math;

public class Vector2f {
    public float x, y;


    public static final Vector2f UP = new Vector2f(0f,-1f);
    public static final Vector2f DOWN = new Vector2f(0f, 1f);
    public static final Vector2f LEFT = new Vector2f(1f, 0);
    public static final Vector2f RIGHT = new Vector2f(-1f, 0f);

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public Vector2f() {
        x = 0f;
        y = 0f;
    }

    public Vector2f mul(float scale){
        this.x *= scale;
        this.y *= scale;
        return this;
    }

    public float getAbs() {
        return distance(this, new Vector2f(0f, 0f));
    }

    public Vector2f getReverse() {
        return new Vector2f(-x, -y);
    }

    public Vector2f toUnit() {
        float abs = getAbs();
        if (abs == 0 )
             return new Vector2f();
        
        return new Vector2f(x / abs, y / abs);
    }

    @Override
    public String toString() {
        return "{" + " x='" + x + "'" + ", y='" + y + "'" + "}";
    }

    public static Vector2f add(Vector2f a, Vector2f b) {
        return new Vector2f(a.x + b.x, a.y + b.y);
    }

    public static float distance(Vector2f a, Vector2f b) {
        double xel = Math.pow(a.x - b.x, 2);
        double yel = Math.pow(a.y - b.y, 2);

        return (float) Math.sqrt(xel + yel);
    }

    public static float dot(Vector2f a, Vector2f b) {

        return new Vector2f(a.x * b.y, a.y * b.y).getAbs();
    }

    public static Vector3f cross(Vector2f a, Vector2f b) {
        return Vector3f.cross(new Vector3f(a), new Vector3f(b));
    }


}