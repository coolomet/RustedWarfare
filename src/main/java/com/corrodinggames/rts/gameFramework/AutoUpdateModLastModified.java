package com.corrodinggames.rts.gameFramework;

class AutoUpdateModLastModified extends Thread {
    boolean a = true;

    public void run() {
        for(; this.a; FileChangeEngine.writeLastModified()) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var2) {
            }
        }

    }
}
