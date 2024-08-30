package com.corrodinggames.rts.appFramework;

import android.content.DialogInterface;
import android.widget.EditText;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;

// $FF: renamed from: com.corrodinggames.rts.appFramework.n.3
final class class_707 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final EditText a;
    // $FF: synthetic field
    final EnterPasswordCallback b;

    class_707(EditText var1, EnterPasswordCallback var2) {
        this.a = var1;
        this.b = var2;
    }

    public void onClick(DialogInterface var1, int var2) {
        String var3 = this.a.getText().toString();
        this.b.a(var3);
        class_195.i = null;
        class_195.j = null;
    }
}
