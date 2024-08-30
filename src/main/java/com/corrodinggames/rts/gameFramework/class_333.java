package com.corrodinggames.rts.gameFramework;

import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.x
class class_333 implements Comparator {
    public strictfp int a(GameObject var1, GameObject var2) {
        if (var1.em > var2.em) {
            return 1;
        } else if (var1.em < var2.em) {
            return -1;
        } else if (var1.en > var2.en) {
            return 1;
        } else if (var1.en < var2.en) {
            return -1;
        } else if (var1.yCord > var2.yCord) {
            return 1;
        } else {
            return var1.yCord < var2.yCord ? -1 : 0;
        }
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((GameObject)var1, (GameObject)var2);
    }
}
