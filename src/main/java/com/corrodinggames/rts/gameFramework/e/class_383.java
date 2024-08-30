package com.corrodinggames.rts.gameFramework.e;

import com.corrodinggames.rts.gameFramework.file.FileLoader;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.e.d
public strictfp class class_383 extends FileLoader {
    String g;
    String h;
    String i;

    public class_383(String var1, String var2) {
        this.g = var1;
        this.h = var2;
        if (!this.g.endsWith("/") && !this.g.endsWith("\\")) {
            this.g = this.g + "/";
        }

    }

    public String b() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public boolean e() {
        return false;
    }

    public String e(String var1) {
        String var2 = super.e(var1);
        if (this.i != null && var2 != null && var2.startsWith(this.g)) {
            var2 = var2.substring(this.g.length());
            if (var2.startsWith("/") || var2.startsWith("\\")) {
                var2 = var2.substring(1);
            }

            var2 = this.i + var2;
        }

        return var2;
    }
}
