package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

class RWBasicGame$1 implements Runnable {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final ByteArrayOutputStream b;
    // $FF: synthetic field
    final String c;
    // $FF: synthetic field
    final RWBasicGame d;

    RWBasicGame$1(RWBasicGame var1, String var2, ByteArrayOutputStream var3, String var4) {
        this.d = var1;
        this.a = var2;
        this.b = var3;
        this.c = var4;
    }

    public void run() {
        try {
            FileOutputStream var1 = new FileOutputStream(this.a);

            try {
                var1.write(this.b.toByteArray());
            } finally {
                var1.close();
            }

            GameEngine.log("Screenshot saved: " + this.c);
        } catch (Exception var6) {
            var6.printStackTrace();
            GameEngine.n("Failed to write screenshot:" + var6.getMessage());
        }

    }
}
