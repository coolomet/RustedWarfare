package com.corrodinggames.rts.game.units.custom.b;

import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.m.class_525;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.b.d
public strictfp class class_930 implements Comparable {
    String a;
    boolean b = false;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    Side h;
    boolean i;
    public float j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public float p;
    public boolean q;
    public LogicBoolean r;
    public LogicBoolean s;
    public LogicBoolean t;
    public boolean u;
    public class_927 v;
    public class_927[] w;
    public float x;
    public int y;
    public boolean z;
    LogicBoolean A;
    LogicBoolean B;
    public TeamImageCache C;
    public float D;
    public float E;
    public LogicBoolean F;
    public LayerType G;
    public float H;
    public boolean I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public LogicBoolean N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public LogicBoolean W;
    public LogicBoolean X;
    public boolean Y;
    public boolean Z;
    public float aa;
    public float ab;
    public LogicBoolean ac;
    public LogicBoolean ad;
    public int ae;
    public boolean af;
    public int ag;
    public class_525 ah;
    public LogicBoolean ai;

    public class_930() {
        this.h = Side.ANY;
        this.o = -1;
        this.p = 1.0F;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.ae = -1;
        this.ag = -1;
    }

    public strictfp int a(class_930 var1) {
        if (var1 == null) {
            return 0;
        } else {
            float var2 = this.H - var1.H;
            if (var2 < 0.0F) {
                return -1;
            } else {
                return var2 > 0.0F ? 1 : 0;
            }
        }
    }

    // $FF: synthetic method
    public int compareTo(Object var1) {
        return this.a((class_930)var1);
    }
}
