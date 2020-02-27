package java2.lesson21;

public class RunningTrack implements Exercise {

    private long length;

    public RunningTrack(long length) { this.setLength(length); }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        if(length > 0) {
            this.length = length;
        } else {
            this.length = 0;
        }
    }

    @Override
    public boolean doIt(Actor actor) {
        return actor.run(length);
    }
}
