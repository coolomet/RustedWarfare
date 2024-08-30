package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.Side;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.bg
public final strictfp class class_391 {
    String a;
    class_585 b;
    class_588 c;
    Side d;
    float e;
    float f;
    float g;
    float h;
    boolean i;
    boolean j;
    int k;
    int l;
    boolean m;
    boolean n;
    class_388 o;
    boolean p;

    public boolean a() {
        return this.n || this.m;
    }

    @SneakyThrows
    public void a(class_591 var1, UnitConfig var2, String var3) {
        this.b = var2.a((String)var3, "anyRuleInGroup", (class_585)null);
        this.c = var2.a((class_591)var1, var3, (String)"searchTags", (class_588)null);
        this.d = (Side)var2.a((String)var3, "searchTeam", (Enum) Side.OWN, (Class)Side.class);
        this.e = var2.i(var3, "searchDistance");
        this.f = this.e * this.e;
        this.g = var2.getValueAsFloatOrDefault(var3, "searchOffsetX", 0.0F);
        this.h = var2.getValueAsFloatOrDefault(var3, "searchOffsetY", 0.0F);
        this.i = var2.getValueAsBoolean(var3, "excludeIncompleteBuildings", false);
        this.j = var2.getValueAsBoolean(var3, "excludeNonBuildings", false);
        this.k = var2.getValueAsIntegerOrDefault(var3, "minCount", Integer.MIN_VALUE);
        this.l = var2.getValueAsIntegerOrDefault(var3, "maxCount", Integer.MAX_VALUE);
        this.p = var2.getValueAsBoolean(var3, "checkEachTile", true);
        this.m = var2.getValueAsBoolean(var3, "aiSuggestionOnly", false);
        this.n = var2.getValueAsBoolean(var3, "blocksPlacement", !this.m);
        if (this.m && this.n) {
            throw new CustomException("[" + var3 + "]: Cannot use aiSuggestionOnly and blocksPlacement at the same time");
        } else {
            this.o = class_436.a((UnitConfig)var2, (String)var3, "cannotPlaceMessage", (String)null);
        }
    }
}
