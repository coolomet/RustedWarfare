package com.corrodinggames.rts.game.units.custom.d;

import com.corrodinggames.rts.game.units.Unit;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.d.a
public abstract strictfp class class_446 {
    public abstract void a(Unit var1);

    public abstract boolean b(Unit var1);

    public abstract void a(Unit var1, double var2);

    public abstract boolean b(Unit var1, double var2);

    public boolean c(Unit var1) {
        if (this.b(var1)) {
            this.a(var1);
            return true;
        } else {
            return false;
        }
    }

    public boolean c(Unit var1, double var2) {
        if (this.b(var1, var2)) {
            this.a(var1, var2);
            return true;
        } else {
            return false;
        }
    }
}
