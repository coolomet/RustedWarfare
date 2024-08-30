package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

public class ScriptEngine$Action {
    public String script;
    public boolean tryToCatchCrash;
    public String caughtCrash;
    public boolean completed;
    public int framesDelay;

    public void run(ScriptEngine var1) {
        try {
            var1.processScript(this.script);
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

    public String waitForCompletionOrCrash(boolean var1) {
        for(int var2 = 0; var2 < 3000; ++var2) {
            if (this.completed) {
                return this.caughtCrash;
            }

            try {
                Thread.sleep(10L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

            if (var1) {
                var2 = 0;
            }
        }

        return "Time Out";
    }
}
