package com.corrodinggames.rts.debug.test;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.corrodinggames.rts.a.a.class_650;
import com.corrodinggames.rts.a.a.class_651;
import com.corrodinggames.rts.a.a.class_652;
import com.corrodinggames.rts.a.a.class_653;
import com.corrodinggames.rts.a.a.class_654;
import com.corrodinggames.rts.game.units.MovementType;
import com.corrodinggames.rts.game.units.class_1050;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_587;
import com.corrodinggames.rts.game.units.custom.class_588;
import com.corrodinggames.rts.game.units.custom.e.GroupingStyle;
import com.corrodinggames.rts.game.units.custom.e.BuiltInResource;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;
import java.util.Random;

public strictfp class TestMiscPerformance extends AbstractScriptTest {
    int a = 1;
    int b;
    final Rect c = new Rect();
    final PointF d = new PointF();
    static final Point e = new Point();

    public void a() {
        GameEngine.log("Misc Performance test");
        int var1 = 5;
        int var2 = 0;
        GameEngine.log("=== applyDigitGroupingStyle tests (runs:" + var1 + ")");
        Long var3 = Unit.loadAllUnitsTook();

        int var4;
        int var5;
        for(var4 = 0; var4 < var1; ++var4) {
            for(var5 = 0; var5 < 100; ++var5) {
                if (!BuiltInResource.a(var5 + "9870000001.67", GroupingStyle.COMMA).equals("")) {
                    ++var2;
                }
            }
        }

        Long var18 = Unit.loadAllUnitsTook();
        double var22 = Unit.a(var3, var18);
        this.a += var2;
        GameEngine.log("Took: " + var22);
        var1 = 5;
        var2 = 0;
        GameEngine.log("=== applyDigitGroupingStyle_systemLibraryVersion tests (runs:" + var1 + ")");
        var3 = Unit.loadAllUnitsTook();

        for(var4 = 0; var4 < var1; ++var4) {
            for(var5 = 0; var5 < 100; ++var5) {
                if (!BuiltInResource.a((long)var5 + 9870000001L, GroupingStyle.COMMA).equals("")) {
                    ++var2;
                }
            }
        }

        var18 = Unit.loadAllUnitsTook();
        var22 = Unit.a(var3, var18);
        this.a += var2;
        GameEngine.log("Took: " + var22);
        var1 = 3;
        var2 = 0;
        GameEngine.log("=== isLineClear tests (runs:" + var1 + ")");
        var3 = Unit.loadAllUnitsTook();

        int var6;
        int var7;
        int var8;
        int var9;
        int var10;
        int var11;
        for(var4 = 0; var4 < var1; ++var4) {
            for(var5 = 0; var5 < 100; ++var5) {
                var6 = 1000 - var5;
                var7 = 50;
                var8 = 50;
                var9 = 1;
                var10 = 1000;
                var11 = 1;
                if (class_1050.b(MovementType.LAND, (float)var5, (float)var6, (float)var7, (float)var8, var10, var11, var9)) {
                    ++var2;
                }
            }
        }

        var18 = Unit.loadAllUnitsTook();
        var22 = Unit.a(var3, var18);
        this.a += var2;
        GameEngine.log("Took: " + var22);
        var1 = 3;
        var2 = 0;
        GameEngine.log("=== maths tests == (runs:" + var1 + ")");
        var3 = Unit.loadAllUnitsTook();
        byte var23 = 0;

        for(var5 = 0; var5 < var1; ++var5) {
            for(var6 = 0; var6 < 1000; ++var6) {
                Point var26 = e;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                var26.a += var6;
                ++this.b;
                var2 += var23;
            }
        }

        Long var31 = Unit.loadAllUnitsTook();
        double var24 = Unit.a(var3, var31);
        this.a += var2;
        GameEngine.log("Took: " + var24);
        var1 = 14;
        byte var19 = 5;
        int var17 = 0;
        class_684 var25 = new class_684();
        var5 = 0;

        for(var6 = 0; var6 < 20000; ++var6) {
            class_587 var27 = new class_587();
            if (var6 % 10 != 0) {
                var27.a(class_585.c("test"));
                var27.a(class_585.c("test1"));
            }

            if (var6 % 2 == 0) {
                var27.a(class_585.c("test2"));
                ++var5;
            }

            if (var6 % 3 == 0) {
                var27.a(class_585.c("test3"));
            }

            if (var6 % 4 == 0) {
                var27.a(class_585.c("test4"));
            }

            if (var6 % 5 == 0) {
                var25.add((Object)null);
            }

            var25.add(var27.a());
        }

        class_588 var28 = class_585.a("test2");
        GameEngine.log("=== CustomTagList tests == (runs:" + var19 + ")");

        for(var7 = 0; var7 < var1; ++var7) {
            Long var29 = Unit.loadAllUnitsTook();

            for(var9 = 0; var9 < var19; ++var9) {
                var10 = 0;
                Iterator var39 = var25.iterator();

                while(var39.hasNext()) {
                    class_588 var12 = (class_588)var39.next();
                    if (class_585.a(var28, var12)) {
                        ++var10;
                    }
                }

                class_650.a(var5, var10);
            }

            GameEngine.log("test2Expected:" + var5);
            Long var35 = Unit.loadAllUnitsTook();
            double var37 = Unit.a(var29, var35);
            this.a += var17;
            GameEngine.log("Took: " + var37);
        }

        var1 = 5000000;
        float var20 = 0.5F;

        Random var32;
        byte var33;
        Long var42;
        int var43;
        for(var17 = 0; var17 < 2; ++var17) {
            var23 = 5;
            var33 = 5;
            byte var30 = 0;
            GameEngine.log("=== [Write]/comparison tests == (runs:" + var33 + ")");

            class_653 var13;
            class_653[] var36;
            Long var41;
            double var45;
            for(var7 = 0; var7 < var23; ++var7) {
                var32 = new Random();
                var36 = new class_653[var1];

                for(var10 = 0; var10 < var36.length; ++var10) {
                    var36[var10] = new class_653();
                    var36[var10].d = var32.nextFloat() < var20;
                }

                var41 = Unit.loadAllUnitsTook();

                for(var11 = 0; var11 < var33; ++var11) {
                    for(var43 = 0; var43 < var36.length; ++var43) {
                        var13 = var36[var43];
                        var13.d = false;
                    }
                }

                var42 = Unit.loadAllUnitsTook();
                var45 = Unit.a(var41, var42);
                this.a += var30;
                GameEngine.log("Took: " + var45);
            }

            var23 = 5;
            var33 = 5;
            var30 = 0;
            GameEngine.log("=== Write/[comparison] tests == (runs:" + var33 + ")");

            for(var7 = 0; var7 < var23; ++var7) {
                var32 = new Random();
                var36 = new class_653[var1];

                for(var10 = 0; var10 < var36.length; ++var10) {
                    var36[var10] = new class_653();
                    var36[var10].d = var32.nextFloat() < var20;
                }

                var41 = Unit.loadAllUnitsTook();

                for(var11 = 0; var11 < var33; ++var11) {
                    for(var43 = 0; var43 < var36.length; ++var43) {
                        var13 = var36[var43];
                        if (var13.d) {
                            var13.d = false;
                        }
                    }
                }

                var42 = Unit.loadAllUnitsTook();
                var45 = Unit.a(var41, var42);
                this.a += var30;
                GameEngine.log("Took: " + var45);
            }
        }

        float var21 = 0.3F;
        var23 = 7;
        var33 = 5;
        var6 = 0;
        short var34 = 1000;
        GameEngine.log("=== [Virtual method]/if tests == (runs:" + var33 + ")");

        Random var38;
        int var51;
        boolean var52;
        double var53;
        Long var57;
        for(var8 = 0; var8 < var23; ++var8) {
            var38 = new Random();
            class_651[] var47 = new class_651[var34];

            for(var11 = 0; var11 < var47.length; ++var11) {
                var52 = var38.nextFloat() < var21;
                if (var52) {
                    class_652 var49 = new class_652(this);
                    var49.c = var38.nextInt(1000);
                    var47[var11] = var49;
                } else {
                    var47[var11] = new class_651(this);
                    var47[var11].a = var38.nextInt(1000);
                }
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var47.length; ++var51) {
                    if (var47[var51].a() == 0) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 7;
        var33 = 5;
        var6 = 0;
        var34 = 1000;
        GameEngine.log("=== Virtual method/[if tests] == (runs:" + var33 + ")");

        for(var8 = 0; var8 < var23; ++var8) {
            var38 = new Random();
            class_654[] var48 = new class_654[var34];

            for(var11 = 0; var11 < var48.length; ++var11) {
                var52 = var38.nextFloat() < var21;
                class_654 var56 = new class_654(this);
                var56.b = var38.nextInt(1000);
                var56.a = var38.nextInt(1000);
                var56.c = var52;
                var48[var11] = var56;
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var48.length; ++var51) {
                    if (var48[var51].a() == 0) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 14;
        var33 = 10;
        var6 = 0;
        GameEngine.log("=== comparison tests 1 == (runs:" + var33 + ")");

        int var14;
        int var15;
        short var40;
        short var50;
        double var55;
        Long var61;
        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var40 = 600;
            var50 = 600;
            float[] var59 = new float[var40 * var40];

            for(var43 = 0; var43 < var40; ++var43) {
                for(var51 = 0; var51 < var50; ++var51) {
                    var59[var43 * var50 + var51] = var32.nextFloat();
                }
            }

            var57 = Unit.loadAllUnitsTook();

            for(var51 = 0; var51 < var33; ++var51) {
                for(var14 = 0; var14 < var40; ++var14) {
                    for(var15 = 0; var15 < var50; ++var15) {
                        int var16 = var14 * var50 + var15;
                        var6 = (int)((float)var6 + var59[var16]);
                    }
                }
            }

            var61 = Unit.loadAllUnitsTook();
            var55 = Unit.a(var57, var61);
            this.a += var6;
            GameEngine.log("Took: " + var55);
        }

        var23 = 14;
        var33 = 10;
        var6 = 0;
        GameEngine.log("=== comparison tests 2 == (runs:" + var33 + ")");

        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var40 = 600;
            var50 = 600;
            float[][] var60 = new float[var40][var40];

            for(var43 = 0; var43 < var40; ++var43) {
                for(var51 = 0; var51 < var50; ++var51) {
                    var60[var43][var51] = var32.nextFloat();
                }
            }

            var57 = Unit.loadAllUnitsTook();

            for(var51 = 0; var51 < var33; ++var51) {
                for(var14 = 0; var14 < var40; ++var14) {
                    for(var15 = 0; var15 < var50; ++var15) {
                        var6 = (int)((float)var6 + var60[var14][var15]);
                    }
                }
            }

            var61 = Unit.loadAllUnitsTook();
            var55 = Unit.a(var57, var61);
            this.a += var6;
            GameEngine.log("Took: " + var55);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== [divide]/multiply float tests == (runs:" + var33 + ")");

        float[] var44;
        float[] var54;
        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var44 = new float[var1];
            var54 = new float[var1];

            for(var11 = 0; var11 < var44.length; ++var11) {
                var44[var11] = var32.nextFloat();
                var54[var11] = var32.nextFloat();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var44.length; ++var51) {
                    if (var44[var51] / var54[var51] == 0.0F) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== divide/[multiply] float tests == (runs:" + var33 + ")");

        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var44 = new float[var1];
            var54 = new float[var1];

            for(var11 = 0; var11 < var44.length; ++var11) {
                var44[var11] = var32.nextFloat();
                var54[var11] = var32.nextFloat();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var44.length; ++var51) {
                    if (var44[var51] * var54[var51] == 0.0F) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== [divide]/multiply int tests == (runs:" + var33 + ")");

        int[] var46;
        int[] var58;
        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var46 = new int[var1];
            var58 = new int[var1];

            for(var11 = 0; var11 < var46.length; ++var11) {
                var46[var11] = var32.nextInt();
                var58[var11] = var32.nextInt();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var46.length; ++var51) {
                    if (var46[var51] / var58[var51] == 0) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== [float cast and divide]/multiply int tests == (runs:" + var33 + ")");

        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var46 = new int[var1];
            var58 = new int[var1];

            for(var11 = 0; var11 < var46.length; ++var11) {
                var46[var11] = var32.nextInt();
                var58[var11] = var32.nextInt();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var46.length; ++var51) {
                    if ((float)var46[var51] / (float)var58[var51] == 0.0F) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== [mixed float and divide]/multiply int tests == (runs:" + var33 + ")");

        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var46 = new int[var1];
            var54 = new float[var1];

            for(var11 = 0; var11 < var46.length; ++var11) {
                var46[var11] = var32.nextInt();
                var54[var11] = var32.nextFloat();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var46.length; ++var51) {
                    if ((float)var46[var51] / var54[var51] == 0.0F) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

        var23 = 5;
        var33 = 5;
        var6 = 0;
        GameEngine.log("=== divide/[multiply] int tests == (runs:" + var33 + ")");

        for(var7 = 0; var7 < var23; ++var7) {
            var32 = new Random();
            var46 = new int[var1];
            var58 = new int[var1];

            for(var11 = 0; var11 < var46.length; ++var11) {
                var46[var11] = var32.nextInt();
                var58[var11] = var32.nextInt();
            }

            var42 = Unit.loadAllUnitsTook();

            for(var43 = 0; var43 < var33; ++var43) {
                for(var51 = 0; var51 < var46.length; ++var51) {
                    if (var46[var51] * var58[var51] == 0) {
                        ++var6;
                    }
                }
            }

            var57 = Unit.loadAllUnitsTook();
            var53 = Unit.a(var42, var57);
            this.a += var6;
            GameEngine.log("Took: " + var53);
        }

    }
}
