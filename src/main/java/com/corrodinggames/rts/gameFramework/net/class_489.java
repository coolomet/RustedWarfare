package com.corrodinggames.rts.gameFramework.net;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.ListIterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.aw
public strictfp class class_489 extends GameOutputStream {
    ByteArrayOutputStream a;
    PrintStream e;
    private PrintStream f;
    private LinkedList g = new LinkedList();

    @SneakyThrows
    public strictfp void flashAll() {
        ListIterator var1 = this.g.listIterator(this.g.size());

        while(var1.hasPrevious()) {
            class_1018 var2 = (class_1018)var1.previous();
            var2.a();
        }

        this.e.flush();
        if (this.a != null) {
            this.a.flush();
        }

    }

    strictfp void b() {
        this.f = this.e;
    }

    public class_489() {
        this.a = new ByteArrayOutputStream();
        this.e = new PrintStream(this.a);
        this.b();
    }

    public class_489(PrintStream var1) {
        this.e = var1;
        this.b();
    }

    public strictfp Packet getPacket(int var1) {
        return this.a(var1, -1);
    }

    public strictfp Packet a(int var1, int var2) {
        try {
            this.flashAll();
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }

        Packet var3 = new Packet(var1);
        var3.bytes = this.a.toByteArray();
        var3.f7548d = var2;
        return var3;
    }

    public strictfp String toString() {
        try {
            this.flashAll();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }

        return this.a.toString();
    }

    public strictfp byte[] toByteArray() {
        try {
            this.flashAll();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }

        return this.a.toByteArray();
    }

    public strictfp void writeByte(int var1) {
        this.f.println(var1);
    }

    public strictfp void writeBoolean(boolean var1) {
        this.f.println(var1);
    }

    public strictfp void writeInt(int var1) {
        this.f.println("#int:");
        this.f.println(var1);
    }

    public strictfp void writeFloat(float var1) {
        this.f.println("#writeFloat");
        this.f.println(var1);
    }

    public strictfp void writeLong(long var1) {
        this.f.println("#writeLong");
        this.f.println(var1);
    }

    public strictfp void writeIsString(String var1) {
        this.writeBoolean(var1 != null);
        if (var1 != null) {
            this.writeString(var1);
        }

    }

    public strictfp void writeString(String var1) {
        this.f.println(var1);
    }

    public strictfp void a(GameObject var1) {
        this.f.println("#writeGameObject:");
        if (var1 == null) {
            this.f.println(-1);
        } else {
            this.f.println(var1.id);
        }

    }

    public strictfp void b(GameObject var1) {
        this.f.println("#writeExistingGameObject:");
        if (var1 != null && !var1.ej) {
            this.f.println(var1.id);
        } else {
            this.f.println(-1);
        }
    }

    public strictfp void b(Unit var1) {
        if (var1 != null && !var1.ej && !var1.bV) {
            this.a((GameObject)var1);
        } else {
            this.a((GameObject)null);
        }
    }

    public strictfp void a(Unit var1) {
        if (var1 != null && !var1.ej) {
            this.a((GameObject)var1);
        } else {
            this.a((GameObject)null);
        }
    }

    public strictfp void a(OrderableUnit var1) {
        if (var1 != null && !var1.ej) {
            this.a((GameObject)var1);
        } else {
            this.a((GameObject)null);
        }
    }

    public strictfp void writeIsPointF(PointF var1) {
        this.f.println("#PointF:");
        this.writeBoolean(var1 != null);
        if (var1 != null) {
            this.writeFloat(var1.x);
            this.writeFloat(var1.y);
        }

    }

    public strictfp void writeEnum(Enum var1) {
        if (var1 == null) {
            this.f.println("#Enum: null");
            this.f.println(-1);
        } else {
            this.f.println("#Enum:" + var1.getClass().getSimpleName() + " : " + var1.toString());
            this.f.println(var1.ordinal());
        }

    }

    public strictfp void a(class_31 var1) {
        this.f.println("#unitType:");
        if (var1 == null) {
            this.f.println(-1);
        } else if (var1 instanceof class_591) {
            this.f.println(-2);
            this.writeString(((class_591)var1).M);
        } else {
            this.f.println(((UnitType)var1).ordinal());
        }

    }

    public strictfp void a(PlayerConnect var1) {
        if (var1 == null) {
            this.f.println(0);
        } else {
            this.f.println(var1.connectIndex);
        }

    }

    public strictfp void a(PlayerData var1) {
        this.f.println("#team:");
        this.f.println(var1.site);
    }

    public strictfp void a(File var1) {
        AssetInputStream var2 = class_697.a(var1);

        try {
            this.a(var2, (int)var1.length());
        } finally {
            var2.close();
        }

    }

    @SneakyThrows
    public strictfp void a(InputStream var1, int var2) {
        int var3 = 0;
        this.writeInt(var2);

        int var4;
        for(byte[] var5 = new byte[16384]; (var4 = var1.read(var5, 0, var5.length)) != -1; var3 += var4) {
            if (var3 + var4 > var2) {
                int var6 = var2 - var3;
                if (var6 < 0) {
                    GameNetEngine.g("writeStream: bytesTillFull is " + var6);
                    return;
                }

                this.f.write(var5, 0, var6);
                return;
            }

            this.f.write(var5, 0, var4);
        }

    }

    @SneakyThrows
    public strictfp void a(ByteArrayOutputStream var1) {
        this.writeInt(var1.size());
        var1.writeTo(this.f);
    }

    @SneakyThrows
    public strictfp void a(byte[] var1) {
        this.writeInt(var1.length);
        this.f.write(var1);
    }

    public strictfp void a(short var1) {
        this.f.println("#writeShort");
        this.f.println(var1);
    }

    public strictfp void e() {
        this.f.println("#writeMark:");
        this.a((short)12345);
    }

    public strictfp void d(String var1) {
        this.f.println("#writeIfDebugOnly: " + var1);
    }

    public strictfp boolean f() {
        return true;
    }

    public strictfp void e(String var1) {
        this.startBlock(var1, false);
    }

    public strictfp void startBlock(String var1, boolean var2) {
        class_1018 var3 = new class_1018(var2);
        var3.b = var1;
        this.g.add(var3);
        this.f = ((class_1018)this.g.getLast()).d;
    }

    public strictfp void endBlock(String var1) {
        class_1018 var2 = (class_1018)this.g.removeLast();
        if (!var2.b.equals(var1)) {
            GameEngine.b("OutputNetStream:endBlock", "Name does not match: expected" + var1 + " , got:" + var2.b);
        }

        var2.a();
        if (this.g.isEmpty()) {
            this.f = this.e;
        } else {
            this.f = ((class_1018)this.g.getLast()).d;
        }

        String var3 = "";
        String var4 = "";

        for(int var5 = 0; var5 < this.g.size(); ++var5) {
            var3 = var3 + ">";
            var4 = var4 + "<";
        }

        this.f.println(var3 + ">>>> Start of block: " + var2.b);
        this.a(var2.c);
        this.f.println(var4 + "<<<< End of block: " + var2.b);
        var2.b();
    }
}
