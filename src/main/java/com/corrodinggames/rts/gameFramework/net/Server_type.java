package com.corrodinggames.rts.gameFramework.net;

public enum Server_type {
    LAYOUT_2_SIDES("layout_2sides", 0),
    LAYOUT_3_SIDES("layout_3sides", 1),
    LAYOUT_FFA("layout_ffa", 2),
    LAYOUT_SPECTATORS("layout_spectators", 3);
    // $FF: synthetic field
    private static final Server_type[] e = new Server_type[]{LAYOUT_2_SIDES, LAYOUT_3_SIDES, LAYOUT_FFA, LAYOUT_SPECTATORS};
    Server_type(String var1, int var2) {
    }
}
