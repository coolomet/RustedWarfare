package com.corrodinggames.rts.java.audio.a;

import lombok.SneakyThrows;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

// $FF: renamed from: com.corrodinggames.rts.java.audio.a.s
public final strictfp class class_49 {
    public static final byte[] a = new byte[0];

    public static void a(InputStream var0, OutputStream var1) {
        a(var0, var1, new byte[4096]);
    }

    @SneakyThrows
    public static void a(InputStream var0, OutputStream var1, byte[] var2) {
        int var3;
        while((var3 = var0.read(var2)) != -1) {
            var1.write(var2, 0, var3);
        }

    }

    public static byte[] a(InputStream var0, int var1) {
        class_48 var2 = new class_48(Math.max(0, var1));
        a(var0, var2);
        return var2.toByteArray();
    }

    public static void a(Closeable var0) {
        if (var0 != null) {
            try {
                var0.close();
            } catch (Throwable var2) {
            }
        }

    }
}
