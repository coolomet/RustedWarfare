package com.corrodinggames.rts.gameFramework.b;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.i
public strictfp class class_478 extends class_477 {
    protected List a;
    // maybe error
    private List b;
    private class_468 c;
    private class_468 d;

    private void a(class_468 var1) {
        this.a();

        for(int var2 = 0; var2 < this.a.size(); ++var2) {
            this.b.add(new class_473(var1.b(), var1.c(), false));
        }

    }

    private void a() {
        Iterator var1 = this.b.iterator();

        while(var1.hasNext()) {
            class_473 var2 = (class_473)var1.next();
            var2.j();
        }

        this.b.clear();
    }

    public class_468 a(class_468 var1, class_13 var2, class_10 var3) {
        if (var1 instanceof class_473) {
            if (!((class_473)var1).k()) {
                return this.c;
            }
        } else if (this.d == var1 && this.c != null) {
            return this.c;
        }

        if (this.b.size() != this.a.size() || this.d != var1) {
            this.a(var1);
        }

        this.d = var1;
        Object var4 = var1;
        int var5 = 0;

        for(int var6 = this.b.size(); var5 < var6; ++var5) {
            class_473 var7 = (class_473)this.b.get(var5);
            class_30 var8 = (class_30)this.a.get(var5);
            var2.c(var7);
            var3.a((class_468)var4, var8, var5 == 0);
            var2.d();
            var4 = var7;
            GameEngine.log("FilterGroup: renderTarget");
        }

        this.c = (class_468)var4;
        return (class_468)var4;
    }
}
