package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.class_34;
import com.corrodinggames.rts.java.audio.a.class_36;
import com.corrodinggames.rts.java.audio.a.class_49;
import java.io.IOException;

public strictfp class Wav$Music extends OpenALMusic {
    private Wav$WavInputStream input;

    public Wav$Music(OpenALAudio var1, class_36 var2) {
        super(var1, var2);
        this.input = new Wav$WavInputStream(var2);
        if (!var1.noDevice) {
            this.setup(this.input.channels, this.input.sampleRate);
        }
    }

    public int read(byte[] var1) {
        if (this.input == null) {
            this.input = new Wav$WavInputStream(this.file);
            this.setup(this.input.channels, this.input.sampleRate);
        }

        try {
            return this.input.read(var1);
        } catch (Exception var3) {
            throw new class_34("Error reading WAV file: " + this.file, var3);
        }
    }

    public void reset() {
        class_49.a(this.input);
        this.input = null;
    }
}
