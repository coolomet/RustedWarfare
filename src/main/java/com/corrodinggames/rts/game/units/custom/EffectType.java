package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.az
public enum EffectType {
    SMALL("small", 0),
    MEDIUM("medium", 1),
    LARGE("large", 2),
    SMOKE("smoke", 3),
    SHOCKWAVE("shockwave", 4),
    LARGE_EXPLOSION("largeExplosion", 5),
    SMALL_EXPLOSION("smallExplosion", 6),
    RESOURCE_POOL_SMOKE("resourcePoolSmoke", 7),
    NONE_EXPLOSION("noneExplosion", 8);
    // $FF: synthetic field
    private static final EffectType[] j = new EffectType[]{SMALL, MEDIUM, LARGE, SMOKE, SHOCKWAVE, LARGE_EXPLOSION, SMALL_EXPLOSION, RESOURCE_POOL_SMOKE, NONE_EXPLOSION};
    EffectType(String var1, int var2) {
    }
}
