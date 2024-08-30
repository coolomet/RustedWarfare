package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import com.corrodinggames.rts.gameFramework.utility.class_686;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.w
public abstract strictfp class GameObject extends class_62 {
    public long id;
    public static class_333 ei = new class_333();
    public boolean ej;
    public boolean ek;
    public boolean el;
    public int em;
    public int en;
    public float xCord;
    public float yCord;
    public float zCord;
    private static final class_682 a = new class_682();
    public static final class_686 er = new class_686("fastGameObjectList");

    public strictfp void S(int var1) {
        this.em = var1;
    }

    public strictfp void a(GameOutputStream var1) {
        var1.writeBoolean(this.ej);
        var1.writeBoolean(this.ek);
        var1.writeInt(this.em);
    }

    public strictfp void a(GameInputStream var1) {
        this.ej = var1.readBoolean();
        this.ek = var1.readBoolean();
        this.em = var1.readInt();
    }

    public GameObject() {
        this(false);
    }

    public GameObject(boolean var1) {
        this.ej = false;
        this.ek = false;
        this.em = 2;
        this.en = 0;
        this.zCord = 0.0F;
        if (!var1) {
            GameEngine var2 = GameEngine.getGameEngine();
            if (this.id != 0L) {
                throw new RuntimeException("ID for GameObject is already set at:" + this.id);
            }

            this.id = var2.netEngine.y();
            if (this.id == 0L) {
                throw new RuntimeException("Adding object with id:0 class:" + this.getClass().getSimpleName());
            }

            a.a((Object)this);
            er.a(this);
        } else {
            this.id = 0L;
        }

    }

    public abstract void a(float var1);

    public abstract void a(float var1, boolean var2);

    public abstract void d(float var1);

    public abstract void e(float var1);

    public strictfp void p(float var1) {
    }

    public abstract boolean c(float var1);

    public abstract boolean f(float var1);

    public strictfp boolean a(GameEngine var1) {
        return true;
    }

    public strictfp void a() {
        if (this.id != 0L) {
            a.b((Object)this);
            er.remove(this);
        }

        this.ej = true;
    }

    public static strictfp GameObject a(long var0, Class var2, boolean var3) {
        if (var0 == -1L) {
            return null;
        } else {
            GameObject[] var4 = er.a();
            int var5 = 0;

            for(int var6 = er.size(); var5 < var6; ++var5) {
                GameObject var7 = var4[var5];
                if (var7.id == var0) {
                    if (var2.isInstance(var7)) {
                        return var7;
                    }

                    String var8 = var7.getClass().getName();
                    String var9 = var2.getName();
                    var8 = var8.replace("com.corrodinggames.rts.", "");
                    var9 = var9.replace("com.corrodinggames.rts.", "");
                    GameNetEngine.g("object id:" + var0 + " was found, but with type " + var8 + " instead of " + var9);
                }
            }

            if (!var3) {
                GameNetEngine.g("getFromId:" + var0 + " was not found");
            }

            return null;
        }
    }

    public static strictfp Unit a(long var0, boolean var2) {
        return (Unit)a(var0, Unit.class, var2);
    }

    public static strictfp OrderableUnit b(long var0, boolean var2) {
        return (OrderableUnit)a(var0, OrderableUnit.class, var2);
    }

    public static strictfp class_682 dK() {
        a.a();
        return a;
    }

    public static strictfp void dL() {
        a.a();
        Unit.bG();
    }
}
