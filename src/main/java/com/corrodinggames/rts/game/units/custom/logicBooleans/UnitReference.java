package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.DummyNonUnitWithTeam;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.class_601;
import com.corrodinggames.rts.gameFramework.utility.UnitConfig;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract strictfp class UnitReference extends LogicBoolean implements Cloneable {
    public static final UnitReference$SelfUnitReference selfUnitReference = new UnitReference$SelfUnitReference();
    static HashMap referenceTypes = new HashMap();
    static final LogicBooleanLoader$LogicBooleanContext unitContextChangingContext;
    static final LogicBooleanLoader$LogicBooleanContext placeholderUnitContext;

    public final Unit get(Unit var1) {
        return !(var1 instanceof OrderableUnit) ? null : this.getSingleRaw((OrderableUnit)var1);
    }

    public final Unit get(OrderableUnit var1) {
        return this.getSingleRaw(var1);
    }

    public final Unit getRealUnitOnly(OrderableUnit var1) {
        Unit var2 = this.getSingleRaw(var1);
        return var2 instanceof DummyNonUnitWithTeam ? null : var2;
    }

    public abstract Unit getSingleRaw(OrderableUnit var1);

    public void forMeta(class_591 var1) {
    }

    static void addUnitReferenceType(UnitReference var0, String... var1) {
        String[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            var5 = var5.toLowerCase(Locale.ROOT);
            referenceTypes.put(var5, var0);
            String var6 = var5.replace("self.", "subject.");
            if (!var6.equals(var5)) {
            }
        }

    }

    public static UnitReference$UnitReferenceOrUnitType parseUnitTypeOrReferenceFromConf(class_591 var0, UnitConfig var1, String var2, String var3, UnitReference$UnitReferenceOrUnitType var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        return parseUnitTypeOrReference(var0, var5, var2, var3, var4);
    }

    public static UnitReference$UnitReferenceOrUnitType parseUnitTypeOrReference(class_591 var0, String var1, String var2, String var3, UnitReference$UnitReferenceOrUnitType var4) {
        if (var1 == null) {
            return var4;
        } else {
            var1 = var1.trim();
            if (!"".equals(var1) && !"NONE".equalsIgnoreCase(var1)) {
                if (var1.toLowerCase(Locale.ROOT).startsWith("unitref ")) {
                    UnitReference var6 = parseUnitReference(var0, var1, var2, var3, (UnitReference)null, true);
                    return new UnitReference$UnitReferenceOrUnitType(var6);
                } else {
                    class_601 var5 = var0.a(var1, var3, var2);
                    if (var5 != null) {
                        var5.f = true;
                    }

                    return new UnitReference$UnitReferenceOrUnitType(var5);
                }
            } else {
                return var4;
            }
        }
    }

    public static UnitReference parseUnitReferenceFromConf(class_591 var0, UnitConfig var1, String var2, String var3, UnitReference var4) {
        String var5 = var1.getValueAsStaticString(var2, var3, (String)null);
        return parseUnitReference(var0, var5, var2, var3, var4, false);
    }

    @SneakyThrows
    public static UnitReference parseUnitReference(class_591 var0, String var1, String var2, String var3, UnitReference var4, boolean var5) {
        if (var1 == null) {
            return var4;
        } else {
            var1 = var1.trim();
            if (!"".equals(var1) && !"NONE".equalsIgnoreCase(var1)) {
                var1 = var1.toLowerCase(Locale.ROOT);
                if (var1.startsWith("unitref ")) {
                    var1 = var1.substring("unitref ".length());
                    var1 = var1.trim();
                }

                if (var1.equals("self")) {
                    return selfUnitReference;
                } else {
                    int var6 = var1.indexOf("(");
                    if (var6 == -1) {
                        var6 = var1.length();
                    } else if (var1.indexOf(")") != var1.length() - 1) {
                        throw new CustomException("[" + var2 + "]" + var3 + " UnitReference: Unexpected format for: '" + var1 + "'");
                    }

                    try {
                        UnitReference var7 = parseSingleUnitReferenceBlock(var0, var1);
                        if (var7 == null) {
                            throw new RuntimeException("Unknown function:'" + var1 + "'");
                        } else {
                            return var7;
                        }
                    } catch (RuntimeException var8) {
                        throw new RuntimeException("[" + var2 + "]" + var3 + " UnitReference error: " + var8.getMessage() + ", [parsing: '" + var1 + "']", var8);
                    }
                }
            } else {
                return var4;
            }
        }
    }

    public static UnitReference parseSingleUnitReferenceElement(class_591 var0, String var1) {
        String var2 = var1.split("\\(")[0];
        var2 = var2.trim().toLowerCase(Locale.ROOT);
        UnitReference var3 = (UnitReference)referenceTypes.get(var2);
        if (var3 == null) {
            return null;
        } else {
            String var4 = var1.substring(var2.length());
            var4 = var4.trim();
            if (var4.equals("")) {
                var4 = "()";
            }

            if (var4.startsWith("(") && var4.endsWith(")")) {
                var4 = var4.substring(1, var4.length() - 1);
                var4 = var4.trim();
                UnitReference var5 = var3.with(var0, var4, var2);
                if (var5 instanceof UnitReference$NullUnitReference) {
                }

                return var5;
            } else {
                throw new RuntimeException("Failed to parse unit reference arguments for:'" + var1 + "'");
            }
        }
    }

    public static UnitReference parseSingleUnitReferenceBlock(class_591 var0, String var1) {
        int var2 = class_675.b(var1);
        if (var2 != 0) {
            if (var2 > 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + var1 + "'. A '(' was not closed.");
            }

            if (var2 < 0) {
                throw new RuntimeException("Brackets unbalanced for: '" + var1 + "'. Too many ')'.");
            }
        }

        var1 = var1.trim();
        var1 = LogicBooleanLoader.breakOuterLayerBrackets(var1);
        String[] var3 = class_675.b(var1, ".", false);
        ArrayList var4 = new ArrayList();
        boolean var5 = false;

        for(int var6 = 0; var6 < var3.length; ++var6) {
            String var7 = var3[var6];
            if (var7.equalsIgnoreCase("self")) {
                var5 = true;
            } else {
                UnitReference var8 = parseSingleUnitReferenceElement(var0, var7);
                if (var8 == null) {
                    throw new RuntimeException("Unknown unit reference:'" + var7 + "'");
                }

                var4.add(var8);
            }
        }

        if (var4.size() == 0) {
            if (var5) {
                return selfUnitReference;
            } else {
                throw new RuntimeException("Unexpected unit reference:'" + var1 + "'");
            }
        } else if (var4.size() == 1) {
            return (UnitReference)var4.get(0);
        } else {
            UnitReference[] var9 = (UnitReference[])var4.toArray(new UnitReference[0]);
            return new UnitReference$ChainedUnitReference(var9);
        }
    }

    public UnitReference with(String var1) {
        return this.with((class_591)null, var1, (String)null);
    }

    public UnitReference with(class_591 var1, String var2, String var3) {
        UnitReference var4;
        try {
            var4 = (UnitReference)this.clone();
        } catch (CloneNotSupportedException var6) {
            throw new RuntimeException(var6);
        }

        var4.forMeta(var1);
        var4.setArgumentsRaw(var2, var1, var3);
        return var4;
    }

    public boolean read(OrderableUnit var1) {
        return false;
    }

    public Unit readUnit(OrderableUnit var1) {
        return this.getSingleRaw(var1);
    }

    public LogicBoolean$ReturnType getReturnType() {
        return LogicBoolean$ReturnType.unit;
    }

    public String getClassDebugName() {
        return "<unit reference>";
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return this.getClassDebugName() + "(" + Unit.A(this.getSingleRaw(var1)) + ")";
    }

    public LogicBooleanLoader$LogicBooleanContext createContext() {
        return unitContextChangingContext;
    }

    public LogicBoolean setChild(LogicBoolean var1) {
        UnitReference$UnitContextChangingBooleanByLogic var2 = UnitReference$UnitContextChangingBooleanByLogic.create(this, var1);
        return var2;
    }

    static {
        addUnitReferenceType(new UnitReference$AttachmentUnitReference(), "attachment");
        addUnitReferenceType(new UnitReference$ParentUnitReference(), "parent");
        addUnitReferenceType(new UnitReference$TransportingUnitReference(), "transporting");
        addUnitReferenceType(new UnitReference$ActiveWaypointTargetReference(), "activeWaypointTarget");
        addUnitReferenceType(new UnitReference$AttackingReference(), "attacking");
        addUnitReferenceType(new UnitReference$Memory1UnitReference(), "customTarget1");
        addUnitReferenceType(new UnitReference$Memory2UnitReference(), "customTarget2");
        addUnitReferenceType(new UnitReference$LastDamagedByUnitReference(), "lastDamagedBy");
        addUnitReferenceType(new UnitReference$NearestUnitReference(), "nearestUnit");
        addUnitReferenceType(new UnitReference$FirstUnitReference(), "globalSearchForFirstUnit");
        addUnitReferenceType(new UnitReference$NullUnitReference(), "nullUnit");
        addUnitReferenceType(new UnitReference$NullUnitReference(), "null");
        addUnitReferenceType(new UnitReference$GetOffsetAbsolute(), "getOffsetAbsolute");
        addUnitReferenceType(new UnitReference$GetOffsetRelative(), "getOffsetRelative");
        addUnitReferenceType(new UnitReference$GetAsMarker(), "getAsMarker");
        addUnitReferenceType(new UnitReference$ThisActionTargetReference(), "thisActionTarget");
        addUnitReferenceType(new UnitReference$EventSourceReference(), "eventSource");
        unitContextChangingContext = new UnitReference$UnitContextChangingContext();
        placeholderUnitContext = new UnitReference$UnitContextChangingContext();
    }
}
