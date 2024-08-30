package net.rudp.p002a;

public class EAKSegment extends ACKSegment {
    private int[] data;

    protected EAKSegment() {
    }

    public EAKSegment(int var1, int var2, int[] var3) {
        this.init(32, var1, 6 + var3.length);
        this.setAck(var2);
        this.data = var3;
    }

    public String a() {
        return "EAK";
    }

    public int[] c() {
        return this.data;
    }

    public byte[] getBytes() {
        byte[] var1 = super.getBytes();

        for(int var2 = 0; var2 < this.data.length; ++var2) {
            var1[4 + var2] = (byte)(this.data[var2] & 255);
        }

        return var1;
    }

    protected void parseBytes(byte[] var1, int var2, int var3) {
        super.parseBytes(var1, var2, var3);
        this.data = new int[var3 - 6];

        for(int var4 = 0; var4 < this.data.length; ++var4) {
            this.data[var4] = var1[var2 + 4 + var4] & 255;
        }

    }
}
