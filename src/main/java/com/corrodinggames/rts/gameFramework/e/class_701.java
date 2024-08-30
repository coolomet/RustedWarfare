package com.corrodinggames.rts.gameFramework.e;

import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.e.h
class class_701 {
    public InputStream a;

    public class_701(InputStream var1) {
        this.a = var1;
    }

    public void a() {
        try {
            if (this.a != null) {
                this.a.close();
            }
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}
