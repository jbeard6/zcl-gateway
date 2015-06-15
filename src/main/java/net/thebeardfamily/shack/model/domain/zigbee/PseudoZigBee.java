package net.thebeardfamily.shack.model.domain.zigbee;

import org.apache.commons.lang3.Validate;

/**
 * A fake {@link ZigBee} device.
 */
public class PseudoZigBee implements ZigBee {

    private final SerialNumber address;

    private NodeIdentifier nodeIdentifier;

    public PseudoZigBee(SerialNumber address) {
        Validate.notNull(address, "The address must not be null");
        this.address = address;
        this.nodeIdentifier = NodeIdentifier.getDefault();
    }

    public SerialNumber getAddress() {
        return address;
    }

    @Override public NodeIdentifier getNodeIdentifier() {
        return nodeIdentifier;
    }

    @Override public void setNodeIdentifier(NodeIdentifier nodeIdentifier) {
        Validate.notNull(nodeIdentifier, "The nodeIdentifier must not be null");
        this.nodeIdentifier = nodeIdentifier;
    }

    @Override public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        PseudoZigBee zigBee = (PseudoZigBee) o;

        return address.equals(zigBee.address);

    }

    @Override public int hashCode() {
        return address.hashCode();
    }

    @Override public String toString() {
        return "PseudoZigBee{" +
               "address=" + address +
               ", nodeIdentifier=" + nodeIdentifier +
               '}';
    }

}
