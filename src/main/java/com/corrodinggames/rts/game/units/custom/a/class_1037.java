package com.corrodinggames.rts.game.units.custom.a;

import android.graphics.PointF;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.a.class_1052;
import com.corrodinggames.rts.game.units.a.DisplayType;
import com.corrodinggames.rts.game.units.custom.class_164;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_392;
import com.corrodinggames.rts.game.units.custom.class_397;
import com.corrodinggames.rts.game.units.custom.class_399;
import com.corrodinggames.rts.game.units.custom.class_441;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.class_592;
import com.corrodinggames.rts.game.units.custom.class_598;
import com.corrodinggames.rts.game.units.custom.class_601;
import com.corrodinggames.rts.game.units.custom.class_605;
import com.corrodinggames.rts.game.units.custom.b.class_600;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.UnitReference$UnitReferenceOrUnitType;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.a.d
public strictfp class class_1037 {
    public int a;
    public String b;
    public String c;
    public class_441 d;
    public UnitReference$UnitReferenceOrUnitType e;
    public UnitReference$UnitReferenceOrUnitType f;
    public UnitReference$UnitReferenceOrUnitType g;
    public class_388 h;
    public class_441 i;
    public class_1052 j;
    public String k;
    public class_601 l;
    public class_399[] m;
    public boolean n;
    public boolean o;
    public float p;
    public class_447 q;
    public class_447 r;
    public class_588 s;
    public LogicBoolean t;
    public LogicBoolean u;
    public LogicBoolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public LogicBoolean z;
    public class_441 A;
    public LogicBoolean B;
    public class_441 C;
    public LogicBoolean D;
    public class_441 E;
    public LogicBoolean F;
    public LogicBoolean G;
    public class_601 H;
    public class_601 I;
    public class_601 J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public class_399[] R;
    public float S;
    public boolean T;
    public boolean U;
    public class_592 V;
    public Float W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public class_397 aa;
    public class_598 ab;
    public class_684 ac;
    public Float ad;
    public class_447 ae;
    public class_447 af;
    public Integer ag;
    public PointF ah;
    public LogicBoolean ai;
    public class_164 aj;
    public int ak;
    public MovementType al;
    public class_600 am;
    public LogicBoolean an;
    public LogicBoolean ao;
    public class_598 ap;
    public class_598 aq;
    public LogicBoolean ar;
    public class_605 as;
    public class_605 at;
    public class_392 au;
    public class_392 av;
    public class_392 aw;
    public class_392 ax;
    public TeamImageCache ay;
    public TeamImageCache az;
    public int aA;
    public LogicBoolean aB;
    public UnitReference$UnitReferenceOrUnitType aC;
    public boolean aD;
    public boolean aE;
    public LogicBoolean aF;
    public DisplayType aG;
    public LogicBoolean aH;
    public boolean aI;
    public int aJ;
    public boolean aK;
    public String aL;
    public class_1032 aM;
    public AIUse aN;

    public class_1037() {
        this.j = class_1052.popupQueue;
        this.p = -999.0F;
        this.K = false;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = false;
        this.S = 0.01F;
        this.T = false;
        this.U = false;
        this.ac = new class_684();
        this.aG = DisplayType.queueUnit;
        this.aM = class_1032.build;
        this.aN = AIUse.auto;
    }

    public String a() {
        return this.d != null ? this.d.b() : this.c;
    }
}
