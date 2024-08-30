package net.rudp.p002a;

public class FINSegment extends Segment {
    protected FINSegment() {
    }

    @Override
    public String a() {
        return null;
    }

    public FINSegment(int var1) {
        this.init(2, var1, 6);
    }

    public String type() {
        return "FIN";
    }
}
