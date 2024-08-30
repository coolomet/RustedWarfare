package com.corrodinggames.rts.game;

import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import java.io.File;
import java.io.FileOutputStream;

// $FF: renamed from: com.corrodinggames.rts.game.k
class class_170 implements Runnable {
    public Bitmap a;
    public int b;
    // $FF: synthetic field
    EngineLoad c;

    public strictfp void run() {
        synchronized(this) {
            try {
                File var2 = new File(this.c.h + "image_" + String.format("%07d", this.b) + ".jpg");
                FileOutputStream var3 = new FileOutputStream(var2);
                this.a.a(Bitmap$CompressFormat.a, 85, var3);
                var3.close();
            } catch (Exception var5) {
                var5.printStackTrace();
                this.c.bo = false;
                this.c.log("Error saving jpg, recording has stopped. Is there free space remaining on the SD card?", 1);
            }

        }
    }
}
