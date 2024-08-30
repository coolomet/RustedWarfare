package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.az
public abstract strictfp class class_75 extends GameObject {
    public int ex = 0;

    protected class_75(boolean var1) {
        super(var1);
    }

    public strictfp void a(GameOutputStream var1) {
        var1.d("xy is:");
        var1.writeFloat(this.xCord);
        var1.writeFloat(this.yCord);
        var1.writeFloat(this.zCord);
        var1.writeInt(this.ex);
        super.a(var1);
    }

    public strictfp void a(GameInputStream var1) {
        this.xCord = var1.readFloat();
        this.yCord = var1.readFloat();
        this.zCord = var1.readFloat();
        this.ex = var1.readInt();
        super.a(var1);
    }
}
