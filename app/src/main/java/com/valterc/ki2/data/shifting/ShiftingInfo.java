package com.valterc.ki2.data.shifting;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public final class ShiftingInfo implements Parcelable {

    private final boolean buzzerOn;
    private final int frontGear;
    private final int frontGearMax;
    private final int rearGear;
    private final int rearGearMax;
    private final ShiftingMode shiftingMode;

    public static final Parcelable.Creator<ShiftingInfo> CREATOR = new Parcelable.Creator<ShiftingInfo>() {
        public ShiftingInfo createFromParcel(Parcel in) {
            return new ShiftingInfo(in);
        }

        public ShiftingInfo[] newArray(int size) {
            return new ShiftingInfo[size];
        }
    };

    private ShiftingInfo(Parcel in) {
        buzzerOn = in.readByte() == 1;
        frontGear = in.readInt();
        frontGearMax = in.readInt();
        rearGear = in.readInt();
        rearGearMax = in.readInt();
        shiftingMode = ShiftingMode.fromValue(in.readInt());
    }

    public ShiftingInfo(boolean buzzerOn, int frontGear, int frontGearMax, int rearGear, int rearGearMax, ShiftingMode shiftingMode)
    {
        this.buzzerOn = buzzerOn;
        this.frontGear = frontGear;
        this.frontGearMax = frontGearMax;
        this.rearGear = rearGear;
        this.rearGearMax = rearGearMax;
        this.shiftingMode = shiftingMode;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeByte(buzzerOn ? (byte) 1 : (byte) 0);
        out.writeInt(frontGear);
        out.writeInt(frontGearMax);
        out.writeInt(rearGear);
        out.writeInt(rearGearMax);
        out.writeInt(shiftingMode.getValue());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isBuzzerOn() {
        return buzzerOn;
    }

    public int getFrontGear() {
        return frontGear;
    }

    public int getFrontGearMax() {
        return frontGearMax;
    }

    public int getRearGear() {
        return rearGear;
    }

    public int getRearGearMax() {
        return rearGearMax;
    }

    public ShiftingMode getShiftingMode() {
        return shiftingMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftingInfo that = (ShiftingInfo) o;
        return buzzerOn == that.buzzerOn && frontGear == that.frontGear && frontGearMax == that.frontGearMax && rearGear == that.rearGear && rearGearMax == that.rearGearMax && shiftingMode == that.shiftingMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buzzerOn, frontGear, frontGearMax, rearGear, rearGearMax, shiftingMode);
    }
}
