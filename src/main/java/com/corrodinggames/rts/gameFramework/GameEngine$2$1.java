package com.corrodinggames.rts.gameFramework;

import android.content.DialogInterface;

class GameEngine$2$1 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final GameEngine$2 a;

    GameEngine$2$1(GameEngine$2 var1) {
        this.a = var1;
    }

    public void onClick(DialogInterface var1, int var2) {
        this.a.a.bp = false;
    }
}
