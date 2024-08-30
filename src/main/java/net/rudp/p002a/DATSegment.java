package net.rudp.p002a;

public class DATSegment extends Segment {
    private byte[] data;

    protected DATSegment() {
    }

    public DATSegment(int var1, int var2, byte[] var3, int var4, int var5) {
        this.init(64, var1, 6);
        this.setAck(var2);
        this.data = new byte[var5];
        System.arraycopy(var3, var4, this.data, 0, var5);
    }

    public int b() {
        return this.data.length + super.b();
    }

    public String a() {
        return "DAT";
    }

    public byte[] c() {
        return this.data;
    }

    public byte[] getBytes() {
        byte[] var1 = super.getBytes();
        System.arraycopy(this.data, 0, var1, 6, this.data.length);
        return var1;
    }

    public void parseBytes(byte[] var1, int var2, int var3) {
        super.parseBytes(var1, var2, var3);
        this.data = new byte[var3 - 6];
        System.arraycopy(var1, var2 + 6, this.data, 0, this.data.length);
    }
}
