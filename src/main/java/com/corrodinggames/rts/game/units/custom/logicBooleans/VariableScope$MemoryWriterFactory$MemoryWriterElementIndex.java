package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;

public strictfp class VariableScope$MemoryWriterFactory$MemoryWriterElementIndex extends VariableScope$MemoryWriterFactory$MemoryWriterElement {
    public LogicBoolean nameIndex;

    public void writeToUnit(OrderableUnit var1) {
        if (var1.bw == null) {
            var1.bw = new VariableScope();
        }

        var1.bw.setFromLogicBoolean(this.name, var1, this.value, this.nameIndex);
    }

    public void writeToMemory(VariableScope var1, OrderableUnit var2) {
        var1.setFromLogicBoolean(this.name, var2, this.value, this.nameIndex);
    }
}
