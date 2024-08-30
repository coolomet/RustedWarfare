package com.corrodinggames.rts.gameFramework.e;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.class_669;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.e.g
public strictfp class class_698 {
    public static boolean a = true;

    public static final String a(char var0) {
        return String.valueOf(var0);
    }

    public static String a(String var0, char var1) {
        if (class_340.b(var0, var1)) {
            var0 = class_340.decodeTextAsMultiline(var0, String.valueOf(var1), "%" + a(var1));
        }

        return var0;
    }

    public static String a(String var0) {
        if (var0 == null) {
            return "null";
        } else {
            var0 = class_340.decodeTextAsMultiline(var0, "%", "%%");
            var0 = a(var0, '/');
            var0 = a(var0, '\\');
            var0 = a(var0, ':');
            var0 = a(var0, '"');
            var0 = a(var0, '\'');
            var0 = a(var0, '|');
            var0 = a(var0, '?');
            var0 = a(var0, '*');
            var0 = a(var0, '<');
            var0 = a(var0, '>');
            var0 = a(var0, '\u0000');
            //if (var0.contains("/")) {
            //    throw new IllegalArgumentException();
            //} else if (var0.contains("\\")) {
            //    throw new IllegalArgumentException();
            //} else {
                return var0.replace("/", "47").replace("\\", "47");
            //}
        }
    }

    public static String a(String var0, String var1, boolean var2) {
        String var3 = class_697.e();
        String var4 = var3 + a(var0) + ".cachedata";
        if (var2) {
            File var5 = new File(var4);
            if (!var5.isDirectory()) {
                boolean var6 = var5.mkdirs();
                if (!var6) {
                    GameEngine.log("Failed to create folder for:" + var5.getAbsolutePath());
                }
            }
        }

        String var7 = var4 + "/" + a(var1);
        return var7;
    }

    public static boolean a(String var0, String var1, String var2) {
        ByteArrayInputStream var3;
        try {
            var3 = new ByteArrayInputStream(var2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException(var5);
        }

        return a(var0, var1, (InputStream)var3);
    }

    public static boolean a(String var0, String var1, InputStream var2) {
        try {
            String var3 = a(var0, var1, true);
            File var4 = new File(var3);
            File var5 = new File(var3 + ".tmp");
            FileOutputStream var6 = new FileOutputStream(var5);

            try {
                class_340.a((InputStream)var2, (OutputStream)var6);
            } finally {
                var6.close();
            }

            boolean var7 = class_697.a(var5, var4);
            if (!var7) {
                GameEngine.print("AddToCache: Failed to rename to final file: " + var3);
                return false;
            } else {
                if (a) {
                    GameEngine.log("Wrote cache file at: " + var4.getAbsolutePath());
                }

                return true;
            }
        } catch (IOException var11) {
            var11.printStackTrace();
            return false;
        }
    }

    public static FileInputStream a(String var0, String var1) {
        String var2 = a(var0, var1, false);

        try {
            File var3 = new File(var2);
            if (!var3.exists()) {
                return null;
            } else {
                long var4 = System.currentTimeMillis();
                var3.setLastModified(var4);
                FileInputStream var6 = new FileInputStream(var3);
                return var6;
            }
        } catch (IOException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public static String b(String var0, String var1) {
        FileInputStream var2 = a(var0, var1);
        return var2 == null ? null : class_340.a((InputStream)var2);
    }

    public static void c(String var0, String var1) {
        String var2 = a(var0, var1, false);
        File var3 = new File(var2);
        if (var3.exists()) {
            boolean var4 = var3.delete();
            if (!var4) {
                GameEngine.warn("Failed to delete: " + var2);
            }
        }

    }

    private static class_701 b(String var0, String var1, String var2) {
        String var3 = var1 + ".data";
        String var4 = var1 + ".meta";
        String var5 = b(var0, var4);
        if (var5 != null) {
            String[] var6 = class_675.b(var5, ":");
            if (var6 != null) {
                Long var7 = class_340.m(var6[0]);
                long var8 = class_697.m(var1);
                String var10 = var6[1];
                if (var7 == null) {
                    if (a) {
                        GameEngine.log("openAssetCached: Bad meta data for: " + var1);
                    }
                } else if (var7 != var8) {
                    if (a) {
                        GameEngine.log("openAssetCached: Stale timestamp for: " + var1 + " (" + var7 + "!=" + var8 + ")");
                    }
                } else {
                    if (var10.startsWith("null")) {
                        if (a) {
                            GameEngine.log("openAssetCached: Cache hit (null-type) for: " + var1 + " (" + var7 + "!=" + var8 + ")");
                        }

                        return new class_701((InputStream)null);
                    }

                    if (!var10.startsWith(var2)) {
                        if (a) {
                            GameEngine.log("openAssetCached: Unsupported type " + var10 + " for: " + var1 + " expected: " + var2);
                        }

                        return new class_701((InputStream)null);
                    }

                    FileInputStream var11 = a(var0, var3);
                    if (var11 != null) {
                        if (a) {
                            GameEngine.log("openAssetCached: Cache hit for: " + var1);
                        }

                        return new class_701(var11);
                    }

                    if (a) {
                        GameEngine.log("openAssetCached: meta file but not data for: " + var1);
                    }
                }
            }
        }

        return null;
    }

    public static String[] d(String var0, String var1) {
        if (!class_669.i(var1)) {
            return class_697.h(var1);
        } else {
            String var2 = var1 + ".data";
            String var3 = var1 + ".meta";
            String var4 = "list";
            class_701 var5 = b(var0, var1, "list");
            if (var5 != null) {
                if (var5.a == null) {
                    return null;
                } else {
                    String var11 = class_340.a(var5.a);
                    var5.a();
                    return class_675.e(var11);
                }
            } else {
                String[] var6 = class_697.h(var1);
                String var7;
                long var8;
                if (var6 != null) {
                    if (a) {
                        GameEngine.log("listDirCached: Listing count: " + var6.length);
                    }

                    var7 = "list";
                    var8 = class_697.m(var1);
                    if (var8 == 0L) {
                        if (a) {
                            GameEngine.log("openAssetCached: Got 0 timestamp for: " + var1 + " cannot cache");
                        }

                        return var6;
                    }

                    a(var0, var2, class_675.a(var6));
                } else {
                    if (a) {
                        GameEngine.log("listDirCached: Null");
                    }

                    var7 = "null";
                    var8 = class_697.m(var1);
                }

                String var10 = var8 + ":" + var7;
                a(var0, var3, var10);
                return var6;
            }
        }
    }

    public static InputStream e(String var0, String var1) {
        String var2 = var1 + ".data";
        String var3 = var1 + ".meta";
        String var4 = "data";
        class_701 var5 = b(var0, var1, "data");
        if (var5 != null) {
            return var5.a;
        } else {
            if (a) {
                GameEngine.log("openAssetCached: Cache miss for: " + var1);
            }

            AssetInputStream var6 = class_697.k(var1);
            String var7;
            long var8;
            if (var6 != null) {
                if (a) {
                    GameEngine.log("openAssetCached: Reading: " + var1);
                }

                var7 = "data";
                var8 = class_697.m(var1);
                if (var8 == 0L) {
                    if (a) {
                        GameEngine.log("openAssetCached: Got 0 timestamp for: " + var1 + " cannot cache");
                    }

                    return var6;
                }

                if (!a(var0, var2, (InputStream)var6)) {
                }
            } else {
                if (a) {
                    GameEngine.log("openAssetCached: Got null for: " + var1);
                }

                var7 = "null";
                var8 = class_697.m(var1);
            }

            String var10 = var8 + ":" + var7;
            a(var0, var3, var10);
            if (var6 == null) {
                return null;
            } else {
                try {
                    var6.close();
                } catch (Exception var12) {
                    var12.printStackTrace();
                }

                FileInputStream var11 = a(var0, var2);
                if (var11 == null) {
                    GameEngine.print("openAssetCached: Error. Failed to reopen cache: " + var1);
                    return class_697.k(var1);
                } else {
                    return var11;
                }
            }
        }
    }

    public static boolean f(String var0, String var1) {
        InputStream var2 = e(var0, var1);
        if (var2 == null) {
            return false;
        } else {
            try {
                var2.close();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            return true;
        }
    }
}
