package net.rudp.p002a;

import lombok.SneakyThrows;

import java.io.IOException;

public abstract class Segment {
    private int flags;
    private int hlen;
    private int seqn;
    private int d = -1;
    private int nretx = 0;

    protected Segment() {
    }

    public abstract String a();

    public int m() {
        return this.seqn;
    }

    public int b() {
        return this.hlen;
    }

    public void setAck(int var1) {
        this.flags |= 64;
        this.d = var1;
    }

    public int getAck() {
        return (this.flags & 64) == 64 ? this.d : -1;
    }

    public int getRetxCounter() {
        return this.nretx;
    }

    public void b(int var1) {
        this.nretx = var1;
    }

    public byte[] getBytes() {
        byte[] var1 = new byte[this.b()];
        var1[0] = (byte)(this.flags & 255);
        var1[1] = (byte)(this.hlen & 255);
        var1[2] = (byte)(this.seqn & 255);
        var1[3] = (byte)(this.d & 255);
        return var1;
    }

    public String toString() {
        return this.a() + " [ SEQ = " + this.m() + ", ACK = " + (this.getAck() >= 0 ? "" + this.getAck() : "N/A") + ", LEN = " + this.b() + " ]";
    }

    @SneakyThrows
    public static Segment parse(byte[] var0, int var1, int var2) {
        Object var3 = null;
        if (var2 < 6) {
            throw new IOException("Invalid segment:" + var2);
        } else {
            byte var4 = var0[var1];
            if ((var4 & -128) != 0) {
                var3 = new SYNSegment();
            } else if ((var4 & 8) != 0) {
                var3 = new NULSegment();
            } else if ((var4 & 32) != 0) {
                var3 = new EAKSegment();
            } else if ((var4 & 16) != 0) {
                var3 = new RSTSegment();
            } else if ((var4 & 2) != 0) {
                var3 = new FINSegment();
            } else if ((var4 & 64) != 0) {
                if (var2 == 6) {
                    var3 = new ACKSegment();
                } else {
                    var3 = new DATSegment();
                }
            }

            if (var3 == null) {
                throw new IOException("Invalid segment");
            } else {
                ((Segment)var3).parseBytes(var0, var1, var2);
                return (Segment)var3;
            }
        }
    }

    protected void init(int var1, int var2, int var3) {
        this.flags = var1;
        this.seqn = var2;
        this.hlen = var3;
    }

    protected void parseBytes(byte[] var1, int var2, int var3) {
        this.flags = var1[var2] & 255;
        this.hlen = var1[var2 + 1] & 255;
        this.seqn = var1[var2 + 2] & 255;
        this.d = var1[var2 + 3] & 255;
    }
}
