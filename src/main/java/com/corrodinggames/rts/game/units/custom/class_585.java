package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.g
public final strictfp class class_585 {
    final String a;
    public static ArrayList b = new ArrayList();
    public static final class_585[] c = new class_585[0];
    public static final class_588 d;

    private class_585(String var1) {
        this.a = var1;
    }

    public String toString() {
        return this.a;
    }

    public static class_588 a(String var0) {
        return a((String)var0, (class_588)null);
    }

    public static class_588 a(String var0, class_588 var1) {
        if (var0 == null) {
            return var1;
        } else if (var0.trim().equals("")) {
            return var1;
        } else {
            ArrayList var2 = new ArrayList();
            String[] var3 = var0.split(",");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String var6 = var3[var5];
                var6 = var6.trim();
                if (!var6.equals("")) {
                    class_585 var7 = c(var6);
                    if (!var2.contains(var7)) {
                        var2.add(var7);
                    }
                }
            }

            if (var2.size() == 0) {
                return var1;
            } else {
                class_588 var8 = new class_588((class_585[])var2.toArray(new class_585[0]));
                return var8;
            }
        }
    }

    @SneakyThrows
    public static class_585 b(String var0) {
        var0 = var0.trim();
        if (var0.contains(",")) {
            throw new CustomException("Expected single tag, got:" + var0);
        } else {
            return c(var0);
        }
    }

    public static class_585 c(String var0) {
        var0 = var0.trim();
        var0 = var0.toLowerCase(Locale.ROOT);
        Iterator var1 = b.iterator();

        class_585 var2;
        do {
            if (!var1.hasNext()) {
                class_585 var3 = new class_585(var0);
                b.add(var3);
                return var3;
            }

            var2 = (class_585)var1.next();
        } while(!var2.a.equals(var0));

        return var2;
    }

    public static void a(class_588 var0, GameOutputStream var1) {
        if (var0 == null) {
            var1.writeIsString((String)null);
        } else if (var0.a.length == 0) {
            var1.writeIsString("");
        } else {
            StringBuilder var2 = new StringBuilder();
            boolean var3 = true;
            class_585[] var4 = var0.a;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                class_585 var7 = var4[var6];
                if (!var3) {
                    var2.append(",");
                }

                var3 = false;
                var2.append(var7.a);
            }

            var1.writeIsString(var2.toString());
        }

    }

    public static class_588 a(GameInputStream var0) {
        String var1 = var0.isReadString();
        if (var1 == null) {
            return null;
        } else {
            class_588 var2 = a(var1, d);
            return var2;
        }
    }

    public static boolean a(class_588 var0, class_588 var1) {
        if (var1 == null) {
            return false;
        } else {
            class_585[] var2 = var0.a;
            int var3 = var2.length;
            class_585[] var4 = var1.a;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var3; ++var6) {
                for(int var7 = 0; var7 < var5; ++var7) {
                    if (var2[var6] == var4[var7]) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public static boolean a(class_585 var0, class_588 var1) {
        if (var1 == null) {
            return false;
        } else {
            class_585[] var2 = var1.a;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == var0) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean b(class_588 var0, class_588 var1) {
        if (var1 == null) {
            return var0 == null || var0.b() == 0;
        } else {
            class_585[] var2 = var0.a;
            int var3 = var2.length;
            class_585[] var4 = var1.a;
            int var5 = var4.length;

            for(int var6 = 0; var6 < var3; ++var6) {
                boolean var7 = false;

                for(int var8 = 0; var8 < var5; ++var8) {
                    if (var2[var6] == var4[var8]) {
                        var7 = true;
                        break;
                    }
                }

                if (!var7) {
                    return false;
                }
            }

            return true;
        }
    }

    static {
        d = new class_588(c);
    }
}
