package com.corrodinggames.rts.java;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint$Align;
import android.graphics.Paint$Style;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.PorterDuff.Mode;
import com.corrodinggames.rts.AssetsID$drawable;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_338;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.m.class_27;
import com.corrodinggames.rts.gameFramework.m.class_28;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;
import com.corrodinggames.rts.gameFramework.m.class_526;
import com.corrodinggames.rts.gameFramework.m.class_561;
import com.corrodinggames.rts.gameFramework.m.class_836;
import com.corrodinggames.rts.gameFramework.m.class_837;
import com.corrodinggames.rts.gameFramework.m.Shader;
import com.corrodinggames.rts.gameFramework.m.class_922;
import com.corrodinggames.rts.gameFramework.m.class_933;
import com.corrodinggames.rts.gameFramework.m.class_936;
import com.corrodinggames.rts.gameFramework.m.class_938;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

import lombok.SneakyThrows;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.GlyphPage;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.PNGImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.FastTrig;
import org.newdawn.slick.util.ResourceLoader;

// $FF: renamed from: com.corrodinggames.rts.java.e
public final strictfp class class_368 implements class_28 {
    public boolean a = true;
    public boolean b;
    public static final Color c = new Color(0, 0, 0, 255);
    public static final Color d = new Color(0, 0, 0, 255);
    public static final Color e = new Color(0, 0, 0, 255);
    public Graphics f;
    public TeamImageCache g;
    public int h;
    public int i;
    public class_836 j;
    public static Graphics k = null;
    static class_368 l = null;
    public static Shader m = null;
    private static SGL W = Renderer.get();
    final Rect n = new Rect();
    final Rect o = new Rect();
    final RectF p = new RectF();
    final PointF q = new PointF();
    public static class_372 r;
    public static class_372 s;
    public static class_372 t;
    ArrayList u = new ArrayList();
    int v = -1;
    Paint w = null;
    LoadImage x = null;
    boolean y;
    final Paint z = new Paint();
    public static final Color A = new Color(0, 0, 0, 255);
    static float B = -1.0F;
    class_377 C = new class_377(this);
    byte[] D = new byte[4];
    static ArrayList E = new ArrayList();
    int F = 0;
    RectF G = new RectF();
    static Paint H = new Paint();
    static Paint I = new class_525();
    static RectF J;
    static RectF K;
    public float L = 1.0F;
    static RectF M;
    FloatBuffer N = BufferUtils.createFloatBuffer(3);
    float[] O = new float[0];
    int P = -1;
    float Q;
    float R;
    float S;
    private static LineStripRenderer X;
    class_378 T = new class_378();
    class_684 U = new class_684();
    class_684 V = new class_684();

    public static void c() {
        W = Renderer.get();
    }

    public Color t() {
        return c;
    }

    public class_368 c(TeamImageCache var1) {
        class_368 var2 = this.d(var1);
        var2.j = this.j;
        return var2;
    }

    public class_368 d(TeamImageCache var1) {
        class_368 var2 = new class_368();
        LoadImage var3 = this.e(var1);

        try {
            var2.f = var3.C().getGraphics();
            var2.g = var1;
            if (var1 != null) {
                var2.h = var1.m();
                var2.i = var1.l();
            }

            return var2;
        } catch (SlickException var5) {
            throw new RuntimeException(var5);
        }
    }

    public int m() {
        if (this.g != null) {
            return this.h;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            return (int)var1.cl;
        }
    }

    public int n() {
        if (this.g != null) {
            return this.i;
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            return (int)var1.cm;
        }
    }

    public void a(int var1, int var2) {
        this.h = var1;
        this.i = var2;
    }

    public boolean a() {
        return false;
    }

    public void a(Context var1) {
    }

    public void b() {
        r = new class_372((LoadImage)this.a(AssetsID$drawable.error_outmem));
        r.a((String)"Out of memory");
        s = new class_372((LoadImage)this.a(AssetsID$drawable.error_general));
        s.a((String)"General Error");
        t = new class_372((LoadImage)this.a(AssetsID$drawable.error_toolargethumb));
        s.a((String)"Too Large Thumbnail Error");
        if (!GameEngine.aC) {
            this.j = new class_836(1024, 1024);
        }

    }

    public class_27 d() {
        return null;
    }

    public void a(class_27 var1) {
    }

    public void a(class_933 var1) {
    }

    public static boolean a(String var0) {
        for(int var1 = 0; var1 < var0.length(); ++var1) {
            int var2 = var0.codePointAt(var1);
            if (var2 > 255) {
                return true;
            }
        }

        return false;
    }

    Font a(class_377 var1, String var2, boolean var3) {
        class_377 var4 = this.a(var1, var3);
        if (var4.a(var2)) {
            return var4.d;
        } else {
            UnicodeFont var5 = (UnicodeFont)var4.d;
            int var6 = 0;

            GlyphPage var9;
            for(Iterator var7 = var5.getGlyphPages().iterator(); var7.hasNext(); var6 += var9.getGlyphs().size()) {
                Object var8 = var7.next();
                var9 = (GlyphPage)var8;
            }

            int var13;
            for(var13 = 0; var13 < var2.length(); ++var13) {
                var2.charAt(var13);
                boolean var15 = false;
                if (!var15) {
                }
            }

            var13 = var5.getGlyphPages().size();
            var5.addGlyphs(var2);

            try {
                var5.loadGlyphs();
            } catch (SlickException var12) {
                throw new RuntimeException(var12);
            }

            int var14 = 0;

            GlyphPage var11;
            for(Iterator var16 = var5.getGlyphPages().iterator(); var16.hasNext(); var14 += var11.getGlyphs().size()) {
                Object var10 = var16.next();
                var11 = (GlyphPage)var10;
            }

            int var17 = var5.getGlyphPages().size();
            if (var6 != var14) {
                GameEngine.log("new glypth, " + var14 + " " + var4.toString() + " for text:" + var2);
            }

            var4.b(var2);
            return var4.d;
        }
    }

    class_377 a(class_377 var1, boolean var2) {
        Iterator var3 = this.u.iterator();

        class_377 var4;
        do {
            if (!var3.hasNext()) {
                var1 = var1.a();
                GameEngine.log("New font:" + var1.a + " bold:" + var1.b);
                if (var2) {
                }

                String var13 = "font/Roboto-Regular.ttf";
                if (var1.b) {
                    var13 = "font/Roboto-Bold.ttf";
                }

                if (var1.c) {
                    var13 = "font/DroidSansFallback.ttf";
                }

                boolean var14 = false;

                java.awt.Font var5;
                try {
                    InputStream var6 = ResourceLoader.getResourceAsStream(var13);
                    var5 = java.awt.Font.createFont(0, var6);
                    var5 = var5.deriveFont((float)var1.a);
                } catch (IOException var11) {
                    throw new RuntimeException(var11);
                } catch (FontFormatException var12) {
                    throw new RuntimeException(var12);
                }

                UnicodeFont var15 = new UnicodeFont(var5);
                var15.addAsciiGlyphs();
                java.awt.Color var7 = new java.awt.Color(255, 255, 255);
                var15.getEffects().add(new ColorEffect(var7));

                try {
                    var15.loadGlyphs();
                } catch (OutOfMemoryError var9) {
                    GameEngine.a((class_338)class_338.GAME_IMAGE, (Throwable)var9);
                } catch (SlickException var10) {
                    throw new RuntimeException(var10);
                }

                GameEngine.log("loadGlyphs");
                var1.d = var15;
                this.u.add(var1);
                return var1;
            }

            var4 = (class_377)var3.next();
        } while(var4.a != var1.a || var4.b != var1.b || var4.c != var1.c);

        return var4;
    }

    public void a(Paint var1, String var2) {
        this.a(var1, true, var2, (LoadImage)null, (TeamImageCache)null);
    }

    public void b(Paint var1) {
        this.a(var1, false, (String)null, (LoadImage)null, (TeamImageCache)null);
    }

    public void a(Paint var1, LoadImage var2, TeamImageCache var3) {
        this.a(var1, false, (String)null, var2, var3);
    }

    public void u() {
        this.y();
        Graphics.setCurrent(this.f);
        this.b(true);
        this.b = true;
        B = -1.0F;
        Color.setRebindRequired();
        this.w = this.z;
        l = this;
    }

    public void a(Paint var1, boolean var2, String var3, LoadImage var4, TeamImageCache var5) {
        boolean var6 = false;
        if (k != this.f) {
            this.u();
            var6 = true;
            k = this.f;
        }

        boolean var8;
        if ((var1 == null || var1 instanceof class_525) && this.w == var1 && this.x == var4 && !var2) {
            Shader var7 = null;
            if (this.a) {
                if (var1 != null && var1 instanceof class_525) {
                    var7 = ((class_525)var1).q();
                }

                if (var5 != null && var7 == null) {
                    var7 = var5.B();
                }
            }

            if (m == var7) {
                if (m != null) {
                    var8 = m.a(var1, var5);
                    if (var8) {
                        this.f.flushBuffer();
                        this.b(m);
                    }
                }

                return;
            }
        }

        this.w = var1;
        this.x = var4;
        boolean var13 = var4 == null && !var2;
        if (this.v != Graphics.MODE_NORMAL) {
            this.v = Graphics.MODE_NORMAL;
            this.f.setDrawMode(this.v);
        }

        if (var6 && this.g != null) {
            W.glEnable(3042);
            W.glColorMask(true, true, true, true);
            GL14.glBlendFuncSeparate(770, 771, 770, 1);
        }

        if (var1 == null) {
            var8 = false;
            this.a(Color.white);
            if (var13) {
                this.a(1.0F);
            }

            if (var2) {
                this.f.resetFont();
            }
        } else {
            var8 = var1.c();
        }

        if (this.a) {
            Shader var9 = null;
            if (var1 != null && var1 instanceof class_525) {
                var9 = ((class_525)var1).q();
            }

            if (var5 != null && var9 == null) {
                var9 = var5.B();
            }

            boolean var10;
            if (m != var9) {
                this.f.flushBuffer();
                if (var9 == null) {
                    this.v();
                } else {
                    var9.f();
                    var10 = this.c(var9);
                    if (!var10) {
                        if (m != null) {
                            this.v();
                        }
                    } else {
                        var9.a(var1, var5);
                        this.b(var9);
                    }
                }

                m = var9;
            } else if (m != null) {
                var10 = m.a(var1, var5);
                if (var10) {
                    this.f.flushBuffer();
                    this.b(m);
                }
            }
        }

        boolean var14;
        if (var4 != null) {
            var14 = var4.E == 1;
            if (var14 != var8) {
                this.f.flushBuffer();
                int var15 = var8 ? 1 : 2;
                var4.C().setFilter(var15);
                var4.E = var15;
            }
        }

        if (var1 != null) {
            var14 = true;
            ColorFilter var16 = var1.h();
            if (var16 != null) {
                if (var16 instanceof LightingColorFilter) {
                    LightingColorFilter var11 = (LightingColorFilter)var16;
                    if (var11.a != 0 && var11.a != -1) {
                        int var12 = var11.a;
                        d.r = (float)android.graphics.Color.b(var12) * 0.003921569F;
                        d.g = (float)android.graphics.Color.c(var12) * 0.003921569F;
                        d.b = (float)android.graphics.Color.d(var12) * 0.003921569F;
                        d.a = (float)android.graphics.Color.a(var12) * 0.003921569F;
                        a(var1.e(), e);
                        Color var10000 = d;
                        var10000.r *= e.r;
                        var10000 = d;
                        var10000.g *= e.g;
                        var10000 = d;
                        var10000.b *= e.b;
                        var10000 = d;
                        var10000.a *= e.a;
                        this.a(d);
                        this.v = Graphics.MODE_ADD;
                        this.f.setDrawMode(this.v);
                        W.glEnable(3042);
                        W.glColorMask(true, true, true, true);
                        W.glBlendFunc(770, 1);
                        var14 = false;
                    }
                } else if (var16 instanceof class_561) {
                    class_561 var17 = (class_561)var16;
                    if (var17.a == class_922.COPY) {
                        this.f(var1.e());
                        this.v = 99;
                        W.glEnable(3042);
                        W.glColorMask(true, true, true, true);
                        W.glBlendFunc(1, 1);
                        var14 = false;
                    } else if (var17.a == class_922.ADDICTIVE) {
                        this.f(var1.e());
                        this.v = 99;
                        W.glEnable(3042);
                        W.glColorMask(true, true, true, true);
                        W.glBlendFunc(774, 771);
                        var14 = false;
                    }
                }
            }

            if (var14) {
                this.f(var1.e());
            }

            if (var13) {
                if (var1.g() != 0.0F) {
                    this.a(var1.g());
                } else {
                    this.a(1.0F);
                }
            }

            if (var2) {
                Font var18 = this.a(var1, var3, true);
                this.f.setFont(var18);
            }
        }

    }

    public void v() {
        GL20.glUseProgram(0);
    }

    public void b(Shader var1) {
        class_938[] var2 = var1.p;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_938 var5 = var2[var4];
            if (var5.c) {
                var5.c = false;
                int var8;
                if (var5.b == -1) {
                    var5.b = GL20.glGetUniformLocation(var1.n, var5.a);
                    if (var5.b == -1 && !var5.d) {
                        var5.d = true;
                        var1.b("Unknown parameter: " + var5.a);
                        int var10 = GL20.glGetProgrami(var1.n, 35718);
                        int var11 = GL20.glGetProgrami(var1.n, 35719);

                        for(var8 = 0; var8 < var10; ++var8) {
                            String var9 = GL20.glGetActiveUniform(var1.n, var8, var11);
                            var1.b("Possible parameter: " + var9);
                        }

                        return;
                    }
                }

                if (var5.f != null) {
                    LoadImage var6 = this.e(var5.f);
                    Texture var7 = var6.C().getTexture();
                    if (var5.g) {
                        GL20.glUniform2f(var5.b, (float)var7.getTextureWidth(), (float)var7.getTextureHeight());
                    } else {
                        var8 = var7.getTextureID();
                        var1.b("Updating texture to:" + var8);
                        GL20.glUniform1i(var5.b, 1);
                        GL13.glActiveTexture(33985);
                        GL11.glBindTexture(3553, var8);
                        GL13.glActiveTexture(33984);
                    }
                } else if (var5.e.length == 1) {
                    GL20.glUniform1f(var5.b, var5.e[0]);
                } else if (var5.e.length == 2) {
                    GL20.glUniform2f(var5.b, var5.e[0], var5.e[1]);
                } else if (var5.e.length == 4) {
                    GL20.glUniform4f(var5.b, var5.e[0], var5.e[1], var5.e[2], var5.e[3]);
                } else {
                    var1.b("Unhandled parameter size: " + var5.a + " - " + var5.e.length);
                }
            }
        }

    }

    public boolean c(Shader var1) {
        if (var1.o != 0) {
            return false;
        } else if (var1.n != 0 && !var1.m) {
            GL20.glUseProgram(var1.n);
            return true;
        } else {
            var1.m = false;
            var1.b("Compiling shader");
            var1.g = this.a(var1, 35633, var1.e);
            var1.h = this.a(var1, 35632, var1.f);
            if (var1.o != 0) {
                return false;
            } else {
                var1.n = GL20.glCreateProgram();
                if (var1.n == 0) {
                    var1.c("could not create program; check ShaderProgram.isSupported()");
                    return false;
                } else {
                    GL20.glAttachShader(var1.n, var1.g);
                    GL20.glAttachShader(var1.n, var1.h);
                    GL20.glLinkProgram(var1.n);
                    int var2 = GL20.glGetProgrami(var1.n, 35714);
                    int var3 = GL20.glGetProgrami(var1.n, 35716);
                    String var4 = GL20.glGetProgramInfoLog(var1.n, var3);
                    if (var4 != null && var4.length() != 0) {
                        var1.d = var4 + "\n" + var1.d;
                    }

                    if (var1.d != null) {
                        var1.d = var1.d.trim();
                    }

                    if (var2 == 0) {
                        var1.c(var1.d.length() != 0 ? var1.d : "Could not link program");
                        return false;
                    } else {
                        GL20.glUseProgram(var1.n);
                        return true;
                    }
                }
            }
        }
    }

    protected int a(Shader var1, int var2, String var3) {
        int var4 = GL20.glCreateShader(var2);
        if (var4 == 0) {
            var1.c("could not create shader object; check ShaderProgram.isSupported()");
        }

        GL20.glShaderSource(var4, var3);
        GL20.glCompileShader(var4);
        int var5 = GL20.glGetShaderi(var4, 35713);
        int var6 = GL20.glGetShaderi(var4, 35716);
        String var7 = this.e(var2);
        String var8 = GL20.glGetShaderInfoLog(var4, var6);
        if (var8 != null && var8.length() != 0) {
            var1.d = var1.d + var7 + " compile log:\n" + var8 + "\n";
        }

        if (var5 == 0) {
            var1.c(var1.d.length() != 0 ? var1.d : "Could not compile " + this.e(var2));
        }

        return var4;
    }

    private String e(int var1) {
        if (var1 == 35632) {
            return "FRAGMENT_SHADER";
        } else {
            return var1 == 35633 ? "VERTEX_SHADER" : "shader";
        }
    }

    private void f(int var1) {
        a(var1, A);
        this.a(A);
    }

    private void a(Color var1) {
        Color var2 = c;
        if (this.b) {
            this.b = false;
        } else if (var2.r == var1.r && var2.g == var1.g && var2.b == var1.b && var2.a == var1.a) {
            return;
        }

        var2.a = var1.a;
        var2.r = var1.r;
        var2.g = var1.g;
        var2.b = var1.b;
        this.f.setColor(var2);
    }

    public void a(float var1) {
        if (B != var1) {
            B = var1;
            this.f.setLineWidth(var1);
        }

    }

    public Font a(Paint var1, String var2, boolean var3) {
        class_377 var4 = this.C;
        var4.a = (int)var1.k();
        if (this.x()) {
            var4.a = (int)((float)var4.a * this.L);
        }

        Typeface var5 = var1.i();
        var4.b = false;
        if (var5 != null) {
            var4.b = var5.a();
        }

        var4.c = false;
        boolean var6 = a(var2);
        if (var6) {
            var4.c = true;
        }

        Font var7 = this.a(var4, var2, var3);
        return var7;
    }

    public static void a(org.newdawn.slick.opengl.ImageData var0, ByteBuffer var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = (var2 + var3 * var0.getTexWidth()) * var8;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            var1.put(var9, (byte)var6);
            var1.put(var9 + 1, (byte)var5);
            var1.put(var9 + 2, (byte)var4);
            var1.put(var9 + 3, (byte)var7);
        } else {
            var1.put(var9, (byte)var4);
            var1.put(var9 + 1, (byte)var5);
            var1.put(var9 + 2, (byte)var6);
            var1.put(var9 + 3, (byte)var7);
        }

    }

    public static int a(org.newdawn.slick.opengl.ImageData var0, ByteBuffer var1, int var2, int var3, int var4) {
        int var5 = (var2 + var3 * var0.getTexWidth()) * var4;
        if (var4 == 4) {
        }

        int var6;
        int var7;
        int var8;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            var8 = var1.get(var5) & 255;
            var7 = var1.get(var5 + 1) & 255;
            var6 = var1.get(var5 + 2) & 255;
        } else {
            var6 = var1.get(var5) & 255;
            var7 = var1.get(var5 + 1) & 255;
            var8 = var1.get(var5 + 2) & 255;
        }

        int var9;
        if (var4 < 4) {
            var9 = 255;
        } else {
            var9 = var1.get(var5 + 3) & 255;
        }

        return a(var9, var6, var7, var8);
    }

    public static final int a(int var0, int var1, int var2, int var3) {
        return var0 << 24 | var1 << 16 | var2 << 8 | var3;
    }

    public static Color a(int var0, Color var1) {
        var1.r = (float)(var0 >> 16 & 255) * 0.003921569F;
        var1.g = (float)(var0 >> 8 & 255) * 0.003921569F;
        var1.b = (float)(var0 & 255) * 0.003921569F;
        var1.a = (float)(var0 >>> 24) * 0.003921569F;
        return var1;
    }

    public TeamImageCache a(int var1) {
        return this.a(var1, true);
    }

    public void e() {
        w();
    }

    public static void w() {
        if (E.size() != 0) {
            Iterator var0 = E.iterator();

            while(var0.hasNext()) {
                LoadImage var1 = (LoadImage)var0.next();
                var1.I();
            }

            E.clear();
        }
    }

    public static void a(LoadImage var0) {
        E.add(var0);
        if (E.size() > 15) {
            w();
        }

    }

    public static LoadImage b(int var0, boolean var1) {
        String var2 = class_340.f(var0);

        try {
            FileInputStream var3 = new FileInputStream(var2);
            org.newdawn.slick.opengl.ImageData var4 = a((InputStream)var3);
            var3.close();
            return a(var4, var2);
        } catch (OutOfMemoryError var5) {
            GameEngine.a((class_338)class_338.GAME_IMAGE, (Throwable)var5);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", var5);
            } else {
                return r;
            }
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }
    }

    public TeamImageCache a(int var1, boolean var2) {
        return b(var1, var2);
    }

    @SneakyThrows
    public static org.newdawn.slick.opengl.ImageData a(InputStream var0) {
        BufferedInputStream var1 = new BufferedInputStream(var0);

        Object var2;
        try {
            var1.mark(Integer.MAX_VALUE);
            PNGImageData var3 = new PNGImageData();
            var3.loadImage(var1);
            var2 = var3;
        } catch (IOException var9) {
            var1.reset();
            GameEngine.log("PNG load failed: " + var9.getMessage());
            GameEngine.log("Attempting load with ImageIO..");
            ImageIOImageData var4 = new ImageIOImageData();
            ByteBuffer var5 = var4.loadImage(var1, false, (int[])null);
            var2 = new com.corrodinggames.rts.java.image.ImageData(var4, var5);
        } finally {
            var1.close();
        }

        return (org.newdawn.slick.opengl.ImageData)var2;
    }

    public TeamImageCache a(InputStream var1, boolean var2) {
        try {
            String var3 = null;
            if (var1 instanceof AssetInputStream) {
                var3 = ((AssetInputStream)var1).d();
            } else {
                GameEngine.print("loadImage InputStream is not AssetInputStream");
                GameEngine.T();
            }

            ++this.F;
            org.newdawn.slick.opengl.ImageData var4 = a(var1);
            return a(var4, var3);
        } catch (OutOfMemoryError var5) {
            GameEngine.a((class_338)class_338.GAME_IMAGE, (Throwable)var5);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", var5);
            } else {
                return r;
            }
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static LoadImage a(org.newdawn.slick.opengl.ImageData var0, String var1) {
        LoadImage var2 = new LoadImage();
        var2.a(var0, var1, false);
        a(var2);
        return var2;
    }

    public TeamImageCache a(int var1, int var2, boolean var3) {
        LoadImage var4 = new LoadImage();

        try {
            var4.a((Image)(new Image(var1, var2)), (String)null);
            a(var4);
            return var4;
        } catch (OutOfMemoryError var6) {
            GameEngine.a((class_338)class_338.GAME_IMAGE_CREATE, (Throwable)var6);
            if (r == null) {
                throw new RuntimeException("outOfMemoryErrorImage==null", var6);
            } else {
                return r;
            }
        } catch (SlickException var7) {
            throw new RuntimeException(var7);
        }
    }

    public TeamImageCache b(int var1, int var2, boolean var3) {
        return a((org.newdawn.slick.opengl.ImageData)(new ImageBuffer(var1, var2)), (String)null);
    }

    public void a(TeamImageCache var1, float var2, float var3, float var4, Paint var5) {
        this.k();
        this.a(var4 + 90.0F, var2, var3);
        this.c(var1, var2 - (float)var1.r, var3 - (float)var1.s, var5);
        this.l();
    }

    public void a(TeamImageCache var1, Rect var2, float var3, float var4, float var5, Paint var6) {
        this.k();
        this.a(var5, var3, var4);
        this.G.a(var3 - (float)var1.r, var4 - (float)var1.s, (float)var1.p, (float)var1.q);
        this.a(var1, var2, this.G, var6);
        this.l();
    }

    public void a(TeamImageCache var1, Rect var2, Rect var3, Paint var4) {
        this.G.a(var3);
        this.a(var1, var2, this.G, var4);
    }

    public void b(TeamImageCache var1, Rect var2, Rect var3, Paint var4) {
        this.G.a(var3);
        this.a(var1, var2, this.G, var4);
    }

    public void a(Rect var1, Paint var2) {
        this.G.a(var1);
        this.a(this.G, var2);
    }

    public void a(boolean var1) {
    }

    public void f() {
    }

    private final LoadImage e(TeamImageCache var1) {
        LoadImage var2 = (LoadImage)var1.c();
        return var2;
    }

    public void a(TeamImageCache var1, Rect var2, RectF var3, Paint var4) {
        this.a(var1, var3.a, var3.b, var3.c, var3.d, (float)var2.a, (float)var2.b, (float)var2.c, (float)var2.d, var4);
    }

    private void c(TeamImageCache var1, float var2, float var3, Paint var4) {
        float var5 = (float)var1.m();
        float var6 = (float)var1.l();
        float var7 = var2 + var5;
        float var8 = var3 + var6;
        float var9 = 0.0F;
        float var10 = 0.0F;
        this.a(var1, var2, var3, var7, var8, var9, var10, var5, var6, var4);
    }

    private void a(TeamImageCache var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, Paint var10) {
        class_378 var11 = this.T;
        float var12 = var4 - var2;
        float var13 = var5 - var3;
        float var16;
        float var17;
        float var18;
        if (var11.c != -90.0F) {
            float var14 = var12 / 2.0F;
            float var15 = var13 / 2.0F;
            var16 = var2 + var14 - var11.g;
            var17 = var3 + var15 - var11.h;
            if (var16 != 0.0F || var17 != 0.0F) {
                var18 = 0.01F;
                if (var16 > 0.01F || var17 > 0.01F || var16 < -0.01F || var17 < -0.01F) {
                    PointF var19 = this.q;
                    var19.x = var16;
                    var19.y = var17;
                    a(var11.c + 180.0F, var19);
                    float var20 = var19.x + var11.g - var14;
                    float var21 = var19.y + var11.h - var15;
                    var4 += var20 - var2;
                    var5 += var21 - var3;
                    var2 = var20;
                    var3 = var21;
                }
            }
        }

        LoadImage var22 = this.e(var1);
        boolean var23 = false;
        if (this.j != null && var22.m() < 450 && var22.l() < 100) {
            class_837 var24 = this.j.a(var22);
            if (var24 != null) {
                var23 = true;
                var22 = this.e(var24.a);
                if (var6 < 0.0F) {
                    var2 += -var6;
                    var6 = 0.0F;
                }

                if (var7 < 0.0F) {
                    var3 += -var7;
                    var7 = 0.0F;
                }

                if (var8 > var24.d) {
                    var4 += -(var24.d - var8);
                    var8 = var24.d;
                }

                if (var9 > var24.e) {
                    var5 += -(var24.e - var9);
                    var9 = var24.e;
                }

                var6 += (float)var24.b;
                var8 += (float)var24.b;
                var7 += (float)var24.c;
                var9 += (float)var24.c;
            }
        }

        var16 = var4 - var2;
        var17 = var5 - var3;
        var2 *= var11.d;
        var3 *= var11.e;
        var16 *= var11.d;
        var17 *= var11.e;
        var2 += var11.a;
        var3 += var11.b;
        var18 = var16 / 2.0F;
        float var25 = var17 / 2.0F;
        this.a(var10, var22, var1);
        Image var26 = var22.C();
        if (var26 == null) {
            var22.G();
            throw new RuntimeException("getSlickImage==null");
        } else {
            this.a(var26, var2 + var18, var3 + var25, var16, var17, var6, var7, var8, var9, this.t(), var11.c);
        }
    }

    private void a(Image var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, Color var10, float var11) {
        Graphics.setCurrent(this.f);
        var1.startUse();
        if (var10 != null) {
            var10.bind();
        }

        float var14 = var4 * 0.5F;
        float var15 = var5 * 0.5F;
        float var16 = var8 - var6;
        float var17 = var9 - var7;
        float var18 = var1.getTextureWidth() / (float)var1.getWidth();
        float var19 = var1.getTextureHeight() / (float)var1.getHeight();
        float var20 = var6 * var18;
        float var21 = var7 * var19;
        float var22 = var16 * var18;
        float var23 = var17 * var19;
        float var32 = var11 + 90.0F;
        float var24;
        float var25;
        float var26;
        float var27;
        float var28;
        float var29;
        float var30;
        float var31;
        if (var32 == 0.0F) {
            var24 = -var14 + var2;
            var25 = -var15 + var3;
            var26 = var14 + var2;
            var27 = -var15 + var3;
            var28 = -var14 + var2;
            var29 = var15 + var3;
            var30 = var14 + var2;
            var31 = var15 + var3;
        } else {
            float var33 = class_340.k(var32);
            float var34 = class_340.j(var32);
            float var35 = var14 * var33;
            float var36 = var15 * var33;
            float var37 = var14 * var34;
            float var38 = var15 * var34;
            var24 = -var35 + var38 + var2;
            var25 = -var37 - var36 + var3;
            var26 = var35 + var38 + var2;
            var27 = var37 - var36 + var3;
            var28 = -var35 - var38 + var2;
            var29 = -var37 + var36 + var3;
            var30 = var35 - var38 + var2;
            var31 = var37 + var36 + var3;
        }

        W.glTexCoord2f(var20, var21);
        W.glVertex3f(var24, var25, 0.0F);
        W.glTexCoord2f(var20, var21 + var23);
        W.glVertex3f(var28, var29, 0.0F);
        W.glTexCoord2f(var20 + var22, var21 + var23);
        W.glVertex3f(var30, var31, 0.0F);
        W.glTexCoord2f(var20 + var22, var21);
        W.glVertex3f(var26, var27, 0.0F);
        var1.endUse();
        this.f.getColor().bind();
    }

    public void a(TeamImageCache var1, float var2, float var3, Paint var4) {
        this.b(var1, var2 - var1.t, var3 - var1.u, var4);
    }

    public void a(TeamImageCache var1, float var2, float var3, Paint var4, float var5, float var6) {
        this.k();
        this.b(var2, var3);
        this.a(var6, var6);
        this.a(var5, var2, var3);
        this.c(var1, 0.0F, 0.0F, var4);
        this.l();
    }

    public void b(TeamImageCache var1, float var2, float var3, Paint var4) {
        this.c(var1, var2, var3, var4);
    }

    public void a(TeamImageCache var1, Rect var2, Paint var3) {
        this.a(var1, var2, var3, 0, 0, 0, 0);
    }

    public void a(TeamImageCache var1, Rect var2, Paint var3, int var4, int var5, int var6, int var7) {
        class_936.a(this, var1, var2, var3, var4, var5, var6, var7);
    }

    public void a(TeamImageCache var1, RectF var2, Paint var3, float var4, float var5, int var6, int var7) {
        class_936.a(this, var1, var2, var3, var4, var5, var6, var7);
    }

    public void b(int var1) {
        if (l != this) {
            this.u();
        }

        this.b(false);
        this.w = null;
        this.f.setBackground(a(var1, e));
        this.f.clear();
    }

    public void o() {
        if (l != this) {
            this.u();
        }

        this.w = null;
        this.f.clearAlphaMap();
    }

    public void a(int var1, PorterDuff.Mode var2) {
        this.w = null;
        if (var2 != Mode.CLEAR) {
            this.b(var1);
        } else {
            this.b(var1);
            this.f.clearAlphaMap();
        }
    }

    public void a(String var1, float var2, float var3, Paint var4, Paint var5, float var6) {
        float var7 = (float)this.b(var1, var4);
        J.a(var2, var3, var2 + var7, var3 + (float)this.a(var1, var4));
        class_340.a(J, var6);
        K.a(J);
        if (var4.j() == Paint$Align.b) {
            J.a(-(var7 / 2.0F), 0.0F);
        }

        this.a(J, var5);
        this.a(var1, K.a + var6, K.d - var6, var4);
    }

    boolean x() {
        if (!GameEngine.getGameEngine().settingsEngine.resizeFontWithUIScale) {
            return false;
        } else if (this.L == 1.0F) {
            return false;
        } else {
            return this.L < 1.0F ? true : true;
        }
    }

    public void a(String var1, float var2, float var3, Paint var4) {
        if (this.x()) {
            this.k();
            float var5 = 1.0F / this.L;
            this.a(var5, var5);
            var2 *= this.L;
            var3 *= this.L;
        }

        var2 *= this.T.d;
        var3 *= this.T.e;
        var2 += this.T.a;
        var3 += this.T.b;
        this.a(var4, var1);
        int var10 = 0;
        int var6;
        if (var4.j() == Paint$Align.b) {
            var6 = this.f.getFont().getWidth(var1);
            var10 -= var6 / 2;
        } else if (var4.j() == Paint$Align.c) {
            var6 = this.f.getFont().getWidth(var1);
            var10 -= var6;
        }

        byte var11 = 0;
        int var7 = this.f.getFont().getLineHeight();
        var6 = var11 - var7;
        int var8 = (int)(var2 + (float)var10);
        int var9 = (int)(var3 + (float)var6);
        this.f.drawString(var1, (float)var8, (float)var9);
        if (this.x()) {
            this.l();
        }

    }

    public void b(Rect var1, Paint var2) {
        this.G.a(var1);
        this.a(this.G, var2);
    }

    public void a(RectF var1, Paint var2) {
        this.b(var2);
        float var3;
        float var4;
        float var5;
        float var6;
        if (var2.d() != Paint$Style.a && var2.d() != Paint$Style.c) {
            var3 = var1.a;
            var4 = var1.b;
            var5 = var1.b();
            var6 = var1.c();
            var3 *= this.T.d;
            var4 *= this.T.e;
            var3 += this.T.a;
            var4 += this.T.b;
            var5 *= this.T.d;
            var6 *= this.T.e;
            this.f.drawRect(var3, var4, var5, var6);
        } else {
            TextureImpl.bindNone();
            W.glBegin(7);
            var3 = var1.a;
            var4 = var1.b;
            var5 = var1.c;
            var6 = var1.d;
            var3 *= this.T.d;
            var4 *= this.T.e;
            var3 += this.T.a;
            var4 += this.T.b;
            var5 *= this.T.d;
            var6 *= this.T.e;
            var5 += this.T.a;
            var6 += this.T.b;
            W.glVertex2f(var3, var4);
            W.glVertex2f(var5, var4);
            W.glVertex2f(var5, var6);
            W.glVertex2f(var3, var6);
            W.glEnd();
        }

    }

    public void g() {
        this.e();
        M = null;
        if (this.j != null) {
            this.j.c();
        }

    }

    public void h() {
        this.y();
        if (this.j != null) {
            this.j.d();
        }

        if (this.a && m != null) {
            this.v();
            m = null;
        }

        this.w = null;
        M = null;
        this.b = true;
        B = -1.0F;
        this.y = false;
    }

    public void c(Rect var1, Paint var2) {
        this.o.a(var1.a, var1.b, var1.a + var1.c, var1.b + var1.d);
        this.b(this.o, var2);
    }

    public void a(Rect var1) {
        if (var1 != null) {
            this.T.f = new RectF(var1);
            RectF var10000 = this.T.f;
            var10000.a *= this.T.d;
            var10000 = this.T.f;
            var10000.c *= this.T.d;
            var10000 = this.T.f;
            var10000.b *= this.T.e;
            var10000 = this.T.f;
            var10000.d *= this.T.e;
            this.T.f.a(this.T.a, this.T.b);
        } else {
            this.T.f = null;
        }

        this.b(false);
    }

    public void a(RectF var1) {
        if (var1 != null) {
            this.T.f = new RectF(var1);
            RectF var10000 = this.T.f;
            var10000.a *= this.T.d;
            var10000 = this.T.f;
            var10000.c *= this.T.d;
            var10000 = this.T.f;
            var10000.b *= this.T.e;
            var10000 = this.T.f;
            var10000.d *= this.T.e;
            this.T.f.a(this.T.a, this.T.b);
        } else {
            this.T.f = null;
        }

        this.b(false);
    }

    public void b(boolean var1) {
        RectF var2 = this.T.f;
        if (M != var2 || var1) {
            this.y();
            if (var2 != null) {
                W.glEnable(3089);
                W.glScissor((int)var2.a, (int)((float)this.n() * this.L - var2.d), (int)var2.b(), (int)var2.c());
            } else {
                W.glDisable(3089);
            }

            M = var2;
        }
    }

    public void b(float var1, float var2, float var3, Paint var4) {
        var1 *= this.T.d;
        var2 *= this.T.e;
        var1 += this.T.a;
        var2 += this.T.b;
        var3 *= this.T.d;
        this.b(var4);
        if (var4.d() == Paint$Style.b) {
            byte var5 = 40;
            if (var3 > 100.0F) {
                var5 = 60;
            }

            this.a(var1, var2, var3, var5);
        } else {
            this.f.fillOval(var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F);
        }

    }

    public void a(float var1, float var2, float var3, Paint var4) {
        float var5 = this.T.d;
        if (var3 * var5 < 25.0F && var4.d() == Paint$Style.b) {
            class_936.a(this, var1, var2, var3, var4, var5);
        } else {
            this.b(var1, var2, var3, var4);
        }
    }

    public FloatBuffer c(int var1) {
        if (this.N.capacity() < var1) {
            this.N = BufferUtils.createFloatBuffer(var1);
        }

        return this.N;
    }

    public FloatBuffer a(float[] var1, int var2) {
        FloatBuffer var3 = this.c(var2);
        var3.clear();
        var3.put(var1, 0, var2);
        var3.flip();
        return var3;
    }

    public float[] d(int var1) {
        if (this.O.length < var1) {
            this.O = new float[var1];
        }

        return this.O;
    }

    public void a(float[] var1, int var2, int var3, Paint var4) {
        if (var3 != 0) {
            boolean var5 = true;
            if (Main.b) {
                var5 = false;
            }

            float var6 = var4.g();
            float var7 = 1.0F;
            float var8 = 0.0F;
            if (var6 > 1.0F) {
                var7 += (var6 - 1.0F) * 0.5F;
                var8 += (var6 - 1.0F) * 0.5F;
            }

            float var9 = this.T.d;
            float var10 = this.T.e;
            float var11 = this.T.a;
            float var12 = this.T.b;
            int var14;
            float var17;
            float var18;
            float var19;
            float var20;
            if (var5) {
                float[] var13 = this.d(var3 * 4);
                var14 = var3 * 4;
                int var15 = 0;

                for(int var16 = 0; var16 < var14; var16 += 8) {
                    var17 = var1[var15];
                    var18 = var1[var15 + 1];
                    var19 = var17 - var8;
                    var20 = var17 + var7;
                    float var21 = var18 - var8;
                    float var22 = var18 + var7;
                    var13[var16 + 0] = var19;
                    var13[var16 + 1] = var21;
                    var13[var16 + 2] = var20;
                    var13[var16 + 3] = var21;
                    var13[var16 + 4] = var20;
                    var13[var16 + 5] = var22;
                    var13[var16 + 6] = var19;
                    var13[var16 + 7] = var22;
                    var15 += 2;
                }

                this.b(var13, 0, var3 * 4, var4);
            } else {
                this.b(var4);
                TextureImpl.bindNone();
                W.glBegin(7);
                int var23 = var2 + var3;

                for(var14 = var2; var14 < var23; var14 += 2) {
                    float var24 = var1[var14];
                    float var25 = var1[var14 + 1];
                    var24 *= var9;
                    var25 *= var10;
                    var24 += var11;
                    var25 += var12;
                    var17 = var24 - var8;
                    var18 = var24 + var7;
                    var19 = var25 - var8;
                    var20 = var25 + var7;
                    W.glVertex2f(var17, var19);
                    W.glVertex2f(var18, var19);
                    W.glVertex2f(var18, var20);
                    W.glVertex2f(var17, var20);
                }

                W.glEnd();
            }

        }
    }

    public void b(float[] var1, int var2, int var3, Paint var4) {
        boolean var5 = Main.a;
        if (var5) {
            GL11.glDisableClientState(32886);
        }

        this.b(var4);
        TextureImpl.bindNone();
        GL11.glEnableClientState(32884);
        FloatBuffer var6 = this.a(var1, var3);
        GL11.glVertexPointer(2, 0, var6);
        GL11.glDrawArrays(7, var2, var3 / 2);
        if (var5) {
            GL11.glEnableClientState(32886);
        }

    }

    public void a(float var1, float var2, float var3, int var4) {
        Graphics.setCurrent(this.f);
        TextureImpl.bindNone();
        if (this.P != var4) {
            this.P = var4;
            this.Q = 6.283185F / (float)var4;
            this.R = (float)FastTrig.cos((double)this.Q);
            this.S = (float)FastTrig.sin((double)this.Q);
        }

        float var5 = this.R;
        float var6 = this.S;
        float var8 = var3;
        float var9 = 0.0F;
        boolean var10 = true;
        X.start();
        ++var4;
        float var10000 = var3 + var1;
        var10000 = var9 + var2;

        for(int var13 = 0; var13 < var4; ++var13) {
            X.vertex(var8 + var1, var9 + var2);
            float var7 = var8;
            var8 = var5 * var8 - var6 * var9;
            var9 = var6 * var7 + var5 * var9;
        }

        X.end();
    }

    public void i() {
        this.z();
    }

    public void j() {
        this.A();
    }

    public void k() {
        this.z();
    }

    public void l() {
        this.A();
    }

    public void a(float var1, float var2, float var3) {
        class_378 var10000 = this.T;
        var10000.c += var1;
        this.T.g = var2;
        this.T.h = var3;
    }

    public static void a(float var0, PointF var1) {
        float var2 = class_340.j(var0);
        float var3 = class_340.k(var0);
        float var4 = var1.x;
        float var5 = var1.y;
        var1.x = var3 * var5 - var2 * var4;
        var1.y = var2 * var5 + var3 * var4;
    }

    public void a(float var1, float var2) {
        class_378 var10000 = this.T;
        var10000.d *= var1;
        var10000 = this.T;
        var10000.e *= var2;
    }

    public void a(float var1, float var2, float var3, float var4) {
        this.b(var3, var4);
        this.a(var1, var2);
        this.b(-var3, -var4);
    }

    public void b(float var1, float var2) {
        class_378 var10000 = this.T;
        var10000.a += var1 * this.T.d;
        var10000 = this.T;
        var10000.b += var2 * this.T.e;
    }

    public void a(class_526 var1) {
        var1.a(this);
    }

    public void a(float var1, float var2, float var3, float var4, Paint var5) {
        this.b(var5);
        var1 *= this.T.d;
        var2 *= this.T.e;
        var1 += this.T.a;
        var2 += this.T.b;
        var3 *= this.T.d;
        var4 *= this.T.e;
        var3 += this.T.a;
        var4 += this.T.b;
        this.f.drawLine(var1, var2, var3, var4);
    }

    public void a(Paint var1) {
        this.a(var1, "", false);
    }

    public void a(Shader var1) {
        if (this.a) {
            this.c(var1);
            this.v();
            m = null;
        }

    }

    public void y() {
        this.f.flushBuffer();
    }

    public void p() {
        this.f.flushBuffer();
        this.w = null;
        this.f.flush();
    }

    public void q() {
        if (this.f != null) {
            this.f.destroy();
        }

        this.f = null;
    }

    public int a(String var1, Paint var2) {
        this.a(var2, var1);
        int var3 = this.f.getFont().getLineHeight();
        if (this.x()) {
            var3 = (int)((float)var3 / this.L);
        }

        return var3;
    }

    public int b(String var1, Paint var2) {
        this.a(var2, var1);
        int var3 = this.f.getFont().getWidth(var1);
        if (this.x()) {
            var3 = (int)((float)var3 / this.L);
        }

        return var3;
    }

    public TeamImageCache r() {
        return r;
    }

    public void a(TeamImageCache var1, File var2) {
        LoadImage var3 = this.e(var1);
        boolean var4 = true;
        String var5 = "png";

        try {
            FileOutputStream var6 = new FileOutputStream(var2);
            BufferedOutputStream var7 = new BufferedOutputStream(var6);
            ImageOut.write(var3.C(), "png", var7);
            var7.close();
            var6.close();
        } catch (IOException var8) {
            throw new RuntimeException(var8);
        } catch (SlickException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void a(Lock var1) {
    }

    public void b(Lock var1) {
    }

    public void z() {
        this.U.add(this.T);
        class_378 var1;
        if (this.V.a == 0) {
            var1 = new class_378();
        } else {
            var1 = (class_378)this.V.c();
        }

        this.T.a(var1);
        this.T = var1;
    }

    public void A() {
        if (this.U.size() == 0) {
            throw new RuntimeException("tranform stack is empty");
        } else {
            this.V.add(this.T);
            this.T = (class_378)this.U.c();
            this.b(false);
        }
    }

    public float s() {
        return this.L;
    }

    // $FF: synthetic method
    public class_28 a(TeamImageCache var1) {
        return this.c(var1);
    }

    // $FF: synthetic method
    public class_28 b(TeamImageCache var1) {
        return this.d(var1);
    }

    static {
        H.a(255, 255, 0, 0);
        H.a(Paint$Style.b);
        J = new RectF();
        K = new RectF();
        X = Renderer.getLineStripRenderer();
    }
}
