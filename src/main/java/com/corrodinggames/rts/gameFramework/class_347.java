package com.corrodinggames.rts.gameFramework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.utility.class_670;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ap
public strictfp class class_347 extends class_345 {
    MediaPlayer a;
    class_978 b;
    class_374 c;

    public class_347(class_374 var1) {
        this.c = var1;
        MediaPlayer var2 = null;
        if (var1.b.size() == 0) {
            throw new RuntimeException("Music player pool empty");
        } else {
            var2 = (MediaPlayer)var1.b.remove(0);
            var1.c.add(this);
            this.a = var2;
        }
    }

    public void a(class_976 var1) {
        this.b = (class_978)var1;
    }

    public void a(boolean var1) {
        try {
            MediaPlayer var2 = this.a;
            var2.reset();
            AssetFileDescriptor var3 = null;
            String var4;
            if (this.b.b.startsWith("music")) {
                var4 = class_697.e(this.b.b);

                try {
                    var3 = this.c.e.w.d().b(var4);
                } catch (Exception var21) {
                    throw new RuntimeException(var21);
                }

                var2.setDataSource(var3.getFileDescriptor(), var3.getStartOffset(), var3.getLength());
            } else {
                var4 = class_697.e(this.b.b);
                if (class_670.a(var4) == null) {
                    var2.setDataSource(var4);
                } else {
                    AssetInputStream var5 = class_697.k(var4);
                    if (var5 == null) {
                        throw new RuntimeException("openAssetSteam() null for '" + var4 + "'");
                    }

                    File var6 = class_697.a(this.c.e.w, "music", "ogg");
                    GameEngine.log("Temp file needed for this music from zipped/abstract mod file");

                    try {
                        FileOutputStream var7 = new FileOutputStream(var6);
                        class_340.a((InputStream)var5, (OutputStream)var7);
                        var7.close();
                        var5.close();
                        FileInputStream var8 = new FileInputStream(var6);

                        try {
                            var2.setDataSource(var8.getFD(), 0L, (long)var8.available());
                        } finally {
                            var8.close();
                        }
                    } finally {
                        var6.delete();
                    }
                }
            }

            if (var1) {
                var2.setLooping(true);
            }

            var2.setVolume(0.0F, 0.0F);
            var2.setOnInfoListener(new class_443(this));
            var2.setOnPreparedListener(new class_442(this));
            var2.prepareAsync();
            if (var3 != null) {
                var3.close();
            }

        } catch (Exception var22) {
            throw new RuntimeException(var22);
        }
    }

    public void a() {
        this.a.pause();
    }

    public void b() {
        this.a.start();
    }

    public boolean c() {
        return this.a.isPlaying();
    }

    public void d() {
        if (this.a != null) {
            this.a.stop();
        }

    }

    public void e() {
        if (this.a != null) {
            this.a.stop();
        }

        this.a = null;
        this.c.c.remove(this);
        this.c.b.add(this.a);
    }

    public void a(float var1) {
        this.a.setVolume(var1, var1);
    }
}
