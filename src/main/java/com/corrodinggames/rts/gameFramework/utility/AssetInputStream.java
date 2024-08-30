package com.corrodinggames.rts.gameFramework.utility;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.corrodinggames.rts.appFramework.class_208;
import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.j
public strictfp class AssetInputStream extends InputStream {
    InputStream a;
    String b;
    String c;
    boolean d;
    String e;

    public boolean a() {
        if (this.a instanceof FileInputStream) {
            return true;
        } else {
            return !GameEngine.av() && this.c != null;
        }
    }

    @SneakyThrows
    public FileDescriptor b() {
        if (this.a instanceof FileInputStream) {
            FileInputStream var4 = (FileInputStream)this.a;
            return var4.getFD();
        } else if (!GameEngine.av() && this.c != null) {
            Context var1 = class_208.a();
            AssetManager var2 = var1.d();
            AssetFileDescriptor var3 = var2.b(this.c);
            return var3.getFileDescriptor();
        } else {
            throw new RuntimeException("AssetInputStream: unexpected stream for: " + this.b);
        }
    }

    private AssetInputStream() {
    }

    @SneakyThrows
    public AssetInputStream(InputStream var1, String var2, String var3) {
        if (var1 == null) {
            throw new FileNotFoundException();
        } else {
            this.a = var1;
            this.b = var2;
            this.c = var3;
            this.e = GameEngine.U();
        }
    }

    @SneakyThrows
    public AssetInputStream(FileInputStream var1, String var2) {
        if (var1 == null) {
            throw new FileNotFoundException();
        } else {
            this.a = var1;
            this.b = var2;
            this.e = GameEngine.U();
        }
    }

    @SneakyThrows
    public AssetInputStream(InputStream var1, String var2) {
        if (var1 == null) {
            throw new FileNotFoundException();
        } else {
            this.a = var1;
            this.b = var2;
            this.e = GameEngine.U();
        }
    }

    public long c() {
        if (!GameEngine.av()) {
            return -1L;
        } else if (this.b == null) {
            return -2L;
        } else {
            File var1 = new File(this.b);
            return var1.lastModified();
        }
    }

    public String d() {
        return this.b;
    }

    @SneakyThrows
    public int available() {
        return this.a.available();
    }

    @SneakyThrows
    public void close() {
        this.d = true;
        this.a.close();
    }

    protected void finalize() {
        if (!this.d) {
            GameEngine.print("AssetInputStream was finalized with being closed");
            GameEngine.print(this.e);
        }

    }

    public boolean equals(Object var1) {
        return this.a.equals(var1);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void mark(int var1) {
        this.a.mark(var1);
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    @SneakyThrows
    public int read() {
        return this.a.read();
    }

    @SneakyThrows
    public int read(byte[] var1, int var2, int var3) {
        return this.a.read(var1, var2, var3);
    }

    @SneakyThrows
    public int read(byte[] var1) {
        return this.a.read(var1);
    }

    @SneakyThrows
    public void reset() {
        this.a.reset();
    }

    @SneakyThrows
    public long skip(long var1) {
        return this.a.skip(var1);
    }

    public String toString() {
        return this.a.toString();
    }
}
