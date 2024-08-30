package net.rudp.p002a;

public class NULSegment extends Segment {
    protected NULSegment() {
    }

    public NULSegment(int var1) {
        this.init(8, var1, 6);
    }

    public String a() {
        return "NUL";
    }
}
