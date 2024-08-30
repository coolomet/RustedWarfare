package com.corrodinggames.rts.gameFramework.b.a.a;

import com.corrodinggames.rts.gameFramework.b.a.class_495;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.b.a.a.a
public strictfp class class_563 extends class_562 {
    private static final class_495[] a;

    public void a() {
        super.a("uniform mat4 u_MVPMatrix;      \nattribute vec4 a_Position;     \nattribute vec2 a_TexCoordinate;\nvarying   vec2 v_TexCoordinate;\nvoid main()                    \n{                              \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix   \n               * a_Position;   \n}                              \n", "uniform sampler2D u_Texture;       \nprecision mediump float;       \nuniform lowp vec4 u_Color;          \nvarying vec2 v_TexCoordinate;  \nvoid main()                    \n{                              \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate).w * u_Color;\n}                             \n", a);
    }

    static {
        a = new class_495[]{class_495.a, class_495.b};
    }
}
