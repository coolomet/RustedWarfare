package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.class_36;
import com.corrodinggames.rts.java.audio.a.class_49;
import java.io.ByteArrayOutputStream;

public strictfp class Ogg$Sound extends OpenALSound {
    public Ogg$Sound(OpenALAudio var1, class_36 var2) {
        super(var1);
        if (!var1.noDevice) {
            OggInputStream var3 = null;

            try {
                var3 = new OggInputStream(var2.a());
                ByteArrayOutputStream var4 = new ByteArrayOutputStream(4096);
                byte[] var5 = new byte[2048];

                while(true) {
                    if (!var3.atEnd()) {
                        int var6 = var3.read(var5);
                        if (var6 != -1) {
                            var4.write(var5, 0, var6);
                            continue;
                        }
                    }

                    this.setup(var4.toByteArray(), var3.getChannels(), var3.getSampleRate());
                    return;
                }
            } finally {
                class_49.a(var3);
            }
        }
    }
}
