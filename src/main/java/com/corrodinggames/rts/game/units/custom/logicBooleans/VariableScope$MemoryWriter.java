package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.OrderableUnit;
import java.util.Iterator;

public strictfp class VariableScope$MemoryWriter extends VariableScope$CachedWriter {
    public void writeToMemory(VariableScope var1, OrderableUnit var2) {
        Iterator var3 = this.writers.iterator();

        while(var3.hasNext()) {
            VariableScope$CachedWriter$WriterElement var4 = (VariableScope$CachedWriter$WriterElement)var3.next();
            VariableScope$MemoryWriterFactory$MemoryWriterElement var5 = (VariableScope$MemoryWriterFactory$MemoryWriterElement)var4;
            var5.writeToMemory(var1, var2);
        }

    }
}
