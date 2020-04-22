package solution.engine.physics;


public class Hitbox {

    private float posx;
    private float posy;

    private float width;
    private float height;



    public Hitbox(float posx, float posy, float width, float height) {
        this.posx = posx;
        this.posy = posy;
        this.width = width;
        this.height = height;
    }
    

    public void scale(float scale) {
        width *= scale;
        height *= scale;
    }

    public boolean intersects(Hitbox arg){


        float ax = arg.getPosx();
        float ay = arg.getPosy();

        float aw = arg.getWidth();
        float ah = arg.getHeight();

        float tx = this.posx;
        float ty = this.posy;

        float tw = this.width;
        float th = this.height; 

        if (aw <= 0 || ah <= 0 || tw <= 0 || th <= 0) {
            return false;
        }

        aw += ax;
        ah += ay;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((aw <= ax || aw >= tx) &&
                (ah <= ay || ah >= ty) &&
                (tw <= tx || tw >= ax) &&
                (th <= ty || th >= ay));
    }


    public void setPos(float x, float y){
        this.posx = x;
        this.posy = y;
    }

    public float getPosx() {
        return this.posx;
    }

    public void setPosx(float posx) {
        this.posx = posx;
    }

    public float getPosy() {
        return this.posy;
    }

    public void setPosy(float posy) {
        this.posy = posy;
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
