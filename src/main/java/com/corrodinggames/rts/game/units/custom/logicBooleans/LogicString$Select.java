package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import java.util.ArrayList;

public strictfp class LogicString$Select extends LogicString {
    LogicBoolean$ReturnType commonType;
    LogicBoolean selector;
    LogicBoolean childA;
    LogicBoolean childB;

    public void setArgumentsRaw(String var1, class_591 var2, String var3) {
        if (var1 != null && !"".equals(var1)) {
            ArrayList var4 = class_675.a(var1, ",", false);
            this.validateNumberOfArguments(var4.size());
            this.selector = LogicBooleanLoader.parseBooleanBlock(var2, (String)var4.get(0), true);
            if (this.selector == null) {
                throw new BooleanParseException("Expected non-null argument");
            } else {
                this.childA = LogicBooleanLoader.parseBooleanBlock(var2, (String)var4.get(1), false);
                if (this.childA == null) {
                    throw new BooleanParseException("Expected non-null argument");
                } else {
                    this.childB = LogicBooleanLoader.parseBooleanBlock(var2, (String)var4.get(2), false);
                    if (this.childB == null) {
                        throw new BooleanParseException("Expected non-null argument");
                    } else {
                        this.commonType = this.childA.getReturnType();
                        if (this.commonType != this.childB.getReturnType()) {
                            throw new BooleanParseException("Select() expected 2 and 3 argument to be the same type, got: " + this.commonType.name() + " and " + this.childB.getReturnType().name());
                        }
                    }
                }
            }
        } else {
            this.validateNumberOfArguments(0);
        }
    }

    public void validateNumberOfArguments(int var1) {
        if (var1 != 3) {
            throw new BooleanParseException("Expected 3 arguments");
        }
    }

    public LogicBoolean$ReturnType getReturnType() {
        return this.commonType;
    }

    public String getMatchFailReasonForPlayer(OrderableUnit var1) {
        return "(selector if:(" + this.selector.getMatchFailReasonForPlayer(var1) + ") then:(" + this.childA.getMatchFailReasonForPlayer(var1) + ") ) else:(" + this.childB.getMatchFailReasonForPlayer(var1) + ") )";
    }

    public String readString(OrderableUnit var1) {
        boolean var2 = this.selector.read(var1);
        return var2 ? this.childA.readString(var1) : this.childB.readString(var1);
    }

    public boolean read(OrderableUnit var1) {
        boolean var2 = this.selector.read(var1);
        return var2 ? this.childA.read(var1) : this.childB.read(var1);
    }

    public float readNumber(OrderableUnit var1) {
        boolean var2 = this.selector.read(var1);
        return var2 ? this.childA.readNumber(var1) : this.childB.readNumber(var1);
    }

    public Unit readUnit(OrderableUnit var1) {
        boolean var2 = this.selector.read(var1);
        return var2 ? this.childA.readUnit(var1) : this.childB.readUnit(var1);
    }
}
