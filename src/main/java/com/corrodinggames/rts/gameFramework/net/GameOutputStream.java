package com.corrodinggames.rts.gameFramework.net;

import android.graphics.PointF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.zip.DataFormatException;

public strictfp class GameOutputStream {
    ByteArrayOutputStream byteStream;
    DataOutputStream useStream;
    private DataOutputStream dataStream;
    private LinkedList e;
    public int packetVersion;

    @SneakyThrows
    public strictfp void flashAll() {
        ListIterator var1 = this.e.listIterator(this.e.size());

        while(var1.hasPrevious()) {
            GzipDataOutStream var2 = (GzipDataOutStream)var1.previous();
            var2.a();
        }

        this.useStream.flush();
        if (this.byteStream != null) {
            this.byteStream.flush();
        }

    }

    strictfp void b() {
        this.dataStream = this.useStream;
    }

    public GameOutputStream(int var1) {
        this();
        this.packetVersion = var1;
    }

    public GameOutputStream() {
        this.e = new LinkedList();
        this.packetVersion = 999999;
        this.byteStream = new ByteArrayOutputStream();
        this.useStream = new DataOutputStream(this.byteStream);
        this.b();
    }

    public GameOutputStream(DataOutputStream var1) {
        this.e = new LinkedList();
        this.packetVersion = 999999;
        this.useStream = var1;
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
        var3.bytes = this.byteStream.toByteArray();
        var3.f7548d = var2;
        return var3;
    }

    public strictfp String toString() {
        try {
            this.flashAll();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }

        return this.byteStream.toString();
    }

    public strictfp byte[] toByteArray() {
        try {
            this.flashAll();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }

        return this.byteStream.toByteArray();
    }

    @SneakyThrows
    public strictfp void writeByte(int var1) {
        this.dataStream.writeByte(var1);
    }

    @SneakyThrows
    public strictfp void writeBoolean(boolean var1) {
        this.dataStream.writeBoolean(var1);
    }

    @SneakyThrows
    public strictfp void writeInt(int var1) {
        this.dataStream.writeInt(var1);
    }

    @SneakyThrows
    public strictfp void writeFloat(float var1) {
        this.dataStream.writeFloat(var1);
    }

    @SneakyThrows
    public strictfp void writeDouble(double var1) {
        this.dataStream.writeDouble(var1);
    }

    @SneakyThrows
    public strictfp void writeLong(long var1) {
        this.dataStream.writeLong(var1);
    }

    public strictfp void writeIsString(String var1) {
        this.writeBoolean(var1 != null);
        if (var1 != null) {
            this.writeString(var1);
        }

    }

    public strictfp void writeIsInt(Integer var1) {
        this.writeBoolean(var1 != null);
        if (var1 != null) {
            this.writeInt(var1);
        }

    }

    @SneakyThrows
    public strictfp void writeString(String var1) {
        this.dataStream.writeUTF(var1);
    }

    @SneakyThrows
    public strictfp void a(class_585 var1) {
        if (var1 == null) {
            this.dataStream.writeUTF("");
        }

        this.dataStream.writeUTF(var1.toString());
    }

    @SneakyThrows
    public strictfp void a(GameObject var1) {
        if (var1 == null) {
            this.dataStream.writeLong(-1L);
        } else {
            this.dataStream.writeLong(var1.id);
        }

    }

    @SneakyThrows
    public strictfp void b(GameObject var1) {
        if (var1 != null && !var1.ej) {
            this.dataStream.writeLong(var1.id);
        } else {
            this.dataStream.writeLong(-1L);
        }
    }

    public strictfp void a(class_684 var1) {
        if (var1 == null) {
            this.writeInt(0);
        } else {
            this.writeInt(var1.size());
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                Object var3 = var2.next();
                GameObject var4 = (GameObject)var3;
                this.b(var4);
            }

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
        this.writeBoolean(var1 != null);
        if (var1 != null) {
            this.writeFloat(var1.x);
            this.writeFloat(var1.y);
        }

    }

    @SneakyThrows
    public strictfp void writeEnum(Enum var1) {
        if (var1 == null) {
            this.dataStream.writeInt(-1);
        } else {
            this.dataStream.writeInt(var1.ordinal());
        }
    }
    @SneakyThrows
    public strictfp void writeSimilarEnum(Object var1) {
        if (var1 == null) {
            this.dataStream.writeInt(-1);
        } else {
            Method method = var1.getClass().getMethod("values");
            Object[] var3 = (Object[]) method.invoke(null);
            int i = 0;
            for (; i < var3.length; i++)
                if (var1.equals(var3[i]))
                    break;
            this.dataStream.writeInt(i);
        }
    }

    @SneakyThrows
    public strictfp void a(class_31 var1) {
        if (var1 == null) {
            this.dataStream.writeInt(-1);
        } else if (var1 instanceof class_591) {
            this.dataStream.writeInt(-2);
            this.writeString(((class_591)var1).M);
        } else {
            UnitType unitType = (UnitType)var1;
            int i = 0;
            for (; i < UnitType.values().length; i++)
                if (unitType.equals(UnitType.values()[i]))
                    break;
            this.dataStream.writeInt(i);
        }

    }

    @SneakyThrows
    public strictfp void a(PlayerConnect var1) {
        if (var1 == null) {
            this.dataStream.writeInt(0);
        } else {
            this.dataStream.writeInt(var1.connectIndex);
        }

    }

    @SneakyThrows
    public strictfp void a(PlayerData var1) {
        this.dataStream.writeByte(var1.site);
    }

    @SneakyThrows
    public strictfp void a(File var1) {
        AssetInputStream var2 = class_697.a(var1);
        if (var2 == null) {
            throw new IOException("Failed to read save file data");
        } else {
            try {
                this.a(var2, (int)var1.length());
            } finally {
                if (var2 != null) {
                    var2.close();
                }

            }

        }
    }

    @SneakyThrows
    public strictfp void a(GameInputStream var1) {
        InputStream var2 = var1.getUseStream();

        try {
            var2.reset();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        this.a(var2, var2.available());
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

                this.dataStream.write(var5, 0, var6);
                return;
            }

            this.dataStream.write(var5, 0, var4);
        }

    }

    @SneakyThrows
    public strictfp void a(ByteArrayOutputStream var1) {
        this.writeInt(var1.size());
        var1.writeTo(this.dataStream);
    }

    @SneakyThrows
    public strictfp void a(byte[] var1) {
        this.writeInt(var1.length);
        this.dataStream.write(var1);
    }

    @SneakyThrows
    public strictfp void b(byte[] var1) {
        this.dataStream.write(var1);
    }

    @SneakyThrows
    public strictfp void a(short var1) {
        this.dataStream.writeShort(var1);
    }

    public strictfp void e() {
        this.a((short)12345);
    }

    public strictfp void d(String var1) {
    }

    public strictfp boolean f() {
        return false;
    }

    public strictfp void e(String var1) {
        this.startBlock(var1, false);
    }

    public strictfp void startBlock(String var1, boolean var2) {
        GzipDataOutStream var3 = new GzipDataOutStream(var2);
        var3.c = var1;
        this.e.add(var3);
        this.dataStream = ((GzipDataOutStream)this.e.getLast()).e;
    }

    @SneakyThrows
    public strictfp void endBlock(String var1) {
        GzipDataOutStream var2 = (GzipDataOutStream)this.e.removeLast();
        if (!var2.c.equals(var1)) {
            GameEngine.b("OutputNetStream:endBlock", "Name does not match: expected" + var1 + " , got:" + var2.c);
        }

        var2.a();
        if (this.e.isEmpty()) {
            this.dataStream = this.useStream;
        } else {
            this.dataStream = ((GzipDataOutStream)this.e.getLast()).e;
        }

        this.dataStream.writeUTF(var2.c);
        this.a(var2.d);

        try {
            var2.b();
        } catch (Exception var4) {
            if (var4 instanceof DataFormatException) {
                if (!GameEngine.aZ) {
                    GameEngine.print("DataFormatException error calling streamBlock.close() (this is expected on android 4.4)");
                }
            } else {
                GameEngine.print("Error calling streamBlock.close() to clean up memory");
                var4.printStackTrace();
            }
        }

    }

    public strictfp int getPacketVersion() {
        return this.packetVersion;
    }

    public strictfp void h() {
        this.useStream = null;
        this.dataStream = null;

        try {
            if (this.byteStream != null) {
                this.byteStream.close();
            }
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        this.byteStream = null;
    }
}
