package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public class PointF implements Parcelable {
    public float x;
    public float y;

    public PointF() {
    }

    public PointF(float var1, float var2) {
        this.x = var1;
        this.y = var2;
    }

    public final void setSite(float var1, float var2) {
        this.x = var1;
        this.y = var2;
    }

    public final void setSite(PointF var1) {
        this.x = var1.x;
        this.y = var1.y;
    }

    public final void moveAdd(float var1, float var2) {
        this.x += var1;
        this.y += var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeFloat(this.x);
        var1.writeFloat(this.y);
    }
}
