package com.corrodinggames.rts.gameFramework.utility;

import android.os.Looper;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.a
public strictfp class class_702 extends Error {
    private class_702(class_699 var1) {
        super("Application Not Responding", var1);
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    static class_702 a(String var0, boolean var1) {
        Thread var2 = Looper.b().e();
        TreeMap var3 = new TreeMap(new class_1070(var2));
        Iterator var4 = Thread.getAllStackTraces().entrySet().iterator();

        while(true) {
            Map.Entry var5;
            do {
                if (!var4.hasNext()) {
                    if (!var3.containsKey(var2)) {
                        var3.put(var2, var2.getStackTrace());
                    }

                    class_699 var7 = null;

                    class_703 var10002;
                    for(Iterator var8 = var3.entrySet().iterator(); var8.hasNext(); var7 = new class_699(var10002, var7, (class_1070)null)) {
                        Map.Entry var6 = (Map.Entry)var8.next();
                        var10002 = new class_703(a((Thread)var6.getKey()), (StackTraceElement[])var6.getValue(), (class_1070)null);
                        var10002.getClass();
                    }

                    return new class_702(var7);
                }

                var5 = (Map.Entry)var4.next();
            } while(var5.getKey() != var2 && (!((Thread)var5.getKey()).getName().startsWith(var0) || !var1 && ((StackTraceElement[])var5.getValue()).length <= 0));

            var3.put(var5.getKey(), var5.getValue());
        }
    }

    static class_702 a() {
        Thread var0 = Looper.b().e();
        StackTraceElement[] var1 = var0.getStackTrace();
        class_703 var10004 = new class_703(a(var0), var1, (class_1070)null);
        var10004.getClass();
        return new class_702(new class_699(var10004, (class_699)null, (class_1070)null));
    }

    private static String a(Thread var0) {
        return var0.getName() + " (state = " + var0.getState() + ")";
    }
}
