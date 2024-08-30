package com.codedisaster.steamworks;

public final class SteamController$SourceMode{
    public static final SteamController$SourceMode None = new SteamController$SourceMode("None", 0);
    public static final SteamController$SourceMode Dpad = new SteamController$SourceMode("Dpad", 1);
    public static final SteamController$SourceMode Buttons = new SteamController$SourceMode("Buttons", 2);
    public static final SteamController$SourceMode FourButtons = new SteamController$SourceMode("FourButtons", 3);
    public static final SteamController$SourceMode AbsoluteMouse = new SteamController$SourceMode("AbsoluteMouse", 4);
    public static final SteamController$SourceMode RelativeMouse = new SteamController$SourceMode("RelativeMouse", 5);
    public static final SteamController$SourceMode JoystickMove = new SteamController$SourceMode("JoystickMove", 6);
    public static final SteamController$SourceMode JoystickMouse = new SteamController$SourceMode("JoystickMouse", 7);
    public static final SteamController$SourceMode JoystickCamera = new SteamController$SourceMode("JoystickCamera", 8);
    public static final SteamController$SourceMode ScrollWheel = new SteamController$SourceMode("ScrollWheel", 9);
    public static final SteamController$SourceMode Trigger = new SteamController$SourceMode("Trigger", 10);
    public static final SteamController$SourceMode TouchMenu = new SteamController$SourceMode("TouchMenu", 11);
    public static final SteamController$SourceMode MouseJoystick = new SteamController$SourceMode("MouseJoystick", 12);
    public static final SteamController$SourceMode MouseRegion = new SteamController$SourceMode("MouseRegion", 13);
    public static final SteamController$SourceMode RadialMenu = new SteamController$SourceMode("RadialMenu", 14);
    public static final SteamController$SourceMode Switches = new SteamController$SourceMode("Switches", 15);
    private static final SteamController$SourceMode[] values = values();
    // $FF: synthetic field
    private static final SteamController$SourceMode[] $VALUES = new SteamController$SourceMode[]{None, Dpad, Buttons, FourButtons, AbsoluteMouse, RelativeMouse, JoystickMove, JoystickMouse, JoystickCamera, ScrollWheel, Trigger, TouchMenu, MouseJoystick, MouseRegion, RadialMenu, Switches};

    public static SteamController$SourceMode[] values() {
        return (SteamController$SourceMode[])$VALUES.clone();
    }

    private SteamController$SourceMode(String var1, int var2) {
    }

    static SteamController$SourceMode byOrdinal(int var0) {
        return values[var0];
    }
}
