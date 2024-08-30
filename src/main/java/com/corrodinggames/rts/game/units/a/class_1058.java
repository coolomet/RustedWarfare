package com.corrodinggames.rts.game.units.a;

import com.corrodinggames.rts.gameFramework.h.class_1009;

// $FF: renamed from: com.corrodinggames.rts.game.units.a.k
public enum class_1058 {
    NORMAL("normal", 0),
    ATTACK("attack", 1),
    DEFEND("defend", 2),
    NUKE("nuke", 3),
    BUILD("build", 4),
    UPGRADE("upgrade", 5),
    OK("ok", 6),
    NO("no", 7),
    HAPPY("happy", 8),
    SAD("sad", 9),
    RETREAT("retreat", 10);
    // $FF: synthetic field
    private static final class_1058[] l = new class_1058[]{NORMAL, ATTACK, DEFEND, NUKE, BUILD, UPGRADE, OK, NO, HAPPY, SAD, RETREAT};
    class_1058(String var1, int var2) {
    }

    public String type() {
        return " - " + this.b();
    }

    public String b() {
        return class_1009.a(this.c());
    }

    public String c() {
        return "menus.ingame.ping.type." + this.name();
    }
}
