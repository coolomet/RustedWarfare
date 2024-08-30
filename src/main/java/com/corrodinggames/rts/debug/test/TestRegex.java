package com.corrodinggames.rts.debug.test;

import com.corrodinggames.rts.a.a.class_650;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.e.GroupingStyle;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.game.units.custom.f.class_956;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_382;
import com.corrodinggames.rts.gameFramework.e.class_383;
import com.corrodinggames.rts.gameFramework.i.ModEngine;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_669;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public strictfp class TestRegex extends AbstractScriptTest {
    int a = 1;

    public void a() {
        GameEngine.log("separator regex test");
        "first".split(Pattern.quote(File.separator));
        class_650.a("first\\second".split(Pattern.quote("\\"))[0], "first");
        class_650.a("first/second".split(Pattern.quote("/"))[0], "first");
        GameEngine.log("Test for dis sq ranges");
        int var1 = 850000;
        int var2 = 8500000;
        class_650.a(50 < var1 * var1);
        class_650.a(50.0F < (float)(var1 * var1));
        class_650.a(50 < var2 * var2);
        class_650.a(50.0F < (float)(var2 * var2));
        Random var3 = new Random();
        float[] var4 = new float[10000];

        for(int var5 = 1; var5 < 5; ++var5) {
            int var6 = 0;

            for(int var7 = 0; var7 < var4.length; ++var7) {
                var4[var7] = var3.nextFloat() * 50.0F;
            }

            long var57 = Unit.loadAllUnitsTook();

            int var9;
            int var10;
            for(var9 = 0; var9 < 1000; ++var9) {
                for(var10 = 0; var10 < var4.length; ++var10) {
                    var6 += class_340.a((int)var4[var10]);
                }
            }

            GameEngine.log("sum:" + var6);
            GameEngine.log("fastSquareRootInt took:" + Unit.a((double)Unit.a(var57)));

            for(var9 = 0; var9 < var4.length; ++var9) {
                var4[var9] = var3.nextFloat() * 50.0F;
            }

            var57 = Unit.loadAllUnitsTook();
            var6 = 0;

            for(var9 = 0; var9 < 1000; ++var9) {
                for(var10 = 0; var10 < var4.length; ++var10) {
                    var6 = (int)((float)var6 + class_340.a((float)((int)var4[var10])));
                }
            }

            GameEngine.log("sum:" + var6);
            GameEngine.log("squareRoot took:" + Unit.a((double)Unit.a(var57)));
        }

        GameEngine.log("CommonUtils.fastSplit");
        String[] var54 = class_340.c("testA|testB", '|');
        class_650.a(var54.length, 2);
        class_650.a(var54[0], "testA");
        class_650.a(var54[1], "testB");
        var54 = class_340.c("test|", '|');
        class_650.a(var54.length, "test|".split("\\|").length);
        class_650.a(var54[0], "test");
        var54 = class_340.c("|test", '|');
        class_650.a(var54.length, 2);
        class_650.a(var54[0], "");
        class_650.a(var54[1], "test");
        var54 = class_340.c("|", '|');
        class_650.a(var54.length, 0);
        GameEngine.log("VariableReplacement");
        class_956 var55 = new class_956();
        var55.b.a("a", "5");
        var55.b.a("b", "10");
        var55.b.a("abc_foo", "7");
        class_591 var56 = class_591.b;

        UnitConfig var58;
        try {
            var58 = new UnitConfig("assets/" + var56.D);
        } catch (Exception var51) {
            throw new RuntimeException(var51);
        }

        String var8;
        try {
            var8 = var55.a(var56, var58, "core", "123");
            class_650.a(var8, "123");
            var8 = var55.a(var56, var58, "core", "1+1");
            class_650.a(var8, "2");
            var8 = var55.a(var56, var58, "core", "(1+1)*2");
            class_650.a(var8, "4");
            var8 = var55.a(var56, var58, "core", "a+b");
            class_650.a(var8, "15");
            var8 = var55.a(var56, var58, "core", "a+a+abc_foo");
            class_650.a(var8, "17");
            var8 = var55.a(var56, var58, "core", "(2+2)*(2+2)");
            class_650.a(var8, "16");
            var8 = var55.a(var56, var58, "core", "10/5");
            class_650.a(var8, "2");
            var8 = var55.a(var56, var58, "core", "10-5");
            class_650.a(var8, "5");
            var8 = var55.a(var56, var58, "core", "cos(60)");
            class_650.c(var8, "0.5");
            var8 = var55.a(var56, var58, "core", "sin(b+20+(2-2)+(5*0))");
            class_650.c(var8, "0.5");
        } catch (Exception var50) {
            throw new RuntimeException(var50);
        }

        GameEngine.log("PassthroughZipReader");
        class_650.a(class_669.l("/first/second/zip.rwmod/test1/test2"), "test1/test2");
        class_650.a(class_669.l("\\first\\second\\zip.rwmod\\test1\\test2"), "test1/test2");
        this.a("A", "B");
        this.a("AA=11", "BB=22");
        this.a("AA='11'", "BB='22'");
        this.a("AA=(11)", "BB=22");
        this.a("(AA)=(11)", "BB=22");
        this.a("(AA)=('11')", "BB=22");
        this.a("(AA)=('11')", "BB=((22))");
        this.a("(A,A)=('1,1')", "BB=((2,2))");
        this.a("(A,A)=('1,,1')", "BB=((2,2))");
        GameEngine.log("splitWithEscaping");
        this.a(class_675.b("hello world", ' '), "hello", "world");
        this.a(class_675.b("hello world", 'X'), "hello world");
        this.a(class_675.b("hello,world", ','), "hello", "world");
        this.a(class_675.b("he\\,llo,world", ','), "he,llo", "world");
        this.a("".split(" "), "");
        this.a(class_675.b("", ' '), "");
        this.a(class_675.b("hello\\\\,World", ','), "hello\\", "World");
        this.a(class_675.b("Hello\\A,world", ','), "HelloA", "world");
        this.a(class_675.b("h\\ello\\,world", ','), "hello,world");
        this.a(class_675.b("h\\ello\\,w,orld", ','), "hello,w", "orld");
        this.a(class_675.b("h\\ello\\,w,orld", ','), "hello,w", "orld");
        class_650.a(class_675.a(new String[]{"Hello"}), "Hello");
        class_650.a(class_675.a(new String[]{"Hello", "World"}), "Hello,World");
        class_650.a(class_675.a(new String[]{"Hel,lo", "World"}), "Hel\\,lo,World");
        class_650.a(class_675.a(new String[]{"Hel,lo,", "Wor,ld"}), "Hel\\,lo\\,,Wor\\,ld");
        class_650.a(class_675.a(new String[]{"Hel\\,lo,", "Wor,ld"}), "Hel\\\\\\,lo\\,,Wor\\,ld");
        class_650.a(class_675.a(new String[]{"H\\el\\,lo,", "Wor,ld"}), "H\\\\el\\\\\\,lo\\,,Wor\\,ld");
        GameEngine.log("FileLoaderBackend");
        var8 = "/tmp/rustedWarfareTests/";
        class_383 var59 = new class_383(var8, "test1");
        var59.a = "fileLoader1: ";
        var59.b = true;
        String var60 = "/tmp/rustedWarfareTestsSec2/";
        class_383 var11 = new class_383(var60, "test2");
        var11.a = "fileLoader2: ";
        var11.b = true;
        String var12 = "primary-PATH/";
        String var13 = "[ALT-PATH]/";
        class_382 var14 = new class_382(var59, var12, var11, var13);
        var14.a = "mergedFileLoader: ";
        var14.b = true;
        class_650.b(var59.f("/SD/rustedWarfare/"), var8);
        class_650.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
        class_650.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
        class_650.b(var59.f("units/test.ini"), "assets/units/test.ini");
        GameEngine.log("FileLoaderBackend - merged");
        class_650.b(var14.f("/SD/rustedWarfare/"), var8);
        class_650.b(var14.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "mods/maps/coolMap.tmx");
        boolean var15 = true;
        GameEngine.log("FileLoaderBackend - android fake");
        boolean var16 = GameEngine.isModsInSD;
        GameEngine.isModsInSD = false;

        try {
            class_650.b(var59.f("/SD/rustedWarfare/"), var8);
            class_650.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "maps/coolMap.tmx");
            class_650.b(var59.f("/SD/rustedWarfare/maps/coolMap.tmx"), var8 + "maps/coolMap.tmx");
            class_650.b(var59.f("units/test.ini"), "units/test.ini");
        } finally {
            GameEngine.isModsInSD = var16;
        }

        if (var15) {
            GameEngine.log("FileLoaderBackend - real file tests");
            String var17 = "/SD/rustedWarfare/testDir";
            File var18 = new File(var59.f(var17));
            var18.mkdirs();
            File var19 = new File(var11.f(var17));
            var19.mkdirs();
            boolean var41 = false;

            try {
                var41 = true;
                File var20 = new File(var59.f(var17 + "/map1.tmx"));
                var20.createNewFile();
                FileWriter var21 = new FileWriter(var20);
                var21.write("map1");
                var21.close();
                File var22 = new File(var59.f(var17 + "/map2.tmx"));
                var22.createNewFile();
                File var23 = new File(var11.f(var17 + "/map3.tmx"));
                var23.createNewFile();
                FileWriter var24 = new FileWriter(var23);
                var24.write("map3");
                var24.close();
                String[] var25 = var59.b(var17, false);
                class_650.a(var25.length, 2);
                class_650.b(var25[0], "map1.tmx");
                class_650.b(var25[1], "map2.tmx");
                var25 = var14.b(var17, false);
                class_650.a(var25.length, 3);
                class_650.b(var25[0], var12 + "map1.tmx");
                class_650.b(var25[1], var12 + "map2.tmx");
                class_650.b(var25[2], var13 + "map3.tmx");
                String var26 = var25[2];
                AssetInputStream var27 = var14.j(var17 + "/" + var26);
                if (var27 == null) {
                    throw new RuntimeException("Null for: " + var17 + "/" + var26);
                }

                class_650.b(class_340.b((InputStream)var27), "map3");
                var41 = false;
            } catch (IOException var52) {
                throw new RuntimeException(var52);
            } finally {
                if (var41) {
                    GameEngine.log("FileLoaderBackend - clean up");
                    String[] var29 = var18.list();
                    String[] var30 = var29;
                    int var31 = var29.length;

                    for(int var32 = 0; var32 < var31; ++var32) {
                        String var33 = var30[var32];
                        File var34 = new File(var18.getPath(), var33);
                        var34.delete();
                    }

                    var18.delete();
                }
            }

            GameEngine.log("FileLoaderBackend - clean up");
            String[] var61 = var18.list();
            String[] var62 = var61;
            int var63 = var61.length;

            for(int var64 = 0; var64 < var63; ++var64) {
                String var65 = var62[var64];
                File var66 = new File(var18.getPath(), var65);
                var66.delete();
            }

            var18.delete();
            GameEngine.log("isSameOrHigherVersion..");
            this.a("v1.13", "v1.14", true);
            this.a("v1.13", "v2.14", true);
            this.a("v1.13", "v2.11", true);
            this.a("v1.13", "v1.13p5", false);
            this.a("v1.13", "v1.13.2", true);
            this.a("v1.13.2", "v1.13", false);
            this.a("v1.13", "v1.13b", true);
            this.a("v1.13", "v1.13.2p6", true);
            this.a("v1.13", "v1.14.2p6", true);
            this.a("v1.13p9", "v1.14.2p6", true);
            this.a("v1.13p9", "v1.14p6", true);
            this.a("v1.14p3", "v1.14p6", true);
            this.a("v1.14p3", "v1.14p6b", true);
            this.a("v1.14p8", "v1.14p3", false);
            this.a("v1", "v2", true);
            this.a("v1.5", "v2", true);
            this.a("v2", "v1.15", false);
            this.a("v2.0.5", "v1.15", false);
            this.a("v1.15", "v2.0.5", true);
            this.a("v1.15.6", "v2.0.5", true);
            this.a("v1.15.6", "v1.16.5", true);
            this.a("v1.13", "v1.13.2p5", true);
            this.a("v1.14", "v1.14p3", false);
            this.a("v1.14b", "v1.14p3", false);
            this.a("v1.14.2", "v1.14p3", false);
            this.a("v1.14.2b", "v1.14p3", false);

            try {
                ModEngine.a("v1.11p1");
            } catch (Exception var48) {
                throw new RuntimeException(var48);
            }

            class_650.a(BuiltInResource.a("10000", GroupingStyle.NONE), "10000");
            class_650.a(BuiltInResource.a("", GroupingStyle.SPACE), "");
            class_650.a(BuiltInResource.a("1", GroupingStyle.COMMA), "1");
            class_650.a(BuiltInResource.a("10", GroupingStyle.COMMA), "10");
            class_650.a(BuiltInResource.a("100", GroupingStyle.COMMA), "100");
            class_650.a(BuiltInResource.a("1000", GroupingStyle.COMMA), "1,000");
            class_650.a(BuiltInResource.a(".", GroupingStyle.COMMA), ".");
            class_650.a(BuiltInResource.a(".2", GroupingStyle.COMMA), ".2");
            class_650.a(BuiltInResource.a(".22", GroupingStyle.COMMA), ".22");
            class_650.a(BuiltInResource.a(".223", GroupingStyle.COMMA), ".223");
            class_650.a(BuiltInResource.a(".2234", GroupingStyle.COMMA), ".2234");
            class_650.a(BuiltInResource.a("100.2234", GroupingStyle.COMMA), "100.2234");
            class_650.a(BuiltInResource.a("1000.2234", GroupingStyle.COMMA), "1,000.2234");
            class_650.a(BuiltInResource.a("10000", GroupingStyle.COMMA), "10,000");
            class_650.a(BuiltInResource.a("9800000", GroupingStyle.COMMA), "9,800,000");
            class_650.a(BuiltInResource.a("9800000.67", GroupingStyle.COMMA), "9,800,000.67");
            class_650.a(BuiltInResource.a("98000000.67", GroupingStyle.COMMA), "98,000,000.67");
            class_650.a(BuiltInResource.a("980000000.67", GroupingStyle.COMMA), "980,000,000.67");
            class_650.a(BuiltInResource.a("9800000001.67", GroupingStyle.COMMA), "9,800,000,001.67");
            class_650.a(BuiltInResource.a("9800000001.6", GroupingStyle.COMMA), "9,800,000,001.6");
            class_650.a(BuiltInResource.a("9800000001.", GroupingStyle.COMMA), "9,800,000,001.");
            class_650.a(BuiltInResource.a("9800000001", GroupingStyle.COMMA), "9,800,000,001");
            class_650.a(BuiltInResource.a(9800000L, GroupingStyle.COMMA), "9,800,000");
        }

    }

    public void a(String var1, String var2) {
        ArrayList var3 = class_675.a(var1 + "," + var2, ",", false, false);
        class_650.a((String)var3.get(0), var1);
        class_650.a((String)var3.get(1), var2);
    }

    public void a(String[] var1, String var2) {
        class_650.a(var1.length, 1);
        class_650.a(var1[0], var2);
    }

    public void a(String[] var1, String var2, String var3) {
        class_650.a(var1.length, 2);
        class_650.a(var1[0], var2);
        class_650.a(var1[1], var3);
    }

    public void a(String var1, String var2, boolean var3) {
        boolean var4 = false;

        try {
            ModEngine.a(var1, var2);
            var4 = true;
        } catch (Exception var6) {
            if (var3) {
                GameEngine.print(var6.getMessage());
            }

            var4 = false;
        }

        if (var4 != var3) {
            throw new RuntimeException("isSameOrHigherVersion(" + var1 + "," + var2 + "): Asset failed got: " + var4);
        }
    }
}
