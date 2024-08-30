package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_337;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.10
class class_554 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final class_198 a;

    class_554(class_198 var1) {
        this.a = var1;
    }

    public void onClick(DialogInterface var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        var3.L();
        var3.a(true, class_337.NORMAL);
        var3.J();
    }
}
