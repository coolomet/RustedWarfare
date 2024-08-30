package com.corrodinggames.rts.gameFramework.i;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.f.InterfaceEngine;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import com.corrodinggames.rts.gameFramework.utility.class_670;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

public strictfp class ModEngine {
    public static String a;
    public static String b;
    public class_800 c = new class_800();
    Object d = new Object();
    ArrayList e = new ArrayList();
    ArrayList f = new ArrayList();


    public ModEngine() {
        try {
            a(GameEngine.getGameEngine().u());
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    @SneakyThrows
    private static int a(String var0, int var1) {
        String[] var2 = class_340.c(var0, '.');
        if (var2 == null) {
            throw new CustomException("Unexpected version format (Missing " + var1 + ")");
        } else if (var2.length > 3) {
            throw new CustomException("Unexpected version format (" + var0 + ")");
        } else if (var2.length <= var1) {
            return 0;
        } else {
            try {
                return Integer.valueOf(var2[var1]);
            } catch (NumberFormatException var4) {
                throw new CustomException("Unexpected version format (Bad " + var1 + ")", var4);
            }
        }
    }

    public static void a(String var0) {
        String var1 = GameEngine.getGameEngine().u();
        a(var0, var1);
    }

    public static String b(String var0) {
        var0 = class_340.decodeTextAsMultiline(var0, "v", "");
        var0 = var0.trim();
        var0 = class_340.decodeTextAsMultiline(var0, "a", "");
        var0 = class_340.decodeTextAsMultiline(var0, "b", "");
        var0 = class_340.decodeTextAsMultiline(var0, "c", "");
        var0 = class_340.decodeTextAsMultiline(var0, "d", "");
        var0 = class_340.decodeTextAsMultiline(var0, "e", "");
        var0 = class_340.decodeTextAsMultiline(var0, "f", "");
        var0 = class_340.decodeTextAsMultiline(var0, "g", "");
        var0 = class_340.decodeTextAsMultiline(var0, "h1", "");
        var0 = class_340.decodeTextAsMultiline(var0, "h2", "");
        var0 = class_340.decodeTextAsMultiline(var0, "h3", "");
        var0 = class_340.decodeTextAsMultiline(var0, "h4", "");
        return var0;
    }

    @SneakyThrows
    public static void a(String var0, String var1) {
        var1 = b(var1);
        var0 = b(var0);
        String var2 = var0;
        String var3 = var1;

        try {
            int var4 = 1000;
            int var5 = 1000;
            String[] var6;
            if (var1.contains("p")) {
                var6 = class_675.b(var1, "p");

                try {
                    var4 = Integer.valueOf(var6[1]);
                } catch (NumberFormatException var15) {
                    throw new CustomException("Unexpected min version:" + var2 + " (Bad build number)", var15);
                }

                var1 = var6[0];
            }

            if (var0.contains("p")) {
                var6 = class_675.b(var0, "p");

                try {
                    var5 = Integer.valueOf(var6[1]);
                } catch (NumberFormatException var14) {
                    throw new CustomException("Unexpected min version:" + var2 + "(Bad build number)", var14);
                }

                var0 = var6[0];
            }

            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var17;
            try {
                var17 = a(var1, 0);
                var7 = a(var0, 0);
                var8 = a(var1, 1);
                var9 = a(var0, 1);
                var10 = a(var1, 2);
                var11 = a(var0, 2);
            } catch (Exception var13) {
                throw new CustomException("Requires version: " + var2 + " or higher. " + var13.getMessage(), var13);
            }

            if (var7 < 1) {
                throw new CustomException("Min version cannot be less than v1.10");
            } else if (var7 > var17) {
                throw new CustomException("Requires version: " + var2 + " or higher. (You have: " + var3 + ")");
            } else if (var17 <= var7) {
                if (var9 < 10 && var7 == 1) {
                    throw new CustomException("Min version cannot be less than v1.10");
                } else if (var9 > var8) {
                    throw new CustomException("Requires version: " + var2 + " or higher. (You have: " + var3 + ")");
                } else if (var8 <= var9) {
                    if (var11 > var10) {
                        throw new CustomException("Requires version: " + var2 + " or higher. (You have: " + var3 + ")");
                    } else if (var10 <= var11) {
                        if (var5 > var4) {
                            throw new CustomException("Requires newer build: " + var2 + " or higher. (You have: " + var3 + ")");
                        }
                    }
                }
            }
        } catch (RuntimeException var16) {
            throw new CustomException("Requires version: " + var0 + " or higher." + var16.getMessage(), var16);
        }
    }

    public void a() {
        this.k();
        this.f();
    }

    public int a(boolean var1) {
        int var2 = 0;
        Iterator var3 = this.e.iterator();

        while(true) {
            class_800 var4;
            do {
                do {
                    do {
                        if (!var3.hasNext()) {
                            return var2;
                        }

                        var4 = (class_800)var3.next();
                    } while(var4.f);
                } while(var4.D);
            } while(var1 && var4.R != null);

            ++var2;
        }
    }

    public int b() {
        int var1 = 0;
        Iterator var2 = this.e.iterator();

        while(var2.hasNext()) {
            class_800 var3 = (class_800)var2.next();
            if (!var3.f && var3.R != null) {
                ++var1;
            }
        }

        return var1;
    }

    public int c() {
        int var1 = 0;
        Iterator var2 = this.e.iterator();

        while(var2.hasNext()) {
            class_800 var3 = (class_800)var2.next();
            if (!var3.z) {
                ++var1;
            }
        }

        return var1;
    }

    public void d() {
        class_800 var2;
        for(Iterator var1 = this.e.iterator(); var1.hasNext(); var2.h = false) {
            var2 = (class_800)var1.next();
            var2.g = var2.f;
        }

    }

    public void e() {
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = "";

        class_800 var4;
        String var5;
        String var6;
        for(Iterator var3 = this.e.iterator(); var3.hasNext(); var2 = var2 + var5 + "|" + var4.e + "|" + var6) {
            var4 = (class_800)var3.next();
            var5 = var4.c;
            var5 = var5.replace(",", " ");
            var5 = var5.replace("|", " ");
            if (var5.length() > 15) {
                var5 = var5.substring(12) + "...";
            }

            if (var2.length() != 0) {
                var2 = var2 + ",";
            }

            var6 = var4.f ? "disabled" : "enabled";
        }

        var1.settingsEngine.modSettingsVersion = 1;
        var1.settingsEngine.modSettings = var2;
    }

    public void f() {
        GameEngine.log("Loading mod selection");
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = var1.settingsEngine.modSettings;
        String[] var3 = var2.split(",");
        String[] var4 = var3;
        int var5 = var3.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            String[] var8 = var7.split("\\|");
            if (var8.length != 3) {
                GameEngine.log("loadSelection: wrong count (" + var8.length + "):" + var7);
            } else {
                String var9 = var8[0];
                String var10 = var8[1];
                String var11 = var8[2];
                boolean var12;
                if (var11.equals("enabled")) {
                    var12 = false;
                } else {
                    if (!var11.equals("disabled")) {
                        GameEngine.log("loadSelection: Unknown option:" + var7);
                        continue;
                    }

                    var12 = true;
                }

                class_800 var13 = this.c(var10);
                if (var13 == null) {
                    GameEngine.log("loadSelection: Did not find mod in settings:" + var9);
                } else {
                    var13.f = var12;
                    var13.i = true;
                }
            }
        }

    }

    public class_800 c(String var1) {
        Iterator var2 = this.e.iterator();

        class_800 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_800)var2.next();
        } while(!var3.e.equals(var1));

        return var3;
    }

    public int d(String var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = 0;
            Iterator var3 = this.e.iterator();

            while(var3.hasNext()) {
                class_800 var4 = (class_800)var3.next();
                if (var1.equals(var4.c())) {
                    ++var2;
                }
            }

            return var2;
        }
    }

    public class_800 a(int var1) {
        Iterator var2 = this.e.iterator();

        class_800 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_800)var2.next();
        } while(var3.L != var1);

        return var3;
    }

    public void g() {
        class_800 var2;
        for(Iterator var1 = this.e.iterator(); var1.hasNext(); var2.f = true) {
            var2 = (class_800)var1.next();
        }

    }

    public int h() {
        int var1 = 0;
        Iterator var2 = this.e.iterator();

        while(true) {
            class_800 var3;
            do {
                if (!var2.hasNext()) {
                    return var1;
                }

                var3 = (class_800)var2.next();
            } while(var3.f && !var3.D);

            ++var1;
        }
    }

    public class_800 e(String var1) {
        Iterator var2 = this.e.iterator();

        class_800 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_800)var2.next();
        } while(!var3.d.equals(var1));

        return var3;
    }

    public class_800 f(String var1) {
        Iterator var2 = this.e.iterator();

        class_800 var3;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            var3 = (class_800)var2.next();
        } while(!var3.modName().equals(var1));

        return var3;
    }

    public class_800 a(String var1, String var2, String var3, String var4, boolean var5, boolean var6, boolean var7, int var8) {
        class_800 var9 = this.c(var4);
        if (var9 == null) {
            var9 = new class_800();
            var9.c = var1;
            var9.d = var2;
            var9.e = var4;
            var9.f = !var5;
        }

        if (var9.q == null && var3 != null) {
            var9.q = var3;
            var9.p = var9.q;
            var9.n();
            if (var9.q != null && var9.q.toLowerCase(Locale.ROOT).contains("rwmod")) {
                var9.j = true;
            }
        }

        var9.x = var8;
        var9.l = true;
        var9.y = var6;
        var9.z = var7;
        if (!var9.z) {
            var9.o = "Storage: " + class_697.d(var9.q);
        }

        var9.r();
        synchronized(this.d) {
            if (!this.e.contains(var9)) {
                ArrayList var11 = new ArrayList();
                var11.addAll(this.e);
                var11.add(var9);
                Collections.sort(var11);
                this.e = var11;
            }

            return var9;
        }
    }

    public void a(class_800 var1) {
        synchronized(this.d) {
            ArrayList var3 = new ArrayList();
            var3.addAll(this.e);
            var3.remove(var1);
            this.e = var3;
        }
    }

    public void a(String var1, boolean var2, boolean var3) {
        GameEngine.log("loading mod custom units at:" + var1);
        String[] var4 = class_697.h(var1);
        if (var4 == null) {
            GameEngine.print("getAllModList: ERROR");
            GameEngine.print("getAllModList: Failed to load:" + var1);
        } else {
            String[] var5 = var4;
            int var6 = var4.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String var8 = var5[var7];
                String var9 = var1 + "/" + var8;
                if (class_697.f(var9) || var8.endsWith(".ini")) {
                    String var10 = class_340.e(var8);
                    String var11 = var8;
                    if (var8.contains("/")) {
                        var11 = var8.substring(var8.lastIndexOf("/") + 1);
                    }

                    boolean var12 = false;
                    this.a(var11, var8, var9, var10, var2, var12, var3, 0);
                }
            }

        }
    }

    public ArrayList i() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = this.e.iterator();

        while(var2.hasNext()) {
            class_800 var3 = (class_800)var2.next();
            if (var3.m()) {
                var1.addAll(var3.q());
            }
        }

        return var1;
    }

    public ArrayList j() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = this.e.iterator();

        while(var2.hasNext()) {
            class_800 var3 = (class_800)var2.next();
            if (var3.m()) {
                var1.add(var3);
            }
        }

        return var1;
    }

    public ArrayList k() {
        Iterator var1 = this.e.iterator();

        while(var1.hasNext()) {
            class_800 var2 = (class_800)var1.next();
            var2.l = false;
            if (var2.m) {
                var2.l = true;
            }
        }

        SteamEngine var8 = SteamEngine.getSteamEngine();
        if (var8 != null) {
            var8.l();
        } else {
            GameEngine.log("getAllModList: SteamEngine==null");
        }

        String var9 = class_436.m();
        if (!class_697.f(var9)) {
            GameEngine.log("Modded Custom '" + var9 + "' directory not found");
        } else {
            boolean var3 = false;
            this.a(var9, true, var3);
        }

        String var10 = class_436.k();
        if (!class_697.f(var10)) {
            GameEngine.log("Modded Custom '" + var10 + "' directory not found");
        } else {
            boolean var4 = true;
            this.a(var10, false, var4);
        }

        String var11 = class_436.l();
        if (!class_697.f(var11)) {
            GameEngine.log("Modded Custom '" + var11 + "' directory not found");
        } else {
            boolean var5 = true;
            this.a(var11, true, var5);
        }

        Iterator var12 = this.e.iterator();

        class_800 var6;
        while(var12.hasNext()) {
            var6 = (class_800)var12.next();
            if (!var6.l) {
                GameEngine.log("Removing mod no longer found on system: " + var6.modName());
                this.a(var6);
            }
        }

        GameEngine.log("========= Mods ===========");
        GameEngine.log("Number of mods:" + this.e.size());
        var12 = this.e.iterator();

        while(var12.hasNext()) {
            var6 = (class_800)var12.next();
            GameEngine.log("Mod: '" + var6.modName());
        }

        GameEngine.log("================================");
        GameEngine var13 = GameEngine.getGameEngine();
        class_800 var7;
        Iterator var14;
        if (var13.settingsEngine.lastModCount != -1 && var13.settingsEngine.modSettingsVersion >= 1) {
            if (this.e.size() > var13.settingsEngine.lastModCount + 4) {
                GameEngine.log("Too many new mods found, not enabling new mods");
                GameEngine.log("Number of mods:" + this.e.size() + " vs " + var13.settingsEngine.lastModCount);
                var14 = this.e.iterator();

                while(var14.hasNext()) {
                    var7 = (class_800)var14.next();
                    if (!var7.i) {
                        var7.f = true;
                    }
                }

                this.e();
                var13.settingsEngine.save();
            }
        } else {
            GameEngine.log("Disabling all new mods for first/new load");

            for(var14 = this.e.iterator(); var14.hasNext(); var7.f = true) {
                var7 = (class_800)var14.next();
            }

            this.e();
            var13.settingsEngine.save();
        }

        var13.settingsEngine.lastModCount = this.e.size();
        return this.e;
    }

    public void l() {
        GameEngine var1 = GameEngine.getGameEngine();

        try {
            var1.br = true;
            var1.e();
            this.a(false, false);
        } finally {
            var1.br = false;
        }

        var1.x();
    }

    public void a(boolean var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_670.b();
        class_800 var5;
        if (!var2) {
            for(Iterator var4 = this.e.iterator(); var4.hasNext(); var5.w = 0) {
                var5 = (class_800)var4.next();
                if (var5.R != null) {
                    GameEngine.log("re-enabling mod: " + var5.modName());
                }

                var5.R = null;
                var5.V.clear();
                var5.S = null;
                var5.U.clear();
                var5.C = false;
                var5.D = false;
                var5.E = 0;
                var5.F = 0;
                var5.G = 0L;
                var5.H = 0L;
                var5.I = 0;
                var5.J = 0;
            }
        }

        this.k();
        ArrayList var8 = new ArrayList(class_591.d);
        if (!var2) {
            class_436.h();
        } else {
            class_436.b();
        }

        if (var1) {
            int var9 = 0;
            Iterator var6 = var8.iterator();

            while(var6.hasNext()) {
                class_591 var7 = (class_591)var6.next();
                if (var7.J != null && !var7.J.f && var7.J.R != null && class_591.a(var7) == null) {
                    GameEngine.log("Was missing: " + var7.M);
                    class_591.d.add(var7);
                    ++var9;
                }
            }

            if (var9 > 0) {
                class_436.e();
            }
        }

        class_591.A();
        PlayerData.P();
        InterfaceEngine.K();
    }

    public void m() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.dH != null) {
            var1.dH.d();
        } else {
            GameEngine.log("No active callbacks");
        }

    }

    public String[] a(String[] var1, String var2) {
        GameEngine.log("addExtraMapsForPath: " + var2);
        ArrayList var3 = new ArrayList();
        String[] var4;
        int var6;
        if (var1 != null) {
            var4 = var1;
            int var5 = var1.length;

            for(var6 = 0; var6 < var5; ++var6) {
                String var7 = var4[var6];
                var3.add(var7);
            }
        }

        if (GameEngine.at() && "/SD/rusted_warfare_maps".equals(var2)) {
            var4 = class_697.a("/SD/rustedWarfare/maps", true);
            if (var4 != null) {
                String[] var10 = var4;
                var6 = var4.length;

                for(int var12 = 0; var12 < var6; ++var12) {
                    String var8 = var10[var12];
                    var3.add("NEW_PATH|maps2/" + var8);
                }
            }
        }

        Iterator var9 = this.g(var2).iterator();

        while(var9.hasNext()) {
            class_801 var11 = (class_801)var9.next();
            var3.add("MOD|" + var11.c.e + "/" + var11.b);
        }

        return var1 == null && var3.size() == 0 ? null : (String[])var3.toArray(new String[0]);
    }

    public ArrayList g(String var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.f.iterator();

        while(var3.hasNext()) {
            class_801 var4 = (class_801)var3.next();
            boolean var5 = false;
            if (var1.startsWith("mod/") && var1.startsWith("mod/" + var4.c.e)) {
                var5 = true;
            }

            if (!var4.c.f && var1.startsWith("/SD/rusted_warfare_maps")) {
                var5 = true;
            }

            if (var5) {
                GameEngine.log("Adding extra map:" + var4.a);
                var2.add(var4);
            }
        }

        return var2;
    }

    public void n() {
        this.f.clear();
    }

    public void a(String var1, class_800 var2) {
        class_801 var3 = new class_801(this);
        var3.a = var1;
        var3.c = var2;
        if (var2.q == null) {
            GameEngine.a("Skipping:" + var1 + " as mod sourceFolder is null");
        } else {
            String var4 = var1;
            String var5 = var2.q;
            if (var1.startsWith(var5)) {
                var4 = var1.substring(var5.length());
            } else {
                String var6 = class_697.o(var1);
                if (var6.startsWith(var5)) {
                    var4 = var6.substring(var5.length());
                    GameEngine.log("Mod path:" + var2.q + " in map path without tag:" + var4);
                } else {
                    GameEngine.a("Mod path:" + var2.q + " not in map path:" + var1);
                }
            }

            var3.b = var4;
            var2.A = true;
            ++var2.F;
            this.f.add(var3);
        }
    }

    public class_800 h(String var1) {
        if (var1.contains("MOD|")) {
            String[] var2 = var1.split("/");
            if (var2.length >= 2) {
                for(int var3 = var2.length - 2; var3 >= 0; --var3) {
                    String var4 = var2[var3];
                    if (var4.startsWith("MOD|")) {
                        String var5 = var4.substring("MOD|".length());
                        class_800 var6 = this.c(var5);
                        if (var6 == null) {
                            GameEngine.log("getLinkedModForFile: Failed to find mod with hash:" + var5);
                            return null;
                        }

                        return var6;
                    }
                }
            }
        }

        return null;
    }
}
