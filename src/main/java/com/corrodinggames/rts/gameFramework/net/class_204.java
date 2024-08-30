package com.corrodinggames.rts.gameFramework.net;

import android.text.Html;
import android.text.Spanned;
import com.corrodinggames.rts.gameFramework.class_340;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.net.a
public strictfp class class_204 {
    private ConcurrentLinkedQueue a = new ConcurrentLinkedQueue();

    public String a(String var1) {
        return class_340.i(var1);
    }

    public void a(int var1, String var2, String var3, PlayerConnect var4) {
        var3 = var3.trim();
        class_209 var5 = new class_209(this, var1, var2, var3, var4);
        this.a.add(var5);
        if (this.a.size() > 45) {
            this.a.poll();
        }

    }

    public int a(PlayerConnect var1, int var2) {
        if (var1 == null) {
            return 0;
        } else {
            int var3 = var1.connectIndex;
            int var4 = 0;
            Iterator var5 = this.a.iterator();

            while(var5.hasNext()) {
                class_209 var6 = (class_209)var5.next();
                if (var6.d == var3 && class_340.a(var6.e, System.nanoTime()) < (long)var2 && !var6.c.startsWith("-i ") && !var6.c.startsWith("-qc ")) {
                    ++var4;
                    if (var6.c != null) {
                        if (class_340.a(var6.c, '\n') >= 3) {
                            var4 += 2;
                        }

                        if (class_340.a(var6.c, '\n') >= 6) {
                            var4 += 2;
                        }

                        if (class_340.a(var6.c, '\n') >= 9) {
                            var4 += 2;
                        }
                    }
                }
            }

            return var4;
        }
    }

    public String a() {
        String var1 = "";

        class_209 var3;
        for(Iterator var2 = this.a.iterator(); var2.hasNext(); var1 = var1 + var3.a() + "\n") {
            var3 = (class_209)var2.next();
        }

        return var1;
    }

    public ConcurrentLinkedQueue b() {
        return this.a;
    }

    public String a(boolean var1) {
        String var2 = "";
        Iterator var3;
        class_209 var4;
        if (!var1) {
            for(var3 = this.a.iterator(); var3.hasNext(); var2 = var2 + var4.b() + "<br/>\n") {
                var4 = (class_209)var3.next();
            }
        } else {
            for(var3 = this.a.iterator(); var3.hasNext(); var2 = var4.b() + "<br/>\n" + var2) {
                var4 = (class_209)var3.next();
            }
        }

        return "<pre>" + var2 + "</pre>";
    }

    public Spanned b(boolean var1) {
        return Html.fromHtml(this.a(var1));
    }

    public void c() {
        this.a.clear();
    }
}
