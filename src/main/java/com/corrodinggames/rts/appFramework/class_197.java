package com.corrodinggames.rts.appFramework;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.e.class_697;
import java.util.ArrayList;
import java.util.Collections;

// $FF: renamed from: com.corrodinggames.rts.appFramework.q
public strictfp class class_197 extends class_194 {
    String[] c;

    public void b() {
        super.b();
        class_208.a(this, true);
    }

    public static String[] l() {
        String[] var0 = class_697.h("/SD/rustedWarfare/replays/");
        if (var0 == null) {
            GameEngine.log("failed to find replay folder");
            return null;
        } else {
            ArrayList var1 = new ArrayList();
            String[] var2 = var0;
            int var3 = var0.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String var5 = var2[var4];
                if (!var5.endsWith(".map")) {
                    var1.add(var5);
                }
            }

            Collections.sort(var1, new class_210());
            return (String[])var1.toArray(new String[0]);
        }
    }

    public void onCreateContextMenu(ContextMenu var1, View var2, ContextMenu.ContextMenuInfo var3) {
        super.onCreateContextMenu(var1, var2, var3);
        Button var4 = (Button)var2;
        var1.setHeaderTitle(var4.getText());
        var1.add(0, var2.getId(), 0, "Share");
        var1.add(1, var2.getId(), 0, "Rename");
        var1.add(2, var2.getId(), 0, "Delete");
        if (this.c != null && this.c.length > 0) {
            String var5 = this.c[var2.getId()];
            String var6 = class_697.n(var5);
            MenuItem var7 = var1.add(3, var2.getId(), 0, "Storage: " + var6);
            if (var7 != null) {
                var7.setEnabled(false);
            }
        }

    }
}
