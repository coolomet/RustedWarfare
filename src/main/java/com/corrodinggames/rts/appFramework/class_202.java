package com.corrodinggames.rts.appFramework;

import android.net.Uri;

// $FF: renamed from: com.corrodinggames.rts.appFramework.s
public strictfp class class_202 extends class_194 {
    boolean c = true;
    static boolean d = false;
    int[] e = new int[]{100, 250, 500, 1000, 2000, 5000, 10000};
    class_206 f = new class_207(this);

    public void l() {
        String var1 = "rustedWarfare".replace("//", "%2F");
        Uri var2 = Uri.parse("content://com.android.externalstorage.documents/document/primary%3A" + var1);
        class_208.a(this, 9, true, "Select a Rusted Warfare Folder to use", var2);
    }
}
