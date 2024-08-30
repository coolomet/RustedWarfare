package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;

// $FF: renamed from: com.corrodinggames.rts.appFramework.n.5
final class class_705 implements DialogInterface.OnCancelListener {
    // $FF: synthetic field
    final EnterPasswordCallback a;

    class_705(EnterPasswordCallback var1) {
        this.a = var1;
    }

    public void onCancel(DialogInterface var1) {
        this.a.a();
        class_195.i = null;
        class_195.j = null;
    }
}
