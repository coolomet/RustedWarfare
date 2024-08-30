package com.corrodinggames.librocket;

import android.graphics.Rect;
import android.graphics.RectF;
import com.Element;
import com.ElementDocument;
import com.LibRocket;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.gameFramework.FileChangeEngine;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.class_964;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $FF: renamed from: com.corrodinggames.librocket.b
public abstract class class_60 extends LibRocket {
    public static class_964 a = new class_964("LoadResources");
    public static String b = "";
    public ScriptEngine c = ScriptEngine.createScriptEngine(this);
    protected int d = 0;
    public boolean e;
    protected Rect f = new Rect();
    protected RectF g = new RectF();
    protected boolean h = false;
    private class_805 j;
    private class_805 k;
    Pattern i = Pattern.compile("\\$\\{([^\\}]*?)\\}");

    public void a() {
        this.d = 0;
    }

    public static String a(String var0) {
        GameEngine.log("convertTexturePath for: " + var0);
        var0 = class_340.o(var0);
        if (var0.startsWith("base:")) {
            return b + var0.substring("base:".length());
        } else if (var0.startsWith("drawable:")) {
            return b + "res/drawable/" + var0.substring("drawable:".length());
        } else if (var0.startsWith("assets:")) {
            String var1 = var0.substring("assets:".length());
            String var2 = class_697.e(var1);
            boolean var3 = true;
            if (GameEngine.aZ && var2 != null && var2.startsWith(b)) {
                var3 = false;
            }

            if (GameEngine.aZ && var2 != null && var2.startsWith("/private")) {
                var3 = false;
            }

            GameEngine.log("convertTexturePath  (basePath:" + var3 + "):" + var1 + " > " + var2);
            return var3 ? b + var2 : var2;
        } else if (var0.startsWith(b + "assets/gui/")) {
            GameEngine.log("convertTexturePath already had path:" + var0);
            return var0;
        } else {
            return b + "assets/gui/" + var0;
        }
    }

    public Matcher a(String var1, String var2) {
        Pattern var3 = Pattern.compile(var1);
        Matcher var4 = var3.matcher(var2);
        return var4.matches() ? var4 : null;
    }

    public void ReleaseTexture(int var1) {
        this.removeTextureHolder(var1);
    }

    public boolean LoadTexture(int var1, String var2) {
        a.a();
        class_806 var3 = (class_806)this.findTextureHolder(var1);
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        class_31 var7 = null;
        if (var2.startsWith("lazy:")) {
            var2 = var2.substring("lazy:".length());
            var4 = true;
        }

        if (var2.startsWith("nocolor:")) {
            var2 = var2.substring("nocolor:".length());
            var5 = true;
        }

        if (var2.startsWith("unit:")) {
            var2 = var2.substring("unit:".length());
            var7 = UnitType.a(var2);
            var4 = true;
        }

        if (var2.startsWith("thumbnail:")) {
            var2 = var2.substring("thumbnail:".length());
            var6 = true;
        }

        Matcher var8 = this.a("^(alpha\\((.*)\\):).*", var2);
        String var9;
        if (var8 != null) {
            var9 = var8.group(1);
            String var10 = var8.group(2);
            GameEngine.log("alpha=" + var10);
            var3.e = Float.parseFloat(var10);
            var2 = var2.substring(var9.length());
        }

        var9 = a(var2);
        var3.b = var4;
        var3.c = var6;
        var3.d = var5;
        var3.f = var7;
        var3.a = var9;
        if (!var4 && !var3.a()) {
            a.b();
            return false;
        } else {
            a.b();
            return true;
        }
    }

    public abstract void EnableScissorRegion(boolean var1);

    public void SetScissorRegion(int var1, int var2, int var3, int var4) {
        this.f.a(var1, var2, var1 + var3, var2 + var4);
        this.g.a((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4));
        this.EnableScissorRegion(true);
    }

    public boolean b() {
        if (this.getActiveDocument() != null) {
            return false;
        } else if (this.k != null) {
            return false;
        } else {
            return this.j == null;
        }
    }

    public void HandleEvent(String var1) {
        this.e = true;

        try {
            this.c.processScript(var1);
        } finally {
            this.e = false;
        }

    }

    public Object b(String var1) {
        HashMap var2 = this.getActiveDocumentMetadata();
        return var2 == null ? null : var2.get(var1);
    }

    public void newDocumentLoaded(ElementDocument var1) {
        this.c.getRootNoCheck().convertTextOnPage();
    }

    public void newDocumentShown(ElementDocument var1) {
        if (this.k != null) {
            this.k.a.pullToFront();
        }

        if (this.j != null) {
            this.j.a.pullToFront();
        }

    }

    public ElementDocument c() {
        return this.k != null ? this.k.a : null;
    }

    public ElementDocument d() {
        return this.j != null ? this.j.a : null;
    }

    public ElementDocument e() {
        ElementDocument var1 = this.d();
        return var1 != null ? var1 : this.c();
    }

    public ElementDocument f() {
        ElementDocument var1 = this.c();
        if (var1 != null) {
            return var1;
        } else {
            var1 = this.getActiveDocument();
            return var1;
        }
    }

    public ElementDocument g() {
        ElementDocument var1 = this.d();
        if (var1 != null) {
            return var1;
        } else {
            var1 = this.c();
            if (var1 != null) {
                return var1;
            } else {
                var1 = this.getActiveDocument();
                return var1;
            }
        }
    }

    public void c(String var1) {
        class_805 var2 = new class_805();
        var2.b = null;
        var2.c = var1;
        this.a(var2);
    }

    public void b(String var1, String var2) {
        class_805 var3 = new class_805();
        var3.b = var1;
        var3.c = var2;
        this.a(var3);
    }

    public void a(String var1, String var2, String var3, String var4, String var5, boolean var6) {
        class_805 var7 = new class_805();
        var7.b = var1;
        var7.c = var2;
        var7.d = var3;
        var7.e = var4;
        var7.f = var5;
        var7.h = var6;
        this.a(var7);
    }

    public void a(String var1, String var2, String var3, class_804 var4, class_804 var5, boolean var6) {
        class_805 var7 = new class_805();
        var7.b = var1;
        var7.c = var2;
        var7.d = var3;
        var7.e = var4;
        var7.f = var5;
        var7.h = var6;
        this.a(var7);
    }

    public ElementDocument a(String var1, String var2, String var3, Object var4, Object var5, boolean var6, boolean var7) {
        class_805 var8 = new class_805();
        var8.b = var1;
        var8.c = var2;
        var8.d = var3;
        var8.e = var4;
        var8.f = var5;
        var8.g = var6;
        var8.h = var7;
        return this.a(var8);
    }

    public ElementDocument a(class_805 var1) {
        ScriptEngine.checkThreadAccess();
        ElementDocument var2 = this.createPopup("messagebox.rml", (Object)null);
        HashMap var3 = var2.getMetadataMap();
        var2.getElementById("message").setTextWithNewlines(var1.c);
        if (var1.b == null) {
            var1.b = "";
        }

        var2.getElementById("title").setText(var1.b);
        this.a(var2, "button_1", var1.e, var3);
        this.a(var2, "button_2", var1.f, var3);
        Element var4 = var2.getElementById("button_back");
        var4.loadCharsetIfNeededWithCurrentText();
        String var5 = "closePopup();";
        if (var1.d != null) {
            var5 = var5 + "hideKeyboard();";
        }

        var4.setAttribute("onclick", var5);
        if (!var1.h) {
            var4.hide();
        }

        if (var1.e == null && var1.f == null) {
            var4.setText(class_1009.a("menus.common.ok"));
            var4.focus();
        }

        if (var1.d != null) {
            Element var6 = var2.getElementById("textInputWrapper");
            var6.show();
            Element var7 = var2.getElementById("textInput");
            var7.setAttribute("value", var1.d);
            var7.focus();
        }

        var1.a = var2;
        if (var1.g) {
            if (this.b(var1)) {
                return var2;
            } else {
                this.closeDocument(var2);
                return null;
            }
        } else {
            return var2;
        }
    }

    public boolean b(class_805 var1) {
        if (this.j != null) {
            GameEngine.log("AlertPopup already visible closing");
            this.closeDocument(this.j.a);
            this.j = null;
        }

        this.j = var1;
        GameEngine.log("Showing popup: " + var1.b);
        if (!this.e) {
            this.update();
        } else {
            GameEngine.log("insideEvent");
        }

        GameEngine.log("popup ready..");
        var1.a.show(4);
        GameEngine.log("Popup shown..");
        return true;
    }

    public boolean a(ElementDocument var1) {
        return this.c(new class_805(var1));
    }

    public boolean c(class_805 var1) {
        if (this.k != null) {
            GameEngine.log("Popup already visible, cannot show: " + var1.a.getMetadata("sourceDocumentId"));
            if (this.j != null) {
                this.j.a.pullToFront();
                return false;
            } else {
                this.k.a.pullToFront();
                return false;
            }
        } else {
            this.k = var1;
            GameEngine.log("Showing popup: " + var1.b);
            if (!this.e) {
                this.update();
            } else {
                GameEngine.log("insideEvent");
            }

            GameEngine.log("popup ready..");
            var1.a.show(4);
            GameEngine.log("Popup shown..");
            return true;
        }
    }

    public ElementDocument a(String var1, Object var2, String var3, boolean var4) {
        ScriptEngine.checkThreadAccess();
        ElementDocument var5 = this.createPopup("messagebox.rml", var2);
        var5.setMetadata("sourceDocumentId", var1);
        File var6 = new File(a(var1));
        String var7 = class_340.a(var6);
        var5.getElementById("mainButtons").hide();
        Element var8 = var5.getElementById("message");
        var8.setInnerRML(var7);
        this.a(var8, false);
        if (var3 == null) {
            var3 = "";
        }

        var5.getElementById("title").setText(var3);
        if (var4) {
            return this.b(var5) ? var5 : null;
        } else {
            return var5;
        }
    }

    public boolean b(ElementDocument var1) {
        class_805 var2 = new class_805(var1);
        if (this.c(var2)) {
            return true;
        } else {
            this.closeDocument(var1);
            return false;
        }
    }

    public void a(Element var1, boolean var2) {
        if (var1 == null) {
            GameEngine.log("loadCharsetIfNeededOnChildren: root is null");
        } else {
            ArrayList var3 = var1.getAllNestedChildren();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
                Element var5 = (Element)var4.next();
                boolean var6 = false;
                String var7 = var5.getTagName();
                if (var7.equals("p") || var7.startsWith("h") || var7.startsWith("label") || var7.startsWith("button") || var7.startsWith("select")) {
                    var6 = true;
                }

                if (var2 && var7.equals("option")) {
                    var6 = true;
                }

                if (var6) {
                    boolean var8 = var5.loadCharsetIfNeededWithCurrentText();
                }
            }

        }
    }

    public void a(ElementDocument var1, String var2, Object var3, HashMap var4) {
        Element var5 = var1.getElementById(var2);
        if (var3 == null) {
            var5.hide();
        } else if (var3 instanceof String) {
            String var6 = (String)var3;
            int var7 = var6.indexOf(":");
            String var8 = var6.substring(0, var7);
            String var9 = "";
            if (var7 + 1 < var6.length()) {
                var9 = var6.substring(var7 + 1);
            }

            if (var8.startsWith("[onenter]")) {
                var8 = var8.substring("[onenter]".length());
                var1.getElementById("textInput").setAttribute("onenter", var9);
            }

            var5.setText(var8);
            var5.setAttribute("onclick", var9);
        } else if (var3 instanceof class_804) {
            class_804 var10 = (class_804)var3;
            String var11 = "action_" + var2;
            var4.put(var11, var10.b);
            var5.setText(var10.a);
            var5.setAttribute("onclick", "runRunnable(" + var11 + ");");
            if (var10.c) {
                var1.getElementById("textInput").setAttribute("onenter", "runRunnable(" + var11 + ");");
            }
        } else {
            GameEngine.warn("Unhandled type:" + var3);
        }

    }

    public boolean h() {
        if (this.i()) {
            return true;
        } else {
            return this.j();
        }
    }

    public boolean i() {
        class_805 var1 = this.j;
        if (var1 != null) {
            GameEngine.log("Closing alert");
            this.closeDocument(var1.a);
            this.j = null;
            if (var1.i != null) {
                var1.i.run();
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean j() {
        class_805 var1 = this.k;
        if (var1 != null) {
            GameEngine.log("Closing popup");
            this.closeDocument(var1.a);
            this.k = null;
            if (var1.i != null) {
                var1.i.run();
            }

            return true;
        } else {
            return false;
        }
    }

    public String k() {
        ElementDocument var1 = this.e();
        Element var2 = var1.getElementById("textInput");
        return var2.getAttribute("value");
    }

    public String d(String var1) {
        String var2 = null;
        if (var1 != null && var1.contains("class=\"log-entry\"")) {
            System.out.println("parseText: skipping log line:" + var1);
            return null;
        } else {
            int var3 = 0;

            for(Matcher var4 = this.i.matcher(var1); var4.find(); var2 = var1) {
                ++var3;
                if (var3 > 100) {
                    System.out.println("parseText too many loops!!");
                    return null;
                }

                String var5 = var4.group(1);
                String var6 = null;
                if (this.debug) {
                    System.out.println("parseText:" + var5);
                }

                if (var5.startsWith("i:")) {
                    String var7 = var5.substring(2);
                    var6 = class_1009.a(var7);
                }

                if (var6 == null) {
                    Object var8 = this.c.processArg(var5);
                    if (var8 != null) {
                        var6 = var8.toString();
                    }
                }

                if (var6 == null) {
                    var1 = var4.replaceFirst("(unhandled:" + var5 + ")");
                } else {
                    var1 = var4.replaceFirst(var6);
                }

                if (var6 != null) {
                    ElementDocument var9 = this.getActiveDocument();
                    if (var9 != null && !var9.translatedToUnicode && class_340.n(var6)) {
                        var9.translatedToUnicode = true;
                    }

                    var9 = this.g();
                    if (var9 != null && !var9.translatedToUnicode && class_340.n(var6)) {
                        var9.translatedToUnicode = true;
                    }
                }

                var4 = this.i.matcher(var1);
            }

            return var2;
        }
    }

    public String TranslateString(String var1) {
        try {
            String var2 = this.d(var1);
            return var2 != null ? var2 : null;
        } catch (Exception var3) {
            ScriptEngine.throwDelayedException("TranslateString exception on: " + var1, var3);
            GameEngine.a((String)"Exception in TranslateString", (Throwable)var3);
            GameEngine.print("start");
            var3.printStackTrace();
            GameEngine.print("end");
            GameEngine.print("start logStack");
            GameEngine.T();
            GameEngine.print("end logStack");
            System.err.flush();
            System.out.flush();
            return null;
        }
    }

    public long getFileLastModified(String var1) {
        return FileChangeEngine.a(var1, false);
    }

    public void postUpdate() {
        boolean var1 = this.queueExtraUpdate;
        super.postUpdate();
        if (var1) {
            this.c.checkForErrors();
        }

    }
}
