package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import lombok.SneakyThrows;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.ax
public strictfp class class_1018 {
    public BufferedOutputStream a;
    public String b;
    public ByteArrayOutputStream c = new ByteArrayOutputStream();
    public PrintStream d;
    public boolean e = false;

    @SneakyThrows
    public strictfp void a() {
        this.d.flush();
        if (this.a != null) {
            this.a.flush();
        }

    }

    public strictfp void b() {
        if (!this.e) {
            this.d.close();
        } else {
            GameEngine.warn("TODO: Cannot yet close wrapped stream");
        }

    }

    public class_1018(boolean var1) {
        Object var2;
        if (var1) {
            this.a = new BufferedOutputStream(this.c);
            var2 = this.a;
        } else {
            var2 = this.c;
        }

        this.d = new PrintStream((OutputStream)var2);
    }
}
