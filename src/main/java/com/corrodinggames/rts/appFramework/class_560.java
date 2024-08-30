package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import android.widget.EditText;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.16
class class_560 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final EditText a;
    // $FF: synthetic field
    final boolean b;
    // $FF: synthetic field
    final class_198 c;

    class_560(class_198 var1, EditText var2, boolean var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void onClick(DialogInterface var1, int var2) {
        String var3 = this.a.getText().toString();
        GameEngine var4 = GameEngine.getGameEngine();
        if (!var3.trim().equals("")) {
            if (this.b) {
                var4.netEngine.l(var3);
            } else {
                var4.netEngine.m(var3);
            }
        }

        var4.bS.u = false;
    }
}
