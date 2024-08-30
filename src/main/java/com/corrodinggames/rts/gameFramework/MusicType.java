package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.e.class_697;
import java.util.ArrayList;

abstract class MusicType {
    public static final MusicType a = new MusicType$1("starting", 0);
    public static final MusicType b = new MusicType$2("buildup", 1);
    public static final MusicType c = new MusicType$3("attacked", 2);
    String[] d;
    // $FF: synthetic field
    private static final MusicType[] e = new MusicType[]{a, b, c};

    public static MusicType[] values() {
        return (MusicType[])e.clone();
    }

    private MusicType(String var1, int var2) {
    }

    void a() {
        this.d = class_697.a(this.d(), false);
        if (this.d == null) {
            this.d = new String[0];
            GameEngine.n("Failed to open music folder: " + this.d());
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            ArrayList var2 = new ArrayList();
            String[] var3 = this.d;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                var6 = class_697.o(var6);
                if (class_1001.a(this.a(var6), true) != null) {
                    GameEngine.log("Loaded track:" + var6);
                    var2.add(var6);
                } else {
                    GameEngine.print("Skipping track:" + var6);
                }

                var1.a("music", false);
            }

            this.d = (String[])var2.toArray(new String[0]);
        }
    }

    String[] b() {
        return this.d;
    }

    static void c() {
        a.a();
        b.a();
        c.a();
    }

    abstract String d();

    String a(String var1) {
        return this.d() + "/" + var1;
    }

    // $FF: synthetic method
    MusicType(String var1, int var2, class_1063 var3) {
        this(var1, var2);
    }
}
