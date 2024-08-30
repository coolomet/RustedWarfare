package com.corrodinggames.rts.debug;

import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.a.class_636;

final class ScriptServerSocket$2 extends class_636 {
    // $FF: synthetic field
    final ScriptEngine a;
    // $FF: synthetic field
    final String b;

    ScriptServerSocket$2(ScriptEngine var1, String var2) {
        this.a = var1;
        this.b = var2;
    }

    public strictfp void run() {
        try {
            ScriptEngine.inDebugScript = true;
            this.c = this.a.processArg(this.b);
        } finally {
            ScriptEngine.inDebugScript = false;
        }

    }
}
