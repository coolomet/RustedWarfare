package com.corrodinggames.librocket.scripts;

class Root$2 implements Runnable {
    // $FF: synthetic field
    final Root this$0;

    Root$2(Root var1) {
        this.this$0 = var1;
    }

    public void run() {
        ScriptEngine.getInstance().addScriptToQueue("joinServerCallback();");
    }
}
