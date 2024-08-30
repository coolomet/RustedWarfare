package com.corrodinggames.rts.gameFramework;

import android.content.DialogInterface;

class GameEngine$2$2 implements DialogInterface.OnCancelListener {
    // $FF: synthetic field
    final GameEngine$2 a;

    GameEngine$2$2(GameEngine$2 var1) {
        this.a = var1;
    }

    public void onCancel(DialogInterface var1) {
        this.a.a.bp = false;
    }
}
