package com.corrodinggames.rts.appFramework;

import android.app.Activity;
import java.util.ArrayList;

// $FF: renamed from: com.corrodinggames.rts.appFramework.b
public strictfp class class_194 extends Activity {
    ArrayList b = new ArrayList();

    public void a(Runnable var1) {
        synchronized(this.b) {
            this.b.add(var1);
        }
    }
}
