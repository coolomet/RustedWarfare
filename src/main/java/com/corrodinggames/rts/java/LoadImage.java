package com.corrodinggames.rts.java;

import android.graphics.Color;
import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;

public strictfp class LoadImage extends TeamImageCache {
    public static ArrayList y;
    private Image x;
    org.newdawn.slick.opengl.ImageData z;
    ByteBuffer A;
    int B;
    String C;
    boolean D = false;
    int E = 1;
    static boolean F = true;
    boolean G = false;
    boolean H;
    boolean I = false;
    long J = -1L;
    static int K = 1000;

    public Image C() {
        return this.x;
    }

    private void a(org.newdawn.slick.opengl.ImageData var1) {
        this.z = var1;
        if (this.z instanceof ImageBuffer) {
            this.A = ByteBuffer.wrap(((ImageBuffer)var1).getRGBA());
        } else {
            this.A = var1.getImageBufferData();
        }

        this.B = var1.getDepth() / 8;
        if (this.B == 4) {
            int var2 = var1.getTexHeight();
            int var3 = var1.getTexWidth();
            int var4 = var1.getHeight();
            int var5 = var1.getWidth();

            for(int var6 = 0; var6 < var4; ++var6) {
                for(int var7 = 0; var7 < var5; ++var7) {
                    int var8 = var7 * 4 + var6 * var3 * 4;

                    try {
                        if (this.A.get(var8 + 3) == 0) {
                            this.A.put(var8 + 0, (byte)0);
                            this.A.put(var8 + 1, (byte)0);
                            this.A.put(var8 + 2, (byte)0);
                        }
                    } catch (IndexOutOfBoundsException var10) {
                        throw new IndexOutOfBoundsException("offset:" + var8 + " x:" + var7 + " y:" + var6 + " height:" + var4 + " width:" + var5 + " texHeight:" + var2 + " texWidth:" + var3);
                    }
                }
            }
        }

        if (F) {
        }

    }

    public String a() {
        return this.g != null ? this.g : this.C;
    }

    public LoadImage() {
        if (y == null) {
            y = new ArrayList();
        }

        y.add(this);
    }

    public void D() {
        if (this.z == null && this.x != null) {
            GameEngine.print("reloadFromImageData: slickImageData==null and slickImage!=null. Ignoring");
        } else {
            if (this.x != null) {
                try {
                    this.x.destroy();
                } catch (SlickException var2) {
                    throw new RuntimeException(var2);
                }
            }

            Image var1 = null;
            if (var1 == null) {
                var1 = new Image(this.z);
            }

            this.x = var1;
            this.E();
            this.p = this.x.getWidth();
            this.q = this.x.getHeight();
            this.g();
            this.v();
        }
    }

    public void a(Image var1, String var2) {
        if (this.x != null) {
            GameEngine.warn("this.slickImage!=null");
        }

        this.x = var1;
        this.E();
        this.p = this.x.getWidth();
        this.q = this.x.getHeight();
        this.g();
        this.C = var2;
        if (this.C != null) {
            File var3 = new File(this.C);
            if (!var3.exists()) {
                throw new RuntimeException(this.C + " does not exist");
            }

            this.J = this.c(true);
        }

    }

    public void a(org.newdawn.slick.opengl.ImageData var1, String var2, boolean var3) {
        this.a(var1);
        if (!var3) {
            this.D();
        }

        this.C = var2;
        if (this.C != null && !this.C.contains(".rwmod")) {
            File var4 = new File(this.C);
            if (!var4.exists()) {
                throw new RuntimeException(this.C + " does not exist");
            }

            this.J = this.c(true);
        }

        this.g();
    }

    public static ByteBuffer a(ByteBuffer var0, ByteBuffer var1) {
        var0.rewind();
        var1.put(var0);
        var0.rewind();
        var1.flip();
        return var1;
    }

    public TeamImageCache getTeamImageCache(int var1, int var2, boolean var3) {
        LoadImage var4 = new LoadImage();
        ImageBuffer var5 = new ImageBuffer(var1, var2);
        Object var6 = null;
        var4.a(var5, (String)var6, true);
        if (var3) {
            boolean var7 = true;
            if (var7 && this.B == 4) {
                this.H();
                ByteBuffer var10 = this.z.getImageBufferData();
                a(var10, var4.A);
            } else {
                this.H();

                for(int var8 = 0; var8 < var2; ++var8) {
                    for(int var9 = 0; var9 < var1; ++var9) {
                        var4.a(var9, var8, this.a(var9, var8));
                    }
                }
            }
        }

        var4.p = var1;
        var4.q = var2;
        var4.g();
        var4.D = true;
        return var4;
    }

    public void i() {
        if (!this.G) {
            this.j();
        } else if (F && this.A == null) {
            this.j();
        }

    }

    public void x() {
        this.H();
    }

    public void y() {
    }

    public void j() {
        this.G = true;
        if (this.H) {
            this.G();
            throw new RuntimeException("Cannot buffer pixels, we have discarded the PixelBuffer");
        } else {
            this.H();
        }
    }

    public void H() {
        if (F && this.A == null) {
            this.J();
        }

    }

    public void q() {
        this.I();
    }

    public void I() {
        if (F) {
            this.z = null;
            this.A = null;
        }

    }

    public void J() {
        if (this.x == null) {
            throw new RuntimeException("Cannot buffer pixels, we have no slickImage");
        } else {
            long var1 = Unit.loadAllUnitsTook();
            ImageData var3 = new ImageData(this, this.x);
            this.z = var3;
            this.A = ByteBuffer.wrap(var3.a());
            double var4 = (double)Unit.a(var1);
            GameEngine.log("Recreating image data from texture: " + this.a() + " (" + Unit.a(var4) + ")");
        }
    }

    public boolean k() {
        if (this.z == null) {
            return F && this.x != null;
        } else {
            return true;
        }
    }

    public int a(int var1, int var2) {
        try {
            return class_368.a(this.z, this.A, var1, var2, this.B);
        } catch (IndexOutOfBoundsException var5) {
            String var4 = "getPixel out of bounds";
            var4 = var4 + " (x:" + var1 + " y:" + var2 + " perPixel:" + this.B + " TexWidth:" + this.z.getTexWidth() + " TexHeight:" + this.z.getTexHeight() + " imageByteBuffer:" + this.A.limit() + " width:" + this.p + " height:" + this.q + ")";
            throw new RuntimeException(var4, var5);
        }
    }

    public void a(int var1, int var2, int var3) {
        try {
            class_368.a(this.z, this.A, var1, var2, Color.b(var3), Color.c(var3), Color.d(var3), Color.a(var3), this.B);
        } catch (IndexOutOfBoundsException var6) {
            String var5 = "setPixel out of bounds";
            var5 = var5 + " (x:" + var1 + " y:" + var2 + " perPixel:" + this.B + " TexWidth:" + this.z.getTexWidth() + " TexHeight:" + this.z.getTexHeight() + " imageByteBuffer:" + this.A.limit() + " width:" + this.p + " height:" + this.q + ")";
            throw new RuntimeException(var5, var6);
        }
    }

    public void p() {
        if (this.G) {
            this.G = false;
            this.D();
        }
    }

    public void r() {
    }

    public void s() {
        this.H = true;
        this.z = null;
        this.A = null;
    }

    public void n() {
        this.I = true;
    }

    public void o() {
        this.z = null;
        this.A = null;
        if (y != null) {
            y.remove(this);
        }

        if (this.x != null) {
            try {
                this.x.destroy();
            } catch (SlickException var2) {
                var2.printStackTrace();
            }

            this.x = null;
        }

    }

    protected void finalize() {
        if (this.I) {
            this.o();
        }

        if (this.x != null) {
            GameEngine.print("SlickBitmapOrTexture: Leak detection: finalize called with slickImage!=null");
        }

    }

    public TeamImageCache h() {
        return this.getTeamImageCache(this.p, this.q, true);
    }

    protected void e() {
        this.E();
    }

    public void E() {
        if (this.x == null) {
            GameEngine.print("slickImage==null");
            GameEngine.T();
        }

        if (!this.o) {
            this.E = 2;
            this.x.setFilter(2);
        } else {
            this.E = 1;
            this.x.setFilter(1);
        }

    }

    public void F() {
        if (this.D) {
            GameEngine.log("reloadImage: skipping cloned image:" + this.C);
        } else if (this.C == null) {
            GameEngine.log("reloadImage: filepath is null, skipping");
        } else {
            try {
                GameEngine.log("reloadImage: reloading:" + this.C);
                if (this.x != null) {
                    this.x.destroy();
                } else {
                    GameEngine.log("slickImage==null cannot free");
                }

                ++K;
                FileInputStream var1 = new FileInputStream(this.C);

                try {
                    this.x = new Image(var1, "reload_" + K, false);
                } catch (NullPointerException var3) {
                    throw new IOException("Failed to reload", var3);
                }

                this.v();
                this.E();
                this.p = this.x.getWidth();
                this.q = this.x.getHeight();
                this.g();
                var1.close();
            } catch (SlickException var4) {
                GameEngine.log("reloadImage: failed");
                var4.printStackTrace();
            } catch (IOException var5) {
                GameEngine.log("reloadImage: failed");
                var5.printStackTrace();
            }

            GameEngine var6 = GameEngine.getGameEngine();
            if (var6 != null && var6.bL != null) {
                var6.bL.g();
            }

        }
    }

    public long c(boolean var1) {
        return this.C == null ? -2L : FileChangeEngine.a(this.C, var1);
    }

    public void t() {
        long var1 = this.c(false);
        if (this.J == -1L) {
            this.J = var1;
        } else if (this.J != var1) {
            GameEngine.log("reloadImage: '" + this.C + "' reloading current now:" + var1);
            this.F();
            this.J = var1;
        }

    }

    public void G() {
        GameEngine.log("SlickBitmapOrTexture: " + this.a());
        GameEngine.log(" className:" + this.getClass().getSimpleName());
        GameEngine.log(" filepath:" + this.C);
        GameEngine.log(" slickImage:" + (this.x != null));
        GameEngine.log(" cloned:" + this.D);
    }

    // $FF: synthetic method
    public Object clone() {
        return this.h();
    }
}
