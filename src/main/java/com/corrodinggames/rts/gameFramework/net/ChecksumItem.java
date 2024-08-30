package com.corrodinggames.rts.gameFramework.net;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.al
public strictfp class ChecksumItem {
    public String a;
    public long b;
    boolean c;
    // $FF: synthetic field
    final CheckSumData d;

    public ChecksumItem(CheckSumData var1, String var2) {
        this(var1, var2, true);
    }

    public ChecksumItem(CheckSumData var1, String var2, boolean var3) {
        this.d = var1;
        this.a = var2;
        this.c = var3;
        var1.b.add(this);
    }
}
