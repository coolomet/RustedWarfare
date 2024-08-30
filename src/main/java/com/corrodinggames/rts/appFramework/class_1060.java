package com.corrodinggames.rts.appFramework;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.e.class_696;
import com.corrodinggames.rts.gameFramework.e.class_697;

// $FF: renamed from: com.corrodinggames.rts.appFramework.c.2
final class class_1060 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final Activity a;
    // $FF: synthetic field
    final GameEngine b;
    // $FF: synthetic field
    final Runnable c;

    class_1060(Activity var1, GameEngine var2, Runnable var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void onClick(DialogInterface var1, int var2) {
        class_696 var3 = class_697.a(true);
        if (!var3.b) {
            GameEngine.log("Storage setup: Not using SAF, not showing setup folder popup");
            boolean var7 = class_208.b(this.a);
            if (var7) {
                this.b.settingsEngine.storageType = 2;
                this.b.settingsEngine.hasSelectedAStorageType = true;
                class_697.b();
                this.b.settingsEngine.save();
            }

        } else if (this.a instanceof class_202) {
            GameEngine.log("Storage setup: Already on settings page");
            class_202 var6 = (class_202)this.a;
            var6.l();
        } else {
            Intent var4 = new Intent(this.a, class_202.class);
            var4.putExtra("mode", "setupExternalFolder");
            class_208.a(var4);
            this.a.a(var4);
            if (this.a instanceof class_194) {
                if (this.c != null) {
                    class_1062 var5 = new class_1062(this);
                    ((class_194)this.a).a(var5);
                }
            } else {
                GameEngine.print("context not instance CommonActivity");
            }

        }
    }
}
