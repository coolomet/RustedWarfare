package com.corrodinggames.rts.gameFramework;

import android.app.AlertDialog;
import android.view.WindowManager;

class GameEngine$2 implements Runnable {
    // $FF: synthetic field
    final GameEngine a;

    GameEngine$2(GameEngine var1) {
        this.a = var1;
    }

    public void run() {
        GameEngine$2$1 var1 = new GameEngine$2$1(this);
        GameEngine$2$2 var2 = new GameEngine$2$2(this);
        GameEngine.log("showMessageBoxRunnable context:" + this.a.am.getClass().getName());

        try {
            (new AlertDialog.Builder(this.a.am)).setIcon(17301543).setTitle(this.a.dF).setMessage(this.a.dG).setOnCancelListener(var2).setPositiveButton("Ok", var1).show();
        } catch (WindowManager.BadTokenException var4) {
            GameEngine.print("Failed to show message: " + this.a.dG);
            var4.printStackTrace();
        }

    }
}
