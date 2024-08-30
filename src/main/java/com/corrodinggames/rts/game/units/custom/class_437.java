package com.corrodinggames.rts.game.units.custom;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.ah
enum class_437 {
    IMAGE_LOAD("imageLoad", 0),
    IMAGE_LOAD_OR_GET("imageLoadOrGet", 1),
    SOUND_LOAD("soundLoad", 2),
    SOUND_LOAD_OR_GET("soundLoadOrGet", 3),
    INI_PARSE("iniParse", 4),
    UNIT_PARSE("unitParse", 5),
    INI_OPEN("iniOpen", 6),
    INI_CLOSE("iniClose", 7),
    INI_SETUP("iniSetup", 8),
    ACTION_PARSE("actionParse", 9),
    UNIT_PARSE_PART_A("unitParsePartA", 10),
    UNIT_PARSE_PART_B("unitParsePartB", 11),
    UNIT_PARSE_PART_C("unitParsePartC", 12),
    UNIT_PARSE_PART_D("unitParsePartD", 13);
    double o;
    // $FF: synthetic field
    private static final class_437[] p = new class_437[]{IMAGE_LOAD, IMAGE_LOAD_OR_GET, SOUND_LOAD, SOUND_LOAD_OR_GET, INI_PARSE, UNIT_PARSE, INI_OPEN, INI_CLOSE, INI_SETUP, ACTION_PARSE, UNIT_PARSE_PART_A, UNIT_PARSE_PART_B, UNIT_PARSE_PART_C, UNIT_PARSE_PART_D};

    class_437(String var1, int var2) {
    }
}
