package com.corrodinggames.rts.gameFramework;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ag
public strictfp class class_994 extends class_991 {
    int e;

    public boolean a(class_991 var1) {
        if (!(var1 instanceof class_994)) {
            return false;
        } else {
            class_994 var2 = (class_994)var1;
            return this.e != var2.e ? false : super.a(var1);
        }
    }

    public boolean a() {
        if (class_985.b.a(this.e, this.b, false)) {
            if (!this.c) {
                this.c = true;
                return true;
            } else {
                return false;
            }
        } else {
            if (class_985.b.a(this.e, this.b, true)) {
                this.c = true;
            } else if (this.c) {
                this.c = false;
            }

            return false;
        }
    }

    public boolean b() {
        return class_985.b.a(this.e, this.b, false);
    }

    public String c() {
        return this.e == 0 ? "" : class_985.b.c(this.e, this.b);
    }

    public boolean d() {
        return this.e == 0;
    }
}
