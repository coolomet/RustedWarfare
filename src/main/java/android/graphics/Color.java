package android.graphics;

import java.util.HashMap;
import java.util.Locale;

public class Color {
    private static final HashMap a = new HashMap();

    public static int a(int var0) {
        return var0 >>> 24;
    }

    public static int b(int var0) {
        return var0 >> 16 & 255;
    }

    public static int c(int var0) {
        return var0 >> 8 & 255;
    }

    public static int d(int var0) {
        return var0 & 255;
    }

    public static int a(int var0, int var1, int var2) {
        return -16777216 | var0 << 16 | var1 << 8 | var2;
    }

    public static int a(int var0, int var1, int var2, int var3) {
        return var0 << 24 | var1 << 16 | var2 << 8 | var3;
    }

    public static int a(String var0) {
        if (var0.charAt(0) == '#') {
            long var3 = Long.parseLong(var0.substring(1), 16);
            if (var0.length() == 7) {
                var3 |= -16777216L;
            } else if (var0.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            }

            return (int)var3;
        } else {
            Integer var1 = (Integer)a.get(var0.toLowerCase(Locale.ROOT));
            if (var1 != null) {
                return var1;
            } else {
                throw new IllegalArgumentException("Unknown color");
            }
        }
    }

    static {
        a.put("black", -16777216);
        a.put("darkgray", -12303292);
        a.put("gray", -7829368);
        a.put("lightgray", -3355444);
        a.put("white", -1);
        a.put("red", -65536);
        a.put("green", -16711936);
        a.put("blue", -16776961);
        a.put("yellow", -256);
        a.put("cyan", -16711681);
        a.put("magenta", -65281);
        a.put("aqua", -16711681);
        a.put("fuchsia", -65281);
        a.put("darkgrey", -12303292);
        a.put("grey", -7829368);
        a.put("lightgrey", -3355444);
        a.put("lime", -16711936);
        a.put("maroon", -8388608);
        a.put("navy", -16777088);
        a.put("olive", -8355840);
        a.put("purple", -8388480);
        a.put("silver", -4144960);
        a.put("teal", -16744320);
    }
}
