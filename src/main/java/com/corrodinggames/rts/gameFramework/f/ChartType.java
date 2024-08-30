package com.corrodinggames.rts.gameFramework.f;

import com.corrodinggames.rts.gameFramework.class_972;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.ac
public enum ChartType {
    overallStats("A", (class_972)null),
    incomeChart("B", class_972.income),
    armyValueChart("C", class_972.armyValue),
    buildingValueChart("D", class_972.buildingValue),
    totalValueChart("E", class_972.totalValue);
    private final String f;
    private final class_972 g;
    ChartType(String var3, class_972 var4) {
        this.f = var3;
        this.g = var4;
    }

    public class_972 a() {
        return this.g;
    }
}
