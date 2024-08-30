package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.q
public strictfp class class_361 {
    class_684 a = new class_684();

    public strictfp void a(Runnable var1) {
        this.a.add(var1);
    }

    public strictfp void a() {
        if (this.a.a > 0) {
            Iterator var1 = this.a.iterator();

            while(var1.hasNext()) {
                Runnable var2 = (Runnable)var1.next();
                var2.run();
            }
        }

    }

    public strictfp void b() {
        if (this.a.a > 0) {
            Iterator var1 = this.a.iterator();

            while(var1.hasNext()) {
                Runnable var2 = (Runnable)var1.next();
                var2.run();
            }

            this.a.clear();
        }

    }
}
