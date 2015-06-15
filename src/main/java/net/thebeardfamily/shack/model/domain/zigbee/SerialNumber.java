package net.thebeardfamily.shack.model.domain.zigbee;

/**
 * Serial number of a {@link ZigBee} device.
 */
public final class SerialNumber {

    private final long value;

    public SerialNumber(long value) {
        this.value = value;
    }

    public SerialNumber(int high, int low) {
        this.value = (high << 32) + low;
    }

    public int getUpper() {
        return (int)(value >> 32);
    }

    public int getLower() {
        return (int) value;
    }

    @Override public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        SerialNumber that = (SerialNumber) o;

        return value == that.value;
    }

    @Override public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override public String toString() {
        return String.format("0x%X 0x%X", getUpper(), getLower());
    }
}
