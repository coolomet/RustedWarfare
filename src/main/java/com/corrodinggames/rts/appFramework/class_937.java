package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.6.1
class class_937 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final class_1024 b;

    class_937(class_1024 var1, String var2) {
        this.b = var1;
        this.a = var2;
    }

    public void onClick(DialogInterface var1, int var2) {
        class_198.a(this.b.b, this.a);
    }
}
