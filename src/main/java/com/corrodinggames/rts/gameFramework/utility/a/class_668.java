package com.corrodinggames.rts.gameFramework.utility.a;

import android.net.Uri;
import com.corrodinggames.rts.appFramework.android.AndroidSAF;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.utility.class_667;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.a.a
public strictfp class class_668 extends class_667 {
    static AndroidSAF a = AndroidSAF.getInstance();
    static HashMap b = new HashMap();
    public static int c = 1;

    public static void h(String var0) {
        GameEngine.log("Saf: " + var0);
    }

    public static void i(String var0) {
    }

    public static void j(String var0) {
        GameEngine.log("Saf: " + var0);
    }

    public static void k(String var0) {
    }

    public static boolean l(String var0) {
        return var0.contains(".[saflink]/") || var0.contains(".[saflink]\\") || var0.endsWith(".[saflink]");
    }

    public static String m(String var0) {
        int var1 = var0.indexOf(".[saflink]/");
        int var2 = var0.indexOf(".[saflink]\\");
        if (var2 != -1 && (var2 < var1 || var1 == -1)) {
            var1 = var2;
        }

        if (var1 == -1 && var0.endsWith(".[saflink]")) {
            var1 = var0.length() - ".[saflink]".length();
        }

        if (var1 == -1) {
            throw new RuntimeException("Could not find saf link in path: " + var0);
        } else {
            return var0.substring(0, var1 + ".[saflink]".length());
        }
    }

    public static class_1008 d(String var0, boolean var1) {
        String var2 = m(var0);
        synchronized(b) {
            class_1008 var4 = (class_1008)b.get(var2);
            if (var4 == null) {
                class_697.b("Folder link no longer open");
                return null;
            } else {
                return var4;
            }
        }
    }

    public void a() {
        synchronized(b) {
            Iterator var2 = b.values().iterator();

            while(var2.hasNext()) {
                class_1008 var3 = (class_1008)var2.next();
                var3.a();
            }

        }
    }

    public static String a(Uri var0, boolean var1) {
        GameEngine.log("createSAFLink: " + var0);
        synchronized(b) {
            String var3 = "/saf-virtual/" + c + ".[saflink]";
            ++c;
            class_1008 var4 = a(var0, var1, var3);
            return var4 == null ? null : var3;
        }
    }

    public static class_1008 a(Uri var0, boolean var1, String var2) {
        GameEngine.log("createSAFLink: " + var0 + " to " + var2);
        synchronized(b) {
            class_1008 var4 = (class_1008)b.get(var2);
            if (var4 != null) {
                GameEngine.print("createSAFLink: Already open");
            }

            class_1008 var5 = new class_1008(var0, var1);

            try {
                var5.b();
            } catch (Exception var8) {
                var8.printStackTrace();
                class_697.b("Failed to list files: " + var8.getMessage());
                return null;
            }

            b.put(var2, var5);
            return var5;
        }
    }

    public static String n(String var0) {
        String var1 = m(var0);
        String var2 = var0.substring(var1.length());
        if (var2.startsWith("/") || var2.startsWith("\\")) {
            var2 = var2.substring(1);
        }

        if (var2.startsWith("/") || var2.startsWith("\\")) {
            var2 = var2.substring(1);
        }

        if (var2.contains("\\")) {
            var2 = var2.replace("\\", "/");
        }

        if (var2.contains("..")) {
            String[] var3 = class_340.c(var2, '/');
            ArrayList var4 = new ArrayList(var3.length);
            int var5 = 0;

            for(int var6 = var3.length - 1; var6 >= 0; --var6) {
                if (var3[var6].equals("..")) {
                    ++var5;
                } else if (var5 > 0) {
                    --var5;
                } else {
                    var4.add(0, var3[var6]);
                }
            }

            if (var5 != 0) {
                j("getPathInZip: Backtracking attempt out of zip: " + var2);
            }

            var2 = class_340.a((CharSequence)"/", (Iterable)var4);
        }

        return var2;
    }

    public boolean a(String var1) {
        if (!var1.endsWith(".[saflink]") && !var1.endsWith(".[saflink]/") && !var1.endsWith(".[saflink]\\")) {
            class_1008 var2 = d(var1, true);
            if (var2 == null) {
                h("fileExists failed to open for: " + var1);
                return false;
            } else {
                try {
                    return var2.a(n(var1));
                } catch (Exception var4) {
                    i("fileExists failed for: " + var1);
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    public String f(String var1) {
        if (!var1.endsWith(".[saflink]") && !var1.endsWith(".[saflink]/") && !var1.endsWith(".[saflink]\\")) {
            class_1008 var2 = d(var1, true);
            if (var2 == null) {
                j("convertAbstractPathForDebug failed for: " + var1);
                return var1;
            } else {
                return var2.c + "/" + n(var1);
            }
        } else {
            return var1;
        }
    }

    public boolean d(String var1) {
        if (!var1.endsWith(".[saflink]") && !var1.endsWith(".[saflink]/") && !var1.endsWith(".[saflink]\\")) {
            class_1008 var2 = d(var1, true);
            if (var2 == null) {
                return false;
            } else {
                try {
                    return var2.h(n(var1));
                } catch (Exception var4) {
                    i("isDirectory failed for: " + var1);
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    public boolean e(String var1) {
        if (!var1.endsWith(".[saflink]") && !var1.endsWith(".[saflink]/") && !var1.endsWith(".[saflink]\\")) {
            class_1008 var2 = d(var1, true);
            if (var2 == null) {
                j("createDirectory failed for: " + var1);
                return false;
            } else {
                try {
                    return var2.j(n(var1));
                } catch (Exception var5) {
                    var5.printStackTrace();
                    return false;
                }
            }
        } else {
            i("createDirectory on root path: " + var1);
            return false;
        }
    }

    public String[] b(String var1) {
        class_1008 var2 = d(var1, true);
        if (var2 == null) {
            return null;
        } else {
            try {
                return var2.g(n(var1));
            } catch (Exception var4) {
                var4.printStackTrace();
                class_697.b("Failed to open saf, " + var4.getMessage());
                return null;
            }
        }
    }

    public long a(String var1, boolean var2) {
        class_1008 var3 = d(var1, var2);
        if (var3 == null) {
            j("saf==null: for '" + var1 + "'");
            return -1L;
        } else {
            String var4 = n(var1);
            long var5 = var3.d(var4);
            return var5;
        }
    }

    public AssetInputStream b(String var1, boolean var2) {
        class_1008 var3 = d(var1, var2);
        if (var3 == null) {
            j("openAssetSteam: saf==null: for '" + var1 + "'");
            return null;
        } else {
            String var4 = n(var1);

            AssetInputStream var5;
            try {
                var5 = var3.b(var4);
            } catch (Exception var7) {
                var7.printStackTrace();
                j("Error opening: '" + var4 + "' in: '" + var1 + "'");
                return null;
            }

            if (var5 == null) {
                k("openAssetSteam: Failed to find: '" + var4 + "' in: '" + var1 + "'");
            }

            return var5;
        }
    }

    public long g(String var1) {
        class_1008 var2 = d(var1, true);
        if (var2 == null) {
            h("saf==null: for '" + var1 + "'");
            return 0L;
        } else {
            String var3 = n(var1);

            try {
                long var4 = var2.c(var3);
                return var4;
            } catch (Exception var7) {
                var7.printStackTrace();
                return 0L;
            }
        }
    }

    public OutputStream c(String var1, boolean var2) {
        class_1008 var3 = d(var1, true);
        if (var3 == null) {
            return null;
        } else {
            String var4 = n(var1);
            OutputStream var5 = var3.a(var4, var2);
            if (var5 == null) {
                j("Failed to find: '" + var4 + "' in: '" + var1 + "'");
            }

            return var5;
        }
    }

    public boolean a(String var1, String var2) {
        h("Rename: " + var1 + " to " + var2);
        class_1008 var3 = d(var1, true);
        if (var3 == null) {
            return false;
        } else {
            String var4 = n(var1);
            String var5 = n(var2);
            i("Relative path: " + var4 + " to " + var5);
            return var3.a(var4, var5);
        }
    }

    public boolean c(String var1) {
        h("deleteFile: " + var1);
        class_1008 var2 = d(var1, true);
        if (var2 == null) {
            j("saf==null: for deleteFile: '" + var1 + "'");
            return false;
        } else {
            String var3 = n(var1);
            return var2.e(var3);
        }
    }
}
