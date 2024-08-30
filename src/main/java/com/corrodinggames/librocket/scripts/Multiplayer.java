package com.corrodinggames.librocket.scripts;

import com.Element;
import com.ElementDocument;
import com.corrodinggames.rts.appFramework.class_200;
import com.corrodinggames.rts.appFramework.class_201;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import com.corrodinggames.rts.gameFramework.net.GameMapData;
import com.corrodinggames.rts.gameFramework.net.MapType;
import com.corrodinggames.rts.gameFramework.net.Server_type;
import com.corrodinggames.rts.gameFramework.steam.SteamEngine;
import com.corrodinggames.rts.gameFramework.utility.class_675;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Multiplayer extends ScriptContext {
    Root root;
    String[] currentDropdownRawArray;
    Root$TableData lastPlayerTable;
    boolean useMapDropdown = false;

    Multiplayer(Root var1) {
        this.root = var1;
    }

    void updateMapDropdown(Element var1, String var2, String var3) {
        GameEngine var4 = GameEngine.getGameEngine();
        Element var5 = var1.getElementById(var3);
        int var6 = var5.getValueAsInt(0);
        this.currentDropdownRawArray = null;
        ArrayList var7 = new ArrayList();
        String[] var8;
        int var9;
        int var10;
        String var11;
        String var12;
        if (var6 == 0) {
            this.currentDropdownRawArray = class_697.a("maps/skirmish", true);
            Arrays.sort(this.currentDropdownRawArray);
            var8 = this.currentDropdownRawArray;
            var9 = var8.length;

            for(var10 = 0; var10 < var9; ++var10) {
                var11 = var8[var10];
                var12 = class_200.e(var11);
                var7.add(var12);
            }
        } else if (var6 == 1) {
            this.currentDropdownRawArray = class_697.a("/SD/rusted_warfare_maps", true);
            if (this.currentDropdownRawArray == null) {
                var4.log("Could not find folder: /SD/rusted_warfare_maps", 1);
                this.currentDropdownRawArray = new String[0];
            }

            Arrays.sort(this.currentDropdownRawArray);
            var8 = this.currentDropdownRawArray;
            var9 = var8.length;

            for(var10 = 0; var10 < var9; ++var10) {
                var11 = var8[var10];
                var12 = class_200.e(var11);
                var7.add(var12);
            }
        } else {
            if (var6 != 2) {
                throw new RuntimeException("Unknown typeIndex:" + var6);
            }

            this.currentDropdownRawArray = class_201.l();
            if (this.currentDropdownRawArray == null) {
                var4.log("Could not find a save folder on SD card", 1);
                this.currentDropdownRawArray = new String[0];
            }

            var8 = this.currentDropdownRawArray;
            var9 = var8.length;

            for(var10 = 0; var10 < var9; ++var10) {
                var11 = var8[var10];
                var12 = class_200.e(var11);
                var7.add(var12);
            }
        }

        String var18 = "";
        String var19 = "maps/skirmish";
        var10 = 0;
        int var20 = 1;
        String[] var21 = this.currentDropdownRawArray;
        int var13 = var21.length;

        int var14;
        String var15;
        for(var14 = 0; var14 < var13; ++var14) {
            var15 = var21[var14];
            ++var10;
            if (var6 == 0 && var15.equalsIgnoreCase("[p8]Many Islands (8p).tmx")) {
                var20 = var10;
            }
        }

        var10 = 0;
        var21 = this.currentDropdownRawArray;
        var13 = var21.length;

        for(var14 = 0; var14 < var13; ++var14) {
            var15 = var21[var14];
            ++var10;
            String var16 = this.root.convertMapName(var15);
            boolean var17 = var10 == var20;
            var18 = var18 + this.generateOption(var15, var16, var17) + "\n";
        }

        GameEngine.log("mapList:" + var18);
        if (var6 != 2) {
        }

        Element var22 = var1.getElementById("mapsSelectorParent");
        String var23 = "<p data-workaround='this stops disappearing select'></p><select id='mapsSelector' class='mapsSelector'><option value='0'>...</option></select>";
        var22.setInnerRML(var23);
        Element var24 = this.getMapDropdown();
        var24.setInnerRML(var18);
    }

    String generateOption(String var1, String var2, boolean var3) {
        return this.generateOption(var1, var2, var3, (Integer)null, false);
    }

    String generateOption(String var1, String var2, boolean var3, Integer var4, boolean var5) {
        String var6 = "";
        if (var3) {
            var6 = var6 + " selected='selected'";
        }

        String var7 = this.root.htmlString(var2);
        String var8 = "";
        if (var4 != null) {
            var8 = var8 + " style='color:" + class_340.h(var4) + ";'";
        }

        if (var5) {
            var8 = var8 + " class='disabled-option'";
        }

        if (var8 != null && !"".equals(var8)) {
            var7 = "<span " + var8 + ">" + var7 + "</span>";
        }

        return "<option value=" + this.root.escapedString(var1) + " " + var6 + ">" + var7 + "</option>";
    }

    Element getMapDropdown() {
        ElementDocument var1 = this.libRocket.c();
        Element var2 = var1.findByClassName("mapsSelector");
        return var2;
    }

    String getMapDropdownSelected() {
        return this.getMapDropdown().getAttribute("value");
    }

    void readInterfaceIntoNetworkSettings() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.isServer) {
            String var2 = this.getMapDropdownSelected();
            if (var2 == null) {
                var2 = "<No Map>";
            }

            var1.netEngine.gameMapData.mapName = var2;
            byte var3 = 0;
            var1.netEngine.gameMapData.mapType = MapType.values()[var3];
        }

    }

    public void multiplayerStart() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.isServer) {
            if (var1.netEngine.gameMapData.mapType == MapType.skirmishMap) {
                String var2 = "maps/skirmish/" + var1.netEngine.gameMapData.mapName;
                var1.netEngine.az = var2;
            } else if (var1.netEngine.gameMapData.mapType == MapType.customMap) {
                var1.netEngine.az = "/SD/rusted_warfare_maps/" + var1.netEngine.gameMapData.mapName;
            } else {
                if (var1.netEngine.gameMapData.mapType != MapType.savedGame) {
                    this.libRocket.c("Error: No map type selected");
                    return;
                }

                var1.netEngine.az = null;
            }

            if (var1.netEngine.gameMapData.mapName == null || "".equals(var1.netEngine.gameMapData.mapName) || var1.netEngine.gameMapData.mapName.equals("<No Map>")) {
                this.libRocket.c("Error: No map selected");
                return;
            }

            var1.netEngine.ae();
        } else if (var1.netEngine.H) {
            var1.netEngine.k("-start");
        } else {
            GameEngine.b("startNetButton.setOnClickListener", "Clicked but not server or proxy controller");
        }

    }

    public void battleroomSetup() {
        GameEngine var1 = GameEngine.getGameEngine();
        this.lastPlayerTable = null;
        this.refreshUI();
        this.root.refreshChat();
        ElementDocument var2 = this.libRocket.getActiveDocument();
        if (var2 != null && var1.netEngine.F) {
            var2.addClass("singlePlayer");
        }

        var1.netEngine.as();
    }

    public void refreshUI() {
        GameEngine var1 = GameEngine.getGameEngine();
        Element var2 = this.libRocket.getActiveElementById("infoDiv");
        if (var2 == null) {
            GameEngine.log("refreshUI: infoTextElement==null");
        } else {
            ElementDocument var3 = this.libRocket.getActiveDocument();
            boolean var4 = var1.netEngine.isServer || var1.netEngine.H;
            boolean var5 = var1.netEngine.isServer;
            boolean var6 = !var4 && !var1.netEngine.gameMapData.m;
            Iterator var7 = var3.findElementsByClassName("forHostOnly").iterator();

            Element var8;
            while(var7.hasNext()) {
                var8 = (Element)var7.next();
                var8.show(var4);
            }

            var7 = var3.findElementsByClassName("forLocalHostOnly").iterator();

            while(var7.hasNext()) {
                var8 = (Element)var7.next();
                var8.show(var5);
            }

            var7 = var3.findElementsByClassName("forUnlockedTeamsNonHost").iterator();

            while(var7.hasNext()) {
                var8 = (Element)var7.next();
                var8.show(var6);
            }

            if (var1.P()) {
                var7 = var3.findElementsByClassName("forRealNetworkOnly").iterator();

                while(var7.hasNext()) {
                    var8 = (Element)var7.next();
                    var8.show(false);
                }
            }

            String var12 = var1.netEngine.at();
            var2.compareAndSetText(var12);
            String var13 = var1.netEngine.av();
            if (var1.netEngine.gameMapData.mapType == MapType.savedGame) {
                var13 = "saves/" + var1.netEngine.gameMapData.mapName;
            }

            Element var9 = this.libRocket.getActiveElementById("mapImage");
            if (var1.netEngine.v) {
                var9.hide();
            }

            String var10 = var9.getAttribute("src");
            if (var13 == null) {
                if (!"".equals(var10)) {
                    var9.setAttribute("src", "");
                }
            } else {
                String var11 = this.root.getMapThumbnail(var13);
                if (var11 == null) {
                    var11 = "";
                }

                if (!var11.equals(var10)) {
                    var9.setAttribute("src", var11);
                }
            }

            this.refreshPlayerTable();
        }
    }

    public void refreshPlayerTable() {
        Root$TableData var1 = this.getPlayerTable();
        String var2 = "playersDiv";
        if (this.lastPlayerTable != null) {
            if (this.lastPlayerTable.same(var1, false)) {
                return;
            }

            if (this.lastPlayerTable.same(var1, true)) {
                this.root.updateTableTextOnly(var2, var1, this.lastPlayerTable);
                return;
            }
        }

        this.root.refreshTable(var2, var1);
        this.lastPlayerTable = var1;
    }

    public Root$TableData getPlayerTable() {
        GameEngine var1 = GameEngine.getGameEngine();
        Root$TableData var2 = new Root$TableData();
        ArrayList var3 = var2.rows;
        int var5 = -1;
        int var6 = 0;
        ArrayList var7 = PlayerData.a(true);
        Iterator var8 = var7.iterator();

        PlayerData var9;
        while(var8.hasNext()) {
            var9 = (PlayerData)var8.next();
            if (var9 != null) {
                if (var5 != -1 && var5 != var9.team) {
                    ++var6;
                }

                var5 = var9.team;
            }
        }

        var5 = -1;
        var8 = var7.iterator();

        while(true) {
            Root$TableRow var4;
            do {
                if (!var8.hasNext()) {
                    if (!var1.netEngine.isServer && var1.netEngine.S == null) {
                        var3.clear();
                        String var18 = "Connecting...";
                        if (var1.netEngine.socketList.size() == 0) {
                            var18 = "Disconnected";
                        }

                        var4 = new Root$TableRow();
                        var4.addCell(var18);
                        Root$TableCell var19 = var4.addCell("");
                        Root$TableCell var21 = var4.addCell("");
                        var4.addCell("");
                        var3.add(var4);
                    }

                    return var2;
                }

                var9 = (PlayerData)var8.next();
            } while(var9 == null);

            if (var5 != -1 && var5 != var9.team && var6 <= 3) {
                Root$TableRow var10 = new Root$TableRow();

                for(int var11 = 0; var11 < 4; ++var11) {
                    Root$TableCell var12 = var10.addCell("");
                    var12.addClass("spacer");
                }

                var3.add(var10);
            }

            var5 = var9.team;
            String var20 = "unnamed";
            if (var9.name != null) {
                var20 = var9.name;
            }

            String var22 = var9.getStatus();
            String var23 = Integer.toString(var9.site + 1);
            boolean var13 = var9.b();
            if (var13) {
                var23 = "S";
            }

            if (!var13 && var9.startUnit != null && var9.startUnit != var1.netEngine.gameMapData.initUnit) {
                var23 = var23 + " - " + var1.netEngine.d(var9.startUnit);
            }

            String var14 = var9.getPlayerTeamName();
            var4 = new Root$TableRow();
            Root$TableCell var15 = var4.addCell(var20);
            if (var9.color != null) {
                var15.color = PlayerData.i(var9.color);
            }

            if (var9 == var1.netEngine.z) {
                var15.addClass("boldText");
            }

            Root$TableCell var16 = var4.addCell(var23);
            var16.color = var9.M();
            Root$TableCell var17 = var4.addCell(var14);
            var17.color = PlayerData.i(var9.team);
            var4.addCell(var22);
            var4.setLibrocketOnClick("mp.showPlayerConfig('" + var9.site + "')");
            var3.add(var4);
        }
    }

    public void showSetTeamsDialog() {
        GameEngine var1 = GameEngine.getGameEngine();
        ElementDocument var2 = this.root.createAndShowPopup("battleroom_setTeams.rml", (Object)null, "Set Teams");
        if (var2 != null) {
        }

    }

    public void showPlayerConfigForSelf() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.z != null) {
            this.showPlayerConfig("" + var1.netEngine.z.site);
        }

    }

    public void showPlayerConfig(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        ScriptEngine$Action var3 = this.scriptEngine.addRunnableToQueue(new Multiplayer$1(this, var1));
    }

    public void showPlayerConfigNow(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        int var3 = Integer.parseInt(var1);
        PlayerData var4 = PlayerData.getPlayerData(var3);
        if (var4 == null) {
            this.root.logWarn("showPlayerConfig: " + var1 + "==null");
        } else if (var2.netEngine.aw() || var2.netEngine.z == var4 && !var2.netEngine.gameMapData.m) {
            ElementDocument var5 = this.root.createAndShowPopup("battleroom_player.rml", var4, var4.name);
            if (var5 != null) {
                Element var6 = var5.getElementById("team_id");
                Element var7 = var5.getElementById("spawnPoint");
                Element var8 = var5.getElementById("allyTeam");
                Element var9 = var5.getElementById("aiDifficulty");
                Element var10 = var5.getElementById("startingUnits");
                Element var11 = var5.getElementById("playerColor");
                Element var12 = var5.getElementById("playerOverridesSection");
                Element var13 = var5.getElementById("aiDifficultySelection");
                if (!GameEngine.o("sd")) {
                    this.setupStartingUnitDropDown(var10, true);
                    this.setupPlayerColorDropDown(var11, true, true, var4);
                } else {
                    GameEngine.log("sd");
                }

                var6.setValue("" + var4.site);
                String var14 = "" + (var4.site + 1);
                if (var4.b()) {
                    var14 = "-2";
                }

                var7.setValue(var14);
                if (var4.u) {
                    var8.setValue("" + (var4.team + 1));
                } else {
                    var8.setValue("fromSpawn2");
                }

                if (var12 == null) {
                    throw new RuntimeException("playerOverridesSection==null");
                }

                if (!var2.netEngine.isServer) {
                    var12.hide();
                }

                if (var13 == null) {
                    throw new RuntimeException("aiDifficultySelection==null");
                }

                if (!GameEngine.o("s1")) {
                    if (var4.w) {
                        if (var4.aiDifficulty == null) {
                            var9.setValue("-99");
                        } else {
                            var9.setValue("" + var4.aiDifficulty);
                        }
                    } else {
                        var13.hide();
                    }
                } else {
                    GameEngine.log("s1");
                }

                if (!GameEngine.o("s2")) {
                    if (var4.startUnit == null) {
                        var10.setValue("-99");
                    } else {
                        GameEngine.log("startingUnitOverride: " + var4.startUnit);
                        var10.setValue("" + var4.startUnit);
                    }
                } else {
                    GameEngine.log("s2");
                }

                if (!GameEngine.o("s3")) {
                    if (var4.color == null) {
                        var11.setValue("-99");
                    } else {
                        GameEngine.log("playerColor: " + var4.color);
                        var11.setValue("" + var4.color);
                    }
                } else {
                    GameEngine.log("s3");
                }
            }

        }
    }

    public void teamsSet_apply() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.netEngine.isServer) {
            GameEngine.log("Not server");
        } else {
            GameEngine.log("playerConfig_kick");
            String var2 = this.libRocket.c().getElementById("teamLayout").getValue();
            if ("2t".equalsIgnoreCase(var2)) {
                var1.netEngine.a(Server_type.LAYOUT_2_SIDES);
            } else if ("3t".equalsIgnoreCase(var2)) {
                var1.netEngine.a(Server_type.LAYOUT_3_SIDES);
            } else if ("FFA".equalsIgnoreCase(var2)) {
                var1.netEngine.a(Server_type.LAYOUT_FFA);
            } else if ("spectators".equalsIgnoreCase(var2)) {
                var1.netEngine.a(Server_type.LAYOUT_SPECTATORS);
            } else {
                GameEngine.print("teamsSet_apply: unknown layout: " + var2);
            }

            this.refreshUI();
        }
    }

    public void playerConfig_kick() {
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.log("playerConfig_kick");
        String var2 = this.libRocket.c().getElementById("team_id").getValue();
        int var3 = Integer.parseInt(var2);
        PlayerData var4 = PlayerData.getPlayerData(var3);
        if (var4 == null) {
            this.root.logWarn("playerConfig_kick: " + var2 + "==null");
        } else {
            var1.netEngine.e(var4);
        }
    }

    public void playerConfig_apply() {
        GameEngine var1 = GameEngine.getGameEngine();
        GameEngine.log("playerConfig_kick");
        String var2 = this.libRocket.c().getElementById("team_id").getValue();
        int var3 = Integer.parseInt(var2);
        PlayerData var4 = PlayerData.getPlayerData(var3);
        if (var4 == null) {
            this.root.logWarn("playerConfig_apply: " + var2 + "==null");
        } else {
            ElementDocument var5 = this.libRocket.c();
            Element var6 = var5.getElementById("spawnPoint");
            Element var7 = var5.getElementById("allyTeam");
            Element var8 = var5.getElementById("aiDifficulty");
            Element var9 = var5.getElementById("startingUnits");
            Element var10 = var5.getElementById("playerColor");
            String var11 = var6.getValue();
            String var12 = var7.getValue();
            int var13 = Integer.valueOf(var11) - 1;
            boolean var14 = false;
            if (var13 == -3) {
                var14 = true;
            } else {
                if (var13 < 0) {
                    var13 = 1;
                }

                if (var13 > PlayerData.c - 1) {
                    var13 = PlayerData.c - 1;
                }
            }

            boolean var15 = false;
            int var16;
            boolean var17;
            if (var14) {
                var16 = -3;
                var17 = true;
            } else if (var12.equals("fromSpawn2")) {
                var16 = var13 % 2;
                var4.u = false;
                var17 = true;
            } else {
                var17 = false;
                var16 = var4.team;

                try {
                    var16 = Integer.valueOf(var12) - 1;
                } catch (NumberFormatException var22) {
                    var22.printStackTrace();
                }

                var4.u = true;
            }

            if (var4.team != var16) {
                if (var1.netEngine.isServer) {
                    var15 = true;
                } else if (!var1.netEngine.H && var1.netEngine.z != var4) {
                    GameEngine.b("row.setOnClickListener", "Clicked but not server or proxy controller");
                } else {
                    var15 = true;
                }
            }

            int var18;
            try {
                if (var4.site != var13) {
                    if (var1.netEngine.isServer) {
                        var15 = false;
                        var1.netEngine.setPlayerTeamSynchronized(var4, var13);
                        var4.team = var16;
                    } else if (!var1.netEngine.H && var1.netEngine.z != var4) {
                        GameEngine.b("row.setOnClickListener", "Clicked but not server or proxy controller");
                    } else {
                        var15 = false;
                        var18 = var16;
                        if (var17) {
                            var18 = -1;
                        }

                        var1.netEngine.a(var4, var13, var18);
                    }
                }
            } catch (NumberFormatException var23) {
                var23.printStackTrace();
            }

            Integer var19;
            if (var4.w) {
                var18 = var8.getValueAsInt(-99);
                if (var18 == -99) {
                    var19 = null;
                } else {
                    var19 = var18;
                }

                if (var4.aiDifficulty != var19) {
                    if (var1.netEngine.isServer) {
                        var4.aiDifficulty = var19;
                    } else {
                        GameEngine.log("aiDifficultyOverride: not server or proxy controller");
                    }
                }
            }

            var18 = var9.getValueAsInt(-99);
            GameEngine.log("startingUnits now: " + var18);
            if (var18 == -99) {
                var19 = null;
            } else {
                var19 = var18;
            }

            if (var4.startUnit != var19) {
                if (var1.netEngine.isServer) {
                    var4.startUnit = var19;
                } else {
                    GameEngine.log("startingUnitOverride: not server or proxy controller");
                }
            }

            int var20 = var10.getValueAsInt(-99);
            GameEngine.log("playerColor now: " + var20);
            Integer var21;
            if (var20 == -99) {
                var21 = null;
            } else {
                var21 = var20;
            }

            if (var4.color != var21) {
                if (var1.netEngine.isServer) {
                    var4.color = var21;
                } else {
                    GameEngine.log("colorOverride: not server or proxy controller");
                }
            }

            if (var15) {
                if (var1.netEngine.isServer) {
                    var4.team = var16;
                } else if (var17) {
                    var1.netEngine.b(var4, -1);
                } else {
                    var1.netEngine.b(var4, var16);
                }
            }

            var1.netEngine.f();
            var1.netEngine.M();
            this.refreshUI();
        }
    }

    public void disconnect(String var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        var2.netEngine.closeServer(var1);
    }

    public void multiplayerBackPrompt() {
        String var1 = class_1009.a("menus.ingame.multiplayerClose.title");
        String var2 = "What would you like to do?";
        String var3 = class_1009.a("menus.ingame.multiplayerClose.disconnectButton") + ":";
        var3 = var3 + "closePopup(); mp.disconnect('exited'); back();";
        boolean var4 = true;
        this.root.showPopup(var1, var2, var4, var3, (String)null);
    }

    public void surrenderPrompt() {
        String var1 = class_1009.a("menus.ingame.surrender.title");
        String var2 = class_1009.a("menus.ingame.surrender.message");
        String var3 = class_1009.a("menus.ingame.surrender.surrenderButton") + ":";
        var3 = var3 + "closePopup(); mp.surrender();";
        boolean var4 = true;
        this.root.showPopup(var1, var2, var4, var3, (String)null);
    }

    public void surrender() {
        GameEngine.log("Surrender requested");
        this.root.sendChatMessage("-surrender");
    }

    public void multiplayerExitPrompt() {
        String var1 = class_1009.a("menus.ingame.multiplayerClose.titleDisconnect");
        String var2 = class_1009.a("menus.ingame.multiplayerClose.messageDisconnect");
        GameEngine var3 = GameEngine.getGameEngine();
        String var4 = class_1009.a("menus.ingame.multiplayerClose.disconnectButton") + ":";
        var4 = var4 + "closePopup(); mp.disconnect('exited'); showMainMenu();";
        String var5 = null;
        if (var3.netEngine.isServer) {
            var1 = class_1009.a("menus.ingame.multiplayerClose.title");
            var2 = class_1009.a("menus.ingame.multiplayerClose.messageEndGame");
            var4 = class_1009.a("menus.ingame.exitGame") + ":";
            var4 = var4 + "closePopup(); mp.disconnect('exited'); showMainMenu();";
            var5 = class_1009.a("menus.ingame.multiplayerClose.returnToBattleroom") + ":";
            var5 = var5 + "closePopup(); mp.sendReturnToBattleroomEvent();";
        }

        boolean var6 = true;
        this.root.showPopup(var1, var2, var6, var4, var5);
    }

    public void sendReturnToBattleroomEvent() {
        GameEngine.log("mp.sendReturnToBattleroomEvent()");
        GameEngine var1 = GameEngine.getGameEngine();
        var1.netEngine.ag();
        var1.bS.u = false;
    }

    public void addAI() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.isServer) {
            var1.netEngine.ap();
        } else if (var1.netEngine.H) {
            var1.netEngine.k("-addai");
        } else {
            this.root.logWarn("addAI(): Clicked but not server or proxy controller");
        }

    }

    public String _getRandomDefaultPlayerName() {
        return "Unnamed" + class_340.rand(0, 999);
    }

    public void loadUsername() {
        GameEngine.log("mp.loadUsername()");
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = var1.settingsEngine.lastNetworkPlayerName;
        Element var3 = this.libRocket.getActiveElementById("username");
        String var4 = SteamEngine.getSteamEngine().c();
        GameEngine.log("steamName:" + var4);
        if (var4 != null && var2 == null) {
            var2 = var4;
        }

        if (var2 == null || "".equals(var2)) {
            var2 = this._getRandomDefaultPlayerName();
        }

        var3.loadCharsetIfNeeded(var2);
        var3.setAttribute("value", var2);
    }

    public void getUsernameFromInterface() {
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = this.root.getValueById("username");
        if (var2 == null) {
            GameEngine.print("getUsernameFromInterface: Cannot find username");
        } else {
            var2 = var2.trim();
            GameEngine.log("set username:" + var2);
            if (var2.equals("")) {
                var2 = this._getRandomDefaultPlayerName();
            }

            var1.netEngine.a(var2);
        }
    }

    public void gameOptionsGet() {
        this.gameOptionsGetOrPush(false);
    }

    public void gameOptionsPush() {
        this.gameOptionsGetOrPush(true);
    }

    public void gameOptionsRefreshTypes() {
        GameEngine var1 = GameEngine.getGameEngine();
        ElementDocument var2 = this.libRocket.c();
        if (this.useMapDropdown) {
            this.updateMapDropdown(var2, "mapsSelector", "typeSelector");
        }

    }

    public void gameOptionsGetOrPush(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        ElementDocument var3 = this.libRocket.c();
        Element var4 = var3.getElementById("fogMode");
        Element var5 = var3.getElementById("startingCredits");
        Element var6 = var3.getElementById("incomeMultiplier");
        Element var7 = var3.getElementById("noNukes");
        Element var8 = var3.getElementById("sharedControl");
        Element var9 = var3.getElementById("aiDifficulty");
        Element var10 = var3.getElementById("startingUnits");
        if (!var1) {
            this.setupStartingUnitDropDown(var10, false);
        }

        Element var11 = var3.getElementById("typeSelector");
        Element var12 = this.getMapDropdown();
        if (!var1) {
            if (var2.netEngine.gameMapData.mapType == null) {
                GameEngine.log("gameOptionsGetOrPush: game.network.setup.currentType==null");
            } else {
                var11.setValue("" + var2.netEngine.gameMapData.mapType.ordinal());
            }

            if (this.useMapDropdown) {
                this.updateMapDropdown(var3, "mapsSelector", "typeSelector");
                var12 = this.getMapDropdown();
                GameEngine.log("new currentMapSelection=" + var2.netEngine.gameMapData.mapName);
                var12.setValue("" + var2.netEngine.gameMapData.mapName);
            }

            var11 = var3.getElementById("typeSelector");
            var4.setValue("" + var2.netEngine.gameMapData.fog);
            var5.setValue("" + var2.netEngine.gameMapData.credits);
            var10.setValue("" + var2.netEngine.gameMapData.initUnit);
            var2.netEngine.gameMapData.e = true;
            var7.setCheckbox(var2.netEngine.gameMapData.nukes);
            var8.setCheckbox(var2.netEngine.gameMapData.sharedControl);
            var6.setValue("" + class_340.a(var2.netEngine.gameMapData.income, 1) + "x");
            var9.setValue("" + var2.netEngine.gameMapData.aidiff);
        } else {
            GameMapData var13 = var2.netEngine.e();
            if (var13 != null) {
                String var14 = null;
                if (this.useMapDropdown) {
                    var14 = var12.getValue();
                    if (var14 == null) {
                        GameEngine.log("gameOptionsGetOrPush: mapDropdownSelected==null");
                        var14 = "<No Map>";
                    }
                }

                int var15 = var11.getValueAsInt(0);
                MapType var16 = var13.mapType;
                var13.mapType = MapType.values()[var15];
                if (this.useMapDropdown) {
                    var13.mapName = var14;
                } else if (var16 != var13.mapType) {
                    var13.mapName = null;
                }

                var13.fog = var4.getValueAsInt((Integer)null);
                var13.credits = var5.getValueAsInt((Integer)null);
                String var17 = var6.getValue();
                var17 = var17.replace("x", "");
                float var18 = 1.0F;

                try {
                    var18 = Float.parseFloat(var17);
                } catch (NumberFormatException var20) {
                    var20.printStackTrace();
                }

                var13.income = var18;
                var13.nukes = var7.getCheckbox();
                var13.sharedControl = var8.getCheckbox();
                var13.aidiff = var9.getValueAsInt((Integer)null);
                var13.initUnit = var10.getValueAsInt(1);
                var2.netEngine.a(var13);
            }

        }
    }

    public void closeBattleroomIfOpen() {
        GameEngine var1 = GameEngine.getGameEngine();
        Element var2 = this.libRocket.getActiveElementById("battleroomPage");
        if (var2 == null) {
            GameEngine.log("closeBattleroomIfOpen: battleroomPage==null");
        } else {
            this.libRocket.backToLastDocument();
        }
    }

    public void reinviteAsk() {
        String var1 = class_1009.a("menus.ingame.multiplayerReinvite.title");
        String var2 = "While in-game you can only reinvite players who were in-game before but dropped out";
        String var3 = "reInvite:";
        var3 = var3 + "closePopup(); mp.showSteamInviteDialog();";
        boolean var4 = true;
        this.root.showPopup(var1, var2, var4, var3, (String)null);
    }

    public void showSteamInviteDialog() {
        SteamEngine var1 = SteamEngine.getSteamEngine();
        var1.g();
    }

    public void setMapFromPopup(String var1) {
        if (!this.isInControlOfServer()) {
            String var5 = this.root.getMapNameFromPath(var1);
            String var6 = "clicked on '" + var5 + "'";
            this.root.sendChatMessage(var6);
            this.root.closePopup();
        } else {
            GameEngine var2 = GameEngine.getGameEngine();
            GameMapData var3 = var2.netEngine.e();
            if (var3 != null) {
                String var4 = var1;
                if (!var1.contains("MOD|")) {
                    var4 = class_340.k(var1);
                }

                var3.mapName = var4;
                var2.netEngine.a(var3);
            }

            this.root.closePopup();
        }
    }

    public void showMapSelect() {
        String var1 = this.root.getModeMapPath((Element)null, (String)null);
        this.root.showMapPopup(var1, "mp.setMapFromPopup");
    }

    public boolean isInControlOfServer() {
        GameEngine var1 = GameEngine.getGameEngine();
        boolean var2 = var1.netEngine.isServer || var1.netEngine.H;
        return var2;
    }

    public void askPassword() {
        GameEngine.log("mp.askPassword()");
        GameEngine var1 = GameEngine.getGameEngine();
        String var2 = "Password Required";
        String var3 = "This server requires a password to join";
        String var4 = "";
        this.root.showInputPopupNonClose(var2, var3, var4, "Close:mp.cancelPaswordAsk()", "[onenter]Join:mp.askPasswordEntered(getPopupText())");
    }

    public void askPasswordEntered(String var1) {
        GameEngine.log("mp.askPasswordEntered()");
        GameEngine var2 = GameEngine.getGameEngine();
        var2.netEngine.passwd = var1;
        var2.netEngine.X();
        this.root.closePopup();
    }

    public void cancelPaswordAsk() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var1.netEngine.isServer) {
            this.root.logWarn("cancelPaswordAsk: we are the server");
        } else {
            var1.netEngine.closeServer("Cancel password");
            this.closeBattleroomIfOpen();
        }

        this.root.closePopup();
    }

    public void setupStartingUnitDropDown(Element var1, boolean var2) {
        String var3 = "";
        if (var2) {
            var3 = var3 + this.generateOption("-99", class_1009.a("menus.settings.option.default"), false);
        }

        Multiplayer$DropdownOption var5;
        for(Iterator var4 = this.getStartingUnitOptions().iterator(); var4.hasNext(); var3 = var3 + this.generateOption(var5.key, var5.value, false)) {
            var5 = (Multiplayer$DropdownOption)var4.next();
        }

        var1.setInnerRML(var3);
    }

    public void setupPlayerColorDropDown(Element var1, boolean var2, boolean var3, PlayerData var4) {
        GameEngine var5 = GameEngine.getGameEngine();
        String var6 = "";
        if (var2) {
            var6 = var6 + this.generateOption("-99", class_1009.a("menus.settings.option.default"), false);
        }

        for(int var7 = 0; var7 < 10; ++var7) {
            boolean var8 = false;
            if (var3 && var5.netEngine.a(var7, var4)) {
                var8 = true;
            }

            String var9 = PlayerData.j(var7);
            var9 = class_675.d(var9);
            int var10 = var7;
            int var11 = var7;
            if (var8) {
                var9 = var9 + " (used)";
                var10 = -7829368;
                var11 = -99;
            }

            var6 = var6 + this.generateOption("" + var11, var9, false, PlayerData.i(var10), var8);
        }

        var1.setInnerRML(var6);
    }

    public ArrayList getStartingUnitOptions() {
        GameEngine var1 = GameEngine.getGameEngine();
        ArrayList var2 = new ArrayList();
        Iterator var3 = var1.netEngine.i().iterator();

        while(var3.hasNext()) {
            Integer var4 = (Integer)var3.next();
            String var5 = var1.netEngine.d(var4);
            var2.add(new Multiplayer$DropdownOption(var4.toString(), var5));
        }

        return var2;
    }
}
