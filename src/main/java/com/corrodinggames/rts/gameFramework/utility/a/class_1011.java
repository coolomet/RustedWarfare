package com.corrodinggames.rts.gameFramework.utility.a;

import android.content.Context;
import android.net.Uri;
import com.corrodinggames.rts.appFramework.class_208;
import com.corrodinggames.rts.appFramework.common.SAFInterface;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.a.c
class class_1011 {
    String a;
    Uri b;
    boolean c;
    HashMap d;
    HashMap e;
    boolean f;
    int g;
    // $FF: synthetic field
    final class_1008 h;

    public class_1011(class_1008 var1, String var2, Uri var3, boolean var4) {
        this.h = var1;
        this.a = var2;
        this.b = var3;
        this.c = var4;
    }

    public HashMap a() {
        if (this.d == null || this.f || this.g != this.h.g) {
            synchronized(this) {
                if (this.d == null || this.f || this.g != this.h.g) {
                    this.a(class_208.a());
                }
            }
        }

        return this.d;
    }

    @SneakyThrows
    public void a(Context var1) {
        HashMap var2 = new HashMap();
        HashMap var3 = new HashMap();
        if (this.c) {
            ArrayList var4 = class_668.a.listWithDetails(var1, this.b);
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
                SAFInterface.FileRow var6 = (SAFInterface.FileRow)var5.next();
                String var7 = var6.id;
                Uri var8 = class_668.a.getChildUri(this.b, var7);
                String var9 = var6.name;
                boolean var10 = var6.isDirectory;
                if (var9.contains("/")) {
                    class_668.h("Name contains symbols: " + var9);
                    var9 = var9.replace("/", "_");
                }

                String var11 = this.a + "/" + var9;
                class_1011 var12 = new class_1011(this.h, var11, var8, var10);
                var2.put(var9, var12);
                String var13 = var9.toLowerCase(Locale.ROOT);
                if (var3.get(var13) == null) {
                    var3.put(var13, var12);
                }
            }
        }

        this.d = var2;
        this.e = var3;
        this.f = false;
        this.g = this.h.g;
    }
}
