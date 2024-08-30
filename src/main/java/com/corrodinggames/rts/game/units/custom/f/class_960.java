package com.corrodinggames.rts.game.units.custom.f;

import com.corrodinggames.rts.game.units.custom.CustomException;
import lombok.SneakyThrows;

// $FF: renamed from: com.corrodinggames.rts.game.units.custom.f.e
public strictfp class class_960 {
    @SneakyThrows
    public static void a(String var0) {
        if (var0.length() == 0) {
            throw new CustomException("name cannot be empty");
        } else if (!var0.contains(" ") && !var0.contains("}") && !var0.contains("$") && !var0.contains(".") && !var0.contains("{") && !var0.contains("-") && !var0.contains("+") && !var0.contains(":") && !var0.contains("(")) {
            if (Character.isDigit(var0.charAt(0))) {
                throw new CustomException("name cannot start with a digit");
            }
        } else {
            throw new CustomException("invalid character in name");
        }
    }
}
