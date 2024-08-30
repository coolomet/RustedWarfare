package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.class_34;
import com.corrodinggames.rts.java.audio.a.class_36;
import com.corrodinggames.rts.java.audio.a.class_49;
import java.io.IOException;

public strictfp class Wav$Sound extends OpenALSound {
    public Wav$Sound(OpenALAudio var1, class_36 var2) {
        super(var1);
        if (!var1.noDevice) {
            Wav$WavInputStream var3 = null;

            try {
                var3 = new Wav$WavInputStream(var2);
                this.setup(class_49.a(var3, var3.dataRemaining), var3.channels, var3.sampleRate);
            } catch (Exception var8) {
                throw new class_34("Error reading WAV file: " + var2, var8);
            } finally {
                class_49.a(var3);
            }

        }
    }
}
