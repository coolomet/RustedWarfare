package net.rudp.p002a;

public class ACKSegment extends Segment {
    protected ACKSegment() {
    }

    public ACKSegment(int var1, int var2) {
        this.init(64, var1, 6);
        this.setAck(var2);
    }

    public String a() {
        return "ACK";
    }
}
