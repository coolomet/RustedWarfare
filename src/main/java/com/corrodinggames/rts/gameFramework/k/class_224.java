package com.corrodinggames.rts.gameFramework.k;

import android.graphics.Paint;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import java.util.LinkedList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.k
public strictfp class class_224 {
    private PathEngine a;
    protected int e;
    protected static int f;
    public int g;
    protected short h;
    protected short i;
    protected Float j;
    protected boolean k;
    protected short l;
    protected short m;
    protected short n;
    protected MovementType o;
    public boolean p;
    public int q;
    public boolean r;
    public float s;
    public float t;
    public boolean u;
    protected boolean v;
    protected boolean w;
    protected LinkedList x;
    public byte[] y;
    public byte[] z;
    public byte[] A;
    public short[] B;
    public byte[] C;

    public class_224(PathEngine var1, boolean var2) {
        this.a = var1;
        if (var2) {
            this.e = f++;
        }

        GameEngine var3 = GameEngine.getGameEngine();
        this.g = var3.tick;
    }

    public strictfp void a(GameOutputStream var1) {
        if (this.x == null) {
            var1.writeBoolean(false);
        } else {
            var1.writeBoolean(true);
            var1.startBlock("p", true);
            var1.writeInt(this.x.size());
            if (this.x.size() != 0) {
                class_319 var2 = (class_319)this.x.get(0);
                var1.a(var2.a);
                var1.a(var2.b);

                for(int var3 = 1; var3 < this.x.size(); ++var3) {
                    class_319 var4 = (class_319)this.x.get(var3);
                    int var5 = var4.a - var2.a;
                    int var6 = var4.b - var2.b;
                    boolean var7 = class_340.d(var5) > 1 || class_340.d(var6) > 1;
                    int var8;
                    if (var7) {
                        GameEngine.log("writeOutCompressedPath: out of range:" + var5 + "," + var6);
                        var8 = 128;
                    } else {
                        var8 = var5 + 1 + (var6 + 1 << 2);
                    }

                    var1.writeByte(var8);
                    if (var7) {
                        var1.a(var4.a);
                        var1.a(var4.b);
                    }

                    var2 = var4;
                }
            }

            var1.endBlock("p");
        }

    }

    public strictfp void a(GameInputStream var1) {
        boolean var2 = var1.readBoolean();
        if (!var2) {
            this.x = null;
        } else {
            var1.a("p", true);
            int var3 = var1.readInt();
            if (var3 > 160000 || var3 < 0) {
                GameEngine.log("readInCompressedPath: Path too big at:" + var3);
                var3 = -1;
            }

            if (var3 != -1) {
                this.u = true;
                if (this.x == null) {
                    this.x = new LinkedList();
                }

                this.x.clear();
            }

            if (var3 > 0) {
                short var4 = var1.readShort();
                short var5 = var1.readShort();
                this.x.add(new class_319(var4, var5));

                for(int var6 = 1; var6 < var3; ++var6) {
                    byte var7 = var1.readByte();
                    byte var8 = 3;
                    byte var9 = 12;
                    if (var7 >= 128) {
                        GameEngine.log("readInCompressedPath: out of range unpack:" + var4 + "," + var5);
                        var4 = var1.readShort();
                        var5 = var1.readShort();
                        this.x.add(new class_319(var4, var5));
                    } else {
                        int var10 = (var7 & var8) - 1;
                        int var11 = ((var7 & var9) >> 2) - 1;
                        boolean var12 = class_340.d(var10) > 1 || class_340.d(var11) > 1;
                        if (var12) {
                            GameEngine.log("readInCompressedPath: out of range but shouldn't be:" + var10 + "," + var11 + " for: " + var7);
                        }

                        var4 = (short)(var4 + var10);
                        var5 = (short)(var5 + var11);
                        this.x.add(new class_319(var4, var5));
                    }
                }
            }

            var1.endBlock("p");
        }

    }

    public strictfp void e() {
        class_223 var1 = this.a.a(this.o);
        if (var1 == null) {
            throw new RuntimeException("Could not get costs for:" + this.o.toString());
        } else {
            this.y = var1.d;
            this.z = var1.e;
            this.A = var1.f;
            this.B = var1.g;
            this.C = var1.j;
        }
    }

    public strictfp void f() {
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
    }

    public strictfp void a(MovementType var1, short var2, short var3, Float var4, boolean var5) {
        if (var1 == null) {
            throw new RuntimeException("MovementType is null");
        } else {
            this.o = var1;
            this.h = var2;
            this.i = var3;
            this.j = var4;
            this.k = var5;
            if (this.h < 0) {
                this.h = 0;
            }

            if (this.i < 0) {
                this.i = 0;
            }

            if (this.h > this.a.s - 1) {
                this.h = (short)(this.a.s - 1);
            }

            if (this.i > this.a.t - 1) {
                this.i = (short)(this.a.t - 1);
            }

            if (this.a.a(var1) == null) {
                throw new RuntimeException("Could not get costs for:" + var1.toString());
            }
        }
    }

    public strictfp void a(short var1, short var2, short var3) {
        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 < 0) {
            var2 = 0;
        }

        if (var1 > this.a.s - 1) {
            var1 = (short)(this.a.s - 1);
        }

        if (var2 > this.a.t - 1) {
            var2 = (short)(this.a.t - 1);
        }

        this.l = var1;
        this.m = var2;
        this.n = var3;
    }

    public strictfp boolean b() {
        return false;
    }

    public strictfp boolean a(class_224 var1) {
        return this == var1;
    }

    public strictfp class_221 a(Unit var1) {
        return null;
    }

    public strictfp LinkedList a() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.netEngine.B && !var1.replayEngine.i()) {
            return this.x;
        } else {
            return this.u ? this.x : null;
        }
    }

    protected strictfp boolean c() {
        return this.x != null;
    }

    protected strictfp void a(LinkedList var1) {
        this.x = var1;
    }

    public strictfp void g() {
        GameEngine var1 = GameEngine.getGameEngine();
        class_484 var2 = var1.bL;
        Paint var3 = new Paint();
        var3.a(2.0F);
        var3.a(100, 0, 100, 0);
        var1.bO.a((float)(this.l * var2.n + var2.p - GameEngine.getGameEngine().cu), (float)(this.m * var2.o + var2.q - GameEngine.getGameEngine().cv), (float)(this.n * var2.n), var3);
        var3.a(225, 0, 0, 255);
        var1.bO.a((float)(this.h * var2.n + var2.p - GameEngine.getGameEngine().cu), (float)(this.i * var2.o + var2.q - GameEngine.getGameEngine().cv), (float)(this.l * var2.n + var2.p - GameEngine.getGameEngine().cu), (float)(this.m * var2.o + var2.q - GameEngine.getGameEngine().cv), var3);
    }

    public strictfp void h() {
        if (this.x != null) {
            GameEngine var1 = GameEngine.getGameEngine();
            class_484 var2 = var1.bL;
            if (this.x.size() >= 1) {
                for(int var3 = 1; var3 < this.x.size(); ++var3) {
                    class_319 var4 = (class_319)this.x.get(var3);
                    class_319 var5 = (class_319)this.x.get(var3 - 1);
                    Paint var6 = new Paint();
                    var6.a(255, 0, 255, 0);
                    var6.a(2.0F);
                    int var7 = var4.a * var2.n + var2.p - GameEngine.getGameEngine().cu;
                    int var8 = var4.b * var2.o + var2.q - GameEngine.getGameEngine().cv;
                    int var9 = var5.a * var2.n + var2.p - GameEngine.getGameEngine().cu;
                    int var10 = var5.b * var2.o + var2.q - GameEngine.getGameEngine().cv;
                    var1.bO.a((float)var7, (float)var8, (float)var9, (float)var10, var6);
                }
            }
        }

    }
}
