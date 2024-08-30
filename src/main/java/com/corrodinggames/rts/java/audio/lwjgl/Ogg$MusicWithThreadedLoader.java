package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.Unit;
import com.corrodinggames.rts.java.audio.a.class_36;
import com.corrodinggames.rts.java.audio.a.class_49;
import java.io.IOException;

public strictfp class Ogg$MusicWithThreadedLoader extends OpenALMusic {
    private OggInputStream input;
    private OggInputStream previousInput;
    ThreadedWrappingAudioInputStream backgroundInput;

    public Ogg$MusicWithThreadedLoader(OpenALAudio var1, class_36 var2) {
        super(var1, var2);
        if (!var1.noDevice) {
            this.input = new OggInputStream(var2.a());
            this.setup(this.input.getChannels(), this.input.getSampleRate());
            this.backgroundInput = new ThreadedWrappingAudioInputStream(this.input);
        }
    }

    public int read(byte[] var1) {
        if (this.input == null) {
            this.input = new OggInputStream(this.file.a(), this.previousInput);
            this.setup(this.input.getChannels(), this.input.getSampleRate());
            this.previousInput = null;
            this.backgroundInput = new ThreadedWrappingAudioInputStream(this.input);
        }

        long var2 = Unit.loadAllUnitsTook();
        int var4 = this.backgroundInput.read(var1);
        double var5 = (double)Unit.a(var2);
        if (var5 > 0.5) {
            GameEngine.log("ogg read took:" + Unit.a(var5));
        }

        return var4;
    }

    public void backgroundUpdate() {
        try {
            if (this.input != null && this.backgroundInput != null) {
                this.backgroundInput.backgroundFillBuffer();
            }

        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public void reset() {
        class_49.a(this.input);
        this.previousInput = null;
        this.input = null;
        this.backgroundInput.close();
    }

    protected void loop() {
        class_49.a(this.input);
        this.previousInput = this.input;
        this.input = null;
        this.backgroundInput.close();
    }
}
