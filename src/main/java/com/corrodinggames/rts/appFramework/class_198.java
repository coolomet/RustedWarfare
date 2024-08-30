package com.corrodinggames.rts.appFramework;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.corrodinggames.rts.AssetsID$id;
import com.corrodinggames.rts.AssetsID$layout;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;

// $FF: renamed from: com.corrodinggames.rts.appFramework.g
public strictfp class class_198 extends class_194 {
    class_0 c;
    final Handler d = new Handler(Looper.b());
    ProgressDialog e;
    boolean f = true;

    public void b() {
        GameEngine.log("IngameActivity: finish");
        super.b();
        class_208.a(this, true);
    }

    public void onWindowFocusChanged(boolean var1) {
        super.onWindowFocusChanged(var1);
        if (var1) {
            class_208.a(this, false, true);
        }

        this.c.a(var1);
    }

    public boolean a(Menu var1) {
        super.a(var1);
        var1.clear();
        GameEngine var2 = GameEngine.getGameEngine();
        var1.add(0, 12, 0, class_1009.a("menus.ingame.save")).setIcon(17301582);
        if (var2.bv && !GameEngine.aZ) {
            var1.add(0, 18, 0, class_1009.a("menus.ingame.exportMap")).setIcon(17301582);
        }

        var1.add(0, 2, 0, class_1009.a("menus.ingame.settings")).setIcon(17301577);
        if (!var2.N()) {
        }

        if (var2.replayEngine != null && var2.replayEngine.j()) {
            var1.add(0, 22, 0, class_1009.a("menus.ingame.hideInterface")).setIcon(17301584);
        }

        if (var2.N()) {
            var1.add(0, 13, 0, class_1009.a("menus.ingame.chat")).setIcon(17301584);
            var1.add(0, 14, 0, class_1009.a("menus.ingame.players")).setIcon(17301661);
            if (var2.netEngine.isServer && SteamEngine.getSteamEngine().e()) {
                var1.add(0, 17, 0, class_1009.a("menus.ingame.steam_reinvite")).setIcon(17301584);
            }

            boolean var3 = false;
            if (var2.playerTeam != null && var2.playerTeam.G) {
                var3 = true;
            }

            if (!var3 && !var2.dq) {
                var1.add(0, 19, 0, class_1009.a("menus.ingame.surrender")).setIcon(17301552);
            }

            if (!var2.netEngine.isServer) {
                var1.add(0, 10, 0, class_1009.a("menus.ingame.disconnect")).setIcon(17301552);
            } else {
                var1.add(0, 10, 0, class_1009.a("menus.ingame.exitGame")).setIcon(17301552);
            }
        } else {
            if (var2.ce != null && var2.ce.h != null) {
                var1.add(0, 11, 0, class_1009.a("menus.ingame.briefing")).setIcon(17301659);
            }

            var1.add(0, 15, 0, class_1009.a("menus.ingame.exitGame")).setIcon(17301552);
        }

        if (var2 != null && var2.settingsEngine.allowGameRecording) {
            if (!var2.bo) {
                var1.add(0, 9, 0, "Start Recording");
            } else {
                var1.add(0, 9, 0, "Stop Recording");
            }
        }

        return true;
    }

    public void c(int var1) {
        GameEngine.log("outer selectMenuOption: " + var1);
        class_1029 var2 = new class_1029(this, var1);
        this.d.a((Runnable)var2);
    }

    public void d(int var1) {
        GameEngine var3;
        switch (var1) {
            case 2:
                Intent var2 = new Intent(this.k(), class_202.class);
                this.a(var2, 0);
                break;
            case 3:
                (new AlertDialog.Builder(this)).setIcon(17301543).setTitle("Skip?").setMessage("Are you sure you want to skip this level?").setPositiveButton("Yes", new class_1030(this)).setNegativeButton("No", (DialogInterface.OnClickListener)null).show();
                break;
            case 4:
                GameEngine.getGameEngine().ch = !GameEngine.getGameEngine().ch;
                break;
            case 5:
                (new AlertDialog.Builder(this)).setIcon(17301543).setTitle("Restart?").setMessage("Are you sure you want to restart this level?").setPositiveButton("Yes", new class_554(this)).setNegativeButton("No", (DialogInterface.OnClickListener)null).show();
                break;
            case 6:
                var3 = GameEngine.getGameEngine();
                var3.bl = !var3.bl;
            case 7:
            case 8:
            case 17:
            default:
                break;
            case 9:
                var3 = GameEngine.getGameEngine();
                if (!var3.bo) {
                    var3.bo = true;
                } else {
                    var3.bo = false;
                }
                break;
            case 10:
                var3 = GameEngine.getGameEngine();
                String var8 = class_1009.a("menus.ingame.multiplayerClose.titleDisconnect");
                String var5 = class_1009.a("menus.ingame.multiplayerClose.messageDisconnect");
                String var6 = class_1009.a("menus.ingame.multiplayerClose.disconnectButton");
                if (var3.netEngine.isServer) {
                    var8 = class_1009.a("menus.ingame.multiplayerClose.title");
                    var5 = class_1009.a("menus.ingame.multiplayerClose.messageEndGame");
                    var6 = class_1009.a("menus.ingame.exitGame");
                }

                AlertDialog.Builder var7 = (new AlertDialog.Builder(this)).setIcon(17301543).setTitle(var8).setMessage(var5).setPositiveButton(var6, new class_555(this)).setNegativeButton(class_1009.a("menus.common.back"), (DialogInterface.OnClickListener)null);
                if (var3.netEngine.isServer) {
                    var7.setNeutralButton(class_1009.a("menus.ingame.multiplayerClose.returnToBattleroom"), new class_556(this));
                }

                var7.show();
                break;
            case 11:
                var3 = GameEngine.getGameEngine();
                if (var3.ce != null && var3.ce.h != null) {
                    var3.a("Briefing", var3.ce.h);
                }
                break;
            case 12:
                class_557 var4 = new class_557(this, this);
                if (!class_208.a(this, var4)) {
                    var4.run();
                }
                break;
            case 13:
                this.a(false);
                break;
            case 14:
                var3 = GameEngine.getGameEngine();
                if (var3.netEngine != null) {
                    var3.netEngine.H();
                }
                break;
            case 15:
                (new AlertDialog.Builder(this)).setIcon(17301543).setTitle("Exit?").setMessage("Are you sure you want to exit this game?").setPositiveButton("Yes", new class_559(this)).setNegativeButton("No", (DialogInterface.OnClickListener)null).show();
                break;
            case 16:
                this.a(true);
                break;
            case 18:
                if (class_208.b((Activity)this)) {
                    this.e((String)null);
                }
                break;
            case 19:
                (new AlertDialog.Builder(this)).setIcon(17301543).setTitle("Disconnect?").setMessage("Are you sure you want to surrender this game?").setPositiveButton("Surrender", new class_558(this)).setNegativeButton("No", (DialogInterface.OnClickListener)null).show();
                break;
            case 20:
                this.b();
                break;
            case 21:
                this.b();
                class_195.o();
                class_195.m();
                break;
            case 22:
                var3 = GameEngine.getGameEngine();
                var3.cU = true;
                var3.bS.u = false;
                break;
            case 23:
                GameEngine.log("TODO display leaderboard settings");
        }

    }

    private void a(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        AlertDialog.Builder var3 = new AlertDialog.Builder(this);
        if (!var1) {
            var3.setTitle("Send Message");
        } else {
            var3.setTitle("Send Team Message");
        }

        LayoutInflater var4 = LayoutInflater.from(this);
        View var5 = var4.inflate(AssetsID$layout.alert_chat, (ViewGroup)null);
        var3.setView(var5);
        TextView var6 = (TextView)var5.findViewById(AssetsID$id.chat_messages);
        EditText var7 = (EditText)var5.findViewById(AssetsID$id.chat_text);
        var6.setText(var2.netEngine.aC.a());
        var7.setText("");
        var7.requestFocus();
        var3.setPositiveButton(var1 ? "Send Team" : "Send", new class_560(this, var7, var1));
        var3.setNeutralButton("Send & Ping Map", new class_1028(this, var7, var1));
        var3.setNegativeButton("Cancel", new class_1027(this));
        var3.show();
    }

    private void e(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        AlertDialog.Builder var3 = new AlertDialog.Builder(this);
        var3.setTitle("Export Map");
        var3.setMessage("Enter a name to export the map as");
        EditText var4 = new EditText(this);
        if (var1 == null) {
            String var5 = class_340.a("d MMM yyyy");
            var5 = var5.replace(".", "");
            String var6 = "New " + var2.al() + " (" + var5 + " " + class_340.a("HH.mm.ss") + ")";
            var6 = var6.replace("  ", " ");
            var4.setText(var6);
        } else {
            var4.setText(var1);
        }

        var3.setView(var4);
        var3.setPositiveButton("Ok", new class_1026(this, var4, var2));
        var3.setNegativeButton("Cancel", new class_1025(this));
        var3.show();
    }

    private void f(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        AlertDialog.Builder var3 = new AlertDialog.Builder(this);
        var3.setTitle("Save Game");
        var3.setMessage("Enter a name to save the game under");
        EditText var4 = new EditText(this);
        if (var1 == null) {
            String var5 = class_340.a("d MMM yyyy");
            var5 = var5.replace(".", "");
            var4.setText(var2.al() + " (" + var5 + " " + class_340.a("HH.mm.ss") + ")");
        } else {
            var4.setText(var1);
        }

        var3.setView(var4);
        var3.setPositiveButton("Ok", new class_1024(this, var4));
        var3.setNegativeButton("Cancel", new class_1023(this));
        var3.show();
    }

    public void d(String var1) {
        this.a(0);
        class_203 var2 = new class_203(this);
        var2.a = var1;
        (new Thread(var2)).start();
    }

    public void l() {
        class_1031 var1 = new class_1031(this);
        this.d.a((Runnable)var1);
    }

    private void n() {
        try {
            Intent var1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.corrodinggames.rts"));
            this.a((Intent)var1);
        } catch (ActivityNotFoundException var5) {
            String var2 = "Failed to open Android Market";
            byte var3 = 0;
            Toast var4 = Toast.makeText(this.g(), var2, var3);
            var4.show();
        }

    }

    public void m() {
    }

    // $FF: synthetic method
    static void a(class_198 var0, String var1) {
        var0.f(var1);
    }

    // $FF: synthetic method
    static void b(class_198 var0, String var1) {
        var0.e(var1);
    }

    // $FF: synthetic method
    static void a(class_198 var0) {
        var0.n();
    }
}
