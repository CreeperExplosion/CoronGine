package solution.engine.Math;

public class Vector3f {

    public float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(Vector2f vector2f) {
        this.x = vector2f.x;
        this.y = vector2f.y;
        this.z = 0f;
    }

    public Vector3f() {

    }

    public float getAbs() {
        return distance(this, new Vector3f(0f, 0f, 0f));
    }

    public Vector3f getReverse() {
        return new Vector3f(-x, -y, -z);
    }

    public Vector3f toUnit() {
        float abs = getAbs();
        return new Vector3f(x / abs, y / abs, z / abs);
    }

    @Override
    public String toString() {
        return "{" + " x='" + x + "'" + ", y='" + y + "'" + ", z='" + z + "'" + "}";
    }

    public static Vector2f add(Vector2f a, Vector2f b) {
        return new Vector2f(a.x + b.x, a.y + b.y);
    }

    public static float distance(Vector3f a, Vector3f b) {
        double xel = Math.pow(a.x - b.x, 2);
        double yel = Math.pow(a.y - b.y, 2);
        double zel = Math.pow(a.z - b.z, 2);

        return (float) Math.sqrt(xel + yel + zel);
    }

    public static float dot(Vector3f a, Vector3f b) {

        return new Vector3f(a.x * b.y, a.y * b.y, a.z * b.z).getAbs();
    }

    public static Vector3f cross(Vector3f a, Vector3f b) {

        Vector3f c = new Vector3f();

        c.x = (a.y * b.z) - (a.z * b.y);
        c.y = (a.z * b.x) - (a.x * b.z);
        c.z = (a.x * b.y) - (a.y * b.x);

        return c;
    }

}