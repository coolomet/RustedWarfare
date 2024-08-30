package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.14
class class_556 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final class_198 a;

    class_556(class_198 var1) {
        this.a = var1;
    }

    public void onClick(DialogInterface var1, int var2) {
        GameEngine.log("Returning to battleroom clicked.");
        GameEngine var3 = GameEngine.getGameEngine();
        var3.netEngine.ag();
        var3.bS.u = false;
    }
}
