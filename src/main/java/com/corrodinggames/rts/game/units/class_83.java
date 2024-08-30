package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.Projectile;
import com.corrodinggames.rts.game.units.land.Builder;
import com.corrodinggames.rts.gameFramework.m.TeamImageCache;

// $FF: renamed from: com.corrodinggames.rts.game.units.x
public abstract strictfp class class_83 extends OrderableUnit {
    public strictfp TeamImageCache v() {
        return null;
    }

    public strictfp TeamImageCache d() {
        return Builder.b;
    }

    public strictfp TeamImageCache k() {
        return null;
    }

    public strictfp TeamImageCache d(int var1) {
        return null;
    }

    public strictfp boolean e() {
        return false;
    }

    public class_83(boolean var1) {
        super(var1);
        this.T(20);
        this.U(20);
        this.cj = 1.0F;
        this.ck = this.cj;
        this.bT = false;
        this.totalHealth = 100.0F;
        this.health = this.totalHealth;
        this.M = Builder.b;
    }

    public strictfp void f_() {
        this.bT = false;
    }

    public strictfp void a(float var1) {
        super.a(var1);
    }

    public strictfp void a(float var1, boolean var2) {
    }

    public strictfp float e(int var1) {
        return 0.0F;
    }

    public strictfp float f(int var1) {
        return 0.0F;
    }

    public strictfp boolean c(float var1) {
        return false;
    }

    public strictfp void a(Unit var1, int var2) {
    }

    public strictfp float attackRange() {
        return 30.0F;
    }

    public strictfp float shootDelay(int var1) {
        return 100.0F;
    }

    public strictfp float speed() {
        return 0.0F;
    }

    public strictfp float turnSpeed() {
        return 4.8F;
    }

    public strictfp float B() {
        return 0.35F;
    }

    public strictfp float c(int var1) {
        return 99.0F;
    }

    public strictfp boolean l() {
        return false;
    }

    public strictfp float C() {
        return 0.04F;
    }

    public strictfp float D() {
        return 0.1F;
    }

    public strictfp boolean E() {
        return true;
    }

    public strictfp float g(int var1) {
        return 10.0F;
    }

    public strictfp boolean F() {
        return false;
    }

    public strictfp float G() {
        return 1.0F;
    }

    public strictfp float H() {
        return 1.0F;
    }

    public strictfp boolean u() {
        return true;
    }

    public strictfp boolean d(Unit var1) {
        return false;
    }

    public strictfp boolean I() {
        return false;
    }

    public strictfp boolean J() {
        return true;
    }

    public strictfp float a(Unit var1, float var2, Projectile var3) {
        var2 = 0.0F;
        return super.a(var1, var2, var3);
    }

    public strictfp boolean P() {
        return true;
    }

    public strictfp boolean Q() {
        return false;
    }

    public strictfp boolean i() {
        return true;
    }

    public strictfp MovementType h() {
        return MovementType.AIR;
    }
}
