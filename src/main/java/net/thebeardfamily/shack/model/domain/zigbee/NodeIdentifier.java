package net.thebeardfamily.shack.model.domain.zigbee;

import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;

/**
 * A string identifier for a {@IZigBee} node.
 */
public final class NodeIdentifier {

    public static final int MAXIMUM_LENGTH = 20;

    private static final NodeIdentifier DEFAULT = new NodeIdentifier(" ");

    /**
     * Get the default node identifier.
     *
     * @return the default node identifier
     */
    public static NodeIdentifier getDefault() {
        return DEFAULT;
    }

    private final String value;

    public NodeIdentifier(String value) {
        Validate.notNull(value, "The value must not be null");
        Validate.isTrue(value.length() < MAXIMUM_LENGTH, "The value may not exceed %d characters", MAXIMUM_LENGTH);
        Validate.isTrue(isAsciiPrintable(value), "The value must be printable ASCII characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        NodeIdentifier that = (NodeIdentifier) o;

        return value.equals(that.value);

    }

    @Override public int hashCode() {
        return value.hashCode();
    }

    @Override public String toString() {
        return value;
    }
}
