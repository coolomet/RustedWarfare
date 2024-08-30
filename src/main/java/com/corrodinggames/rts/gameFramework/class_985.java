package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ac
public strictfp class class_985 {
    public static class_999 a = new class_1000();
    public static class_363 b = new class_363();
    public class_987 c;
    public class_987 d;
    public class_987 e;
    public class_987 f;
    public class_987 g;
    public class_987 h;
    public class_987 i;
    public class_987 j;
    public class_987 k;
    public class_987 l = this.a("Debug Left");
    public class_987 m = this.a("Debug Right");
    public class_987 n = this.b("Camera Up");
    public class_987 o = this.b("Camera Down");
    public class_987 p = this.b("Camera Left");
    public class_987 q = this.b("Camera Right");
    public class_987 r = this.b("Zoom In");
    public class_987 s = this.b("Zoom Out");
    public class_987 t = this.b("Send Chat");
    public class_987 u = this.b("Send Team Chat");
    public class_987 v = this.b("Ping Map");
    public class_987 w = this.b("Show Menu");
    public class_987 x = this.b("Save Game");
    public class_987 y = this.b("Deselect units");
    public class_987 z = this.b("Go to notification");
    public class_987 A = this.b("Select Whole Army");
    public class_987 B = this.b("Select Command Center");
    public class_987 C = this.b("Cycle Builders");
    public class_987 D = this.b("Cycle Extractors");
    public class_987 E = this.b("Cycle Upgradable Fabricators");
    public class_987 F = this.b("Cycle Land Factories");
    public class_987 G = this.b("Cycle Air Factories");
    public class_987 H = this.b("Next Music Track");
    public class_988 I = this.c("Game Speed (Single player)");
    public class_987 J = this.b("Slower");
    public class_987 K = this.b("Faster");
    public class_987 L = this.b("Pause Game");
    public class_988 M = this.c("Unit Actions");
    public class_987 N = this.b("Attack Move");
    public class_987 O = this.b("Stop");
    public class_987 P = this.b("Guard Unit");
    public class_987 Q = this.b("Patrol");
    public class_987 R = this.b("Reclaim");
    public class_987 S = this.b("Action - Upgrade");
    public class_987 T = this.b("Action - Set Rally");
    public class_987 U = this.a("Debug Editor");
    public class_987 V = this.a("Debug Pause");
    public class_987 W = this.a("Debug Slow");
    public class_987 X = this.a("Debug HideInterface");
    public class_987 Y = this.a("Debug HideInterface Temp");
    public class_987 Z = this.a("Debug InvincibleUnits");
    public class_987 aa = this.a("debugPrintSelectedUnit");
    public class_987 ab = this.a("debugDevModeSwitch");
    public class_987 ac = this.a("debugAIViewSwitch");
    public class_987 ad = this.a("debugMapSwitch");
    public class_987 ae = this.a("Debug Take Screenshot");
    public class_987 af = this.a("Debug Take Screenshot High");
    public class_987[] ag;
    public class_988 ah;
    public class_987[] ai;
    public class_987[] aj;
    public class_987[] ak;
    public ArrayList al;
    Properties am;
    int an;
    int ao;

    public class_985() {
        this.n.a("UP").a("NUMPAD8");
        this.o.a("DOWN").a("NUMPAD2");
        this.p.a("LEFT").a("NUMPAD4");
        this.q.a("RIGHT").a("NUMPAD6");
        this.l.a("F5");
        this.m.a("F6");
        this.x.a("CTRL+S");
        this.t.a("ENTER").a("T");
        this.u.a("SHIFT+ENTER").a("Y");
        this.v.a("CTRL+M").a("CTRL+P");
        this.w.a("ESCAPE").a("F10");
        this.y.a("SPACE");
        this.z.a("CTRL+SPACE");
        this.A.a("CTRL+A");
        this.C.a("CTRL+B");
        this.D.a("CTRL+E");
        this.E.a("CTRL+F");
        this.F.a("CTRL+L");
        this.G.a("CTRL+K");
        this.B.a("CTRL+C");
        this.H.a("CTRL+N");
        this.N.a("A");
        this.L.a("BREAK");
        this.O.a("S");
        this.P.a("G");
        this.Q.a("P");
        this.S.a("U");
        this.T.a("R");
        this.U.a("CTRL+SHIFT+E");
        this.V.a("CTRL+SHIFT+P");
        this.W.a("CTRL+SHIFT+S");
        this.X.a("CTRL+SHIFT+H");
        this.Y.a("CTRL+H");
        this.Z.a("CTRL+SHIFT+I");
        this.aa.a("CTRL+SHIFT+L");
        this.ab.a("CTRL+SHIFT+D");
        this.ac.a("SHIFT+F3");
        this.ad.a("SHIFT+F4");
        this.ae.a("CTRL+SHIFT+ALT+S");
        this.af.a("CTRL+SHIFT+ALT+D");
        this.J.a("minus").a("NUMPADSUBTRACT");
        this.K.a("equals").a("NUMPADADD");
        int[] var1 = new int[]{54, 52, 31, 50, 30, 42, 41, 38, 39, 40, 37, 43};
        this.ag = new class_987[10];

        int var2;
        for(var2 = 0; var2 < this.ag.length; ++var2) {
            this.ag[var2] = this.b("unit action " + (var2 + 1));
            this.ag[var2].c(var1[var2]);
        }

        this.ah = this.c("Unit Groups");
        this.ak = new class_987[10];

        int var3;
        byte var4;
        for(var2 = 0; var2 < this.ak.length; ++var2) {
            this.ak[var2] = this.b("create group " + (var2 + 1));
            var3 = this.a(var2 == 9 ? 0 : var2 + 1);
            var4 = 1;
            this.ak[var2].a(var3, 0, var4, false);
        }

        this.ai = new class_987[10];

        for(var2 = 0; var2 < this.ai.length; ++var2) {
            this.ai[var2] = this.b("select group " + (var2 + 1));
            var3 = this.a(var2 == 9 ? 0 : var2 + 1);
            this.ai[var2].c(var3);
        }

        this.aj = new class_987[10];

        for(var2 = 0; var2 < this.aj.length; ++var2) {
            this.aj[var2] = this.b("Add group to selection " + (var2 + 1));
            var3 = this.a(var2 == 9 ? 0 : var2 + 1);
            var4 = 2;
            this.aj[var2].a(var3, 0, var4, false);
        }

        this.am = new Properties();
        this.an = 0;
        this.ao = 0;
    }

    public int a(int var1) {
        if (var1 >= 10) {
            throw new RuntimeException("number:" + var1 + " too high");
        } else {
            return var1 == 0 ? 7 : 8 + (var1 - 1);
        }
    }

    public class_987 a(String var1) {
        if (this.al == null) {
            this.al = new ArrayList();
        }

        class_987 var2 = new class_987();
        var2.a = var1;
        var2.b = false;
        this.al.add(var2);
        return var2;
    }

    public class_987 b(String var1) {
        if (this.al == null) {
            this.al = new ArrayList();
        }

        class_987 var2 = new class_987();
        var2.a = var1;
        var2.b = true;
        this.al.add(var2);
        return var2;
    }

    public class_988 c(String var1) {
        if (this.al == null) {
            this.al = new ArrayList();
        }

        class_988 var2 = new class_988();
        var2.a = var1;
        var2.b = true;
        this.al.add(var2);
        return var2;
    }

    public void a(String var1, String var2) {
        var1 = var1.toLowerCase(Locale.ENGLISH).trim();
        class_987 var3 = null;
        Iterator var4 = this.al.iterator();

        while(var4.hasNext()) {
            class_987 var5 = (class_987)var4.next();
            if (var5.a != null && var5.e().equals(var1)) {
                var3 = var5;
            }
        }

        if (var3 == null) {
            GameEngine.print("loadKey: could not find:" + var1);
        } else {
            String[] var7 = var2.split(",");

            for(int var8 = 0; var8 <= 1 && var8 < var7.length; ++var8) {
                String var6 = var7[var8];
                if (!var6.equalsIgnoreCase("DEFAULT")) {
                    var3.a(var6, var8);
                    if (var3.c.size() > var8 && var3.c.get(var8) != null) {
                        ((class_991)var3.c.get(var8)).d = true;
                    } else {
                        GameEngine.warn("out of range");
                    }
                }
            }

        }
    }

    public String a(class_987 var1) {
        String var2 = "";
        boolean var3 = true;
        Iterator var4 = var1.c.iterator();

        while(var4.hasNext()) {
            class_991 var5 = (class_991)var4.next();
            if (var3) {
                var3 = false;
            } else {
                var2 = var2 + ",";
            }

            if (var5.d) {
                if (var5.d()) {
                    var2 = var2 + "CLEARED";
                } else {
                    var2 = var2 + var5.c();
                }
            } else {
                var2 = var2 + "DEFAULT";
            }
        }

        return var2;
    }

    public boolean a(class_987 var1, int var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        class_991 var4 = var1.a(var2);
        if (var4 == null) {
            return false;
        } else {
            ArrayList var5 = var3.bT.al;

            for(int var6 = 0; var6 < var5.size(); ++var6) {
                class_987 var7 = (class_987)var5.get(var6);
                if (var7 != var1) {
                    Iterator var8 = var7.c.iterator();

                    while(var8.hasNext()) {
                        class_991 var9 = (class_991)var8.next();
                        if (var4.a(var9)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public void a() {
        this.c = this.a("shoot");
        this.d = this.a("move up");
        this.e = this.a("move down");
        this.f = this.a("move left");
        this.g = this.a("move right");
        this.h = this.a("aim up");
        this.i = this.a("aim down");
        this.j = this.a("aim left");
        this.k = this.a("aim right");
        byte var1 = 0;
        this.c.a(var1, "enter", -1);
        this.c.a(var1, "space", -1);
        this.d.a(var1, "w", -1);
        this.e.a(var1, "s", -1);
        this.f.a(var1, "a", -1);
        this.g.a(var1, "d", -1);
        this.h.a(var1, "UP", -1);
        this.i.a(var1, "DOWN", -1);
        this.j.a(var1, "LEFT", -1);
        this.k.a(var1, "RIGHT", -1);
        GameEngine.log("getControllerCount:" + b.a());
        byte var2 = 1;
        this.d.b(var1, var2, 0, true);
        this.e.b(var1, var2, 0, false);
        this.f.b(var1, var2, 1, true);
        this.g.b(var1, var2, 1, false);
        this.h.b(var1, var2, 2, true);
        this.i.b(var1, var2, 2, false);
        this.j.b(var1, var2, 3, true);
        this.k.b(var1, var2, 3, false);
        this.c.b(var1, var2, 4, true);
    }

    public void b() {
        if (b.a() != this.ao) {
            this.ao = b.a();
            GameEngine.log("Number of controllers changed, now:" + this.ao);
        }

    }

    public static int d(String var0) {
        return var0.equalsIgnoreCase("CLEARED") ? 0 : SlickToAndroidKeycodes.a(var0);
    }
}
