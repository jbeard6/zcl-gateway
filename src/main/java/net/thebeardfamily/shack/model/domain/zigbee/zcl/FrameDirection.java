package net.thebeardfamily.shack.model.domain.zigbee.zcl;

/**
 * Specifies the client/server direction for a {@link Command}.
 * If this value is set to 1, the command is being sent from the server side of a cluster to
 * the client side of a cluster. If this value is set to 0, the command is being sent from
 * the client side of a cluster to the server side of a cluster.
 */
public enum FrameDirection {
    CLIENT_TO_SERVER((byte) 0x00),
    SERVER_TO_CLIENT((byte) 0x10);

    private final byte controlValue;

    FrameDirection(byte controlValue) {
        this.controlValue = controlValue;
    }

    public byte getControlValue() {
        return controlValue;
    }

    public static FrameDirection fromControlValue(byte controlValue) {
        return ((controlValue & 0x10) == 0x00) ?CLIENT_TO_SERVER : SERVER_TO_CLIENT;
    }
}
