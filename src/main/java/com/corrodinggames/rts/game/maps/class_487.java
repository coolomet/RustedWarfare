package com.corrodinggames.rts.game.maps;

import android.graphics.RectF;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.custom.class_388;
import com.corrodinggames.rts.game.units.custom.class_389;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.GameObject;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import com.corrodinggames.rts.gameFramework.utility.class_691;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;

import lombok.SneakyThrows;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// $FF: renamed from: com.corrodinggames.rts.game.maps.a
// MapTrigger?
public strictfp class class_487 {
    public int a;
    public String name;
    public String c;
    public String type;
    public float x;
    public float y;
    public float width;
    public float height;
    public float rotation;
    private String p;
    public RectF j;
    public int gid = -1;
    public TileSet l;
    public int m = -1;
    public Properties n;
    public class_684 o = new class_684();

    @SneakyThrows
    static float a(Element var0, String var1) {
        String var2 = var0.getAttribute(var1);

        try {
            return Float.parseFloat(var2);
        } catch (NumberFormatException var4) {
            throw new MapException("Invalid map: Error reading '" + var1 + "' invalid float: " + var2, var4);
        }
    }

    @SneakyThrows
    public class_487(Element var1, class_484 var2, ObjectGroup var3) {
        this.name = var1.getAttribute("name");
        if (this.name != null) {
            this.c = this.name.trim().toLowerCase(Locale.ENGLISH);
        }

        this.type = var1.getAttribute("type");
        this.x = Float.parseFloat(var1.getAttribute("x"));
        this.y = Float.parseFloat(var1.getAttribute("y"));
        if (var1.hasAttribute("rotation")) {
            this.rotation = Float.parseFloat(var1.getAttribute("rotation")) - 90.0F;
        }

        if (!var1.getAttribute("width").equals("")) {
            this.width = a(var1, "width");
        }

        if (!var1.getAttribute("height").equals("")) {
            this.height = a(var1, "height");
        }

        Element var4 = (Element)var1.getElementsByTagName("image").item(0);
        if (var4 != null) {
            this.p = var4.getAttribute("source");
        }

        Element var5 = (Element)var1.getElementsByTagName("properties").item(0);
        String var9;
        String var10;
        if (var5 != null) {
            NodeList var6 = var5.getElementsByTagName("property");
            if (var6 != null) {
                this.n = new Properties();

                for(int var7 = 0; var7 < var6.getLength(); ++var7) {
                    Element var8 = (Element)var6.item(var7);
                    var9 = var8.getAttribute("name");
                    var10 = "";
                    if (var8.hasAttribute("value")) {
                        var10 = var8.getAttribute("value");
                    } else {
                        var10 = var8.getTextContent();
                    }

                    this.n.setProperty(var9, var10);
                }
            }
        }

        if (var1.hasAttribute("gid")) {
            this.gid = Integer.parseInt(var1.getAttribute("gid"));
            this.l = var2.a(this.gid);
            if (this.l == null) {
                throw new RuntimeException("Unable to decode base 64 block, could not find tileId:" + this.gid);
            }

            this.l.p = true;
            this.l.r = true;
            this.m = this.gid - this.l.l;
        }

        Properties var18 = this.n;
        this.j = new RectF(this.x, this.y, this.x + this.width, this.y + this.height);
        var2.a(this.j);
        this.x = this.j.a;
        this.y = this.j.b;
        this.width = this.j.b();
        this.height = this.j.c();
        float var19 = this.j.d();
        float var20 = this.j.e();
        var9 = var1.getAttribute("type");
        if (var9 != null && !var9.equals("") && !var9.equals("unit") && !var9.equals("comment") && !var3.b.equalsIgnoreCase("triggers")) {
            this.d("Triggers should be on triggers layer");
        }

        if (var18 != null) {
            var10 = var18.getProperty("unit");
            String var11 = var18.getProperty("customUnit");
            if (var10 != null || var11 != null) {
                String var12 = var18.getProperty("team");
                PlayerData var13 = null;
                if (var12 == null) {
                    throw new MapException("Unit object team missing for:" + (var10 != null ? var10 : var11));
                }

                if ("none".equalsIgnoreCase(var12)) {
                    var13 = PlayerData.getPlayerData(-1);
                } else {
                    int var14;
                    try {
                        var14 = Integer.valueOf(var12);
                    } catch (NumberFormatException var17) {
                        throw new MapException("Unit object team invalid: " + var17.getMessage(), var17);
                    }

                    var13 = PlayerData.getPlayerData(var14);
                    if (var13 == null) {
                        GameEngine.b("map", "Unit object without team:" + var10 + " (skipping unit)");
                        return;
                    }

                    if (var13.b()) {
                        GameEngine.b("map", "Unit team is marked as spectator:" + var10 + " (skipping unit)");
                        return;
                    }
                }

                Object var21;
                if (var11 != null) {
                    class_591 var15 = class_591.n(var11);
                    if (var15 == null) {
                        throw new MapException("Could not find custom unit of:" + var11 + " at x:" + this.x + ", y:" + this.y);
                    }

                    class_31 var16 = class_591.c((class_31)var15);
                    if (var16 != null) {
                        if (var16 instanceof class_591) {
                            var15 = (class_591)var16;
                        } else {
                            GameEngine.print("replacement not a custom unit:" + var16.i());
                        }
                    }

                    var21 = class_591.a(false, var15);
                    if (var21 == null) {
                        throw new RuntimeException("Metadata unit is null for:" + var11);
                    }
                } else {
                    var21 = null;
                    class_31 var22 = UnitType.a(var10);
                    if (var22 == null) {
                        throw new MapException("Could not find unit type of:" + var10 + " at x:" + this.x + ", y:" + this.y);
                    }

                    var21 = var22.a();
                }

                ((Unit)var21).xCord = var19;
                ((Unit)var21).yCord = var20;
                if (!((Unit)var21).bI()) {
                    ((Unit)var21).h(this.rotation);
                }

                if (var13 == null) {
                    throw new MapException("team is null:" + var10);
                }

                ((Unit)var21).b(var13);
                if (var18.getProperty("type") != null) {
                    ((Unit)var21).a_(var18.getProperty("type"));
                }

                if (var18.getProperty("randomRotate") != null && !((Unit)var21).bI()) {
                    ((Unit)var21).h((float)class_340.a((Unit)var21, -180, 180));
                }

                ((Unit)var21).bO = "builder".equalsIgnoreCase(var10) || "builder".equalsIgnoreCase(var11);
                ((Unit)var21).bP = "commandCenter".equalsIgnoreCase(var10) || "commandCenter".equalsIgnoreCase(var11);
                ((Unit)var21).bM = true;
                ((Unit)var21).n();
                PlayerData.c((Unit)var21);
                GameObject.dL();
            }
        }

    }

    public boolean a(Unit var1) {
        return this.j.b((float)((int)var1.xCord), (float)((int)var1.yCord));
    }

    public void a(String var1) {
        if (!this.o.contains(var1)) {
            this.o.add(var1);
        }

    }

    public String[] a() {
        if (this.n == null) {
            return class_691.h;
        } else {
            class_684 var1 = new class_684();
            Enumeration var2 = this.n.propertyNames();

            while(var2.hasMoreElements()) {
                String var3 = (String)var2.nextElement();
                if (!this.o.contains(var3)) {
                    var1.add(var3);
                }
            }

            return (String[])var1.toArray(class_691.h);
        }
    }

    public String b(String var1) {
        this.a(var1);
        return this.n == null ? null : this.n.getProperty(var1);
    }

    public String a(String var1, String var2) {
        this.a(var1);
        return this.n == null ? null : this.n.getProperty(var1, var2);
    }

    @SneakyThrows
    public Integer c(String var1) {
        String var2 = this.a((String)var1, (String)null);
        if (var2 == null) {
            return null;
        } else {
            try {
                return Integer.parseInt(var2);
            } catch (NumberFormatException var4) {
                throw new MapException(var1 + ": Unexpected integer value:'" + var2 + "'");
            }
        }
    }

    public class_388 createLocaleStringFromProperty(String var1, class_388 var2) {
        String var3 = this.a((String)var1, (String)null);
        if (var3 == null) {
            return var2;
        } else {
            ArrayList var4 = new ArrayList();
            class_389 var5 = new class_389((String)null, var3);
            var4.add(var5);
            String var6 = var1 + "_";
            class_684 var7 = new class_684();
            Iterator var8 = this.n.keySet().iterator();

            String var10;
            while(var8.hasNext()) {
                Object var9 = var8.next();
                if (var9 instanceof String) {
                    var10 = (String)var9;
                    if (var10.startsWith(var6)) {
                        var7.add(var10);
                    }
                } else {
                    GameEngine.print("createLocaleStringFromProperty: Non string:" + var9);
                }
            }

            var8 = var7.iterator();

            while(var8.hasNext()) {
                String var14 = (String)var8.next();
                var10 = var14.substring(var6.length());
                var10 = var10.toLowerCase(Locale.ROOT);
                GameEngine.print("createLocaleStringFromProperty checking: " + var14);
                if (var10.length() <= 4) {
                    String var11 = this.b(var14);
                    GameEngine.print("createLocaleStringFromProperty got: " + var11);
                    GameEngine.print("createLocaleStringFromProperty code: " + var10);
                    class_389 var12 = new class_389(var10, var11);
                    var4.add(var12);
                }
            }

            class_389[] var13 = (class_389[])var4.toArray(new class_389[0]);
            class_388 var15 = new class_388(var13);
            var15.b();
            GameEngine.print("createLocaleStringFromProperty final: " + var15.b());
            GameEngine.print("createLocaleStringFromProperty locate: " + class_1009.c());
            return var15;
        }
    }

    public void d(String var1) {
        GameNetEngine.g("(Map trigger: " + this.name + ", type:" + this.type + "): " + var1);
    }

    public String b() {
        return "(Map trigger: " + this.name + ", type:" + this.type + ")";
    }
}
