package com.corrodinggames.rts.appFramework;

import android.util.Log;
import android.view.MotionEvent;
import java.lang.reflect.Method;

// $FF: renamed from: com.corrodinggames.rts.appFramework.l
public strictfp class class_213 {
    public static final boolean a;
    public static final boolean b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static int l = 6;
    private static int m = 8;
    private static final float[] n;
    private static final float[] o;
    private static final float[] p;
    private static final int[] q;
    private static final int[] r;

    // $FF: synthetic method
    static int[] a() {
        return r;
    }

    static {
        boolean var0 = false;

        try {
            d = MotionEvent.class.getMethod("getPointerCount");
            e = MotionEvent.class.getMethod("findPointerIndex", Integer.TYPE);
            f = MotionEvent.class.getMethod("getPressure", Integer.TYPE);
            g = MotionEvent.class.getMethod("getHistoricalX", Integer.TYPE, Integer.TYPE);
            h = MotionEvent.class.getMethod("getHistoricalY", Integer.TYPE, Integer.TYPE);
            i = MotionEvent.class.getMethod("getHistoricalPressure", Integer.TYPE, Integer.TYPE);
            j = MotionEvent.class.getMethod("getX", Integer.TYPE);
            k = MotionEvent.class.getMethod("getY", Integer.TYPE);
            var0 = true;
        } catch (Exception var5) {
            Log.b("MultiTouchController", "static initializer failed", var5);
        }

        a = var0;
        if (a) {
            try {
                l = MotionEvent.class.getField("ACTION_POINTER_UP").getInt((Object)null);
                m = MotionEvent.class.getField("ACTION_POINTER_INDEX_SHIFT").getInt((Object)null);
            } catch (Exception var4) {
            }
        }

        boolean var1 = false;

        try {
            c = MotionEvent.class.getMethod("getButtonState");
            var1 = true;
            Log.b("MultiTouchController", "--- Mouse API succeeded");
        } catch (Exception var3) {
            Log.b("MultiTouchController", "static initializer for mouse failed", var3);
        }

        b = var1;
        n = new float[10];
        o = new float[10];
        p = new float[10];
        q = new int[10];
        r = new int[10];
    }
}
