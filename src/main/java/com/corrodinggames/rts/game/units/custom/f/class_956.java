package com.corrodinggames.rts.game.units.custom.f;

import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

import java.util.regex.Matcher;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.f.b
public strictfp class class_956 {
    public class_958 a;
    public class_958 b;

    public class_956() {
        this.a = new class_958();
        this.b = new class_958();
    }

    public class_956(class_958 var1, class_958 var2) {
        this.a = var1;
        this.b = var2;
    }

    public void a() {
        this.a.a();
        this.b.a();
    }

    public class_956 b() {
        class_956 var1 = new class_956(this.a, new class_958());
        return var1;
    }

    public static double a(String var0) {
        return (new class_56(var0)).b();
    }

    public boolean b(String var1) {
        if (var1.contains("*")) {
            return true;
        } else if (var1.contains("/")) {
            return true;
        } else if (var1.contains("+")) {
            return true;
        } else if (var1.contains("-")) {
            return true;
        } else if (var1.contains("(")) {
            return true;
        } else if (var1.contains(")")) {
            return true;
        } else if (var1.contains("^")) {
            return true;
        } else {
            return var1.contains("%");
        }
    }

    @SneakyThrows
    public String a(class_591 var1, UnitConfig var2, String var3, String var4) {
        var4 = var4.trim();
        boolean var5 = this.b(var4);
        int var6 = 0;
        StringBuffer var7 = new StringBuffer();
        Matcher var8 = class_957.b.matcher(var4);

        while(var8.find()) {
            ++var6;
            if (var6 > 100) {
                throw new CustomException("Too many loops while parsing");
            }

            String var9 = var8.group(0);
            if (!class_340.r(var9) && !var9.equals("int") && !var9.equals("cos") && !var9.equals("sin") && !var9.equals("sqrt")) {
                String var10 = this.b(var1, var2, var3, var9);
                if (var5 && !class_340.r(var10)) {
                    throw new CustomException("Cannot do maths on '" + var10 + "' from " + var9 + " (not a number)");
                }

                var8.appendReplacement(var7, Matcher.quoteReplacement(var10));
            }
        }

        var8.appendTail(var7);
        var4 = var7.toString();
        if (var5) {
            var4 = class_340.b(a(var4));
        }

        return var4;
    }

    @SneakyThrows
    public String b(class_591 var1, UnitConfig var2, String var3, String var4) {
        if (var4.contains(".")) {
            String[] var9 = class_340.c(var4, '.');
            if (var9.length != 2) {
                throw new CustomException("Unexpected key format: " + var4);
            } else {
                String var6 = var9[0];
                String var7 = var9[1];
                if (var6.equals("section")) {
                    var6 = var3;
                }

                String var8 = var2.getValueAsStaticString(var6, var7, (String)null);
                if (var8 == null) {
                    if (var6.equalsIgnoreCase("self")) {
                        throw new CustomException("Static $ block: Could not find: [" + var6 + "]" + var7 + " in this conf file. Hint: You might have wanted % instead of $ for a dynamic string");
                    } else {
                        throw new CustomException("Static $ block: Could not find: [" + var6 + "]" + var7 + " in this conf file");
                    }
                } else if (var8.contains("${")) {
                    throw new CustomException("Reference [" + var6 + "]" + var7 + " is dynamic, chaining is not yet supported");
                } else {
                    return var8;
                }
            }
        } else {
            String var5 = this.b.a(var4);
            if (var5 != null) {
                return var5;
            } else {
                var5 = this.a.a(var4);
                if (var5 != null) {
                    return var5;
                } else {
                    throw new CustomException("Could not find variable with name: " + var4);
                }
            }
        }
    }
}
