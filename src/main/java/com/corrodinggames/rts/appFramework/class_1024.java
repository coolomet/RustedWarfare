package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.6
class class_1024 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final EditText a;
    // $FF: synthetic field
    final class_198 b;

    class_1024(class_198 var1, EditText var2) {
        this.b = var1;
        this.a = var2;
    }

    public void onClick(DialogInterface var1, int var2) {
        String var3 = this.a.getText().toString();
        if (!var3.contains("/") && !var3.contains("\\") && !var3.contains(":") && !var3.contains("*") && !var3.contains("?") && !var3.contains("\"") && !var3.contains("<") && !var3.contains(">")) {
            this.b.d(var3);
        } else {
            AlertDialog.Builder var4 = new AlertDialog.Builder(this.b);
            var4.setTitle("Bad Save Name");
            var4.setMessage("The characters /\\:*?\"<> are not allowed (fat32 formatting)");
            var4.setPositiveButton("Ok", new class_937(this, var3));
            var4.show();
        }

    }
}
