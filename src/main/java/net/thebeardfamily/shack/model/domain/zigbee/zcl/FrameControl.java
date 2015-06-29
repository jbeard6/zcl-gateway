package net.thebeardfamily.shack.model.domain.zigbee.zcl;

import org.apache.commons.lang3.Validate;

/**
 * The control field of a {@link Frame}.
 */
public final class FrameControl {

    public static FrameControl fromHeader(byte controlValue) {
        FrameType frameType = FrameType.fromControlValue(controlValue);
        boolean manufacturerSpecific = (controlValue & 0x20) != 0x00;
        FrameDirection frameDirection = FrameDirection.fromControlValue(controlValue);
        boolean disableDefaultResponse = (controlValue & 0x04) != 0x00;
        return new FrameControl(frameType, manufacturerSpecific, frameDirection, disableDefaultResponse);
    }

    private final FrameType frameType;

    private final boolean manufacturerSpecific;

    private final FrameDirection frameDirection;

    private final boolean disableDefaultResponse;

    public FrameControl(FrameType frameType, boolean manufacturerSpecific, FrameDirection frameDirection,
            boolean disableDefaultResponse) {
        Validate.notNull(frameType, "The frameType must not be null");
        Validate.isTrue(!frameType.isReserved(), "The frameType must not be reserved");
        Validate.notNull(frameDirection, "The frameDirection must not be null");
        this.frameType = frameType;
        this.manufacturerSpecific = manufacturerSpecific;
        this.frameDirection = frameDirection;
        this.disableDefaultResponse = disableDefaultResponse;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    public boolean isManufacturerSpecific() {
        return manufacturerSpecific;
    }

    public FrameDirection getFrameDirection() {
        return frameDirection;
    }

    public boolean isDisableDefaultResponse() {
        return disableDefaultResponse;
    }
}
