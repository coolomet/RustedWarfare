package com.corrodinggames.rts.gameFramework;

import android.content.Context;
import android.util.Log;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.am
public strictfp class class_1001 {
    public static class_373 a = new class_374();
    Object b = new Object();
    Object c = new Object();
    volatile float d = 1.0F;
    class_979 e;
    volatile boolean f = false;
    volatile boolean g = true;
    float h = 0.0F;
    int i = 0;
    boolean j = false;
    class_345 k;
    boolean l;
    String m;
    boolean n;
    boolean o;
    float p;
    float q;
    float r;
    public boolean s;
    public String t;
    public boolean u;
    String v;
    Context w;
    boolean x;
    boolean y;
    int z;
    class_345 A;
    boolean B;
    boolean C;
    float D;
    boolean E = false;
    public boolean F = false;
    boolean G = false;
    float H;
    ArrayList I = new ArrayList();
    static HashMap J = new HashMap();
    static int K = 0;
    boolean L;
    boolean M;
    long N = -1L;

    public float a() {
        GameEngine var1 = GameEngine.getGameEngine();
        return var1.settingsEngine.musicVolume * var1.settingsEngine.masterVolume;
    }

    public boolean b() {
        if (GameEngine.ax()) {
            return false;
        } else if (this.u) {
            return false;
        } else {
            return this.a() > 0.01F;
        }
    }

    public void a(Context var1) {
        this.w = var1;
        if (!GameEngine.ax()) {
            a.a(this);
            this.k = a.a();
            this.A = a.a();
            MusicType.c();
            if (a.d()) {
                this.e = new class_979(this);
                this.e.start();
            }

        }
    }

    public void c() {
        if (!GameEngine.av()) {
            this.l = false;
            this.m = null;
            this.x = true;
            this.B = false;
        }

        this.y = true;
        this.u = false;
    }

    static class_976 a(String var0, boolean var1) {
        class_976 var2 = (class_976)J.get(var0);
        if (var2 != null) {
            return var2;
        } else {
            class_976 var3;
            try {
                var3 = a.a(var0);
            } catch (ArithmeticException var5) {
                ++K;
                GameEngine.a((String)("Error loading:" + var0), (Throwable)var5);
                if (K > 2 && K <= 4) {
                    GameEngine.getGameEngine().i("Failed to load music track:" + var0 + ". Music track skipped.");
                }

                if (!var1) {
                    throw new RuntimeException(var5);
                }

                return null;
            } catch (OutOfMemoryError var6) {
                ++K;
                GameEngine.a((String)("OutOfMemoryError loading:" + var0), (Throwable)var6);
                GameEngine.aC();
                System.gc();
                GameEngine.aC();
                if (K < 3) {
                    GameEngine.getGameEngine().i("Ran out of memory loading music track:" + var0 + ". Music track skipped.");
                }

                if (!var1) {
                    throw new RuntimeException(var6);
                }

                return null;
            } catch (Exception var7) {
                ++K;
                GameEngine.a((String)("Exception loading:" + var0), (Throwable)var7);
                if (K > 2 && K <= 4) {
                    GameEngine.getGameEngine().i("Unknown error loading music track:" + var0 + ". Music track skipped.");
                }

                if (!var1) {
                    throw new RuntimeException(var7);
                }

                return null;
            }

            if (var1) {
                J.put(var0, var3);
            }

            return var3;
        }
    }

    public ArrayList d() {
        ArrayList var1 = new ArrayList();
        String[] var2 = MusicType.a.b();
        int var3 = var2.length;

        int var4;
        String var5;
        for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            var1.add(var5);
        }

        var2 = MusicType.b.b();
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            var1.add(var5);
        }

        var2 = MusicType.a.b();
        var3 = var2.length;

        for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            var1.add(var5);
        }

        return var1;
    }

    public String a(MusicType var1) {
        return this.a(var1, var1);
    }

    public String a(MusicType var1, MusicType var2) {
        GameEngine var5 = GameEngine.getGameEngine();
        MusicType var4;
        if (class_340.c(var1.b().length + var2.b().length) < var1.b().length) {
            var4 = var1;
        } else {
            var4 = var2;
        }

        String[] var3 = var4.b();
        return var4.a(var3[class_340.c(var3.length)]);
    }

    public synchronized void e() {
        this.s = true;
        this.u = false;
        this.t = null;
    }

    public synchronized void a(String var1) {
        this.s = true;
        this.u = false;
        this.t = var1;
    }

    public synchronized void a(float var1) {
        if (!GameEngine.ax()) {
            if (!a.d()) {
                if (!this.L) {
                    this.b(var1);
                }

                this.g = true;
            }

            this.N = GameEngine.millis();
            GameEngine var2 = GameEngine.getGameEngine();
            if (var2.bT.H.a()) {
                this.e();
            }

            if (this.v != null) {
                GameNetEngine.a((String)null, (String)this.v);
                this.v = null;
            }

            if (this.p != this.a()) {
                this.p = this.a();
                this.o = true;
            }

            synchronized(this.c) {
                this.d = var1;
                if (this.L) {
                    if (!this.M) {
                        this.M = true;
                        GameEngine.n("Music subsystem crashed, music has been disabled to keep your game running. Please send your logs.");
                    }

                } else {
                    if (!this.g) {
                        this.h += var1;
                        ++this.i;
                        if (this.h > 320.0F && this.i > 80 && !this.j) {
                            this.j = true;
                            GameEngine.n("Lockup detected in music subsystem");
                        }
                    } else {
                        this.h = 0.0F;
                        this.i = 0;
                    }

                    this.g = false;
                    this.f = true;
                    this.c.notifyAll();
                }
            }
        }
    }

    public String b(String var1) {
        var1 = class_340.k(var1);
        var1 = class_340.g(var1);
        var1 = var1.replace("[noloop]", "");
        var1 = var1.replace("_", " ");
        return var1;
    }

    public boolean b(float var1) {
        try {
            this.c(var1);
            return true;
        } catch (Exception var5) {
            GameEngine.a((String)"Music system crashed", (Throwable)var5);
            this.L = true;
            GameEngine.log("Stopping music");

            try {
                this.g();
            } catch (Exception var4) {
                GameEngine.a((String)"crash stopping music", (Throwable)var4);
            }

            return false;
        }
    }

    public void c(float var1) {
        if (!GameEngine.ax()) {
            a.a(var1);
            if (!this.b()) {
                if (this.l && this.k.c()) {
                    this.g();
                    this.l = false;
                    this.B = false;
                }

            } else {
                boolean var2 = false;
                if (!this.l) {
                    var2 = true;
                }

                if (this.n) {
                    if (!this.C) {
                        this.q += var1;
                    }

                    if (this.q > 600.0F) {
                        this.r += var1;
                        if (this.r > 100.0F) {
                            this.r = 0.0F;
                            if (!this.l || !this.k.c()) {
                                var2 = true;
                                this.q = 0.0F;
                            }
                        }
                    }
                } else {
                    this.q += var1;
                    if (this.q > 3600.0F) {
                        GameEngine.log("Next music track, timer:" + this.q);
                        var2 = true;
                        this.q = 0.0F;
                    }
                }

                if (this.y) {
                    class_800 var3 = InterfaceEngine.z();
                    if (var3 != null && var3.N) {
                        var2 = true;
                    }

                    this.y = false;
                }

                boolean var15;
                if (var2 || this.s) {
                    var15 = this.s;
                    String var4 = this.t;
                    if (this.s) {
                        GameEngine.log("Next music track requested");
                        this.s = false;
                        this.q = 0.0F;
                        this.t = null;
                    }

                    String var5 = null;
                    boolean var6 = false;
                    class_800 var7 = null;
                    if (var4 != null) {
                        ArrayList var8 = GameEngine.getGameEngine().bZ.i();
                        var8.addAll(this.d());
                        String var9 = var4;
                        if (var4.endsWith(".ogg") || var4.endsWith(".wav")) {
                            this.b(var4);
                        }

                        Iterator var10 = var8.iterator();

                        while(var10.hasNext()) {
                            String var11 = (String)var10.next();
                            String var12 = this.b(var11);
                            if (var12.equalsIgnoreCase(var9)) {
                                var6 = true;
                                var5 = var11;
                                break;
                            }
                        }

                        if (var5 == null) {
                            GameEngine.log("Failed to find requested music: " + var9);
                        }
                    }

                    class_800 var17 = InterfaceEngine.z();
                    if (var5 == null && var17 != null && var17.P < 10 && var17.N) {
                        ArrayList var19 = var17.q();
                        if (var19.size() > 0) {
                            var6 = true;
                            var7 = var17;
                            var5 = (String)var19.get(class_340.rand(0, var19.size() - 1));
                            if (var15 || this.I.contains(var5)) {
                                for(int var21 = 0; var21 < 30 && (var5.equals(this.m) || this.I.contains(var5)); ++var21) {
                                    var5 = (String)var19.get(class_340.rand(0, var19.size() - 1));
                                    if (var21 > 20) {
                                        this.I.clear();
                                    }
                                }
                            }

                            GameEngine.log("Playing music from mod:" + var17.modName() + " - '" + var5 + "'");
                        }
                    }

                    if (var5 == null) {
                        if (this.x) {
                            var5 = this.a(MusicType.a);
                        } else {
                            var5 = this.a(MusicType.b, MusicType.a);
                        }

                        if (var15 || this.I.contains(var5)) {
                            for(int var20 = 0; var20 < 30 && (var5.equals(this.m) || this.I.contains(var5)); ++var20) {
                                var5 = this.a(MusicType.b, MusicType.a);
                                if (var20 > 20) {
                                    this.I.clear();
                                }
                            }
                        }
                    }

                    if (!var5.equals(this.m)) {
                        this.m = var5;
                        this.x = false;
                        this.q = 0.0F;
                        this.n = var6 || var5.contains("[noloop]");
                        this.I.add(var5);
                        if (this.I.size() > 4) {
                            this.I.remove(0);
                        }

                        if (var15) {
                            this.v = "Now playing: " + this.b(var5);
                        }

                        class_345 var22 = this.k;
                        this.k = this.A;
                        this.A = var22;

                        class_976 var23;
                        try {
                            var23 = a(var5, false);
                        } catch (RuntimeException var14) {
                            var14.printStackTrace();
                            if (this.z < 3) {
                                this.v = "Failed to open music track: " + var5;
                                ++this.z;
                            }

                            if (var7 != null) {
                                ++var7.P;
                            }

                            return;
                        }

                        try {
                            this.k.a(var23);
                            this.k.a(!this.n);
                        } catch (RuntimeException var13) {
                            var13.printStackTrace();
                            if (this.z < 3) {
                                this.v = "Failed to play music track: " + var5;
                                ++this.z;
                            }

                            if (var7 != null) {
                                ++var7.P;
                            }

                            return;
                        }

                        this.E = false;
                        if (!var15 && this.B) {
                            this.E = true;
                        }

                        if (this.l) {
                            this.B = true;
                        }

                        this.C = true;
                        this.G = false;
                        this.D = 1.0F;
                        this.l = true;
                    } else if (var15) {
                        GameEngine.log("Same music found");
                    }
                }

                if (this.C || this.o) {
                    var15 = a.c();
                    if (!var15) {
                        if (this.F) {
                            this.D -= var1 * 0.1F;
                        } else {
                            this.D -= var1 * 0.006F;
                        }
                    } else if (this.F) {
                        this.D -= var1 * 0.1F;
                    } else if (this.E) {
                        this.D -= var1 * 0.003F;
                    } else {
                        this.D -= var1 * 0.008F;
                    }

                    float var16;
                    float var18;
                    if (!var15) {
                        var16 = this.D * this.a();
                        var18 = (1.0F - this.D) * this.a();
                    } else {
                        var16 = (this.D * 2.0F - 1.0F) * this.a();
                        var18 = (1.0F - this.D * 2.0F) * this.a();
                    }

                    var16 = class_340.b(var16, 0.0F, 1.0F);
                    var18 = class_340.b(var18, 0.0F, 1.0F);
                    if (this.C) {
                        if (this.D <= 0.0F) {
                            this.C = false;
                            this.E = false;
                            if (this.B && !this.G) {
                                this.G = true;
                                this.A.d();
                            }

                            if (this.l) {
                                this.k.a(this.a(), this.a());
                            }
                        } else {
                            this.H += var1;
                            if (this.H > 10.0F) {
                                this.H = 0.0F;
                                if (this.B && !this.G) {
                                    this.A.a(var16, var16);
                                    if (var16 < 0.02F) {
                                        this.G = true;
                                        this.A.d();
                                    }
                                }

                                if (this.l) {
                                    this.k.a(var18, var18);
                                }
                            }
                        }
                    } else if (this.l) {
                        this.k.a(var18, var18);
                    }
                }

                this.o = false;
            }
        }
    }

    public void f() {
        Log.a("RustedWarfare", "Music:pause()");
        class_1063 var1 = new class_1063(this);
        var1.start();
    }

    public void g() {
        if (this.l) {
            this.k.a();
        }

        if (this.B) {
            this.A.a();
        }

    }

    public void h() {
        class_1064 var1 = new class_1064(this);
        var1.start();
    }

    public void i() {
        a.b();
        if (this.B) {
            this.A.d();
            this.A.e();
        }

        if (this.k != null) {
            this.k.d();
            this.k.e();
        }

        this.k = null;
        this.m = null;
        this.l = false;
    }

    public boolean j() {
        return this.C;
    }
}
