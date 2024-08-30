package com.corrodinggames.librocket;

import com.corrodinggames.librocket.scripts.Root;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;
import com.corrodinggames.rts.gameFramework.utility.class_678;

// $FF: renamed from: com.corrodinggames.librocket.a.2
class class_641 implements Runnable {
    final class_678 a;
    // $FF: synthetic field
    final ScriptEngine b;
    // $FF: synthetic field
    final EnterPasswordCallback c;
    // $FF: synthetic field
    final class_790 d;

    class_641(class_790 var1, ScriptEngine var2, EnterPasswordCallback var3) {
        this.d = var1;
        this.b = var2;
        this.c = var3;
        this.a = new class_678(false);
    }

    public void run() {
        Root var1 = this.b.getRoot();
        class_804 var2 = new class_804(this.c.f != null ? this.c.f : "Join", new class_961(this, var1));
        var2.c = true;
        class_962 var3 = new class_962(this, var1);
        class_804 var4 = new class_804(this.c.g != null ? this.c.g : "Close", var3);
        String var5 = "Password Required";
        String var6 = "This server requires a password to join";
        if (this.c.b != null) {
            var5 = "Server Question";
            var6 = this.c.b;
            var6 = class_1009.c(var6);
        }

        if (this.c.e != null) {
            var5 = this.c.e;
        }

        String var7 = "";
        class_805 var8 = new class_805();
        var8.b = var5;
        var8.c = var6;
        var8.d = var7;
        var8.e = var4;
        var8.f = var2;
        var8.h = false;
        var8.i = var3;
        this.d.b.a(var8);
    }
}
