package com.corrodinggames.rts.gameFramework.n;

import android.graphics.Color;
import android.graphics.Paint;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.maps.class_487;
import com.corrodinggames.rts.game.units.class_32;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_395;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.n.a.class_1005;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.a
public strictfp class class_637 {
    public String a;
    public String b;
    public String c;
    public class_638 d = new class_638();
    public class_638 e = new class_638();
    public class_684 f = new class_684();
    public class_609 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public int n = -1;
    public int o = Integer.MAX_VALUE;
    public int p;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public class_487 t;
    public boolean u = false;
    public class_395 v;
    public float w;
    public float x;
    public PlayerData y;
    public class_388 z;
    public class_388 A;
    public Paint B;
    public boolean C;

    public void a(class_1005 var1) {
        this.f.add(var1);
    }

    public void a(String var1) {
        this.t.b(var1);
    }

    public String b(String var1) {
        return this.t.b(var1);
    }

    public String a(String var1, String var2) {
        return this.t.a(var1, var2);
    }

    public boolean c(String var1) {
        return this.t.b(var1) != null;
    }

    @SneakyThrows
    public int a(String var1, int var2) {
        String var3 = this.a(var1, (String)null);
        if (var3 == null) {
            return var2;
        } else {
            try {
                return Integer.parseInt(var3);
            } catch (NumberFormatException var5) {
                throw this.f(var1 + ": Unexpected integer value:'" + var3 + "'");
            }
        }
    }

    @SneakyThrows
    public int b(String var1, int var2) {
        String var3 = this.b(var1);
        if (var3 == null) {
            return var2;
        } else {
            double var5 = 1.0;
            if (var3.endsWith("ms")) {
                var3 = var3.substring(0, var3.length() - 2);
                var5 = 1.0;
            } else if (var3.endsWith("s")) {
                var3 = var3.substring(0, var3.length() - 1);
                var5 = 1000.0;
            } else {
                var5 = 1.0;
            }

            double var7;
            try {
                var7 = Double.parseDouble(var3);
            } catch (NumberFormatException var10) {
                var10.printStackTrace();
                throw this.f(var1 + ": Unexpected time:'" + var3 + "'");
            }

            return (int)(var7 * var5);
        }
    }

    @SneakyThrows
    public float a(String var1, float var2) {
        String var3 = this.a(var1, (String)null);
        if (var3 == null) {
            return var2;
        } else {
            try {
                return Float.parseFloat(var3);
            } catch (NumberFormatException var5) {
                throw this.f(var1 + ": Unexpected float value:'" + var3 + "'");
            }
        }
    }

    @SneakyThrows
    public Integer d(String var1) {
        String var2 = this.a(var1, (String)null);
        if (var2 == null) {
            return null;
        } else {
            try {
                return Integer.parseInt(var2);
            } catch (NumberFormatException var4) {
                throw this.f(var1 + ": Unexpected integer value:'" + var2 + "'");
            }
        }
    }

    @SneakyThrows
    public Boolean e(String var1) {
        String var2 = this.a(var1, (String)null);
        if (var2 == null) {
            return null;
        } else if (var2.equalsIgnoreCase("true")) {
            return true;
        } else if (var2.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw this.f(var1 + ": Unexpected boolean value:'" + var2 + "'");
        }
    }

    public boolean a(String var1, String var2, boolean var3) {
        Boolean var4 = this.e(var1);
        if (var4 != null) {
            return var4;
        } else {
            var4 = this.e(var2);
            return var4 != null ? var4 : var3;
        }
    }

    @SneakyThrows
    public boolean a(String var1, boolean var2) {
        String var3 = this.a(var1, (String)null);
        if (var3 == null) {
            return var2;
        } else if (var3.equalsIgnoreCase("true")) {
            return true;
        } else if (var3.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw this.f(var1 + ": Unexpected boolean value:'" + var3 + "'");
        }
    }

    @SneakyThrows
    public int c(String var1, int var2) {
        String var3 = this.b(var1);
        if (var3 == null) {
            return var2;
        } else if (var3.equals("")) {
            throw this.f(var1 + ": Unknown color:" + var3);
        } else {
            try {
                return Color.a(var3);
            } catch (IllegalArgumentException var5) {
                throw this.f(var1 + ": Unknown color:" + var3);
            }
        }
    }

    public class_388 a(String var1, class_388 var2) {
        return this.t.createLocaleStringFromProperty(var1, var2);
    }

    public boolean a(Unit var1) {
        return this.t.a(var1);
    }

    public MapException f(String var1) {
        return this.a(var1, (Exception)null);
    }

    public MapException a(String var1, Exception var2) {
        var1 = "MapTrigger-Error (" + this.a + " id:" + this.b + "): " + var1;
        GameNetEngine.g(var1);
        return var2 == null ? new MapException(var1) : new MapException(var1, var2);
    }

    public void g(String var1) {
        GameNetEngine.g("MapTrigger-Error (" + this.a + " id:" + this.b + " type:" + this.g + "): " + var1);
    }

    public void h(String var1) {
        GameEngine.log("MapTrigger-Debug (" + this.b + " type:" + this.g + "): " + var1);
    }

    public PlayerData a() {
        return this.y;
    }

    public int b() {
        return (int)this.t.j.d();
    }

    public int c() {
        return (int)this.t.j.e();
    }

    public boolean b(Unit var1) {
        PlayerData var2 = this.a();
        if (var2 != null && var1.bX != var2) {
            return false;
        } else {
            boolean var3 = this.c("onlyIfEmpty");
            if (var3 && var1.cr() && var1 instanceof class_32) {
                class_32 var4 = (class_32)var1;
                if (var4.bB() > 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean d() {
        GameEngine var1 = GameEngine.getGameEngine();
        int var2 = var1.by;
        boolean var3 = true;
        boolean var4 = false;
        if (!this.m && this.r != -1) {
            if (this.r <= var2) {
                var4 = true;
                this.m = true;
            } else {
                var3 = false;
            }
        }

        if (this.d.a()) {
            if (this.d.b()) {
                var4 = true;
            } else {
                var3 = false;
            }
        }

        if (this.f.a > 0) {
            Iterator var5 = this.f.iterator();

            while(var5.hasNext()) {
                class_1005 var6 = (class_1005)var5.next();
                if (var6.a(this)) {
                    if (var6.b(this)) {
                        var4 = true;
                    } else {
                        var3 = false;
                    }
                }
            }
        }

        boolean var7;
        if (this.h) {
            var7 = var4 && var3;
        } else {
            var7 = var4;
            if (var3) {
                var7 = true;
            }
        }

        if (var7) {
            if (this.n == -1) {
                this.n = var2;
            }

            if (this.s <= 0) {
                return true;
            } else {
                return var2 >= this.n + this.s;
            }
        } else {
            this.n = -1;
            return false;
        }
    }
}
