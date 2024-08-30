package com.corrodinggames.rts.gameFramework;

import android.media.MediaPlayer;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.ap.2
class class_442 implements MediaPlayer.OnPreparedListener {
    // $FF: synthetic field
    final class_347 a;

    class_442(class_347 var1) {
        this.a = var1;
    }

    public void onPrepared(MediaPlayer var1) {
        var1.start();
    }
}
