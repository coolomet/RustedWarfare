package com.corrodinggames.rts.java.audio;

import com.corrodinggames.rts.java.audio.a.class_36;

public interface Audio {
    AudioDevice newAudioDevice(int var1, boolean var2);

    AudioRecorder newAudioRecorder(int var1, boolean var2);

    Sound newSound(class_36 var1);

    Music newMusic(class_36 var1);
}
