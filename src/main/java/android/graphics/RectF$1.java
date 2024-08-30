package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

final class RectF$1 implements Parcelable.Creator {
    public RectF a(Parcel var1) {
        RectF var2 = new RectF();
        var2.a(var1);
        return var2;
    }

    public RectF[] a(int var1) {
        return new RectF[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.a(var1);
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.a(var1);
    }
}
