package net.thebeardfamily.shack.model.domain.zigbee.zcl;

/**
 * The type of {@link Frame}.  Contained within the {@link FrameControl} header.
 */
public final class FrameType {

    /**
     * Command acts across the entire profile.
     */
    public static final FrameType PROFILE = new FrameType((byte)0x00);


    /**
     * Command is specific to a cluster.
     */
    public static final FrameType CLUSTER = new FrameType((byte)0x40);

    private static final FrameType RESERVED_2 = new FrameType((byte)0x80);
    private static final FrameType RESERVED_3 = new FrameType((byte)0xC0);

    public static FrameType fromControlValue(byte controlValue) {
        switch (controlValue & 0xC0) {
            case 0x00: return PROFILE;
            case 0x40: return CLUSTER;
            case 0x80: return RESERVED_2;
            case 0xC0: return RESERVED_3;
        }
        assert false : "fell through switch statement";
        return null;
    }

    private final byte controlValue;

    private FrameType(byte controlValue) {
        this.controlValue = controlValue;
    }

    public byte getControlValue() {
        return controlValue;
    }

    public boolean isReserved() {
        return this == RESERVED_2 || this == RESERVED_3;
    }

    @Override public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        FrameType frameType = (FrameType) o;

        return controlValue == frameType.controlValue;

    }

    @Override public int hashCode() {
        return (int) controlValue;
    }

    @Override public String toString() {
        switch (controlValue & 0xC0) {
            case 0x00: return "PROFILE";
            case 0x40: return "CLUSTER";
            case 0x80:
            case 0xC0: return "RESERVED";
        }
        assert false : "fell through switch statement";
        return "INVALID";
    }
}
