package com.corrodinggames.rts.appFramework;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Spanned;
import android.widget.EditText;
import android.widget.TextView;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_337;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.net.EnterPasswordCallback;
import com.corrodinggames.rts.gameFramework.net.MapType;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.appFramework.n
public strictfp class class_195 extends class_194 {
    public static class_195 c;
    boolean d;
    // maybe error
    Handler e;
    public static boolean f = false;
    public boolean g;
    TextView h;
    private Handler k;
    private Runnable l;
    private Runnable m;
    static EnterPasswordCallback i;
    static AlertDialog j;

    public static boolean l() {
        return c == null ? false : c.g;
    }

    public static void m() {
        if (c != null) {
            class_195 var0 = c;
            class_709 var1 = new class_709(var0);
            c.e.a((Runnable)var1);
        }

    }

    public static void d(String var0) {
        class_195 var1 = c;
        if (var1 != null) {
            Message var2 = var1.k.a();
            var2.d().putString("text", var0);
            var1.k.c(var2);
        }
    }

    void n() {
        if (!this.d) {
            GameEngine.print("addMessageToChatLogInternal: !onCreateFinished");
        } else {
            GameEngine var1 = GameEngine.getGameEngine();
            Spanned var2 = var1.netEngine.aC.b(true);
            if (this.h == null) {
                throw new RuntimeException("chatLog==null");
            } else if (var2 == null) {
                throw new RuntimeException("chatLogHTML==null");
            } else {
                try {
                    this.h.clearFocus();
                    this.h.setTextKeepState(var2);
                } catch (NullPointerException var4) {
                    GameEngine.a((String)"chatLog.setText error", (Throwable)var4);
                    var1.log("chatLog.setText error", 1);
                }

            }
        }
    }

    public static void a(String var0, String var1) {
        if (c != null) {
            class_195 var2 = c;
            class_708 var3 = new class_708(var2, var1);
            c.e.a((Runnable)var3);
        }

    }

    public static void o() {
        GameEngine var0 = GameEngine.getGameEngine();
        if (var0.netEngine != null) {
            var0.netEngine.O();
            var0.netEngine.d.c();
        }

        if (!GameEngine.isModsInSD) {
            if (var0.netEngine == null || !var0.netEngine.ingame) {
                if (c != null) {
                    c.e.a(c.l);
                } else {
                    GameEngine.print("MultiplayerBattleroomActivity:updateUI() lastLoaded==null");
                }

            }
        }
    }

    public static void p() {
        if (c != null) {
            c.e.a(c.m);
            f = false;
        } else {
            GameEngine.print("MultiplayerBattleroomActivity:startGame() lastLoaded==null");
            GameEngine.T();
            f = true;
        }

    }

    public static void q() {
        class_211 var0 = new class_211("Starting unit count");
        class_211 var1 = new class_211("Total unit HP");
        class_211 var2 = new class_211("Team Credits");
        Iterator var3 = PlayerData.c().iterator();

        while(var3.hasNext()) {
            PlayerData var4 = (PlayerData)var3.next();
            int var5 = 0;
            int var6 = 0;
            Unit[] var7 = Unit.bE.a();
            int var8 = 0;

            for(int var9 = Unit.bE.size(); var8 < var9; ++var8) {
                Unit var10 = var7[var8];
                if (var10.bX == var4) {
                    ++var5;
                    var6 = (int)((float)var6 + var10.health);
                }
            }

            if (var5 != 0) {
                var0.a(var4, var5);
                var1.a(var4, var6);
                var2.a(var4, (int)var4.credits);
            }
        }

        if (!var0.a()) {
            var1.a();
        }

        var2.a();
    }

    public static void r() {
        GameEngine var0 = GameEngine.getGameEngine();
        var0.dm = null;
        if (var0.netEngine.gameMapData.mapType == MapType.savedGame) {
            if (!var0.netEngine.isServer) {
                var0.ca.a(var0.netEngine.aA, true, false, false);
                var0.bS.h.a((String)null, "Note: Game was started from a saved game.");
            } else {
                var0.ca.c(var0.netEngine.gameMapData.mapName, true);
            }

            q();
        } else if (var0.netEngine.gameMapData.mapType == MapType.customMap) {
            if (!var0.netEngine.isServer) {
                var0.dl = "";
                var0.dm = var0.netEngine.aB;
                var0.a(true, class_337.NORMAL);
                var0.bS.h.a((String)null, "Note: Game was started from a custom map on server.");
            } else {
                var0.dl = var0.netEngine.az;
                var0.a(true, class_337.NORMAL);
            }

            q();
        } else {
            var0.dl = var0.netEngine.az;
            var0.a(true, class_337.NORMAL);
        }

    }

    public static void a(EnterPasswordCallback var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        Context var2 = var1.aD();
        AlertDialog.Builder var3 = new AlertDialog.Builder(var2);
        String var4 = "Password Required";
        String var5 = "This server requires a password to join";
        if (var0.b != null) {
            var4 = "Server Question";
            var5 = var0.b;
            var5 = class_1009.c(var5);
        }

        if (var0.e != null) {
            var4 = var0.e;
        }

        var3.setTitle(var4);
        var3.setMessage(var5);
        EditText var6 = new EditText(var3.getContext());
        var3.setView(var6);
        if (var0.b != null) {
            var6.setHint("Enter text...");
        } else {
            var6.setHint("Enter password...");
        }

        var3.setPositiveButton(var0.f != null ? var0.f : "Submit", new class_707(var6, var0));
        var3.setNegativeButton(var0.g != null ? var0.g : "Disconnect", new class_706(var0));
        var3.setOnCancelListener(new class_705(var0));
        AlertDialog var7 = j;
        if (var7 != null) {
            try {
                var7.dismiss();
            } catch (IllegalArgumentException var9) {
                var9.printStackTrace();
            }
        }

        AlertDialog var8 = var3.show();
        i = var0;
        j = var8;
        var6.requestFocus();
    }
}
