package com.corrodinggames.rts.gameFramework.net;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.LinkedList;

public strictfp class GameInputStream {
    ByteArrayInputStream byteStream;
    private DataInputStream dataStream;
    private DataInputStream useStream;
    private LinkedList g = new LinkedList();
    int b = 999999;
    int c = 999999;
    int d = 0;

    strictfp void setMainStream() {
        this.useStream = this.dataStream;
    }

    public GameInputStream(Packet var1) {
        this.byteStream = new ByteArrayInputStream(var1.bytes);
        this.dataStream = new DataInputStream(this.byteStream);
        this.setMainStream();
    }

    public GameInputStream(DataInputStream var1) {
        this.dataStream = var1;
        this.setMainStream();
    }

    public GameInputStream(String var1) {
        this.byteStream = new ByteArrayInputStream(var1.getBytes());
        this.dataStream = new DataInputStream(this.byteStream);
        this.setMainStream();
    }

    public GameInputStream(byte[] var1) {
        this.byteStream = new ByteArrayInputStream(var1);
        this.dataStream = new DataInputStream(this.byteStream);
        this.setMainStream();
    }

    public strictfp void a(int var1) {
        this.b = var1;
    }

    public strictfp int b() {
        return this.b;
    }

    public strictfp void setCacheInt(int var1) {
        this.c = var1;
    }

    public strictfp int getCacheInt() {
        return this.c;
    }

    @SneakyThrows
    public strictfp byte readByte() {
        return this.useStream.readByte();
    }

    @SneakyThrows
    public strictfp boolean readBoolean() {
        return this.useStream.readBoolean();
    }

    @SneakyThrows
    public strictfp int readInt() {
        return this.useStream.readInt();
    }

    @SneakyThrows
    public strictfp float readFloat() {
        return this.useStream.readFloat();
    }

    @SneakyThrows
    public strictfp double readDouble() {
        return this.useStream.readDouble();
    }

    @SneakyThrows
    public strictfp long readLong() {
        return this.useStream.readLong();
    }

    public strictfp String isReadString() {
        return !this.readBoolean() ? null : this.readString();
    }

    public strictfp Integer isReadInt() {
        return !this.readBoolean() ? null : this.readInt();
    }

    @SneakyThrows
    public strictfp String readString() {
        String var1 = this.useStream.readUTF();
        return var1;
    }

    @SneakyThrows
    public strictfp class_585 m() {
        String var1 = this.useStream.readUTF();
        return var1.equals("") ? null : class_585.c(var1);
    }

    @SneakyThrows
    public strictfp long m5452n() {
        long var1 = this.useStream.readLong();
        return var1;
    }

    @SneakyThrows
    public strictfp GameObject a(Class var1) {
        long var2 = this.useStream.readLong();
        return GameObject.a(var2, var1, false);
    }

    public strictfp void a(class_684 var1, Class var2) {
        int var3 = this.readInt();

        for(int var4 = 0; var4 < var3; ++var4) {
            GameObject var5 = this.a(var2);
            if (var5 != null) {
                var1.add(var5);
            }
        }

    }

    public strictfp Unit o() {
        return this.a(class_215.WARN);
    }

    @SneakyThrows
    public strictfp Unit a(class_215 var1) {
        long var2 = this.useStream.readLong();
        boolean var4 = var1 == class_215.EXPECTED;
        return GameObject.a(var2, var4);
    }

    @SneakyThrows
    public strictfp OrderableUnit p() {
        long var1 = this.useStream.readLong();
        return GameObject.b(var1, false);
    }

    @SneakyThrows
    public strictfp Enum readEnum(Class var1) {
        int var2 = this.useStream.readInt();
        if (var2 == -1) {
            return null;
        } else {
            Object[] var3 = var1.getEnumConstants();
            if (var2 >= 0 && var2 < var3.length) {
                return (Enum)var3[var2];
            } else {
                GameNetEngine.g("readEnum:" + var2 + " is out of range for " + var1.toString());
                return null;
            }
        }
    }
    @SneakyThrows
    public strictfp Object readSimilarEnum(Class var1) {
        int var2 = this.useStream.readInt();
        if (var2 == -1) {
            return null;
        } else {
            Method method = var1.getMethod("values");
            Object[] var3 = (Object[]) method.invoke(null);
            if (var2 >= 0 && var2 < var3.length) {
                return var3[var2];
            } else {
                GameNetEngine.g("readSimilarEnum:" + var2 + " is out of range for " + var1.toString());
                return null;
            }
        }
    }

    @SneakyThrows
    public strictfp class_31 q() {
        int var1 = this.useStream.readInt();
        if (var1 == -1) {
            return null;
        } else if (var1 == -2) {
            String var5 = this.readString();
            class_591 var3 = class_591.n(var5);
            if (var3 == null) {
                GameNetEngine.g("readUnitType: Could not find customUnitMetadata:" + var5);
            }

            class_31 var4 = class_591.c((class_31)var3);
            if (var4 != null) {
                if (var4 instanceof class_591) {
                    var3 = (class_591)var4;
                } else {
                    GameEngine.print("replacement not a custom unit:" + var4.i());
                }
            }

            return var3;
        } else {
            Object[] var2 = UnitType.values();
            if (var1 >= 0 && var1 < var2.length) {
                return (UnitType)var2[var1];
            } else {
                GameNetEngine.g("readUnitType:" + var1 + " is out of range for UnitType");
                return null;
            }
        }
    }

    @SneakyThrows
    public strictfp PlayerData r() {
        byte var1 = this.useStream.readByte();
        PlayerData var2 = PlayerData.getPlayerData(var1);
        if (var2 == null) {
            throw new IOException("Error loading save data, could not find referenced team:" + var1 + "");
        } else {
            return var2;
        }
    }

    @SneakyThrows
    public strictfp PlayerData s() {
        byte var1 = this.useStream.readByte();
        return PlayerData.getPlayerData(var1);
    }

    @SneakyThrows
    public strictfp byte[] readBytes() {
        int var1 = 0;
        int var2 = this.readInt();

        byte[] var3;
        int var4;
        for(var3 = new byte[var2]; var1 < var2; var1 += var4) {
            var4 = this.useStream.read(var3, var1, var2 - var1);
            if (var4 == -1) {
                break;
            }
        }

        return var3;
    }

    public strictfp GameInputStream u() {
        byte[] var1 = this.readBytes();
        return new GameInputStream(var1);
    }

    @SneakyThrows
    public strictfp short readShort() {
        return this.useStream.readShort();
    }

    public strictfp void checkMark(String var1) {
        short var2 = this.readShort();
        if (var2 != 12345) {
            GameNetEngine.g("Mark wasn't read for:" + var1);
            if (GameEngine.getGameEngine().aa()) {
                throw new RuntimeException("Mark wasn't read for:" + var1);
            }
        }

    }

    public strictfp InputStream getUseStream() {
        return this.useStream;
    }

    public strictfp void startBlock(String var1) {
        this.a(var1, false);
    }

    public strictfp String x() {
        return this.a(false, false);
    }

    public strictfp void a(String var1, boolean var2) {
        this.a(var1, var2, false);
    }

    public strictfp void a(String var1, boolean var2, boolean var3) {
        if (this.b < 11) {
            GameEngine.log("Skipping start block:" + var1);
        } else {
            String var4 = this.a(var2, var3);
            if (!var4.equals(var1)) {
                GameEngine.b("InputNetStream:endBlock", "Name does not match: expected:" + var1 + " , got:" + var4);
            }

        }
    }

    @SneakyThrows
    public strictfp byte[] getBytesAndCheckMark(String var1) {
        String var2 = this.useStream.readUTF();
        if (!var2.equals(var1)) {
            GameEngine.b("getBlockRaw", "Name does not match: expected:" + var1 + " , got:" + var2);
        }

        byte[] var3 = this.readBytes();
        return var3;
    }

    @SneakyThrows
    public strictfp String a(boolean var1, boolean var2) {
        if (this.b < 11) {
            GameEngine.log("Skipping start block: startBlockAndGetName()");
            return "<skipped>";
        } else {
            String var3 = this.useStream.readUTF();
            byte[] var4 = this.readBytes();
            class_216 var5 = new class_216(var4, var1, var2);
            var5.a = var3;
            this.g.add(var5);
            this.useStream = ((class_216)this.g.getLast()).c;
            return var3;
        }
    }

    public strictfp void endBlock(String var1) {
        if (this.b < 11) {
            GameEngine.log("Skipping end block:" + var1);
        } else {
            class_216 var2 = (class_216)this.g.removeLast();
            if (!var2.a.equals(var1)) {
                GameEngine.b("InputNetStream:endBlock", "Name does not match: expected" + var1 + " ," + var2.a);
            }

            if (this.g.isEmpty()) {
                this.useStream = this.dataStream;
            } else {
                this.useStream = ((class_216)this.g.getLast()).c;
            }

        }
    }

    public strictfp PointF getPointF() {
        if (!this.readBoolean()) {
            return null;
        } else {
            PointF var1 = new PointF();
            var1.x = this.readFloat();
            var1.y = this.readFloat();
            return var1;
        }
    }
}
