package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.DummyNonUnitWithTeam;
import com.corrodinggames.rts.game.units.custom.CustomException;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Iterator;

public strictfp class VariableScope {
    public static final VariableScope emptyVariableScope = new VariableScope$EmptyVariableScope();
    public static final String nullOrMissingString = "";
    static final VariableScope$VariableName[] emptyNames = new VariableScope$VariableName[0];
    static final VariableScope$VariableData[] emptyData = new VariableScope$VariableData[0];
    VariableScope$VariableName[] variableNames;
    VariableScope$VariableData[] variableData;
    public static final VariableScope$VariableDataNull variableDataNull = new VariableScope$VariableDataNull();

    public VariableScope() {
        this.variableNames = emptyNames;
        this.variableData = emptyData;
    }

    public boolean isEmpty() {
        for(int var1 = 0; var1 < this.variableData.length; ++var1) {
            VariableScope$VariableData var2 = this.variableData[var1];
            if (var2 != null) {
                return false;
            }
        }

        return true;
    }

    public String debugMemory(boolean var1, boolean var2) {
        String var3 = "";

        for(int var4 = 0; var4 < this.variableData.length; ++var4) {
            VariableScope$VariableData var5 = this.variableData[var4];
            if (var5 != null) {
                var3 = var3 + VariableScope$VariableName.access$000(this.variableNames[var4]) + "=" + var5.valueToStringDebug((OrderableUnit)null);
                if (var2) {
                    var3 = var3 + " (" + var5.getReturnType().name() + ")";
                }

                if (var1) {
                    var3 = var3 + "\n";
                } else {
                    var3 = var3 + "|";
                }
            }
        }

        return var3;
    }

    public VariableScope$VariableData getDataObjectRaw(VariableScope$VariableName var1) {
        for(int var2 = 0; var2 < this.variableData.length; ++var2) {
            if (this.variableNames[var2] == var1) {
                return this.variableData[var2];
            }
        }

        return variableDataNull;
    }

    public void setArrayDataRaw(VariableScope$VariableName var1, VariableScope$VariableData var2, int var3) {
        Object var4 = null;
        LogicBoolean$ReturnType var5 = LogicBoolean$ReturnType.undefined;
        if (var2 != null) {
            var5 = var2.getReturnType();
        }

        for(int var6 = 0; var6 < this.variableData.length; ++var6) {
            if (this.variableNames[var6] == var1 && this.variableData[var6] instanceof VariableScope$VariableDataArray) {
                VariableScope$VariableDataArray var7 = (VariableScope$VariableDataArray)this.variableData[var6];
                if (var5 == LogicBoolean$ReturnType.undefined || var7.getElementReturnType() == var5) {
                    var4 = var7;
                }
            }
        }

        if (var4 != null || var2 != null) {
            if (var4 == null) {
                if (var5 == LogicBoolean$ReturnType.number) {
                    var4 = new VariableScope$VariableDataNumberArray();
                } else if (var5 == LogicBoolean$ReturnType.bool) {
                    var4 = new VariableScope$VariableDataBoolArray();
                } else {
                    if (var5 != LogicBoolean$ReturnType.unit) {
                        GameEngine.print("Unhandled array type: " + var5);
                        return;
                    }

                    var4 = new VariableScope$VariableDataUnitArray();
                }

                this.setDataRaw(var1, (VariableScope$VariableData)var4);
            }

            ((VariableScope$VariableDataArray)var4).setDataAtIndex(var2, var3);
        }
    }

    public void setDataRaw(VariableScope$VariableName var1, VariableScope$VariableData var2) {
        if (var2 == null) {
            var2 = variableDataNull;
        }

        for(int var3 = 0; var3 < this.variableData.length; ++var3) {
            if (this.variableNames[var3] == var1) {
                this.variableData[var3] = (VariableScope$VariableData)var2;
                return;
            }
        }

        VariableScope$VariableName[] var6 = new VariableScope$VariableName[this.variableData.length + 1];
        VariableScope$VariableData[] var4 = new VariableScope$VariableData[this.variableData.length + 1];

        for(int var5 = 0; var5 < this.variableData.length; ++var5) {
            var4[var5] = this.variableData[var5];
            var6[var5] = this.variableNames[var5];
        }

        var4[var4.length - 1] = (VariableScope$VariableData)var2;
        var6[var6.length - 1] = var1;
        this.variableData = var4;
        this.variableNames = var6;
    }

    public void clearAllData() {
        this.variableData = emptyData;
        this.variableNames = emptyNames;
    }

    public void setUnit(VariableScope$VariableDefinition var1, Unit var2) {
        if (var1.type != LogicBoolean$ReturnType.unit) {
        }

        this.setDataRaw(var1.name, new VariableScope$VariableDataUnit(var2));
    }

    Unit getUnit(VariableScope$VariableName var1) {
        return this.getDataObjectRaw(var1).readUnit((OrderableUnit)null);
    }

    LogicBoolean getAsLogicBoolean(VariableScope$VariableName var1) {
        return this.getDataObjectRaw(var1);
    }

    public void setFromLogicBoolean(VariableScope$VariableName var1, OrderableUnit var2, LogicBoolean var3, LogicBoolean var4) {
        Object var5 = null;
        if (var3 != null) {
            LogicBoolean$ReturnType var6 = var3.getReturnType();
            if (var6 == LogicBoolean$ReturnType.bool) {
                var5 = new VariableScope$VariableDataBoolean(var3.read(var2));
            } else if (var6 == LogicBoolean$ReturnType.unit) {
                Unit var7 = var3.readUnit(var2);
                var7 = getSafeUnitReferenceForStorage(var7);
                var5 = new VariableScope$VariableDataUnit(var7);
            } else if (var6 == LogicBoolean$ReturnType.number) {
                var5 = new VariableScope$VariableDataNumber((double)var3.readNumber(var2));
            } else if (var6 == LogicBoolean$ReturnType.string) {
                var5 = new VariableScope$VariableDataString(var3.readString(var2));
            }
        }

        if (var4 != null) {
            int var8 = (int)var4.readNumber(var2);
            this.setArrayDataRaw(var1, (VariableScope$VariableData)var5, var8);
        } else {
            this.setDataRaw(var1, (VariableScope$VariableData)var5);
        }

    }

    double getNumber(VariableScope$VariableName var1) {
        return (double)this.getDataObjectRaw(var1).readNumber((OrderableUnit)null);
    }

    String getString(VariableScope$VariableName var1) {
        return this.getDataObjectRaw(var1).readString((OrderableUnit)null);
    }

    boolean getBoolean(VariableScope$VariableName var1) {
        return this.getDataObjectRaw(var1).read((OrderableUnit)null);
    }

    public static void writeOut(GameOutputStream var0, VariableScope var1) {
        if (var1 == null) {
            var0.writeByte(-2);
        } else if (var1.variableData.length == 0) {
            var0.writeByte(-1);
        } else {
            var0.writeByte(0);
            var0.a((short)var1.variableData.length);
            int var2 = var1.variableData.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                VariableScope$VariableData var4 = var1.variableData[var3];
                var0.writeString(VariableScope$VariableName.access$000(var1.variableNames[var3]));
                boolean var5 = false;
                var0.writeBoolean(var5);
                if (!var5) {
                    writeOutDynamicData(var0, var4);
                }
            }

        }
    }

    public static VariableScope readIn(GameInputStream var0) {
        byte var1 = var0.readByte();
        if (var1 == -2) {
            return null;
        } else if (var1 == -1) {
            return null;
        } else {
            short var2 = var0.readShort();
            VariableScope var3 = new VariableScope();

            for(int var4 = 0; var4 < var2; ++var4) {
                VariableScope$VariableName var5 = VariableScope$VariableName.get(var0.readString());
                boolean var6 = var0.readBoolean();
                if (!var6) {
                    VariableScope$VariableData var7 = readInDynamicData(var0);
                    var3.setDataRaw(var5, var7);
                }
            }

            return var3;
        }
    }

    public static void writeOutUnitOrPlaceholder(GameOutputStream var0, Unit var1) {
        if (var1 instanceof DummyNonUnitWithTeam) {
            var0.writeByte(1);
            var0.writeFloat(var1.xCord);
            var0.writeFloat(var1.yCord);
            var0.writeFloat(var1.zCord);
            var0.writeFloat(var1.cg);
            var0.a(var1.bX);
        } else {
            var0.writeByte(0);
            var0.b(var1);
        }

    }

    public static void writeOutDynamicData(GameOutputStream var0, VariableScope$VariableData var1) {
        if (var1 == null) {
            var0.writeEnum((Enum)null);
        } else {
            LogicBoolean$ReturnType var2 = var1.getReturnType();
            var0.writeEnum(var2);
            if (var1 instanceof VariableScope$VariableDataUnit) {
                VariableScope$VariableDataUnit var3 = (VariableScope$VariableDataUnit)var1;
                Unit var4 = var3.unit;
                writeOutUnitOrPlaceholder(var0, var4);
            } else if (var1 instanceof VariableScope$VariableDataBoolean) {
                var0.writeBoolean(((VariableScope$VariableDataBoolean)var1).bool);
            } else if (var1 instanceof VariableScope$VariableDataString) {
                var0.writeIsString(((VariableScope$VariableDataString)var1).text);
            } else if (var1 instanceof VariableScope$VariableDataNumber) {
                var0.writeDouble(((VariableScope$VariableDataNumber)var1).number);
            } else if (var1 instanceof VariableScope$VariableDataArray) {
                VariableScope$VariableDataArray var7 = (VariableScope$VariableDataArray)var1;
                var0.writeInt(var7.size);
                int var5;
                if (var7 instanceof VariableScope$VariableDataBoolArray) {
                    VariableScope$VariableDataBoolArray var8 = (VariableScope$VariableDataBoolArray)var7;

                    for(var5 = 0; var5 < var8.size; ++var5) {
                        var0.writeBoolean(var8.dataArray[var5]);
                    }
                } else if (var7 instanceof VariableScope$VariableDataNumberArray) {
                    VariableScope$VariableDataNumberArray var9 = (VariableScope$VariableDataNumberArray)var7;

                    for(var5 = 0; var5 < var9.size; ++var5) {
                        var0.writeFloat(var9.dataArray[var5]);
                    }
                } else {
                    if (!(var7 instanceof VariableScope$VariableDataUnitArray)) {
                        throw new RuntimeException("Unhandled array type: " + var2.name());
                    }

                    VariableScope$VariableDataUnitArray var10 = (VariableScope$VariableDataUnitArray)var7;

                    for(var5 = 0; var5 < var10.size; ++var5) {
                        Unit var6 = var10.dataArray[var5];
                        writeOutUnitOrPlaceholder(var0, var6);
                    }
                }
            } else if (var2 != LogicBoolean$ReturnType.undefined) {
                throw new RuntimeException("Unhandled type: " + var2.name());
            }

        }
    }

    @SneakyThrows
    public static Unit readInUnitOrPlaceholder(GameInputStream var0) {
        byte var1 = var0.readByte();
        Object var2;
        if (var1 == 1) {
            float var3 = var0.readFloat();
            float var4 = var0.readFloat();
            float var5 = var0.readFloat();
            float var6 = var0.readFloat();
            PlayerData var7 = var0.s();
            var2 = DummyNonUnitWithTeam.a(var7);
            ((Unit)var2).xCord = var3;
            ((Unit)var2).yCord = var4;
            ((Unit)var2).zCord = var5;
            ((Unit)var2).cg = var6;
        } else {
            if (var1 != 0) {
                throw new IOException("Unhandled unit type: " + var1);
            }

            var2 = var0.o();
        }

        return (Unit)var2;
    }

    public static VariableScope$VariableData readInDynamicData(GameInputStream var0) {
        LogicBoolean$ReturnType var1 = (LogicBoolean$ReturnType)var0.readEnum(LogicBoolean$ReturnType.class);
        if (var1 == null) {
            return null;
        } else if (var1 == LogicBoolean$ReturnType.unit) {
            Unit var6 = readInUnitOrPlaceholder(var0);
            VariableScope$VariableDataUnit var9 = new VariableScope$VariableDataUnit(var6);
            return var9;
        } else if (var1 == LogicBoolean$ReturnType.bool) {
            return new VariableScope$VariableDataBoolean(var0.readBoolean());
        } else if (var1 == LogicBoolean$ReturnType.string) {
            return new VariableScope$VariableDataString(var0.isReadString());
        } else if (var1 == LogicBoolean$ReturnType.number) {
            return new VariableScope$VariableDataNumber(var0.readDouble());
        } else if (var1 != LogicBoolean$ReturnType.boolArray && var1 != LogicBoolean$ReturnType.numberArray && var1 != LogicBoolean$ReturnType.unitArray) {
            if (var1 == LogicBoolean$ReturnType.undefined) {
                throw new RuntimeException("Undefined type: " + var1.name());
            } else {
                throw new RuntimeException("Unhandled type: " + var1.name());
            }
        } else {
            int var2 = var0.readInt();
            int var4;
            if (var1 == LogicBoolean$ReturnType.boolArray) {
                VariableScope$VariableDataBoolArray var8 = new VariableScope$VariableDataBoolArray();

                for(var4 = 0; var4 < var2; ++var4) {
                    var8.setBooleanIndex(var4, var0.readBoolean());
                }

                return var8;
            } else if (var1 == LogicBoolean$ReturnType.numberArray) {
                VariableScope$VariableDataNumberArray var7 = new VariableScope$VariableDataNumberArray();

                for(var4 = 0; var4 < var2; ++var4) {
                    var7.setNumberIndex(var4, var0.readFloat());
                }

                return var7;
            } else if (var1 != LogicBoolean$ReturnType.unitArray) {
                throw new RuntimeException("Unhandled array type: " + var1.name());
            } else {
                VariableScope$VariableDataUnitArray var3 = new VariableScope$VariableDataUnitArray();

                for(var4 = 0; var4 < var2; ++var4) {
                    Unit var5 = readInUnitOrPlaceholder(var0);
                    var3.setUnitIndex(var4, var5);
                }

                return var3;
            }
        }
    }

    public static LogicBoolean$ReturnType getUserType(String var0) {
        LogicBoolean$ReturnType var1 = null;
        if (var0.equals("boolean")) {
            var1 = LogicBoolean$ReturnType.bool;
        } else if (var0.equals("bool")) {
            var1 = LogicBoolean$ReturnType.bool;
        } else if (var0.equals("unit")) {
            var1 = LogicBoolean$ReturnType.unit;
        } else if (var0.equals("number")) {
            var1 = LogicBoolean$ReturnType.number;
        } else if (var0.equals("float")) {
            var1 = LogicBoolean$ReturnType.number;
        } else if (var0.equals("text")) {
            var1 = LogicBoolean$ReturnType.string;
        } else if (var0.equals("string")) {
            var1 = LogicBoolean$ReturnType.string;
        } else if (var0.equals("number[]")) {
            var1 = LogicBoolean$ReturnType.numberArray;
        } else if (var0.equals("float[]")) {
            var1 = LogicBoolean$ReturnType.numberArray;
        } else if (var0.equals("bool[]")) {
            var1 = LogicBoolean$ReturnType.boolArray;
        } else if (var0.equals("boolean[]")) {
            var1 = LogicBoolean$ReturnType.boolArray;
        } else if (var0.equals("unit[]")) {
            var1 = LogicBoolean$ReturnType.unitArray;
        }

        return var1;
    }

    public static VariableScope$MemoryWriter createGenericKeyValueWriter(String var0, class_591 var1, String var2, String var3) {
        try {
            VariableScope$MemoryWriter var4 = new VariableScope$MemoryWriter();
            Object var5 = null;
            var4.addWriterElements(var0, new VariableScope$MemoryWriterFactory(var1, (VariableScope$VariableMapping)var5));
            return var4;
        } catch (Exception var6) {
            throw new RuntimeException("[" + var2 + "]" + var3 + ": " + var6.getMessage(), var6);
        }
    }

    public static VariableScope$MemoryWriter createMemoryWriter(String var0, class_591 var1, String var2, String var3) {
        try {
            VariableScope$MemoryWriter var4 = new VariableScope$MemoryWriter();
            var4.addWriterElements(var0, new VariableScope$MemoryWriterFactory(var1));
            return var4;
        } catch (Exception var5) {
            throw new RuntimeException("[" + var2 + "]" + var3 + ": " + var5.getMessage(), var5);
        }
    }

    public static VariableScope$MemoryNames createMemoryNameList(String var0, class_591 var1, LogicBoolean$ReturnType var2, String var3, String var4) {
        try {
            VariableScope$MemoryWriter var5 = new VariableScope$MemoryWriter();
            VariableScope$MemoryWriterFactory var6 = new VariableScope$MemoryWriterFactory(var1);
            var6.noValues = true;
            var5.addWriterElements(var0, var6);
            VariableScope$MemoryNames var7 = new VariableScope$MemoryNames();

            VariableScope$MemoryWriterFactory$MemoryWriterElement var10;
            for(Iterator var8 = var5.writers.iterator(); var8.hasNext(); var7.names.add(var10.name)) {
                VariableScope$CachedWriter$WriterElement var9 = (VariableScope$CachedWriter$WriterElement)var8.next();
                if (!(var9 instanceof VariableScope$MemoryWriterFactory$MemoryWriterElement)) {
                    throw new CustomException("Unexpected element reading: " + var0, var3, var4);
                }

                var10 = (VariableScope$MemoryWriterFactory$MemoryWriterElement)var9;
                if (var10 instanceof VariableScope$MemoryWriterFactory$MemoryWriterElementIndex) {
                    throw new CustomException("Expected memory name without an index got: " + var0, var3, var4);
                }

                if (var2 != null) {
                    VariableScope$VariableDefinition var11 = var1.r.get(var10.name);
                    if (var11 == null) {
                        throw new CustomException("Failed to find defined memory: " + var0, var3, var4);
                    }

                    if (var11.type != var2) {
                        throw new CustomException("Memory: " + var0 + " is type: " + var11.type + " expected: " + var2, var3, var4);
                    }
                }
            }

            return var7;
        } catch (CustomException var12) {
            throw new RuntimeException("[" + var3 + "]" + var4 + ": " + var12.getMessage(), var12);
        }
    }

    public static boolean isMarker(Unit var0) {
        return var0 == null ? false : var0 instanceof DummyNonUnitWithTeam;
    }

    public static Unit getSafeUnitReferenceForStorage(Unit var0) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof DummyNonUnitWithTeam) {
            DummyNonUnitWithTeam var1 = DummyNonUnitWithTeam.a(var0.bX);
            var1.xCord = var0.xCord;
            var1.yCord = var0.yCord;
            var1.zCord = var0.zCord;
            var1.cg = var0.cg;
            return var1;
        } else {
            return var0;
        }
    }
}
