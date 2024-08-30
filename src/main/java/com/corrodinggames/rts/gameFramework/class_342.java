package com.corrodinggames.rts.gameFramework;

import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.g
public final strictfp class class_342 {
    protected static SystemType a;

    public static strictfp SystemType a() {
        if (a == null) {
            String var0 = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if (var0.indexOf("mac") < 0 && var0.indexOf("darwin") < 0) {
                if (var0.indexOf("win") >= 0) {
                    a = SystemType.WINDOWS;
                } else if (var0.indexOf("nux") >= 0) {
                    a = SystemType.LINUX;
                } else {
                    a = SystemType.OTHER;
                }
            } else {
                a = SystemType.MACOS;
            }
        }

        return a;
    }
}
