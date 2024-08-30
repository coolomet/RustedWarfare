package com.corrodinggames.rts.java.audio.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// $FF: renamed from: com.corrodinggames.rts.java.audio.a.a
public strictfp class class_36 {
    protected InputStream a;
    protected File b;
    protected String c;

    public class_36(String var1) {
        this.b = new File(var1);
        this.c = this.b.getName();
    }

    public class_36(InputStream var1, String var2) {
        this.a = var1;
        this.c = var2;
        if (this.a == null) {
            throw new RuntimeException("inputStream==null");
        }
    }

    public InputStream a() {
        if (this.a != null) {
            return this.a;
        } else {
            try {
                return new FileInputStream(this.b);
            } catch (FileNotFoundException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public String b() {
        String var1 = this.c;
        int var2 = var1.lastIndexOf(46);
        return var2 == -1 ? "" : var1.substring(var2 + 1);
    }
}
