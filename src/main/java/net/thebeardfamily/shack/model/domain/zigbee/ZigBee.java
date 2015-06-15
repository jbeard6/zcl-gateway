package net.thebeardfamily.shack.model.domain.zigbee;

/**
 * A ZigBee device.
 */
public interface ZigBee {

    SerialNumber getAddress();

    NodeIdentifier getNodeIdentifier();

    void setNodeIdentifier(NodeIdentifier nodeIdentifier);

}
