package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.s
public enum CheckRate {
    EVERY_FRAME("everyFrame", 0),
    EVERY_4_FRAMES("every4Frames", 1),
    EVERY_8_FRAMES("every8Frames", 2);
    // $FF: synthetic field
    private static final CheckRate[] d = new CheckRate[]{EVERY_FRAME, EVERY_4_FRAMES, EVERY_8_FRAMES};
    CheckRate(String var1, int var2) {
    }
}
