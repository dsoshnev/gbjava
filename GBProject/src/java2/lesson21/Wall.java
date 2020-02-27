package java2.lesson21;

public class Wall implements Exercise {

    private long height;

    public Wall(long height) {
        this.setHeight(height);
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        if(height > 0) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    @Override
    public boolean doIt(Actor actor) {
        return actor.jump(height);
    }
}
