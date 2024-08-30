package com.corrodinggames.rts.gameFramework.m;

import android.graphics.Bitmap;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.m.ad
public strictfp class MutableBitmapOrTexture extends TeamImageCache {
    TeamImageCache x;

    public MutableBitmapOrTexture(TeamImageCache var1) {
        this.x = var1;
        this.k = var1.k;
    }

    public String a() {
        return this.x.a();
    }

    public Bitmap b() {
        return this.x.b();
    }

    public TeamImageCache c() {
        return this.x.c();
    }

    public void a(boolean var1) {
    }

    public void a(Bitmap var1) {
    }

    public void g() {
        this.x.g();
    }

    public void a(TeamImageCache var1) {
        this.x.a(var1);
    }

    public TeamImageCache h() {
        return this;
    }

    public TeamImageCache getTeamImageCache(int var1, int var2, boolean var3) {
        return this;
    }

    public void i() {
    }

    public void j() {
    }

    public int a(int var1, int var2) {
        return this.x.a(var1, var2);
    }

    public void a(int var1, int var2, int var3) {
    }

    public int l() {
        return this.x.l();
    }

    public int m() {
        return this.x.m();
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public void r() {
    }

    public void t() {
    }

    public int u() {
        return this.x.u();
    }

    public void v() {
    }

    public void w() {
    }

    public String toString() {
        return "MutableBitmapOrTexture(" + this.x.toString() + ")";
    }

    public Shader B() {
        return this.x.i;
    }

    public void a(Shader var1) {
    }

    // $FF: synthetic method
    public Object clone() {
        return this.h();
    }
}
