package com.corrodinggames.rts.appFramework;

import com.corrodinggames.rts.gameFramework.net.ListRoomInfo;
import java.util.Comparator;

// $FF: renamed from: com.corrodinggames.rts.appFramework.p.1
final class class_57 implements Comparator {
    public int a(ListRoomInfo var1) {
        if (var1.d()) {
            return 0;
        } else if (var1.x && var1.s.equals("chat")) {
            return 1;
        } else if (var1.a) {
            return 2;
        } else if (!var1.s.equals("battleroom")) {
            return 99;
        } else {
            if (var1.v != -1 && var1.v < var1.w) {
                if (var1.x) {
                    if (var1.v != 0) {
                        return 3;
                    }

                    return 4;
                }

                if (var1.h && !var1.x) {
                    return 7;
                }
            } else {
                if (var1.x) {
                    return 6;
                }

                if (var1.h && !var1.x) {
                    return 8;
                }
            }

            return 9;
        }
    }

    public int a(ListRoomInfo var1, ListRoomInfo var2) {
        Integer var3 = this.a(var1);
        Integer var4 = this.a(var2);
        if (!var1.g()) {
            var3 = var3 + 20;
        }

        if (!var2.g()) {
            var4 = var4 + 20;
        }

        int var5 = var3.compareTo(var4);
        return var5 != 0 ? var5 : var1.q.compareTo(var2.q);
    }

    // $FF: synthetic method
    public int compare(Object var1, Object var2) {
        return this.a((ListRoomInfo)var1, (ListRoomInfo)var2);
    }
}
