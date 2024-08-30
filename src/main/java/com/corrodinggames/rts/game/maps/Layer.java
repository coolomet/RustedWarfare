package com.corrodinggames.rts.game.maps;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import lombok.SneakyThrows;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public strictfp class Layer {
    private static byte[] x = new byte[256];
    static class_525 a;
    static class_525[] b;
    static class_525 c;
    static class_525 d;
    static class_525 e;
    static class_525 f;
    static class_525 g;
    static class_525[] h;
    public class_484 i;
    public int j;
    public String k;
    public String l;
    public boolean m;
    public int n;
    public int o;
    public Properties p;
    public short[] q;
    public boolean r;
    public boolean s;
    final Rect t = new Rect();
    final Rect u = new Rect();
    final RectF v = new RectF();
    public boolean w;

    public final class_482 a(int var1, int var2) {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }

        return this.i.a(this.q[var1 * this.o + var2]);
    }

    public short[] a() {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }

        return this.q;
    }

    public void a(int var1, int var2, class_482 var3, boolean var4) {
        if (this.q == null) {
            this.q = new short[this.n * this.o];
        }

        if (var3 == null) {
            this.q[var1 * this.o + var2] = 0;
        } else {
            if (var4) {
                var3 = this.i.a(var3, var1, var2);
            }

            if (var3.i) {
                boolean var5 = false;
                Iterator var6 = this.i.A.iterator();

                while(var6.hasNext()) {
                    Point var7 = (Point)var6.next();
                    if (var7.a == var1 && var7.b == var2) {
                        GameEngine.log("resPools point:" + var1 + ", " + var2 + " already exists");
                        var5 = true;
                    }
                }

                if (!var5) {
                    this.i.A.add(new Point(var1, var2));
                }
            }

            if (var3.d == -1) {
                var3.d = this.i.a(var3);
            }

            this.q[var1 * this.o + var2] = var3.d;
        }
    }

    public void a(class_28 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, boolean var10, boolean var11, boolean var12) {
        GameEngine var13 = GameEngine.getGameEngine();
        class_484 var14 = this.i;
        int var15 = (int)(var4 * var14.r);
        if (var15 < 0) {
            var15 = 0;
        }

        int var16 = (int)(var5 * var14.s);
        if (var16 < 0) {
            var16 = 0;
        }

        int var17 = (int)((var4 + var6) * var14.r);
        if (var17 > this.n - 1) {
            var17 = this.n - 1;
        }

        int var18 = (int)((var5 + var7) * var14.s);
        if (var18 > this.o - 1) {
            var18 = this.o - 1;
        }

        byte[][] var19 = var13.playerTeam.N;
        float var20 = var2 * var8;
        float var21 = var3 * var9;
        float var22 = (float)var14.n * var8;
        float var23 = (float)var14.o * var9;
        boolean var24 = true;
        byte var25 = 15;
        if (!var11) {
            var25 = 10;
        }

        boolean var26 = var14.G;
        if (var26) {
            var25 = 15;
        }

        if (var10 && var19 == null) {
            var10 = false;
        }

        class_525 var27 = b[5];
        class_525 var28 = a;
        class_525 var29 = c;
        var29.c(255);
        if (var26) {
            var28 = b[7];
            float var30 = 1.0F - (1.0F - (float)var27.f() / 255.0F) * (1.0F - (float)var28.f() / 255.0F);
            var29.c((int)(var30 * 255.0F));
        }

        boolean var59 = false;
        if (GameEngine.av() && var8 < 1.0F && var9 < 1.0F) {
            var59 = true;
        }

        if (var12) {
        }

        class_525 var31;
        if (!this.r) {
            var31 = f;
            if (var59) {
                var31 = g;
            }
        } else {
            var31 = d;
            if (var59) {
                var31 = e;
            }
        }

        class_525 var32 = var31;
        float var33 = 0.0F;
        float var34 = 0.0F;
        boolean var35 = false;
        if (!GameEngine.av()) {
            var35 = true;
        } else if (!var12) {
            if (var8 < 1.0F || var9 < 1.0F) {
                var33 = 0.5F * var8;
            }
        } else if (!(var8 < 1.0F) && var9 < 1.0F) {
        }

        class_483 var36;
        if (var8 < 0.5F) {
            var36 = class_484.m;
        } else {
            var36 = class_484.l;
        }

        short[] var37 = this.a();
        class_482[] var38 = var14.B;
        RectF var39 = this.v;
        Rect var40 = this.u;
        int var41 = this.o;
        boolean var42 = this.r;
        Rect var43 = this.t;
        var14.l();
        byte[][] var44 = var14.M;
        byte[][] var45 = var14.N;
        TeamImageCache var46 = class_484.K;

        for(int var47 = var15; var47 < var17 + 1; ++var47) {
            for(int var48 = var16; var48 < var18 + 1; ++var48) {
                short var49 = var37[var47 * var41 + var48];
                class_482 var50 = var38[var49];
                if (var50 != null) {
                    byte var51 = 0;
                    if (var10) {
                        var51 = var19[var47][var48];
                    }

                    if (var51 != var25) {
                        float var52 = (float)var47 * var22 + var34;
                        float var53 = (float)var48 * var23 + var34;
                        float var54 = (float)(var47 + 1) * var22 + var33;
                        float var55 = (float)(var48 + 1) * var23 + var33;
                        var39.a(var52 - var20, var53 - var21, var54 - var20, var55 - var21);
                        if (var59 && !var12) {
                            var39.b = (float)((int)var39.b);
                            var39.a = (float)((int)var39.a);
                        }

                        if (!var12) {
                            TileSet var56 = var50.a;
                            Rect var57;
                            TeamImageCache var58;
                            if (!var35) {
                                if (var50.c >= 0) {
                                    var57 = var36.b(var50.c);
                                    var58 = var36.a(var50.c);
                                    var1.a(var58, var57, (RectF)var39, var32);
                                } else {
                                    var50.a(var1, var39, var8, var32);
                                }
                            } else {
                                var40.a((int)(var52 - var20), (int)(var53 - var21), (int)(var54 - var20), (int)(var55 - var21));
                                if (var50.c >= 0) {
                                    var57 = var36.b(var50.c);
                                    var58 = var36.a(var50.c);
                                    var1.b(var58, var57, var40, var32);
                                } else {
                                    var57 = var56.b(var50.b);
                                    var1.a(var56.b, var57, (Rect)var40, var32);
                                }
                            }
                        }

                        if (var10 && var42 && var11 && (var51 != 0 || var45[var47][var48] != 0 || var44[var47][var48] != 0)) {
                            int var62;
                            byte var63;
                            if (var51 >= 5) {
                                if (var12 && (var51 == 10 || var44[var47][var48] == 0)) {
                                    int var60;
                                    for(var60 = var48 + 1; var60 < var18; ++var60) {
                                        var62 = var19[var47][var60];
                                        if (var51 != var62 || var51 != 10 && var44[var47][var60] != 0) {
                                            break;
                                        }
                                    }

                                    --var60;
                                    if (var60 > var48) {
                                        var39.d += (float)(var60 - var48) * var23;
                                        var48 = var60;
                                    }
                                }

                                class_525 var61;
                                if (var51 == 10) {
                                    var61 = var29;
                                } else {
                                    var61 = var27;
                                }

                                var40.a = (int)var39.a;
                                var40.c = (int)var39.c;
                                var40.b = (int)var39.b;
                                var40.d = (int)var39.d;
                                var1.a((Rect)var40, (Paint)var61);
                            } else {
                                var63 = var45[var47][var48];
                                if (var63 == 127) {
                                    var63 = var14.a(var47, var48, var19, (byte)5);
                                    var45[var47][var48] = var63;
                                }

                                if (var63 != 0) {
                                    var62 = var63 + 128;
                                    if (var46 != null) {
                                        class_484.a(var62, var43);
                                        var40.a((int)(var52 - var20), (int)(var53 - var21), (int)(var54 - var20), (int)(var55 - var21));
                                        var1.b(var46, var43, var40, var27);
                                    } else if (!var14.k[var63 + 128]) {
                                        GameEngine.log("SmoothFog, missing: " + var63);
                                        var14.k[var63 + 128] = true;
                                    }
                                }
                            }

                            if (var51 != 10) {
                                var63 = var44[var47][var48];
                                if (var63 == 127) {
                                    var63 = var14.a(var47, var48, var19, (byte)10);
                                    var44[var47][var48] = var63;
                                }

                                if (var63 != 0) {
                                    var62 = var63 + 128;
                                    if (var46 != null) {
                                        class_484.a(var62, var43);
                                        var40.a((int)(var52 - var20), (int)(var53 - var21), (int)(var54 - var20), (int)(var55 - var21));
                                        var1.b(var46, var43, var40, var28);
                                    } else if (!var14.k[var63 + 128]) {
                                        GameEngine.log("SmoothFog, missing: " + var63);
                                        var14.k[var63 + 128] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void b() {
        this.q = null;
        this.p = null;
        this.i = null;
    }

    public Layer(class_484 var1, String var2, int var3, int var4) {
        this.i = var1;
        this.a(var2);
        this.n = var3;
        this.o = var4;
        this.a();
    }

    void a(String var1) {
        this.k = var1;
        Log.d("RustedWarfare", "MapLayer create: " + var1);
        if (var1 != null) {
            this.l = var1.toLowerCase(Locale.ENGLISH);
        }

        this.m = this.l.contains("items");
        this.r = this.l.equalsIgnoreCase("ground");
        if (this.m || this.r) {
            this.s = true;
        }

        if (var1 != null && var1.equalsIgnoreCase("grounddetails")) {
            this.s = true;
        }

    }

    @SneakyThrows
    public Layer(class_484 var1, Element var2) {
        this.i = var1;
        this.a(var2.getAttribute("name"));
        this.n = Short.parseShort(var2.getAttribute("width"));
        this.o = Short.parseShort(var2.getAttribute("height"));
        Element var3 = (Element)var2.getElementsByTagName("properties").item(0);
        String var8;
        if (var3 != null) {
            NodeList var4 = var3.getElementsByTagName("property");
            if (var4 != null) {
                this.p = new Properties();

                for(int var5 = 0; var5 < var4.getLength(); ++var5) {
                    Element var6 = (Element)var4.item(var5);
                    String var7 = var6.getAttribute("name");
                    var8 = var6.getAttribute("value");
                    this.p.setProperty(var7, var8);
                }
            }
        }

        Element var12 = (Element)var2.getElementsByTagName("data").item(0);
        if (var12 == null) {
            throw new MapException("Map is missing <data> element");
        } else {
            String var13 = var12.getAttribute("encoding");
            String var14 = var12.getAttribute("compression");

            try {
                Node var15 = var12.getFirstChild();
                var8 = var15.getNodeValue();
                InputStream var9 = a(var8, var13, var14);
                BufferedInputStream var10 = new BufferedInputStream(var9);
                this.a((InputStream)var10);
                if (var10 != null) {
                    var10.close();
                }

                if (var9 != null) {
                    var9.close();
                }

            } catch (IOException var11) {
                throw new MapException("Unable to decompress base64 block", var11);
            }
        }
    }

    @SneakyThrows
    void a(InputStream var1) {
        class_484 var2 = this.i;
        class_482 var3 = null;
        int var4 = -1;
        boolean var5 = this.s;
        HashMap var6 = new HashMap();

        for(short var7 = 0; var7 < this.o; ++var7) {
            for(short var8 = 0; var8 < this.n; ++var8) {
                int var9 = 0;
                var9 |= var1.read();
                var9 |= var1.read() << 8;
                var9 |= var1.read() << 16;
                var9 |= var1.read() << 24;
                boolean var10 = (var9 & Integer.MIN_VALUE) != 0;
                boolean var11 = (var9 & 1073741824) != 0;
                boolean var12 = (var9 & 536870912) != 0;
                var9 &= 536870911;
                if (!var10 && !var11 && var12) {
                }

                if (var9 != 0) {
                    if (var4 == var9 && var3 != null) {
                        this.a(var8, var7, var3, true);
                    } else {
                        class_482 var13 = (class_482)var6.get(var9);
                        if (var13 != null) {
                            var3 = var13;
                            var4 = var9;
                            this.a(var8, var7, var13, true);
                        } else {
                            TileSet var14 = var2.a(var9);
                            if (var14 == null) {
                                throw new MapException("Unable to decode base64 block, could not find tileId: " + var9);
                            }

                            var3 = class_482.a(var2, this, var14, var9 - var14.l, var8, var7, var5);
                            if (var3 != null) {
                                this.a(var8, var7, var3, true);
                                var6.put(var9, var3);
                            }

                            var4 = var9;
                        }
                    }
                }
            }
        }

    }

    @SneakyThrows
    public static InputStream a(String var0, String var1, String var2) {
        if (var1.equals("base64")) {
            char[] var4 = var0.toCharArray();
            byte[] var3 = a(var4);
            Object var7;
            if ("gzip".equals(var2)) {
                try {
                    GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var3));
                    var7 = var5;
                } catch (IOException var6) {
                    throw new MapException("Unable to decode block in map", var6);
                }
            } else if ("".equals(var2)) {
                var7 = new ByteArrayInputStream(var3);
            } else {
                if (!"zlib".equals(var2)) {
                    throw new MapException("Unsupport tiled map compression: " + var1 + "," + var2 + " (only gzip base64 is supported, this can be set in Tiled's Preferences)");
                }

                InflaterInputStream var8 = new InflaterInputStream(new ByteArrayInputStream(var3));
                var7 = var8;
            }

            return (InputStream)var7;
        } else {
            throw new MapException("Unsupport tiled map encoding: " + var1 + "," + var2 + " (only gzip base64 is supported, this can be set in Tiled's Preferences)");
        }
    }

    public static byte[] a(char[] var0) {
        int var1 = var0.length;
        byte[] var2 = x;

        int var3;
        for(var3 = 0; var3 < var0.length; ++var3) {
            if (var0[var3] > 255 || var2[var0[var3]] < 0) {
                --var1;
            }
        }

        var3 = var1 / 4 * 3;
        if (var1 % 4 == 3) {
            var3 += 2;
        }

        if (var1 % 4 == 2) {
            ++var3;
        }

        byte[] var4 = new byte[var3];
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        for(int var8 = 0; var8 < var0.length; ++var8) {
            byte var9 = var0[var8] > 255 ? -1 : var2[var0[var8]];
            if (var9 >= 0) {
                var6 <<= 6;
                var5 += 6;
                var6 |= var9;
                if (var5 >= 8) {
                    var5 -= 8;
                    var4[var7++] = (byte)(var6 >> var5 & 255);
                }
            }
        }

        if (var7 != var4.length) {
            throw new RuntimeException("Data length appears to be wrong (wrote " + var7 + " should be " + var4.length + ")");
        } else {
            return var4;
        }
    }

    static {
        int var0;
        for(var0 = 0; var0 < 256; ++var0) {
            x[var0] = -1;
        }

        for(var0 = 65; var0 <= 90; ++var0) {
            x[var0] = (byte)(var0 - 65);
        }

        for(var0 = 97; var0 <= 122; ++var0) {
            x[var0] = (byte)(26 + var0 - 97);
        }

        for(var0 = 48; var0 <= 57; ++var0) {
            x[var0] = (byte)(52 + var0 - 48);
        }

        x[43] = 62;
        x[47] = 63;
        a = new class_525();
        a.b(-16777216);
        a.a((Paint$Style)Paint$Style.a);
        b = new class_525[11];

        for(var0 = 0; var0 <= 10; ++var0) {
            b[var0] = new class_525();
            b[var0].b(-16777216);
            b[var0].a((Paint$Style)Paint$Style.a);
            b[var0].c(var0 * 25);
        }

        c = new class_525();
        c.b(-16777216);
        c.a((Paint$Style)Paint$Style.a);
        d = new class_525();
        d.a(false);
        d.d(false);
        d.b(false);
        e = new class_525();
        e.a(true);
        f = new class_525();
        f.a(false);
        f.d(false);
        f.b(false);
        g = new class_525();
        g.a(true);
        h = new class_525[11];

        for(var0 = 0; var0 <= 10; ++var0) {
            class_525 var1 = new class_525();
            var1.a((ColorFilter)(new LightingColorFilter(Color.a(255 - var0 * 25, 255 - var0 * 25, 255 - var0 * 25), 0)));
            h[var0] = var1;
        }

    }
}
