package com.corrodinggames.rts.appFramework;

// $FF: renamed from: com.corrodinggames.rts.appFramework.c.2.1
class class_1062 implements Runnable {
    // $FF: synthetic field
    final class_1060 a;

    class_1062(class_1060 var1) {
        this.a = var1;
    }

    public void run() {
        if (this.a.b.settingsEngine.hasSelectedAStorageType) {
            this.a.c.run();
        }

    }
}
