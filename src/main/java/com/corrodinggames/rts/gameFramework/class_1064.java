package com.corrodinggames.rts.gameFramework;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.am.2
class class_1064 extends Thread {
    // $FF: synthetic field
    final class_1001 a;

    class_1064(class_1001 var1) {
        this.a = var1;
    }

    public void run() {
        synchronized(this.a.b) {
            if (this.a.l) {
                this.a.k.b();
                if (!this.a.C) {
                    this.a.k.a(this.a.a(), this.a.a());
                }
            }

            if (this.a.B) {
                this.a.A.b();
            }

        }
    }
}
