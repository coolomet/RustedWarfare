package com.corrodinggames.rts.gameFramework.utility;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.d
public strictfp class class_700 extends Thread {
    private static final class_21 a = new class_380();
    private static final class_22 b = new class_381();
    private class_21 c;
    private class_22 d;
    private final Handler e;
    private final int f;
    private String g;
    private boolean h;
    private boolean i;
    private volatile int j;
    private final Runnable k;

    public class_700() {
        this(5000);
    }

    public class_700(int var1) {
        this.c = a;
        this.d = b;
        this.e = new Handler(Looper.b());
        this.g = "";
        this.h = false;
        this.i = false;
        this.j = 0;
        this.k = new class_379(this);
        this.f = var1;
    }

    public class_700 a(class_21 var1) {
        if (var1 == null) {
            this.c = a;
        } else {
            this.c = var1;
        }

        return this;
    }

    public void run() {
        this.setName("|ANR-WatchDog|");
        int var2 = -1;

        while(true) {
            if (!this.isInterrupted()) {
                int var1 = this.j;
                this.e.a(this.k);

                try {
                    Thread.sleep((long)this.f);
                } catch (InterruptedException var4) {
                    this.d.a(var4);
                    return;
                }

                if (this.j != var1) {
                    continue;
                }

                if (!this.i && Debug.isDebuggerConnected()) {
                    if (this.j != var2) {
                        Log.c("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }

                    var2 = this.j;
                    continue;
                }

                class_702 var3;
                if (this.g != null) {
                    var3 = class_702.a(this.g, this.h);
                } else {
                    var3 = class_702.a();
                }

                this.c.a(var3);
                return;
            }

            return;
        }
    }

    // $FF: synthetic method
    static int a(class_700 var0, int var1) {
        return var0.j = var1;
    }

    // $FF: synthetic method
    static int a(class_700 var0) {
        return var0.j;
    }
}
