package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

public class ScriptEngine$RunnableAction extends ScriptEngine$Action {
    Runnable runnable;

    ScriptEngine$RunnableAction(Runnable var1) {
        this.runnable = var1;
    }

    public void run(ScriptEngine var1) {
        try {
            this.runnable.run();
        } catch (Exception var6) {
            if (!this.tryToCatchCrash) {
                throw new RuntimeException(var6);
            }

            GameEngine.a((String)"caught script crash", (Throwable)var6);
            this.caughtCrash = class_340.a(var6);
        } finally {
            this.completed = true;
        }

    }
}
