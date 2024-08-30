package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.e.class_697;

// $FF: renamed from: com.corrodinggames.rts.appFramework.c.1
final class class_1061 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final GameEngine a;
    // $FF: synthetic field
    final Runnable b;

    class_1061(GameEngine var1, Runnable var2) {
        this.a = var1;
        this.b = var2;
    }

    public void onClick(DialogInterface var1, int var2) {
        this.a.settingsEngine.storageType = 1;
        this.a.settingsEngine.hasSelectedAStorageType = true;
        class_697.b();
        this.a.settingsEngine.save();
        if (this.b != null) {
            this.b.run();
        }

    }
}
