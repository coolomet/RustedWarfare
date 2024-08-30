package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.units.a.class_253;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.f.a.class_177;
import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.h.3
final class class_274 extends class_253 {
    class_274(String var1) {
        super(var1);
    }

    public String type() {
        return "Start playback of last a replay";
    }

    public String b() {
        return "Start Playback";
    }

    public String d() {
        String var1 = "Start Playback";
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = var2.replayEngine.j();
        if (!var3) {
            var1 = "Start Playback";
        } else {
            var1 = "Stop Playback";
        }

        return var1;
    }

    public boolean a(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        boolean var4 = var3.replayEngine.k();
        EditorOrBuilder var5 = EditorOrBuilder.L();
        if (var5 == null) {
            return false;
        } else {
            return var5.r != null && !var4;
        }
    }

    public boolean b(Unit var1) {
        EditorOrBuilder var2 = EditorOrBuilder.L();
        if (var2 == null) {
            return false;
        } else {
            return var2.r != null;
        }
    }

    public boolean a(Unit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = var2.replayEngine.j();
        return var3;
    }

    public boolean c(Unit var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        String var4 = EditorOrBuilder.L().r;
        if (var4 == null) {
            var3.i("No last replay found");
            return false;
        } else {
            boolean var5 = var3.replayEngine.j();
            if (!var5) {
                class_529 var6 = new class_529(this, var4);
                class_177 var7 = class_177.a("Start playback of last recording?", true);
                var7.a(class_1009.a("menus.common.ok"), new class_191(this, var7, var3, var6));
                var3.bS.a(var7);
            } else {
                class_530 var8 = new class_530(this);
                var3.a((Runnable)var8);
            }

            return false;
        }
    }
}
