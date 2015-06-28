package net.thebeardfamily.shack.model.domain.zigbee.zcl;

/**
 * A reference to the unique enumeration of {@link Cluster Clusters} within a
 * specific application profile. The {@link ClusterIdentifier} is a 16-bit number unique within
 * the scope of the application profile and identifies a specific {@link Cluster}.
 * {@link ClusterIdentifier ClusterIdentifiers} are designated as inputs or outputs in the
 * simple descriptor for use in creating a binding table.
 */
public final class ClusterIdentifier {

    private final short value;

    public ClusterIdentifier(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }
}
