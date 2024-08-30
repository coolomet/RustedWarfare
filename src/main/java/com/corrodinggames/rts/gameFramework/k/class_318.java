package com.corrodinggames.rts.gameFramework.k;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.utility.class_684;
import java.util.Iterator;
import java.util.PriorityQueue;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.k.d
public final strictfp class class_318 extends class_316 {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static double h;
    public static double i;
    int j;
    int k;
    int l;
    int m;
    int n;
    class_322[] o = new class_322[975];
    class_684 p = new class_684(100);
    final PriorityQueue q = new PriorityQueue();
    final class_684 r = new class_684(300);
    int s;
    int t;
    public static int u;

    private strictfp void c() {
        if (this.k == this.m) {
            this.d();
        } else {
            int var1 = this.n;
            class_322[] var2 = this.o;
            int var3;
            int var5;
            if (this.j == -2) {
                for(var3 = 0; var3 <= var1; ++var3) {
                    class_322 var4 = var2[var3];
                    var5 = var4.c;
                    if (this.k == var5) {
                        this.j = var3;
                        this.k = var5;
                        return;
                    }
                }
            }

            var3 = -1;
            int var8 = Integer.MAX_VALUE;

            for(var5 = 0; var5 <= var1; ++var5) {
                class_322 var6 = var2[var5];
                int var7 = var6.c;
                if (var8 > var7) {
                    var3 = var5;
                    var8 = var7;
                }
            }

            if (this.k != var8) {
                ++g;
            }

            this.j = var3;
            this.k = var8;
        }
    }

    private strictfp void a(int var1, class_322 var2) {
        this.o[var1] = var2;
        int var3 = var2.c;
        if (this.j == -1 || this.k >= var3) {
            if (this.k > var3) {
            }

            if (this.k != var3) {
                ++g;
            }

            this.j = var1;
            this.k = var3;
        }

        if (this.l == -1 || this.m < var3) {
            this.l = var1;
            this.m = var3;
        }

    }

    private strictfp void d() {
        this.j = -1;
        this.k = Integer.MAX_VALUE;
        this.l = -1;
        this.m = Integer.MIN_VALUE;

        for(int var1 = 0; var1 <= this.n; ++var1) {
            class_322 var2 = this.o[var1];
            if (var2 == null) {
                GameEngine.log("n:" + var1);
                GameEngine.log("lowestBufferLastIndex:" + this.n);
                throw new RuntimeException("null with n:" + var1 + ", lowestBufferLastIndex:" + this.n);
            }

            int var3 = var2.c;
            if (this.k > var3) {
                this.j = var1;
                this.k = var3;
            }

            if (this.m < var3) {
                this.l = var1;
                this.m = var3;
            }
        }

    }

    private strictfp void e() {
        class_322 var1;
        if (this.n < 30) {
            var1 = (class_322)this.q.poll();
            if (var1 != null) {
                this.b(var1);
            }

            class_322 var2 = (class_322)this.q.peek();
            if (var2 != null) {
                this.s = var2.c;
            }

        } else {
            this.s = Integer.MAX_VALUE;
            var1 = (class_322)this.q.peek();
            if (var1 != null) {
                this.s = var1.c;
            }

        }
    }

    public class_318() {
        this.f();
    }

    private strictfp void b(class_322 var1) {
        ++this.n;
        this.a(this.n, var1);
        if (this.n > a) {
            a = this.n;
        }

    }

    private strictfp void c(class_322 var1) {
        this.q.offer(var1);
        if (var1.c < this.s) {
            this.s = var1.c;
        }

        if (this.q.size() > b) {
            b = this.q.size();
        }

    }

    public strictfp void a(class_322 var1) {
        ++d;
        boolean var2 = false;
        if (this.n < this.o.length - 1) {
            var2 = true;
        }

        if (var2) {
            if (var1.c <= this.s) {
                this.b(var1);
            } else {
                this.c(var1);
            }
        } else if (var1.c < this.m) {
            class_322 var3 = this.o[this.l];
            this.o[this.l] = var1;
            this.d();
            this.c(var3);
        } else {
            this.c(var1);
        }
    }

    public strictfp class_322 a() {
        if (this.j == -2) {
            int var1 = this.k;
            this.c();
            ++this.t;
            if (u < this.t) {
                u = this.t;
            }

            ++e;
            if (var1 == this.k) {
                ++f;
            }
        } else {
            this.t = 0;
        }

        if (this.k < this.s && this.j != -1) {
            class_322[] var4 = this.o;
            class_322 var2 = var4[this.j];
            if (this.n != this.j) {
                var4[this.j] = var4[this.n];
                var4[this.n] = null;
            } else {
                var4[this.n] = null;
            }

            --this.n;
            this.j = -2;
            return var2;
        } else {
            class_322 var3 = (class_322)this.q.poll();
            this.e();
            return var3;
        }
    }

    public strictfp void b() {
        this.a((class_315)null);
    }

    public strictfp void a(class_315 var1) {
        for(int var2 = 0; var2 < this.o.length; ++var2) {
            if (this.o[var2] != null) {
                if (var1 != null) {
                    var1.a(this.o[var2]);
                }

                this.o[var2] = null;
            }
        }

        this.n = -1;
        Iterator var4 = this.q.iterator();

        while(var4.hasNext()) {
            class_322 var3 = (class_322)var4.next();
            if (var1 != null) {
                var1.a(var3);
            }
        }

        this.q.clear();
        this.f();
    }

    private strictfp void f() {
        this.j = -1;
        this.k = Integer.MAX_VALUE;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.s = Integer.MAX_VALUE;
    }
}
