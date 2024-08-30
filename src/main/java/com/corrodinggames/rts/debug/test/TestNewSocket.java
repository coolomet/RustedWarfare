package com.corrodinggames.rts.debug.test;

import com.corrodinggames.rts.gameFramework.GameEngine;

public strictfp class TestNewSocket extends AbstractScriptTest {
    public void start() {
        this.test();
    }

    public void test() {
        GameEngine.log("networkSocks");
        GameEngine var1 = GameEngine.getGameEngine();

        for(int var2 = 0; var2 < 10000; ++var2) {
            var1.netEngine.startNet(false);

            try {
                Thread.sleep(50L);
            } catch (InterruptedException var5) {
                var5.printStackTrace();
            }

            var1.netEngine.closeServer("test");
        }

        GameEngine.log("done");

        try {
            Thread.sleep(100000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }
}
