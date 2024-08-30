package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_345;
import com.corrodinggames.rts.gameFramework.class_976;
import com.corrodinggames.rts.java.audio.Music;

// $FF: renamed from: com.corrodinggames.rts.java.n
public strictfp class class_348 extends class_345 {
    LoadMusic a;
    class_376 b;
    Music c;
    boolean d = false;
    boolean e = false;
    boolean f = false;

    public class_348(class_376 var1) {
        this.b = var1;
    }

    public void a(class_976 var1) {
        this.a = (LoadMusic)var1;
    }

    public void a(boolean var1) {
        synchronized(this.b.f()) {
            this.d = true;
            this.e = var1;
            this.f = false;
            GameEngine.log("Queued:" + this.a.b);
            if (this.c != null) {
                GameEngine.log("startPlaying: Stopping old music");
                this.c.stop();
            }

            this.c = this.a.c;
        }
    }

    public void f() {
        if (!this.f) {
            synchronized(this.b.f()) {
                if (this.c != null) {
                    GameEngine.log("Now playing:" + this.a.b);
                    if (this.e) {
                        this.c.setVolume(this.c.getVolume());
                        this.c.setLooping(true);
                        this.c.play();
                    } else {
                        this.c.setVolume(this.c.getVolume());
                        this.c.play();
                    }

                    this.f = true;
                } else {
                    GameEngine.log("realPlay: playingMusic==null");
                }

            }
        }
    }

    public void a() {
        synchronized(this.b.f()) {
            if (this.c != null) {
                this.c.pause();
            }

        }
    }

    public void b() {
        synchronized(this.b.f()) {
            if (this.c != null && !this.c.isPlaying()) {
                this.c.play();
            }

        }
    }

    public void d() {
        synchronized(this.b.f()) {
            if (this.c != null) {
                this.c.stop();
                this.f = false;
                this.d = false;
                this.c = null;
            }

        }
    }

    public void e() {
        synchronized(this.b.f()) {
            if (this.c != null) {
                this.c.stop();
            }

        }
    }

    public boolean c() {
        synchronized(this.b.f()) {
            return this.f && this.c != null ? this.c.isPlaying() : false;
        }
    }

    public void a(float var1) {
        synchronized(this.b.f()) {
            if (this.c != null) {
                if (var1 > 0.05F && !this.f && this.d) {
                    this.f();
                }

                this.c.setVolume(var1);
            } else {
                GameEngine.log("setVolume: playingMusic==null");
            }

        }
    }
}
