package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class LogicBooleanGameFunctions$GameMapWidthBoolean extends LogicNumberFunction {
    public String getName() {
        return "game.mapWidth";
    }

    public float readNumber(OrderableUnit var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        return var2.bL.i();
    }
}
