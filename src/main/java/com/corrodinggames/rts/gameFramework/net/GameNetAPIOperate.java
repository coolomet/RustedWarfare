package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.appFramework.class_196;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.gameFramework.class_340;
import com.corrodinggames.rts.gameFramework.e.class_697;
import com.corrodinggames.rts.gameFramework.h.class_1009;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public strictfp class GameNetAPIOperate {
    public static boolean a = true;
    public static boolean b = true;
    public static String[] urlList = new String[]{"http://gs1.corrodinggames.com/masterserver/1.4", "http://gs4.corrodinggames.net/masterserver/1.4"};
    public static HTTPService d = new HTTPService();
    static int e;
    public static Object f = new Object();
    public static String g;

    public static void a(String var0) {
        if (b) {
            GameEngine.log(var0);
        }

    }

    static void a(List var0, boolean var1, class_219 var2) {
        a(var0, var1, var2, urlList);
    }

    static void a(List var0, boolean var1, class_219 var2, String[] var3) {
        var2.f = var3.length;
        int var4 = 0;
        String[] var5 = var3;
        int var6 = var3.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var5[var7];
            ++var4;
            class_181 var9 = new class_181(var0, var2, var8, var1, var4);
            (new Thread(var9)).start();
            if (a) {
                GameEngine.b("LoadFromMasterServer", var4 + ": Started RequestsParallelRunnable thread");
            }
        }

    }

    public static String a(List var0, String var1) {
        if (var0 != null) {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
                NameValuePair var3 = (NameValuePair)var2.next();
                if (var1.equals(var3.getName())) {
                    return var3.getValue();
                }
            }
        }

        return null;
    }

    public static BufferedReader a(List var0) {
        return a(var0, true, urlList, 10, true);
    }

    public static BufferedReader a(List var0, int var1) {
        return a(var0, true, urlList, var1, true);
    }

    @SneakyThrows
    public static BufferedReader a(List var0, boolean var1, String[] var2, int var3, boolean var4) {
        String var5 = a(var0, "action");
        ExecutorService var6 = Executors.newFixedThreadPool(var2.length);
        boolean var7 = var4;

        BufferedReader var28;
        try {
            ExecutorCompletionService var8 = new ExecutorCompletionService(var6);
            ArrayList var9 = new ArrayList();
            String[] var10 = var2;
            int var11 = var2.length;

            for(int var12 = 0; var12 < var11; ++var12) {
                String var13 = var10[var12];
                GameNetAPIOperate$1 var15 = new GameNetAPIOperate$1(var13, var0, var1, var7);
                Future var16 = var8.submit(var15);
                var9.add(var16);
            }

            int var24 = var2.length;
            class_182 var25 = null;
            class_182 var26 = null;
            class_182 var27 = null;

            for(int var14 = 0; var14 < var24; ++var14) {
                try {
                    Future var29 = var8.poll(10L, TimeUnit.SECONDS);
                    if (var29 == null) {
                        GameEngine.print("MULTI_MASTERSERVERS: poll timed out (" + var5 + ")");
                        break;
                    }

                    class_182 var30 = (class_182)var29.get();
                    if (var30 != null) {
                        var25 = var30;
                        if (var30.b) {
                            if (!var30.c) {
                                var26 = var30;
                                break;
                            }

                            var27 = var30;
                        }
                    }
                } catch (ExecutionException var21) {
                    var21.printStackTrace();
                    if (var21.getCause() != null) {
                        var21.getCause().printStackTrace();
                    }
                } catch (InterruptedException var22) {
                }
            }

            if (var26 == null && var27 != null) {
                GameEngine.print("All masterserver results included an error message (" + var5 + ")");
                var26 = var27;
            }

            if (var26 == null) {
                GameEngine.print("No valid result found on any masterserver (" + var5 + ")");
                var26 = var25;
            }

            if (var26 == null) {
                throw new IOException("No results found (" + var5 + ")");
            }

            var28 = var26.a;
        } finally {
            var6.shutdown();
        }

        return var28;
    }

    @SneakyThrows
    public static class_182 a(List var0, String var1, boolean var2) {
        String var3 = a(var0, "action");
        long var4 = Unit.loadAllUnitsTook();
        String var7 = var1 + "/interface";
        Object var6;
        if (var2) {
            HttpPost var8 = new HttpPost(var7);
            var8.setEntity(new UrlEncodedFormEntity(var0));
            var6 = var8;
        } else {
            var7 = var7 + "?" + URLEncodedUtils.format(var0, "utf-8");
            HttpGet var26 = new HttpGet(var7);
            var6 = var26;
        }

        String var27 = "rw ";
        if (GameEngine.ax()) {
            var27 = var27 + "server";
        } else {
            var27 = var27 + (GameEngine.av() ? "pc" : "android");
        }

        String var9 = class_1009.c();
        GameEngine var10 = GameEngine.getGameEngine();
        if (var10 != null) {
            var27 = var27 + " " + var10.c(true) + " " + var9;
        }

        ((HttpUriRequest)var6).setHeader("User-Agent", var27);
        ((HttpUriRequest)var6).setHeader("Language", var9);
        HttpClient var28 = d.a();

        HttpResponse var11;
        try {
            var11 = var28.execute((HttpUriRequest)var6);
        } catch (NullPointerException var24) {
            GameEngine.print("doRequest: httpclient.execute threw NullPointerException, running workaround");
            var28 = d.b();
            var11 = var28.execute((HttpUriRequest)var6);
        }

        float var12 = Unit.a(var4);
        HttpEntity var13 = var11.getEntity();
        InputStream var14 = var13.getContent();
        ByteArrayOutputStream var15 = new ByteArrayOutputStream();
        byte[] var17 = new byte[16384];

        int var16;
        while((var16 = var14.read(var17, 0, var17.length)) != -1) {
            var15.write(var17, 0, var16);
        }

        var15.flush();
        var14.close();
        var13.consumeContent();
        byte[] var18 = var15.toByteArray();
        String var19 = "CORRODINGGAMES";
        class_182 var20 = new class_182();
        String var21 = a(var18);
        var20.b = var21.startsWith(var19);
        var20.c = var21.contains("[FAILED]");
        if (!var20.b || var20.c) {
            String var22 = var7 + (var3 != null ? "?action=" + var3 : "") + " (" + var12 + "ms)";
            if (!"list".equals(var3)) {
                var22 = var22 + ":\n" + new String(var18);
            }

            GameEngine.log(var22);
        }

        ByteArrayInputStream var25 = new ByteArrayInputStream(var18);
        BufferedReader var23 = new BufferedReader(new InputStreamReader(var25));
        d.a(var28);
        var20.a = var23;
        return var20;
    }

    public static String a(byte[] var0) {
        int var1 = var0.length;

        for(int var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2] == 10 || var0[var2] == 13) {
                var1 = var2;
                break;
            }
        }

        String var3 = new String(var0, 0, var1);
        return var3;
    }

    @SneakyThrows
    public static ListRoomInfo b(String var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var0 == null) {
            throw new IOException("findOrCreateServer id cannot be null");
        } else {
            Iterator var2 = var1.netEngine.bi.iterator();

            ListRoomInfo var3;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                var3 = (ListRoomInfo)var2.next();
            } while(!var0.equals(var3.b));

            return var3;
        }
    }

    @SneakyThrows
    public static ListRoomInfo c(String var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        if (var0 == null) {
            throw new IOException("findOrCreateServer id cannot be null");
        } else {
            ListRoomInfo var2 = b(var0);
            if (var2 != null) {
                return var2;
            } else {
                ListRoomInfo var3 = new ListRoomInfo();
                var3.b = var0;
                var3.a = false;
                var3.o = var1.netEngine.p();
                return var3;
            }
        }
    }

    public static void a(Runnable var0) {
        GameEngine.b("LoadFromMasterServer", "Load requested");
        ListOperate_Join_GetRoomList var1 = new ListOperate_Join_GetRoomList(var0);
        Thread var2 = new Thread(var1);
        var2.start();
    }

    static void a(int var0, int var1) {
        GameEngine var2 = GameEngine.getGameEngine();
        boolean var3 = false;
        synchronized(f) {
            Iterator var5 = var2.netEngine.bi.iterator();

            while(true) {
                if (!var5.hasNext()) {
                    break;
                }

                ListRoomInfo var6 = (ListRoomInfo)var5.next();
                if (var6.p < var0) {
                    GameEngine.b("LoadFromMasterServer", var1 + ": Removing stale server with id:" + var6.b);
                    var5.remove();
                    var3 = true;
                }
            }
        }

        if (var3) {
            class_196.l();
        }

    }

    public static void a() {
        GameEngine.b("GetOwnInfoRunnable", "getOwnInfoFromMasterServer");
        APIEncryption.e = 6;
        class_218 var0 = new class_218();
        Thread var1 = new Thread(var0);
        var1.start();
    }

    static void listAddBasicNameValuePair(List var0, String var1, String var2) {
        var0.add(new BasicNameValuePair(var1, var2));
    }

    static void b(List var0) {
        GameEngine var1 = GameEngine.getGameEngine();
        listAddBasicNameValuePair(var0, "password_required", class_340.a(var1.netEngine.passwd != null));
        listAddBasicNameValuePair(var0, "created_by", var1.netEngine.y);
        listAddBasicNameValuePair(var0, "private_ip", var1.netEngine.ah());
        listAddBasicNameValuePair(var0, "port_number", Integer.toString(var1.netEngine.port));
        if (var1.netEngine.u != null) {
            listAddBasicNameValuePair(var0, "game_map", class_697.o(var1.netEngine.u));
        } else {
            listAddBasicNameValuePair(var0, "game_map", class_697.o(var1.netEngine.gameMapData.mapName));
        }

        MapType var2 = var1.netEngine.gameMapData.mapType;
        if (var2 == null) {
            var2 = MapType.skirmishMap;
        }

        listAddBasicNameValuePair(var0, "game_mode", var2.name());
        String var3;
        if (!var1.netEngine.v) {
            if (var1.netEngine.ingame) {
                var3 = "ingame";
            } else if (var1.netEngine.gameMapData.p) {
                var3 = "locked";
            } else {
                var3 = "battleroom";
            }

            listAddBasicNameValuePair(var0, "game_status", var3);
        } else {
            listAddBasicNameValuePair(var0, "game_status", "chat");
        }

        listAddBasicNameValuePair(var0, "player_count", Integer.toString(var1.netEngine.E()));
        var3 = Integer.toString(PlayerData.c);
        if (var1.netEngine.v) {
        }

        listAddBasicNameValuePair(var0, "max_player_count", var3);
    }

    public static void b() {
        GameEngine.b("StartCreateOnMasterServer", "Create requested");
        APIEncryption.b = 5;
        ListOperate_AddRoom var0 = new ListOperate_AddRoom();
        Thread var1 = new Thread(var0);
        var1.start();
    }

    public static void c() {
        ListOperate_UpdateRoom var0 = new ListOperate_UpdateRoom();
        Thread var1 = new Thread(var0);
        var1.start();
    }

    public static void d() {
        GameEngine.b("startRemoveOnMasterServer", "Remove requested");
        ListOperate_RemoveRoom var0 = new ListOperate_RemoveRoom();
        Thread var1 = new Thread(var0);
        var1.start();
    }

    public static void a(String var0, String var1) {
        GameEngine.b("startErrorReport", "ErrorReport requested");
        SendErrorLogToGameDev var2 = new SendErrorLogToGameDev();
        var2.b = var1;
        var2.a = var0;
        Thread var3 = new Thread(var2);
        var3.start();
    }

    public static String a(int var0) {
        if (var0 == 0) {
            return "";
        } else {
            if (var0 > 0) {
                if (var0 < 100000) {
                    return class_340.a((String)class_340.b("x" + var0), (int)10);
                }

                if (var0 < 200000) {
                    return class_340.a((String)class_340.b("y" + var0), (int)11);
                }

                if (var0 < 300000) {
                    return class_340.a((String)class_340.b("z" + var0), (int)12);
                }

                if (var0 < 1000000) {
                    return class_340.a((String)class_340.b("xx" + var0), (int)13) + "-" + GameEngine.getGameEngine().netEngine.g(var0 - 300000);
                }

                if (var0 < 2000000) {
                    return class_340.a((String)class_340.b("yy" + var0), (int)14) + "-" + GameEngine.getGameEngine().netEngine.g(var0 - 1000000);
                }
            }

            return "NA";
        }
    }

    public static void getGameServerInfoFromMasterServer(class_184 var0, String var1, int var2, String var3) {
        GameEngine.log("getGameServerInfoFromMasterServer");
        ListOperate_Join_GetRoomIP var4 = new ListOperate_Join_GetRoomIP();
        var4.a = var0;
        var4.b = var1;
        var4.c = var2;
        var4.d = var3;
        Thread var5 = new Thread(var4);
        var5.start();
    }
}
