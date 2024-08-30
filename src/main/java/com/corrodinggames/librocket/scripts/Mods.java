package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.i.class_800;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class Mods extends ScriptContext {
    Root root;
    Runnable updateModsRunnable = new Mods$1(this);
    int checkWorkshopSkip = 0;

    Mods(Root var1) {
        this.root = var1;
    }

    public SteamEngine getSteam() {
        SteamEngine var1 = SteamEngine.getSteamEngine();
        if (!var1.e()) {
            var1.h();
            return null;
        } else {
            return var1;
        }
    }

    public void openWorkshop() {
        GameEngine var1 = GameEngine.getGameEngine();
        SteamEngine var2 = this.getSteam();
        if (var2 != null) {
            var2.m();
        }
    }

    public void uploadModAsk(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (var2.n()) {
            this.root.showAlert("Workshop uploading is disabled in BETA versions to ensure compatibility for others. Please test and upload this mod with a released version or wait till beta finishes.");
        } else {
            class_800 var3 = var2.bZ.c(var1);
            if (var3 == null) {
                this.root.showAlert("Could not find mod:" + var1);
            } else {
                SteamEngine var4 = this.getSteam();
                if (var4 != null) {
                    String var5 = "Are you sure you want to upload to the workshop?";
                    String var6 = "";
                    String var7 = "[onenter]Upload:";
                    var7 = var7 + "closePopup(); mods.uploadMod('" + var1 + "');";
                    boolean var8 = true;
                    this.root.showPopup(var5, var6, var8, var7, (String)null);
                }
            }
        }
    }

    public void uploadMod(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_800 var3 = var2.bZ.c(var1);
        if (var3 == null) {
            this.root.showAlert("Could not find mod:" + var1);
        } else {
            SteamEngine var4 = this.getSteam();
            if (var4 != null) {
                if (var3.k == 0L) {
                    var4.b(var3);
                } else {
                    String var5 = "Changes.";
                    var4.a(var3, false, var5);
                }
            }
        }
    }

    public void viewMod(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_800 var3 = var2.bZ.c(var1);
        if (var3 == null) {
            this.root.showAlert("Could not find mod:" + var1);
        } else {
            SteamEngine var4 = this.getSteam();
            if (var4 != null) {
                var4.a(var3);
            }
        }
    }

    public void deleteModPopup(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_800 var3 = var2.bZ.c(var1);
        if (var3 == null) {
            this.root.showAlert("Could not find mod:" + var1);
        } else {
            String var4 = "";
            String var5 = "Are you sure you want to permanently delete '" + var3.b() + "'? (Note: You can instead disable the mod by unticking it)";
            String var6 = "[onenter]Delete:";
            var6 = var6 + "closePopup(); mods.deleteMod('" + var1 + "');";
            boolean var7 = true;
            this.root.showPopup(var4, var5, var7, var6, (String)null);
        }
    }

    public void deleteMod(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        class_800 var3 = var2.bZ.c(var1);
        if (var3 == null) {
            this.root.showAlert("Could not find mod:" + var1);
        } else {
            boolean var4 = var3.u();
            if (var4) {
                this.reloadModData();
            } else {
                this.root.showAlert("Error failed to delete mod");
            }

        }
    }

    public void setModFilter(String var1) {
        ElementDocument var2 = this.libRocket.getActiveDocument();
        if (var2 == null) {
            GameEngine.log("loadMods: No Active Document");
        } else {
            var2.setMetadata("modFilter", var1);
            this.applyModFilter();
        }
    }

    public void applyModFilter() {
        GameEngine var1 = GameEngine.getGameEngine();
        ElementDocument var2 = this.libRocket.getActiveDocument();
        if (var2 == null) {
            GameEngine.log("loadMods: No Active Document");
        } else {
            String var3 = (String)var2.getMetadata("modFilter");
            Element var4 = var2.getElementById("modList");
            if (var4 == null) {
                GameEngine.log("loadMods: Failed to find modList, wrong page?");
            } else {
                Element var5 = var2.getElementById("onlyEnabledMods");
                boolean var6 = var5.getCheckbox();
                ArrayList var7 = var4.findElementsByClassName("modItem");
                if (var3 == null || var3.trim().equals("")) {
                    var3 = null;
                }

                if (var3 != null) {
                    var3 = var3.toLowerCase(Locale.ROOT).trim();
                }

                int var8 = 0;
                int var9 = 0;
                Iterator var10 = var7.iterator();

                Element var11;
                while(var10.hasNext()) {
                    var11 = (Element)var10.next();
                    boolean var12 = false;
                    String var13 = var11.getAttribute("data_sessionid");
                    int var14 = class_340.l(var13);
                    class_800 var15 = var1.bZ.a(var14);
                    if (var15 == null) {
                        GameEngine.log("Could not find mod with mod session id: " + var14);
                    } else {
                        if (var3 != null) {
                            boolean var16 = false;
                            if (var15.modName() != null && var15.modName().toLowerCase(Locale.ROOT).contains(var3)) {
                                var16 = true;
                            }

                            if (var15.e() != null && var15.e().toLowerCase(Locale.ROOT).contains(var3)) {
                                var16 = true;
                            }

                            if (!var16) {
                                var12 = true;
                            }
                        }

                        if (var6 && var15.f) {
                            var12 = true;
                        }
                    }

                    if (var12) {
                        ++var8;
                        var11.compareAndAddClass("modItemFilteredOut");
                    } else {
                        ++var9;
                        var11.removeClass("modItemFilteredOut");
                    }
                }

                String var17 = "";
                if (var8 > 0 && var9 == 0) {
                    var17 = "< No mods found with active filter (" + var8 + " hidden) >";
                } else if (var8 > 0) {
                    var17 = "< " + var8 + " mods hidden with active filter >";
                }

                var11 = var2.getElementById("filterStatus");
                var11.setText(var17);
            }
        }
    }

    public void updateMods() {
        ++this.checkWorkshopSkip;
        if (this.checkWorkshopSkip > 100) {
            this.checkWorkshopSkip = 0;
            SteamEngine var1 = SteamEngine.getSteamEngine();
            if (var1 != null) {
                var1.k();
            }
        }

    }

    public void refreshModList() {
        ElementDocument var1 = this.libRocket.getActiveDocument();
        if (var1 == null) {
            GameEngine.log("refreshModList: No Active Document");
        } else {
            GameEngine.log("refreshModList");
            Element var2 = var1.getElementById("modTemplate");
            if (var2 == null) {
                GameEngine.log("refreshModList: Failed to find modTemplate, wrong page?");
            } else {
                GameEngine var3 = GameEngine.getGameEngine();
                var3.bZ.d();
                this._rememberTempModSelection();
                this.loadMods();
                this._restoreTempModSelection();
            }
        }
    }

    public void loadMods() {
        GameEngine var1 = GameEngine.getGameEngine();
        ArrayList var2 = var1.bZ.k();
        ElementDocument var3 = this.libRocket.getActiveDocument();
        if (var3 == null) {
            GameEngine.log("loadMods: No Active Document");
        } else {
            GameEngine.log("loadMods");
            Element var4 = var3.getElementById("modTemplate");
            Element var5 = var3.getElementById("modList");
            if (var4 == null) {
                GameEngine.log("loadMods: Failed to find modTemplate, wrong page?");
            } else if (var5 == null) {
                GameEngine.log("loadMods: Failed to find modList, wrong page?");
            } else {
                this.root.setDocumentUpdate(var3, this.updateModsRunnable);
                String var6 = var4.getInnerRML();
                String var7 = "";
                int var8 = 0;

                Iterator var9;
                class_800 var10;
                String var11;
                for(var9 = var2.iterator(); var9.hasNext(); var7 = var7 + var11) {
                    var10 = (class_800)var9.next();
                    String var12 = var10.modName();
                    String var13 = "";
                    var11 = var6.replace("_NAME_", this.root.htmlString(var12));
                    var11 = var11.replace("_ID_", var10.e);
                    String var14 = var10.R;
                    if (var14 == null) {
                        var14 = "";
                    } else {
                        var13 = var13 + " modItemError";
                    }

                    if (var10.v()) {
                        var13 = var13 + " modItemCanBeDeleted";
                    }

                    if (var10.k == 0L) {
                        if (!var10.y && !var10.z) {
                            var13 = var13 + " modItemCanBePublished";
                        }
                    } else {
                        if (!var10.y) {
                            var13 = var13 + " modItemIsOwner";
                        }

                        var13 = var13 + " modItemIsPublished";
                    }

                    if (var10.A) {
                        var13 = var13 + " modItemHasMaps";
                    }

                    String var15 = var10.l();
                    if (var15 == null) {
                        var15 = "";
                    }

                    String var16 = var10.e();
                    var11 = var11.replace("_ERROR_", this.root.htmlString(var14));
                    var11 = var11.replace("_MESSAGE_", this.root.htmlStringWithNewlines(var15));
                    var11 = var11.replace("_DESCRIPTION_", this.root.htmlString(var16));
                    var11 = var11.replace("_CLASS_", var13);
                    var11 = var11.replace("_SESSIONID_", "" + var10.d());
                    ++var8;
                }

                var5.setInnerRML(var7);
                var5.loadCharsetIfNeeded(var7);
                var9 = var2.iterator();

                while(var9.hasNext()) {
                    var10 = (class_800)var9.next();
                    Element var17 = var3.getElementById(var10.e);
                    if (var17 == null) {
                        GameEngine.print("Could not find:" + var10.c);
                    } else {
                        var17.setCheckbox(!var10.f);
                    }
                }

                this.applyModFilter();
            }
        }
    }

    public void saveMods() {
        this._saveModsCommon(true);
    }

    private void _rememberTempModSelection() {
        ElementDocument var1 = this.libRocket.getActiveDocument();
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("temp save");
        ArrayList var3 = var1.findElementsByClassName("modSelection");
        boolean var4 = false;
        Iterator var5 = var3.iterator();

        while(var5.hasNext()) {
            Element var6 = (Element)var5.next();
            String var7 = var6.getId();
            if (!var7.equals("_ID_")) {
                class_800 var8 = var2.bZ.c(var7);
                if (var8 == null) {
                    GameEngine.a("Could not find mod:" + var6.getInnerRML());
                } else {
                    boolean var9 = !var6.getCheckbox();
                    if (var8.g != var9) {
                        var4 = true;
                    }

                    var8.g = var9;
                    var8.h = true;
                }
            }
        }

    }

    private void _restoreTempModSelection() {
        ElementDocument var1 = this.libRocket.getActiveDocument();
        GameEngine var2 = GameEngine.getGameEngine();
        GameEngine.log("temp restore");
        ArrayList var3 = var1.findElementsByClassName("modSelection");
        boolean var4 = false;
        Iterator var5 = var3.iterator();

        while(var5.hasNext()) {
            Element var6 = (Element)var5.next();
            String var7 = var6.getId();
            if (var7 != null && !var7.equals("") && !var7.equals("_ID_")) {
                class_800 var8 = var2.bZ.c(var7);
                if (var8 == null) {
                    GameEngine.a("Could not find mod:" + var6.getInnerRML() + " id:" + var7);
                } else if (var8.h) {
                    boolean var9 = !var6.getCheckbox();
                    if (var8.g != var9) {
                        var4 = true;
                        var6.setCheckbox(!var8.g);
                    }
                }
            }
        }

    }

    private void _saveModsCommon(boolean var1) {
        boolean var2 = false;
        ElementDocument var3 = this.libRocket.getActiveDocument();
        GameEngine var4 = GameEngine.getGameEngine();
        GameEngine.log("savesMods");
        ArrayList var5 = var3.findElementsByClassName("modSelection");
        Iterator var6 = var5.iterator();

        while(var6.hasNext()) {
            Element var7 = (Element)var6.next();
            String var8 = var7.getId();
            if (!var8.equals("_ID_")) {
                class_800 var9 = var4.bZ.c(var8);
                if (var9 == null) {
                    this.root.showAlert("Could not find mod:" + var7.getInnerRML());
                } else {
                    boolean var10 = !var7.getCheckbox();
                    if (var9.f != var10) {
                        var2 = true;
                    }

                    var9.f = var10;
                    var9.g = var10;
                }
            }
        }

        if (var2) {
            GameEngine.log("mod changes made");
        } else {
            GameEngine.log("no mod changes made");
        }

        var4.bZ.e();
        var4.settingsEngine.save();
        if (var1) {
            this._saveModsMessages(false);
        }

    }

    private void _saveModsMessages(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = var2.bZ.a(false);
        int var4 = var2.bZ.b();
        if (var2.netEngine.B) {
            GameEngine.log("savesMods: in network game");
            this.root.showAlert("You are currently in a network game, changes will be checked and applied on next game");
        } else if (class_436.c(true)) {
            if (var3 == 0) {
                this.root.showAlert("Mod changes saved. Will be used in the next game.");
            } else {
                String var5;
                if (var1) {
                    var5 = "Note: " + var3 + " selected mods are still not loaded after reload";
                    if (var4 > 0) {
                        var5 = "Warning: " + var4 + " selected mods had errors after reload";
                    }

                    this.root.showAlert(var5);
                } else {
                    var5 = "Reload needed";
                    String var6 = "Mod selection saved. But " + var3 + " mod(s) aren't loaded. Load them now?";
                    if (!var2.I()) {
                        var6 = var6 + " (This will end your current game).";
                    }

                    String var7 = "[onenter]Reload:";
                    var7 = var7 + "closePopup(); mods.reloadModData();";
                    boolean var8 = true;
                    this.root.showPopup(var5, var6, var8, var7, (String)null);
                }
            }
        } else {
            GameEngine.log("Errors found");
        }

    }

    public void disableAllAsk() {
        String var1 = "Disable all mods?";
        String var2 = "";
        String var3 = "[onenter]Disable All:";
        var3 = var3 + "closePopup(); mods.disableAll();";
        boolean var4 = true;
        this.root.showPopup(var1, var2, var4, var3, (String)null);
    }

    public void disableAll() {
        GameEngine var1 = GameEngine.getGameEngine();
        var1.bZ.g();
        var1.bZ.e();
        var1.settingsEngine.save();
        var1.bZ.l();
        this.loadMods();
    }

    public void reloadModDataAsk() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.I()) {
            GameEngine.log("Menu active, reloading without asking");
            this.reloadModData();
        } else {
            String var2 = "Reload all mod data?";
            String var3 = "";
            var3 = var3 + "Warning! this will end your current game.";
            String var4 = "[onenter]Reload:";
            var4 = var4 + "closePopup(); mods.reloadModData();";
            boolean var5 = true;
            this.root.showPopup(var2, var3, var5, var4, (String)null);
        }
    }

    public void reloadModData() {
        GameEngine var1 = GameEngine.getGameEngine();
        this._saveModsCommon(false);
        var1.bZ.l();
        this._saveModsMessages(true);
        this.loadMods();
    }
}
