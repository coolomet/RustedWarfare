package com.corrodinggames.rts.gameFramework.k;

import android.graphics.Paint;
import android.os.Debug;
import android.util.Log;
import com.corrodinggames.rts.game.maps.class_484;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.Iterator;
import java.util.LinkedList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.o
public final strictfp class class_323 implements Runnable {
    private final PathEngine C;
    boolean a = true;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public short[] e;
    public byte[] f;
    private class_224 D;
    int g;
    int h;
    int i = 5;
    int j = 0;
    int k = 0;
    int[][] l;
    byte[][] m;
    class_223 n;
    final class_315 o = new class_315();
    final class_315 p = new class_315();
    final class_319 q = new class_319();
    final class_319 r = new class_319();
    volatile boolean s = true;
    static LinkedList t = new LinkedList();
    static int u;
    int v;
    Thread w;
    Object x = new Object();
    long y;
    long z;
    Object A = new Object();
    Paint B = new Paint();

    public strictfp void a(class_224 var1) {
        if (!this.s) {
            throw new RuntimeException("setupNewPath: last path not yet finished");
        } else {
            this.s = false;
            this.a(var1.o, var1);
            var1.v = true;
            this.D = var1;
        }
    }

    public strictfp void a() {
        if (this.w == null) {
            throw new RuntimeException("thread==null");
        } else {
            synchronized(this.x) {
                this.x.notifyAll();
            }
        }
    }

    public strictfp void run() {
        GameEngine.aq();

        while(this.a) {
            synchronized(this.x) {
                if (this.D == null) {
                    try {
                        this.x.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                    }
                }
            }

            if (this.D != null) {
                this.b();
            }
        }

    }

    public strictfp void b() {
        LinkedList var1;
        if (this.D instanceof class_225) {
            this.f();
            var1 = t;
        } else {
            var1 = this.e();
        }

        synchronized(this.C.G) {
            this.D.f();
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.D.a(var1);
            this.D = null;
            this.s = true;
            this.C.G.notifyAll();
        }
    }

    class_323(PathEngine var1) {
        this.C = var1;
        this.v = u++;
    }

    public strictfp synchronized void c() {
        if (this.w != null) {
            throw new RuntimeException("thread!=null");
        } else {
            this.w = new Thread(this);
            this.w.setName("PathSolver-" + this.v);
            this.w.setPriority(10);
            this.w.setDaemon(true);
            this.w.start();
        }
    }

    public strictfp void a(class_484 var1) {
        this.g = var1.u.n;
        this.h = var1.u.o;
        this.l = new int[2][this.g * this.h];
        this.m = new byte[2][this.g * this.h];
        this.d();
    }

    public strictfp void d() {
        int var1 = this.g * this.h * 42 + 1;
        this.i += var1;
        boolean var2 = false;
        if (this.i > Integer.MAX_VALUE - var1 || this.i < 0 || var2) {
            this.i = 5;

            for(int var3 = 0; var3 < 2; ++var3) {
                for(int var4 = 0; var4 < this.g; ++var4) {
                    for(int var5 = 0; var5 < this.h; ++var5) {
                        this.l[var3][var4 * this.h + var5] = -1;
                    }
                }
            }
        }

    }

    public final strictfp int a(int var1, int var2) {
        return this.b[var1 * this.h + var2] != -1 && this.c[var1 * this.h + var2] != -1 && this.d[var1 * this.h + var2] != -1 ? this.b[var1 * this.h + var2] + this.c[var1 * this.h + var2] + this.d[var1 * this.h + var2] * 10 : -1;
    }

    public strictfp void a(MovementType var1, class_224 var2) {
        if (var1 == null) {
            throw new RuntimeException("MovementType is null");
        } else {
            class_223 var3 = this.C.a(var1);
            if (var3 == null) {
                throw new RuntimeException("Could not get costs for:" + var1.toString());
            } else {
                this.n = var3;
                this.b = var2.y;
                this.c = var2.z;
                this.d = var2.A;
                this.e = var2.B;
                this.f = var2.C;
                if (this.b == null) {
                    throw new RuntimeException("linkToPath failed mapCosts_mapCosts is null");
                } else if (this.c == null) {
                    throw new RuntimeException("linkToPath failed mapCosts_buildingCosts is null");
                } else if (this.d == null) {
                    throw new RuntimeException("linkToPath failed mapCosts_objectCosts is null");
                }
            }
        }
    }

    public strictfp void a(MovementType var1, short var2, short var3, Float var4) {
        if (PathEngine.a) {
            Log.d("RustedWarfare", "path start is:" + var2 + "," + var3);
        }

        class_319 var5 = new class_319(var2, var3);
        var5.a(this, (byte)0, (int)this.i);
        if (var4 == null) {
            var5.a(this, (byte)0, (byte)0);
            var5.b(this, (byte)0, true);
        } else {
            var5.a(this, (byte)0, var4);
            var5.b(this, (byte)0, true);
        }

        var5.a(this, (byte)0, false);
    }

    public strictfp void a(short var1, short var2, short var3) {
        if (PathEngine.a) {
            Log.d("RustedWarfare", "path end is:" + var1 + "," + var2 + " size:" + var3);
        }

        class_319 var4 = new class_319(var1, var2);
        var4.a(this, (byte)1, (byte)0);
        var4.b(this, (byte)1, true);
        var4.a(this, (byte)1, (int)this.i);
        var4.a(this, (byte)1, false);
    }

    static strictfp int b(int var0, int var1) {
        if (var0 == var1) {
            return 0;
        } else {
            int var2 = var0 - var1;
            if (var2 < 0) {
                var2 = -var2;
            }

            if (var2 > 4) {
                var2 = 8 - var2;
            }

            if (var2 == 1) {
                return 4;
            } else {
                return var2 == 2 ? 21 : 25;
            }
        }
    }

    static strictfp int c(int var0, int var1) {
        if (var0 == var1) {
            return 0;
        } else {
            int var2 = Math.abs(var0 - var1);
            if (var2 > 4) {
                var2 = 8 - var2;
            }

            if (var2 == 1) {
                return 4;
            } else if (var2 == 2) {
                return 21;
            } else if (var2 == 3) {
                return 4;
            } else if (var2 == 4) {
                return 0;
            } else {
                return var2 == 5 ? 0 : 25;
            }
        }
    }

    public strictfp LinkedList e() {
        if (PathEngine.l && !GameEngine.getGameEngine().bH) {
            Debug.startMethodTracing("pathTrace", 110000000);
        }

        class_224 var1 = this.D;
        int var2 = var1.p ? 7 : 1;
        int var3 = var1.q;
        if (PathEngine.a) {
            Log.d("RustedWarfare", "starting path for:" + this.n.a.toString());
        }

        class_319 var4 = this.r;
        class_319 var5 = this.q;
        int var6 = this.h;
        int var7 = this.g;
        this.y = GameEngine.millis();
        short var8 = var1.h;
        short var9 = var1.i;
        boolean var10 = var1.k;
        this.d();
        this.a(var1.o, var1.h, var1.i, var1.j);
        short var11 = var1.l;
        short var12 = var1.m;
        short var13 = var1.n;
        LinkedList var14 = new LinkedList();
        if (var8 == var11 && var9 == var12) {
            if (PathEngine.a) {
                Log.d("RustedWarfare", "no point pathing when start=end");
            }

            var14.clear();
            var14.add(new class_319(var11, var12));
            return var14;
        } else if (this.n.a.equals(MovementType.NONE)) {
            if (PathEngine.a) {
                Log.d("RustedWarfare", "no point pathing for none");
            }

            var14.clear();
            return var14;
        } else {
            int var15 = 0;
            short var16 = var11;
            short var17 = var12;
            short var18 = var13;
            short var20;
            short var22;
            short var23;
            int var25;
            int var26;
            if (this.e != null) {
                short[] var19 = this.e;
                var20 = var19[var8 * var6 + var9];
                boolean var21 = true;
                if (var20 == -1) {
                    var21 = false;
                } else {
                    for(var22 = (short)(var11 - var13); var22 <= var11 + var13; ++var22) {
                        for(var23 = (short)(var12 - var13); var23 <= var12 + var13; ++var23) {
                            if (var22 >= 0 && var22 < var7 && var23 >= 0 && var23 < var6 && var20 == var19[var22 * var6 + var23]) {
                                var21 = false;
                            }
                        }
                    }
                }

                if (var21) {
                    if (PathEngine.a) {
                        Log.d("RustedWarfare", "end is blocked on isolated groups");
                    }

                    var22 = var11;
                    var23 = var12;
                    float var24 = -1.0F;

                    float var27;
                    for(var25 = (short)(var11 - 25); var25 <= var11 + 25; var25 = (short)(var25 + 1)) {
                        for(var26 = (short)(var12 - 25); var26 <= var12 + 25; var26 = (short)(var26 + 1)) {
                            if (var25 >= 0 && var25 < var7 && var26 >= 0 && var26 < var6 && (var20 == var19[var25 * var6 + var26] || var19[var25 * var6 + var26] == 0)) {
                                var27 = class_340.a((float)var25, (float)var26, (float)var11, (float)var12);
                                if (var24 == -1.0F || var27 < var24) {
                                    var24 = var27;
                                    var22 = (short)var25;
                                    var23 = (short)var26;
                                    var18 = 0;
                                }
                            }
                        }
                    }

                    if (var24 == -1.0F) {
                        for(var25 = 0; var25 < var7; var25 = (short)(var25 + 1)) {
                            for(var26 = 0; var26 < var6; var26 = (short)(var26 + 1)) {
                                if (var20 == var19[var25 * var6 + var26] || var19[var25 * var6 + var26] == 0) {
                                    var27 = class_340.a((float)var25, (float)var26, (float)var11, (float)var12);
                                    if (var24 == -1.0F || var27 < var24) {
                                        var24 = var27;
                                        var22 = (short)var25;
                                        var23 = (short)var26;
                                        var18 = 0;
                                    }
                                }
                            }
                        }
                    }

                    var16 = var22;
                    var17 = var23;
                    if (PathEngine.a) {
                        long var50 = System.currentTimeMillis() - this.y;
                        Log.d("RustedWarfare", "fakeNode search was:" + var50);
                    }
                }
            }

            boolean var44 = true;

            short var46;
            label515:
            for(var20 = (short)(var16 - var18); var20 <= var16 + var18; ++var20) {
                for(var46 = (short)(var17 - var18); var46 <= var17 + var18; ++var46) {
                    if (var20 >= 0 && var20 < var7 && var46 >= 0 && var46 < var6 && this.a(var20, var46) != -1) {
                        var44 = false;
                        break label515;
                    }
                }
            }

            short var48;
            if (var44) {
                var20 = var16;
                var46 = var17;
                float var47 = -1.0F;
                if (PathEngine.a) {
                    Log.d("RustedWarfare", "end is blocked on non isolated groups");
                }

                float var51;
                for(var23 = (short)(var16 - 9); var23 <= var16 + 9; ++var23) {
                    for(var48 = (short)(var17 - 9); var48 <= var17 + 9; ++var48) {
                        if (var23 >= 0 && var23 < var7 && var48 >= 0 && var48 < var6 && this.a(var23, var48) != -1) {
                            var51 = class_340.a((float)var23, (float)var48, (float)var16, (float)var17);
                            if (var47 == -1.0F || var51 < var47) {
                                var47 = var51;
                                var20 = var23;
                                var46 = var48;
                                var18 = 0;
                            }
                        }
                    }
                }

                if (var47 == -1.0F) {
                    for(var23 = 0; var23 < var7; ++var23) {
                        for(var48 = 0; var48 < var6; ++var48) {
                            if (this.a(var23, var48) != -1) {
                                var51 = class_340.a((float)var23, (float)var48, (float)var16, (float)var17);
                                if (var47 == -1.0F || var51 < var47) {
                                    var47 = var51;
                                    var20 = var23;
                                    var46 = var48;
                                    var18 = 0;
                                }
                            }
                        }
                    }
                }

                var16 = var20;
                var17 = var46;
                if (PathEngine.a) {
                    long var49 = System.currentTimeMillis() - this.y;
                    Log.d("RustedWarfare", "fakeNode search was:" + var49);
                }
            }

            if (PathEngine.a && (var16 != var11 || var17 != var12)) {
                Log.d("RustedWarfare", "Moved end to fakeEndX:" + var16 + " fakeEndY:" + var17);
            }

            this.o.a(var16, var17);
            this.o.a(0, var8, var9);
            this.p.a(var8, var9);
            this.a(var16, var17, var18);
            this.p.a(0, var16, var17);
            var44 = false;
            boolean var45 = false;
            var46 = -1;
            var22 = -1;
            var23 = -1;
            var48 = -1;
            var25 = 400;
            var26 = 0;

            label444:
            while(true) {
                if (!var44) {
                    ++var26;
                    if (var1.w) {
                        var14.clear();
                        return var14;
                    }

                    ++var15;
                    if (var25 > 0) {
                        --var25;
                    } else {
                        var45 = !var45;
                    }

                    byte var52 = 0;
                    if (var45) {
                        var52 = 1;
                    }

                    class_315 var29;
                    if (!var45) {
                        var29 = this.o;
                    } else {
                        var29 = this.p;
                    }

                    class_322 var30 = var29.c();
                    if (var30 == null) {
                        if (var45) {
                            continue;
                        }

                        if (PathEngine.a) {
                            Log.d("RustedWarfare", "listNode==null for normal side ending path");
                        }
                    } else {
                        class_319 var28 = var5.a(var30);
                        int var31 = var28.a(this, var52);
                        byte var32 = var28.c(this, var52);
                        boolean var33 = var28.d(this, var52);
                        boolean var34 = false;
                        if (!var45) {
                            if (var28.a == var16 && var28.b == var17) {
                                if (PathEngine.a) {
                                    Log.d("RustedWarfare", "Over goal: fakeEnd");
                                }

                                var34 = true;
                            }

                            if (class_340.d(var28.a - var11) <= var13 && class_340.d(var28.b - var12) <= var13) {
                                if (PathEngine.a) {
                                    Log.d("RustedWarfare", "Over goal: real end");
                                }

                                var34 = true;
                            }
                        }

                        boolean var35 = var28.b(this, (byte)(1 - var52));
                        if (!var35 && !var34) {
                            var28.a(this, var52, true);
                            boolean var62 = false;
                            boolean var37 = true;
                            byte var63;
                            byte var64;
                            if (var33) {
                                var63 = 0;
                                var64 = 7;
                            } else {
                                byte var38 = 2;
                                if (this.f != null && this.f[var28.a * var6 + var28.b] > 1) {
                                    var38 = 1;
                                }

                                var63 = (byte)(var32 - var38);
                                var64 = (byte)(var32 + var38);
                            }

                            byte var65 = var63;

                            while(true) {
                                if (var65 > var64) {
                                    continue label444;
                                }

                                var4.a(var28);
                                byte var39 = var65;
                                if (var65 > 7) {
                                    var39 = (byte)(var65 - 8);
                                }

                                if (var39 < 0) {
                                    var39 = (byte)(var39 + 8);
                                }

                                if (var39 == 0) {
                                    ++var4.a;
                                }

                                if (var39 == 1) {
                                    ++var4.a;
                                    ++var4.b;
                                }

                                if (var39 == 2) {
                                    ++var4.b;
                                }

                                if (var39 == 3) {
                                    ++var4.b;
                                    --var4.a;
                                }

                                if (var39 == 4) {
                                    --var4.a;
                                }

                                if (var39 == 5) {
                                    --var4.a;
                                    --var4.b;
                                }

                                if (var39 == 6) {
                                    --var4.b;
                                }

                                if (var39 == 7) {
                                    --var4.b;
                                    ++var4.a;
                                }

                                if (var4.a >= 0 && var4.a < var7 && var4.b >= 0 && var4.b < var6) {
                                    int var40 = var4.a(this);
                                    if (var40 != -1) {
                                        int var41 = var4.a(this, var52);
                                        if (!var4.b(this, var52)) {
                                            label657: {
                                                int var42;
                                                if (var4.a != var28.a && var4.b != var28.b) {
                                                    if (this.a(var4.a, var28.b) == -1 || this.a(var28.a, var4.b) == -1) {
                                                        break label657;
                                                    }

                                                    var42 = var31 + 14 + var40 + 1;
                                                } else {
                                                    var42 = var31 + 10 + var40 + 1;
                                                }

                                                if (var32 != var39) {
                                                    if (!var33) {
                                                        var42 += b(var32, var39);
                                                    } else if (!var45) {
                                                        if (var10) {
                                                            var42 += c(var32, var39);
                                                        } else {
                                                            var42 += b(var32, var39);
                                                        }
                                                    }
                                                }

                                                if (this.f != null) {
                                                    var42 += (4 - this.f[var4.a * var6 + var4.b]) * var2;
                                                }

                                                if (var3 > 0 && this.f != null) {
                                                    byte var43 = this.f[var4.a * var6 + var4.b];
                                                    if (var43 <= var3) {
                                                        var42 += 100;
                                                    }
                                                }

                                                if (var41 < this.i || var42 < var41) {
                                                    var4.a(this, var52, var39);
                                                    var4.a(this, var52, false);
                                                    var4.a(this, var52, var42);
                                                    var29.a(var42 - this.i, var4.a, var4.b);
                                                }
                                            }
                                        }
                                    }
                                }

                                ++var65;
                            }
                        }

                        var4.a(var28);
                        if (!var35) {
                            if (PathEngine.a) {
                                Log.d("RustedWarfare", "Not closedOnOtherSide");
                            }

                            var46 = var5.a;
                            var22 = var5.b;
                            var44 = true;
                        } else {
                            class_319 var36 = var4.f(this, var52);
                            if (var36 == null) {
                                Log.d("RustedWarfare", "findPath: otherConnection==null");
                                Log.d("RustedWarfare", "currentNode:" + var5.a + "," + var5.b);
                                Log.d("RustedWarfare", "currentNode cost normal:" + var5.a(this, (byte)0));
                                Log.d("RustedWarfare", "currentNode cost opposite:" + var5.a(this, (byte)1));
                                var14.clear();
                                return var14;
                            }

                            if (!var45) {
                                if (PathEngine.a) {
                                    Log.d("RustedWarfare", "closing path runFromOppositeSide=false");
                                }

                                var23 = var5.a;
                                var48 = var5.b;
                                var46 = var36.a;
                                var22 = var36.b;
                            } else {
                                if (PathEngine.a) {
                                    Log.d("RustedWarfare", "closing path runFromOppositeSide=true");
                                }

                                var23 = var36.a;
                                var48 = var36.b;
                                var46 = var5.a;
                                var22 = var5.b;
                            }

                            var44 = true;
                        }
                    }
                }

                long var53;
                if (PathEngine.a) {
                    Log.d("RustedWarfare", "grid path finshed in :" + var26 + " ticks");
                    var53 = System.currentTimeMillis() - this.y;
                    Log.d("RustedWarfare", "grid path done in:" + var53);
                }

                var53 = System.currentTimeMillis();
                long var54;
                if (!var44) {
                    if (PathEngine.a) {
                        Log.d("RustedWarfare", "could not find end node");
                    }

                    var54 = System.currentTimeMillis();
                    float var56 = -1.0F;
                    class_319 var57 = new class_319();

                    for(short var58 = 0; var58 < var7; ++var58) {
                        for(short var60 = 0; var60 < var6; ++var60) {
                            var57.a(var58, var60);
                            if (var57.e(this, (byte)0)) {
                                float var61 = class_340.a((float)var58, (float)var60, (float)var11, (float)var12);
                                if (var56 == -1.0F || var61 < var56) {
                                    var56 = var61;
                                    var46 = var58;
                                    var22 = var60;
                                }
                            }
                        }
                    }

                    if (PathEngine.a) {
                        long var59 = System.currentTimeMillis() - var54;
                        Log.d("RustedWarfare", "got closest node in:" + var59);
                    }
                }

                var14.clear();
                LinkedList var55;
                if (var46 != -1 && var22 != -1) {
                    var55 = this.a((byte)0, var46, var22);
                    var14.addAll(this.a(var55));
                }

                if (var23 != -1 && var48 != -1) {
                    var55 = this.a((byte)1, var23, var48);
                    var14.addAll(var55);
                }

                if (var14.size() > 1) {
                    var14.remove(0);
                }

                this.z = GameEngine.millis();
                if (PathEngine.a) {
                    var54 = this.z - this.y;
                    Log.d("RustedWarfare", "path(" + var1.e + ") finished in:" + var54);
                }

                if (PathEngine.l && !GameEngine.getGameEngine().bH) {
                    Debug.stopMethodTracing();
                    PathEngine.l = false;
                }

                return var14;
            }
        }
    }

    public strictfp LinkedList a(byte var1, short var2, short var3) {
        LinkedList var4 = new LinkedList();
        class_319 var5 = new class_319(var2, var3);
        var4.add(var5);

        while(true) {
            class_319 var6 = var5.f(this, var1);
            if (var6 == null) {
                return var4;
            }

            var4.add(var6);
            var5 = var6;
        }
    }

    public strictfp LinkedList a(LinkedList var1) {
        LinkedList var2 = new LinkedList();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            class_319 var4 = (class_319)var3.next();
            var2.addFirst(var4);
        }

        return var2;
    }

    public strictfp void f() {
        this.g();
    }

    public strictfp void g() {
        class_225 var1 = (class_225)this.D;
        class_301 var2 = new class_301(this.g, this.h);
        if (PathEngine.l && !GameEngine.getGameEngine().bH) {
            Debug.startMethodTracing("pathTrace", 110000000);
        }

        byte var3 = 7;
        byte var4 = 0;
        if (PathEngine.a) {
            Log.d("RustedWarfare", "starting path for:" + this.n.a.toString());
        }

        class_319 var5 = this.r;
        class_319 var6 = this.q;
        int var7 = this.h;
        int var8 = this.g;
        this.y = GameEngine.millis();
        short var9 = var1.h;
        short var10 = var1.i;
        boolean var11 = var1.k;
        this.d();
        this.a(var1.o, var1.h, var1.i, var1.j);
        short var12 = var1.l;
        short var13 = var1.m;
        short var14 = var1.n;
        new LinkedList();
        if (this.n.a.equals(MovementType.NONE)) {
            if (PathEngine.a) {
                Log.d("RustedWarfare", "no point pathing for none");
            }

        } else {
            int var16 = 0;
            short var17 = var12;
            short var18 = var13;
            short var19 = var14;
            short var21;
            boolean var22;
            short var24;
            int var26;
            if (this.e != null) {
                short[] var20 = this.e;
                var21 = var20[var9 * var7 + var10];
                var22 = true;
                short var23;
                if (var21 == -1) {
                    var22 = false;
                } else {
                    for(var23 = (short)(var12 - var14); var23 <= var12 + var14; ++var23) {
                        for(var24 = (short)(var13 - var14); var24 <= var13 + var14; ++var24) {
                            if (var23 >= 0 && var23 < var8 && var24 >= 0 && var24 < var7 && var21 == var20[var23 * var7 + var24]) {
                                var22 = false;
                            }
                        }
                    }
                }

                if (var22) {
                    if (PathEngine.a) {
                        Log.d("RustedWarfare", "end is blocked on isolated groups");
                    }

                    var23 = var12;
                    var24 = var13;
                    float var25 = -1.0F;

                    short var27;
                    float var28;
                    for(var26 = (short)(var12 - 25); var26 <= var12 + 25; var26 = (short)(var26 + 1)) {
                        for(var27 = (short)(var13 - 25); var27 <= var13 + 25; ++var27) {
                            if (var26 >= 0 && var26 < var8 && var27 >= 0 && var27 < var7 && (var21 == var20[var26 * var7 + var27] || var20[var26 * var7 + var27] == 0)) {
                                var28 = class_340.a((float)var26, (float)var27, (float)var12, (float)var13);
                                if (var25 == -1.0F || var28 < var25) {
                                    var25 = var28;
                                    var23 = (short)var26;
                                    var24 = var27;
                                    var19 = 0;
                                }
                            }
                        }
                    }

                    if (var25 == -1.0F) {
                        for(var26 = 0; var26 < var8; var26 = (short)(var26 + 1)) {
                            for(var27 = 0; var27 < var7; ++var27) {
                                if (var21 == var20[var26 * var7 + var27] || var20[var26 * var7 + var27] == 0) {
                                    var28 = class_340.a((float)var26, (float)var27, (float)var12, (float)var13);
                                    if (var25 == -1.0F || var28 < var25) {
                                        var25 = var28;
                                        var23 = (short)var26;
                                        var24 = var27;
                                        var19 = 0;
                                    }
                                }
                            }
                        }
                    }

                    var17 = var23;
                    var18 = var24;
                    if (PathEngine.a) {
                        long var52 = System.currentTimeMillis() - this.y;
                        Log.d("RustedWarfare", "fakeNode search was:" + var52);
                    }
                }
            }

            boolean var43 = true;

            short var45;
            label366:
            for(var21 = (short)(var17 - var19); var21 <= var17 + var19; ++var21) {
                for(var45 = (short)(var18 - var19); var45 <= var18 + var19; ++var45) {
                    if (var21 >= 0 && var21 < var8 && var45 >= 0 && var45 < var7 && this.a(var21, var45) != -1) {
                        var43 = false;
                        break label366;
                    }
                }
            }

            if (var43) {
                var21 = var17;
                var45 = var18;
                float var46 = -1.0F;
                if (PathEngine.a) {
                    Log.d("RustedWarfare", "end is blocked on non isolated groups");
                }

                short var48;
                float var53;
                for(var24 = (short)(var17 - 9); var24 <= var17 + 9; ++var24) {
                    for(var48 = (short)(var18 - 9); var48 <= var18 + 9; ++var48) {
                        if (var24 >= 0 && var24 < var8 && var48 >= 0 && var48 < var7 && this.a(var24, var48) != -1) {
                            var53 = class_340.a((float)var24, (float)var48, (float)var17, (float)var18);
                            if (var46 == -1.0F || var53 < var46) {
                                var46 = var53;
                                var21 = var24;
                                var45 = var48;
                                var19 = 0;
                            }
                        }
                    }
                }

                if (var46 == -1.0F) {
                    for(var24 = 0; var24 < var8; ++var24) {
                        for(var48 = 0; var48 < var7; ++var48) {
                            if (this.a(var24, var48) != -1) {
                                var53 = class_340.a((float)var24, (float)var48, (float)var17, (float)var18);
                                if (var46 == -1.0F || var53 < var46) {
                                    var46 = var53;
                                    var21 = var24;
                                    var45 = var48;
                                    var19 = 0;
                                }
                            }
                        }
                    }
                }

                var17 = var21;
                var18 = var45;
                if (PathEngine.a) {
                    long var49 = System.currentTimeMillis() - this.y;
                    Log.d("RustedWarfare", "fakeNode search was:" + var49);
                }
            }

            if (PathEngine.a && (var17 != var12 || var18 != var13)) {
                Log.d("RustedWarfare", "Moved end to fakeEndX:" + var17 + " fakeEndY:" + var18);
            }

            this.o.a(var17, var18);
            this.o.a(0, var9, var10);
            this.p.a(var9, var10);
            this.a(var17, var18, var19);
            this.p.a(0, var17, var18);
            var43 = false;
            boolean var44 = true;
            var22 = true;
            boolean var47 = true;
            boolean var50 = true;
            boolean var51 = true;
            var26 = 0;

            while(!var43) {
                ++var26;
                if (var1.w) {
                    return;
                }

                ++var16;
                boolean var54 = false;
                byte var55 = 1;
                class_315 var29 = this.p;
                class_322 var30 = var29.c();
                if (var30 == null) {
                    break;
                }

                class_319 var56 = var6.a(var30);
                int var31 = var56.a(this, var55);
                byte var32 = (byte)(var2.a(var56) - 1);
                boolean var33 = var2.b(var56);
                boolean var34 = false;
                var2.a(var56, true);
                boolean var35 = false;
                boolean var36 = true;
                byte var59;
                byte var60;
                if (var33) {
                    var59 = 0;
                    var60 = 7;
                } else {
                    byte var37 = 2;
                    if (this.f != null && this.f[var56.a * var7 + var56.b] > 1) {
                        var37 = 1;
                    }

                    var59 = (byte)(var32 - var37);
                    var60 = (byte)(var32 + var37);
                }

                for(byte var61 = var59; var61 <= var60; ++var61) {
                    var5.a(var56);
                    byte var38 = var61;
                    if (var61 > 7) {
                        var38 = (byte)(var61 - 8);
                    }

                    if (var38 < 0) {
                        var38 = (byte)(var38 + 8);
                    }

                    if (var38 == 0) {
                        ++var5.a;
                    }

                    if (var38 == 1) {
                        ++var5.a;
                        ++var5.b;
                    }

                    if (var38 == 2) {
                        ++var5.b;
                    }

                    if (var38 == 3) {
                        ++var5.b;
                        --var5.a;
                    }

                    if (var38 == 4) {
                        --var5.a;
                    }

                    if (var38 == 5) {
                        --var5.a;
                        --var5.b;
                    }

                    if (var38 == 6) {
                        --var5.b;
                    }

                    if (var38 == 7) {
                        --var5.b;
                        ++var5.a;
                    }

                    if (var5.a >= 0 && var5.a < var8 && var5.b >= 0 && var5.b < var7) {
                        int var39 = var5.a(this);
                        if (var39 != -1) {
                            int var40 = var5.a(this, var55);
                            if (!var2.c(var5)) {
                                int var41;
                                if (var5.a != var56.a && var5.b != var56.b) {
                                    if (this.a(var5.a, var56.b) == -1 || this.a(var56.a, var5.b) == -1) {
                                        continue;
                                    }

                                    var41 = var31 + 14 + var39 + 1;
                                } else {
                                    var41 = var31 + 10 + var39 + 1;
                                }

                                if (var32 != var38 && !var33) {
                                    var41 += b(var32, var38);
                                }

                                if (this.f != null) {
                                    var41 += (4 - this.f[var5.a * var7 + var5.b]) * var3;
                                }

                                if (var4 > 0 && this.f != null) {
                                    byte var42 = this.f[var5.a * var7 + var5.b];
                                    if (var42 <= var4) {
                                        var41 += 100;
                                    }
                                }

                                if (var40 < this.i || var41 < var40) {
                                    var2.a(var5, (byte)(var38 + 1));
                                    var2.a(var5, false);
                                    var5.a(this, var55, var41);
                                    var29.a(var41 - this.i, var5.a, var5.b);
                                }
                            }
                        }
                    }
                }
            }

            long var57;
            if (PathEngine.a) {
                Log.d("RustedWarfare", "grid path finshed in :" + var26 + " ticks");
                var57 = System.currentTimeMillis() - this.y;
                Log.d("RustedWarfare", "grid path done in:" + var57);
            }

            var57 = System.currentTimeMillis();
            var2.c = var17;
            var2.d = var18;
            var1.b = var2;
            PathEngine.e = var1;
            this.z = GameEngine.millis();
            if (PathEngine.a) {
                long var58 = this.z - this.y;
                Log.d("RustedWarfare", "path(" + var1.e + ") finished in:" + var58);
            }

            if (PathEngine.l && !GameEngine.getGameEngine().bH) {
                Debug.stopMethodTracing();
                PathEngine.l = false;
            }

        }
    }

    static {
        t.add(new class_319((short)-9, (short)-9));
        t.add(new class_319((short)-9, (short)-9));
        t.add(new class_319((short)-9, (short)-9));
        u = 0;
    }
}
