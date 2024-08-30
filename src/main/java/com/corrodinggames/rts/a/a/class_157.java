package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.debug.test.AbstractScriptTest;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_694;

// $FF: renamed from: com.corrodinggames.rts.a.a.a
public strictfp class class_157 extends AbstractScriptTest {
    public void a() {
        GameEngine.log("== Testing GameLogic ==");
        GameEngine var1 = GameEngine.getGameEngine();
        var1.by = 1000;
        class_650.a(class_694.b(1000, 5));
        class_650.a(class_694.b(1000, 1100));
        class_650.a(class_694.b(900, 200));
        class_650.b(class_694.b(-9999, 200));
        class_650.b(class_694.b(1100, 200));
        class_650.b(class_694.b(700, 200));
        var1.by = 1000;
        class_650.a(class_694.a(500, 300));
        class_650.b(class_694.a(900, 300));
    }
}
