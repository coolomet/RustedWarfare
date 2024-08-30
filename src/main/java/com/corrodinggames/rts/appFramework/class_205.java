package com.corrodinggames.rts.appFramework;

// $FF: renamed from: com.corrodinggames.rts.appFramework.e
public enum class_205 {
    SINGLE_THREADED_SURFACE("singleThreadedSurface", 0),
    SINGLE_THREADED_SURFACE_IF_HARDWARE("singleThreadedSurfaceIfHardware", 1),
    MULTI_THREADED_SURFACE("multiThreadedSurface", 2),
    MULTI_THREADED_NON_SURFACE("multiThreadedNonSurface", 3),
    OPENGL("opengl", 4),
    DYNAMIC_DEFAULT("dynamicDefault", 5);
    // $FF: synthetic field
    private static final class_205[] g = new class_205[]{SINGLE_THREADED_SURFACE, SINGLE_THREADED_SURFACE_IF_HARDWARE, MULTI_THREADED_SURFACE, MULTI_THREADED_NON_SURFACE, OPENGL, DYNAMIC_DEFAULT};
    class_205(String var1, int var2) {
    }
}
