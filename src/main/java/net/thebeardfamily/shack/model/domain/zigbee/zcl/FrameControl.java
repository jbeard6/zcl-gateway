package net.thebeardfamily.shack.model.domain.zigbee.zcl;

import org.apache.commons.lang3.Validate;

/**
 * The control field of a {@link Frame}.
 */
public final class FrameControl {

    private final FrameType frameType;

    private final boolean manufacturerSpecific;

    public FrameControl(FrameType frameType, boolean manufacturerSpecific) {
        Validate.notNull(frameType, "The frameType must not be null");
        this.frameType = frameType;
        this.manufacturerSpecific = manufacturerSpecific;
    }

    public FrameType getFrameType() {
        return frameType;
    }

    public boolean isManufacturerSpecific() {
        return manufacturerSpecific;
    }
}
