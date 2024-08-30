package com.corrodinggames.rts.gameFramework;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.au
class class_979 extends Thread {
    // $FF: synthetic field
    final class_1001 a;

    class_979(class_1001 var1) {
        this.a = var1;
    }

    public void run() {
        while(true) {
            float var1 = 1.0F;
            synchronized(this.a.c) {
                this.a.g = true;
                if (!this.a.f) {
                    try {
                        this.a.c.wait((long)class_1001.a.e());
                    } catch (InterruptedException var7) {
                    }
                }

                this.a.f = false;
                var1 = this.a.d;
            }

            synchronized(this.a.b) {
                if (!this.a.b(var1)) {
                    return;
                }
            }
        }
    }
}
