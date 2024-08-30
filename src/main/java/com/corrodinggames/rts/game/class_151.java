package com.corrodinggames.rts.game;

import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.d.class_447;
import com.corrodinggames.rts.game.units.custom.e.class_1069;
import com.corrodinggames.rts.game.units.buildings.class_73;
import com.corrodinggames.rts.game.units.buildings.class_8;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.game.s
public final strictfp class class_151 {
    public int a = 5;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public class_1069 h = new class_1069();
    public class_1069 i = new class_1069();
    public class_1069 j = new class_1069();
    public class_1069 k = new class_1069();
    public class_1069 l = new class_1069();
    public boolean m;
    public int n;
    public int o;
    public class_153 p = new class_153();
    public class_153 q = new class_153();

    public void a(Unit var1) {
        ++this.d;
        if (var1.cm < 1.0F) {
            ++this.f;
        } else {
            ++this.c;
        }

        class_31 var2 = var1.r();
        if (!var2.k()) {
            ++this.b;
        }

        if (!this.m && !var1.u() && var1.r().y()) {
            this.m = true;
        }

        class_447 var3 = var1.dq();
        if (var3 != null) {
            this.k.a(var3, 0.0, Double.MAX_VALUE);
            this.l.a(var3, -1.7976931348623157E308, 0.0);
        }

        if (var1 instanceof class_8) {
            class_8 var4 = (class_8)var1;
            int var5 = var4.f(false);
            this.b += var5;
            this.e += var5;
            if (var5 != 0) {
                this.a(var4);
            }
        }

        this.c(var1);
        float var8 = var1.cy();
        if (var8 != 0.0F && var1.cm >= 1.0F) {
            this.g = (int)((float)this.g + var8);
        }

        class_1069 var9 = var1.cA();
        if (!var9.c() && var1.cm >= 1.0F) {
            this.h.b(var9);
            this.i.a(var9, 0.0, Double.MAX_VALUE);
            this.j.a(var9, -1.7976931348623157E308, 0.0);
        }

        if (var1.cU()) {
            int var6 = var1.cM().b();
            class_447 var7 = var2.B();
            if (var7 != null) {
                var6 += var7.b();
            }

            if (var2.j()) {
                this.o += var6;
            } else {
                this.n += var6;
            }
        }

    }

    public void b(Unit var1) {
        --this.d;
        if (var1.cm < 1.0F) {
            --this.f;
        } else {
            --this.c;
        }

        class_31 var2 = var1.r();
        if (!var2.k()) {
            --this.b;
        }

        class_447 var3 = var1.dq();
        if (var3 != null) {
            this.k.b(var3, 0.0, Double.MAX_VALUE);
            this.l.b(var3, -1.7976931348623157E308, 0.0);
        }

        if (var1 instanceof class_8) {
            class_8 var4 = (class_8)var1;
            int var5 = var4.f(false);
            this.b -= var5;
            this.e -= var5;
            if (var5 != 0) {
                this.b(var4);
            }
        }

        this.d(var1);
        float var8 = var1.cy();
        if (var8 != 0.0F && var1.cm >= 1.0F) {
            this.g = (int)((float)this.g - var8);
        }

        class_1069 var9 = var1.cA();
        if (!var9.c() && var1.cm >= 1.0F) {
            this.h.c(var9);
            this.i.b(var9, 0.0, Double.MAX_VALUE);
            this.j.b(var9, -1.7976931348623157E308, 0.0);
        }

        if (var1.cU()) {
            int var6 = var1.cM().b();
            class_447 var7 = var2.B();
            if (var7 != null) {
                var6 += var7.b();
            }

            if (var2.j()) {
                this.o -= var6;
            } else {
                this.n -= var6;
            }
        }

    }

    private final void c(Unit var1) {
        class_588 var2 = var1.de();
        if (var2 != null) {
            class_585[] var3 = var2.a;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_585 var6 = var3[var5];
                class_150 var7 = this.a(var6);
                if (var1.cm < 1.0F) {
                    ++var7.c;
                } else {
                    ++var7.b;
                }
            }
        }

    }

    private final void d(Unit var1) {
        class_588 var2 = var1.de();
        if (var2 != null) {
            class_585[] var3 = var2.a;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                class_585 var6 = var3[var5];
                class_150 var7 = this.a(var6);
                if (var1.cm < 1.0F) {
                    --var7.c;
                } else {
                    --var7.b;
                }
            }
        }

    }

    private final void a(class_8 var1) {
        class_684 var2 = var1.dx();
        if (var2.a != 0) {
            Iterator var3 = var2.iterator();

            while(true) {
                class_73 var4;
                class_588 var6;
                do {
                    class_31 var5;
                    do {
                        do {
                            if (!var3.hasNext()) {
                                return;
                            }

                            var4 = (class_73)var3.next();
                        } while(!var4.f);

                        var5 = var4.g;
                    } while(var5 == null);

                    var6 = var5.x();
                } while(var6 == null);

                class_585[] var7 = var6.a;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    class_585 var10 = var7[var9];
                    class_150 var11 = this.a(var10);
                    var11.d += var4.a;
                }
            }
        }
    }

    private final void b(class_8 var1) {
        class_684 var2 = var1.dx();
        if (var2.a != 0) {
            Iterator var3 = var2.iterator();

            while(true) {
                class_73 var4;
                class_588 var6;
                do {
                    class_31 var5;
                    do {
                        do {
                            if (!var3.hasNext()) {
                                return;
                            }

                            var4 = (class_73)var3.next();
                        } while(!var4.f);

                        var5 = var4.g;
                    } while(var5 == null);

                    var6 = var5.x();
                } while(var6 == null);

                class_585[] var7 = var6.a;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    class_585 var10 = var7[var9];
                    class_150 var11 = this.a(var10);
                    var11.d -= var4.a;
                }
            }
        }
    }

    public final class_150 a(class_585 var1) {
        class_150[] var2 = this.q.b;
        int var3 = 0;

        for(int var4 = this.q.c; var3 < var4; ++var3) {
            class_150 var5 = var2[var3];
            if (var5.a == var1) {
                return var5;
            }

            if (var5.a == null) {
                var5.a = var1;
                return var5;
            }
        }

        class_150 var6 = new class_150();
        var6.a = var1;
        this.q.a(var6);
        return var6;
    }
}
