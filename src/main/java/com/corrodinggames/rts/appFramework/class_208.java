package com.corrodinggames.rts.appFramework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $FF: renamed from: com.corrodinggames.rts.appFramework.c
public strictfp class class_208 {
    static Handler a;
    static volatile Context b;
    public static final class_205 c;
    public static class_205 d;

    public static int a(String var0) {
        String var1 = null;
        if (var0 != null) {
            var1 = class_340.k(var0);
        }

        if (var1 != null) {
            Pattern var2 = Pattern.compile("^ *\\[([^\\]]*)\\].*");
            Matcher var3 = var2.matcher(var1);
            if (var3.matches()) {
                String var4 = var3.group(1);
                String[] var5 = var4.split(";");
                String[] var6 = var5;
                int var7 = var5.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    String var9 = var6[var8];
                    if (var9.startsWith("p") && var9.length() >= 2) {
                        String var10 = var9.substring(1);

                        try {
                            int var11 = Integer.parseInt(var10);
                            return var11;
                        } catch (NumberFormatException var13) {
                            GameEngine.log("getNumberOfPlayersInMap: NumberFormatException:" + var10);
                            return -1;
                        }
                    }
                }
            }
        }

        GameEngine.log("getNumberOfPlayersInMap: fail to match:" + var1);
        return -1;
    }

    public static String b(String var0) {
        if (var0 == null) {
            return null;
        } else {
            String[] var1;
            if (var0.contains(File.separator)) {
                var1 = var0.split(Pattern.quote(File.separator));
                var0 = var1[var1.length - 1];
            }

            if (var0.contains("/")) {
                var1 = var0.split("/");
                var0 = var1[var1.length - 1];
            }

            String var4 = null;
            Pattern var2;
            Matcher var3;
            if (var4 == null) {
                var2 = Pattern.compile("^l\\d*;\\[.*\\](.+)\\.tmx");
                var3 = var2.matcher(var0);
                if (var3.matches()) {
                    var4 = var3.group(1);
                    if (var4.length() >= 1) {
                        var4 = var4.substring(0, 1).toUpperCase() + var4.substring(1);
                    }
                }
            }

            if (var4 == null) {
                var2 = Pattern.compile("^l\\d*;(.+)\\.tmx");
                var3 = var2.matcher(var0);
                if (var3.matches()) {
                    var4 = var3.group(1);
                    if (var4.length() >= 1) {
                        var4 = var4.substring(0, 1).toUpperCase() + var4.substring(1);
                    }
                }
            }

            if (var4 == null) {
                var2 = Pattern.compile("^ *\\[.*\\](.+)\\.tmx");
                var3 = var2.matcher(var0);
                if (var3.matches()) {
                    var4 = var3.group(1);
                    if (var4.length() >= 1) {
                        var4 = var4.substring(0, 1).toUpperCase() + var4.substring(1);
                    }
                }
            }

            if (var4 == null) {
                var2 = Pattern.compile("(.*)\\.tmx");
                var3 = var2.matcher(var0);
                if (var3.matches()) {
                    var4 = var3.group(1);
                    if (var4.length() >= 1) {
                        var4 = var4.substring(0, 1).toUpperCase() + var4.substring(1);
                    }
                }
            }

            if (var4 == null) {
                var4 = var0;
            }

            var4 = var4.replace('_', ' ');
            if (var4.endsWith(".rwsave")) {
                var4 = var4.replace(".rwsave", "");
            }

            return var4;
        }
    }

    public static String c(String var0) {
        String var1 = var0.replace(".tmx", "");
        var1 = var1 + "_map.png";
        return var1;
    }

    private static void c(Activity var0) {
        if (VERSION.SDK_INT >= 19) {
            var0.a().getDecorView().setSystemUiVisibility(5894);
        }

    }

    private static void d(Activity var0) {
    }

    public static void a(Runnable var0) {
        if (a == null) {
            a = new Handler(Looper.b());
        }

        a.a(var0);
    }

    public static Context a() {
        if (b == null) {
            throw new RuntimeException("ApplicationContext==null");
        } else {
            return b;
        }
    }

    public static void a(Activity var0) {
        if (b == null) {
            b = var0.g();
        }

    }

    public static void a(Context var0) {
        if (b == null) {
            b = var0.g();
        }

    }

    public static void a(Activity var0, boolean var1, boolean var2) {
        a(var0);
        GameEngine var3;
        if (var2) {
            var3 = GameEngine.getGameEngine();
            if (var3 != null && var3.settingsEngine.immersiveFullScreen) {
                c(var0);
            }
        } else {
            d(var0);
        }

        var3 = GameEngine.getGameEngine();
        if (var3 != null) {
            var3.ab();
        }

        if (var1) {
            var0.a().setBackgroundDrawable((Drawable)null);
        }

    }

    public static void a(Activity var0, boolean var1) {
        if (var1) {
            var0.a(0, 0);
        }

    }

    public static boolean a(Activity var0, Runnable var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = a(var0, var1, false);
        return var3;
    }

    public static boolean a(Activity var0, Runnable var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        if (!var2 && var3.settingsEngine.hasSelectedAStorageType) {
            return false;
        } else if (VERSION.SDK_INT < 19) {
            return false;
        } else {
            class_1061 var4 = new class_1061(var3, var1);
            class_1060 var5 = new class_1060(var0, var3, var1);
            String var6 = class_1009.a("menus.mods.androidStorageSetupTitle");
            String var7 = class_1009.a("menus.mods.androidStorageSetupMessage");
            String var8 = class_1009.a("menus.mods.androidStorageSetupInternal");
            String var9 = class_1009.a("menus.mods.androidStorageSetupExternal");
            (new AlertDialog.Builder(var0)).setIcon(17301543).setTitle(var6).setMessage(var7).setPositiveButton(var8, var4).setNeutralButton(var9, var5).show();
            GameEngine.log("Showing storage setup");
            return true;
        }
    }

    public static boolean b(Context var0) {
        if (GameEngine.isModsInSD) {
            return true;
        } else if (!class_697.f()) {
            return true;
        } else if (VERSION.SDK_INT >= 23) {
            return ContextCompat.a(var0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        } else {
            return true;
        }
    }

    public static boolean b(Activity var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        if (GameEngine.isModsInSD) {
            return true;
        } else if (!class_697.f()) {
            return true;
        } else if (VERSION.SDK_INT >= 23) {
            if (var1.aD() == null) {
            }

            if (ContextCompat.a(var0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                var1.settingsEngine.hadStoragePermissionInPast = true;
                GameEngine.log("File Permission is granted");
                return true;
            } else {
                GameEngine.log("Permission is revoked");
                ActivityCompat.a(var0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                return false;
            }
        } else {
            return true;
        }
    }

    public static void a(Intent var0) {
        var0.addFlags(65536);
    }

    public static void a(Activity var0, int var1, boolean var2, String var3, Uri var4) {
        GameEngine.log("Show folder chooser. Write:" + var2);
        Intent var5 = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        var5.addFlags(64);
        var5.addFlags(1);
        if (var2) {
            var5.addFlags(2);
        }

        if (var4 != null) {
            var5.putExtra("android.provider.extra.INITIAL_URI", var4);
        }

        var5.putExtra("android.content.extra.SHOW_ADVANCED", true);

        try {
            var0.a(Intent.createChooser(var5, var3), var1);
        } catch (ActivityNotFoundException var7) {
            Toast.makeText(var0, "Failed to open file list. Please install a File Manager.", 0).show();
        }

    }

    static {
        c = class_205.DYNAMIC_DEFAULT;
        d = c;
    }
}
