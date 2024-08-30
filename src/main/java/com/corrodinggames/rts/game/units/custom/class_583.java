package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.units.custom.b.class_928;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_684;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.e
public final strictfp class class_583 {
    public class_586 a;
    float b;
    float c;
    float d = 1.0F;
    boolean e = false;
    boolean f = false;
    boolean g;
    boolean h;
    boolean i;
    int j;
    float k = 0.0F;
    float l = 0.05F;
    class_113 m;
    float[] n;

    public class_583(class_113 var1) {
        this.m = var1;
    }

    public strictfp void a(class_586 var1, int var2) {
        this.a(var1, var2, false);
    }

    public strictfp void a(class_586 var1, int var2, boolean var3) {
        if (var1 != null && var1.a()) {
            if (!this.i && (!this.f || !this.e) || var2 > this.j || var3 && var1 == this.a) {
                this.i = true;
                if (var1 != this.a || var3 || this.g) {
                    float var4 = 0.0F;
                    if (this.a != null && this.e) {
                        var4 = this.a.i;
                    }

                    this.a = var1;
                    this.j = var2;
                    this.c();
                    this.f = var3;
                    if (var3) {
                        this.h = false;
                    } else {
                        this.h = true;
                    }

                    this.b = -1.0F;
                    this.c = -1.0F;
                    this.d = 1.0F;
                    this.g = false;
                    float var5 = var1.h;
                    if (var4 > var5) {
                        var5 = var4;
                    }

                    if (var5 > 0.0F) {
                        this.k = 1.0F;
                        this.l = var5;
                    } else {
                        this.k = 0.0F;
                    }
                }

                this.e = true;
            }
        }
    }

    public strictfp void a() {
        if (this.a != null) {
            boolean var1 = true;
            this.b(var1);
        }

        this.e = false;
        this.a = null;
        this.j = -1;
    }

    public strictfp void b() {
        if (this.a != null) {
            if (!this.g) {
                float var1 = this.a.i;
                if (var1 > 0.0F) {
                    this.g = true;
                    this.c();
                    this.h = false;
                    this.j = -1;
                    this.k = 1.0F;
                    this.l = var1;
                    return;
                }
            }

            boolean var2 = true;
            this.b(var2);
        }

        this.e = false;
        this.a = null;
        this.j = -1;
    }

    public strictfp void a(float var1) {
        if (this.e) {
            this.c = this.b;
            if (this.b < 0.0F) {
                this.b = 0.0F;
            }

            float var2 = this.d;
            if (this.a != null && this.a.j != null) {
                var2 *= this.a.j.readNumber(this.m);
            }

            this.b += var2 * var1;
            if (this.h && !this.i) {
                this.b();
            }

            this.i = false;
            if (this.e) {
                if (this.k > 0.0F) {
                    this.k -= this.l * var1;
                } else if (this.g) {
                    this.b();
                    return;
                }

                if (!this.g && this.a != null) {
                    if (this.a.g) {
                        if (this.b > this.a.n) {
                            this.a(false);
                            this.b = this.a.n;
                            this.d = -1.0F;
                        } else if (this.b < 0.0F) {
                            this.b = 0.0F;
                            this.d = 1.0F;
                            if (this.f) {
                                this.b();
                                if (!this.g) {
                                    return;
                                }
                            }
                        }
                    } else {
                        if (this.b > this.a.n) {
                            if (this.f) {
                                this.a(false);
                                this.b();
                                if (!this.g) {
                                    return;
                                }
                            } else {
                                this.a(false);
                                this.b = 0.0F;
                                this.d = 1.0F;
                            }
                        }

                        if (this.b < 0.0F && !this.f && var2 < 0.0F) {
                            this.b = this.a.n;
                        }
                    }
                }

                boolean var3 = false;
                if (this.g) {
                    var3 = true;
                }

                this.b(var3);
            }

        }
    }

    strictfp void c() {
        class_684 var1 = this.a.l;
        if (this.n == null || this.n.length < var1.size()) {
            this.n = new float[var1.size()];
        }

        for(int var2 = 0; var2 < var1.size(); ++var2) {
            class_581 var3 = (class_581)var1.get(var2);
            class_584 var4 = var3.a;
            if (var4 == class_584.SCALE) {
                this.n[var2] = this.m.c;
            } else if (var4 == class_584.FRAME) {
                this.n[var2] = -99.0F;
            } else {
                class_928 var5;
                if (var4 == class_584.LEG_X) {
                    if (this.m.dT != null && var3.b < this.m.dT.length) {
                        var5 = this.m.dT[var3.b];
                        this.n[var2] = var5.p;
                    } else {
                        this.n[var2] = 0.0F;
                        GameEngine.print("setBaseBlendValues: Target leg out of range for: " + this.m.dt().i());
                    }
                } else if (var4 == class_584.LEG_Y) {
                    if (this.m.dT != null && var3.b < this.m.dT.length) {
                        var5 = this.m.dT[var3.b];
                        this.n[var2] = var5.q;
                    }
                } else if (var4 == class_584.LEG_DIR) {
                    if (this.m.dT != null && var3.b < this.m.dT.length) {
                        this.m.dT[var3.b].r = class_340.a(this.m.dT[var3.b].r, false);
                        this.n[var2] = this.m.dT[var3.b].r;
                    }
                } else if (var4 == class_584.LEG_HEIGHT) {
                    if (this.m.dT != null && var3.b < this.m.dT.length) {
                        this.n[var2] = this.m.dT[var3.b].d;
                    }
                } else if (var4 == class_584.LEG_ALPHA) {
                    if (this.m.dT != null && var3.b < this.m.dT.length) {
                        this.n[var2] = this.m.dT[var3.b].s;
                    }
                } else if (var4 != class_584.EVENT) {
                    this.n[var2] = 0.0F;
                    GameEngine.print("Unsupported blend type:" + var4);
                }
            }
        }

    }

    strictfp void a(boolean var1) {
        class_684 var2 = this.a.l;

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            class_581 var4 = (class_581)var2.get(var3);
            class_584 var5 = var4.a;
            if (var5 == class_584.EVENT) {
                var4.a(this.m, this.c, this.b, var1);
            }
        }

    }

    strictfp void b(boolean var1) {
        class_684 var2 = this.a.l;

        for(int var3 = 0; var3 < var2.size(); ++var3) {
            class_581 var4 = (class_581)var2.get(var3);
            class_584 var5 = var4.a;
            if (var5 != class_584.FRAME || this.m.el || var1) {
                float var6;
                if (var1) {
                    var6 = 0.0F;
                    if (var5 == class_584.SCALE) {
                        var6 = 1.0F;
                    } else if (var5 == class_584.FRAME) {
                        var6 = (float)this.m.x.Y;
                    } else if (var5 == class_584.LEG_ALPHA) {
                        var6 = 1.0F;
                        class_431[] var7 = this.m.x.ax;
                        if (var7 != null && var4.b < var7.length) {
                            var6 = var7[var4.b].r;
                        }
                    }
                } else {
                    var6 = var4.b(this.b);
                }

                if (this.k > 0.0F && var5 != class_584.FRAME) {
                    var6 = var6 * (1.0F - this.k) + this.n[var3] * this.k;
                }

                if (var5 == class_584.FRAME) {
                    this.m.a = (int)var6;
                } else if (var5 == class_584.SCALE) {
                    this.m.c = var6;
                } else {
                    class_928 var8;
                    if (var5 == class_584.LEG_X) {
                        if (this.m.dT != null && var4.b < this.m.dT.length) {
                            var8 = this.m.dT[var4.b];
                            var8.p = var6;
                            var8.k = true;
                            var8.o = true;
                        }
                    } else if (var5 == class_584.LEG_Y) {
                        if (this.m.dT != null && var4.b < this.m.dT.length) {
                            var8 = this.m.dT[var4.b];
                            var8.q = var6;
                            var8.k = true;
                            var8.o = true;
                        }
                    } else if (var5 == class_584.LEG_DIR) {
                        if (this.m.dT != null && var4.b < this.m.dT.length) {
                            this.m.dT[var4.b].r = var6;
                        }
                    } else if (var5 == class_584.LEG_HEIGHT) {
                        if (this.m.dT != null && var4.b < this.m.dT.length) {
                            this.m.dT[var4.b].d = var6;
                        }
                    } else if (var5 == class_584.LEG_ALPHA) {
                        class_928[] var9 = this.m.dT;
                        if (var9 != null && var4.b < var9.length) {
                            var9[var4.b].s = var6;
                        }
                    } else if (var5 != class_584.TURRET_X && var5 == class_584.EVENT) {
                        var4.a(this.m, this.c, this.b, var1);
                    }
                }
            }
        }

    }

    public strictfp boolean a(class_586 var1) {
        return this.e && this.a == var1;
    }
}
