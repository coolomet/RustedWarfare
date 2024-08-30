package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public strictfp class GzipDataOutStream {
    public GZIPOutputStream a;
    public BufferedOutputStream b;
    public String c;
    public ByteArrayOutputStream d = new ByteArrayOutputStream();
    public DataOutputStream e;
    public boolean f = false;

    @SneakyThrows
    public strictfp void a() {
        this.e.flush();
        if (this.b != null) {
            this.b.flush();
        }

        if (this.a != null) {
            this.a.finish();
        }

    }

    @SneakyThrows
    public strictfp void b() {
        if (!this.f) {
            this.e.close();
        } else {
            GameEngine.warn("TODO: Cannot yet close wrapped stream");
        }

    }

    @SneakyThrows
    public GzipDataOutStream(boolean var1) {
        Object var2;
        if (var1) {
            this.a = new GZIPOutputStream(this.d);
            this.b = new BufferedOutputStream(this.a);
            var2 = this.b;
        } else {
            var2 = this.d;
        }

        this.e = new DataOutputStream((OutputStream)var2);
    }
}
