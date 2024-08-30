package com.corrodinggames.rts.gameFramework;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.f.a
class class_582 implements FileFilter {
    public strictfp boolean accept(File var1) {
        return var1 != null && Pattern.matches("cpu[0-9]+", var1.getName());
    }
}
