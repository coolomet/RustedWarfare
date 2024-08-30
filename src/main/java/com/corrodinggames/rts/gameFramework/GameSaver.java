package com.corrodinggames.rts.gameFramework;

import com.corrodinggames.rts.game.Player;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.ScorchMark;
import com.corrodinggames.rts.game.class_140;
import com.corrodinggames.rts.game.a.class_138;
import com.corrodinggames.rts.game.units.EditorOrBuilder;
import com.corrodinggames.rts.game.units.class_31;
import com.corrodinggames.rts.game.units.UnitType;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.UnitException;
import com.corrodinggames.rts.game.units.custom.class_436;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.gameFramework.d.Emitter;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.n.class_70;
import com.corrodinggames.rts.gameFramework.net.GameInputStream;
import com.corrodinggames.rts.gameFramework.net.GameNetEngine;
import com.corrodinggames.rts.gameFramework.net.GameOutputStream;
import com.corrodinggames.rts.gameFramework.net.class_489;
import com.corrodinggames.rts.gameFramework.utility.AssetInputStream;
import com.corrodinggames.rts.gameFramework.utility.class_682;
import lombok.SneakyThrows;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public strictfp class GameSaver {
    public static boolean a = false;
    final boolean b;
    int c;
    int d;

    public GameSaver() {
        if (!GameEngine.as) {
        }

        this.b = false;
        this.c = -9999;
        this.d = -9999;
    }

    public strictfp File a(String var1, boolean var2) {
        return a(var1, "saves/", var2);
    }

    public static strictfp File a(String var0, String var1, boolean var2) {
        return class_697.a(var0, var1, var2);
    }

    public strictfp void b(String var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();
        String var4 = var1;
        if (var1 != null && !var1.endsWith(".rwsave")) {
            var4 = var1 + ".rwsave";
        }

        String var5 = "SD card";
        File var6 = null;
        boolean var7 = false;

        String var9;
        try {
            var6 = this.a(var4 + ".tmp", true);
            if (var6.exists()) {
                var6 = this.a(var4 + ".tmp2", true);
            }

            File var8 = this.a(var4, true);
            var5 = var8.getAbsolutePath();
            GameEngine.log("Saving game to: " + var5);
            OutputStream var27 = class_697.a(var6, false);
            BufferedOutputStream var28 = new BufferedOutputStream(var27);
            if (!a) {
                DataOutputStream var11 = new DataOutputStream(var28);
                GameOutputStream var12 = new GameOutputStream(var11);

                try {
                    this.a(var12);
                } finally {
                    var11.close();
                    var28.close();
                    var27.close();
                }
            } else {
                PrintStream var29 = new PrintStream(var28);
                class_489 var31 = new class_489(var29);

                try {
                    this.a((GameOutputStream)var31);
                } finally {
                    var29.close();
                    var28.close();
                    var27.close();
                }

                GameEngine.n("DEBUG plain text save created");
            }

            boolean var30;
            if (var2 && GameEngine.at() && class_697.i(var8.getAbsolutePath())) {
                GameEngine.log("Autosave file already exists: " + var8.getAbsolutePath());
                var30 = class_697.b(var8);
                if (!var30) {
                    GameEngine.log("Old autosave failed to delete");
                }
            }

            GameEngine.log("Finished writing save, renaming to final filename");
            var30 = class_697.b(var6, var8);
            if (!var30) {
                GameEngine.log("Failed to rename to final file");
                throw new IOException("Failed to rename to final file. Check file permissions of storage.");
            }

            class_697.c(var8);
            var7 = true;
        } catch (Exception var25) {
            if (var2) {
                GameEngine.log("Auto save failed: " + var25.getMessage());
                return;
            }

            var25.printStackTrace();
            var9 = class_340.b(var25);
            String var10 = "Error saving game, please check permissions, disk space, etc. (" + var9 + ")";
            var3.log(var10, 1);
            if (var6 != null && class_697.i(var6.getAbsolutePath())) {
                GameEngine.log("saveGame: Removing temp save file after crash");
                class_697.b(var6);
            }
        } catch (OutOfMemoryError var26) {
            var26.printStackTrace();
            var9 = "Error. Run out of memory error while saving game to " + var5 + ".";
            var3.log(var9, 1);
            if (var6 != null && class_697.i(var6.getAbsolutePath())) {
                GameEngine.log("saveGame: Removing temp save file after crash");
                class_697.b(var6);
            }
        }

        if (var7) {
            if (var2) {
                var3.bS.i.a("Auto Saved", 1000);
            } else {
                var3.bS.h.a((String)null, "Game saved");
            }
        }

    }

    @SneakyThrows
    public strictfp void a(GameOutputStream var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        long var3 = System.currentTimeMillis();
        GameEngine.b("GameSaver", "saveCurrentMap took:" + (System.currentTimeMillis() - var3));
        long var5 = System.currentTimeMillis();

        try {
            var1.writeString("rustedWarfareSave");
            int var7 = var2.c(true);
            var1.writeInt(var7);
            var1.writeInt(96);
            var1.writeBoolean(var2.ar);
            var1.startBlock("saveCompression", true);
            var1.e("customUnitsBlock");
            class_591.a(var1);
            var1.endBlock("customUnitsBlock");
            var1.e("gameSetup");
            boolean var8 = var2.netEngine.B || var2.netEngine.F;
            var1.writeBoolean(var2.netEngine.B);
            var1.writeBoolean(var2.netEngine.F);
            var1.writeBoolean(var8);
            if (var8) {
                var2.netEngine.a(var1);
            }

            var1.endBlock("gameSetup");
            var1.writeString(var2.dl);
            boolean var9 = var2.dm != null;
            var1.writeBoolean(var9);
            if (var9) {
                GameEngine.log("Writing remote map steam into save");
                var1.a(var2.dm);
            }

            var1.writeInt(var2.by);
            var1.writeFloat(var2.cy + var2.cI);
            var1.writeFloat(var2.cz + var2.cJ);
            var1.writeFloat(var2.cV);
            var1.writeInt(var2.bV.a);
            var1.writeInt(0);
            var1.e();
            var2.bL.a(var1);
            var1.writeBoolean(var2.bv);
            var1.writeBoolean(var2.bL.E);
            var1.writeBoolean(var2.bL.F);
            var1.writeBoolean(var2.bL.G);
            var1.writeBoolean(var2.ce != null);
            if (var2.ce != null) {
                var2.ce.a(var1);
            }

            var1.e();
            int var10 = -1;
            if (var2.playerTeam != null) {
                var10 = var2.playerTeam.site;
            }

            var1.writeInt(var10);
            var1.writeInt(PlayerData.c);

            int var11;
            PlayerData var12;
            for(var11 = 0; var11 < PlayerData.c; ++var11) {
                var12 = PlayerData.getPlayerData(var11);
                var1.writeBoolean(var12 instanceof class_138);
                var1.writeBoolean(var12 instanceof class_140);
                var1.writeBoolean(var12 != null);
                if (var12 != null) {
                    var12.b(var1);
                }
            }

            if (!var2.bS.e) {
            }

            var1.d("Section: unit shells");
            var1.writeInt(GameObject.er.size());

            Iterator var16;
            GameObject var17;
            String var18;
            for(var16 = GameObject.er.iterator(); var16.hasNext(); var1.writeLong(var17.id)) {
                var17 = (GameObject)var16.next();
                if (var17 == null) {
                    throw new RuntimeException("Found null in fastGameObjectList");
                }

                if (var17 instanceof Unit) {
                    Unit var13 = (Unit)var17;
                    if (var13.r() instanceof UnitType) {
                        var1.writeByte(1);
                        var1.writeSimilarEnum((UnitType)var13.r());
                    } else {
                        if (!(var13.r() instanceof class_591)) {
                            throw new IOException("Unhandled getUnitType on save:" + var13.r().getClass().toString());
                        }

                        var1.writeByte(3);
                        String var14 = ((class_591)var13.r()).M;
                        var1.writeString(var14);
                    }
                } else {
                    var1.writeByte(2);
                    if (var17 instanceof ScorchMark) {
                        var1.writeByte(1);
                    } else if (var17 instanceof Projectile) {
                        var1.writeByte(2);
                    } else {
                        if (!(var17 instanceof Emitter)) {
                            var18 = null;
                            if (var17.getClass() != null) {
                                var18 = var17.getClass().toString();
                            }

                            throw new IOException("Unhandled class on save: " + var18);
                        }

                        var1.writeByte(3);
                    }
                }
            }

            var1.d("Section: CurrentUnitId");
            var1.writeLong(var2.netEngine.z());
            var2.bV.a(var1);
            var2.bS.a(var1);
            var2.stats.a(var1);

            for(var11 = 0; var11 < PlayerData.c; ++var11) {
                var12 = PlayerData.getPlayerData(var11);
                if (var12 != null) {
                    var12.a(var1);
                }
            }

            var1.e();
            var16 = GameObject.er.iterator();

            while(true) {
                if (!var16.hasNext()) {
                    var1.endBlock("saveCompression");
                    var1.e();
                    var1.writeString("<SAVE END>");
                    break;
                }

                var17 = (GameObject)var16.next();
                if (var1.f()) {
                    var18 = var17.getClass().getSimpleName();
                    if (var17 instanceof Unit) {
                        var18 = ((Unit)var17).r().i();
                    }

                    var1.d("Saving unit:" + var18 + " (id" + var17.id + ")");
                }

                var17.a(var1);
                var1.e();
            }
        } catch (IOException var15) {
            var15.printStackTrace();
            throw var15;
        }

        GameEngine.b("GameSaver", "saveGame took:" + (System.currentTimeMillis() - var5));
    }

    public strictfp String a(String var1) {
        if (var1 == null) {
            return null;
        } else if (var1.equals("maps/normal/l010;mission_1__-__Dividing_River.tmx")) {
            return "maps/normal/l010;[demo]mission_1__-__Dividing_River.tmx";
        } else {
            return var1.equals("maps/normal/l030;mission_3__-__Crossfire.tmx") ? "maps/normal/l030;[demo]mission_3__-__Crossfire.tmx" : var1;
        }
    }

    public strictfp boolean c(String var1, boolean var2) {
        GameEngine var3 = GameEngine.getGameEngine();

        try {
            File var4 = this.a(var1, false);
            if (var4.isDirectory()) {
                var3.log("Could not load, is a directory", 1);
                return false;
            } else {
                AssetInputStream var5 = class_697.k(var4.getAbsolutePath());
                if (var5 == null) {
                    var3.log("Could not load, failed to open: " + class_697.d(var4.getAbsolutePath()), 1);
                    return false;
                } else {
                    BufferedInputStream var6 = new BufferedInputStream(var5);
                    DataInputStream var7 = new DataInputStream(var6);
                    GameInputStream var8 = new GameInputStream(var7);

                    boolean var9;
                    try {
                        var9 = this.a(var8, var2, false, false);
                    } finally {
                        var7.close();
                        var6.close();
                        var5.close();
                    }

                    return var9;
                }
            }
        } catch (Exception var14) {
            throw new RuntimeException(var14);
        }
    }

    @SneakyThrows
    public strictfp void a(String var1, GameOutputStream var2) {
        File var3 = this.a(var1, false);
        if (var3 == null) {
            throw new IOException("Failed to get game save: " + var1);
        } else {
            var2.a(var3);
        }
    }

    public strictfp synchronized boolean a(GameInputStream var1, boolean var2, boolean var3, boolean var4) {
        GameEngine var5 = GameEngine.getGameEngine();

        Iterator var8;
        try {
            com.corrodinggames.rts.gameFramework.Unit var6 = var5.cd;
            if (this.b) {
                var6.a(class_324.y);
            }

            ArrayList var41 = null;
            if (var4) {
                var41 = new ArrayList();
                var8 = var5.bS.bZ.iterator();

                while(var8.hasNext()) {
                    Unit var43 = (Unit)var8.next();
                    var41.add(var43.id);
                }
            }

            String var10;
            String var42;
            try {
                var42 = var1.readString();
            } catch (Exception var38) {
                var38.printStackTrace();
                var10 = "Failed to load save. (Failed to read header: " + var38.getMessage() + ")";
                GameEngine.print(var10);
                var5.log(var10, 1);
                return false;
            }

            if (!var42.equals("rustedWarfareSave")) {
                GameEngine.print("Map Load: Header is not correct:" + var42.substring(0, Math.min(var42.length(), 50)));
                String var45 = "Failed to load save. (Could not find correct header)";
                if (var42.equals("rustedWarfareReplay")) {
                    var45 = "Failed to load save. (This file appears to be a replay file, not a save file)";
                }

                GameEngine.print(var45);
                var5.log(var45, 1);
                return false;
            } else {
                var1.readInt();
                int var44 = var1.readInt();
                GameEngine.b("gameSaver", "Loading save from version: " + var44);
                var1.a(var44);
                if (var44 > 96) {
                    var5.log("Cannot load: This save was made with a newer game", 1);
                    return false;
                } else {
                    if (var44 >= 5) {
                        var1.readBoolean();
                    }

                    if (var44 >= 23) {
                        var6.a(class_324.B);
                        var1.a("saveCompression", true);
                        var6.b(class_324.B);
                    }

                    if (var44 >= 54) {
                        var1.startBlock("customUnitsBlock");
                        if (var5.replayEngine.j() && !var4) {
                            GameEngine.log("Loading mods from replay");

                            try {
                                class_591.a(var1);
                                class_436.d();
                            } catch (Exception ex) {
                                if (ex instanceof UnitException) {
                                    UnitException var36 = (UnitException) ex;
                                    GameEngine.log("Replay load: Missing unit:" + var36.getMessage() + " d:" + var36.b);
                                    var5.i(var36.getMessage() + ", this is likely to cause the replay to desync (reverting to default units & mods)");
                                    class_436.b(true);
                                }
                            }
                        }

                        var1.endBlock("customUnitsBlock");
                    }

                    Integer var46 = null;
                    Integer var11 = null;
                    if (var5.replayEngine.j() && var4) {
                        var46 = var5.bB;
                        var11 = var5.bC;
                    }

                    boolean var13;
                    if (var44 >= 56) {
                        var1.startBlock("gameSetup");
                        boolean var12 = var1.readBoolean();
                        var13 = var12;
                        boolean var14 = false;
                        if (var44 >= 94) {
                            var14 = var1.readBoolean();
                            var13 = var1.readBoolean();
                        }

                        boolean var15 = var5.replayEngine.j() || !var5.netEngine.B;
                        if (var15 && !var4 && var13) {
                            GameEngine.log("Using game rules from save");
                            var5.replayEngine.O = true;
                            var5.netEngine.a(var1);
                            var46 = var5.bB;
                            var11 = var5.bC;
                            if ((var12 || var14) && !var5.netEngine.F && !var5.netEngine.B && !var5.replayEngine.j()) {
                                GameEngine.log("Enabling use of singlePlayer rules from saved game.");
                                var5.netEngine.F = true;
                            }
                        }

                        var1.endBlock("gameSetup");
                    }

                    var5.dm = null;
                    String var47 = var1.readString();
                    var47 = class_697.o(var47);
                    var5.dl = this.a(var47);
                    var13 = false;
                    if (var44 >= 72) {
                        var13 = var1.readBoolean();
                        if (var13) {
                            GameEngine.log("Reading remote map stream");
                            var5.dm = var1.u();
                        }
                    }

                    if (var5.netEngine.B && !var5.netEngine.isServer && var4 && var5.netEngine.aB != null && !var13) {
                        var5.dl = "";
                        var5.dm = var5.netEngine.aB;
                    }

                    var6.a(class_324.z);
                    if (var4) {
                        var5.a(true, true, class_337.NORMAL_SAVE);
                        if (GameEngine.at()) {
                            var5.dv = true;
                        }
                    } else {
                        var5.a(true, class_337.NORMAL_SAVE);
                    }

                    if (!var5.bL.W) {
                        GameEngine.log("Not loading save because map failed to load");
                        return false;
                    } else {
                        if (var46 != null) {
                            var5.bB = var46;
                        }

                        if (var11 != null) {
                            var11 = var5.bC;
                        }

                        synchronized(var5) {
                            var6.b(class_324.z);
                            var5.by = var1.readInt();
                            float var48 = var1.readFloat();
                            float var16 = var1.readFloat();
                            float var17 = var1.readFloat();
                            if (!var4) {
                                var5.b(var48, var16);
                                var5.cV = var17;
                            }

                            if (var44 >= 18) {
                                var5.bV.a = var1.readInt();
                            }

                            var1.readInt();
                            if (var44 >= 19) {
                                var1.checkMark("end of setup");
                            }

                            var5.bL.a(var1);
                            boolean var18;
                            if (var44 >= 86) {
                                var18 = var1.readBoolean();
                                boolean var19 = var1.readBoolean();
                                boolean var20 = var1.readBoolean();
                                boolean var21 = var1.readBoolean();
                                if (!var2 && !var18) {
                                    var5.bL.E = var19;
                                    var5.bL.F = var20;
                                    var5.bL.G = var21;
                                }
                            }

                            var18 = var1.readBoolean();
                            if (var18) {
                                if (var5.ce == null) {
                                    GameEngine.b("gameSaver", "making new mission engine on load, this shouldn't happen");
                                    var5.ce = new class_70();
                                    var5.ce.a(false);
                                }

                                var5.ce.a(var1);
                            }

                            if (var44 >= 19) {
                                var1.checkMark("start of teams");
                            }

                            GameEngine.b("gameSaver", "loading teams");
                            PlayerData[] var49 = new PlayerData[PlayerData.e];
                            int var50 = -1;
                            if (var44 >= 36) {
                                var50 = var1.readInt();
                            }

                            int var51 = 8;
                            int var22;
                            if (var44 >= 49) {
                                var51 = var1.readInt();
                                PlayerData.b(var51, false);

                                for(var22 = 0; var22 < PlayerData.c; ++var22) {
                                    if (var22 >= var51 && !var2) {
                                        PlayerData var23 = PlayerData.getPlayerData(var22);
                                        if (var23 != null) {
                                            var23.I();
                                        }
                                    }
                                }
                            }

                            Integer var28;
                            for(var22 = 0; var22 < var51; ++var22) {
                                Object var53 = PlayerData.getPlayerData(var22);
                                Object var24 = var53;
                                boolean var25 = var1.readBoolean();
                                boolean var26 = false;
                                if (var44 >= 7) {
                                    var26 = var1.readBoolean();
                                }

                                boolean var27 = var1.readBoolean();
                                if (var27) {
                                    if (var25) {
                                        if (var53 == null || !(var53 instanceof class_138)) {
                                            if (var2 && !var4 && var53 != null) {
                                                GameEngine.print("Would replace team:" + var22 + " with AI, writing to dummy AI");
                                                var53 = new class_138(var22, false);
                                                var49[var22] = (PlayerData)var53;
                                            } else {
                                                if (var4) {
                                                    GameEngine.print("Adding new AI " + var22 + " on resync");
                                                }

                                                var53 = new class_138(var22);
                                            }
                                        }
                                    } else if (var26) {
                                        if (var53 == null || !(var53 instanceof class_140)) {
                                            if (var2) {
                                                GameEngine.print("Replacing team:" + var22 + " with NetworkedPlayer");
                                            }

                                            var53 = new class_140(var22);
                                        }
                                    } else if (var53 == null || !(var53 instanceof Player)) {
                                        if (var2) {
                                            GameEngine.print("Replacing team:" + var22 + " with Player");
                                            if (var53 != null) {
                                                ((PlayerData)var53).c("Existing");
                                            }
                                        }

                                        var53 = new Player(var22);
                                    }

                                    var28 = ((PlayerData)var53).aiDifficulty;
                                    if (var44 >= 2) {
                                        ((PlayerData)var53).b(var1);
                                    } else {
                                        ((PlayerData)var53).c(var1);
                                    }

                                    if (!var4) {
                                        ((PlayerData)var53).i();
                                        if (var2) {
                                            ((PlayerData)var53).aiDifficulty = var28;
                                            ((PlayerData)var53).c("networkLoad aiDifficultyOverride=" + var28);
                                            var5.netEngine.a((PlayerData)var53);
                                            var5.netEngine.b((PlayerData)var53);
                                        }

                                        if (var24 != null && var53 != var24) {
                                            ((PlayerData)var24).c("Transfering team stats");
                                            ((PlayerData)var24).credits = ((PlayerData)var53).credits;
                                            ((PlayerData)var24).V().a(((PlayerData)var53).V());
                                        }
                                    }
                                } else if (var2 && !var5.replayEngine.j()) {
                                    GameEngine.print("GameSaver: Would normally remove team:" + var22 + "");
                                    var49[var22] = PlayerData.g;
                                } else {
                                    PlayerData var64 = PlayerData.getPlayerData(var22);
                                    if (var64 != null) {
                                        var64.I();
                                    }
                                }
                            }

                            boolean var52 = false;
                            boolean var55 = false;
                            var5.netEngine.aq();
                            if (var5.replayEngine.j()) {
                                var5.playerTeam = PlayerData.i;
                            } else {
                                int var54;
                                if (var5.netEngine.B) {
                                    if (var5.netEngine.z != null) {
                                        var54 = var5.netEngine.z.site;
                                        if (var54 != -3) {
                                            PlayerData var57 = PlayerData.getPlayerData(var54);
                                            if (var57 == null) {
                                                throw new RuntimeException("GameSaver: Cannot relink player team: " + var54);
                                            }

                                            var5.playerTeam = var57;
                                        }
                                    }
                                } else if (var50 != -1 && var50 != -3) {
                                    var5.playerTeam = PlayerData.getPlayerData(var50);
                                } else {
                                    for(var54 = 0; var54 < PlayerData.c; ++var54) {
                                        if (PlayerData.getPlayerData(var54) instanceof Player) {
                                            var5.playerTeam = PlayerData.getPlayerData(var54);
                                        }
                                    }
                                }
                            }

                            class_682 var56 = GameObject.dK();
                            Iterator var58 = var56.iterator();

                            GameObject var61;
                            while(var58.hasNext()) {
                                var61 = (GameObject)var58.next();
                                var61.a();
                            }

                            if (var5.aa()) {
                                var56 = GameObject.dK();
                                var58 = var56.iterator();

                                while(var58.hasNext()) {
                                    var61 = (GameObject)var58.next();
                                    if (var61.id == 0L) {
                                        if (var61 instanceof Unit) {
                                            GameEngine.log("object: " + ((Unit)var61).c());
                                        }

                                        throw new RuntimeException("GameLoad preload: Found object in list with id:0");
                                    }
                                }
                            }

                            boolean var59 = false;
                            int var60 = var1.readInt();

                            int var63;
                            int var67;
                            for(var63 = 0; var63 < var60; ++var63) {
                                Object var62 = null;
                                byte var66 = var1.readByte();
                                if (var66 == 1) {
                                    UnitType var69 = (UnitType)var1.readSimilarEnum(UnitType.class);
                                    if (var69 == UnitType.editorOrBuilder) {
                                        if (!var5.replayEngine.j() && !var5.bv) {
                                            GameEngine.log("Creating DebugEditorBuilder for load");
                                            var62 = new EditorOrBuilder(false);
                                            var52 = true;
                                        } else {
                                            GameEngine.log("Creating DebugEditorBuilder for replay");
                                            var62 = new EditorOrBuilder(false);
                                            EditorOrBuilder var78 = var5.bS.i();
                                            if (var78 == null || var78.ej) {
                                                GameEngine.log("Relinking editor");
                                                var5.bS.a((EditorOrBuilder)var62);
                                            }
                                        }
                                    } else {
                                        var62 = var69.a();
                                    }
                                } else if (var66 == 3) {
                                    String var29 = var1.readString();
                                    class_591 var30 = class_591.n(var29);
                                    if (var30 == null) {
                                        String var31 = "Could not find custom unit:" + var29;
                                        GameEngine.log(var31);
                                        if (!var59) {
                                            var59 = true;
                                            GameNetEngine.g(var31);
                                        }

                                        var30 = class_591.b;
                                        if (var30 == null) {
                                            throw new RuntimeException("Could not find custom unit:" + var29 + " and missingPlaceHolder is null");
                                        }
                                    }

                                    class_31 var77 = class_591.c((class_31)var30);
                                    if (var77 != null) {
                                        if (var77 instanceof class_591) {
                                            var30 = (class_591)var77;
                                        } else {
                                            GameEngine.print("replacement not a custom unit:" + var77.i());
                                        }
                                    }

                                    var62 = var30.a();
                                } else {
                                    if (var66 != 2) {
                                        throw new IOException("Unhandled basic type on load:" + var66);
                                    }

                                    var67 = var1.readByte();
                                    if (var67 == 1) {
                                        var62 = new ScorchMark();
                                    } else if (var67 == 2) {
                                        var62 = new Projectile(false);
                                    } else {
                                        if (var67 != 3) {
                                            throw new IOException("Unhandled gameType on load:" + var67);
                                        }

                                        var62 = new Emitter(var5.bR);
                                    }
                                }

                                ((GameObject)var62).id = var1.readLong();
                                if (((GameObject)var62).id == 0L) {
                                    GameEngine.print("GameSaver: Adding object with id==0");
                                    if (var62 instanceof Unit) {
                                        GameEngine.print(((Unit)var62).cC());
                                    }

                                    var55 = true;
                                }

                                GameObject.dL();
                            }

                            if (var44 >= 3) {
                                long var65 = var1.readLong();
                                if (var65 <= 0L) {
                                    GameEngine.a("GameLoad: Trying to set next unit id <= 0: " + var65);
                                    var65 = 100000L;
                                }

                                var5.netEngine.a(var65);
                            } else {
                                var5.netEngine.a(100000L);
                            }

                            if (var44 >= 24) {
                                var5.bV.a(var1);
                            }

                            if (var44 >= 4) {
                                var5.bS.a(var1, var4);
                            }

                            if (var44 >= 57) {
                                var5.stats.a(var1, var4);
                            }

                            if (var44 >= 7) {
                                for(var63 = 0; var63 < var51; ++var63) {
                                    PlayerData var74 = PlayerData.getPlayerData(var63);
                                    if (var49[var63] != null) {
                                        var74 = var49[var63];
                                        if (var74 == PlayerData.g) {
                                            var74 = null;
                                        }
                                    }

                                    if (var74 != null) {
                                        var28 = var74.aiDifficulty;
                                        var74.c(var1);
                                        if (!var4) {
                                            if (var2) {
                                                var74.aiDifficulty = var28;
                                                var74.c("networkLoad2 aiDifficultyOverride=" + var28);
                                            }

                                            var5.netEngine.a(var74);
                                            var5.netEngine.b(var74);
                                        }
                                    }
                                }
                            } else if (var44 >= 2) {
                            }

                            if (var44 >= 10) {
                                var1.checkMark("Pre-unit data");
                            }

                            var6.a(class_324.A);
                            class_682 var71 = GameObject.dK();
                            GameEngine.b("gameSaver", "Loading unit data for " + var71.size() + " objects.");
                            Iterator var79 = var71.iterator();

                            while(var79.hasNext()) {
                                GameObject var68 = (GameObject)var79.next();
                                var68.a(var1);
                                if (var44 >= 10) {
                                    var1.checkMark("post unit: " + var68.getClass().toString() + " with id:" + var68.id);
                                }
                            }

                            GameEngine.b("gameSaver", "Loading unit data done.");
                            var6.b(class_324.A);
                            Unit var82;
                            if (var52) {
                                class_682 var81 = GameObject.dK();
                                Iterator var70 = var81.iterator();

                                while(var70.hasNext()) {
                                    GameObject var72 = (GameObject)var70.next();
                                    if (var72 instanceof Unit) {
                                        var82 = (Unit)var72;
                                        if (!var5.replayEngine.j() && !var5.bv && var82.r() == UnitType.editorOrBuilder) {
                                            var82.ci();
                                        }
                                    }
                                }
                            }

                            if (var44 >= 23) {
                                var1.endBlock("saveCompression");
                            }

                            if (var44 >= 19) {
                                var1.checkMark("End of Save");
                                var1.readString();
                            }

                            GameEngine.b("gameSaver", "Checking for ID overlaps");
                            int var83 = 0;
                            boolean var73 = true;
                            if (var73) {
                                GameObject[] var75 = GameObject.er.a();
                                int var84 = GameObject.er.size();

                                for(int var80 = 0; var80 < var84; ++var80) {
                                    GameObject var32 = var75[var80];
                                    if (var32.id == 0L) {
                                        GameEngine.print("GameSaver: Fixing object with zero id.");
                                        var32.id = var5.netEngine.y();
                                    }

                                    for(int var33 = var80 + 1; var33 < var84; ++var33) {
                                        GameObject var34 = var75[var33];
                                        if (var32 != var34 && var32.id == var34.id) {
                                            ++var83;
                                            var34.id = var5.netEngine.y();
                                        }
                                    }
                                }
                            }

                            GameEngine.b("gameSaver", "clearing out dead units.");
                            GameEngine.log("Unit.fastLiveUnitList before:" + Unit.bE.size());
                            Iterator var76 = Unit.bE.iterator();

                            while(var76.hasNext()) {
                                var82 = (Unit)var76.next();
                                if (var82.bV) {
                                    var76.remove();
                                }
                            }

                            GameEngine.log("Unit.fastLiveUnitList after:" + Unit.bE.size());
                            if (var83 > 0) {
                                if (var44 <= 2) {
                                    var5.log("Warning: " + var83 + " errors were found in this save, this is due to a bug in the old version", 1);
                                } else {
                                    var5.log("Warning: " + var83 + " errors were found in this save", 1);
                                }
                            }

                            GameEngine.b("gameSaver", "Fixing map cost.");
                            var5.bU.a((OrderableUnit)null);
                            var5.bU.b();
                            GameEngine.b("gameSaver", "Fixing map cost done.");
                            PlayerData.O();

                            PlayerData var89;
                            for(var67 = 0; var67 < PlayerData.c; ++var67) {
                                var89 = PlayerData.getPlayerData(var67);
                                if (var89 != null) {
                                    var89.d(false);
                                }
                            }

                            PlayerData.e();
                            GameEngine.b("gameSaver", "Rebuilt unit caches");
                            PlayerData.O();
                            PlayerData.Y();
                            PlayerData.i.d(false);
                            PlayerData.h.d(false);

                            for(var67 = 0; var67 < PlayerData.c; ++var67) {
                                var89 = PlayerData.getPlayerData(var67);
                                if (var89 != null && var89 instanceof class_138) {
                                    class_138 var85 = (class_138)var89;
                                    var85.aq();
                                }
                            }

                            if (var41 != null) {
                                var5.bS.y();
                                var76 = var41.iterator();

                                while(var76.hasNext()) {
                                    long var90 = (Long)var76.next();
                                    Unit var86 = GameObject.a(var90, true);
                                    if (var86 != null) {
                                        var5.bS.k(var86);
                                    }
                                }
                            }

                            if (var5.aa()) {
                                class_682 var87 = GameObject.dK();
                                Iterator var91 = var87.iterator();

                                while(var91.hasNext()) {
                                    GameObject var88 = (GameObject)var91.next();
                                    if (var88.id == 0L) {
                                        if (var88 instanceof Unit) {
                                            GameEngine.log("object: " + ((Unit)var88).c());
                                        }

                                        throw new RuntimeException("GameLoad postload: Found object in list with id:0");
                                    }
                                }
                            }

                            GameEngine.log("--- Save file load complete ---");
                            GameEngine.log("GameObject.fastGameObjectList:" + GameObject.er.size());
                            GameEngine.log("Unit.fastLiveUnitList:" + Unit.bE.size());
                            if (!var4) {
                                var5.replayEngine.a(var4);
                            }

                            if (this.b) {
                                var6.b(class_324.y);
                                var6.a(true, true);
                            }

                            return true;
                        }
                    }
                }
            }
        } catch (Exception var40) {
            var40.printStackTrace();
            GameEngine.log("Save load error, clearing all units");
            class_682 var7 = GameObject.dK();

            GameObject var9;
            for(var8 = var7.iterator(); var8.hasNext(); var9.a()) {
                var9 = (GameObject)var8.next();
                if (var9.id == 0L) {
                    var9.id = var5.netEngine.y();
                }
            }

            throw new RuntimeException(var40);
        }
    }

    public strictfp boolean b(String var1) {
        GameEngine.log("Deleting: " + var1);
        String var2 = class_697.o(var1);
        if (!var2.contains("\\") && !var2.contains("/")) {
            File var4 = this.a(var1, true);
            boolean var3 = class_697.b(var4);
            File var5 = this.a(var1 + ".map", true);
            class_697.b(var5);
            if (!var3) {
                GameEngine.log("Failed to delete: " + var4.getAbsolutePath());
                GameEngine.getGameEngine().i("Failed to delete: " + var4.getAbsolutePath());
            }

            return true;
        } else {
            GameEngine.log("Cannot get save with path: " + var1);
            return false;
        }
    }

    public strictfp void a(boolean var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        if (!var1) {
            this.c = -9999;
            this.d = -9999;
        }

    }

    public strictfp boolean a() {
        GameEngine var1 = GameEngine.getGameEngine();
        if (!var1.settingsEngine.autosaving) {
            return false;
        } else if (GameEngine.ax()) {
            return false;
        } else if (var1.bG && !var1.bH && !var1.replayEngine.j()) {
            return !var1.M();
        } else {
            return false;
        }
    }

    public strictfp void b() {
        int var1 = 300000;
        GameEngine var2 = GameEngine.getGameEngine();
        if (this.a()) {
            if (this.d == -9999) {
                this.c = var2.by;
                this.d = var2.by;
            }

            if (this.d + var1 < var2.by) {
                this.d = var2.by;
                long var3 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
                this.c();
                double var5 = (double) com.corrodinggames.rts.gameFramework.Unit.a(var3);
                GameEngine.log("Autosaved (" + com.corrodinggames.rts.gameFramework.Unit.a(var5) + ")");
            }

        }
    }

    public strictfp void c() {
        this.b("autosave", true);
    }
}
