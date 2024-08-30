package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.net.GameNetAPIOperate;
import com.corrodinggames.rts.gameFramework.utility.class_21;
import com.corrodinggames.rts.gameFramework.utility.class_702;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

final class GameEngine$4 implements class_21 {
    public strictfp void a(class_702 var1) {
        if (GameEngine.dT) {
            GameEngine.print("activeANRWatchDog: ANR already detected");
        }

        GameEngine.dT = true;
        GameEngine.print("activeANRWatchDog: ANR detected");
        String var2 = GameEngine.a((Throwable)var1);
        GameNetAPIOperate.a("detectedANR", var2);

        try {
            Thread.sleep(400L);
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        }

        try {
            File var3 = GameSaver.a("lastFreeze", "", true);
            FileOutputStream var4 = new FileOutputStream(var3);
            PrintStream var5 = new PrintStream(var4);
            var5.print(var2);
            var5.close();
            var4.close();
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }
    }
}
