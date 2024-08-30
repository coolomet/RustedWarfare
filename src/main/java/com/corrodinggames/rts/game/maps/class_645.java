package com.corrodinggames.rts.game.maps;

import java.io.ByteArrayInputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

// $FF: renamed from: com.corrodinggames.rts.game.maps.b.2
class class_645 implements EntityResolver {
    // $FF: synthetic field
    final class_484 a;

    class_645(class_484 var1) {
        this.a = var1;
    }

    public strictfp InputSource resolveEntity(String var1, String var2) {
        return new InputSource(new ByteArrayInputStream(new byte[0]));
    }
}
