package com.corrodinggames.rts.game.maps;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.sea.MissileShip;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.m.class_28;
import lombok.SneakyThrows;

import java.util.Properties;

// $FF: renamed from: com.corrodinggames.rts.game.maps.g
public final strictfp class class_482 {
    public TileSet a;
    public int b;
    public int c = -2;
    public short d = -1;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public byte j;
    public boolean k;
    public boolean l;
    public class_482[] m;
    static final Rect n = new Rect();

    public static strictfp boolean a(class_482 var0, class_482 var1) {
        if (var0 == var1) {
            return true;
        } else if (var0 == null) {
            return false;
        } else if (var1 == null) {
            return false;
        } else if (var0.a != var1.a) {
            return false;
        } else {
            return var0.b == var1.b;
        }
    }

    public strictfp class_482 a() {
        class_482 var1 = new class_482();
        var1.a = this.a;
        var1.b = this.b;
        var1.e = this.e;
        var1.f = this.f;
        var1.g = this.g;
        var1.h = this.h;
        var1.i = this.i;
        var1.j = this.j;
        var1.k = this.k;
        var1.l = this.l;
        return var1;
    }

    public static strictfp void a(String var0) {
        GameEngine.print(var0);
        GameEngine.getGameEngine().log("Missing unit data while loading map: " + var0, 1);

        try {
            Thread.sleep(2L);
        } catch (InterruptedException var2) {
        }

    }

    @SneakyThrows
    public static strictfp class_482 a(class_484 var0, Layer var1, TileSet var2, int var3, short var4, short var5, boolean var6) {
        Properties var7 = var2.a(var2.l + var3);
        String var11;
        int var20;
        if (var7 != null) {
            String var8 = var7.getProperty("showFog");
            if (var8 != null) {
                var20 = Integer.parseInt(var8);
                GameEngine var23 = GameEngine.getGameEngine();
                var0.a(var4, var5);
                float var24 = (float)(var0.T + var0.p);
                float var26 = (float)(var0.U + var0.q);
                var23.bL.a(var24, var26, var20, var23.playerTeam, false);
                return null;
            }

            String var9 = var7.getProperty("unit");
            String var10 = var7.getProperty("customUnit");
            if (var9 != null || var10 != null) {
                var11 = var7.getProperty("team");
                PlayerData var25 = null;
                if ("none".equalsIgnoreCase(var11)) {
                    var25 = PlayerData.getPlayerData(-1);
                } else {
                    if (var11 == null) {
                        GameEngine.b("map", "warning: unit has no team property:" + var9 + " at: " + var4 + "," + var5);
                        return null;
                    }

                    var25 = PlayerData.getPlayerData(Integer.valueOf(var11));
                    if (var25 == null) {
                        GameEngine.b("map", "skipping unit without player:" + var9 + " at: " + var4 + "," + var5 + " team:" + var11);
                        return null;
                    }

                    if (var25.b()) {
                        GameEngine.b("map", "Unit team is marked as spectator:" + var9 + " (skipping unit)");
                        return null;
                    }
                }

                Object var13 = null;
                String var28;
                if (var10 != null) {
                    class_591 var14 = class_591.n(var10);
                    if (var14 == null) {
                        var28 = "Could not find custom unit of:" + var10 + " at x:" + var4 + ", y:" + var5;
                        a(var28);
                        throw new MapException(var28);
                    }

                    class_31 var15 = class_591.c((class_31)var14);
                    if (var15 != null) {
                        if (var15 instanceof class_591) {
                            var14 = (class_591)var15;
                        } else {
                            GameEngine.print("replacement not a custom unit:" + var15.i());
                        }
                    }

                    var13 = class_591.a(false, var14);
                    if (var13 == null) {
                        String var16 = "Metadata unit is null for:" + var10;
                        a(var16);
                        throw new MapException(var16);
                    }
                } else {
                    class_31 var27 = UnitType.a(var9);
                    if (var27 != null) {
                        var13 = var27.a();
                    }

                    if (var13 == null && "scoutShip".equalsIgnoreCase(var9)) {
                        var13 = new MissileShip(false);
                    }

                    if (var13 == null) {
                        var28 = "Could not find unit:" + var9 + " at: " + var4 + "," + var5;
                        a(var28);
                        throw new MapException(var28);
                    }
                }

                var0.a(var4, var5);
                ((Unit)var13).xCord = (float)var0.T + ((Unit)var13).cZ();
                ((Unit)var13).yCord = (float)var0.U + ((Unit)var13).da();
                if (var25 == null) {
                    throw new MapException("team has not been set for:" + var9);
                }

                ((Unit)var13).b(var25);
                if (var7.getProperty("type") != null) {
                    ((Unit)var13).a_(var7.getProperty("type"));
                }

                if (var7.getProperty("randomRotate") != null) {
                    ((Unit)var13).cg = (float)class_340.a((Unit)var13, -180, 180);
                }

                ((Unit)var13).bO = "builder".equalsIgnoreCase(var9) || "builder".equalsIgnoreCase(var10);
                ((Unit)var13).bP = "commandCenter".equalsIgnoreCase(var9) || "commandCenter".equalsIgnoreCase(var10);
                ((Unit)var13).bM = true;
                ((Unit)var13).n();
                PlayerData.c((Unit)var13);
                GameObject.dL();
                return null;
            }

            if (var1 != null && var1.l.equals("units")) {
                Log.d("RustedWarfare", "non unit on units layer at:" + var4 + "," + var5);
                return null;
            }
        }

        class_482 var19 = new class_482();
        var19.a = var2;
        var2.p = true;
        if (var1 != null && !var1.r) {
            var2.r = true;
        }

        if (var6) {
            var2.q = true;
        }

        var19.b = var3;
        if (var7 != null) {
            if (var7.getProperty("water") != null) {
                var19.e = true;
            }

            if (var7.getProperty("water-bridge") != null) {
                var19.f = true;
            }

            if (var7.getProperty("lava") != null || var7.getProperty("lava-cliff") != null) {
                var19.g = true;
                if (var7.getProperty("lava-cliff") != null) {
                    var19.h = true;
                }
            }

            if (var7.getProperty("cliff-soft") != null) {
                var19.h = true;
            }

            if (var7.getProperty("cliff") != null) {
                var19.h = true;
            }

            if (var7.getProperty("large-cliff") != null) {
                var19.k = true;
            }

            if (var7.getProperty("trees") != null) {
                var19.k = true;
            }

            if (var7.getProperty("res_pool") != null) {
                var19.i = true;
            }

            if (var7.getProperty("tree") != null) {
            }

            if (var7.getProperty("small-rock") != null) {
                var19.j = 40;
            }

            if (var7.getProperty("large-rock") != null) {
                var19.j = -1;
            }

            if (var7.getProperty("block-land") != null) {
                var19.j = -1;
            }

            if (var7.getProperty("block-buildings") != null) {
                var19.l = true;
            }
        }

        var20 = 0;
        int var21 = 0;
        if (var19.a != null) {
            var11 = var19.a.c;
            if (var11 != null) {
                if (var19.b == 0 && var11.equals("shallowwater.png")) {
                    var20 = 5;
                }

                if (var19.b == 0 && var11.equals("deepwater.png")) {
                    var20 = 2;
                }

                if (var19.b == 0 && var11.equals("water.png")) {
                    var20 = 2;
                }

                if (var19.b == 0 && var11.equals("longgrass.png")) {
                    var20 = 3;
                }

                if (var19.b == 0 && var11.equals("mountain.png")) {
                    var20 = 3;
                }

                if (var19.b == 7 && var11.equals("stone.png")) {
                    var20 = 4;
                    var21 = 23;
                }

                if (var19.b == 0 && var11.equals("lava.png")) {
                }

                if (var19.b == 0 && var11.equals("snow.png")) {
                    var20 = 2;
                }
            }
        }

        if (var7 != null && var7.getProperty("randomTileBy") != null) {
            try {
                var20 = Integer.parseInt(var7.getProperty("randomTileBy"));
            } catch (NumberFormatException var18) {
                throw new MapException("(x:" + var4 + "y:" + var5 + ") - randomTileBy: Unexpected integer value:'" + var7.getProperty("randomTileBy") + "'");
            }

            if (var7.getProperty("randomTileFixedOffset") != null) {
                try {
                    var21 = Integer.parseInt(var7.getProperty("randomTileFixedOffset"));
                } catch (NumberFormatException var17) {
                    throw new MapException("(x:" + var4 + "y:" + var5 + ") - randomTileFixedOffset: Unexpected integer value:'" + var7.getProperty("randomTileBy") + "'");
                }
            }
        }

        if (var20 > 0) {
            class_482[] var22 = new class_482[var20];

            for(int var12 = 0; var12 < var20; ++var12) {
                var22[var12] = var19.a();
                var22[var12].b += var12 + 1 + var21;
            }

            var19.m = var22;
        }

        return var19;
    }

    class_482() {
    }

    public strictfp void a(class_28 var1, RectF var2, float var3, Paint var4) {
        TileSet var5 = this.a;
        Rect var6 = var5.b(this.b);
        var1.a(var5.b, var6, var2, var4);
    }

    // $FF: synthetic method
    public Object clone() {
        return this.a();
    }
}
