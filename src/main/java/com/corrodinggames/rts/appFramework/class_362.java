package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.4.1
class class_362 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final String a;
    // $FF: synthetic field
    final class_1026 b;

    class_362(class_1026 var1, String var2) {
        this.b = var1;
        this.a = var2;
    }

    public void onClick(DialogInterface var1, int var2) {
        class_198.b(this.b.c, this.a);
    }
}
