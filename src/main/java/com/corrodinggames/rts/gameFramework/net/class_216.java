package com.corrodinggames.rts.gameFramework.net;

import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.l
public strictfp class class_216 {
    public String a;
    public ByteArrayInputStream b;
    public DataInputStream c;

    @SneakyThrows
    public class_216(byte[] var1, boolean var2, boolean var3) {
        this.b = new ByteArrayInputStream(var1);
        Object var4;
        if (var2) {
            var4 = new BufferedInputStream(new GZIPInputStream(this.b));
        } else {
            var4 = this.b;
        }

        this.c = new DataInputStream((InputStream)var4);
    }
}
