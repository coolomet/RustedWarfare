package com.corrodinggames.rts.gameFramework.a;

import android.content.Context;
import com.corrodinggames.rts.AssetsID$raw;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.a.f
public strictfp class class_350 extends class_349 {
    public void a(Context var1) {
    }

    public class_355 a(int var1) {
        String var2 = class_340.a(AssetsID$raw.class, var1);
        class_356 var3 = new class_356(var2, this);
        return var3;
    }

    public class_355 a(String var1, AssetInputStream var2, boolean var3) {
        class_356 var4 = new class_356(var1, this);
        return var4;
    }

    public static class_355 b() {
        class_356 var0 = new class_356("Null (from out of memory)", (class_349)null);
        return var0;
    }

    public static class_355 a(String var0) {
        class_356 var1 = new class_356("Null sound - " + var0, (class_349)null);
        return var1;
    }
}
