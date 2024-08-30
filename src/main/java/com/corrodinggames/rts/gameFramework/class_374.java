package com.corrodinggames.rts.gameFramework;

import android.media.MediaPlayer;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.an
public strictfp class class_374 extends class_373 {
    ArrayList a = new ArrayList();
    ArrayList b = new ArrayList();
    ArrayList c = new ArrayList();
    boolean d = false;

    public class_976 a(String var1) {
        return new class_978(var1, this);
    }

    public class_345 a() {
        class_347 var1 = new class_347(this);
        return var1;
    }

    public void a(class_1001 var1) {
        this.e = var1;
        if (this.d) {
            GameEngine.log("AndroidMusicFactory already loaded");
        }

        GameEngine.log("AndroidMusicFactory - load");
        this.d = true;
        this.a.add(new MediaPlayer());
        this.a.add(new MediaPlayer());
        this.b.addAll(this.a);
    }

    public void b() {
    }
}
