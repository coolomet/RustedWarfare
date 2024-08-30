package com.corrodinggames.rts.java.librocket;

import com.corrodinggames.librocket.class_806;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_338;
import com.corrodinggames.rts.gameFramework.utility.class_667;
import com.corrodinggames.rts.gameFramework.utility.class_670;
import com.corrodinggames.rts.java.class_368;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.PNGImageData;

// $FF: renamed from: com.corrodinggames.rts.java.librocket.b
public strictfp class class_807 extends class_806 {
    Image h;
    boolean i;
    ImageBuffer j;
    // $FF: synthetic field
    final SlickLibRocket k;

    public class_807(SlickLibRocket var1) {
        super(var1);
        this.k = var1;
    }

    public boolean a() {
        class_667 var2 = class_670.a(this.a);
        Object var1;
        if (var2 != null) {
            var1 = var2.b(this.a, true);
            if (var1 == null) {
                GameEngine.warn("Failed to open zipped file: " + this.a);
                return false;
            }
        } else {
            try {
                var1 = new FileInputStream(this.a);
            } catch (IOException var15) {
                var15.printStackTrace();
                return false;
            }
        }

        try {
            BufferedInputStream var3 = new BufferedInputStream((InputStream)var1);

            PNGImageData var4;
            try {
                var4 = new PNGImageData();
                var4.loadImage(var3);
            } finally {
                var3.close();
            }

            this.h = new Image(var4);
        } catch (OutOfMemoryError var12) {
            GameEngine.a((class_338)class_338.UI_IMAGE, (Throwable)var12);
            this.h = class_368.r.C();
            this.i = true;
        } catch (IOException var13) {
            GameEngine.a((String)("Exception loading image: " + this.a), (Throwable)var13);
            this.h = class_368.s.C();
            this.i = true;
        } catch (UnsupportedOperationException var14) {
            var14.printStackTrace();
            GameEngine.a((String)("Exception loading image: " + this.a), (Throwable)var14);
            this.h = class_368.s.C();
            this.i = true;
        }

        this.width = this.h.getWidth();
        this.height = this.h.getHeight();
        if (this.c && (this.width > 500 || this.height > 500)) {
            GameEngine.log("Map thumbnail is too large. Size:(" + this.width + "," + this.height + ") (max:500 pixels)");
            this.h = class_368.t.C();
            this.i = true;
            this.width = this.h.getWidth();
            this.height = this.h.getHeight();
        }

        return true;
    }

    public void remove() {
        if (this.h != null && !this.i) {
            try {
                this.h.destroy();
            } catch (SlickException var2) {
                var2.printStackTrace();
            }
        }

        this.a = null;
        this.j = null;
        this.h = null;
        this.i = false;
    }
}
