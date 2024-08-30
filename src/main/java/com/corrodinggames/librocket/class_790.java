package com.corrodinggames.librocket;

import android.app.Activity;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.appFramework.class_0;
import com.corrodinggames.rts.appFramework.class_200;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;
import com.corrodinggames.rts.gameFramework.utility.SlickToAndroidKeycodes;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;

// $FF: renamed from: com.corrodinggames.librocket.a
public abstract class class_790 {
    protected static class_790 a;
    public class_60 b;
    public class_0 c;
    boolean d = true;
    boolean e = true;

    public static class_790 a() {
        return a;
    }

    public void a(class_60 var1, class_0 var2) {
        this.b = var1;
        this.c = var2;
    }

    public void b() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1 != null) {
            var1.a((Activity)null, this.c, true);
        } else {
            GameEngine.log("showMainMenu: game is null");
        }

        this.b.setDocument("mainMenu.rml");
    }

    public void c() {
    }

    public void d() {
        this.b.setDocument("settings.rml");
    }

    public void e() {
        this.b.setDocument("leaderboard.rml");
    }

    public synchronized void a(boolean var1) {
        this.e = var1;
        this.f();
    }

    public synchronized void f() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1 == null) {
            GameEngine.print("Main::resumeGame(): game==null");
        } else {
            var1.bD = true;
            var1.a((Activity)null, this.c, this.e);
        }
    }

    public synchronized void b(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!var1) {
            GameEngine.log("endGame: queDisconnectAndWait");
            var2.netEngine.u();
        } else {
            GameEngine.log("endGame: network disconnect");
            var2.netEngine.closeServer("shutdownServer");
        }

    }

    public synchronized void a(String var1) {
        this.b(true);
        GameEngine var2 = GameEngine.getGameEngine();
        this.e = false;
        boolean var4 = false;
        byte var5 = 8;
        byte var6 = 0;
        boolean var7 = true;
        boolean var8 = false;
        class_200.a(var1, var4, var5, var6, var7, var8);
        this.f();
    }

    public void c(boolean var1) {
        this.e = var1;
    }

    public abstract void g();

    public abstract void h();

    public abstract int i();

    public abstract void d(boolean var1);

    public boolean j() {
        return this.b != null && !this.b.b();
    }

    public void a(int var1, char var2) {
        int var3 = SlickToAndroidKeycodes.b(var1);
        if (!this.j()) {
            GameEngine var6 = GameEngine.getGameEngine();
            if (var6 != null) {
                var6.b(var3, true);
                if (var1 == 1) {
                }

            }
        } else {
            Integer var4 = SlickToAndroidKeycodes.c(var1);
            Object var5 = this.b.b("event_onkeydown");
            if (var5 != null) {
                ScriptEngine.getInstance().addScriptToQueue(var5 + "(" + var3 + ");");
                if (this.b.c() != null) {
                    return;
                }
            }

            if (var2 > 255) {
                ScriptEngine.getInstance().addRunnableToQueue(new class_642(this));
            }

            if (var1 == 30 && this.i() == 1) {
                this.b.processKeyDown(93, 0);
                this.b.processKeyUp(93, 0);
                this.b.processKeyDown(91, 2);
                this.b.processKeyUp(91, 2);
            } else if (var1 == 46 && this.i() == 1) {
                this.b.processKeyDown(14, 1);
            } else if (var1 == 47 && this.i() == 1) {
                this.b.processKeyDown(33, 1);
            } else {
                if (var4 != null) {
                    this.b.processKeyDown(var4, this.i());
                } else if (var2 != 0) {
                    if (Character.isISOControl(var2)) {
                        if (var2 == '\b') {
                            GameEngine.log("backspace char pressed");
                            this.b.processKeyDown(69, 0);
                            this.b.processKeyUp(69, 0);
                        } else {
                            GameEngine.log("keyPressed skipping isISOControl:" + var1 + " c:" + var2 + " c_print:" + var2);
                        }
                    } else {
                        this.b.processTextInputChar(var2);
                    }
                }

                if (var1 != 28 && var1 != 156) {
                    if (var2 == '\r') {
                        GameEngine.log("keyPressed: new line entered");
                        ScriptEngine.getInstance().addScriptToQueue("onEnter();");
                    }
                } else {
                    ScriptEngine.getInstance().addScriptToQueue("onEnter();");
                }

                if (var1 == 1) {
                    ScriptEngine.getInstance().addScriptToQueue("onEscape();");
                }

            }
        }
    }

    public LinkedList k() {
        return null;
    }

    public boolean b(String var1) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                try {
                    GameEngine.log("Opening link from desktop api");
                    Desktop.getDesktop().browse(new URI(var1));
                    return true;
                } catch (IOException var6) {
                    var6.printStackTrace();
                } catch (URISyntaxException var7) {
                    var7.printStackTrace();
                }
            } else {
                String var2 = System.getProperty("os.name").toLowerCase();
                String[] var3 = null;
                if (var2.contains("win")) {
                    var3 = new String[]{"rundll32", "url.dll,FileProtocolHandler", var1};
                }

                if (var2.contains("mac")) {
                    var3 = new String[]{"open", var1};
                }

                if (var2.contains("nix") || var2.contains("nux")) {
                    var3 = new String[]{"xdg-open", var1};
                }

                if (var3 != null) {
                    Runtime var4 = Runtime.getRuntime();

                    try {
                        var4.exec(var3);
                        return true;
                    } catch (IOException var8) {
                        var8.printStackTrace();
                    }
                }
            }
        } catch (RuntimeException var9) {
            var9.printStackTrace();
        }

        return false;
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.netEngine.ingame) {
            ScriptEngine var2 = ScriptEngine.getInstance();
            if (var2 != null) {
                var2.addScriptToQueue("mp.closeBattleroomIfOpen()");
            }
        }

    }

    public void a(EnterPasswordCallback var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        ScriptEngine var3 = ScriptEngine.getInstance();
        if (var3 != null) {
            class_641 var4 = new class_641(this, var3, var1);
            var3.addRunnableToQueue(var4);
        }

    }
}
