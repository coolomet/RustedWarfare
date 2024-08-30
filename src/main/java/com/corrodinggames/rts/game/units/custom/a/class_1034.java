package com.corrodinggames.rts.game.units.custom.a;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.a.class_1033;
import com.corrodinggames.rts.game.units.custom.d.class_447;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.b
public strictfp class class_1034 extends class_1033 {
    public class_1033 b;
    public class_447 c;
    public class_447 d;

    public class_1034(class_1033 var1) {
        this.b = var1;
    }

    public boolean b(Unit var1) {
        return this.b.b(var1);
    }

    public String c(Unit var1) {
        return this.b.c(var1);
    }

    public boolean a(Unit var1, boolean var2) {
        return this.b.a(var1, var2);
    }

    public boolean d(Unit var1) {
        return this.b.d(var1);
    }

    public class_447 a() {
        return this.c != null ? this.c : this.b.a();
    }

    public class_447 b() {
        return this.d != null ? this.d : this.b.b();
    }

    public void a(Unit var1, Unit var2) {
        this.b.a(var1, var2);
    }
}
