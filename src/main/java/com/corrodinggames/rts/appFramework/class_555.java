package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.13
class class_555 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final class_198 a;

    class_555(class_198 var1) {
        this.a = var1;
    }

    public void onClick(DialogInterface var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.netEngine.closeServer("exited");
        this.a.b();
    }
}
