package com.corrodinggames.rts.gameFramework.a;

import android.content.Context;
import android.media.SoundPool;
import com.corrodinggames.rts.AssetsID$raw;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.utility.class_671;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.a.a
public strictfp class class_351 extends class_349 {
    LinkedBlockingQueue a = new LinkedBlockingQueue();
    final int b = 15;
    class_671 c = new class_671(15);
    class_647 d;
    int e = 1000;
    Context f;
    SoundPool g;

    public class_351() {
        for(int var1 = 0; var1 < 15; ++var1) {
            this.c.a(new class_646());
        }

    }

    public void a(Context var1) {
        if (this.f != null) {
            GameEngine.log("AndroidSoundFactory:setContext context already set");
        } else {
            this.f = var1;
            this.g = new SoundPool(16, 3, 0);
        }
    }

    public void a() {
        if (this.d != null) {
            throw new RuntimeException("soundThread!=null");
        } else {
            this.d = new class_647(this);
            this.d.start();
        }
    }

    public class_355 a(int var1) {
        String var2 = class_340.a(AssetsID$raw.class, var1);
        class_357 var3 = new class_357(this, var2, this);
        var3.a = this;
        var3.b = this.g.load(this.f, var1, 1);
        return var3;
    }

    public class_355 a(String var1, AssetInputStream var2, boolean var3) {
        class_351 var4 = this;
        if (!var3) {
            var4 = null;
        }

        FileDescriptor var5;
        long var6;
        long var8;
        int var10;
        if (!var2.a()) {
            try {
                File var11 = class_697.a(this.f, "audio", "ogg");

                try {
                    FileOutputStream var12 = new FileOutputStream(var11);
                    class_340.a((InputStream)var2, (OutputStream)var12);
                    var12.close();

                    try {
                        var2.close();
                    } catch (Exception var31) {
                        var31.printStackTrace();
                    }

                    FileInputStream var13 = new FileInputStream(var11);

                    try {
                        var5 = var13.getFD();
                        var6 = 0L;
                        var8 = (long)var13.available();
                        var10 = this.g.load(var5, var6, var8, 1);
                    } finally {
                        var13.close();
                    }
                } finally {
                    var11.delete();
                }
            } catch (IOException var33) {
                var33.printStackTrace();
                return null;
            }
        } else {
            try {
                var5 = var2.b();
                var6 = 0L;
                var8 = (long)var2.available();
            } catch (Exception var29) {
                var29.printStackTrace();
                return null;
            }

            var10 = this.g.load(var5, var6, var8, 1);

            try {
                var2.close();
            } catch (Exception var28) {
                var28.printStackTrace();
            }
        }

        class_357 var34 = new class_357(this, var1, var4);
        var34.a = this;
        var34.b = var10;
        return var34;
    }
}
