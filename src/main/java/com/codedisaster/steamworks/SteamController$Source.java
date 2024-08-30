package com.codedisaster.steamworks;

public final class SteamController$Source {
    public static final SteamController$Source None = new SteamController$Source("None", 0);
    public static final SteamController$Source LeftTrackpad = new SteamController$Source("LeftTrackpad", 1);
    public static final SteamController$Source RightTrackpad = new SteamController$Source("RightTrackpad", 2);
    public static final SteamController$Source Joystick = new SteamController$Source("Joystick", 3);
    public static final SteamController$Source ABXY = new SteamController$Source("ABXY", 4);
    public static final SteamController$Source Switch = new SteamController$Source("Switch", 5);
    public static final SteamController$Source LeftTrigger = new SteamController$Source("LeftTrigger", 6);
    public static final SteamController$Source RightTrigger = new SteamController$Source("RightTrigger", 7);
    public static final SteamController$Source Gyro = new SteamController$Source("Gyro", 8);
    public static final SteamController$Source CenterTrackpad = new SteamController$Source("CenterTrackpad", 9);
    public static final SteamController$Source RightJoystick = new SteamController$Source("RightJoystick", 10);
    public static final SteamController$Source DPad = new SteamController$Source("DPad", 11);
    // $FF: synthetic field
    private static final SteamController$Source[] $VALUES = new SteamController$Source[]{None, LeftTrackpad, RightTrackpad, Joystick, ABXY, Switch, LeftTrigger, RightTrigger, Gyro, CenterTrackpad, RightJoystick, DPad};

    public static SteamController$Source[] values() {
        return (SteamController$Source[])$VALUES.clone();
    }


    private SteamController$Source(String var1, int var2) {
    }
}
