package com.corrodinggames.rts.gameFramework.utility.a;

import android.content.Context;
import android.net.Uri;
import com.corrodinggames.rts.appFramework.class_208;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.a.b
class class_1008 {
    Uri a;
    Uri b;
    String c;
    boolean d;
    class_1011 e;
    boolean f = false;
    int g = 1;

    public class_1008(Uri var1, boolean var2) {
        this.a = var1;
        this.b = class_668.a.buildDocumentUriUsingTree(var1);
        this.c = class_668.a.getReadablePath(this.c(), var1);
        this.d = var2;
        class_668.h("== new SafLink write:" + var2 + " ==");
        class_668.h("root:" + this.a);
        class_668.h("rootDocument:" + this.b);
        class_668.h("shownUrl:" + this.c);
        this.e = new class_1011(this, "", this.b, true);
    }

    public void a() {
        this.f = true;
        ++this.g;
    }

    @SneakyThrows
    public void b() {
        class_668.h("== testRoot ==");
        class_668.a.listWithDetails(this.c(), this.b);
    }

    public Context c() {
        return class_208.a();
    }

    public boolean a(String var1) {
        boolean var2 = false;
        if ("mod-info.txt".equals(var1)) {
            var2 = true;
        }

        if (var2) {
            return class_668.a.exists(this.c(), this.f(var1));
        } else {
            class_1011 var3 = this.k(var1);
            return var3 != null;
        }
    }

    public AssetInputStream b(String var1) {
        boolean var3 = false;
        if ("mod-info.txt".equals(var1)) {
            var3 = true;
        }

        Uri var2;
        if (!var3) {
            class_1011 var4 = this.k(var1);
            if (var4 == null) {
                return null;
            }

            var2 = var4.b;
        } else {
            var2 = this.f(var1);
        }

        if (var2 == null) {
            return null;
        } else {
            InputStream var8;
            try {
                var8 = class_668.a.read(this.c(), var2);
            } catch (FileNotFoundException var6) {
                class_668.j("openAssetSteam: " + var6.getMessage() + " (file: " + var1 + ")");
                return null;
            } catch (IllegalArgumentException var7) {
                class_668.j("openAssetSteam: " + var7.getMessage() + " (file: " + var1 + ")");
                return null;
            }

            if (var8 == null) {
                return null;
            } else {
                AssetInputStream var5 = new AssetInputStream(var8, this.a + "/" + var1);
                return var5;
            }
        }
    }

    @SneakyThrows
    public long c(String var1) {
        Uri var2 = this.f(var1);
        if (var2 == null) {
            class_668.h("getLastModified file missing: " + var1);
            return 0L;
        } else {
            long var3 = class_668.a.getLastModified(this.c(), var2);
            return var3;
        }
    }

    public long d(String var1) {
        Uri var2 = this.f(var1);
        if (var2 == null) {
            class_668.h("getEntrySize file missing: " + var1);
            return -1L;
        } else {
            long var3 = class_668.a.getFileSize(this.c(), var2);
            return var3;
        }
    }

    public OutputStream a(String var1, boolean var2) {
        class_668.i("writableOutputSteam:" + var1);
        Uri var3 = this.f(var1);
        String var5;
        if (var3 == null) {
            File var4 = new File(var1);
            var5 = var4.getName();
            Uri var6 = this.i(var1);
            class_668.i("writableOutputSteam creating: " + var5 + " in " + var6);
            if (var6 == null) {
                class_668.j("writableOutputSteam: Parent folder not found for: " + var1);
                return null;
            }

            try {
                var3 = class_668.a.createFile(this.c(), var6, "", var5);
                class_668.i("newFileUri: " + var3);
            } catch (FileNotFoundException var8) {
                var8.printStackTrace();
                return null;
            }
        }

        OutputStream var10;
        try {
            var5 = "w";
            if (var2) {
                var5 = "wa";
            }

            var10 = class_668.a.write(this.c(), var3, var5);
        } catch (FileNotFoundException var9) {
            var9.printStackTrace();
            return null;
        }

        this.a();
        return var10;
    }

    public boolean e(String var1) {
        if (!this.d) {
            class_668.j("deleteFile: Not open as writable");
            return false;
        } else {
            Uri var2 = this.f(var1);
            if (var2 == null) {
                class_668.j("deleteFile: fileUri==null for:" + var1);
                return false;
            } else if (class_668.a.isDirectory(this.c(), var2)) {
                throw new RuntimeException("Attempted to delete folder at: " + var1 + " url:" + var2);
            } else {
                boolean var3;
                try {
                    var3 = class_668.a.deleteFile(this.c(), var2);
                } catch (IOException var5) {
                    var5.printStackTrace();
                    return false;
                } catch (IllegalArgumentException var6) {
                    var6.printStackTrace();
                    return false;
                }

                this.a();
                return var3;
            }
        }
    }

    public boolean a(String var1, String var2) {
        if (!this.d) {
            class_668.j("renameFile: Not open as writable");
            return false;
        } else {
            Uri var3 = this.f(var1);
            if (var3 == null) {
                class_668.j("renameFile: fileUri==null for:" + var1);
                return false;
            } else {
                String var4 = class_340.k(var2);
                class_668.i("Rename: " + var3 + " to " + var4);

                Uri var5;
                try {
                    var5 = class_668.a.renameFile(this.c(), var3, var4);
                } catch (IOException var7) {
                    var7.printStackTrace();
                    return false;
                }

                this.a();
                return var5 != null;
            }
        }
    }

    public Uri f(String var1) {
        class_1011 var2 = this.k(var1);
        return var2 == null ? null : var2.b;
    }

    public String[] g(String var1) {
        class_1011 var2 = this.k(var1);
        if (var2 == null) {
            return null;
        } else if (!var2.c) {
            return null;
        } else {
            HashMap var3 = var2.a();
            ArrayList var4 = new ArrayList();
            Iterator var5 = var3.keySet().iterator();

            while(var5.hasNext()) {
                String var6 = (String)var5.next();
                var4.add(var6);
            }

            return (String[])var4.toArray(new String[0]);
        }
    }

    public boolean h(String var1) {
        if (!var1.equals("/") && !var1.equals("")) {
            class_1011 var2 = this.k(var1);
            return var2 == null ? false : var2.c;
        } else {
            return true;
        }
    }

    public Uri i(String var1) {
        File var2 = new File(var1);
        String var3 = var2.getParent();
        if (var3 == null) {
            var3 = "";
        }

        Uri var4 = this.f(var3);
        if (var4 == null) {
            class_668.j("createDirectory: Parent folder: " + var3 + " not found");
        }

        return var4;
    }

    @SneakyThrows
    public boolean j(String var1) {
        File var2 = new File(var1);
        String var3 = var2.getName();
        Uri var4 = this.i(var1);
        if (var4 == null) {
            return false;
        } else {
            Uri var5 = class_668.a.createDirectory(this.c(), var4, var3);
            this.a();
            return var5 != null;
        }
    }

    private class_1011 k(String var1) {
        return this.l(var1);
    }

    private class_1011 l(String var1) {
        String[] var2 = var1.split("\\\\|\\/");
        class_1011 var3 = this.e;
        String[] var4 = var2;
        int var5 = var2.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            if (!var7.trim().equals("")) {
                HashMap var8;
                try {
                    var8 = var3.a();
                } catch (Exception var11) {
                    var11.printStackTrace();
                    return null;
                }

                class_1011 var9 = (class_1011)var8.get(var7);
                if (var9 != null) {
                    var3 = var9;
                } else {
                    String var10 = var7.toLowerCase(Locale.ROOT);
                    var9 = (class_1011)var3.e.get(var10);
                    if (var9 == null) {
                        class_668.i("child null for: " + var1);
                        class_668.i("element: " + var7);
                        return null;
                    }

                    var3 = var9;
                }
            }
        }

        return var3;
    }
}
