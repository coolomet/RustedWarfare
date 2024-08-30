package com.corrodinggames.rts.debug.test;

import com.corrodinggames.rts.a.a.class_650;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.k.class_316;
import com.corrodinggames.rts.gameFramework.k.class_317;
import com.corrodinggames.rts.gameFramework.k.class_318;
import com.corrodinggames.rts.gameFramework.k.class_322;

public strictfp class TestFastNodeQueue extends AbstractScriptTest {
    public class_322 a(int var1) {
        class_322 var2 = new class_322();
        var2.a((short)var1, (short)0);
        var2.a(0, 0, 0);
        return var2;
    }

    public void a() {
        GameEngine.log("== Testing FastNodeQueue ==");
        class_318 var1 = new class_318();
        this.a(var1);
        GameEngine.log("== Testing FastNodeQueue2 ==");
        class_317 var2 = new class_317();
        this.a(var2);
    }

    public void a(class_316 var1) {
        class_322 var2 = this.a(1);
        class_322 var3 = this.a(2);
        class_322 var4 = this.a(3);
        class_322 var5 = this.a(4);
        GameEngine.log("sequential");
        var1.b();
        var1.a(var2);
        var1.a(var3);
        var1.a(var4);
        var1.a(var5);
        class_650.a((Object)var1.a(), (Object)var2);
        class_650.a((Object)var1.a(), (Object)var3);
        class_650.a((Object)var1.a(), (Object)var4);
        class_650.a((Object)var1.a(), (Object)var5);
        GameEngine.log("reverse sequence");
        var1.b();
        var1.a(var5);
        var1.a(var4);
        var1.a(var3);
        var1.a(var2);
        class_650.a((Object)var1.a(), (Object)var2);
        class_650.a((Object)var1.a(), (Object)var3);
        class_650.a((Object)var1.a(), (Object)var4);
        class_650.a((Object)var1.a(), (Object)var5);
        GameEngine.log("sequential with noise");
        var1.b();
        var1.a(var2);

        int var6;
        for(var6 = 0; var6 < 1000; ++var6) {
            var1.a(this.a(100 + var6));
        }

        class_650.a((Object)var1.a(), (Object)var2);
        var1.a(var3);
        var1.a(var4);

        for(var6 = 0; var6 < 1000; ++var6) {
            var1.a(this.a(100 + var6));
        }

        class_650.a((Object)var1.a(), (Object)var3);
        var1.a(var5);
        class_650.a((Object)var1.a(), (Object)var4);
        class_650.a((Object)var1.a(), (Object)var5);
        GameEngine.log("reverse sequence with noise");
        var1.b();
        var1.a(var5);
        var1.a(var4);

        for(var6 = 0; var6 < 1000; ++var6) {
            var1.a(this.a(100 + var6));
        }

        var1.a(var3);

        for(var6 = 0; var6 < 1000; ++var6) {
            var1.a(this.a(100 + var6));
        }

        var1.a(var2);
        class_650.a((Object)var1.a(), (Object)var2);
        class_650.a((Object)var1.a(), (Object)var3);
        class_650.a((Object)var1.a(), (Object)var4);
        class_650.a((Object)var1.a(), (Object)var5);
    }
}
