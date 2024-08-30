package com.corrodinggames.rts.game.units;

import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.ao
public enum MovementType {
    NONE,
    LAND,
    BUILDING,
    AIR,
    WATER,
    HOVER,
    OVER_CLIFF,
    OVER_CLIFF_WATER;

    public static strictfp MovementType a(String var0, String var1) {
        try {
            return valueOf(var0.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException var8) {
            String var3 = "";
            MovementType[] var4 = values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                MovementType var7 = var4[var6];
                var3 = var3 + ", " + var7.toString();
            }

            throw new IllegalArgumentException("Unknown movement type:'" + var0 + "' possible type:" + var3 + " on key:" + var1);
        }
    }
}
