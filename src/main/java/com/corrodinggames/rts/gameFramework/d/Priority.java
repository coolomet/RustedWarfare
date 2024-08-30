package com.corrodinggames.rts.gameFramework.d;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.d.h
public enum Priority {
    verylow,
    low,
    high,
    veryhigh,
    critical;
    // $FF: synthetic field
    public boolean a(Priority var1) {
        if (var1 == null) {
            return true;
        } else {
            return this.ordinal() < var1.ordinal();
        }
    }
}
