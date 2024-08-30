package com.corrodinggames.rts.gameFramework.n;

import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.b
public strictfp class class_638 {
    class_684 a = new class_684();
    boolean b;

    public void a(class_637 var1) {
        this.a.add(var1);
    }

    public boolean a() {
        return this.a.a > 0;
    }

    public boolean b() {
        boolean var1 = false;
        boolean var2 = true;
        Iterator var3 = this.a.iterator();

        while(var3.hasNext()) {
            class_637 var4 = (class_637)var3.next();
            if (var4.j) {
                var1 = true;
            } else {
                var2 = false;
            }
        }

        if (this.b && !var2) {
            var1 = false;
        }

        return var1;
    }
}
