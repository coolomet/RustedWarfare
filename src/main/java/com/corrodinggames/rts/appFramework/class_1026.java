package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import com.corrodinggames.rts.gameFramework.GameEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g.4
class class_1026 implements DialogInterface.OnClickListener {
    // $FF: synthetic field
    final EditText a;
    // $FF: synthetic field
    final GameEngine b;
    // $FF: synthetic field
    final class_198 c;

    class_1026(class_198 var1, EditText var2, GameEngine var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void onClick(DialogInterface var1, int var2) {
        String var3 = this.a.getText().toString();
        if (!var3.contains("/") && !var3.contains("\\") && !var3.contains(":") && !var3.contains("*") && !var3.contains("?") && !var3.contains("\"") && !var3.contains("<") && !var3.contains(">")) {
            this.b.bL.a(this.b.dl, "/SD/rustedWarfare/maps/" + var3 + ".tmx");
        } else {
            AlertDialog.Builder var4 = new AlertDialog.Builder(this.c);
            var4.setTitle("Bad Map Name");
            var4.setMessage("The characters /\\:*?\"<> are not allowed (fat32 formatting)");
            var4.setPositiveButton("Ok", new class_362(this, var3));
            var4.show();
        }

    }
}
