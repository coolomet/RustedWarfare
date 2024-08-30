package com.corrodinggames.rts.gameFramework;

public enum SystemType {
    WINDOWS("Windows", 0),
    MACOS("MacOS", 1),
    LINUX("Linux", 2),
    OTHER("Other", 3);
    // $FF: synthetic field
    private static final SystemType[] e = new SystemType[]{WINDOWS, MACOS, LINUX, OTHER};
    SystemType(String var1, int var2) {
    }
}
