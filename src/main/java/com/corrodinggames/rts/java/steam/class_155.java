package com.corrodinggames.rts.java.steam;

import com.codedisaster.steamworks.SteamNativeHandle;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.i.class_800;

// $FF: renamed from: com.corrodinggames.rts.java.steam.j
public strictfp class class_155 implements SteamUGCCallback {
    // $FF: synthetic field
    final class_156 a;

    public class_155(class_156 var1) {
        this.a = var1;
    }

    public void onUGCQueryCompleted(SteamUGCQuery var1, int var2, int var3, boolean var4, SteamResult var5) {
        GameEngine.log("Got workshop callback: onUGCQueryCompleted (" + var5 + ") numResultsReturned:" + var2);
        if (var5 == SteamResult.OK) {
            for(int var6 = 0; var6 < var2; ++var6) {
                SteamUGCDetails var7 = new SteamUGCDetails();
                boolean var8 = this.a.d.getQueryUGCResult(var1, var6, var7);
                if (!var8) {
                    GameEngine.log("getQueryUGCResult failed for index: " + var6);
                } else {
                    SteamPublishedFileID var9 = var7.getPublishedFileID();
                    GameEngine.log("getQueryUGCResult: " + var9);
                    SteamPublicData_2 var10 = this.a.a(var9);
                    var10.d = var7.getTitle();
                    var10.c = true;
                    this.a.a = true;
                }
            }

        }
    }

    public void onSubscribeItem(SteamPublishedFileID var1, SteamResult var2) {
        this.a("onSubscribeItem", var2);
        GameEngine var3 = GameEngine.getGameEngine();
    }

    public void onUnsubscribeItem(SteamPublishedFileID var1, SteamResult var2) {
        this.a("onUnsubscribeItem", var2);
        GameEngine var3 = GameEngine.getGameEngine();
    }

    public void onRequestUGCDetails(SteamUGCDetails var1, SteamResult var2) {
        this.a("onRequestUGCDetails", var2);
    }

    public void onCreateItem(SteamPublishedFileID var1, boolean var2, SteamResult var3) {
        this.a("onCreateItem", var3);
        if (this.a.e == null) {
            this.a.a((class_800)null, "Error no mod pending creation!", false);
        } else if (this.a.e.k != 0L) {
            this.a.a(this.a.e, "This mod has already been published", true);
        } else {
            this.a.e.a(SteamNativeHandle.getNativeHandle(var1));
            this.a.a(this.a.e, true, "Created.");
            this.a.e = null;
            GameEngine var4 = GameEngine.getGameEngine();
            var4.bZ.m();
        }
    }

    public void onSubmitItemUpdate(boolean var1, SteamResult var2) {
        class_800 var3 = this.a.g;
        this.a.g = null;
        this.a("onSubmitItemUpdate", var2);
        String var4 = "";
        if (var2 == SteamResult.OK) {
            var4 = "Workshop item updated.";
        } else if (this.a.f) {
            var4 = "Error. Workshop returned: " + var2 + " while trying to upload workshop data.";
        } else {
            var4 = "Error. Workshop returned: " + var2 + " while trying to update existing workshop item.";
            if (var2 == SteamResult.FileNotFound) {
                var4 = var4 + " (If you want to create a new workshop item instead of updating, delete steam.dat from this mod.)";
            }
        }

        if (var1) {
            var4 = var4 + "WLA agreement needs to be accepted on the workshop site.";
        }

        GameEngine.getGameEngine().i(var4);
        GameEngine var5 = GameEngine.getGameEngine();
        var5.bZ.m();
    }

    public void onDownloadItemResult(int var1, SteamPublishedFileID var2, SteamResult var3) {
        this.a("onDownloadItemResult", var3);
        synchronized(this.a.h) {
            SteamPublicData_1 var5 = this.a.c(var2);
            if (var5 != null) {
                var5.a(var3);
                this.a.h.remove(var5);
            }
        }

        GameEngine var4 = GameEngine.getGameEngine();
        var4.bZ.m();
    }

    public void onUserFavoriteItemsListChanged(SteamPublishedFileID var1, boolean var2, SteamResult var3) {
        this.a("onUserFavoriteItemsListChanged", var3);
    }

    public void onSetUserItemVote(SteamPublishedFileID var1, boolean var2, SteamResult var3) {
        this.a("onSetUserItemVote", var3);
    }

    public void onGetUserItemVote(SteamPublishedFileID var1, boolean var2, boolean var3, boolean var4, SteamResult var5) {
        this.a("onGetUserItemVote", var5);
    }

    public void onStartPlaytimeTracking(SteamResult var1) {
        this.a("onStartPlaytimeTracking", var1);
    }

    public void onStopPlaytimeTracking(SteamResult var1) {
        this.a("onStopPlaytimeTracking", var1);
    }

    public void onStopPlaytimeTrackingForAllItems(SteamResult var1) {
        this.a("onStopPlaytimeTrackingForAllItems", var1);
    }

    public void a(String var1, SteamResult var2) {
        GameEngine.log("Got workshop callback: " + var1 + " (" + var2 + ")");
    }
}
