package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;

// $FF: renamed from: com.corrodinggames.rts.appFramework.n.4
final class class_706 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final EnterPasswordCallback a;

    class_706(EnterPasswordCallback var1) {
        this.a = var1;
    }

    public void onClick(DialogInterface var1, int var2) {
        this.a.a();
        class_195.i = null;
        class_195.j = null;
    }
}
