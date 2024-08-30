package com.corrodinggames.rts.java;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.debug.ScriptServerSocket;
import com.corrodinggames.rts.game.EngineLoad;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_359;
import java.awt.Toolkit;
import org.lwjgl.Sys;

// $FF: renamed from: com.corrodinggames.rts.java.i
public strictfp class class_360 extends class_359 {
    Main a;

    public class_360(Main var1) {
        this.a = var1;
    }

    public void a(String var1, int var2) {
        GameEngine.log("slick queuing-alert:" + var1);
        ScriptEngine.getInstance().addRunnableToQueue(new class_490(this, var1));
    }

    public void a(String var1, String var2) {
        GameEngine.log("slick queuing-messageBox:" + var2);
        ScriptEngine.getInstance().addRunnableToQueue(new class_491(this, var2, var1));
    }

    public void a(String var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (var3 == null || !var3.bj) {
            if (this.a.j != null) {
                this.a.j.a(var1, var2);
            }

        }
    }

    public void d() {
        GameEngine.log("refreshModDisplay");
        ScriptEngine.getInstance().addScriptToQueue("mods.refreshModList()");
    }

    public void a(Throwable var1) {
        this.a(var1, true);
    }

    public void a(Throwable var1, boolean var2) {
        try {
            GameEngine.log("----------- onGameCrash ----------");
            Toolkit.getDefaultToolkit();
            String var3 = GameEngine.b(var1);
            String var4 = var3 + "\nCheck logs for more details";
            GameEngine.log("Error message: " + var4);
            if (ScriptServerSocket.a()) {
                GameEngine.log("onGameCrash: Not showing popup message due to active debugSocket");
                System.exit(1);
                return;
            }

            if (var1 != null && var1 instanceof OutOfMemoryError && !EngineLoad.b) {
                var4 = var4 + " (You are also using the 32 bit version, switching to the 64 bit version might help with out of memory)";
            }

            Sys.alert("Crash", var4);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }

            GameEngine.log("onGameCrash: end");
        } catch (Throwable var7) {
            GameEngine.log("exception showing message");
            var7.printStackTrace();
        }

    }

    public boolean b() {
        return !GameEngine.getGameEngine().I() && !this.a.p.b();
    }

    public boolean c() {
        return ScriptServerSocket.a();
    }
}
