package com.corrodinggames.rts.gameFramework;

import java.util.ArrayList;
import java.util.Iterator;

public strictfp class CollisionEngine {
    public class_344 a = this.a((byte)1);
    public class_344 b = this.a((byte)2);
    public class_344 c = this.a((byte)3);
    public class_344 d = this.a((byte)4);
    public class_344 e = this.a((byte)10);
    public class_344 f = this.a((byte)11);
    public class_344 g = this.a((byte)13);
    public class_344 h = this.a((byte)21);
    public class_344 i = this.a((byte)35);
    public class_344 j = this.a((byte)40);
    public class_344 k = this.a((byte)45);
    public class_344 l = this.a((byte)52);
    public class_344 m = this.a((byte)60);
    ArrayList<class_344> n = new ArrayList<>();

    public CollisionEngine() {
        class_344 var1 = null;
        var1 = this.a;
        var1.a(var1);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)11));
        var1.a(this.a((byte)13));
        var1.a(this.a((byte)21));
        var1 = this.k;
        var1.a(this.a((byte)52));
        var1 = this.m;
        var1.a(var1);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)11));
        var1.a(this.a((byte)13));
        var1.a(this.a((byte)21));
        var1 = this.a((byte)10);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1.a(this.a((byte)40));
        var1 = this.a((byte)11);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1.a(this.a((byte)40));
        var1 = this.a((byte)3);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1 = this.a((byte)4);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1 = this.a((byte)13);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1 = this.a((byte)21);
        var1.a(this.a((byte)3));
        var1.a(this.a((byte)4));
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
        var1 = this.i;
        var1.a(this.a((byte)10));
        var1.a(this.a((byte)13));
    }

    public strictfp class_344 a(byte var1) {
        if (n == null)
            n = new ArrayList<>();
        Iterator<class_344> var2 = this.n.iterator();

        class_344 var3;
        do {
            if (!var2.hasNext()) {
                class_344 var4 = new class_344();
                var4.a = var1;
                this.n.add(var4);
                return var4;
            }

            var3 = (class_344)var2.next();
        } while(var3.a != var1);

        return var3;
    }
}
