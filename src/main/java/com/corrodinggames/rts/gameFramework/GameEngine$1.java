package com.corrodinggames.rts.gameFramework;

import android.widget.Toast;

class GameEngine$1 implements Runnable {
    // $FF: synthetic field
    final GameEngine a;

    GameEngine$1(GameEngine var1) {
        this.a = var1;
    }

    public void run() {
        String var1 = this.a.dE;

        try {
            if (var1 == null) {
                GameEngine.print("Cannot show toast, no message");
                return;
            }

            byte var2 = 1;
            Toast var3 = Toast.makeText(this.a.am, var1, var2);
            var3.show();
        } catch (Exception var4) {
            GameEngine.print("Error showing toast: " + var1);
            var4.printStackTrace();
        }

    }
}
