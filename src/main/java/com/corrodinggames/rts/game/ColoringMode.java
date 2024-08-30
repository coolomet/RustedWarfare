package com.corrodinggames.rts.game;

// $FF: renamed from: com.corrodinggames.rts.game.o
public enum ColoringMode {
    PURE_GREEN("pureGreen", 0),
    HUE_ADD("hueAdd", 1),
    HUE_NEW("hueNew", 2),
    HUE_SHIFT("hueShift", 3),
    DISABLED("disabled", 4);
    // $FF: synthetic field
    private static final ColoringMode[] f = new ColoringMode[]{PURE_GREEN, HUE_ADD, HUE_NEW, HUE_SHIFT, DISABLED};
    ColoringMode(String var1, int var2) {
    }
}
