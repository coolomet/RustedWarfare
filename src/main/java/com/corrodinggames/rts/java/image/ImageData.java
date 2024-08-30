package com.corrodinggames.rts.java.image;

import java.nio.ByteBuffer;

public strictfp class ImageData implements org.newdawn.slick.opengl.ImageData {
    org.newdawn.slick.opengl.ImageData a;
    ByteBuffer b;

    public ImageData(org.newdawn.slick.opengl.ImageData var1, ByteBuffer var2) {
        this.a = var1;
        this.b = var2;
    }

    public int getDepth() {
        return this.a.getDepth();
    }

    public int getHeight() {
        return this.a.getHeight();
    }

    public ByteBuffer getImageBufferData() {
        return this.b;
    }

    public int getTexHeight() {
        return this.a.getTexHeight();
    }

    public int getTexWidth() {
        return this.a.getTexWidth();
    }

    public int getWidth() {
        return this.a.getWidth();
    }
}
