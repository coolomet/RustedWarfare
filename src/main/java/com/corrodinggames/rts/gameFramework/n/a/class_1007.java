package com.corrodinggames.rts.gameFramework.n.a;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.maps.MapException;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.gameFramework.n.class_637;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.n.a.b
public strictfp class class_1007 extends class_1005 {
    PlayerData a;
    class_585 b;

    @SneakyThrows
    public static class_1007 d(class_637 var0) {
        class_1007 var1 = new class_1007();
        var1.a = var0.a();
        if (var1.a == null) {
            throw new MapException("teamTagDetect requires a team set");
        } else {
            String var2 = var0.b("teamTag");
            if (var2 != null && !var2.equals("")) {
                try {
                    var1.b = class_585.b(var2);
                    return var1;
                } catch (Exception var4) {
                    throw new MapException(var4.getMessage());
                }
            } else {
                throw new MapException("teamTagDetect requires a teamTag set");
            }
        }
    }

    public boolean b(class_637 var1) {
        return class_585.a(this.b, this.a.U());
    }
}
