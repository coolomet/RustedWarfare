package com.corrodinggames.rts.gameFramework;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.bs
public strictfp class class_324 {
    public static final class_324 a = new class_325("total", 0);
    public static final class_324 b = new class_326("update", 1);
    public static final class_324 c = new class_327("draw", 2);
    public static final class_324 d = new class_328("draw_game", 3);
    public static final class_324 e = new class_324("draw_end", 4);
    public static final class_324 f = new class_324("draw_gui", 5);
    public static final class_324 g = new class_324("draw_game_effects", 6);
    public static final class_324 h = new class_324("update_game_shouldDraw", 7);
    public static final class_324 i = new class_324("update_game_sortRender", 8);
    public static final class_324 j = new class_324("update_do_all_collisions", 9);
    public static final class_324 k = new class_324("update_do_all_collisions2", 10);
    public static final class_324 l = new class_324("update_all_team_and_ai", 11);
    public static final class_324 m = new class_324("update_geo_indexes", 12);
    public static final class_324 n = new class_324("update_minimap", 13);
    public static final class_324 o = new class_324("update_groupcontroller", 14);
    public static final class_324 p = new class_324("draw_game_unit", 15);
    public static final class_324 q = new class_324("draw_setup", 16);
    public static final class_324 r = new class_324("draw_setup_fill", 17);
    public static final class_324 s = new class_324("draw_setup_clip", 18);
    public static final class_324 t = new class_324("draw_setup_drawMap", 19);
    public static final class_324 u = new class_324("surface_draw", 20);
    public static final class_324 v = new class_324("realdraw_in_drawthread", 21);
    public static final class_324 w = new class_324("update_waiting_on_draw", 22);
    public static final class_324 x = new class_324("draw_waiting_on_update", 23);
    public static final class_324 y = new class_324("load_total", 24);
    public static final class_324 z = new class_324("load_map", 25);
    public static final class_324 A = new class_324("load_units", 26);
    public static final class_324 B = new class_324("load_compression", 27);
    public static final class_324 C = new class_324("init_total", 28);
    public static final class_324 D = new class_324("init_unitcolour", 29);
    // $FF: synthetic field
    private static final class_324[] E = new class_324[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D};

    public static class_324[] values() {
        return (class_324[])E.clone();
    }
    private class_324(String var1, int var2) {
    }

    // $FF: synthetic method
    class_324(String var1, int var2, Unit$1 var3) {
        this(var1, var2);
    }
}
