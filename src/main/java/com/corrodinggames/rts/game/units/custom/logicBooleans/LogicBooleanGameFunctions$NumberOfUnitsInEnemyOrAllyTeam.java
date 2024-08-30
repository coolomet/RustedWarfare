package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.gameFramework.GameEngine;

public final strictfp class LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam extends LogicBoolean$AbstractNumberBoolean {
    public class_585 _withTag;
    @LogicBoolean$Parameter
    public float withinRange = -1.0F;
    public float withinRangeSq = -1.0F;
    @LogicBoolean$Parameter
    public boolean incompleteBuildings;
    @LogicBoolean$Parameter
    public boolean factoryQueue;
    @LogicBoolean$Parameter
    public boolean ally;
    public static final LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam$HandleCallbackCountEnemies handleCallbackCountEnemies = new LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam$HandleCallbackCountEnemies();
    public static final LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam$HandleCallbackCountAlly handleCallbackCountAlly = new LogicBooleanGameFunctions$NumberOfUnitsInEnemyOrAllyTeam$HandleCallbackCountAlly();

    @LogicBoolean$Parameter
    public void withTag(String var1) {
        this._withTag = class_585.c(var1);
    }

    public void validate(String var1, String var2, String var3, LogicBooleanLoader$LogicBooleanContext var4, boolean var5) {
        super.validate(var1, var2, var3, var4, var5);
        if (this.withinRange > 1000.0F) {
            throw new BooleanParseException("For CPU reasons withinRange argument cannot be over 1000 (but unlimited range is fine) in function:" + var1);
        } else {
            if (this.withinRange > 0.0F) {
                this.withinRangeSq = this.withinRange * this.withinRange;
                if (this.factoryQueue) {
                    throw new BooleanParseException("'factoryQueue' and 'withinRange' are not supported at the same time in function:" + var1);
                }
            }

        }
    }

    public String getName() {
        return "Enemy Unit count of " + this._withTag + (this.withinRange < 0.0F ? "" : " (within range " + this.withinRange + ")");
    }

    public float getValue(OrderableUnit var1) {
        PlayerData var2 = var1.bX;
        int var3 = 0;
        if (!this.ally) {
            var3 += var2.b(this._withTag, this.incompleteBuildings, this.factoryQueue);
        } else {
            var3 += var2.c(this._withTag, this.incompleteBuildings, this.factoryQueue);
        }

        if (!(this.withinRange < 0.0F) && var3 != 0) {
            GameEngine var4;
            if (!this.ally) {
                handleCallbackCountEnemies.withinRangeSq = this.withinRangeSq;
                handleCallbackCountEnemies.count = 0;
                handleCallbackCountEnemies.tag = this._withTag;
                handleCallbackCountEnemies.incompleteBuildings = this.incompleteBuildings;
                var4 = GameEngine.getGameEngine();
                var4.cc.a(var1.xCord, var1.yCord, this.withinRange, var1, 0.0F, handleCallbackCountEnemies);
                return (float)handleCallbackCountEnemies.count;
            } else {
                handleCallbackCountAlly.withinRangeSq = this.withinRangeSq;
                handleCallbackCountAlly.count = 0;
                handleCallbackCountAlly.tag = this._withTag;
                handleCallbackCountAlly.incompleteBuildings = this.incompleteBuildings;
                handleCallbackCountAlly.ally = var1.bX;
                var4 = GameEngine.getGameEngine();
                var4.cc.a(var1.xCord, var1.yCord, this.withinRange, var1, 0.0F, handleCallbackCountAlly);
                return (float)handleCallbackCountAlly.count;
            }
        } else {
            return (float)var3;
        }
    }

    public float getMaxValue(OrderableUnit var1) {
        return 2.1474836E9F;
    }
}
