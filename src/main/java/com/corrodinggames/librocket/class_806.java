package com.corrodinggames.librocket;

import com.LibRocket$TextureHolder;
import com.corrodinggames.rts.game.units.class_31;

// $FF: renamed from: com.corrodinggames.librocket.c
public abstract class class_806 extends LibRocket$TextureHolder {
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public float e;
    public class_31 f;
    // $FF: synthetic field
    final class_60 g;

    public class_806(class_60 var1) {
        super(var1);
        this.g = var1;
        this.e = 1.0F;
    }

    public abstract boolean a();
}
