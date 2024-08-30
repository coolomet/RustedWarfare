package com.corrodinggames.librocket.scripts;

import com.corrodinggames.rts.gameFramework.class_340;

public class Root$TableCell {
    public String text;
    public String classes;
    public String librocketOnClick;
    public Integer color;

    public void setLibrocketOnClick(String var1) {
        this.librocketOnClick = var1;
    }

    public Root$TableCell(String var1) {
        this.text = var1;
    }

    public void addClass(String var1) {
        if (this.classes != null) {
            this.classes = this.classes + " " + var1;
        } else {
            this.classes = var1;
        }

    }

    public boolean same(Root$TableCell var1, boolean var2) {
        if (class_340.d(this.classes, var1.classes) && class_340.d(this.librocketOnClick, var1.librocketOnClick) && class_340.a(this.color, var1.color)) {
            return var2 || class_340.d(this.text, var1.text);
        } else {
            return false;
        }
    }
}
