package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes$MissingKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ad
public strictfp class class_987 {
    public String a;
    public boolean b = false;
    public ArrayList c = new ArrayList();
    public ArrayList d = new ArrayList();

    public boolean a() {
        Iterator var1 = this.c.iterator();

        class_991 var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = (class_991)var1.next();
        } while(var2.a != -1 || !var2.a());

        return true;
    }

    public boolean b() {
        Iterator var1 = this.c.iterator();

        class_991 var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = (class_991)var1.next();
        } while(var2 == null || var2.a != -1 || !var2.b());

        return true;
    }

    public String c() {
        Iterator var1 = this.c.iterator();

        class_991 var2;
        do {
            if (!var1.hasNext()) {
                return "";
            }

            var2 = (class_991)var1.next();
        } while(var2 == null);

        return var2.c().toUpperCase();
    }

    public class_991 a(int var1) {
        if (this.c.size() > var1) {
            class_991 var2 = (class_991)this.c.get(var1);
            return var2;
        } else {
            return null;
        }
    }

    public String b(int var1) {
        if (this.c.size() > var1) {
            class_991 var2 = (class_991)this.c.get(var1);
            return var2 == null ? "<null>" : var2.c().toUpperCase();
        } else {
            return "";
        }
    }

    public class_987 c(int var1) {
        byte var2 = 0;
        return this.a(var1, 0, var2, false);
    }

    public class_987 a(int var1, int var2, int var3, boolean var4) {
        class_994 var5 = new class_994();
        var5.e = var1;
        var5.a = -1;
        var5.b = var3;
        if (var4) {
            var5.d = true;
        }

        if (this.c.size() <= var2) {
            this.c.add(new class_992());
        }

        if (this.c.size() <= var2) {
            this.c.add(new class_992());
        }

        this.c.set(var2, var5);
        return this;
    }

    public class_987 a(String var1) {
        return this.a(var1, -1);
    }

    public class_987 a(String var1, int var2) {
        if (var1 == null) {
            throw new RuntimeException("key==null");
        } else {
            return this.a(-1, var1, var2);
        }
    }

    public class_987 a(int var1, String var2, int var3) {
        if (var2 == null) {
            throw new RuntimeException("key==null");
        } else {
            class_994 var4 = new class_994();
            var4.a = var1;
            var4.b = 0;
            var2 = var2.toLowerCase(Locale.ENGLISH);
            if (var2.contains("alt+")) {
                var2 = var2.replace("alt+", "");
                var4.b += 4;
            }

            if (var2.contains("ctrl+")) {
                var2 = var2.replace("ctrl+", "");
                ++var4.b;
            }

            if (var2.contains("shift+")) {
                var2 = var2.replace("shift+", "");
                var4.b += 2;
            }

            try {
                var4.e = class_985.d(var2);
                if (var3 == -1) {
                    this.c.add(var4);
                } else {
                    if (this.c.size() <= var3) {
                        this.c.add(new class_992());
                    }

                    if (this.c.size() <= var3) {
                        this.c.add(new class_992());
                    }

                    this.c.set(var3, var4);
                }
            } catch (Exception var7) {
                var7.printStackTrace();
                GameEngine var6 = GameEngine.getGameEngine();
                if (var6 != null) {
                    var6.log(var7.getMessage(), 1);
                }
            }

            return this;
        }
    }

    public class_987 b(int var1, int var2, int var3, boolean var4) {
        class_993 var5 = new class_993();
        var5.a = var1;
        var5.e = var2;
        var5.f = var3;
        var5.g = var4;

        try {
            var5.i = var5.a(true);
        } catch (IndexOutOfBoundsException var7) {
            GameEngine.print("Failed to bind Axis:" + var3 + " on joystick:" + var2);
            return this;
        }

        this.c.add(var5);
        return this;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.a.replace("-", "").replace("  ", " ").replace("  ", " ").replace(" ", "_").toLowerCase(Locale.ENGLISH);
    }
}
