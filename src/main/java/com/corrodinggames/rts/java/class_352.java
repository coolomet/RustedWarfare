package com.corrodinggames.rts.java;

import android.content.Context;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.a.class_349;
import com.corrodinggames.rts.gameFramework.a.class_355;
import com.corrodinggames.rts.gameFramework.utility.class_671;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.java.audio.a.class_34;
import com.corrodinggames.rts.java.audio.a.class_36;
import com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.corrodinggames.rts.java.o
public strictfp class class_352 extends class_349 {
    final int a = 15;
    LinkedBlockingQueue b = new LinkedBlockingQueue();
    class_671 c = new class_671(15);
    class_341 d;
    Context e;
    public OpenALAudio f;

    public Object b() {
        return this.f;
    }

    public class_352(OpenALAudio var1) {
        for(int var2 = 0; var2 < 15; ++var2) {
            this.c.a(new class_354());
        }

        this.f = var1;
    }

    public void a(Context var1) {
        if (this.e != null) {
            GameEngine.log("SlickSoundFactory:setContext context already set");
        } else {
            this.e = var1;
        }
    }

    public class_355 a(int var1) {
        String var2 = class_340.f(var1);
        class_358 var3 = new class_358(this, var2, this);
        String var4 = class_340.f(var1);
        if (var4 == null) {
            throw new RuntimeException("Failed to find sound for res id:" + var1);
        } else {
            synchronized(this.b()) {
                class_36 var6 = new class_36(var4);
                var3.a = this.f.newSound(var6);
                return var3;
            }
        }
    }

    public class_355 a(String var1, AssetInputStream var2, boolean var3) {
        class_352 var4 = this;
        if (!var3) {
            var4 = null;
        }

        class_358 var5 = new class_358(this, var1, var4);

        try {
            synchronized(this.b()) {
                var5.a = this.f.newSound(new class_36(var2, var2.d()));
                return var5;
            }
        } catch (class_34 var9) {
            var9.printStackTrace();
            return null;
        }
    }

    public void a() {
        if (this.d != null) {
            throw new RuntimeException("startThreads: soundThread!=null");
        } else {
            this.d = new class_341(this);
            this.d.start();
        }
    }
}
