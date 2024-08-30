package android.graphics;

public enum Matrix$ScaleToFit {
    FILL("FILL", 0, 0),
    START("START", 1, 1),
    CENTER("CENTER", 2, 2),
    EMD("END", 3, 3);
    final int e;
    // $FF: synthetic field
    private static final Matrix$ScaleToFit[] f = new Matrix$ScaleToFit[]{FILL, START, CENTER, EMD};

    Matrix$ScaleToFit(String var1, int var2, int var3) {
        this.e = var3;
    }
}
